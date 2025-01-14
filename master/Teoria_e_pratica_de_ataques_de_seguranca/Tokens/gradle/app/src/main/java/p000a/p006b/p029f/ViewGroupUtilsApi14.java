package p000a.p006b.p029f;

import android.animation.LayoutTransition;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: a.b.f.y */
/* loaded from: classes.dex */
public class ViewGroupUtilsApi14 {

    /* renamed from: a */
    public static LayoutTransition f1007a;

    /* renamed from: b */
    public static Field f1008b;

    /* renamed from: c */
    public static boolean f1009c;

    /* renamed from: d */
    public static Method f1010d;

    /* renamed from: e */
    public static boolean f1011e;

    /* compiled from: ViewGroupUtilsApi14.java */
    /* renamed from: a.b.f.y$a */
    /* loaded from: classes.dex */
    public static class C0130a extends LayoutTransition {
        @Override // android.animation.LayoutTransition
        public boolean isChangingLayout() {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m10420a(android.view.ViewGroup r5, boolean r6) {
        /*
            android.animation.LayoutTransition r0 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1007a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L2a
            a.b.f.y$a r0 = new a.b.f.y$a
            r0.<init>()
            p000a.p006b.p029f.ViewGroupUtilsApi14.f1007a = r0
            android.animation.LayoutTransition r0 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1007a
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1007a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1007a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1007a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1007a
            r4 = 4
            r0.setAnimator(r4, r3)
        L2a:
            if (r6 == 0) goto L4a
            android.animation.LayoutTransition r6 = r5.getLayoutTransition()
            if (r6 == 0) goto L44
            boolean r0 = r6.isRunning()
            if (r0 == 0) goto L3b
            m10421a(r6)
        L3b:
            android.animation.LayoutTransition r0 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1007a
            if (r6 == r0) goto L44
            int r0 = p000a.p006b.p029f.C0119j.transition_layout_save
            r5.setTag(r0, r6)
        L44:
            android.animation.LayoutTransition r6 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1007a
            r5.setLayoutTransition(r6)
            goto L9a
        L4a:
            r5.setLayoutTransition(r3)
            boolean r6 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1009c
            java.lang.String r0 = "ViewGroupUtilsApi14"
            if (r6 != 0) goto L6a
            java.lang.Class<android.view.ViewGroup> r6 = android.view.ViewGroup.class
            java.lang.String r4 = "mLayoutSuppressed"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r4)     // Catch: java.lang.NoSuchFieldException -> L63
            p000a.p006b.p029f.ViewGroupUtilsApi14.f1008b = r6     // Catch: java.lang.NoSuchFieldException -> L63
            java.lang.reflect.Field r6 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1008b     // Catch: java.lang.NoSuchFieldException -> L63
            r6.setAccessible(r1)     // Catch: java.lang.NoSuchFieldException -> L63
            goto L68
        L63:
            java.lang.String r6 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.i(r0, r6)
        L68:
            p000a.p006b.p029f.ViewGroupUtilsApi14.f1009c = r1
        L6a:
            java.lang.reflect.Field r6 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1008b
            if (r6 == 0) goto L83
            boolean r6 = r6.getBoolean(r5)     // Catch: java.lang.IllegalAccessException -> L7e
            if (r6 == 0) goto L7c
            java.lang.reflect.Field r1 = p000a.p006b.p029f.ViewGroupUtilsApi14.f1008b     // Catch: java.lang.IllegalAccessException -> L7a
            r1.setBoolean(r5, r2)     // Catch: java.lang.IllegalAccessException -> L7a
            goto L7c
        L7a:
            r2 = r6
            goto L7e
        L7c:
            r2 = r6
            goto L83
        L7e:
            java.lang.String r6 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.i(r0, r6)
        L83:
            if (r2 == 0) goto L88
            r5.requestLayout()
        L88:
            int r6 = p000a.p006b.p029f.C0119j.transition_layout_save
            java.lang.Object r6 = r5.getTag(r6)
            android.animation.LayoutTransition r6 = (android.animation.LayoutTransition) r6
            if (r6 == 0) goto L9a
            int r0 = p000a.p006b.p029f.C0119j.transition_layout_save
            r5.setTag(r0, r3)
            r5.setLayoutTransition(r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p029f.ViewGroupUtilsApi14.m10420a(android.view.ViewGroup, boolean):void");
    }

    /* renamed from: a */
    public static void m10421a(LayoutTransition layoutTransition) {
        if (!f1011e) {
            try {
                f1010d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f1010d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f1011e = true;
        }
        Method method = f1010d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
            } catch (IllegalAccessException unused2) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            } catch (InvocationTargetException unused3) {
                Log.i("ViewGroupUtilsApi14", "Failed to invoke cancel method by reflection");
            }
        }
    }
}
