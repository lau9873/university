package a.b.g.l;

import a.b.g.i.b;
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
/* compiled from: TextViewCompat.java */
/* loaded from: classes.dex */
public final class p {
    public static void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (i2 >= 17) {
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

    public static void b(TextView textView, int i2) {
        int i3;
        a.b.g.j.m.a(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16 && !textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.descent;
        } else {
            i3 = fontMetricsInt.bottom;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static void d(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    public static b.a e(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new b.a(textView.getTextMetricsParams());
        }
        b.a.C0029a c0029a = new b.a.C0029a(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            c0029a.a(textView.getBreakStrategy());
            c0029a.b(textView.getHyphenationFrequency());
        }
        if (Build.VERSION.SDK_INT >= 18) {
            c0029a.a(d(textView));
        }
        return c0029a.a();
    }

    public static void c(TextView textView, int i2) {
        a.b.g.j.m.a(i2);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing(i2 - fontMetricsInt, 1.0f);
        }
    }

    public static TextDirectionHeuristic d(TextView textView) {
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

    public static Drawable[] a(TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (i2 >= 17) {
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

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static ActionMode.Callback a(TextView textView, ActionMode.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof a)) ? callback : new a(callback, textView);
    }

    public static void a(TextView textView, int i2) {
        int i3;
        a.b.g.j.m.a(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16 && !textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.ascent;
        } else {
            i3 = fontMetricsInt.top;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 - (-i3), textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    /* compiled from: TextViewCompat.java */
    /* loaded from: classes.dex */
    public static class a implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final ActionMode.Callback f1253a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1254b;

        /* renamed from: c  reason: collision with root package name */
        public Class f1255c;

        /* renamed from: d  reason: collision with root package name */
        public Method f1256d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1257e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1258f = false;

        public a(ActionMode.Callback callback, TextView textView) {
            this.f1253a = callback;
            this.f1254b = textView;
        }

        public final void a(Menu menu) {
            Context context = this.f1254b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f1258f) {
                this.f1258f = true;
                try {
                    this.f1255c = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f1256d = this.f1255c.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f1257e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f1255c = null;
                    this.f1256d = null;
                    this.f1257e = false;
                }
            }
            try {
                Method declaredMethod = (this.f1257e && this.f1255c.isInstance(menu)) ? this.f1256d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> a2 = a(context, packageManager);
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    ResolveInfo resolveInfo = a2.get(i2);
                    menu.add(0, 0, i2 + 100, resolveInfo.loadLabel(packageManager)).setIntent(a(resolveInfo, this.f1254b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f1253a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f1253a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f1253a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            a(menu);
            return this.f1253a.onPrepareActionMode(actionMode, menu);
        }

        public final List<ResolveInfo> a(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity) {
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                    if (a(resolveInfo, context)) {
                        arrayList.add(resolveInfo);
                    }
                }
                return arrayList;
            }
            return arrayList;
        }

        public final boolean a(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (resolveInfo.activityInfo.exported) {
                String str = resolveInfo.activityInfo.permission;
                return str == null || context.checkSelfPermission(str) == 0;
            }
            return false;
        }

        public final Intent a(ResolveInfo resolveInfo, TextView textView) {
            return a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !a(textView)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        public final boolean a(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        public final Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    public static void a(TextView textView, b.a aVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setTextDirection(a(aVar.c()));
        }
        if (Build.VERSION.SDK_INT < 23) {
            float textScaleX = aVar.d().getTextScaleX();
            textView.getPaint().set(aVar.d());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(aVar.d());
        textView.setBreakStrategy(aVar.a());
        textView.setHyphenationFrequency(aVar.b());
    }

    public static void a(TextView textView, a.b.g.i.b bVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setText(bVar.b());
        } else if (e(textView).equals(bVar.a())) {
            textView.setText(bVar);
        } else {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
    }

    public static int a(TextDirectionHeuristic textDirectionHeuristic) {
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
