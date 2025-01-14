// Uma classe simples para representar um ponto 2D
class Point {
   int x, y;

   Point() {
      x = y = 0;
   }
   
   Point(int x0, int y0) {
      x = x0;
      y = y0;
   }

   public String toString() {
      return "(" + x + "," + y + ")";
   }
}
class Rectangle {
    Point P1,P2;
    
    Rectangle(){
	P1 = P2 = new Point(0,0);
    }

    Rectangle(int x1,int y1,int x2,int y2) {
	P1 = new Point(x1,y1);
	P2 = new Point(x2,y2);
    }
    Rectangle(Point p1, Point p2){
	P1 = p1;
	P2 = p2;	
    }
    public int area(){
	int a = (P2.x-P1.x)*(P2.y-P1.y);
	return (a);
    }
    public int perimeter(){
	int p = (P2.x-P1.x)*2+(P2.y-P1.y)*2;
	return (p);
    }
    public boolean pointInside(Point p){
        return (p.x>=P1.x && p.x<=P2.x && p.y>=P1.y && p.y<=P2.y);
    }
    public boolean rectangleInside(Rectangle r){
	return (pointInside(r.P1) && pointInside(r.P2));
    }
}
class TestRectangle {
   public static void main(String[] args) {
      Point a = new Point(1,1);
      Point b = new Point(2,2);
      Point c = new Point(3,4);
      Point d = new Point(8,2);
      
      Rectangle amarelo  = new Rectangle(a, c);
      Rectangle laranja  = new Rectangle(2, 3, 9, 6);
      Rectangle verde    = new Rectangle(3, 4, 4, 5);
      Rectangle azul     = new Rectangle(5, 1, 6, 5);
      Rectangle vermelho = new Rectangle(7, 3, 9, 5);
      
      System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
      System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20
      
      System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
      System.out.println("Area do retangulo laranja = " + laranja.area()); // 21                   
      
      System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
      System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false
      
      System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde));       // true
      System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul));         // false
      System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho)); // true
   }
}
