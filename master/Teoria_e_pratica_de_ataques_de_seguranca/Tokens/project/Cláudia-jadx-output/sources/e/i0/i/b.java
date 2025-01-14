package e.i0.i;
/* compiled from: Header.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: d  reason: collision with root package name */
    public static final f.f f5675d = f.f.c(":");

    /* renamed from: e  reason: collision with root package name */
    public static final f.f f5676e = f.f.c(":status");

    /* renamed from: f  reason: collision with root package name */
    public static final f.f f5677f = f.f.c(":method");

    /* renamed from: g  reason: collision with root package name */
    public static final f.f f5678g = f.f.c(":path");

    /* renamed from: h  reason: collision with root package name */
    public static final f.f f5679h = f.f.c(":scheme");

    /* renamed from: i  reason: collision with root package name */
    public static final f.f f5680i = f.f.c(":authority");

    /* renamed from: a  reason: collision with root package name */
    public final f.f f5681a;

    /* renamed from: b  reason: collision with root package name */
    public final f.f f5682b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5683c;

    public b(String str, String str2) {
        this(f.f.c(str), f.f.c(str2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f5681a.equals(bVar.f5681a) && this.f5682b.equals(bVar.f5682b);
        }
        return false;
    }

    public int hashCode() {
        return ((527 + this.f5681a.hashCode()) * 31) + this.f5682b.hashCode();
    }

    public String toString() {
        return e.i0.c.a("%s: %s", this.f5681a.i(), this.f5682b.i());
    }

    public b(f.f fVar, String str) {
        this(fVar, f.f.c(str));
    }

    public b(f.f fVar, f.f fVar2) {
        this.f5681a = fVar;
        this.f5682b = fVar2;
        this.f5683c = fVar.f() + 32 + fVar2.f();
    }
}
