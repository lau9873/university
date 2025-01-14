package defpackage;
/* renamed from: TestGeometry  reason: default package */
/* loaded from: TestGeometry.class */
public class TestGeometry {
    public static void main(String[] strArr) {
        Point point = new Point();
        System.out.println("p1 original: " + point);
        point.x = 1;
        System.out.println("p1 modificado: " + point);
        System.out.println("p2: " + new Point(2, 3));
    }
}
