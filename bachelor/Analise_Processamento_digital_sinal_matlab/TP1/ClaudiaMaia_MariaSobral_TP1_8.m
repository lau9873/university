%EXERCÍCIO 8

n=[0:90];
s=ones(1,91);
for i=n
  s(i+1)=2*(i)*(0.9^(i));
end
r=rand(1,91)*0.8-0.4;
x=s+r

N=length(x);
xc=[0 x 0];
xd=[0 0 x];
xe=[x 0 0];
y_3=(xd+xc+xe)/3;
y3=y_3(2:N+1)

x_1=[0 0 0 0 x];
x_2=[0 0 0 x 0];
x_3=[0 0 x 0 0];
x_4=[0 x 0 0 0];
x_5=[x 0 0 0 0];
y_5=(x_1+x_2+x_3+x_4+x_5)/5;
y5=y_5(3:N+2)

Er_x=ClaudiaMaia_MariaSobral_TP1_6(x,s);
Er_y3=ClaudiaMaia_MariaSobral_TP1_6(y3,s);
Er_y5=ClaudiaMaia_MariaSobral_TP1_6(y5,s);

plot(n,s,n,x,n,y3,n,y5);
title('Filtros de média ')
legend(' s',[' x: ',num2str(Er_x)],['y3: ',num2str(Er_y3)],['y5: ',num2str(Er_y5)])
axis ([0 90 -2 8])
xlabel('n')
ylabel('Amplitude')



