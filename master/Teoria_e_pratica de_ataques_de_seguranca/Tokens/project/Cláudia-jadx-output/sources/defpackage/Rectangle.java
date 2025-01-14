package defpackage;
/* compiled from: TestRectangle.java */
/* renamed from: Rectangle  reason: default package */
/* loaded from: Rectangle.class */
class Rectangle {
    Point P1;
    Point P2;

    Rectangle() {
        Point point = new Point(0, 0);
        this.P2 = point;
        this.P1 = point;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rectangle(int i2, int i3, int i4, int i5) {
        this.P1 = new Point(i2, i3);
        this.P2 = new Point(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rectangle(Point point, Point point2) {
        this.P1 = point;
        this.P2 = point2;
    }

    public int area() {
        return (this.P2.x - this.P1.x) * (this.P2.y - this.P1.y);
    }

    public int perimeter() {
        return ((this.P2.x - this.P1.x) * 2) + ((this.P2.y - this.P1.y) * 2);
    }

    public boolean pointInside(Point point) {
        return point.x >= this.P1.x && point.x <= this.P2.x && point.y >= this.P1.y && point.y <= this.P2.y;
    }

    public boolean rectangleInside(Rectangle rectangle) {
        return pointInside(rectangle.P1) && pointInside(rectangle.P2);
    }
}
