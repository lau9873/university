package d.a.a.a.m.c;
/* compiled from: Priority.java */
/* loaded from: classes.dex */
public enum f {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    public static <Y> int a(j jVar, Y y) {
        f fVar;
        if (y instanceof j) {
            fVar = ((j) y).a();
        } else {
            fVar = NORMAL;
        }
        return fVar.ordinal() - jVar.a().ordinal();
    }
}
