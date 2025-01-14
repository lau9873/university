
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
summary(dados)

dados_alt <- dados
dados_alt <- dados_alt[, -which(names(dados) == "device_fraud_count")]

dados_alt$payment_type <-factor(dados_alt$payment_type)
dados_alt$employment_status <- factor(dados_alt$employment_status)
dados_alt$housing_status <- factor(dados_alt$housing_status)
dados_alt$device_os <- factor(dados_alt$device_os)
dados_alt$source <- factor(dados_alt$source)

dados_alt$email_is_free <- factor(dados_alt$email_is_free)
dados_alt$phone_home_valid <- factor(dados_alt$phone_home_valid)
dados_alt$phone_mobile_valid <- factor(dados_alt$phone_mobile_valid)
dados_alt$has_other_cards <- factor(dados_alt$has_other_cards)
dados_alt$foreign_request <- factor(dados_alt$foreign_request)
dados_alt$keep_alive_session <- factor(dados_alt$keep_alive_session)





  
summary(dados_alt)
sapply(dados_alt, class)


#variaveis discretas: todo o resto
#variaveis continuas: income, name_email_similarity, days_since_request, intended_balcon_amount,
#payment_type, velocity_6h, velocity_24h, velocity_4w, session_length_in_minutes



