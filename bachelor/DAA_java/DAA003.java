import java.util.Scanner;
public class DAA003{
     public static void main(String[] args){
	 Scanner in = new Scanner(System.in);
	 int t = in.nextInt();
	 while(t>0){
	     String m1 = in.next();
	     String m2 = in.next();
	     int f1 = formato(m1); 
	     int f2 = formato(m2);
	   
	     int l11 = codLetra(m1, f1, 1);

	     int l12 = codLetra(m1, f1, 2);
	     
	     
	     int l21 = codLetra(m2, f2, 1);
	   
	     int l22 = codLetra(m2, f2, 2);
	     int l13 = 0;
	     int l14 = 0;
	     int l23 = 0;
	     int l24 = 0;
	     if(f1==4){
		 l13= codLetra(m1, f1, 3);
		 l14=codLetra(m1, f1, 4);
	     }
	     if(f2==4){
		 l23= codLetra(m2, f2, 3);
	         l24=codLetra(m2, f2, 4);
        
	     }
	     int d =  dti(m1,m2,f1,f2,l11,l12,l13,l14,l21,l22,l23,l24);
	     System.out.println(d);
	     t--;
	 }
	     
     }

    public static int formato(String m){
	if (Character.isLetter(m.charAt(0)) && Character.isLetter(m.charAt(6))){
	    return 4;
	}else if (Character.isLetter(m.charAt(6))){
	    return 2;
	} else if (Character.isLetter(m.charAt(3))){
	    return 3;
	}else{
	    return 1;
	}
    }

    public static int codLetra( String m, int f, int pos){
	int c;
	if (f==1){
	    if(pos==1)
	       c = m.charAt(0);
	    else
	       c = m.charAt(1);
	} else if(f==2){
	    if(pos==1)
	       c = m.charAt(6);
	    else
	       c = m.charAt(7);
	} else if(f==3){
	     if(pos==1)
	       c = m.charAt(3);
	    else
	       c = m.charAt(4);
	}else{
	    if(pos==1)
	       c = m.charAt(0);
	    else if(pos==2)
	       c = m.charAt(1);
	    else if(pos==3)
	       c = m.charAt(6);
	    else
	       c = m.charAt(7);
	}
	if (c==90)
	    return c-3;
	else if (c>87)
	    return c-2;
	else if(c>75)
	    return c-1;
	else
	    return c;
    }
    
    public static int dti(String ma1, String ma2, int g1, int g2, int l11, int l12, int l13, int l14,int l21, int l22, int l23, int l24){

	int maf123 = 23*23*10000; // nº de matriculos da 1º,2º,3º geracao
	int maf4 = 23*23*23*23*100; //nº de matriculas de 4 geração	
	int maior1;
	int maior2;
       //matriculas maiores do que ma1 ** primeiro é incrementada a parte numerica
	switch(g1){
	case 1:
	    maior1 = (9-num(ma1.charAt(7)))+(9-num(ma1.charAt(6)))*10 + (9-num(ma1.charAt(4)))*100 + (9-num(ma1.charAt(3)))*1000 + (87 - l12)*10000 + (87-l11)*23*10000  + 2*maf123 + maf4;
	    break;
	case 2:
	    maior1 = (9-num(ma1.charAt(4)))+(9-num(ma1.charAt(3)))*10+ (9-num(ma1.charAt(1)))*100 + (9-num(ma1.charAt(0)))*1000 + (87 - l12)*10000 + (87-l11)*23*10000  +  maf123 + maf4 ;
	     break;
	case 3:
	    maior1 = (9-num(ma1.charAt(7)))+(9-num(ma1.charAt(6)))*10+ (9-num(ma1.charAt(1)))*100 + (9-num(ma1.charAt(0)))*1000 + (87 - l12)*10000 + (87-l11)*23*10000  + maf4;
	    break;
	default:
	    maior1 = (9-num(ma1.charAt(4))) + (9-num(ma1.charAt(3)))*10 + (87-l14)*100 + (87-l13)*23*100 + (87-l12)*23*23*100 + (87-l11)*23*23*23*100;
	    break;
	}
	// matriculas maiores do que ma2
  	switch(g2){
	case 1:
	    maior2 = (9-num(ma2.charAt(7)))+(9-num(ma2.charAt(6)))*10+ (9-num(ma2.charAt(4)))*100 + (9-num(ma2.charAt(3)))*1000 + (87 - l22)*10000 + (87-l21)*23*10000  + 2*maf123 + maf4;
	    break;
	case 2:
	    maior2 = (9-num(ma2.charAt(4)))+(9-num(ma2.charAt(3)))*10+ (9-num(ma2.charAt(1)))*100 + (9-num(ma2.charAt(0)))*1000 + (87 - l22)*10000 + (87-l21)*23*10000  +  maf123 + maf4 ;
	     break;
	case 3:
	    maior2 = (9-num(ma2.charAt(7)))+(9-num(ma2.charAt(6)))*10+ (9-num(ma2.charAt(1)))*100 + (9-num(ma2.charAt(0)))*1000 + (87 - l22)*10000 + (87-l21)*23*10000  + maf4;
	    break;
	default:
	    maior2 = (9-num(ma2.charAt(4))) + (9-num(ma2.charAt(3)))*10  + (87-l24)*100 + (87-l23)*23*100 + (87-l22)*23*23*100 + (87-l21)*23*23*23*100;
	    break;
	}

        return Math.abs(maior1 - maior2);
    }
    public static int num( char a ){
	return Character.getNumericValue(a);
    }
// da joana....	    
	    
}