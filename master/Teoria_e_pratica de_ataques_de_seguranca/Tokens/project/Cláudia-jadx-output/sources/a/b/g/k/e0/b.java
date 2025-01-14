package a.b.g.k.e0;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
/* compiled from: AccessibilityManagerCompat.java */
/* loaded from: classes.dex */
public final class b {

    /* compiled from: AccessibilityManagerCompat.java */
    /* loaded from: classes.dex */
    public interface a {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* compiled from: AccessibilityManagerCompat.java */
    /* renamed from: a.b.g.k.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0033b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final a f1111a;

        public accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0033b(a aVar) {
            this.f1111a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0033b.class != obj.getClass()) {
                return false;
            }
            return this.f1111a.equals(((accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0033b) obj).f1111a);
        }

        public int hashCode() {
            return this.f1111a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.f1111a.onTouchExplorationStateChanged(z);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0033b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new accessibility.AccessibilityManager$TouchExplorationStateChangeListenerC0033b(aVar));
    }
}
