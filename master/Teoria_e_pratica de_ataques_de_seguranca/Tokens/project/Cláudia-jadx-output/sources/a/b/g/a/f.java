package a.b.g.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
/* compiled from: DialogFragment.java */
/* loaded from: classes.dex */
public class f extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public int Z = 0;
    public int a0 = 0;
    public boolean b0 = true;
    public boolean c0 = true;
    public int d0 = -1;
    public Dialog e0;
    public boolean f0;
    public boolean g0;
    public boolean h0;

    @Override // android.support.v4.app.Fragment
    public void W() {
        super.W();
        Dialog dialog = this.e0;
        if (dialog != null) {
            this.f0 = true;
            dialog.dismiss();
            this.e0 = null;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void X() {
        super.X();
        if (this.h0 || this.g0) {
            return;
        }
        this.g0 = true;
    }

    public void a(k kVar, String str) {
        this.g0 = false;
        this.h0 = true;
        q a2 = kVar.a();
        a2.a(this, str);
        a2.a();
    }

    @Override // android.support.v4.app.Fragment
    public void a0() {
        super.a0();
        Dialog dialog = this.e0;
        if (dialog != null) {
            this.f0 = false;
            dialog.show();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void b(Bundle bundle) {
        Bundle bundle2;
        super.b(bundle);
        if (this.c0) {
            View H = H();
            if (H != null) {
                if (H.getParent() == null) {
                    this.e0.setContentView(H);
                } else {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
            }
            g j = j();
            if (j != null) {
                this.e0.setOwnerActivity(j);
            }
            this.e0.setCancelable(this.b0);
            this.e0.setOnCancelListener(this);
            this.e0.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.e0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void b0() {
        super.b0();
        Dialog dialog = this.e0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void c(Bundle bundle) {
        super.c(bundle);
        this.c0 = this.z == 0;
        if (bundle != null) {
            this.Z = bundle.getInt("android:style", 0);
            this.a0 = bundle.getInt("android:theme", 0);
            this.b0 = bundle.getBoolean("android:cancelable", true);
            this.c0 = bundle.getBoolean("android:showsDialog", this.c0);
            this.d0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public LayoutInflater d(Bundle bundle) {
        if (!this.c0) {
            return super.d(bundle);
        }
        this.e0 = n(bundle);
        Dialog dialog = this.e0;
        if (dialog != null) {
            a(dialog, this.Z);
            return (LayoutInflater) this.e0.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater) this.t.c().getSystemService("layout_inflater");
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.e(bundle);
        Dialog dialog = this.e0;
        if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i2 = this.Z;
        if (i2 != 0) {
            bundle.putInt("android:style", i2);
        }
        int i3 = this.a0;
        if (i3 != 0) {
            bundle.putInt("android:theme", i3);
        }
        boolean z = this.b0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.c0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i4 = this.d0;
        if (i4 != -1) {
            bundle.putInt("android:backStackId", i4);
        }
    }

    public void k(boolean z) {
        if (this.g0) {
            return;
        }
        this.g0 = true;
        this.h0 = false;
        Dialog dialog = this.e0;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f0 = true;
        if (this.d0 >= 0) {
            v().a(this.d0, 1);
            this.d0 = -1;
            return;
        }
        q a2 = v().a();
        a2.a(this);
        if (z) {
            a2.b();
        } else {
            a2.a();
        }
    }

    public void l(boolean z) {
        this.b0 = z;
        Dialog dialog = this.e0;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void m(boolean z) {
        this.c0 = z;
    }

    public Dialog n(Bundle bundle) {
        throw null;
    }

    public void n0() {
        k(false);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f0) {
            return;
        }
        k(true);
    }

    @Override // android.support.v4.app.Fragment
    public void a(Context context) {
        super.a(context);
        if (this.h0) {
            return;
        }
        this.g0 = false;
    }

    public void a(Dialog dialog, int i2) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            }
            dialog.getWindow().addFlags(24);
        }
        dialog.requestWindowFeature(1);
    }
}
