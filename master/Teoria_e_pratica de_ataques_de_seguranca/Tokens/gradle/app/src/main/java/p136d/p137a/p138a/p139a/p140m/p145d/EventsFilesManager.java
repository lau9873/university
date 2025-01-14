package p136d.p137a.p138a.p139a.p140m.p145d;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p142b.CurrentTimeProvider;

/* renamed from: d.a.a.a.m.d.b */
/* loaded from: classes.dex */
public abstract class EventsFilesManager<T> {

    /* renamed from: a */
    public final Context f6561a;

    /* renamed from: b */
    public final EventTransform<T> f6562b;

    /* renamed from: c */
    public final CurrentTimeProvider f6563c;

    /* renamed from: d */
    public final EventsStorage f6564d;

    /* renamed from: e */
    public final int f6565e;

    /* renamed from: f */
    public final List<EventsStorageListener> f6566f = new CopyOnWriteArrayList();

    /* compiled from: EventsFilesManager.java */
    /* renamed from: d.a.a.a.m.d.b$a */
    /* loaded from: classes.dex */
    public class C1518a implements Comparator<C1519b> {
        public C1518a(EventsFilesManager eventsFilesManager) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(C1519b c1519b, C1519b c1519b2) {
            return (int) (c1519b.f6568b - c1519b2.f6568b);
        }
    }

    /* compiled from: EventsFilesManager.java */
    /* renamed from: d.a.a.a.m.d.b$b */
    /* loaded from: classes.dex */
    public static class C1519b {

        /* renamed from: a */
        public final File f6567a;

        /* renamed from: b */
        public final long f6568b;

        public C1519b(File file, long j) {
            this.f6567a = file;
            this.f6568b = j;
        }
    }

    public EventsFilesManager(Context context, EventTransform<T> eventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage, int i) {
        this.f6561a = context.getApplicationContext();
        this.f6562b = eventTransform;
        this.f6564d = eventsStorage;
        this.f6563c = currentTimeProvider;
        this.f6563c.mo4007a();
        this.f6565e = i;
    }

    /* renamed from: a */
    public void m3953a(T t) {
        byte[] mo3957a = this.f6562b.mo3957a(t);
        m3955a(mo3957a.length);
        this.f6564d.mo3931a(mo3957a);
    }

    /* renamed from: b */
    public final void m3949b(String str) {
        for (EventsStorageListener eventsStorageListener : this.f6566f) {
            try {
                eventsStorageListener.mo3942a(str);
            } catch (Exception e) {
                CommonUtils.m4107a(this.f6561a, "One of the roll over listeners threw an exception", e);
            }
        }
    }

    /* renamed from: c */
    public abstract String mo3948c();

    /* renamed from: d */
    public List<File> m3947d() {
        return this.f6564d.mo3937a(1);
    }

    /* renamed from: e */
    public int mo3946e() {
        return 8000;
    }

    /* renamed from: f */
    public int mo3945f() {
        return this.f6565e;
    }

    /* renamed from: g */
    public boolean m3944g() {
        String str;
        boolean z = true;
        if (this.f6564d.mo3930b()) {
            str = null;
            z = false;
        } else {
            str = mo3948c();
            this.f6564d.mo3933a(str);
            CommonUtils.m4110a(this.f6561a, 4, "Fabric", String.format(Locale.US, "generated new file %s", str));
            this.f6563c.mo4007a();
        }
        m3949b(str);
        return z;
    }

    /* renamed from: a */
    public void m3954a(EventsStorageListener eventsStorageListener) {
        if (eventsStorageListener != null) {
            this.f6566f.add(eventsStorageListener);
        }
    }

    /* renamed from: b */
    public void m3950b() {
        List<File> mo3929c = this.f6564d.mo3929c();
        int mo3945f = mo3945f();
        if (mo3929c.size() <= mo3945f) {
            return;
        }
        int size = mo3929c.size() - mo3945f;
        CommonUtils.m4082c(this.f6561a, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", Integer.valueOf(mo3929c.size()), Integer.valueOf(mo3945f), Integer.valueOf(size)));
        TreeSet treeSet = new TreeSet(new C1518a(this));
        for (File file : mo3929c) {
            treeSet.add(new C1519b(file, m3952a(file.getName())));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((C1519b) it.next()).f6567a);
            if (arrayList.size() == size) {
                break;
            }
        }
        this.f6564d.mo3932a(arrayList);
    }

    /* renamed from: a */
    public final void m3955a(int i) {
        if (this.f6564d.mo3936a(i, mo3946e())) {
            return;
        }
        CommonUtils.m4110a(this.f6561a, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", Integer.valueOf(this.f6564d.mo3938a()), Integer.valueOf(i), Integer.valueOf(mo3946e())));
        m3944g();
    }

    /* renamed from: a */
    public void m3951a(List<File> list) {
        this.f6564d.mo3932a(list);
    }

    /* renamed from: a */
    public void m3956a() {
        EventsStorage eventsStorage = this.f6564d;
        eventsStorage.mo3932a(eventsStorage.mo3929c());
        this.f6564d.mo3928d();
    }

    /* renamed from: a */
    public long m3952a(String str) {
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
