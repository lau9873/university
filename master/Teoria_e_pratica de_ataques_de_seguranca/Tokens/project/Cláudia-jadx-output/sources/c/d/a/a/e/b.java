package c.d.a.a.e;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import c.d.a.a.e.f.c0;
/* loaded from: classes.dex */
public class b extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Dialog f3217a = null;

    /* renamed from: b  reason: collision with root package name */
    public DialogInterface.OnCancelListener f3218b = null;

    public static b a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        b bVar = new b();
        c0.a(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        bVar.f3217a = dialog2;
        if (onCancelListener != null) {
            bVar.f3218b = onCancelListener;
        }
        return bVar;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f3218b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f3217a == null) {
            setShowsDialog(false);
        }
        return this.f3217a;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
