package c.d.a.a.e;

import a.b.g.a.f;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import c.d.a.a.e.f.c0;
/* loaded from: classes.dex */
public class d extends f {
    public Dialog i0 = null;
    public DialogInterface.OnCancelListener j0 = null;

    public static d a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        d dVar = new d();
        c0.a(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        dVar.i0 = dialog2;
        if (onCancelListener != null) {
            dVar.j0 = onCancelListener;
        }
        return dVar;
    }

    @Override // a.b.g.a.f
    public void a(a.b.g.a.k kVar, String str) {
        super.a(kVar, str);
    }

    @Override // a.b.g.a.f
    public Dialog n(Bundle bundle) {
        if (this.i0 == null) {
            m(false);
        }
        return this.i0;
    }

    @Override // a.b.g.a.f, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.j0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
