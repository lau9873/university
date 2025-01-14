# 1 - Data Understanding
# install.packages("readr")
library(readr)


### Data Import

ec <- read_csv("echocardiogram.csv") # set working directory...
ec 
spec(ec) # Inspect the type of each attribute
str(ec)

# set and find out how missing values are represented and 
# make sure that they are properly represented
ec <- read_csv("echocardiogram.csv", na = "?") 
ec
spec(ec)

#remove redundant or irrelevant attribute
ec <- ec %>% select(-c(mult, name, group)) 

summary(ec)

# data type change
ec <- ec %>% mutate(survival = as.numeric(survival), 
                    still_alive = as.factor(still_alive),
                    pericardial_effusion = as.factor(pericardial_effusion), 
                    alive_at = as.factor(alive_at))
summary(ec)

### Summarization

load("carIns_noNAs.Rdata")

carIns_noNAs %>% group_by(bodyStyle) %>% count() # number of cars by bodyStyle

carIns_noNAs %>% group_by(bodyStyle, fuelType) %>% count()

carIns_noNAs %>%
  group_by(bodyStyle) %>%
  summarize(cityMpg.mean = mean(cityMpg), cityMpg.sd = sd(cityMpg)) %>%
  arrange(cityMpg.mean)


### Visualization

library(ggplot2)

ggplot(carIns_noNAs, aes(x = cityMpg, y = highwayMpg)) + geom_point() + 
  ggtitle("Relationship between cityMpg and highwayMpg") # relationship between the attributes cityMpg and highwayMpg

ggplot(carIns_noNAs, aes(x = bodyStyle)) + geom_bar() + 
  ggtitle("Distribution of cars across bodyStyle")

ggplot(carIns_noNAs, aes(x = price)) + geom_histogram(binwidth = 5000) + 
  ggtitle("Histogram of price")

ggplot(carIns_noNAs, aes(x = price)) + 
  geom_histogram(binwidth = 5000, aes(y = ..density..)) +
  geom_density(color = "blue") + geom_rug() + ggtitle("Histogram of price")

ggplot(carIns_noNAs, aes(x = make, y = price)) + geom_boxplot() + coord_flip()

ggplot(carIns_noNAs, aes(x = price)) + geom_histogram(binwidth = 5000) + 
  facet_wrap(~nDoors) + ggtitle("Histogram of price by nDoors")

ggplot(carIns_noNAs, aes(x = price)) + geom_histogram(binwidth = 5000) + 
  facet_grid(fuelType ~ aspiration) + 
  ggtitle("Histogram of price by aspiration and fuel type")

ggplot(carIns_noNAs, aes(x = price)) + geom_histogram(binwidth = 5000) + 
  facet_grid(fuelType ~ aspiration, scales = "free_y") + 
  ggtitle("Histogram of price by aspiration and fuel type")

### Data Quality

library(tidyverse)
library(tidymodels)

## Handling Missing Values

load("carIns.Rdata")
str(carIns)

carIns %>% drop_na() # remove all the observations that contain missing values;
carIns %>% replace_na(list(nDoors='four')) # replace all the missing values of the attribute nDoors with the value ’four’.

rec <- recipe(carIns)

rec %>%
  # pre-processing steps imputation methods %>%
  prep() %>%
  bake(carIns)

carIns_imput <- rec %>%
  step_impute_mode(nDoors) %>% step_impute_mean(normLoss) %>%
  prep() %>% bake(carIns)
carIns_imput %>% select(nDoors,normLoss) %>% summary()

carIns_imput <-
  rec %>%
  step_impute_mode(all_nominal()) %>%
  step_impute_mean(all_numeric()) %>%
  prep() %>%
  bake(carIns)
summary(carIns_imput)

### Data Transformation

carIns_stand <-
  rec %>%
  step_range(price) %>%
  prep() %>%
  bake(carIns)
carIns_stand %>% select(price) %>% summary() # range-based normalization

carIns_stand <-
  rec %>%
  step_normalize(price) %>%
  prep() %>%
  bake(carIns)
carIns_stand %>% select(price) %>% summary() # z-score normalization

carIns_discr <-
  rec %>%
  step_discretize(price,num_breaks=4) %>%
  prep() %>%
  bake(carIns)
carIns_discr %>% select(price) %>% summary() # cut it into 4 equal-frequency ranges

### Sampling Data

set.seed(123)
carIns_sample1 <- carIns %>% slice_sample(prop=0.5) # A random sample of 50% of the cases

set.seed(123)
carIns_sample2 <- carIns %>% group_by(fuelType) %>% slice_sample(prop=0.5) 
# A stratified sample of 60% of the cases of cars, according to the fuelType attribute.

carIns %>% select(fuelType) %>% summary()
carIns_sample1 %>% select(fuelType) %>% summary()
carIns_sample2 %>% select(fuelType) %>% summary()

### Dimensionality Reduction

carIns_num <- carIns_imput %>% select(where(is.numeric))
res <- carIns_num %>% cor()

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

res1 <- cor.mtest(carIns_num,conf.level=0.95)
corrplot(res,p.mat=res1$p,type="lower",
         diag=FALSE,sig.level = 0.05,insig="blank")

# install.packages("devtools")
library(devtools)
# install_github("vqv/ggbiplot")
library(ggbiplot)
data("USArrests")
res_pca <- prcomp(USArrests, scale=TRUE,center=TRUE)
res_pca
ggbiplot(res_pca,labels=rownames(USArrests))






