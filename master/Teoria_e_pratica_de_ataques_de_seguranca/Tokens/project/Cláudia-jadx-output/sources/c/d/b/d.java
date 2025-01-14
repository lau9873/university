package c.d.b;

import java.lang.reflect.Field;
import java.util.Locale;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* loaded from: classes.dex */
public abstract class d implements c.d.b.e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f3704a = new a("IDENTITY", 0);

    /* renamed from: b  reason: collision with root package name */
    public static final d f3705b = new d("UPPER_CAMEL_CASE", 1) { // from class: c.d.b.d.b
        @Override // c.d.b.e
        public String a(Field field) {
            return d.a(field.getName());
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final d f3706c = new d("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: c.d.b.d.c
        @Override // c.d.b.e
        public String a(Field field) {
            return d.a(d.a(field.getName(), " "));
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final d f3707d = new d("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: c.d.b.d.d
        @Override // c.d.b.e
        public String a(Field field) {
            return d.a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final d f3708e = new d("LOWER_CASE_WITH_DASHES", 4) { // from class: c.d.b.d.e
        @Override // c.d.b.e
        public String a(Field field) {
            return d.a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final d f3709f = new d("LOWER_CASE_WITH_DOTS", 5) { // from class: c.d.b.d.f
        @Override // c.d.b.e
        public String a(Field field) {
            return d.a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ d[] f3710g = {f3704a, f3705b, f3706c, f3707d, f3708e, f3709f};

    /* compiled from: FieldNamingPolicy.java */
    /* loaded from: classes.dex */
    public enum a extends d {
        public a(String str, int i2) {
            super(str, i2, null);
        }

        @Override // c.d.b.e
        public String a(Field field) {
            return field.getName();
        }
    }

    public d(String str, int i2) {
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f3710g.clone();
    }

    public /* synthetic */ d(String str, int i2, a aVar) {
        this(str, i2);
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i2 < length - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i2++;
            charAt = str.charAt(i2);
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(a(Character.toUpperCase(charAt), str, i2 + 1));
        return sb.toString();
    }

    public static String a(char c2, String str, int i2) {
        if (i2 < str.length()) {
            return c2 + str.substring(i2);
        }
        return String.valueOf(c2);
    }
}
