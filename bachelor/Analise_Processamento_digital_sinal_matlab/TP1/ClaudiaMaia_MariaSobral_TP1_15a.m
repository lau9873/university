load SR;
maximos = zeros(1,6);
posicoes_maxi = zeros(1,6);

Rs=[R1;R2;R3;R4;R5;R6];
   
stem(SL1);
for v=[1:18]
    for i= [1:6]
        [Vmax,Lmax]=ClaudiaMaia_MariaSobral_TP1_13(Rs(i,:),SL1,0);
        maximos(i)=Vmax;
        posicoes_maxi(i)=-Lmax;
    end
    [max1,pos1] = max(maximos);
    figure
    subplot(2,1,1);
    stem([0:29],Rs(pos1,:))
    xlabel('n');
    title(['Referência R',num2str(pos1),' escolhida que corresponde à parte do gráfico']);
    subplot(2,1,2);
    stem([0:29],SL1([posicoes_maxi(pos1)+1:(posicoes_maxi(pos1)+30)]));  
    xlabel('n');
    [max2,Lmax]=ClaudiaMaia_MariaSobral_TP1_13(Rs(pos1,:),SL1([posicoes_maxi(pos1)+1:(posicoes_maxi(pos1)+30)]),0);
    title(['Gráfico de SL1 com n entre ',num2str(posicoes_maxi(pos1)+1),' e ',num2str(posicoes_maxi(pos1)+30),', Vmax=',num2str(max2),' e Lmax= ',num2str(-posicoes_maxi(pos1))]);
    SL1([posicoes_maxi(pos1)+1:(posicoes_maxi(pos1)+30)])= zeros(1,30);
end









