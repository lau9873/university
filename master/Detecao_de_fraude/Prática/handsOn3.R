library(tidyverse)
library(cluster)
library(dbscan)
library(factoextra)



# 1 - Descriptive Analytics

# (a)
iris1 <- iris %>% 
  select(-Species) %>% 
  slice(1:5)


# (b)
dist_iris1 <- dist(iris1)
dist_manhattan <- dist(iris1, method = "manhattan")
dist_minkowski2 <- dist(iris1, method = "minkowski", p = 2)
dist_minkowski4 <- dist(iris1, method = "minkowski", p = 4)
dist_supremum <- dist(iris1, method = "maximum")

# (c)
iris_cluster <- iris %>% 
  mutate(Species = as.factor(Species))

dist_daisy_euclidean <- daisy(iris_cluster, metric = "euclidean")
dist_daisy_manhattan <- daisy(iris_cluster, metric = "manhattan")
dist_daisy_gower <- daisy(iris_cluster, metric = "gower")

# 2 - Clustering
# (a)
iris2 <- iris %>% 
  select(-Species) %>% 
  mutate_all(scale)

# (b)
k3 <- kmeans(iris2, centers = 3)
k3

# (c)
fviz_cluster(k3, iris2)

# (d)
si_coefs_k3 <- silhouette(k3$cluster, dist(iris2))
fviz_silhouette(si_coefs_k3) + coord_flip()

summary(iris)

# (e)
fviz_nbclust(iris2, kmeans, method = "silhouette")

# (f)
    # PAM algorithm with 3 clusters
p3 <- pam(iris2, k = 3)
fviz_cluster(p3, iris2)

    # CLARA algorithm with 3 clusters
c3 <- clara(iris2, k = 3)
fviz_cluster(c3, iris2)

# (g)
fviz_nbclust(iris2, kmeans, method = "wss")

# (h)
dbs <- dbscan(iris2,eps=0.9,minPts=5)
dbs
fviz_cluster(dbs, iris2)

# (i)
dm <- dist(iris2)
    # single linkage
hclust.sing <- hclust(dm, method = "single")
fviz_dend(hclust.sing, k = 3)

    # complete linkage
hclust.comp <- hclust(dm, method = "complete")
fviz_dend(hclust.comp, k = 3)

    # average linkage
hclust.avg <- hclust(dm, method = "average")
fviz_dend(hclust.avg, k = 3)


c <- cutree(hclust.sing,k=3)
si_coefs_hclust_sing_3 <- silhouette(c,dist(iris2))
mean(si_coefs_hclust_sing_3)
fviz_silhouette(si_coefs_hclust_sing_3) + coord_flip()




