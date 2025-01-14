package c.c.a.j;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.futuremind.recyclerviewfastscroll.FastScroller;
/* compiled from: ScrollerViewProvider.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public FastScroller f3190a;

    /* renamed from: b  reason: collision with root package name */
    public d f3191b;

    /* renamed from: c  reason: collision with root package name */
    public d f3192c;

    public abstract View a(ViewGroup viewGroup);

    public void a(FastScroller fastScroller) {
        this.f3190a = fastScroller;
    }

    public abstract int b();

    public abstract View b(ViewGroup viewGroup);

    public Context c() {
        return this.f3190a.getContext();
    }

    public d d() {
        if (this.f3191b == null) {
            this.f3191b = l();
        }
        return this.f3191b;
    }

    public FastScroller e() {
        return this.f3190a;
    }

    public void f() {
        if (d() != null) {
            d().d();
        }
        if (a() != null) {
            a().d();
        }
    }

    public void g() {
        if (d() != null) {
            d().a();
        }
        if (a() != null) {
            a().a();
        }
    }

    public void h() {
        if (d() != null) {
            d().c();
        }
        if (a() != null) {
            a().c();
        }
    }

    public void i() {
        if (d() != null) {
            d().b();
        }
        if (a() != null) {
            a().b();
        }
    }

    public abstract d j();

    public abstract TextView k();

    public abstract d l();

    public d a() {
        if (this.f3192c == null) {
            this.f3192c = j();
        }
        return this.f3192c;
    }
}
