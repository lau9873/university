import java.util.Scanner;

public class Palindromos{
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int n = stdin.nextInt();
      System.out.println(n);
      stdin.nextLine();

      for(int i=0;i<n;i++){
	  String s = stdin.nextLine();
	  
          System.out.println(isPalindrome(s));
      }
   }
 static String isPalindrome(String n){
        String j = "";
	String g = "";
	for (int i = 0; i<n.length(); i++){
	    if (Character.isLetter(n.charAt(i)))	
	       g += n.charAt(i);
	}
	    
	for (int i = n.length()-1; i>=0; i--){
	    if (Character.isLetter(n.charAt(i)))	
		j += n.charAt(i);
	}
	String l = g.toUpperCase();
	String k = j.toUpperCase();

	if (l.equals(k))
	    return "sim";
	return "nao";  	
 }
}
