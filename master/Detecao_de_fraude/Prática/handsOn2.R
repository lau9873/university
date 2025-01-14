library(tidyverse) 
library(tidymodels)
# 1 - Handling Missing Values
load("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/carIns.Rdata") 
str(carIns)

# (a)
#remove all the observations that contain missing values;
carIns %>% drop_na()
#replace all the missing values of the attribute nDoors with the value ’four’. 
carIns %>% replace_na(list(nDoors='four'))

# (b)
rec <- recipe(carIns)
rec %>%
  # pre-processing steps imputation methods %>% 
  prep() %>%
  bake(carIns)

# (c)
carIns_imput <- 
  rec %>%
  step_impute_mode(nDoors) %>% step_impute_mean(normLoss) %>% 
  prep() %>%
  bake(carIns)
carIns_imput %>% select(nDoors,normLoss) %>% summary()

carIns_imput <- 
  rec %>%
  step_impute_mode(all_nominal()) %>% 
  step_impute_mean(all_numeric()) %>% 
  prep() %>%
  bake(carIns)
summary(carIns_imput)

# 2 - Data Transformation

# (a)
carIns_stand <- 
  rec %>%
  step_range(price) %>% 
  prep() %>% 
  bake(carIns)
carIns_stand %>% select(price) %>% summary()

# (b)
carIns_stand <- 
  rec %>%
  step_normalize(price) %>% 
  prep() %>%
  bake(carIns)
carIns_stand %>% select(price) %>% summary()

# (c)
carIns_discr <- 
  rec %>%
  step_discretize(price,num_breaks=4) %>% 
  prep() %>%
  bake(carIns)
carIns_discr %>% select(price) %>% summary()

# 3 - Sampling Data

# (a)
set.seed(123)
carIns_sample1 <- carIns %>% slice_sample(prop=0.5)

# (b)
set.seed(123)
carIns_sample2 <- carIns %>% group_by(fuelType) %>% slice_sample(prop=0.5)

# (c)
carIns %>% select(fuelType) %>% summary() 
carIns_sample1 %>% select(fuelType) %>% summary() 
carIns_sample2 %>% select(fuelType) %>% summary()

# 4 - Dimensionality Reduction

# (a)
carIns_num <- carIns_imput %>% select(where(is.numeric)) 
res <- carIns_num %>% cor()

# (b)
library(corrplot) 
corrplot(res,type="lower",
         method="number",
         number.cex = 0.5,diag=FALSE) 
corrplot.mixed(res,
               lower = "circle", 
               upper = "number", 
               number.cex = 0.5, 
               tl.col = "black", 
               tl.cex = 0.5)

# (c)
carIns_corr <- 
  rec %>%
  step_impute_mean(all_numeric()) %>% 
  step_corr(all_numeric(),threshold=.8) %>% 
  prep() %>%
  bake(carIns)
setdiff(carIns %>% colnames(),carIns_corr %>% colnames())
carIns_corr_num <- carIns_corr %>% select(where(is.numeric)) 
res_corr <- carIns_corr_num %>% cor() 
corrplot.mixed(res_corr,
               lower = "circle", 
               upper = "number", 
               number.cex = 0.65, 
               tl.col = "black", 
               tl.cex = 0.65)

# (d)
res1 <- cor.mtest(carIns_num,conf.level=0.95) 
corrplot(res,p.mat=res1$p,type="lower",
         diag=FALSE,sig.level = 0.05,insig="blank")

# 5 - Dimensionality Reduction

# (a)
# ??prcomp()

# (b)
library(devtools)
# remote::install_github("vqv/ggbiplot")
library(ggbiplot)
data("USArrests")
res_pca <- prcomp(USArrests, scale=TRUE,center=TRUE) 
res_pca
ggbiplot(res_pca,labels=rownames(USArrests))
