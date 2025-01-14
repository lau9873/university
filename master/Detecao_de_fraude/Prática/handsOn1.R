library(tidyverse) #para usar o read_csv()
# 1 - Data Import

# (a)
ec <- read_csv("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/echocardiogram.csv") 
ec
spec(ec)

# (b)
ec <- read_csv("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/echocardiogram.csv",na= "?") 
ec 
spec(ec)

# (c)
ec <- ec %>% select(-c(mult,name,group))
ec

# (d)
summary(ec)

# (e)
ec <- ec %>% mutate(survival=as.numeric(survival),
                    still_alive=as.factor(still_alive),
                    pericardial_effusion=as.factor(pericardial_effusion), 
                    alive_at=as.factor(alive_at))
summary(ec)


# 2 - Summarization
load("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/carIns_noNAs.Rdata")

# (a)
carIns_noNAs %>% group_by(bodyStyle) %>% count()

# (b)
carIns_noNAs %>% group_by(bodyStyle,fuelType) %>% count()

# (c)
carIns_noNAs %>% group_by(bodyStyle) %>%
  summarize(cityMpg.mean = mean(cityMpg), 
            cityMpg.sd = sd(cityMpg)) %>% arrange(cityMpg.mean)

# 3 - Visualization
library(ggplot2)

# (a)
ggplot(carIns_noNAs,aes(x=cityMpg,y=highwayMpg)) + geom_point() + ggtitle("Relationship between cityMpg and highwayMpg")

# (b)
ggplot(carIns_noNAs,aes(x=bodyStyle)) + geom_bar() + ggtitle("Distribution of cars across bodyStyle")

# (c)
ggplot(carIns_noNAs,aes(x=price)) + geom_histogram(binwidth = 5000) + ggtitle("Histogram of price")

# (d)
ggplot(carIns_noNAs,aes(x=price)) + geom_histogram(binwidth = 5000, aes(y=..density..)) + geom_density(color="blue") + geom_rug() +
  ggtitle("Histogram of price")

# (e)
ggplot(carIns_noNAs,aes(x=make,y=price)) + geom_boxplot() + coord_flip()

# (f)
ggplot(carIns_noNAs,aes(x=price)) + geom_histogram(binwidth = 5000) + facet_wrap(~nDoors) + ggtitle("Histogram of price by nDoors")

# (g)
ggplot(carIns_noNAs,aes(x=price)) + geom_histogram(binwidth = 5000) + facet_grid(fuelType ~ aspiration) + ggtitle("Histogram of price by aspiration and fuel type")

# (h)
ggplot(carIns_noNAs,aes(x=price)) + geom_histogram(binwidth = 5000) + facet_grid(fuelType ~ aspiration,scales="free_y") +
  ggtitle("Histogram of price by aspiration and fuel type")





