package a.b.g.g;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;
/* compiled from: LocaleListCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final f f958a;

    /* compiled from: LocaleListCompat.java */
    /* loaded from: classes.dex */
    public static class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public LocaleList f959a = new LocaleList(new Locale[0]);

        @Override // a.b.g.g.f
        public void a(Locale... localeArr) {
            this.f959a = new LocaleList(localeArr);
        }

        @Override // a.b.g.g.f
        public boolean equals(Object obj) {
            return this.f959a.equals(((d) obj).a());
        }

        @Override // a.b.g.g.f
        public Locale get(int i2) {
            return this.f959a.get(i2);
        }

        @Override // a.b.g.g.f
        public int hashCode() {
            return this.f959a.hashCode();
        }

        @Override // a.b.g.g.f
        public String toString() {
            return this.f959a.toString();
        }

        @Override // a.b.g.g.f
        public Object a() {
            return this.f959a;
        }
    }

    /* compiled from: LocaleListCompat.java */
    /* loaded from: classes.dex */
    public static class b implements f {

        /* renamed from: a  reason: collision with root package name */
        public e f960a = new e(new Locale[0]);

        @Override // a.b.g.g.f
        public void a(Locale... localeArr) {
            this.f960a = new e(localeArr);
        }

        @Override // a.b.g.g.f
        public boolean equals(Object obj) {
            return this.f960a.equals(((d) obj).a());
        }

        @Override // a.b.g.g.f
        public Locale get(int i2) {
            return this.f960a.a(i2);
        }

        @Override // a.b.g.g.f
        public int hashCode() {
            return this.f960a.hashCode();
        }

        @Override // a.b.g.g.f
        public String toString() {
            return this.f960a.toString();
        }

        @Override // a.b.g.g.f
        public Object a() {
            return this.f960a;
        }
    }

    static {
        new d();
        if (Build.VERSION.SDK_INT >= 24) {
            f958a = new a();
        } else {
            f958a = new b();
        }
    }

    public static d a(Object obj) {
        d dVar = new d();
        if (obj instanceof LocaleList) {
            dVar.a((LocaleList) obj);
        }
        return dVar;
    }

    public static d b(Locale... localeArr) {
        d dVar = new d();
        dVar.a(localeArr);
        return dVar;
    }

    public boolean equals(Object obj) {
        return f958a.equals(obj);
    }

    public int hashCode() {
        return f958a.hashCode();
    }

    public String toString() {
        return f958a.toString();
    }

    public Object a() {
        return f958a.a();
    }

    public Locale a(int i2) {
        return f958a.get(i2);
    }

    public final void a(LocaleList localeList) {
        int size = localeList.size();
        if (size > 0) {
            Locale[] localeArr = new Locale[size];
            for (int i2 = 0; i2 < size; i2++) {
                localeArr[i2] = localeList.get(i2);
            }
            f958a.a(localeArr);
        }
    }

    public final void a(Locale... localeArr) {
        f958a.a(localeArr);
    }
}
