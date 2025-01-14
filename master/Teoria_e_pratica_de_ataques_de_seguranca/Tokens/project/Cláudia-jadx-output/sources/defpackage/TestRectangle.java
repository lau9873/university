package defpackage;
/* renamed from: TestRectangle  reason: default package */
/* loaded from: TestRectangle.class */
class TestRectangle {
    TestRectangle() {
    }

    public static void main(String[] strArr) {
        Point point = new Point(1, 1);
        Point point2 = new Point(2, 2);
        Point point3 = new Point(3, 4);
        Point point4 = new Point(8, 2);
        Rectangle rectangle = new Rectangle(point, point3);
        Rectangle rectangle2 = new Rectangle(2, 3, 9, 6);
        Rectangle rectangle3 = new Rectangle(3, 4, 4, 5);
        Rectangle rectangle4 = new Rectangle(5, 1, 6, 5);
        Rectangle rectangle5 = new Rectangle(7, 3, 9, 5);
        System.out.println("Perimetro do retangulo amarelo = " + rectangle.perimeter());
        System.out.println("Perimetro do retangulo laranja = " + rectangle2.perimeter());
        System.out.println("Area do retangulo amarelo = " + rectangle.area());
        System.out.println("Area do retangulo laranja = " + rectangle2.area());
        System.out.println("Ponto B dentro rectangulo amarelo? " + rectangle.pointInside(point2));
        System.out.println("Ponto D dentro rectangulo amarelo? " + rectangle.pointInside(point4));
        System.out.println("Retangulo verde dentro do laranja? " + rectangle2.rectangleInside(rectangle3));
        System.out.println("Retangulo azul dentro do laranja? " + rectangle2.rectangleInside(rectangle4));
        System.out.println("Retangulo vermelho dentro do laranja? " + rectangle2.rectangleInside(rectangle5));
    }
}
