package c.d.b;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a  reason: collision with root package name */
    public static final r f3737a = new a("DEFAULT", 0);

    /* renamed from: b  reason: collision with root package name */
    public static final r f3738b = new r("STRING", 1) { // from class: c.d.b.r.b
    };

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ r[] f3739c = {f3737a, f3738b};

    /* compiled from: LongSerializationPolicy.java */
    /* loaded from: classes.dex */
    public enum a extends r {
        public a(String str, int i2) {
            super(str, i2, null);
        }
    }

    public r(String str, int i2) {
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f3739c.clone();
    }

    public /* synthetic */ r(String str, int i2, a aVar) {
        this(str, i2);
    }
}
