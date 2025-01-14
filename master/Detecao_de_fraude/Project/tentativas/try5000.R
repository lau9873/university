


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

setwd("/Users/lau/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Project")
dados <- read.csv("train.csv", header = TRUE, sep = ",")
teste <- read.csv("test.csv", header = TRUE, sep = ",")
dados_completos <- rbind(dados[,-33], teste)
summary(dados_completos)
dados_completos <- dados_completos %>% mutate(prev_address_months_count = na_if(prev_address_months_count, -1), 
                          current_address_months_count = na_if(current_address_months_count, -1),
                          bank_months_count = na_if(bank_months_count, -1))
dados_sum <- dados_completos

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



#Mode function
Mode <- function(x) {
  ux <- unique(x)
  ux[which.max(tabulate(match(x, ux)))]
}

dados_preenchidos <- dados_sum
median_1 <- mean(dados_preenchidos$prev_address_months_count[1:7944], na.rm = TRUE)
dados_preenchidos$prev_address_months_count[is.na(dados_preenchidos$prev_address_months_count)] <- median_1

median_2 <- mean(dados_preenchidos$current_address_months_count[1:7944], na.rm = TRUE)
dados_preenchidos$current_address_months_count[is.na(dados_preenchidos$current_address_months_count)] <- median_2

median_3 <- mean(dados_preenchidos$employment_status[1:7944], na.rm = TRUE)
dados_preenchidos$employment_status[is.na(dados_preenchidos$employment_status)] <- median_3

median_4 <- mean(dados_preenchidos$bank_months_count[1:7944], na.rm = TRUE)
dados_preenchidos$bank_months_count[is.na(dados_preenchidos$bank_months_count)] <- median_4

mode_5 <- Mode(dados_preenchidos$has_other_cards[1:7944])
dados_preenchidos$has_other_cards[is.na(dados_preenchidos$has_other_cards)] <- mode_5

mode_6 <- Mode(dados_preenchidos$source[1:7944])
dados_preenchidos$source[is.na(dados_preenchidos$source)] <- mode_6



dados_normalizados_p <- scale(dados_preenchidos) 
pca <- prcomp(dados_normalizados_p)
reducao_pca_p <- predict(pca, newdata = dados_normalizados_p)[, 1:5]
class(reducao_pca_p)

dados_treino <- reducao_pca_p[c(1:7944),]
dados_teste <- reducao_pca_p[-c(1:7944),]
dados_treino
dados_teste

fraud <- as.factor(dados$is_fraud)
dados_treino <- cbind(dados_treino, is_fraud = fraud)
class(dados_treino)
dados_treino


percentagem_treino <- 1
set.seed(123)
tamanho_treino <- floor(percentagem_treino * nrow(dados_treino))
indices <- sample(1:nrow(dados_treino))
dados_treino <- dados_treino[indices[1:tamanho_treino], ]
dados_treino <- as.data.frame(dados_treino)
dados_treino
dados_teste




modelo_rf <- randomForest(is_fraud ~ ., data = dados_treino, ntree = 100)
previsao <- predict(modelo_rf, newdata = dados_teste, type="class")
resultado <- cbind(teste[1], is_fraud = previsao)
resultado





modelo_knn <- knn(train = dados_treino[, -ncol(dados_treino)], test = dados_teste, cl = dados_treino$is_fraud, k = k)
previsao <- as.factor(modelo_knn)
resultado <- cbind(teste[1], is_fraud = previsao)
resultado

modelo_svm <- svm(is_fraud ~ ., data = dados_treino, type = "C")
previsao <- predict(modelo_svm, newdata = dados_teste)
resultado <- cbind(teste[1], is_fraud = previsao)
resultado

write.csv(resultado, file = "resultado.csv", row.names = FALSE)
