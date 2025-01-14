package p000a.p006b.p030g.p045k.p046e0;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import com.j256.ormlite.logger.Logger;

/* renamed from: a.b.g.k.e0.c */
/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {

    /* renamed from: a */
    public final AccessibilityNodeInfo f1623a;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: a.b.g.k.e0.c$a */
    /* loaded from: classes.dex */
    public static class C0284a {

        /* renamed from: a */
        public final Object f1624a;

        public C0284a(Object obj) {
            this.f1624a = obj;
        }

        /* renamed from: a */
        public static C0284a m9522a(int i, int i2, boolean z, int i3) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21) {
                return new C0284a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (i4 >= 19) {
                return new C0284a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new C0284a(null);
        }
    }

    public AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f1623a = accessibilityNodeInfo;
    }

    /* renamed from: a */
    public static AccessibilityNodeInfoCompat m9555a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    /* renamed from: b */
    public static String m9550b(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
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
                    case Logger.DEFAULT_FULL_MESSAGE_LENGTH /* 128 */:
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

    /* renamed from: b */
    public void m9549b(Rect rect) {
        this.f1623a.getBoundsInScreen(rect);
    }

    /* renamed from: c */
    public C0285b m9545c() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        if (Build.VERSION.SDK_INT < 19 || (collectionItemInfo = this.f1623a.getCollectionItemInfo()) == null) {
            return null;
        }
        return new C0285b(collectionItemInfo);
    }

    /* renamed from: d */
    public void m9541d(CharSequence charSequence) {
        this.f1623a.setText(charSequence);
    }

    /* renamed from: e */
    public void m9538e(boolean z) {
        this.f1623a.setScrollable(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AccessibilityNodeInfoCompat.class == obj.getClass()) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.f1623a;
            if (accessibilityNodeInfo == null) {
                if (accessibilityNodeInfoCompat.f1623a != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.f1623a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public CharSequence m9537f() {
        return this.f1623a.getPackageName();
    }

    /* renamed from: g */
    public CharSequence m9535g() {
        return this.f1623a.getText();
    }

    /* renamed from: h */
    public String m9534h() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f1623a.getViewIdResourceName();
        }
        return null;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1623a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* renamed from: i */
    public boolean m9533i() {
        return this.f1623a.isCheckable();
    }

    /* renamed from: j */
    public boolean m9532j() {
        return this.f1623a.isChecked();
    }

    /* renamed from: k */
    public boolean m9531k() {
        return this.f1623a.isClickable();
    }

    /* renamed from: l */
    public boolean m9530l() {
        return this.f1623a.isEnabled();
    }

    /* renamed from: m */
    public boolean m9529m() {
        return this.f1623a.isFocusable();
    }

    /* renamed from: n */
    public boolean m9528n() {
        return this.f1623a.isFocused();
    }

    /* renamed from: o */
    public boolean m9527o() {
        return this.f1623a.isLongClickable();
    }

    /* renamed from: p */
    public boolean m9526p() {
        return this.f1623a.isPassword();
    }

    /* renamed from: q */
    public boolean m9525q() {
        return this.f1623a.isScrollable();
    }

    /* renamed from: r */
    public boolean m9524r() {
        return this.f1623a.isSelected();
    }

    /* renamed from: s */
    public AccessibilityNodeInfo m9523s() {
        return this.f1623a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m9556a(rect);
        sb.append("; boundsInParent: " + rect);
        m9549b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(m9537f());
        sb.append("; className: ");
        sb.append(m9551b());
        sb.append("; text: ");
        sb.append(m9535g());
        sb.append("; contentDescription: ");
        sb.append(m9542d());
        sb.append("; viewId: ");
        sb.append(m9534h());
        sb.append("; checkable: ");
        sb.append(m9533i());
        sb.append("; checked: ");
        sb.append(m9532j());
        sb.append("; focusable: ");
        sb.append(m9529m());
        sb.append("; focused: ");
        sb.append(m9528n());
        sb.append("; selected: ");
        sb.append(m9524r());
        sb.append("; clickable: ");
        sb.append(m9531k());
        sb.append("; longClickable: ");
        sb.append(m9527o());
        sb.append("; enabled: ");
        sb.append(m9530l());
        sb.append("; password: ");
        sb.append(m9526p());
        sb.append("; scrollable: " + m9525q());
        sb.append("; [");
        int m9559a = m9559a();
        while (m9559a != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(m9559a);
            m9559a &= ~numberOfTrailingZeros;
            sb.append(m9550b(numberOfTrailingZeros));
            if (m9559a != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a */
    public int m9559a() {
        return this.f1623a.getActions();
    }

    /* renamed from: b */
    public void m9546b(boolean z) {
        this.f1623a.setChecked(z);
    }

    /* renamed from: d */
    public CharSequence m9542d() {
        return this.f1623a.getContentDescription();
    }

    /* renamed from: e */
    public Bundle m9539e() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.f1623a.getExtras();
        }
        return new Bundle();
    }

    /* renamed from: f */
    public void m9536f(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1623a.setShowingHintText(z);
        } else {
            m9557a(4, z);
        }
    }

    /* renamed from: a */
    public void m9558a(int i) {
        this.f1623a.addAction(i);
    }

    /* renamed from: b */
    public CharSequence m9551b() {
        return this.f1623a.getClassName();
    }

    /* renamed from: d */
    public void m9540d(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1623a.setDismissable(z);
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: a.b.g.k.e0.c$b */
    /* loaded from: classes.dex */
    public static class C0285b {

        /* renamed from: a */
        public final Object f1625a;

        public C0285b(Object obj) {
            this.f1625a = obj;
        }

        /* renamed from: a */
        public static C0285b m9520a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 21) {
                return new C0285b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (i5 >= 19) {
                return new C0285b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new C0285b(null);
        }

        /* renamed from: b */
        public int m9519b() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f1625a).getColumnSpan();
            }
            return 0;
        }

        /* renamed from: c */
        public int m9518c() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f1625a).getRowIndex();
            }
            return 0;
        }

        /* renamed from: d */
        public int m9517d() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f1625a).getRowSpan();
            }
            return 0;
        }

        /* renamed from: e */
        public boolean m9516e() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f1625a).isSelected();
            }
            return false;
        }

        /* renamed from: a */
        public int m9521a() {
            if (Build.VERSION.SDK_INT >= 19) {
                return ((AccessibilityNodeInfo.CollectionItemInfo) this.f1625a).getColumnIndex();
            }
            return 0;
        }
    }

    /* renamed from: a */
    public void m9556a(Rect rect) {
        this.f1623a.getBoundsInParent(rect);
    }

    /* renamed from: b */
    public void m9547b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1623a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((C0285b) obj).f1625a);
        }
    }

    /* renamed from: c */
    public void m9543c(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1623a.setContentInvalid(z);
        }
    }

    /* renamed from: a */
    public void m9552a(boolean z) {
        this.f1623a.setCheckable(z);
    }

    /* renamed from: a */
    public void m9554a(CharSequence charSequence) {
        this.f1623a.setClassName(charSequence);
    }

    /* renamed from: b */
    public void m9548b(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1623a.setError(charSequence);
        }
    }

    /* renamed from: c */
    public void m9544c(CharSequence charSequence) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f1623a.setHintText(charSequence);
        } else if (i >= 19) {
            this.f1623a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    /* renamed from: a */
    public void m9553a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1623a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((C0284a) obj).f1624a);
        }
    }

    /* renamed from: a */
    public final void m9557a(int i, boolean z) {
        Bundle m9539e = m9539e();
        if (m9539e != null) {
            int i2 = m9539e.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            m9539e.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }
}
