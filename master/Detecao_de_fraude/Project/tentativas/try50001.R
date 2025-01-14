
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
#summary(dados_completos)
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


set.seed(1234)

pima_split <- dados_preenchidos %>% initial_split(prop=.7,strata=is_fraud)
pima_split



percentagem_treino <- percentagem_total
set.seed(1234)
split_dados <- dados_featured %>% initial_split(prop=percentagem_total,strata=is_fraud)
dados_treino <- training(split_dados)
dados_teste <- testing(split_dados)



rec <- recipe(is_fraud ~.,dados_treino)
rec <- rec %>% step_normalize(all_numeric_predictors()) %>% prep()
dados_treino <- rec %>% bake(new_data=NULL)
dados_teste <- rec %>% bake(new_data=test)

model_knn <- nearest_neighbor(mode="classification")      
knn_fit <- model_knn %>%
  fit(diabetes ~ ., data = pima_train)
knn_fit
knn_preds <- predict(knn_fit,new_data = pima_test)

knn_preds <-
  pima_test %>% dplyr::select(diabetes) %>%
  bind_cols(predict(knn_fit, pima_test)) %>%
  bind_cols(predict(knn_fit, pima_test,type="prob"))
knn_preds %>% roc_auc(truth=fct_relevel(diabetes,"pos"),estimate=.pred_pos)

roc_curve(knn_preds,fct_relevel(diabetes,"pos"),.pred_pos) %>% autoplot()

model_knn <- nearest_neighbor(mode="classification",neighbors=11)
knn_fit <- model_knn %>%
  fit(diabetes ~ ., data = pima_train)
knn_preds <-
  pima_test %>% dplyr::select(diabetes) %>%
  bind_cols(predict(knn_fit,pima_test)) %>%
  bind_cols(predict(knn_fit,pima_test,type="prob"))
knn_preds %>% conf_mat(diabetes,.pred_class) %>% autoplot(type="heatmap")



