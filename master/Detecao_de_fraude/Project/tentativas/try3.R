library(tidyverse)
library(cluster)
library(dbscan)
library(factoextra)
library(readr)
library(ggplot2)
library(dplyr)
library(tidyr)
library(magrittr)
library(imputeTS)
library(rpart)
library(class)
library(neuralnet)
library(e1071)
library(ipred)
library(randomForest)
library(gbm)
library(xgboost)

###data summarization #################
rm(list = ls())
setwd("/Users/lau/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Project")
dados <- read.csv("train.csv", header = TRUE, sep = ",")
###data understanding -> data preparation
# Definir -1 como NA nas coluna prev_address_months_count, current_address_months_count e bank_months_count
# Definir a variavel source como numerica, substituinto INTERNET por 0 e TELEAPP por 1, para facilitar a análise e sumarizaçao de dados.
dados <- dados %>% mutate(prev_address_months_count = na_if(prev_address_months_count, -1), 
                          current_address_months_count = na_if(current_address_months_count, -1),
                          bank_months_count = na_if(bank_months_count, -1))
#ver quais os valores possiveis de cada varivel categorica para a poder transformar em numerica das colunas: payment_type, employment_status, 
#housing_status e device_os
valores_unicos <- unique(dados$payment_type)
valores_unicos
valores_unicos <- unique(dados$employment_status)
valores_unicos
valores_unicos <- unique(dados$housing_status)
valores_unicos
valores_unicos <- unique(dados$device_os)
valores_unicos
valores_unicos <- unique(dados$source)
valores_unicos
#trocar para variaveis numericas para fazer ver estatisticas
#categórica em fator e depois em numerica
dados_sum <- dados
dados_sum$payment_type <- factor(dados_sum$payment_type, levels = c("AB", "AC", "AD", "AA", "AE"))
dados_sum$payment_type <- as.numeric(dados_sum$payment_type)
dados_sum$employment_status <- factor(dados_sum$employment_status, levels = c("CA", "CD", "CB", "CC", "CE", "CF", "CG"))
dados_sum$employment_status <- as.numeric(dados_sum$employment_status)
dados_sum$housing_status <- factor(dados_sum$housing_status, levels = c("BC", "BE", "BB", "BA", "BD", "BF"))
dados_sum$housing_status <- as.numeric(dados_sum$housing_status)
dados_sum$device_os <- factor(dados_sum$device_os, levels = c("linux", "other", "windows", "macintosh", "x11"))
dados_sum$device_os <- as.numeric(dados_sum$device_os)
dados_sum$source <- factor(dados_sum$source, levels = c("INTERNET", "TELEAPP"))
dados_sum$source <- as.numeric(dados_sum$source)

dados_sum <- dados_sum[, -31]
dados <- dados[, -31]
dados_sem_na <- na.omit(dados_sum) 

# Ou preencher valores ausentes com a média dos valores não ausentes ou moda!!!
##funcao para calcular a moda
Mode <- function(x) {
  ux <- unique(x)
  ux[which.max(tabulate(match(x, ux)))]
}


dados_preenchidos <- dados_sum
median_1 <- median(dados_preenchidos$prev_address_months_count, na.rm = TRUE)
dados_preenchidos$prev_address_months_count[is.na(dados_preenchidos$prev_address_months_count)] <- median_1

median_2 <- median(dados_preenchidos$current_address_months_count, na.rm = TRUE)
dados_preenchidos$current_address_months_count[is.na(dados_preenchidos$current_address_months_count)] <- median_2

median_3 <- median(dados_preenchidos$employment_status, na.rm = TRUE)
dados_preenchidos$employment_status[is.na(dados_preenchidos$employment_status)] <- median_3

median_4 <- median(dados_preenchidos$bank_months_count, na.rm = TRUE)
dados_preenchidos$bank_months_count[is.na(dados_preenchidos$bank_months_count)] <- median_4

mode_5 <- Mode(dados_preenchidos$has_other_cards[!is.na(dados_preenchidos$has_other_cards)])
dados_preenchidos$has_other_cards[is.na(dados_preenchidos$has_other_cards)] <- mode_5

mode_6 <- Mode(dados_preenchidos$source[!is.na(dados_preenchidos$source)])
dados_preenchidos$source[is.na(dados_preenchidos$source)] <- mode_6










num_componentes_lista <- c(4) 
percentagem_total_lista <- c(0.1, 0.2, 0.3, 0.5, 0.7)
matriz <- array(0, dim = c(6, 8, 5))
#features,modelo,percentagem

for (num_componentes in num_componentes_lista){
  dados_normalizados <- scale(dados_sem_na)
  dados_normalizados_p <- scale(dados_preenchidos)
  pca <- prcomp(dados_normalizados)
  reducao_pca <- predict(pca, newdata = dados_normalizados)[, 1:num_componentes]
  svd_resultado <- svd(dados_normalizados)
  reducao_svd <- dados_normalizados %*% svd_resultado$v[, 1:num_componentes]
  pca <- prcomp(dados_normalizados_p)
  reducao_pca_p <- predict(pca, newdata = dados_normalizados_p)[, 1:num_componentes]
  svd_resultado <- svd(dados_normalizados_p)
  reducao_svd_p <- dados_normalizados_p %*% svd_resultado$v[, 1:num_componentes]
  
  dados_sem_na$is_fraud <- as.factor(dados_sem_na$is_fraud)
  dados_preenchidos$is_fraud <- as.factor(dados_preenchidos$is_fraud)
  reducao_pca <- cbind(reducao_pca, is_fraud = dados_sem_na$is_fraud)
  reducao_svd <- cbind(reducao_svd, is_fraud = dados_sem_na$is_fraud)
  reducao_pca_p <- cbind(reducao_pca_p, is_fraud = dados_preenchidos$is_fraud)
  reducao_svd_p <- cbind(reducao_svd_p, is_fraud = dados_preenchidos$is_fraud)
  dados_sem_na$is_fraud <- as.numeric(dados_sem_na$is_fraud)
  dados_preenchidos$is_fraud <- as.numeric(dados_preenchidos$is_fraud)
  
  dados_featured_lista <- list(dados_sem_na, dados_preenchidos, 
                               reducao_pca, reducao_pca_p,
                               reducao_svd, reducao_svd_p)
  dados_featured_nome_lista <- c("dados com valores NA removidos", 
                                 "dados com valores NA preenchidos", 
                                 "dados com redução PCA e valores NA removidos", 
                                 "dados com redução PCA e valores NA preenchidos",
                                 "dados com redução SVD e valores NA removidos", 
                                 "dados com redução SVD e valores NA preenchidos")
  
  
  
  print(paste("Numero de componentes:", num_componentes))
  for (f in 1:6){
    dados_featured <- dados_featured_lista[[f]]
    dados_featured_nome <- dados_featured_nome_lista[f]
    print(paste("Tipos de featuring usada: ",dados_featured_nome))
    for (p in 1:5){
      percentagem_total <- percentagem_total_lista[p]
      #tamanho_total <- floor(percentagem_total * nrow(dados_featured))
      #indices_amostra <- sample(1:nrow(dados_featured), size = tamanho_total)
      #dados_amostra <- dados_featured[indices_amostra, ]
      dados_amostra <- dados_featured
      # Divisão em conjunto de treino e teste
      percentagem_treino <- percentagem_total
      set.seed(123)
      tamanho_treino <- floor(percentagem_treino * nrow(dados_amostra))
      tamanho_teste <- nrow(dados_amostra) - tamanho_treino
      indices <- sample(1:nrow(dados_amostra))
      dados_treino <- dados_amostra[indices[1:tamanho_treino], ]
      dados_teste <- dados_amostra[indices[(tamanho_treino + 1):nrow(dados_amostra)], ]
      dados_treino <- as.data.frame(dados_treino)
      dados_teste <- as.data.frame(dados_teste)
      
      percentagem_erro_AD <- -1
      percentagem_erro_KNN <- -1
      percentagem_erro_NB <- -1
      percentagem_erro_NN <- -1
      percentagem_erro_SVM <- -1
      percentagem_erro_RF <- -1
      
      #Árvores de Decisão
      tryCatch({
        modelo <- rpart(is_fraud ~ ., data = dados_treino, method = "class")
        previsao <- predict(modelo, newdata = dados_teste, type = "class")
        resultado <- cbind(dados_teste, previsao)
        percentagem_erro_AD <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
        rm(previsao)
        rm(resultado)
      }, error = function(err) {
        print("Ocorreu um erro na Árvore de Decisão")
        percentagem_erro_AD <- -1  
      })
      
      #KNN
      tryCatch({
        k <- 5
        modelo_knn <- knn(train = dados_treino[, -ncol(dados_treino)], test = dados_teste[, -ncol(dados_teste)], cl = dados_treino$is_fraud, k = k)
        previsao <- as.factor(modelo_knn)
        resultado <- cbind(dados_teste, previsao)
        percentagem_erro_KNN <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
        rm(previsao)
        rm(resultado)
      }, error = function(err) {
        print("Ocorreu um erro no Naive Bayes")
        percentagem_erro_KNN <- -1  
      })
      
      
      
      #Naive Bayes
      tryCatch({
        modelo_nb <- naiveBayes(is_fraud ~ ., data = dados_treino)
        previsao <- predict(modelo_nb,  list(var = dados_teste[, -1]))
        resultado <- cbind(var, previsao)
        percentagem_erro_NB <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
        rm(previsao)
        rm(resultado)
      }, error = function(err) {
        print("Ocorreu um erro no Naive Bayes")
        percentagem_erro_NB <- -1  
      })
      
      #Rede Neural
      tryCatch({
        modelo_nn <- neuralnet(is_fraud ~ ., data = dados_treino, hidden = c(4, 2))
        previsao <- compute(modelo_nn, dados_teste[, -ncol(dados_teste)])$net.result
        previsao <- ifelse(previsao >= 0.5, 1, 0) 
        resultado <- cbind(dados_teste, previsao)
        percentagem_erro_NN <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
        rm(modelo_nn)
        rm(previsao)
        rm(resultado)
      }, error = function(err) {
        print("Ocorreu um erro no Naive Bayes")
        percentagem_erro_NN <- -1  
      })
      
      
      #SVM 
      tryCatch({
        modelo_svm <- svm(is_fraud ~ ., data = dados_treino, type = "C")
        previsao <- predict(modelo_svm, newdata = dados_teste)
        resultado <- cbind(dados_teste, previsao)
        percentagem_erro_SVM <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
        rm(previsao)
        rm(resultado)
      }, error = function(err) {
        print("Ocorreu um erro no SVM")
        percentagem_erro_SVM <- -1 
      })
      
      #Random Forest
      tryCatch({
        modelo_rf <- randomForest(is_fraud ~ ., data = dados_treino, ntree = 100)
        previsao <- predict(modelo_rf, newdata = dados_teste, type = "response")
        resultado <- cbind(dados_teste, previsao)
        percentagem_erro_RF <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
        rm(previsao)
        rm(resultado)
      }, error = function(err) {
        print("Ocorreu um erro no Naive Bayes")
        percentagem_erro_RF <- -1  
      })
      
      
      #GBM
      tryCatch({
        dados_treino$is_fraud <- as.numeric(as.factor(dados_treino$is_fraud))-1
        dados_teste$is_fraud <- as.numeric(as.factor(dados_teste$is_fraud))-1
        modelo_boosting <- gbm(is_fraud ~ ., data = dados_treino, distribution = "bernoulli", n.trees = 100)
        previsao <- predict(modelo_boosting, newdata = dados_teste, n.trees = 50, type = "response")
        previsao_classes <- ifelse(previsao > 0.5, 1, 0)
        resultado <- cbind(dados_teste, previsao = previsao_classes)
        percentagem_erro_GBM <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
        rm(previsao)
        rm(resultado)
        rm(previsao_classes)
      }, error = function(err) {
        print("Ocorreu um erro no Naive Bayes")
        percentagem_erro_GBM <- -1  
      })
      
      
      #XGBoost
      tryCatch({
        dtrain <- xgb.DMatrix(data = as.matrix(dados_treino[, -ncol(dados_treino)]), label = dados_treino$is_fraud)
        dtest <- xgb.DMatrix(data = as.matrix(dados_teste[, -ncol(dados_teste)]), label = dados_teste$is_fraud)
        param <- list( objective = "binary:logistic", eval_metric = "error")
        modelo_xgb <- xgboost(data = dtrain, params = param, nrounds = 100,verbose = FALSE)
        previsao <- predict(modelo_xgb, dtest)
        previsao_classes <- ifelse(previsao > 0.5, 1, 0)
        resultado <- cbind(dados_teste, previsao = previsao_classes)
        percentagem_erro_XGB <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
        dados_treino$is_fraud <- as.factor(as.numeric(dados_treino$is_fraud) + 1)
        rm(previsao)
        rm(resultado)
        rm(previsao_classes)
      }, error = function(err) {
        print("Ocorreu um erro no Naive Bayes")
        percentagem_erro_XGB <- -1  
      })
      
      
      ##
      print(paste("Percentagem da amostra:", percentagem_total*100, "%"))
      
      percentagens_de_erro_lista <- list(percentagem_erro_AD, percentagem_erro_KNN,
                                         percentagem_erro_NB, percentagem_erro_NN,
                                         percentagem_erro_SVM, percentagem_erro_RF,
                                         percentagem_erro_GBM, percentagem_erro_XGB)
      percentagem_erro_nome_lista <- c("AD", "KNN", "NB", "NN", "SVM", "RF", "GBM", "XGB")
      
      for (m in 1:8){
        percentagens_de_erro <- percentagens_de_erro_lista[[m]]
        percentagem_erro_nome <-percentagem_erro_nome_lista[m]
        print(paste("Percentagem de erro de", percentagem_erro_nome, ": ",percentagens_de_erro))
        matriz[f, m, p] <- percentagens_de_erro
      }
    }
  }
}



cores <- rainbow(ncol(matriz))
cores<-cores[-6]
for (i in 1:nrow(matriz)) {
  dados <- t(matriz[i, , ])
  matplot(percentagem_total_lista[-6], dados[,-6], type = "l", col = cores, xlab = "Percentagem dos dados para treino",
          ylab = "Percentagem de erros", main = paste("Feature", dados_featured_nome_lista[i]))
  legend("topright", legend = percentagem_erro_nome_lista[-6], col = cores, lty = 1)
}


