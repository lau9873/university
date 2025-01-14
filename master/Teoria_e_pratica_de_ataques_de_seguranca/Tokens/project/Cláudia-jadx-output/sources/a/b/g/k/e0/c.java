package a.b.g.k.e0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
/* compiled from: AccessibilityNodeInfoCompat.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final AccessibilityNodeInfo f1112a;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1113a;

        public a(Object obj) {
            this.f1113a = obj;
        }

        public static a a(int i2, int i3, boolean z, int i4) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                return new a(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z, i4));
            }
            if (i5 >= 19) {
                return new a(AccessibilityNodeInfo.CollectionInfo.obtain(i2, i3, z));
            }
            return new a(null);
        }
    }

    public c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1112a = accessibilityNodeInfo;
    }

    public static c a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    public static String b(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                switch (i2) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    default:
                        return "ACTION_UNKNOWN";
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public void b(Rect rect) {
        this.f1112a.getBoundsInScreen(rect);
    }

    public b c() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT < 19 || (collectionItemInfo = this.f1112a.getCollectionItemInfo()) == null) {
            return null;
        }
        return new b(collectionItemInfo);
    }

    public void d(CharSequence charSequence) {
        this.f1112a.setText(charSequence);
    }

    public void e(boolean z) {
        this.f1112a.setScrollable(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.f1112a;
            if (accessibilityNodeInfo == null) {
                if (cVar.f1112a != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(cVar.f1112a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public CharSequence f() {
        return this.f1112a.getPackageName();
    }

    public CharSequence g() {
        return this.f1112a.getText();
    }

    public String h() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f1112a.getViewIdResourceName();
        }
        return null;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1112a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean i() {
        return this.f1112a.isCheckable();
    }

    public boolean j() {
        return this.f1112a.isChecked();
    }

    public boolean k() {
        return this.f1112a.isClickable();
    }

    public boolean l() {
        return this.f1112a.isEnabled();
    }

    public boolean m() {
        return this.f1112a.isFocusable();
    }

    public boolean n() {
        return this.f1112a.isFocused();
    }

    public boolean o() {
        return this.f1112a.isLongClickable();
    }

    public boolean p() {
        return this.f1112a.isPassword();
    }

    public boolean q() {
        return this.f1112a.isScrollable();
    }

    public boolean r() {
        return this.f1112a.isSelected();
    }

    public AccessibilityNodeInfo s() {
        return this.f1112a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(f());
        sb.append("; className: ");
        sb.append(b());
        sb.append("; text: ");
        sb.append(g());
        sb.append("; contentDescription: ");
        sb.append(d());
        sb.append("; viewId: ");
        sb.append(h());
        sb.append("; checkable: ");
        sb.append(i());
        sb.append("; checked: ");
        sb.append(j());
        sb.append("; focusable: ");
        sb.append(m());
        sb.append("; focused: ");
        sb.append(n());
        sb.append("; selected: ");
        sb.append(r());
        sb.append("; clickable: ");
        sb.append(k());
        sb.append("; longClickable: ");
        sb.append(o());
        sb.append("; enabled: ");
        sb.append(l());
        sb.append("; password: ");
        sb.append(p());
        sb.append("; scrollable: " + q());
        sb.append("; [");
        int a2 = a();
        while (a2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(a2);
            a2 &= ~numberOfTrailingZeros;
            sb.append(b(numberOfTrailingZeros));
            if (a2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public int a() {
        return this.f1112a.getActions();
    }

    public void b(boolean z) {
        this.f1112a.setChecked(z);
    }

    public CharSequence d() {
        return this.f1112a.getContentDescription();
    }

    public Bundle e() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f1112a.getExtras();
        }
        return new Bundle();
    }

    public void f(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1112a.setShowingHintText(z);
        } else {
            a(4, z);
        }
    }

    public void a(int i2) {
        this.f1112a.addAction(i2);
    }

    public CharSequence b() {
        return this.f1112a.getClassName();
    }

    public void d(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1112a.setDismissable(z);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Object f1114a;

        public b(Object obj) {
            this.f1114a = obj;
        }

        public static b a(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 21) {
                return new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z, z2));
            }
            if (i6 >= 19) {
                return new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z));
            }
            return new b(null);
        }

        public int b() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f1114a).getColumnSpan();
            }
            return 0;
        }

        public int c() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f1114a).getRowIndex();
            }
            return 0;
        }

        public int d() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f1114a).getRowSpan();
            }
            return 0;
        }

        public boolean e() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f1114a).isSelected();
            }
            return false;
        }

        public int a() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f1114a).getColumnIndex();
            }
            return 0;
        }
    }

    public void a(Rect rect) {
        this.f1112a.getBoundsInParent(rect);
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1112a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((b) obj).f1114a);
        }
    }

    public void c(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1112a.setContentInvalid(z);
        }
    }

    public void a(boolean z) {
        this.f1112a.setCheckable(z);
    }

    public void a(CharSequence charSequence) {
        this.f1112a.setClassName(charSequence);
    }

    public void b(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1112a.setError(charSequence);
        }
    }

    public void c(CharSequence charSequence) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f1112a.setHintText(charSequence);
        } else if (i2 >= 19) {
            this.f1112a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1112a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((a) obj).f1113a);
        }
    }

    public final void a(int i2, boolean z) {
        Bundle e2 = e();
        if (e2 != null) {
            int i3 = e2.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i2);
            if (!z) {
                i2 = 0;
            }
            e2.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i2 | i3);
        }
    }
}
