package p000a.p006b.p030g.p031a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p065v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

/* renamed from: a.b.g.a.f */
/* loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* renamed from: Z */
    public int f1098Z = 0;

    /* renamed from: a0 */
    public int f1099a0 = 0;

    /* renamed from: b0 */
    public boolean f1100b0 = true;

    /* renamed from: c0 */
    public boolean f1101c0 = true;

    /* renamed from: d0 */
    public int f1102d0 = -1;

    /* renamed from: e0 */
    public Dialog f1103e0;

    /* renamed from: f0 */
    public boolean f1104f0;

    /* renamed from: g0 */
    public boolean f1105g0;

    /* renamed from: h0 */
    public boolean f1106h0;

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: W */
    public void mo7529W() {
        super.mo7529W();
        Dialog dialog = this.f1103e0;
        if (dialog != null) {
            this.f1104f0 = true;
            dialog.dismiss();
            this.f1103e0 = null;
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: X */
    public void mo779X() {
        super.mo779X();
        if (this.f1106h0 || this.f1105g0) {
            return;
        }
        this.f1105g0 = true;
    }

    /* renamed from: a */
    public void mo5624a(FragmentManager fragmentManager, String str) {
        this.f1105g0 = false;
        this.f1106h0 = true;
        FragmentTransaction mo10264a = fragmentManager.mo10264a();
        mo10264a.mo10142a(this, str);
        mo10264a.mo10146a();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a0 */
    public void mo5376a0() {
        super.mo5376a0();
        Dialog dialog = this.f1103e0;
        if (dialog != null) {
            this.f1104f0 = false;
            dialog.show();
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: b */
    public void mo7503b(Bundle bundle) {
        Bundle bundle2;
        super.mo7503b(bundle);
        if (this.f1101c0) {
            View m7543H = m7543H();
            if (m7543H != null) {
                if (m7543H.getParent() == null) {
                    this.f1103e0.setContentView(m7543H);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            FragmentActivity m7468j = m7468j();
            if (m7468j != null) {
                this.f1103e0.setOwnerActivity(m7468j);
            }
            this.f1103e0.setCancelable(this.f1100b0);
            this.f1103e0.setOnCancelListener(this);
            this.f1103e0.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.f1103e0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: b0 */
    public void mo883b0() {
        super.mo883b0();
        Dialog dialog = this.f1103e0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f1101c0 = this.f3511z == 0;
        if (bundle != null) {
            this.f1098Z = bundle.getInt("android:style", 0);
            this.f1099a0 = bundle.getInt("android:theme", 0);
            this.f1100b0 = bundle.getBoolean("android:cancelable", true);
            this.f1101c0 = bundle.getBoolean("android:showsDialog", this.f1101c0);
            this.f1102d0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: d */
    public LayoutInflater mo7490d(Bundle bundle) {
        if (!this.f1101c0) {
            return super.mo7490d(bundle);
        }
        this.f1103e0 = mo769n(bundle);
        Dialog dialog = this.f1103e0;
        if (dialog != null) {
            m10347a(dialog, this.f1098Z);
            return (LayoutInflater) this.f1103e0.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) this.f3505t.m10291c().getSystemService("layout_inflater");
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: e */
    public void mo924e(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.mo924e(bundle);
        Dialog dialog = this.f1103e0;
        if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.f1098Z;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.f1099a0;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.f1100b0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.f1101c0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.f1102d0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    /* renamed from: k */
    public void m10346k(boolean z) {
        if (this.f1105g0) {
            return;
        }
        this.f1105g0 = true;
        this.f1106h0 = false;
        Dialog dialog = this.f1103e0;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f1104f0 = true;
        if (this.f1102d0 >= 0) {
            m7447v().mo10262a(this.f1102d0, 1);
            this.f1102d0 = -1;
            return;
        }
        FragmentTransaction mo10264a = m7447v().mo10264a();
        mo10264a.mo10143a(this);
        if (z) {
            mo10264a.mo10140b();
        } else {
            mo10264a.mo10146a();
        }
    }

    /* renamed from: l */
    public void m10345l(boolean z) {
        this.f1100b0 = z;
        Dialog dialog = this.f1103e0;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    /* renamed from: m */
    public void m10344m(boolean z) {
        this.f1101c0 = z;
    }

    /* renamed from: n */
    public Dialog mo769n(Bundle bundle) {
        throw null;
    }

    /* renamed from: n0 */
    public void m10343n0() {
        m10346k(false);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f1104f0) {
            return;
        }
        m10346k(true);
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public void mo778a(Context context) {
        super.mo778a(context);
        if (this.f1106h0) {
            return;
        }
        this.f1105g0 = false;
    }

    /* renamed from: a */
    public void m10347a(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            dialog.getWindow().addFlags(24);
        }
        dialog.requestWindowFeature(1);
    }
}
