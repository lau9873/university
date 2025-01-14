library(tidyverse)
#load("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/dummy1.csv")
#load("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/dummy2.csv")
#load("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/dummy3.csv")
#load("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/dummy4.csv")
ds1 <- read_csv("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/dummy1.csv")
ds2 <- read_csv2("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/dummy2.csv")
ds31 <- read_csv("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/dummy3.csv")
ds32 <- read_csv("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/dummy3.csv",na="?")
ds4 <- read_csv("~/Desktop/Cláudia/Mestrado/1º ano/2º semestre/Deteção de Fraude/Prática/dummy4.csv")
ds1
ds2
ds31
ds32
ds4

data(iris)
class(iris)
iris

ir <- as_tibble(iris)
class(ir)
ir

filter(ir, Sepal.Length>6, Sepal.Width>3.5)
filter(ir, Sepal.Length>7.7 | Sepal.Length<4.4)

select(ir, Sepal.Length, Species)

select(ir, -(Sepal.Length:Petal.Length))

select(ir, starts_with("Sepal"))

arrange(ir, desc(Sepal.Length), Sepal.Width)

mutate(ir,
      sr=Sepal.Length/Sepal.Width,
      pr=Petal.Length/Petal.Width)

mutate(ir,
      Sepal.Length=Sepal.Length*10)

summarise(ir,
            avgPL= mean(Petal.Length),
            varSW = var(Sepal.Width))

select( filter(ir, Petal.Width > 2.3), Sepal.Length, Species)

arrange(
  select(
    filter(
      mutate(ir, sr = Sepal.Length/Sepal.Width), sr > 1.6),
    Sepal.Length, Species),
  Species, desc(Sepal.Length))

mutate(ir, sr = Sepal.Length/Sepal.Width) %>%
  filter(sr > 1.6) %>%
  select(Sepal.Length, Species) %>%
  arrange(Species, desc(Sepal.Length))

sps <- group_by(ir, Species)
sps

group_by(ir, Species) %>% summarise(mPL=mean(Petal.Length))

ggplot(iris,aes(x=Petal.Length,y=Sepal.Length,color=Species)) +
  geom_point() + ggtitle("Species of Plants")

df <- tibble(trt = c("a", "b", "c"), outcome = c(2.3, 1.9, 3.2))
ggplot(df, aes(x=trt, y=outcome)) + geom_col() +
  ggtitle("Outcome value per treatment")


data(algae,package="DMwR2")
str(algae)

ggplot(algae,aes(x=season)) + geom_bar() +
  ggtitle("Distribution of water samples across seasons")

ggplot(algae, aes(x = a1)) + geom_histogram(binwidth = 10) +
  ggtitle("Distribution of Algae a1") + ylab("Concentration")

ggplot(algae, aes(x = mxPH)) +
  geom_histogram(binwidth = .5, aes(y = ..density..)) +
  geom_density(color = "red") + geom_rug() + ggtitle("The Histogram of mxPH")

ggplot(algae, aes(sample = mxPH)) + geom_qq(geom="point") + stat_qq_line() +
  ggtitle('QQ Plot of Maximum PH Values')

ggplot(algae, aes(x = season, y = a6)) + geom_boxplot() +
  ggtitle('Distribution of Algae a6 by Season')

ggplot(algae,aes(x=mxPH,y=Chla)) + geom_point() + facet_grid(~season) +
  ggtitle("Maximum PH and Chlorophyll a by Season")

ggplot(algae, aes(x = a3)) + geom_histogram(binwidth = 5) +
  facet_grid(speed ~ season) +
  ggtitle('Distribution of Algae a3 by River Speed and Season')






