package p070c.p084d.p105b;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: c.d.b.d */
/* loaded from: classes.dex */
public abstract class FieldNamingPolicy implements FieldNamingStrategy {

    /* renamed from: a */
    public static final FieldNamingPolicy f5647a = new C1250a("IDENTITY", 0);

    /* renamed from: b */
    public static final FieldNamingPolicy f5648b = new FieldNamingPolicy("UPPER_CAMEL_CASE", 1) { // from class: c.d.b.d.b
        @Override // p070c.p084d.p105b.FieldNamingStrategy
        /* renamed from: a */
        public String mo4947a(Field field) {
            return FieldNamingPolicy.m4949a(field.getName());
        }
    };

    /* renamed from: c */
    public static final FieldNamingPolicy f5649c = new FieldNamingPolicy("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: c.d.b.d.c
        @Override // p070c.p084d.p105b.FieldNamingStrategy
        /* renamed from: a */
        public String mo4947a(Field field) {
            return FieldNamingPolicy.m4949a(FieldNamingPolicy.m4948a(field.getName(), " "));
        }
    };

    /* renamed from: d */
    public static final FieldNamingPolicy f5650d = new FieldNamingPolicy("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: c.d.b.d.d
        @Override // p070c.p084d.p105b.FieldNamingStrategy
        /* renamed from: a */
        public String mo4947a(Field field) {
            return FieldNamingPolicy.m4948a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: e */
    public static final FieldNamingPolicy f5651e = new FieldNamingPolicy("LOWER_CASE_WITH_DASHES", 4) { // from class: c.d.b.d.e
        @Override // p070c.p084d.p105b.FieldNamingStrategy
        /* renamed from: a */
        public String mo4947a(Field field) {
            return FieldNamingPolicy.m4948a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: f */
    public static final FieldNamingPolicy f5652f = new FieldNamingPolicy("LOWER_CASE_WITH_DOTS", 5) { // from class: c.d.b.d.f
        @Override // p070c.p084d.p105b.FieldNamingStrategy
        /* renamed from: a */
        public String mo4947a(Field field) {
            return FieldNamingPolicy.m4948a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: g */
    public static final /* synthetic */ FieldNamingPolicy[] f5653g = {f5647a, f5648b, f5649c, f5650d, f5651e, f5652f};

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: c.d.b.d$a */
    /* loaded from: classes.dex */
    public enum C1250a extends FieldNamingPolicy {
        public C1250a(String str, int i) {
            super(str, i, null);
        }

        @Override // p070c.p084d.p105b.FieldNamingStrategy
        /* renamed from: a */
        public String mo4947a(Field field) {
            return field.getName();
        }
    }

    public FieldNamingPolicy(String str, int i) {
    }

    /* renamed from: a */
    public static String m4948a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) f5653g.clone();
    }

    public /* synthetic */ FieldNamingPolicy(String str, int i, C1250a c1250a) {
        this(str, i);
    }

    /* renamed from: a */
    public static String m4949a(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i < length - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i++;
            charAt = str.charAt(i);
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(m4950a(Character.toUpperCase(charAt), str, i + 1));
        return sb.toString();
    }

    /* renamed from: a */
    public static String m4950a(char c, String str, int i) {
        if (i < str.length()) {
            return c + str.substring(i);
        }
        return String.valueOf(c);
    }
}
