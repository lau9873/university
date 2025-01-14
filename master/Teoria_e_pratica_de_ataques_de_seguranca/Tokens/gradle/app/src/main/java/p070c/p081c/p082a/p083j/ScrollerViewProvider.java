package p070c.p081c.p082a.p083j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.futuremind.recyclerviewfastscroll.FastScroller;

/* renamed from: c.c.a.j.c */
/* loaded from: classes.dex */
public abstract class ScrollerViewProvider {

    /* renamed from: a */
    public FastScroller f5028a;

    /* renamed from: b */
    public ViewBehavior f5029b;

    /* renamed from: c */
    public ViewBehavior f5030c;

    /* renamed from: a */
    public abstract View mo5678a(ViewGroup viewGroup);

    /* renamed from: a */
    public void m5677a(FastScroller fastScroller) {
        this.f5028a = fastScroller;
    }

    /* renamed from: b */
    public abstract int mo5676b();

    /* renamed from: b */
    public abstract View mo5675b(ViewGroup viewGroup);

    /* renamed from: c */
    public Context m5674c() {
        return this.f5028a.getContext();
    }

    /* renamed from: d */
    public ViewBehavior m5673d() {
        if (this.f5029b == null) {
            this.f5029b = mo5665l();
        }
        return this.f5029b;
    }

    /* renamed from: e */
    public FastScroller m5672e() {
        return this.f5028a;
    }

    /* renamed from: f */
    public void m5671f() {
        if (m5673d() != null) {
            m5673d().mo5661d();
        }
        if (m5679a() != null) {
            m5679a().mo5661d();
        }
    }

    /* renamed from: g */
    public void m5670g() {
        if (m5673d() != null) {
            m5673d().mo5664a();
        }
        if (m5679a() != null) {
            m5679a().mo5664a();
        }
    }

    /* renamed from: h */
    public void m5669h() {
        if (m5673d() != null) {
            m5673d().mo5662c();
        }
        if (m5679a() != null) {
            m5679a().mo5662c();
        }
    }

    /* renamed from: i */
    public void m5668i() {
        if (m5673d() != null) {
            m5673d().mo5663b();
        }
        if (m5679a() != null) {
            m5679a().mo5663b();
        }
    }

    /* renamed from: j */
    public abstract ViewBehavior mo5667j();

    /* renamed from: k */
    public abstract TextView mo5666k();

    /* renamed from: l */
    public abstract ViewBehavior mo5665l();

    /* renamed from: a */
    public ViewBehavior m5679a() {
        if (this.f5030c == null) {
            this.f5030c = mo5667j();
        }
        return this.f5030c;
    }
}
