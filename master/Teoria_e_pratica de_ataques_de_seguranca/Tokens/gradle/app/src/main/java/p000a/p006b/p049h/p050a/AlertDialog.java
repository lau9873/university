package p000a.p006b.p049h.p050a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p067v7.app.AlertController;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import p000a.p006b.p049h.p051b.C0354a;

/* renamed from: a.b.h.a.c */
/* loaded from: classes.dex */
public class AlertDialog extends AppCompatDialog implements DialogInterface {

    /* renamed from: c */
    public final AlertController f1873c;

    /* compiled from: AlertDialog.java */
    /* renamed from: a.b.h.a.c$a */
    /* loaded from: classes.dex */
    public static class C0325a {

        /* renamed from: a */
        public final AlertController.C0644f f1874a;

        /* renamed from: b */
        public final int f1875b;

        public C0325a(Context context) {
            this(context, AlertDialog.m9149b(context, 0));
        }

        /* renamed from: a */
        public C0325a m9142a(View view) {
            this.f1874a.f3786g = view;
            return this;
        }

        /* renamed from: b */
        public Context m9135b() {
            return this.f1874a.f3780a;
        }

        /* renamed from: c */
        public AlertDialog m9129c() {
            AlertDialog m9148a = m9148a();
            m9148a.show();
            return m9148a;
        }

        public C0325a(Context context, int i) {
            this.f1874a = new AlertController.C0644f(new ContextThemeWrapper(context, AlertDialog.m9149b(context, i)));
            this.f1875b = i;
        }

        /* renamed from: a */
        public C0325a m9147a(int i) {
            AlertController.C0644f c0644f = this.f1874a;
            c0644f.f3787h = c0644f.f3780a.getText(i);
            return this;
        }

        /* renamed from: b */
        public C0325a m9134b(int i) {
            AlertController.C0644f c0644f = this.f1874a;
            c0644f.f3785f = c0644f.f3780a.getText(i);
            return this;
        }

        /* renamed from: a */
        public C0325a m9140a(CharSequence charSequence) {
            this.f1874a.f3787h = charSequence;
            return this;
        }

        /* renamed from: b */
        public C0325a m9131b(CharSequence charSequence) {
            this.f1874a.f3785f = charSequence;
            return this;
        }

        /* renamed from: a */
        public C0325a m9143a(Drawable drawable) {
            this.f1874a.f3783d = drawable;
            return this;
        }

        /* renamed from: b */
        public C0325a m9133b(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0644f c0644f = this.f1874a;
            c0644f.f3788i = c0644f.f3780a.getText(i);
            this.f1874a.f3790k = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C0325a m9146a(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0644f c0644f = this.f1874a;
            c0644f.f3791l = c0644f.f3780a.getText(i);
            this.f1874a.f3793n = onClickListener;
            return this;
        }

        /* renamed from: b */
        public C0325a m9130b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0644f c0644f = this.f1874a;
            c0644f.f3788i = charSequence;
            c0644f.f3790k = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C0325a m9139a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0644f c0644f = this.f1874a;
            c0644f.f3791l = charSequence;
            c0644f.f3793n = onClickListener;
            return this;
        }

        /* renamed from: b */
        public C0325a m9132b(View view) {
            AlertController.C0644f c0644f = this.f1874a;
            c0644f.f3805z = view;
            c0644f.f3804y = 0;
            c0644f.f3769E = false;
            return this;
        }

        /* renamed from: a */
        public C0325a m9138a(boolean z) {
            this.f1874a.f3797r = z;
            return this;
        }

        /* renamed from: a */
        public C0325a m9145a(DialogInterface.OnDismissListener onDismissListener) {
            this.f1874a.f3799t = onDismissListener;
            return this;
        }

        /* renamed from: a */
        public C0325a m9144a(DialogInterface.OnKeyListener onKeyListener) {
            this.f1874a.f3800u = onKeyListener;
            return this;
        }

        /* renamed from: a */
        public C0325a m9141a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0644f c0644f = this.f1874a;
            c0644f.f3802w = listAdapter;
            c0644f.f3803x = onClickListener;
            return this;
        }

        /* renamed from: a */
        public C0325a m9136a(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.C0644f c0644f = this.f1874a;
            c0644f.f3801v = charSequenceArr;
            c0644f.f3774J = onMultiChoiceClickListener;
            c0644f.f3770F = zArr;
            c0644f.f3771G = true;
            return this;
        }

        /* renamed from: a */
        public C0325a m9137a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0644f c0644f = this.f1874a;
            c0644f.f3801v = charSequenceArr;
            c0644f.f3803x = onClickListener;
            c0644f.f3773I = i;
            c0644f.f3772H = true;
            return this;
        }

        /* renamed from: a */
        public AlertDialog m9148a() {
            AlertDialog alertDialog = new AlertDialog(this.f1874a.f3780a, this.f1875b);
            this.f1874a.m7282a(alertDialog.f1873c);
            alertDialog.setCancelable(this.f1874a.f3797r);
            if (this.f1874a.f3797r) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f1874a.f3798s);
            alertDialog.setOnDismissListener(this.f1874a.f3799t);
            DialogInterface.OnKeyListener onKeyListener = this.f1874a.f3800u;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }
    }

    public AlertDialog(Context context, int i) {
        super(context, m9149b(context, i));
        this.f1873c = new AlertController(getContext(), this, getWindow());
    }

    /* renamed from: b */
    public static int m9149b(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0354a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1873c.m7309a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f1873c.m7307a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f1873c.m7293b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // p000a.p006b.p049h.p050a.AppCompatDialog, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1873c.m7290b(charSequence);
    }
}
