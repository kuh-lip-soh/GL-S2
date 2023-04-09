function[]= ACP(x)

[n,c]=size(x);
moy=mean(x);
xc=x-moy;

v=(1/n)*(xc')*xc;
[vcp,vlp]=eigs(v);
d=diag(diag(1./(sqrt(v))));
xcr=xc*d;

r=(1/n)*(xcr')*xcr;
[vec_p,val_p]=eigs(r);

cv=diag(val_p);
[a,b]=size(vec_p);
y=cv;
for i=1:a
for j=1:b
cv(i,j)=vec_p(i,j)*sqrt(y(j));
end
end

cv
cp=xcr*vec_p

q1=val_p(1)/sum(val_p,'all');
q2=val_p(2)/sum(val_p,'all');
q=(q1+q2)*100


figure
   hold on
   title('Représentation des individus')
   xlabel('Axe1')
   ylabel('Axe2')
   xline(0)
   yline(0)
   for i = 1:size(cp,1)
       size(cp, 1);
       a = cp(i, 1);
       b = cp(i, 2);
       text(a, b, num2str(i))
       plot(a, b, 'rx');
   end
   figure 
   hold on
   title('Représentation des variables')
   xlabel('Axe1')
   ylabel('Axe2')
   p = nsidedpoly(1000, 'center', [0, 0], 'Radius', 1)
   plot(p, 'FaceColor', 'none')
   for i = 1:size(cv, 1)
       a = cv(i, 1);
       b = cv(i, 2);
       text(a, b, num2str(i))
       plot(a, b, 'rx');
   end  
end