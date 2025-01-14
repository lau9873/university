%EXERCICIO 7

n=[0:90]
s=ones(1,91)
for i=n
  s(i+1)=2*(i)*(0.9^(i)) 
end
r=rand(1,91)*0.8-0.4
x=s+r

Er=ClaudiaMaia_MariaSobral_TP1_6(x,s)
plot(n,s,n,r,n,x)
axis([0 90 -2 8])
title(['Sinais ( Erro:', num2str(Er),' )'])
legend('s[n]','r[n]','x[n]')
xlabel('n')
ylabel('Amplitude')