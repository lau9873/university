package g.a.a.n;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* compiled from: Stats.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: g  reason: collision with root package name */
    public static final q f6171g = new q();

    /* renamed from: h  reason: collision with root package name */
    public static final SimpleDateFormat f6172h = new SimpleDateFormat("HH:mm:ss.SSS");

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f6173a;

    /* renamed from: b  reason: collision with root package name */
    public long f6174b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6175c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6176d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6177e;

    /* renamed from: f  reason: collision with root package name */
    public a f6178f;

    /* compiled from: Stats.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f6179a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f6180b;

        /* renamed from: c  reason: collision with root package name */
        public Date f6181c;

        /* renamed from: d  reason: collision with root package name */
        public Date f6182d;

        /* renamed from: e  reason: collision with root package name */
        public Date f6183e;

        /* renamed from: f  reason: collision with root package name */
        public Date f6184f;
    }

    public q() {
        a();
    }

    public static q f() {
        return f6171g;
    }

    public void a(g.a.a.c cVar) {
        e();
        a aVar = this.f6178f;
        aVar.f6179a++;
        if (aVar.f6181c == null) {
            aVar.f6181c = new Date();
        }
        if (this.f6178f.f6182d != null) {
            long time = new Date().getTime() - this.f6178f.f6182d.getTime();
            a aVar2 = this.f6178f;
            if (time > aVar2.f6180b) {
                aVar2.f6180b = time;
            }
        }
        this.f6178f.f6182d = new Date();
    }

    public boolean b() {
        return this.f6177e;
    }

    public final void c() {
        boolean z = true;
        g.a.a.m.d.a("Stats", "--- Stats for %s samples", Integer.valueOf(this.f6173a.size()));
        Iterator<a> it = this.f6173a.iterator();
        while (it.hasNext()) {
            a(it.next(), z);
            z = false;
        }
    }

    public void d() {
        Date date = new Date();
        a aVar = this.f6178f;
        if (aVar != null) {
            date = new Date(aVar.f6183e.getTime() + this.f6174b);
            a aVar2 = this.f6178f;
            aVar2.f6184f = date;
            if (!this.f6176d && this.f6175c) {
                a(aVar2, true);
            }
        }
        this.f6178f = new a();
        a aVar3 = this.f6178f;
        aVar3.f6183e = date;
        this.f6173a.add(aVar3);
        if (this.f6176d) {
            c();
        }
    }

    public final void e() {
        if (this.f6178f == null || (this.f6174b > 0 && new Date().getTime() - this.f6178f.f6183e.getTime() >= this.f6174b)) {
            d();
        }
    }

    public void a() {
        this.f6173a = new ArrayList<>();
        d();
    }

    public final void a(a aVar, boolean z) {
        if (z) {
            g.a.a.m.d.a("Stats", "sample start time, sample stop time, first detection time, last detection time, max millis between detections, detection count", new Object[0]);
        }
        g.a.a.m.d.a("Stats", "%s, %s, %s, %s, %s, %s", a(aVar.f6183e), a(aVar.f6184f), a(aVar.f6181c), a(aVar.f6182d), Long.valueOf(aVar.f6180b), Long.valueOf(aVar.f6179a));
    }

    public final String a(Date date) {
        String format;
        if (date != null) {
            synchronized (f6172h) {
                format = f6172h.format(date);
            }
            return format;
        }
        return "";
    }
}
