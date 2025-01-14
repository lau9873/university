library(tidyverse)
library(tidymodels)
library(rpart.plot)
library(vip)

# 1 -  Multiple Linear Regression

# (a)
data(Boston, package = "MASS")
set.seed(123)
boston_train <- Boston %>% sample_frac(0.7)
boston_test <- anti_join(Boston, boston_train, by = c("crim", "zn", "indus", "chas", "nox", "rm", "age", "dis", "rad", "tax", "ptratio", "black", "lstat", "medv"))

# (b)
model_lm <- linear_reg(engine = "lm")
lm_fit1 <- model_lm %>%
  fit(medv ~ rm, data = boston_train)
tidy(lm_fit1)
ggplot(boston_train, aes(x = rm, y = medv)) + geom_point()
lm_preds1 <- boston_test %>%
  dplyr::select(medv) %>%
  bind_cols(predict(lm_fit1, boston_test))
lm_preds1 %>%
  metrics(truth = medv, estimate = .pred)

# (c)
lm_fit2 <- model_lm %>%
  fit(medv ~ rm + crim, data = boston_train)

# (d)
lm_fit3 <- model_lm %>%
  fit(medv ~ ., data = boston_train)
tidy(lm_fit3)

# (e)
lm_preds <- boston_test %>%
  dplyr::select(medv) %>%
  bind_cols(predict(lm_fit3, boston_test))

lm_preds %>%
  metrics(truth = medv, estimate = .pred)

# (f)
lm_preds %>%
  ggplot(aes(x = medv, y = .pred)) + geom_point() + geom_smooth(method = "lm",
                                                                formula = "y ~ x") + ggtitle("Boston: Linear Regression Predictions") + xlab("True Values") +
  ylab("Predicted Values") + xlim(0, 50) + ylim(0, 50)

# (g)
model_glm_ridge <- linear_reg(engine = "glmnet", penalty = 0.01, mixture = 0)
ridge_fit <- model_glm_ridge %>%
  fit(medv ~ ., data = boston_train)
tidy(ridge_fit)

model_glm_ridge <- linear_reg(engine = "glmnet", penalty = 1, mixture = 0)
ridge_fit <- model_glm_ridge %>%
  fit(medv ~ ., data = boston_train)
tidy(ridge_fit)

# (h)

# Make predictions on the test set for the Ridge Regression model with different penalty values
ridge_preds_0.01 <- boston_test %>%
  dplyr::select(medv) %>%
  bind_cols(predict(model_glm_ridge, boston_test, type = "response", penalty = 0.01))

ridge_preds_100 <- boston_test %>%
  dplyr::select(medv) %>%
  bind_cols(predict(model_glm_ridge, boston_test, type = "response", penalty = 100))

# Calculate the RMSE and R-squared values for each model
rmse_0.01 <- rmse(ridge_preds_0.01$medv, ridge_preds_0.01$.pred)
r_squared_0.01 <- rsq(ridge_preds_0.01$medv, ridge_preds_0.01$.pred)

rmse_100 <- rmse(ridge_preds_100$medv, ridge_preds_100$.pred)
r_squared_100 <- rsq(ridge_preds_100$medv, ridge_preds_100$.pred)

# Print the RMSE and R-squared values for each model
cat("Ridge Regression with penalty = 0.01: RMSE =", round(rmse_0.01, 2), "R-squared =", round(r_squared_0.01, 2), "\n")
cat("Ridge Regression with penalty = 100: RMSE =", round(rmse_100, 2), "R-squared =", round(r_squared_100, 2), "\n")

# (i)
library(glmnet)

# Build Lasso Regression model on the training data
x_train <- as.matrix(boston_train[, -14])
y_train <- boston_train$medv

lasso_fit <- glmnet(x_train, y_train, alpha = 1, family = "gaussian", standardize = TRUE)

# Inspect the obtained coefficients
coef(lasso_fit)

# (j) 
# Prepare test data
x_test <- as.matrix(boston_test[, -14])
y_test <- boston_test$medv

# Make predictions on test data for different penalty values
lasso_preds <- predict(lasso_fit, s = c(0.01, 0.1, 1, 10), newx = x_test)

# Calculate performance metrics for different penalty values
library(yardstick)
lasso_metrics <- tibble(penalty = c(0.01, 0.1, 1, 10),
                        rmse = c(rmse(y_test, lasso_preds[, 1]),
                                 rmse(y_test, lasso_preds[, 2]),
                                 rmse(y_test, lasso_preds[, 3]),
                                 rmse(y_test, lasso_preds[, 4])),
                        r2 = c(rsq(y_test, lasso_preds[, 1]),
                               rsq(y_test, lasso_preds[, 2]),
                               rsq(y_test, lasso_preds[, 3]),
                               rsq(y_test, lasso_preds[, 4])))

# Print performance metrics
print(lasso_metrics)

# 2 - CART Trees
# (a)
model_rt <- decision_tree(mode = "regression", engine = "rpart")
rt_fit <- model_rt %>%
  fit(medv ~ ., data = Boston)
library(rpart.plot)
# to extract it from the parsnip
rt_fit %>%
  extract_fit_engine() %>%
  rpart.plot(roundint = FALSE)
library(vip)
vip(rt_fit)
# bostonTree <- rt_fit %>% extract_fit_engine() bostonTree£variable.importance

# (b)
data(iris)
model_rt <- decision_tree(mode = "classification", engine = "rpart")
rt_fit <- model_rt %>%
  fit(Species ~ ., data = iris)
rt_fit %>%
  extract_fit_engine() %>%
  rpart.plot(roundint = FALSE)
vip(rt_fit)

# (c)
golf <- read.csv("golf.csv")
model_rt <- decision_tree(mode = "classification", engine = "rpart")
rt_fit <- model_rt %>%
  set_engine("rpart", min_n = 2) %>%
  fit(decision ~ ., data = golf)
rt_fit %>%
  extract_fit_engine() %>%
  rpart.plot(roundint = FALSE)
vip(rt_fit)


# 3
# Predict using CART model
cart_preds <- predict(rt_fit, new_data = boston_test)

# Evaluate performance using root mean squared error (RMSE)
library(yardstick)
cart_rmse <- rmse(boston_test$medv, cart_preds)
cart_rmse











