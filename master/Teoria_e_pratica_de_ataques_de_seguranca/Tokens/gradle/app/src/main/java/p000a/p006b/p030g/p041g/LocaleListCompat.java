package p000a.p006b.p030g.p041g;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* renamed from: a.b.g.g.d */
/* loaded from: classes.dex */
public final class LocaleListCompat {

    /* renamed from: a */
    public static final LocaleListInterface f1468a;

    /* compiled from: LocaleListCompat.java */
    /* renamed from: a.b.g.g.d$a */
    /* loaded from: classes.dex */
    public static class C0241a implements LocaleListInterface {

        /* renamed from: a */
        public LocaleList f1469a = new LocaleList(new Locale[0]);

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        /* renamed from: a */
        public void mo9739a(Locale... localeArr) {
            this.f1469a = new LocaleList(localeArr);
        }

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        public boolean equals(Object obj) {
            return this.f1469a.equals(((LocaleListCompat) obj).m9747a());
        }

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        public Locale get(int i) {
            return this.f1469a.get(i);
        }

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        public int hashCode() {
            return this.f1469a.hashCode();
        }

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        public String toString() {
            return this.f1469a.toString();
        }

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        /* renamed from: a */
        public Object mo9740a() {
            return this.f1469a;
        }
    }

    /* compiled from: LocaleListCompat.java */
    /* renamed from: a.b.g.g.d$b */
    /* loaded from: classes.dex */
    public static class C0242b implements LocaleListInterface {

        /* renamed from: a */
        public LocaleListHelper f1470a = new LocaleListHelper(new Locale[0]);

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        /* renamed from: a */
        public void mo9739a(Locale... localeArr) {
            this.f1470a = new LocaleListHelper(localeArr);
        }

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        public boolean equals(Object obj) {
            return this.f1470a.equals(((LocaleListCompat) obj).m9747a());
        }

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        public Locale get(int i) {
            return this.f1470a.m9741a(i);
        }

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        public int hashCode() {
            return this.f1470a.hashCode();
        }

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        public String toString() {
            return this.f1470a.toString();
        }

        @Override // p000a.p006b.p030g.p041g.LocaleListInterface
        /* renamed from: a */
        public Object mo9740a() {
            return this.f1470a;
        }
    }

    static {
        new LocaleListCompat();
        if (Build.VERSION.SDK_INT >= 24) {
            f1468a = new C0241a();
        } else {
            f1468a = new C0242b();
        }
    }

    /* renamed from: a */
    public static LocaleListCompat m9744a(Object obj) {
        LocaleListCompat localeListCompat = new LocaleListCompat();
        if (obj instanceof LocaleList) {
            localeListCompat.m9745a((LocaleList) obj);
        }
        return localeListCompat;
    }

    /* renamed from: b */
    public static LocaleListCompat m9742b(Locale... localeArr) {
        LocaleListCompat localeListCompat = new LocaleListCompat();
        localeListCompat.m9743a(localeArr);
        return localeListCompat;
    }

    public boolean equals(Object obj) {
        return f1468a.equals(obj);
    }

    public int hashCode() {
        return f1468a.hashCode();
    }

    public String toString() {
        return f1468a.toString();
    }

    /* renamed from: a */
    public Object m9747a() {
        return f1468a.mo9740a();
    }

    /* renamed from: a */
    public Locale m9746a(int i) {
        return f1468a.get(i);
    }

    /* renamed from: a */
    public final void m9745a(LocaleList localeList) {
        int size = localeList.size();
        if (size > 0) {
            Locale[] localeArr = new Locale[size];
            for (int i = 0; i < size; i++) {
                localeArr[i] = localeList.get(i);
            }
            f1468a.mo9739a(localeArr);
        }
    }

    /* renamed from: a */
    public final void m9743a(Locale... localeArr) {
        f1468a.mo9739a(localeArr);
    }
}
