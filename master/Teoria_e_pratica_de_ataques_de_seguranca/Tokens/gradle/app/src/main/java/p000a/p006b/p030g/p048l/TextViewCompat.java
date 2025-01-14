package p000a.p006b.p030g.p048l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p030g.p043i.PrecomputedTextCompat;
import p000a.p006b.p030g.p044j.Preconditions;

/* renamed from: a.b.g.l.p */
/* loaded from: classes.dex */
public final class TextViewCompat {
    /* renamed from: a */
    public static void m9212a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (i >= 17) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: b */
    public static void m9209b(TextView textView, int i) {
        int i2;
        Preconditions.m9622a(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16 && !textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.descent;
        } else {
            i2 = fontMetricsInt.bottom;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    /* renamed from: c */
    public static int m9208c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    /* renamed from: d */
    public static void m9205d(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    /* renamed from: e */
    public static PrecomputedTextCompat.C0258a m9204e(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PrecomputedTextCompat.C0258a(textView.getTextMetricsParams());
        }
        PrecomputedTextCompat.C0258a.C0259a c0259a = new PrecomputedTextCompat.C0258a.C0259a(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            c0259a.m9694a(textView.getBreakStrategy());
            c0259a.m9692b(textView.getHyphenationFrequency());
        }
        if (Build.VERSION.SDK_INT >= 18) {
            c0259a.m9693a(m9206d(textView));
        }
        return c0259a.m9695a();
    }

    /* renamed from: c */
    public static void m9207c(TextView textView, int i) {
        Preconditions.m9622a(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing(i - fontMetricsInt, 1.0f);
        }
    }

    /* renamed from: d */
    public static TextDirectionHeuristic m9206d(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality != 1 && directionality != 2) {
                return TextDirectionHeuristics.LTR;
            }
            return TextDirectionHeuristics.RTL;
        }
        boolean z = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                if (z) {
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                }
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    /* renamed from: a */
    public static Drawable[] m9216a(TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (i >= 17) {
            boolean z = textView.getLayoutDirection() == 1;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (z) {
                Drawable drawable = compoundDrawables[2];
                Drawable drawable2 = compoundDrawables[0];
                compoundDrawables[0] = drawable;
                compoundDrawables[2] = drawable2;
            }
            return compoundDrawables;
        }
        return textView.getCompoundDrawables();
    }

    /* renamed from: b */
    public static int m9210b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    /* renamed from: a */
    public static ActionMode.Callback m9211a(TextView textView, ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof ActionMode$CallbackC0317a)) ? callback : new ActionMode$CallbackC0317a(callback, textView);
    }

    /* renamed from: a */
    public static void m9215a(TextView textView, int i) {
        int i2;
        Preconditions.m9622a(i);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16 && !textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.ascent;
        } else {
            i2 = fontMetricsInt.top;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i - (-i2), textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    /* compiled from: TextViewCompat.java */
    /* renamed from: a.b.g.l.p$a */
    /* loaded from: classes.dex */
    public static class ActionMode$CallbackC0317a implements ActionMode.Callback {

        /* renamed from: a */
        public final ActionMode.Callback f1840a;

        /* renamed from: b */
        public final TextView f1841b;

        /* renamed from: c */
        public Class f1842c;

        /* renamed from: d */
        public Method f1843d;

        /* renamed from: e */
        public boolean f1844e;

        /* renamed from: f */
        public boolean f1845f = false;

        public ActionMode$CallbackC0317a(ActionMode.Callback callback, TextView textView) {
            this.f1840a = callback;
            this.f1841b = textView;
        }

        /* renamed from: a */
        public final void m9199a(Menu menu) {
            Context context = this.f1841b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f1845f) {
                this.f1845f = true;
                try {
                    this.f1842c = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f1843d = this.f1842c.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f1844e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f1842c = null;
                    this.f1843d = null;
                    this.f1844e = false;
                }
            }
            try {
                Method declaredMethod = (this.f1844e && this.f1842c.isInstance(menu)) ? this.f1843d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> m9202a = m9202a(context, packageManager);
                for (int i = 0; i < m9202a.size(); i++) {
                    ResolveInfo resolveInfo = m9202a.get(i);
                    menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(m9200a(resolveInfo, this.f1841b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f1840a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f1840a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f1840a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            m9199a(menu);
            return this.f1840a.onPrepareActionMode(actionMode, menu);
        }

        /* renamed from: a */
        public final List<ResolveInfo> m9202a(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity) {
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(m9203a(), 0)) {
                    if (m9201a(resolveInfo, context)) {
                        arrayList.add(resolveInfo);
                    }
                }
                return arrayList;
            }
            return arrayList;
        }

        /* renamed from: a */
        public final boolean m9201a(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (resolveInfo.activityInfo.exported) {
                String str = resolveInfo.activityInfo.permission;
                return str == null || context.checkSelfPermission(str) == 0;
            }
            return false;
        }

        /* renamed from: a */
        public final Intent m9200a(ResolveInfo resolveInfo, TextView textView) {
            return m9203a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !m9198a(textView)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        /* renamed from: a */
        public final boolean m9198a(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        /* renamed from: a */
        public final Intent m9203a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    /* renamed from: a */
    public static void m9214a(TextView textView, PrecomputedTextCompat.C0258a c0258a) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setTextDirection(m9217a(c0258a.m9697c()));
        }
        if (Build.VERSION.SDK_INT < 23) {
            float textScaleX = c0258a.m9696d().getTextScaleX();
            textView.getPaint().set(c0258a.m9696d());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(c0258a.m9696d());
        textView.setBreakStrategy(c0258a.m9699a());
        textView.setHyphenationFrequency(c0258a.m9698b());
    }

    /* renamed from: a */
    public static void m9213a(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setText(precomputedTextCompat.m9700b());
        } else if (m9204e(textView).equals(precomputedTextCompat.m9701a())) {
            textView.setText(precomputedTextCompat);
        } else {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
    }

    /* renamed from: a */
    public static int m9217a(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }
}
