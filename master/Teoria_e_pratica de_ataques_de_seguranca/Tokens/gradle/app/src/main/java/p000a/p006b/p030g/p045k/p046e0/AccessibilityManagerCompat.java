package p000a.p006b.p030g.p045k.p046e0;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

/* renamed from: a.b.g.k.e0.b */
/* loaded from: classes.dex */
public final class AccessibilityManagerCompat {

    /* compiled from: AccessibilityManagerCompat.java */
    /* renamed from: a.b.g.k.e0.b$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0282a {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* compiled from: AccessibilityManagerCompat.java */
    /* renamed from: a.b.g.k.e0.b$b  reason: invalid class name */
    /* loaded from: classes.dex */
    public static class accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0283b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a */
        public final InterfaceC0282a f1622a;

        public accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0283b(InterfaceC0282a interfaceC0282a) {
            this.f1622a = interfaceC0282a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0283b.class != obj.getClass()) {
                return false;
            }
            return this.f1622a.equals(((accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0283b) obj).f1622a);
        }

        public int hashCode() {
            return this.f1622a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.f1622a.onTouchExplorationStateChanged(z);
        }
    }

    /* renamed from: a */
    public static boolean m9561a(AccessibilityManager accessibilityManager, InterfaceC0282a interfaceC0282a) {
        if (Build.VERSION.SDK_INT < 19 || interfaceC0282a == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0283b(interfaceC0282a));
    }

    /* renamed from: b */
    public static boolean m9560b(AccessibilityManager accessibilityManager, InterfaceC0282a interfaceC0282a) {
        if (Build.VERSION.SDK_INT < 19 || interfaceC0282a == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0283b(interfaceC0282a));
    }
}
