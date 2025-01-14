package defpackage;
/* compiled from: TestRectangle.java */
/* renamed from: Point  reason: default package */
/* loaded from: Point.class */
class Point {
    int x;
    int y;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point() {
        this.y = 0;
        this.x = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point(int i2, int i3) {
        this.x = i2;
        this.y = i3;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
