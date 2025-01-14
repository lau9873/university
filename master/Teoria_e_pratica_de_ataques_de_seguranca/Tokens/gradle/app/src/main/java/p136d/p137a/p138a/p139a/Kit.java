package p136d.p137a.p138a.p139a;

import android.content.Context;
import java.io.File;
import java.util.Collection;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;
import p136d.p137a.p138a.p139a.p140m.p143c.DependsOn;
import p136d.p137a.p138a.p139a.p140m.p143c.Task;

/* renamed from: d.a.a.a.h */
/* loaded from: classes.dex */
public abstract class Kit<Result> implements Comparable<Kit> {

    /* renamed from: a */
    public Fabric f6395a;

    /* renamed from: c */
    public Context f6397c;

    /* renamed from: d */
    public InitializationCallback<Result> f6398d;

    /* renamed from: e */
    public IdManager f6399e;

    /* renamed from: b */
    public InitializationTask<Result> f6396b = new InitializationTask<>(this);

    /* renamed from: f */
    public final DependsOn f6400f = (DependsOn) getClass().getAnnotation(DependsOn.class);

    /* renamed from: a */
    public void m4183a(Context context, Fabric fabric, InitializationCallback<Result> initializationCallback, IdManager idManager) {
        this.f6395a = fabric;
        this.f6397c = new FabricContext(context, mo4149i(), m4174j());
        this.f6398d = initializationCallback;
        this.f6399e = idManager;
    }

    /* renamed from: a */
    public void m4181a(Result result) {
    }

    /* renamed from: b */
    public void m4179b(Result result) {
    }

    /* renamed from: b */
    public boolean m4180b(Kit kit) {
        if (m4173l()) {
            for (Class<?> cls : this.f6400f.value()) {
                if (cls.isAssignableFrom(kit.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    public abstract Result mo4150d();

    /* renamed from: e */
    public Context m4178e() {
        return this.f6397c;
    }

    /* renamed from: f */
    public Collection<Task> m4177f() {
        return this.f6396b.mo3967d();
    }

    /* renamed from: g */
    public Fabric m4176g() {
        return this.f6395a;
    }

    /* renamed from: h */
    public IdManager m4175h() {
        return this.f6399e;
    }

    /* renamed from: i */
    public abstract String mo4149i();

    /* renamed from: j */
    public String m4174j() {
        return ".Fabric" + File.separator + mo4149i();
    }

    /* renamed from: k */
    public abstract String mo4148k();

    /* renamed from: l */
    public boolean m4173l() {
        return this.f6400f != null;
    }

    /* renamed from: m */
    public final void m4172m() {
        this.f6396b.m3978a(this.f6395a.m4204c(), (Object[]) new Void[]{null});
    }

    /* renamed from: n */
    public boolean mo4147n() {
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Kit kit) {
        if (m4180b(kit)) {
            return 1;
        }
        if (kit.m4180b((Kit) this)) {
            return -1;
        }
        if (!m4173l() || kit.m4173l()) {
            return (m4173l() || !kit.m4173l()) ? 0 : -1;
        }
        return 1;
    }
}
