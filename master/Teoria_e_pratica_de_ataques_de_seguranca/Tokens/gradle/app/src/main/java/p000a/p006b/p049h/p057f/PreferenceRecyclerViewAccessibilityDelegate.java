package p000a.p006b.p049h.p057f;

import android.os.Bundle;
import android.support.p067v7.preference.Preference;
import android.support.p067v7.widget.RecyclerView;
import android.view.View;
import p000a.p006b.p030g.p045k.AccessibilityDelegateCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;
import p000a.p006b.p049h.p063k.RecyclerViewAccessibilityDelegate;

/* renamed from: a.b.h.f.k */
/* loaded from: classes.dex */
public class PreferenceRecyclerViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {

    /* renamed from: e */
    public final RecyclerView f2191e;

    /* renamed from: f */
    public final AccessibilityDelegateCompat f2192f;

    /* renamed from: g */
    public final AccessibilityDelegateCompat f2193g;

    public PreferenceRecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        super(recyclerView);
        this.f2192f = super.mo7995b();
        this.f2193g = new C0398a();
        this.f2191e = recyclerView;
    }

    @Override // p000a.p006b.p049h.p063k.RecyclerViewAccessibilityDelegate
    /* renamed from: b */
    public AccessibilityDelegateCompat mo7995b() {
        return this.f2193g;
    }

    /* compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
    /* renamed from: a.b.h.f.k$a */
    /* loaded from: classes.dex */
    public class C0398a extends AccessibilityDelegateCompat {
        public C0398a() {
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public void mo7332a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Preference m8847g;
            PreferenceRecyclerViewAccessibilityDelegate.this.f2192f.mo7332a(view, accessibilityNodeInfoCompat);
            int m6885e = PreferenceRecyclerViewAccessibilityDelegate.this.f2191e.m6885e(view);
            RecyclerView.AbstractC0711g adapter = PreferenceRecyclerViewAccessibilityDelegate.this.f2191e.getAdapter();
            if ((adapter instanceof PreferenceGroupAdapter) && (m8847g = ((PreferenceGroupAdapter) adapter).m8847g(m6885e)) != null) {
                m8847g.mo7193a(accessibilityNodeInfoCompat);
            }
        }

        @Override // p000a.p006b.p030g.p045k.AccessibilityDelegateCompat
        /* renamed from: a */
        public boolean mo7333a(View view, int i, Bundle bundle) {
            return PreferenceRecyclerViewAccessibilityDelegate.this.f2192f.mo7333a(view, i, bundle);
        }
    }
}
