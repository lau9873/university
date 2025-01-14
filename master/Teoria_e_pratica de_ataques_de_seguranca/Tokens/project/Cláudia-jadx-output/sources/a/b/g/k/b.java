package a.b.g.k;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
/* compiled from: AccessibilityDelegateCompat.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final View.AccessibilityDelegate f1102b = new View.AccessibilityDelegate();

    /* renamed from: a  reason: collision with root package name */
    public final View.AccessibilityDelegate f1103a = new a(this);

    /* compiled from: AccessibilityDelegateCompat.java */
    /* loaded from: classes.dex */
    public static final class a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        public final b f1104a;

        public a(b bVar) {
            this.f1104a = bVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f1104a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            a.b.g.k.e0.d a2 = this.f1104a.a(view);
            if (a2 != null) {
                return (AccessibilityNodeProvider) a2.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1104a.b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f1104a.a(view, a.b.g.k.e0.c.a(accessibilityNodeInfo));
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1104a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f1104a.a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f1104a.a(view, i2, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i2) {
            this.f1104a.a(view, i2);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f1104a.d(view, accessibilityEvent);
        }
    }

    public View.AccessibilityDelegate a() {
        return this.f1103a;
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        f1102b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        f1102b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        f1102b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public void a(View view, int i2) {
        f1102b.sendAccessibilityEvent(view, i2);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return f1102b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, a.b.g.k.e0.c cVar) {
        f1102b.onInitializeAccessibilityNodeInfo(view, cVar.s());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f1102b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public a.b.g.k.e0.d a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = f1102b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new a.b.g.k.e0.d(accessibilityNodeProvider);
    }

    public boolean a(View view, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return f1102b.performAccessibilityAction(view, i2, bundle);
        }
        return false;
    }
}
