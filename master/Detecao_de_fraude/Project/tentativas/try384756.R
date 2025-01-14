
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
library(kknn)
library(tidymodels)
library(discrim)
library(klaR)
library(rpart.plot)




rm(list = ls())
setwd("/Users/lau/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Project")
dados <- read.csv("train.csv", header = TRUE, sep = ",")




dados <- dados %>% mutate(prev_address_months_count = na_if(prev_address_months_count, -1), 
                          current_address_months_count = na_if(current_address_months_count, -1),
                          bank_months_count = na_if(bank_months_count, -1))


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



dados_sum <- dados_sum[, -which(names(dados) == "device_fraud_count")]
dados_sum <- dados_sum[, -which(names(dados_sum) == "id")]

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















percentagem_total_lista <- c(0.7, 0.5, 0.4 ,0.3, 0.2, 0.1)
matriz <- array(0, dim = c(6, 8, 6))
num_componentes<-5

dados_normalizados <- scale(dados_sem_na[, -which(names(dados) == "is_fraud")])
dados_normalizados_p <- scale(dados_preenchidos[, -which(names(dados) == "is_fraud")])
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
reducao_pca <- as.data.frame(reducao_pca)
reducao_pca_p <- as.data.frame(reducao_pca_p)
reducao_svd <- as.data.frame(reducao_svd)
reducao_svd_p <- as.data.frame(reducao_svd_p)

dados_featured_lista <- list(dados_sem_na, dados_preenchidos, 
                             reducao_pca, reducao_pca_p,
                             reducao_svd, reducao_svd_p)
dados_featured_nome_lista <- c("dados com valores NA removidos", 
                               "dados com valores NA preenchidos", 
                               "dados com redução PCA e valores NA removidos", 
                               "dados com redução PCA e valores NA preenchidos",
                               "dados com redução SVD e valores NA removidos", 
                               "dados com redução SVD e valores NA preenchidos")

for (f in 1:6){
dados_featured <- dados_featured_lista[[f]]
dados_featured_nome <- dados_featured_nome_lista[f]

print(paste("Tipos de featuring usada: ",dados_featured_nome))

for (p in 1:6){
percentagem_total <-percentagem_total_lista[p]
set.seed(1234)
split_dados <- dados_featured %>% initial_split(prop=percentagem_total)
dados_treino <- training(split_dados)
dados_teste <- testing(split_dados)

percentagem_erro_AD <- -1
percentagem_erro_KNN <- -1
percentagem_erro_NB <- -1
percentagem_erro_NN <- -1
percentagem_erro_SVM <- -1
percentagem_erro_RF <- -1



dados_treino$is_fraud <- as.factor(dados_treino$is_fraud)
dados_teste$is_fraud <- as.factor(dados_teste$is_fraud)
rec <- recipe(is_fraud ~.,dados_treino)
rec <- rec %>% step_normalize(all_numeric_predictors()) %>% prep()
dados_treino <- rec %>% bake(new_data=dados_treino)
dados_teste <- rec %>% bake(new_data=dados_teste)








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
    
    model_knn <- nearest_neighbor(mode="classification",neighbors=11)
    knn_fit <- model_knn %>% fit(is_fraud ~ ., data = dados_treino)
    resultado <- dados_teste %>% dplyr::select(is_fraud) %>% 
      bind_cols(predict(knn_fit,dados_teste)) %>% 
      bind_cols(predict(knn_fit,dados_teste,type="prob"))
    percentagem_erro_KNN <- sum(resultado$is_fraud != resultado$.pred_class) / nrow(resultado) * 100
    rm(resultado)
  }, error = function(err) {
    print("Ocorreu um erro no KNN")
    percentagem_erro_KNN <- -1  
  })


#Naive Bayes
  
  tryCatch({
    model_nb <- naive_Bayes(mode="classification")
    nb_fit <- model_nb %>% fit(is_fraud ~ ., data = dados_treino)
    resultado <- dados_teste %>% dplyr::select(is_fraud) %>% 
      bind_cols(predict(nb_fit, dados_teste)) %>% 
      bind_cols(predict(nb_fit, dados_teste, type = "prob"))
    percentagem_erro_NB <- sum(resultado$is_fraud != resultado$.pred_class) / nrow(resultado) * 100
    rm(resultado)
  }, warning = function(w) NULL,
  error = function(err) {
    print("Ocorreu um erro no Naive Bayes")
    percentagem_erro_NB <- -1
  })
  

#Rede Neural
tryCatch({
  modelo_nn <- neuralnet(is_fraud ~ ., data = dados_treino, hidden = c(3, 2))
  previsao <- compute(modelo_nn, dados_teste[, -ncol(dados_teste)])$net.result
  previsao <- ifelse(previsao >= 0.5, 1, 0) 
  resultado <- cbind(dados_teste, previsao)
  percentagem_erro_NN <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
  rm(modelo_nn)
  rm(previsao)
  rm(resultado)
}, error = function(err) {
  print("Ocorreu um erro no NN")
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
  print("Ocorreu um erro no RF")
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
  print("Ocorreu um erro no GBM")
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
  print("Ocorreu um erro no XGB")
  percentagem_erro_XGB <- -1  
})

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
    
    
    
cores <- rainbow(ncol(matriz))
for (i in 1:nrow(matriz)) {
  dados <- t(matriz[i, , ])
  matplot(percentagem_total_lista, dados, type = "l", col = cores, xlab = "Percentagem dos dados para treino",
          ylab = "Percentagem de erros", main = paste("Feature", dados_featured_nome_lista[i]))
  legend("topright", legend = percentagem_erro_nome_lista, col = cores, lty = 1)
}
    
    
    