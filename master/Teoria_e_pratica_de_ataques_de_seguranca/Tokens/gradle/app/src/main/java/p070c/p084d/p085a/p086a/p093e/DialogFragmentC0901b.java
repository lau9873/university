package p070c.p084d.p085a.p086a.p093e;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.b */
/* loaded from: classes.dex */
public class DialogFragmentC0901b extends DialogFragment {

    /* renamed from: a */
    public Dialog f5055a = null;

    /* renamed from: b */
    public DialogInterface.OnCancelListener f5056b = null;

    /* renamed from: a */
    public static DialogFragmentC0901b m5640a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        DialogFragmentC0901b dialogFragmentC0901b = new DialogFragmentC0901b();
        C1049c0.m5293a(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        dialogFragmentC0901b.f5055a = dialog2;
        if (onCancelListener != null) {
            dialogFragmentC0901b.f5056b = onCancelListener;
        }
        return dialogFragmentC0901b;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f5056b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f5055a == null) {
            setShowsDialog(false);
        }
        return this.f5055a;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
