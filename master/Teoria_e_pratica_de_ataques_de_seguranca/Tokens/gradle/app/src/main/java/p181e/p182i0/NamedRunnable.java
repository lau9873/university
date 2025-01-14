package p181e.p182i0;

/* renamed from: e.i0.b */
/* loaded from: classes.dex */
public abstract class NamedRunnable implements Runnable {

    /* renamed from: a */
    public final String f7933a;

    public NamedRunnable(String str, Object... objArr) {
        this.f7933a = Util.m3161a(str, objArr);
    }

    /* renamed from: b */
    public abstract void mo2965b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f7933a);
        try {
            mo2965b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
