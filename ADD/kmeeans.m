function [C]= kmeeans(X,k)
   rng('default')
   [idx,C] = kmeans(X,k);
   figure
   gscatter(X(:,1),X(:,2),idx,'bgmry')
   hold on
   plot(C(:,1),C(:,2),'kx','MarkerSize',15,'LineWidth',3)
   legend('Cluster 1','Cluster 2','Cluster 3','Cluster 4','Cluster Centroid')	
end