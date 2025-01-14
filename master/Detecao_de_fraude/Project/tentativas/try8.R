
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
  dados_treino$is_fraud <- as.factor(dados_treino$is_fraud)
  dados_teste$is_fraud <- as.factor(dados_teste$is_fraud)
  model_rf <- rand_forest(mode = "classification", trees = 100) %>% 
    set_engine("ranger", importance = "impurity")
  rf_fit <- model_rf %>%
    fit(is_fraud ~ ., data = dados_treino)
  resultado <- dados_teste %>%
    dplyr::select(is_fraud) %>%
    add_column(predict(rf_fit, dados_teste))
  percentagem_erro_RF <- sum(dados_teste$is_fraud != resultado$.pred_class) / nrow(resultado) *100
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

