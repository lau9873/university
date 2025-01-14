package a.b.h.j.j;

import a.b.h.j.j.p;
import a.b.h.j.j.q;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
/* compiled from: BaseMenuPresenter.java */
/* loaded from: classes.dex */
public abstract class b implements p {

    /* renamed from: a  reason: collision with root package name */
    public Context f1533a;

    /* renamed from: b  reason: collision with root package name */
    public Context f1534b;

    /* renamed from: c  reason: collision with root package name */
    public h f1535c;

    /* renamed from: d  reason: collision with root package name */
    public LayoutInflater f1536d;

    /* renamed from: e  reason: collision with root package name */
    public p.a f1537e;

    /* renamed from: f  reason: collision with root package name */
    public int f1538f;

    /* renamed from: g  reason: collision with root package name */
    public int f1539g;

    /* renamed from: h  reason: collision with root package name */
    public q f1540h;

    /* renamed from: i  reason: collision with root package name */
    public int f1541i;

    public b(Context context, int i2, int i3) {
        this.f1533a = context;
        this.f1536d = LayoutInflater.from(context);
        this.f1538f = i2;
        this.f1539g = i3;
    }

    public abstract void a(k kVar, q.a aVar);

    @Override // a.b.h.j.j.p
    public void a(Context context, h hVar) {
        this.f1534b = context;
        LayoutInflater.from(this.f1534b);
        this.f1535c = hVar;
    }

    public abstract boolean a(int i2, k kVar);

    @Override // a.b.h.j.j.p
    public boolean a(h hVar, k kVar) {
        return false;
    }

    public q b(ViewGroup viewGroup) {
        if (this.f1540h == null) {
            this.f1540h = (q) this.f1536d.inflate(this.f1538f, viewGroup, false);
            this.f1540h.a(this.f1535c);
            a(true);
        }
        return this.f1540h;
    }

    @Override // a.b.h.j.j.p
    public boolean b(h hVar, k kVar) {
        return false;
    }

    public p.a d() {
        return this.f1537e;
    }

    @Override // a.b.h.j.j.p
    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1540h;
        if (viewGroup == null) {
            return;
        }
        h hVar = this.f1535c;
        int i2 = 0;
        if (hVar != null) {
            hVar.b();
            ArrayList<k> n = this.f1535c.n();
            int size = n.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                k kVar = n.get(i4);
                if (a(i3, kVar)) {
                    View childAt = viewGroup.getChildAt(i3);
                    k itemData = childAt instanceof q.a ? ((q.a) childAt).getItemData() : null;
                    View a2 = a(kVar, childAt, viewGroup);
                    if (kVar != itemData) {
                        a2.setPressed(false);
                        a2.jumpDrawablesToCurrentState();
                    }
                    if (a2 != childAt) {
                        a(a2, i3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        while (i2 < viewGroup.getChildCount()) {
            if (!a(viewGroup, i2)) {
                i2++;
            }
        }
    }

    public void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1540h).addView(view, i2);
    }

    public boolean a(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    @Override // a.b.h.j.j.p
    public void a(p.a aVar) {
        this.f1537e = aVar;
    }

    public q.a a(ViewGroup viewGroup) {
        return (q.a) this.f1536d.inflate(this.f1539g, viewGroup, false);
    }

    public View a(k kVar, View view, ViewGroup viewGroup) {
        q.a a2;
        if (view instanceof q.a) {
            a2 = (q.a) view;
        } else {
            a2 = a(viewGroup);
        }
        a(kVar, a2);
        return (View) a2;
    }

    @Override // a.b.h.j.j.p
    public void a(h hVar, boolean z) {
        p.a aVar = this.f1537e;
        if (aVar != null) {
            aVar.a(hVar, z);
        }
    }

    @Override // a.b.h.j.j.p
    public boolean a(v vVar) {
        p.a aVar = this.f1537e;
        if (aVar != null) {
            return aVar.a(vVar);
        }
        return false;
    }

    @Override // a.b.h.j.j.p
    public int a() {
        return this.f1541i;
    }

    public void a(int i2) {
        this.f1541i = i2;
    }
}
