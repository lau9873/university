package a.b.h.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AppCompatDrawableManager.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: h  reason: collision with root package name */
    public static k f1797h;

    /* renamed from: a  reason: collision with root package name */
    public WeakHashMap<Context, a.b.g.j.o<ColorStateList>> f1799a;

    /* renamed from: b  reason: collision with root package name */
    public a.b.g.j.a<String, d> f1800b;

    /* renamed from: c  reason: collision with root package name */
    public a.b.g.j.o<String> f1801c;

    /* renamed from: d  reason: collision with root package name */
    public final WeakHashMap<Context, a.b.g.j.f<WeakReference<Drawable.ConstantState>>> f1802d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    public TypedValue f1803e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1804f;

    /* renamed from: g  reason: collision with root package name */
    public static final PorterDuff.Mode f1796g = PorterDuff.Mode.SRC_IN;

    /* renamed from: i  reason: collision with root package name */
    public static final c f1798i = new c(6);
    public static final int[] j = {a.b.h.b.e.abc_textfield_search_default_mtrl_alpha, a.b.h.b.e.abc_textfield_default_mtrl_alpha, a.b.h.b.e.abc_ab_share_pack_mtrl_alpha};
    public static final int[] k = {a.b.h.b.e.abc_ic_commit_search_api_mtrl_alpha, a.b.h.b.e.abc_seekbar_tick_mark_material, a.b.h.b.e.abc_ic_menu_share_mtrl_alpha, a.b.h.b.e.abc_ic_menu_copy_mtrl_am_alpha, a.b.h.b.e.abc_ic_menu_cut_mtrl_alpha, a.b.h.b.e.abc_ic_menu_selectall_mtrl_alpha, a.b.h.b.e.abc_ic_menu_paste_mtrl_am_alpha};
    public static final int[] l = {a.b.h.b.e.abc_textfield_activated_mtrl_alpha, a.b.h.b.e.abc_textfield_search_activated_mtrl_alpha, a.b.h.b.e.abc_cab_background_top_mtrl_alpha, a.b.h.b.e.abc_text_cursor_material, a.b.h.b.e.abc_text_select_handle_left_mtrl_dark, a.b.h.b.e.abc_text_select_handle_middle_mtrl_dark, a.b.h.b.e.abc_text_select_handle_right_mtrl_dark, a.b.h.b.e.abc_text_select_handle_left_mtrl_light, a.b.h.b.e.abc_text_select_handle_middle_mtrl_light, a.b.h.b.e.abc_text_select_handle_right_mtrl_light};
    public static final int[] m = {a.b.h.b.e.abc_popup_background_mtrl_mult, a.b.h.b.e.abc_cab_background_internal_bg, a.b.h.b.e.abc_menu_hardkey_panel_mtrl_mult};
    public static final int[] n = {a.b.h.b.e.abc_tab_indicator_material, a.b.h.b.e.abc_textfield_search_material};
    public static final int[] o = {a.b.h.b.e.abc_btn_check_material, a.b.h.b.e.abc_btn_radio_material};

    /* compiled from: AppCompatDrawableManager.java */
    /* loaded from: classes.dex */
    public static class a implements d {
        @Override // a.b.h.k.k.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return a.b.h.e.a.a.e(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* compiled from: AppCompatDrawableManager.java */
    /* loaded from: classes.dex */
    public static class b implements d {
        @Override // a.b.h.k.k.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return a.b.e.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* compiled from: AppCompatDrawableManager.java */
    /* loaded from: classes.dex */
    public static class c extends a.b.g.j.g<Integer, PorterDuffColorFilter> {
        public c(int i2) {
            super(i2);
        }

        public static int b(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
            return b(Integer.valueOf(b(i2, mode)));
        }

        public PorterDuffColorFilter a(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return a((c) Integer.valueOf(b(i2, mode)), (Integer) porterDuffColorFilter);
        }
    }

    /* compiled from: AppCompatDrawableManager.java */
    /* loaded from: classes.dex */
    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: AppCompatDrawableManager.java */
    /* loaded from: classes.dex */
    public static class e implements d {
        @Override // a.b.h.k.k.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return a.b.e.a.i.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (f1797h == null) {
                f1797h = new k();
                a(f1797h);
            }
            kVar = f1797h;
        }
        return kVar;
    }

    public final Drawable b(Context context, int i2) {
        if (this.f1803e == null) {
            this.f1803e = new TypedValue();
        }
        TypedValue typedValue = this.f1803e;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        if (i2 == a.b.h.b.e.abc_cab_background_top_material) {
            a3 = new LayerDrawable(new Drawable[]{c(context, a.b.h.b.e.abc_cab_background_internal_bg), c(context, a.b.h.b.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a3);
        }
        return a3;
    }

    public synchronized Drawable c(Context context, int i2) {
        return a(context, i2, false);
    }

    public synchronized ColorStateList d(Context context, int i2) {
        ColorStateList e2;
        e2 = e(context, i2);
        if (e2 == null) {
            if (i2 == a.b.h.b.e.abc_edit_text_material) {
                e2 = a.b.h.d.a.a.b(context, a.b.h.b.c.abc_tint_edittext);
            } else if (i2 == a.b.h.b.e.abc_switch_track_mtrl_alpha) {
                e2 = a.b.h.d.a.a.b(context, a.b.h.b.c.abc_tint_switch_track);
            } else if (i2 == a.b.h.b.e.abc_switch_thumb_material) {
                e2 = e(context);
            } else if (i2 == a.b.h.b.e.abc_btn_default_mtrl_shape) {
                e2 = d(context);
            } else if (i2 == a.b.h.b.e.abc_btn_borderless_material) {
                e2 = b(context);
            } else if (i2 == a.b.h.b.e.abc_btn_colored_material) {
                e2 = c(context);
            } else {
                if (i2 != a.b.h.b.e.abc_spinner_mtrl_am_alpha && i2 != a.b.h.b.e.abc_spinner_textfield_background_material) {
                    if (a(k, i2)) {
                        e2 = g1.c(context, a.b.h.b.a.colorControlNormal);
                    } else if (a(n, i2)) {
                        e2 = a.b.h.d.a.a.b(context, a.b.h.b.c.abc_tint_default);
                    } else if (a(o, i2)) {
                        e2 = a.b.h.d.a.a.b(context, a.b.h.b.c.abc_tint_btn_checkable);
                    } else if (i2 == a.b.h.b.e.abc_seekbar_thumb_material) {
                        e2 = a.b.h.d.a.a.b(context, a.b.h.b.c.abc_tint_seek_thumb);
                    }
                }
                e2 = a.b.h.d.a.a.b(context, a.b.h.b.c.abc_tint_spinner);
            }
            if (e2 != null) {
                a(context, i2, e2);
            }
        }
        return e2;
    }

    public final ColorStateList e(Context context, int i2) {
        a.b.g.j.o<ColorStateList> oVar;
        WeakHashMap<Context, a.b.g.j.o<ColorStateList>> weakHashMap = this.f1799a;
        if (weakHashMap == null || (oVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return oVar.b(i2);
    }

    public synchronized void f(Context context) {
        a.b.g.j.f<WeakReference<Drawable.ConstantState>> fVar = this.f1802d.get(context);
        if (fVar != null) {
            fVar.a();
        }
    }

    public final ColorStateList c(Context context) {
        return a(context, g1.b(context, a.b.h.b.a.colorAccent));
    }

    public final ColorStateList e(Context context) {
        int[][] iArr = new int[3];
        int[] iArr2 = new int[3];
        ColorStateList c2 = g1.c(context, a.b.h.b.a.colorSwitchThumbNormal);
        if (c2 != null && c2.isStateful()) {
            iArr[0] = g1.f1732b;
            iArr2[0] = c2.getColorForState(iArr[0], 0);
            iArr[1] = g1.f1735e;
            iArr2[1] = g1.b(context, a.b.h.b.a.colorControlActivated);
            iArr[2] = g1.f1736f;
            iArr2[2] = c2.getDefaultColor();
        } else {
            iArr[0] = g1.f1732b;
            iArr2[0] = g1.a(context, a.b.h.b.a.colorSwitchThumbNormal);
            iArr[1] = g1.f1735e;
            iArr2[1] = g1.b(context, a.b.h.b.a.colorControlActivated);
            iArr[2] = g1.f1736f;
            iArr2[2] = g1.b(context, a.b.h.b.a.colorSwitchThumbNormal);
        }
        return new ColorStateList(iArr, iArr2);
    }

    public final Drawable f(Context context, int i2) {
        int next;
        a.b.g.j.a<String, d> aVar = this.f1800b;
        if (aVar == null || aVar.isEmpty()) {
            return null;
        }
        a.b.g.j.o<String> oVar = this.f1801c;
        if (oVar != null) {
            String b2 = oVar.b(i2);
            if ("appcompat_skip_skip".equals(b2) || (b2 != null && this.f1800b.get(b2) == null)) {
                return null;
            }
        } else {
            this.f1801c = new a.b.g.j.o<>();
        }
        if (this.f1803e == null) {
            this.f1803e = new TypedValue();
        }
        TypedValue typedValue = this.f1803e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.f1801c.a(i2, name);
                    d dVar = this.f1800b.get(name);
                    if (dVar != null) {
                        a3 = dVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (a3 != null) {
                        a3.setChangingConfigurations(typedValue.changingConfigurations);
                        a(context, a2, a3);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e2);
            }
        }
        if (a3 == null) {
            this.f1801c.a(i2, "appcompat_skip_skip");
        }
        return a3;
    }

    public static void a(k kVar) {
        if (Build.VERSION.SDK_INT < 24) {
            kVar.a("vector", new e());
            kVar.a("animated-vector", new b());
            kVar.a("animated-selector", new a());
        }
    }

    public synchronized Drawable a(Context context, int i2, boolean z) {
        Drawable f2;
        a(context);
        f2 = f(context, i2);
        if (f2 == null) {
            f2 = b(context, i2);
        }
        if (f2 == null) {
            f2 = a.b.g.b.b.c(context, i2);
        }
        if (f2 != null) {
            f2 = a(context, i2, z, f2);
        }
        if (f2 != null) {
            k0.b(f2);
        }
        return f2;
    }

    public final ColorStateList b(Context context) {
        return a(context, 0);
    }

    public static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    public final Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList d2 = d(context, i2);
        if (d2 != null) {
            if (k0.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable i3 = a.b.g.c.j.a.i(drawable);
            a.b.g.c.j.a.a(i3, d2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 != null) {
                a.b.g.c.j.a.a(i3, a2);
                return i3;
            }
            return i3;
        } else if (i2 == a.b.h.b.e.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), g1.b(context, a.b.h.b.a.colorControlNormal), f1796g);
            a(layerDrawable.findDrawableByLayerId(16908303), g1.b(context, a.b.h.b.a.colorControlNormal), f1796g);
            a(layerDrawable.findDrawableByLayerId(16908301), g1.b(context, a.b.h.b.a.colorControlActivated), f1796g);
            return drawable;
        } else if (i2 != a.b.h.b.e.abc_ratingbar_material && i2 != a.b.h.b.e.abc_ratingbar_indicator_material && i2 != a.b.h.b.e.abc_ratingbar_small_material) {
            if (a(context, i2, drawable) || !z) {
                return drawable;
            }
            return null;
        } else {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            a(layerDrawable2.findDrawableByLayerId(16908288), g1.a(context, a.b.h.b.a.colorControlNormal), f1796g);
            a(layerDrawable2.findDrawableByLayerId(16908303), g1.b(context, a.b.h.b.a.colorControlActivated), f1796g);
            a(layerDrawable2.findDrawableByLayerId(16908301), g1.b(context, a.b.h.b.a.colorControlActivated), f1796g);
            return drawable;
        }
    }

    public final ColorStateList d(Context context) {
        return a(context, g1.b(context, a.b.h.b.a.colorButtonNormal));
    }

    public final synchronized Drawable a(Context context, long j2) {
        a.b.g.j.f<WeakReference<Drawable.ConstantState>> fVar = this.f1802d.get(context);
        if (fVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> b2 = fVar.b(j2);
        if (b2 != null) {
            Drawable.ConstantState constantState = b2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            fVar.a(j2);
        }
        return null;
    }

    public final synchronized boolean a(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            a.b.g.j.f<WeakReference<Drawable.ConstantState>> fVar = this.f1802d.get(context);
            if (fVar == null) {
                fVar = new a.b.g.j.f<>();
                this.f1802d.put(context, fVar);
            }
            fVar.c(j2, new WeakReference<>(constantState));
            return true;
        }
        return false;
    }

    public synchronized Drawable a(Context context, q1 q1Var, int i2) {
        Drawable f2 = f(context, i2);
        if (f2 == null) {
            f2 = q1Var.a(i2);
        }
        if (f2 != null) {
            return a(context, i2, false, f2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = a.b.h.k.k.f1796g
            int[] r1 = a.b.h.k.k.j
            boolean r1 = a(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L15
            int r2 = a.b.h.b.a.colorControlNormal
        L12:
            r7 = 1
            r1 = -1
            goto L44
        L15:
            int[] r1 = a.b.h.k.k.l
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L20
            int r2 = a.b.h.b.a.colorControlActivated
            goto L12
        L20:
            int[] r1 = a.b.h.k.k.m
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L2b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L12
        L2b:
            int r1 = a.b.h.b.e.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L3c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = r7
            r7 = 1
            goto L44
        L3c:
            int r1 = a.b.h.b.e.abc_dialog_material_background
            if (r7 != r1) goto L41
            goto L12
        L41:
            r7 = 0
            r1 = -1
            r2 = 0
        L44:
            if (r7 == 0) goto L61
            boolean r7 = a.b.h.k.k0.a(r8)
            if (r7 == 0) goto L50
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L50:
            int r6 = a.b.h.k.g1.b(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = a(r6, r0)
            r8.setColorFilter(r6)
            if (r1 == r3) goto L60
            r8.setAlpha(r1)
        L60:
            return r5
        L61:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.h.k.k.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    public final void a(String str, d dVar) {
        if (this.f1800b == null) {
            this.f1800b = new a.b.g.j.a<>();
        }
        this.f1800b.put(str, dVar);
    }

    public static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    public static PorterDuff.Mode a(int i2) {
        if (i2 == a.b.h.b.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public final void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.f1799a == null) {
            this.f1799a = new WeakHashMap<>();
        }
        a.b.g.j.o<ColorStateList> oVar = this.f1799a.get(context);
        if (oVar == null) {
            oVar = new a.b.g.j.o<>();
            this.f1799a.put(context, oVar);
        }
        oVar.a(i2, colorStateList);
    }

    public final ColorStateList a(Context context, int i2) {
        int b2 = g1.b(context, a.b.h.b.a.colorControlHighlight);
        return new ColorStateList(new int[][]{g1.f1732b, g1.f1734d, g1.f1733c, g1.f1736f}, new int[]{g1.a(context, a.b.h.b.a.colorButtonNormal), a.b.g.c.a.b(b2, i2), a.b.g.c.a.b(b2, i2), i2});
    }

    public static void a(Drawable drawable, j1 j1Var, int[] iArr) {
        if (k0.a(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (j1Var.f1795d || j1Var.f1794c) {
            drawable.setColorFilter(a(j1Var.f1795d ? j1Var.f1792a : null, j1Var.f1794c ? j1Var.f1793b : f1796g, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (k.class) {
            a2 = f1798i.a(i2, mode);
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                f1798i.a(i2, mode, a2);
            }
        }
        return a2;
    }

    public static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (k0.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f1796g;
        }
        drawable.setColorFilter(a(i2, mode));
    }

    public final void a(Context context) {
        if (this.f1804f) {
            return;
        }
        this.f1804f = true;
        Drawable c2 = c(context, a.b.h.b.e.abc_vector_test);
        if (c2 == null || !a(c2)) {
            this.f1804f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public static boolean a(Drawable drawable) {
        return (drawable instanceof a.b.e.a.i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
