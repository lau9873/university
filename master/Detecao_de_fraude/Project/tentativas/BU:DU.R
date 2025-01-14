#install.packages()...
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



##### descriptive statistics
summary(dados_sum)
glimpse(dados_sum)

#device_fraud_count nao da informação nenhuma entao vou excluir esta coluna, que é a coluna 31
dados_sum <- dados_sum[, -31]
dados <- dados[, -31]

#separar os dados fraudulentos dos nao fraudulentos
fraud_data <- subset(dados, is_fraud == 1)
non_fraud_data <- subset(dados, is_fraud == 0)


#####data visualization

ggplot(dados, aes(x = income, fill = factor(is_fraud))) +
  geom_bar(stat = "count") +
  labs(title = "Histogram - Income",
       x = "Income",
       y = "Count",
       fill = "Fraudulento") +
  scale_fill_manual(values = c("blue", "red"), labels = c("Não Fraudulento", "Fraudulento"))

##!!!!!!!
ggplot(dados, aes(x = name_email_similarity, fill = factor(is_fraud))) +
  geom_density(alpha = 0.5) +
  labs(title = "Distribuição - name_email_similarity",
       x = "name_email_similarity",
       y = "Count",
       fill = "Fraudulento") +
  scale_fill_manual(values = c("blue", "red"), labels = c("Não Fraudulento", "Fraudulento"))



ggplot(dados, aes(x = factor(is_fraud), y = prev_address_months_count)) +
  geom_boxplot(fill = "lightgray", outlier.shape = NA) +
  geom_jitter(aes(color = factor(is_fraud)), width = 0.2, height = 0.1, alpha = 0.7) +
  ggtitle("Prev Address Months Count") +
  xlab("Fraudulent") +
  ylab("Months") +
  scale_color_manual(values = c("blue", "red"), labels = c("Não Fraudulento", "Fraudulento")) +
  theme_minimal()

ggplot(dados, aes(x = factor(is_fraud), y = current_address_months_count)) +
  geom_boxplot(fill = "lightgray", outlier.shape = NA) +
  geom_jitter(aes(color = factor(is_fraud)), width = 0.2, height = 0.1, alpha = 0.7) +
  ggtitle("Current Address Months Count") +
  xlab("Fraudulent") +
  ylab("Months") +
  scale_color_manual(values = c("blue", "red"), labels = c("Não Fraudulento", "Fraudulento")) +
  theme_minimal()

ggplot(dados, aes(x = factor(is_fraud), y = customer_age, fill = factor(is_fraud))) +
  geom_boxplot() +
  ggtitle("Idade do Cliente") +
  xlab("Fraude") +
  ylab("Idade") +
  scale_fill_manual(values = c("blue", "red"), labels = c("Não Fraudulento", "Fraudulento"))

ggplot(dados, aes(x = factor(is_fraud), y = days_since_request, fill = factor(is_fraud))) +
  geom_boxplot() +
  ggtitle("Distribuição de dias desde a solicitação") +
  xlab("Fraudulento") +
  ylab("Dias desde a solicitação") +
  scale_fill_manual(values = c("blue", "red"), labels = c("Não Fraudulento", "Fraudulento"))

ggplot(dados, aes(x = factor(is_fraud), y = intended_balcon_amount, fill = factor(is_fraud))) +
  geom_boxplot() +
  ggtitle("Intended Balcon Amount by Fraudulent Status") +
  xlab("Fraudulent") +
  ylab("Intended Balcon Amount") +
  scale_fill_manual(values = c("blue", "red"), labels = c("Não Fraudulento", "Fraudulento"))




# Histograma para payment_type
ggplot(dados, aes(x = payment_type, fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Payment Type", y = "Count", fill = "Fraudulent") +
  scale_fill_manual(values = c("blue", "red"), labels = c("Não Fraudulento", "Fraudulento")) +
  theme_minimal()

ggplot(dados, aes(x = zip_count_4w, fill = factor(is_fraud))) +
  geom_density(alpha = 0.5) +
  labs(x = "Zip Count in 4 Weeks", y = "Density", fill = "Fraudulent") +
  theme_minimal()


ggplot(dados, aes(x = velocity_6h, fill = factor(is_fraud))) +
  geom_density(alpha = 0.5) +
  labs(x = "Velocity in 6 Hours", y = "Density", fill = "Fraudulent") +
  theme_minimal()

ggplot(dados, aes(x = velocity_24h, fill = factor(is_fraud))) +
  geom_density(alpha = 0.5) +
  labs(x = "Velocity in 24 Hours", y = "Density", fill = "Fraudulent") +
  theme_minimal()


ggplot(dados, aes(x = velocity_4w, fill = factor(is_fraud))) +
  geom_density(alpha = 0.5) +
  labs(x = "Velocity in 4 Weeks", y = "Density", fill = "Fraudulent") +
  theme_minimal()

ggplot(dados, aes(x = bank_branch_count_8w, fill = factor(is_fraud))) +
  geom_histogram(binwidth = 100) +
  labs(x = "Bank Branch Count in 8 Weeks", y = "Count", fill = "Fraudulent") +
  theme_minimal()

# Gráfico de densidade para date_of_birth_distinct_emails_4w
ggplot(dados, aes(x = date_of_birth_distinct_emails_4w, fill = factor(is_fraud))) +
  geom_density(alpha = 0.5) +
  labs(x = "Distinct Emails in 4 Weeks", y = "Density", fill = "Fraudulent") +
  theme_minimal()
# Histograma para employment_status pq era categorica
ggplot(dados, aes(x = employment_status, fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Employment Status", y = "Count", fill = "Fraudulent") +
  theme_minimal()
# Gráfico de densidade para credit_risk_score
ggplot(dados, aes(x = credit_risk_score, fill = factor(is_fraud))) +
  geom_density(alpha = 0.5) +
  labs(x = "Credit Risk Score", y = "Density", fill = "Fraudulent") +
  theme_minimal()

# Gráfico de barras para email_is_free
ggplot(dados, aes(x = factor(email_is_free), fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Email is Free", y = "Count", fill = "Fraudulent") +
  scale_x_discrete(labels = c("Paid", "Free")) +
  theme_minimal()

# Histograma para housing_status
ggplot(dados, aes(x = housing_status, fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Housing Status", y = "Count", fill = "Fraudulent") +
  theme_minimal()

# Gráfico de barras para phone_home_valid
ggplot(dados, aes(x = factor(phone_home_valid), fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Home Phone Valid", y = "Count", fill = "Fraudulent") +
  scale_x_discrete(labels = c("Invalid", "Valid")) +
  theme_minimal()

# Gráfico de barras para phone_mobile_valid
ggplot(dados, aes(x = factor(phone_mobile_valid), fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Mobile Phone Valid", y = "Count", fill = "Fraudulent") +
  scale_x_discrete(labels = c("Invalid", "Valid")) +
  theme_minimal()

# Histograma para bank_months_count
ggplot(dados, aes(x = bank_months_count, fill = factor(is_fraud))) +
  geom_histogram(binwidth = 1) +
  labs(x = "Bank Months Count", y = "Count", fill = "Fraudulent") +
  theme_minimal()

# Gráfico de barras para has_other_cards
ggplot(dados, aes(x = factor(has_other_cards), fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Has Other Cards", y = "Count", fill = "Fraudulent") +
  scale_x_discrete(labels = c("No", "Yes")) +
  theme_minimal()

# Histograma para proposed_credit_limit
ggplot(dados, aes(x = proposed_credit_limit, fill = factor(is_fraud))) +
  geom_histogram(binwidth = 500) +
  labs(x = "Proposed Credit Limit", y = "Count", fill = "Fraudulent") +
  theme_minimal()

# Gráfico de barras para foreign_request
ggplot(dados, aes(x = factor(foreign_request), fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Foreign Request", y = "Count", fill = "Fraudulent") +
  scale_x_discrete(labels = c("No", "Yes")) +
  theme_minimal()

# Gráfico de barras para source
ggplot(dados, aes(x = factor(source), fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Source", y = "Count", fill = "Fraudulent") +
  theme_minimal()

ggplot(dados, aes(x = session_length_in_minutes, fill = factor(is_fraud))) +
  geom_density(alpha = 0.5) +
  labs(x = "Session Length (Minutes)", y = "Density", fill = "Fraudulent") +
  theme_minimal()


# Gráfico de barras para device_os
ggplot(dados, aes(x = factor(device_os), fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Device OS", y = "Count", fill = "Fraudulent") +
  theme_minimal()

# Gráfico de barras para keep_alive_session
ggplot(dados, aes(x = factor(keep_alive_session), fill = factor(is_fraud))) +
  geom_bar() +
  labs(x = "Keep Alive Session", y = "Count", fill = "Fraudulent") +
  scale_x_discrete(labels = c("No", "Yes")) +
  theme_minimal()

# Histograma para device_distinct_emails_8w
ggplot(dados, aes(x = device_distinct_emails_8w, fill = factor(is_fraud))) +
  geom_histogram(binwidth = 1) +
  labs(x = "Distinct Emails on Device", y = "Count", fill = "Fraudulent") +
  theme_minimal()


###### ver se os dados se correlacionams atraves da matriz e do mapa de calor

matriz_cor <- cor(dados_sum)
matriz_cor

ggplot(data = reshape2::melt(matriz_cor), aes(x = Var1, y = Var2, fill = value)) +
  geom_tile() +
  scale_fill_gradient(low = "blue", high = "red") +
  theme_minimal() +
  labs(title = "Matriz de Correlação")

#####como nao da para ver nada vou encontrar os valores com correlacao maior
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

##########################################################################################
##########################################################################################
##########################################################################################
##########################################################################################




num_componentes_lista <- c(2, 10) 
percentagem_total_lista <- c(1, 0.7, 0.5)

for (num_componentes in num_componentes_lista){
  #num_componentes = 2
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
  for (i in 1:6){
    #i=1
    dados_featured <- dados_featured_lista[[i]]
    dados_featured_nome <- dados_featured_nome_lista[i]
    print(paste("Tipos de featuring usada: ",dados_featured_nome))
    for (percentagem_total in percentagem_total_lista){
      tamanho_total <- floor(percentagem_total * nrow(dados_featured))
      indices_amostra <- sample(1:nrow(dados_featured), size = tamanho_total)
      dados_amostra <- dados_featured[indices_amostra, ]
      
      # Divisão em conjunto de treino e teste
      percentagem_treino <- 0.7
      set.seed(123)
      tamanho_treino <- floor(percentagem_treino * nrow(dados_amostra))
      tamanho_teste <- nrow(dados_amostra) - tamanho_treino
      indices <- sample(1:nrow(dados_amostra))
      dados_treino <- dados_amostra[indices[1:tamanho_treino], ]
      dados_teste <- dados_amostra[indices[(tamanho_treino + 1):nrow(dados_amostra)], ]
      dados_treino <- as.data.frame(dados_treino)
      dados_teste <- as.data.frame(dados_teste)
      
      percentagem_erro_AD <-232436
      percentagem_erro_KNN <-232436
      percentagem_erro_NB <-232436
      percentagem_erro_NN <-232436
      percentagem_erro_SVM <-232436
      percentagem_erro_RF <-232436
      
      
      #KNN
      k <- 5
      modelo_knn <- knn(train = dados_treino[, -ncol(dados_treino)], test = dados_teste[, -ncol(dados_teste)], cl = dados_treino$is_fraud, k = k)
      previsao <- as.factor(modelo_knn)
      resultado <- cbind(dados_teste, previsao)
      percentagem_erro_KNN <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
      rm(previsao)
      rm(resultado)
      
      #Naive Bayes
      modelo_nb <- naiveBayes(is_fraud ~ ., data = dados_treino)
      previsao <- predict(modelo_nb,  list(var = dados_teste[, -1]))
      resultado <- cbind(dados_teste, previsao)
      percentagem_erro_NB <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
      rm(previsao)
      rm(resultado)
      
      #Rede Neural
      modelo_nn <- neuralnet(is_fraud ~ ., data = dados_treino, hidden = c(4, 2))
      previsao <- compute(modelo_nn, dados_teste[, -ncol(dados_teste)])$net.result
      previsao <- ifelse(previsao >= 0.5, 1, 0) 
      resultado <- cbind(dados_teste, previsao)
      percentagem_erro_NN <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
      rm(modelo_nn)
      rm(previsao)
      rm(resultado)
      
     
      #Random Forest
      modelo_rf <- randomForest(is_fraud ~ ., data = dados_treino, ntree = 100)
      previsao <- predict(modelo_rf, newdata = dados_teste, type = "response")
      resultado <- cbind(dados_teste, previsao)
      percentagem_erro_RF <- sum(resultado$is_fraud != resultado$previsao) / nrow(resultado) * 100
      rm(previsao)
      rm(resultado)
      
      #GBM
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
      
      #XGBoost
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
      
      ##
      print(paste("Percentagem da amostra:", percentagem_total*100, "%"))
      
      percentagens_de_erro_lista <- list(percentagem_erro_AD, percentagem_erro_KNN,
                                      percentagem_erro_NB, percentagem_erro_NN,
                                      percentagem_erro_SVM, percentagem_erro_RF)
                                    #  percentagem_erro_GBM, percentagem_erro_XGB)
      percentagem_erro_nome_lista <- c("AD", "KNN", "NB", "NN", "SVM", "RF", "GBM", "XGB")
      
      for (p in 1:6){
        percentagens_de_erro <- percentagens_de_erro_lista[[p]]
        percentagem_erro_nome <-percentagem_erro_nome_lista[p]
        print(paste("Percentagem de erro de", percentagem_erro_nome,
                    ": ",percentagens_de_erro))
      }
    }
  }
}




