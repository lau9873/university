package p000a.p006b.p030g.p045k;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeInfoCompat;
import p000a.p006b.p030g.p045k.p046e0.AccessibilityNodeProviderCompat;

/* renamed from: a.b.g.k.b */
/* loaded from: classes.dex */
public class AccessibilityDelegateCompat {

    /* renamed from: b */
    public static final View.AccessibilityDelegate f1613b = new View.AccessibilityDelegate();

    /* renamed from: a */
    public final View.AccessibilityDelegate f1614a = new C0278a(this);

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: a.b.g.k.b$a */
    /* loaded from: classes.dex */
    public static final class C0278a extends View.AccessibilityDelegate {

        /* renamed from: a */
        public final AccessibilityDelegateCompat f1615a;

        public C0278a(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.f1615a = accessibilityDelegateCompat;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f1615a.m9584a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProviderCompat m9586a = this.f1615a.m9586a(view);
            if (m9586a != null) {
                return (AccessibilityNodeProvider) m9586a.m9515a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1615a.mo7331b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f1615a.mo7332a(view, AccessibilityNodeInfoCompat.m9555a(accessibilityNodeInfo));
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1615a.mo7557c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f1615a.m9583a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f1615a.mo7333a(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f1615a.m9585a(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f1615a.m9582d(view, accessibilityEvent);
        }
    }

    /* renamed from: a */
    public View.AccessibilityDelegate m9587a() {
        return this.f1614a;
    }

    /* renamed from: b */
    public void mo7331b(View view, AccessibilityEvent accessibilityEvent) {
        f1613b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: c */
    public void mo7557c(View view, AccessibilityEvent accessibilityEvent) {
        f1613b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: d */
    public void m9582d(View view, AccessibilityEvent accessibilityEvent) {
        f1613b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    /* renamed from: a */
    public void m9585a(View view, int i) {
        f1613b.sendAccessibilityEvent(view, i);
    }

    /* renamed from: a */
    public boolean m9584a(View view, AccessibilityEvent accessibilityEvent) {
        return f1613b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* renamed from: a */
    public void mo7332a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        f1613b.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.m9523s());
    }

    /* renamed from: a */
    public boolean m9583a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f1613b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* renamed from: a */
    public AccessibilityNodeProviderCompat m9586a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = f1613b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
    }

    /* renamed from: a */
    public boolean mo7333a(View view, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return f1613b.performAccessibilityAction(view, i, bundle);
        }
        return false;
    }
}
