package a.b.h.f;

import a.b.h.a.c;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.preference.DialogPreference;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/* compiled from: PreferenceDialogFragmentCompat.java */
/* loaded from: classes.dex */
public abstract class f extends a.b.g.a.f implements DialogInterface.OnClickListener {
    public DialogPreference i0;
    public CharSequence j0;
    public CharSequence k0;
    public CharSequence l0;
    public CharSequence m0;
    public int n0;
    public BitmapDrawable o0;
    public int p0;

    public void a(c.a aVar) {
    }

    public final void a(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    public View b(Context context) {
        int i2 = this.n0;
        if (i2 == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i2, (ViewGroup) null);
    }

    @Override // a.b.g.a.f, android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        Fragment G = G();
        if (G instanceof DialogPreference.a) {
            DialogPreference.a aVar = (DialogPreference.a) G;
            String string = o().getString("key");
            if (bundle == null) {
                this.i0 = (DialogPreference) aVar.a(string);
                this.j0 = this.i0.M();
                this.k0 = this.i0.O();
                this.l0 = this.i0.N();
                this.m0 = this.i0.L();
                this.n0 = this.i0.K();
                Drawable J = this.i0.J();
                if (J != null && !(J instanceof BitmapDrawable)) {
                    Bitmap createBitmap = Bitmap.createBitmap(J.getIntrinsicWidth(), J.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    J.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    J.draw(canvas);
                    this.o0 = new BitmapDrawable(B(), createBitmap);
                    return;
                }
                this.o0 = (BitmapDrawable) J;
                return;
            }
            this.j0 = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.k0 = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.l0 = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.m0 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.n0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.o0 = new BitmapDrawable(B(), bitmap);
                return;
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    @Override // a.b.g.a.f, android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.j0);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.k0);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.l0);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.m0);
        bundle.putInt("PreferenceDialogFragment.layout", this.n0);
        BitmapDrawable bitmapDrawable = this.o0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    @Override // a.b.g.a.f
    public Dialog n(Bundle bundle) {
        a.b.g.a.g j = j();
        this.p0 = -2;
        c.a aVar = new c.a(j);
        aVar.b(this.j0);
        aVar.a(this.o0);
        aVar.b(this.k0, this);
        aVar.a(this.l0, this);
        View b2 = b((Context) j);
        if (b2 != null) {
            b(b2);
            aVar.b(b2);
        } else {
            aVar.a(this.m0);
        }
        a(aVar);
        a.b.h.a.c a2 = aVar.a();
        if (p0()) {
            a((Dialog) a2);
        }
        return a2;
    }

    public abstract void n(boolean z);

    public DialogPreference o0() {
        if (this.i0 == null) {
            this.i0 = (DialogPreference) ((DialogPreference.a) G()).a(o().getString("key"));
        }
        return this.i0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.p0 = i2;
    }

    @Override // a.b.g.a.f, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        n(this.p0 == -1);
    }

    public boolean p0() {
        return false;
    }

    public void b(View view) {
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence charSequence = this.m0;
            int i2 = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i2 = 0;
            }
            if (findViewById.getVisibility() != i2) {
                findViewById.setVisibility(i2);
            }
        }
    }
}
