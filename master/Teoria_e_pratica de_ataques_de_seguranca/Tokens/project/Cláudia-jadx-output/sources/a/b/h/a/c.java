package a.b.h.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertController;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
/* compiled from: AlertDialog.java */
/* loaded from: classes.dex */
public class c extends h implements DialogInterface {

    /* renamed from: c  reason: collision with root package name */
    public final AlertController f1272c;

    /* compiled from: AlertDialog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final AlertController.f f1273a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1274b;

        public a(Context context) {
            this(context, c.b(context, 0));
        }

        public a a(View view) {
            this.f1273a.f2409g = view;
            return this;
        }

        public Context b() {
            return this.f1273a.f2403a;
        }

        public c c() {
            c a2 = a();
            a2.show();
            return a2;
        }

        public a(Context context, int i2) {
            this.f1273a = new AlertController.f(new ContextThemeWrapper(context, c.b(context, i2)));
            this.f1274b = i2;
        }

        public a a(int i2) {
            AlertController.f fVar = this.f1273a;
            fVar.f2410h = fVar.f2403a.getText(i2);
            return this;
        }

        public a b(int i2) {
            AlertController.f fVar = this.f1273a;
            fVar.f2408f = fVar.f2403a.getText(i2);
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f1273a.f2410h = charSequence;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f1273a.f2408f = charSequence;
            return this;
        }

        public a a(Drawable drawable) {
            this.f1273a.f2406d = drawable;
            return this;
        }

        public a b(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1273a;
            fVar.f2411i = fVar.f2403a.getText(i2);
            this.f1273a.k = onClickListener;
            return this;
        }

        public a a(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1273a;
            fVar.l = fVar.f2403a.getText(i2);
            this.f1273a.n = onClickListener;
            return this;
        }

        public a b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1273a;
            fVar.f2411i = charSequence;
            fVar.k = onClickListener;
            return this;
        }

        public a a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1273a;
            fVar.l = charSequence;
            fVar.n = onClickListener;
            return this;
        }

        public a b(View view) {
            AlertController.f fVar = this.f1273a;
            fVar.z = view;
            fVar.y = 0;
            fVar.E = false;
            return this;
        }

        public a a(boolean z) {
            this.f1273a.r = z;
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.f1273a.t = onDismissListener;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f1273a.u = onKeyListener;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1273a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            return this;
        }

        public a a(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.f1273a;
            fVar.v = charSequenceArr;
            fVar.J = onMultiChoiceClickListener;
            fVar.F = zArr;
            fVar.G = true;
            return this;
        }

        public a a(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f1273a;
            fVar.v = charSequenceArr;
            fVar.x = onClickListener;
            fVar.I = i2;
            fVar.H = true;
            return this;
        }

        public c a() {
            c cVar = new c(this.f1273a.f2403a, this.f1274b);
            this.f1273a.a(cVar.f1272c);
            cVar.setCancelable(this.f1273a.r);
            if (this.f1273a.r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f1273a.s);
            cVar.setOnDismissListener(this.f1273a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f1273a.u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }
    }

    public c(Context context, int i2) {
        super(context, b(context, i2));
        this.f1272c = new AlertController(getContext(), this, getWindow());
    }

    public static int b(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.b.h.b.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // a.b.h.a.h, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1272c.a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f1272c.a(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f1272c.b(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // a.b.h.a.h, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1272c.b(charSequence);
    }
}
