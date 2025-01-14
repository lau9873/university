package p070c.p084d.p085a.p086a.p093e;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import p000a.p006b.p030g.p031a.DialogFragment;
import p000a.p006b.p030g.p031a.FragmentManager;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.d */
/* loaded from: classes.dex */
public class C0904d extends DialogFragment {

    /* renamed from: i0 */
    public Dialog f5062i0 = null;

    /* renamed from: j0 */
    public DialogInterface.OnCancelListener f5063j0 = null;

    /* renamed from: a */
    public static C0904d m5623a(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        C0904d c0904d = new C0904d();
        C1049c0.m5293a(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        c0904d.f5062i0 = dialog2;
        if (onCancelListener != null) {
            c0904d.f5063j0 = onCancelListener;
        }
        return c0904d;
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment
    /* renamed from: a */
    public void mo5624a(FragmentManager fragmentManager, String str) {
        super.mo5624a(fragmentManager, str);
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment
    /* renamed from: n */
    public Dialog mo769n(Bundle bundle) {
        if (this.f5062i0 == null) {
            m10344m(false);
        }
        return this.f5062i0;
    }

    @Override // p000a.p006b.p030g.p031a.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f5063j0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }
}
