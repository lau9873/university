package d.a.a.a.m.d;

import android.content.Context;
import d.a.a.a.m.b.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: EventsFilesManager.java */
/* loaded from: classes.dex */
public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4357a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.a.m.d.a<T> f4358b;

    /* renamed from: c  reason: collision with root package name */
    public final k f4359c;

    /* renamed from: d  reason: collision with root package name */
    public final c f4360d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4361e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d> f4362f = new CopyOnWriteArrayList();

    /* compiled from: EventsFilesManager.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<C0091b> {
        public a(b bVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C0091b c0091b, C0091b c0091b2) {
            return (int) (c0091b.f4364b - c0091b2.f4364b);
        }
    }

    /* compiled from: EventsFilesManager.java */
    /* renamed from: d.a.a.a.m.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0091b {

        /* renamed from: a  reason: collision with root package name */
        public final File f4363a;

        /* renamed from: b  reason: collision with root package name */
        public final long f4364b;

        public C0091b(File file, long j) {
            this.f4363a = file;
            this.f4364b = j;
        }
    }

    public b(Context context, d.a.a.a.m.d.a<T> aVar, k kVar, c cVar, int i2) {
        this.f4357a = context.getApplicationContext();
        this.f4358b = aVar;
        this.f4360d = cVar;
        this.f4359c = kVar;
        this.f4359c.a();
        this.f4361e = i2;
    }

    public void a(T t) {
        byte[] a2 = this.f4358b.a(t);
        a(a2.length);
        this.f4360d.a(a2);
    }

    public final void b(String str) {
        for (d dVar : this.f4362f) {
            try {
                dVar.a(str);
            } catch (Exception e2) {
                d.a.a.a.m.b.i.a(this.f4357a, "One of the roll over listeners threw an exception", e2);
            }
        }
    }

    public abstract String c();

    public List<File> d() {
        return this.f4360d.a(1);
    }

    public int e() {
        return 8000;
    }

    public int f() {
        return this.f4361e;
    }

    public boolean g() {
        String str;
        boolean z = true;
        if (this.f4360d.b()) {
            str = null;
            z = false;
        } else {
            str = c();
            this.f4360d.a(str);
            d.a.a.a.m.b.i.a(this.f4357a, 4, "Fabric", String.format(Locale.US, "generated new file %s", str));
            this.f4359c.a();
        }
        b(str);
        return z;
    }

    public void a(d dVar) {
        if (dVar != null) {
            this.f4362f.add(dVar);
        }
    }

    public void b() {
        List<File> c2 = this.f4360d.c();
        int f2 = f();
        if (c2.size() <= f2) {
            return;
        }
        int size = c2.size() - f2;
        d.a.a.a.m.b.i.c(this.f4357a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", Integer.valueOf(c2.size()), Integer.valueOf(f2), Integer.valueOf(size)));
        TreeSet treeSet = new TreeSet(new a(this));
        for (File file : c2) {
            treeSet.add(new C0091b(file, a(file.getName())));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((C0091b) it.next()).f4363a);
            if (arrayList.size() == size) {
                break;
            }
        }
        this.f4360d.a(arrayList);
    }

    public final void a(int i2) {
        if (this.f4360d.a(i2, e())) {
            return;
        }
        d.a.a.a.m.b.i.a(this.f4357a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", Integer.valueOf(this.f4360d.a()), Integer.valueOf(i2), Integer.valueOf(e())));
        g();
    }

    public void a(List<File> list) {
        this.f4360d.a(list);
    }

    public void a() {
        c cVar = this.f4360d;
        cVar.a(cVar.c());
        this.f4360d.d();
    }

    public long a(String str) {
        String[] split = str.split("_");
        if (split.length != 3) {
            return 0L;
        }
        try {
            return Long.valueOf(split[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}
