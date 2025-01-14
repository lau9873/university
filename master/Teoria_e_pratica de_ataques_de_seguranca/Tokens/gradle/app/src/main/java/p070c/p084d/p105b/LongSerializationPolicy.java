package p070c.p084d.p105b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: c.d.b.r */
/* loaded from: classes.dex */
public abstract class LongSerializationPolicy {

    /* renamed from: a */
    public static final LongSerializationPolicy f5689a = new C1262a("DEFAULT", 0);

    /* renamed from: b */
    public static final LongSerializationPolicy f5690b = new LongSerializationPolicy("STRING", 1) { // from class: c.d.b.r.b
    };

    /* renamed from: c */
    public static final /* synthetic */ LongSerializationPolicy[] f5691c = {f5689a, f5690b};

    /* compiled from: LongSerializationPolicy.java */
    /* renamed from: c.d.b.r$a */
    /* loaded from: classes.dex */
    public enum C1262a extends LongSerializationPolicy {
        public C1262a(String str, int i) {
            super(str, i, null);
        }
    }

    public LongSerializationPolicy(String str, int i) {
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) f5691c.clone();
    }

    public /* synthetic */ LongSerializationPolicy(String str, int i, C1262a c1262a) {
        this(str, i);
    }
}
