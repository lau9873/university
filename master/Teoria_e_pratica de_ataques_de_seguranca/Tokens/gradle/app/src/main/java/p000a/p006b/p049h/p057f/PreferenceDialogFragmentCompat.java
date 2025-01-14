package p000a.p006b.p049h.p057f;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p065v4.app.Fragment;
import android.support.p067v7.preference.DialogPreference;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import p000a.p006b.p030g.p031a.DialogFragment;
import p000a.p006b.p030g.p031a.FragmentActivity;
import p000a.p006b.p049h.p050a.AlertDialog;

/* renamed from: a.b.h.f.f */
/* loaded from: classes.dex */
public abstract class PreferenceDialogFragmentCompat extends DialogFragment implements DialogInterface.OnClickListener {

    /* renamed from: i0 */
    public DialogPreference f2132i0;

    /* renamed from: j0 */
    public CharSequence f2133j0;

    /* renamed from: k0 */
    public CharSequence f2134k0;

    /* renamed from: l0 */
    public CharSequence f2135l0;

    /* renamed from: m0 */
    public CharSequence f2136m0;

    /* renamed from: n0 */
    public int f2137n0;

    /* renamed from: o0 */
    public BitmapDrawable f2138o0;

    /* renamed from: p0 */
    public int f2139p0;

    /* renamed from: a */
    public void mo8882a(AlertDialog.C0325a c0325a) {
    }

    /* renamed from: a */
    public final void m8881a(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    /* renamed from: b */
    public View m8880b(Context context) {
        int i = this.f2137n0;
        if (i == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i, (ViewGroup) null);
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        Fragment m7544G = m7544G();
        if (m7544G instanceof DialogPreference.InterfaceC0654a) {
            DialogPreference.InterfaceC0654a interfaceC0654a = (DialogPreference.InterfaceC0654a) m7544G;
            String string = m7454o().getString("key");
            if (bundle == null) {
                this.f2132i0 = (DialogPreference) interfaceC0654a.mo7270a(string);
                this.f2133j0 = this.f2132i0.m7273M();
                this.f2134k0 = this.f2132i0.m7271O();
                this.f2135l0 = this.f2132i0.m7272N();
                this.f2136m0 = this.f2132i0.m7274L();
                this.f2137n0 = this.f2132i0.m7275K();
                Drawable m7276J = this.f2132i0.m7276J();
                if (m7276J != null && !(m7276J instanceof BitmapDrawable)) {
                    Bitmap createBitmap = Bitmap.createBitmap(m7276J.getIntrinsicWidth(), m7276J.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    m7276J.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    m7276J.draw(canvas);
                    this.f2138o0 = new BitmapDrawable(m7549B(), createBitmap);
                    return;
                }
                this.f2138o0 = (BitmapDrawable) m7276J;
                return;
            }
            this.f2133j0 = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f2134k0 = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f2135l0 = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f2136m0 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f2137n0 = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f2138o0 = new BitmapDrawable(m7549B(), bitmap);
                return;
            }
            return;
        }
        throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment, android.support.p065v4.app.Fragment
    /* renamed from: e */
    public void mo924e(Bundle bundle) {
        super.mo924e(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f2133j0);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f2134k0);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f2135l0);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f2136m0);
        bundle.putInt("PreferenceDialogFragment.layout", this.f2137n0);
        BitmapDrawable bitmapDrawable = this.f2138o0;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment
    /* renamed from: n */
    public Dialog mo769n(Bundle bundle) {
        FragmentActivity m7468j = m7468j();
        this.f2139p0 = -2;
        AlertDialog.C0325a c0325a = new AlertDialog.C0325a(m7468j);
        c0325a.m9131b(this.f2133j0);
        c0325a.m9143a(this.f2138o0);
        c0325a.m9130b(this.f2134k0, this);
        c0325a.m9139a(this.f2135l0, this);
        View m8880b = m8880b((Context) m7468j);
        if (m8880b != null) {
            mo8879b(m8880b);
            c0325a.m9132b(m8880b);
        } else {
            c0325a.m9140a(this.f2136m0);
        }
        mo8882a(c0325a);
        AlertDialog m9148a = c0325a.m9148a();
        if (mo8876p0()) {
            m8881a((Dialog) m9148a);
        }
        return m9148a;
    }

    /* renamed from: n */
    public abstract void mo8878n(boolean z);

    /* renamed from: o0 */
    public DialogPreference m8877o0() {
        if (this.f2132i0 == null) {
            this.f2132i0 = (DialogPreference) ((DialogPreference.InterfaceC0654a) m7544G()).mo7270a(m7454o().getString("key"));
        }
        return this.f2132i0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2139p0 = i;
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        mo8878n(this.f2139p0 == -1);
    }

    /* renamed from: p0 */
    public boolean mo8876p0() {
        return false;
    }

    /* renamed from: b */
    public void mo8879b(View view) {
        View findViewById = view.findViewById(16908299);
        if (findViewById != null) {
            CharSequence charSequence = this.f2136m0;
            int i = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i = 0;
            }
            if (findViewById.getVisibility() != i) {
                findViewById.setVisibility(i);
            }
        }
    }
}
