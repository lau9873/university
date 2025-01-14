package p000a.p006b.p049h.p063k;

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
import p000a.p006b.p027e.p028a.AnimatedVectorDrawableCompat;
import p000a.p006b.p027e.p028a.VectorDrawableCompat;
import p000a.p006b.p030g.p032b.ContextCompat;
import p000a.p006b.p030g.p034c.ColorUtils;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p044j.ArrayMap;
import p000a.p006b.p030g.p044j.LongSparseArray;
import p000a.p006b.p030g.p044j.LruCache;
import p000a.p006b.p030g.p044j.SparseArrayCompat;
import p000a.p006b.p049h.p051b.C0354a;
import p000a.p006b.p049h.p051b.C0356c;
import p000a.p006b.p049h.p051b.C0358e;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p055e.p056a.AnimatedStateListDrawableCompat;

/* renamed from: a.b.h.k.k */
/* loaded from: classes.dex */
public final class AppCompatDrawableManager {

    /* renamed from: h */
    public static AppCompatDrawableManager f2718h;

    /* renamed from: a */
    public WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f2726a;

    /* renamed from: b */
    public ArrayMap<String, InterfaceC0473d> f2727b;

    /* renamed from: c */
    public SparseArrayCompat<String> f2728c;

    /* renamed from: d */
    public final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> f2729d = new WeakHashMap<>(0);

    /* renamed from: e */
    public TypedValue f2730e;

    /* renamed from: f */
    public boolean f2731f;

    /* renamed from: g */
    public static final PorterDuff.Mode f2717g = PorterDuff.Mode.SRC_IN;

    /* renamed from: i */
    public static final C0472c f2719i = new C0472c(6);

    /* renamed from: j */
    public static final int[] f2720j = {C0358e.abc_textfield_search_default_mtrl_alpha, C0358e.abc_textfield_default_mtrl_alpha, C0358e.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: k */
    public static final int[] f2721k = {C0358e.abc_ic_commit_search_api_mtrl_alpha, C0358e.abc_seekbar_tick_mark_material, C0358e.abc_ic_menu_share_mtrl_alpha, C0358e.abc_ic_menu_copy_mtrl_am_alpha, C0358e.abc_ic_menu_cut_mtrl_alpha, C0358e.abc_ic_menu_selectall_mtrl_alpha, C0358e.abc_ic_menu_paste_mtrl_am_alpha};

    /* renamed from: l */
    public static final int[] f2722l = {C0358e.abc_textfield_activated_mtrl_alpha, C0358e.abc_textfield_search_activated_mtrl_alpha, C0358e.abc_cab_background_top_mtrl_alpha, C0358e.abc_text_cursor_material, C0358e.abc_text_select_handle_left_mtrl_dark, C0358e.abc_text_select_handle_middle_mtrl_dark, C0358e.abc_text_select_handle_right_mtrl_dark, C0358e.abc_text_select_handle_left_mtrl_light, C0358e.abc_text_select_handle_middle_mtrl_light, C0358e.abc_text_select_handle_right_mtrl_light};

    /* renamed from: m */
    public static final int[] f2723m = {C0358e.abc_popup_background_mtrl_mult, C0358e.abc_cab_background_internal_bg, C0358e.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: n */
    public static final int[] f2724n = {C0358e.abc_tab_indicator_material, C0358e.abc_textfield_search_material};

    /* renamed from: o */
    public static final int[] f2725o = {C0358e.abc_btn_check_material, C0358e.abc_btn_radio_material};

    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: a.b.h.k.k$a */
    /* loaded from: classes.dex */
    public static class C0470a implements InterfaceC0473d {
        @Override // p000a.p006b.p049h.p063k.AppCompatDrawableManager.InterfaceC0473d
        /* renamed from: a */
        public Drawable mo8285a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.m8957e(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: a.b.h.k.k$b */
    /* loaded from: classes.dex */
    public static class C0471b implements InterfaceC0473d {
        @Override // p000a.p006b.p049h.p063k.AppCompatDrawableManager.InterfaceC0473d
        /* renamed from: a */
        public Drawable mo8285a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.m10645a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: a.b.h.k.k$c */
    /* loaded from: classes.dex */
    public static class C0472c extends LruCache<Integer, PorterDuffColorFilter> {
        public C0472c(int i) {
            super(i);
        }

        /* renamed from: b */
        public static int m8286b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* renamed from: a */
        public PorterDuffColorFilter m8288a(int i, PorterDuff.Mode mode) {
            return m9649b(Integer.valueOf(m8286b(i, mode)));
        }

        /* renamed from: a */
        public PorterDuffColorFilter m8287a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return m9651a((C0472c) Integer.valueOf(m8286b(i, mode)), (Integer) porterDuffColorFilter);
        }
    }

    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: a.b.h.k.k$d */
    /* loaded from: classes.dex */
    public interface InterfaceC0473d {
        /* renamed from: a */
        Drawable mo8285a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: a.b.h.k.k$e */
    /* loaded from: classes.dex */
    public static class C0474e implements InterfaceC0473d {
        @Override // p000a.p006b.p049h.p063k.AppCompatDrawableManager.InterfaceC0473d
        /* renamed from: a */
        public Drawable mo8285a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static synchronized AppCompatDrawableManager m8318a() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (f2718h == null) {
                f2718h = new AppCompatDrawableManager();
                m8315a(f2718h);
            }
            appCompatDrawableManager = f2718h;
        }
        return appCompatDrawableManager;
    }

    /* renamed from: b */
    public final Drawable m8297b(Context context, int i) {
        if (this.f2730e == null) {
            this.f2730e = new TypedValue();
        }
        TypedValue typedValue = this.f2730e;
        context.getResources().getValue(i, typedValue, true);
        long m8301a = m8301a(typedValue);
        Drawable m8308a = m8308a(context, m8301a);
        if (m8308a != null) {
            return m8308a;
        }
        if (i == C0358e.abc_cab_background_top_material) {
            m8308a = new LayerDrawable(new Drawable[]{m8295c(context, C0358e.abc_cab_background_internal_bg), m8295c(context, C0358e.abc_cab_background_top_mtrl_alpha)});
        }
        if (m8308a != null) {
            m8308a.setChangingConfigurations(typedValue.changingConfigurations);
            m8307a(context, m8301a, m8308a);
        }
        return m8308a;
    }

    /* renamed from: c */
    public synchronized Drawable m8295c(Context context, int i) {
        return m8310a(context, i, false);
    }

    /* renamed from: d */
    public synchronized ColorStateList m8293d(Context context, int i) {
        ColorStateList m8291e;
        m8291e = m8291e(context, i);
        if (m8291e == null) {
            if (i == C0358e.abc_edit_text_material) {
                m8291e = AppCompatResources.m8968b(context, C0356c.abc_tint_edittext);
            } else if (i == C0358e.abc_switch_track_mtrl_alpha) {
                m8291e = AppCompatResources.m8968b(context, C0356c.abc_tint_switch_track);
            } else if (i == C0358e.abc_switch_thumb_material) {
                m8291e = m8292e(context);
            } else if (i == C0358e.abc_btn_default_mtrl_shape) {
                m8291e = m8294d(context);
            } else if (i == C0358e.abc_btn_borderless_material) {
                m8291e = m8298b(context);
            } else if (i == C0358e.abc_btn_colored_material) {
                m8291e = m8296c(context);
            } else {
                if (i != C0358e.abc_spinner_mtrl_am_alpha && i != C0358e.abc_spinner_textfield_background_material) {
                    if (m8299a(f2721k, i)) {
                        m8291e = ThemeUtils.m8344c(context, C0354a.colorControlNormal);
                    } else if (m8299a(f2724n, i)) {
                        m8291e = AppCompatResources.m8968b(context, C0356c.abc_tint_default);
                    } else if (m8299a(f2725o, i)) {
                        m8291e = AppCompatResources.m8968b(context, C0356c.abc_tint_btn_checkable);
                    } else if (i == C0358e.abc_seekbar_thumb_material) {
                        m8291e = AppCompatResources.m8968b(context, C0356c.abc_tint_seek_thumb);
                    }
                }
                m8291e = AppCompatResources.m8968b(context, C0356c.abc_tint_spinner);
            }
            if (m8291e != null) {
                m8312a(context, i, m8291e);
            }
        }
        return m8291e;
    }

    /* renamed from: e */
    public final ColorStateList m8291e(Context context, int i) {
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.f2726a;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return sparseArrayCompat.m9602b(i);
    }

    /* renamed from: f */
    public synchronized void m8290f(Context context) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f2729d.get(context);
        if (longSparseArray != null) {
            longSparseArray.m9665a();
        }
    }

    /* renamed from: c */
    public final ColorStateList m8296c(Context context) {
        return m8313a(context, ThemeUtils.m8345b(context, C0354a.colorAccent));
    }

    /* renamed from: e */
    public final ColorStateList m8292e(Context context) {
        int[][] iArr = new int[3];
        int[] iArr2 = new int[3];
        ColorStateList m8344c = ThemeUtils.m8344c(context, C0354a.colorSwitchThumbNormal);
        if (m8344c != null && m8344c.isStateful()) {
            iArr[0] = ThemeUtils.f2643b;
            iArr2[0] = m8344c.getColorForState(iArr[0], 0);
            iArr[1] = ThemeUtils.f2646e;
            iArr2[1] = ThemeUtils.m8345b(context, C0354a.colorControlActivated);
            iArr[2] = ThemeUtils.f2647f;
            iArr2[2] = m8344c.getDefaultColor();
        } else {
            iArr[0] = ThemeUtils.f2643b;
            iArr2[0] = ThemeUtils.m8347a(context, C0354a.colorSwitchThumbNormal);
            iArr[1] = ThemeUtils.f2646e;
            iArr2[1] = ThemeUtils.m8345b(context, C0354a.colorControlActivated);
            iArr[2] = ThemeUtils.f2647f;
            iArr2[2] = ThemeUtils.m8345b(context, C0354a.colorSwitchThumbNormal);
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* renamed from: f */
    public final Drawable m8289f(Context context, int i) {
        int next;
        ArrayMap<String, InterfaceC0473d> arrayMap = this.f2727b;
        if (arrayMap == null || arrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat<String> sparseArrayCompat = this.f2728c;
        if (sparseArrayCompat != null) {
            String m9602b = sparseArrayCompat.m9602b(i);
            if ("appcompat_skip_skip".equals(m9602b) || (m9602b != null && this.f2727b.get(m9602b) == null)) {
                return null;
            }
        } else {
            this.f2728c = new SparseArrayCompat<>();
        }
        if (this.f2730e == null) {
            this.f2730e = new TypedValue();
        }
        TypedValue typedValue = this.f2730e;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long m8301a = m8301a(typedValue);
        Drawable m8308a = m8308a(context, m8301a);
        if (m8308a != null) {
            return m8308a;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.f2728c.m9604a(i, name);
                    InterfaceC0473d interfaceC0473d = this.f2727b.get(name);
                    if (interfaceC0473d != null) {
                        m8308a = interfaceC0473d.mo8285a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (m8308a != null) {
                        m8308a.setChangingConfigurations(typedValue.changingConfigurations);
                        m8307a(context, m8301a, m8308a);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e);
            }
        }
        if (m8308a == null) {
            this.f2728c.m9604a(i, "appcompat_skip_skip");
        }
        return m8308a;
    }

    /* renamed from: a */
    public static void m8315a(AppCompatDrawableManager appCompatDrawableManager) {
        if (Build.VERSION.SDK_INT < 24) {
            appCompatDrawableManager.m8300a("vector", new C0474e());
            appCompatDrawableManager.m8300a("animated-vector", new C0471b());
            appCompatDrawableManager.m8300a("animated-selector", new C0470a());
        }
    }

    /* renamed from: a */
    public synchronized Drawable m8310a(Context context, int i, boolean z) {
        Drawable m8289f;
        m8314a(context);
        m8289f = m8289f(context, i);
        if (m8289f == null) {
            m8289f = m8297b(context, i);
        }
        if (m8289f == null) {
            m8289f = ContextCompat.m10016c(context, i);
        }
        if (m8289f != null) {
            m8289f = m8309a(context, i, z, m8289f);
        }
        if (m8289f != null) {
            C0475k0.m8282b(m8289f);
        }
        return m8289f;
    }

    /* renamed from: b */
    public final ColorStateList m8298b(Context context) {
        return m8313a(context, 0);
    }

    /* renamed from: a */
    public static long m8301a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    /* renamed from: a */
    public final Drawable m8309a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList m8293d = m8293d(context, i);
        if (m8293d != null) {
            if (C0475k0.m8283a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable m9848i = DrawableCompat.m9848i(drawable);
            DrawableCompat.m9861a(m9848i, m8293d);
            PorterDuff.Mode m8317a = m8317a(i);
            if (m8317a != null) {
                DrawableCompat.m9858a(m9848i, m8317a);
                return m9848i;
            }
            return m9848i;
        } else if (i == C0358e.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            m8303a(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.m8345b(context, C0354a.colorControlNormal), f2717g);
            m8303a(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.m8345b(context, C0354a.colorControlNormal), f2717g);
            m8303a(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.m8345b(context, C0354a.colorControlActivated), f2717g);
            return drawable;
        } else if (i != C0358e.abc_ratingbar_material && i != C0358e.abc_ratingbar_indicator_material && i != C0358e.abc_ratingbar_small_material) {
            if (m8311a(context, i, drawable) || !z) {
                return drawable;
            }
            return null;
        } else {
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m8303a(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.m8347a(context, C0354a.colorControlNormal), f2717g);
            m8303a(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.m8345b(context, C0354a.colorControlActivated), f2717g);
            m8303a(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.m8345b(context, C0354a.colorControlActivated), f2717g);
            return drawable;
        }
    }

    /* renamed from: d */
    public final ColorStateList m8294d(Context context) {
        return m8313a(context, ThemeUtils.m8345b(context, C0354a.colorButtonNormal));
    }

    /* renamed from: a */
    public final synchronized Drawable m8308a(Context context, long j) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f2729d.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> m9659b = longSparseArray.m9659b(j);
        if (m9659b != null) {
            Drawable.ConstantState constantState = m9659b.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.m9663a(j);
        }
        return null;
    }

    /* renamed from: a */
    public final synchronized boolean m8307a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.f2729d.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray<>();
                this.f2729d.put(context, longSparseArray);
            }
            longSparseArray.m9654c(j, new WeakReference<>(constantState));
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public synchronized Drawable m8306a(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i) {
        Drawable m8289f = m8289f(context, i);
        if (m8289f == null) {
            m8289f = vectorEnabledTintResources.m8130a(i);
        }
        if (m8289f != null) {
            return m8309a(context, i, false, m8289f);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m8311a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = p000a.p006b.p049h.p063k.AppCompatDrawableManager.f2717g
            int[] r1 = p000a.p006b.p049h.p063k.AppCompatDrawableManager.f2720j
            boolean r1 = m8299a(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L15
            int r2 = p000a.p006b.p049h.p051b.C0354a.colorControlNormal
        L12:
            r7 = 1
            r1 = -1
            goto L44
        L15:
            int[] r1 = p000a.p006b.p049h.p063k.AppCompatDrawableManager.f2722l
            boolean r1 = m8299a(r1, r7)
            if (r1 == 0) goto L20
            int r2 = p000a.p006b.p049h.p051b.C0354a.colorControlActivated
            goto L12
        L20:
            int[] r1 = p000a.p006b.p049h.p063k.AppCompatDrawableManager.f2723m
            boolean r1 = m8299a(r1, r7)
            if (r1 == 0) goto L2b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L12
        L2b:
            int r1 = p000a.p006b.p049h.p051b.C0358e.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L3c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = r7
            r7 = 1
            goto L44
        L3c:
            int r1 = p000a.p006b.p049h.p051b.C0358e.abc_dialog_material_background
            if (r7 != r1) goto L41
            goto L12
        L41:
            r7 = 0
            r1 = -1
            r2 = 0
        L44:
            if (r7 == 0) goto L61
            boolean r7 = p000a.p006b.p049h.p063k.C0475k0.m8283a(r8)
            if (r7 == 0) goto L50
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L50:
            int r6 = p000a.p006b.p049h.p063k.ThemeUtils.m8345b(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = m8316a(r6, r0)
            r8.setColorFilter(r6)
            if (r1 == r3) goto L60
            r8.setAlpha(r1)
        L60:
            return r5
        L61:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p063k.AppCompatDrawableManager.m8311a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    /* renamed from: a */
    public final void m8300a(String str, InterfaceC0473d interfaceC0473d) {
        if (this.f2727b == null) {
            this.f2727b = new ArrayMap<>();
        }
        this.f2727b.put(str, interfaceC0473d);
    }

    /* renamed from: a */
    public static boolean m8299a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static PorterDuff.Mode m8317a(int i) {
        if (i == C0358e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    /* renamed from: a */
    public final void m8312a(Context context, int i, ColorStateList colorStateList) {
        if (this.f2726a == null) {
            this.f2726a = new WeakHashMap<>();
        }
        SparseArrayCompat<ColorStateList> sparseArrayCompat = this.f2726a.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat<>();
            this.f2726a.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.m9604a(i, colorStateList);
    }

    /* renamed from: a */
    public final ColorStateList m8313a(Context context, int i) {
        int m8345b = ThemeUtils.m8345b(context, C0354a.colorControlHighlight);
        return new ColorStateList(new int[][]{ThemeUtils.f2643b, ThemeUtils.f2645d, ThemeUtils.f2644c, ThemeUtils.f2647f}, new int[]{ThemeUtils.m8347a(context, C0354a.colorButtonNormal), ColorUtils.m9926b(m8345b, i), ColorUtils.m9926b(m8345b, i), i});
    }

    /* renamed from: a */
    public static void m8302a(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (C0475k0.m8283a(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (tintInfo.f2716d || tintInfo.f2715c) {
            drawable.setColorFilter(m8305a(tintInfo.f2716d ? tintInfo.f2713a : null, tintInfo.f2715c ? tintInfo.f2714b : f2717g, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    /* renamed from: a */
    public static PorterDuffColorFilter m8305a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m8316a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: a */
    public static synchronized PorterDuffColorFilter m8316a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter m8288a;
        synchronized (AppCompatDrawableManager.class) {
            m8288a = f2719i.m8288a(i, mode);
            if (m8288a == null) {
                m8288a = new PorterDuffColorFilter(i, mode);
                f2719i.m8287a(i, mode, m8288a);
            }
        }
        return m8288a;
    }

    /* renamed from: a */
    public static void m8303a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (C0475k0.m8283a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f2717g;
        }
        drawable.setColorFilter(m8316a(i, mode));
    }

    /* renamed from: a */
    public final void m8314a(Context context) {
        if (this.f2731f) {
            return;
        }
        this.f2731f = true;
        Drawable m8295c = m8295c(context, C0358e.abc_vector_test);
        if (m8295c == null || !m8304a(m8295c)) {
            this.f2731f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    /* renamed from: a */
    public static boolean m8304a(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }
}
