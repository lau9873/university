package p000a.p006b.p049h.p063k;

import android.os.Bundle;
import android.support.p067v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import p000a.p006b.p030g.p045k.AccessibilityDelegateCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;

/* renamed from: a.b.h.k.x0 */
/* loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* renamed from: c */
    public final RecyclerView f3000c;

    /* renamed from: d */
    public final AccessibilityDelegateCompat f3001d = new C0515a(this);

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.f3000c = recyclerView;
    }

    @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
    /* renamed from: a */
    public boolean mo7333a(View view, int i, Bundle bundle) {
        if (super.mo7333a(view, i, bundle)) {
            return true;
        }
        if (m7994c() || this.f3000c.getLayoutManager() == null) {
            return false;
        }
        return this.f3000c.getLayoutManager().m6703a(i, bundle);
    }

    @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
    /* renamed from: b */
    public void mo7331b(View view, AccessibilityEvent accessibilityEvent) {
        super.mo7331b(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if (!(view instanceof RecyclerView) || m7994c()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().mo6438a(accessibilityEvent);
        }
    }

    /* renamed from: c */
    public boolean m7994c() {
        return this.f3000c.m6857p();
    }

    @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
    /* renamed from: a */
    public void mo7332a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.mo7332a(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.m9554a((CharSequence) RecyclerView.class.getName());
        if (m7994c() || this.f3000c.getLayoutManager() == null) {
            return;
        }
        this.f3000c.getLayoutManager().m6699a(accessibilityNodeInfoCompat);
    }

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    /* renamed from: a.b.h.k.x0$a */
    /* loaded from: classes.dex */
    public static class C0515a extends AccessibilityDelegateCompat {

        /* renamed from: c */
        public final RecyclerViewAccessibilityDelegate f3002c;

        public C0515a(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f3002c = recyclerViewAccessibilityDelegate;
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public void mo7332a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo7332a(view, accessibilityNodeInfoCompat);
            if (this.f3002c.m7994c() || this.f3002c.f3000c.getLayoutManager() == null) {
                return;
            }
            this.f3002c.f3000c.getLayoutManager().m6673a(view, accessibilityNodeInfoCompat);
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public boolean mo7333a(View view, int i, Bundle bundle) {
            if (super.mo7333a(view, i, bundle)) {
                return true;
            }
            if (this.f3002c.m7994c() || this.f3002c.f3000c.getLayoutManager() == null) {
                return false;
            }
            return this.f3002c.f3000c.getLayoutManager().m6676a(view, i, bundle);
        }
    }

    /* renamed from: b */
    public AccessibilityDelegateCompat mo7995b() {
        return this.f3001d;
    }
}
