package p070c.p084d.p085a.p086a.p093e.p096f;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.p065v4.app.Fragment;
import android.util.Log;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1;

/* renamed from: c.d.a.a.e.f.y0 */
/* loaded from: classes.dex */
public abstract class AbstractDialogInterface$OnClickListenerC1094y0 implements DialogInterface.OnClickListener {
    /* renamed from: a */
    public static AbstractDialogInterface$OnClickListenerC1094y0 m5153a(Activity activity, Intent intent, int i) {
        return new C1096z0(intent, activity, i);
    }

    /* renamed from: a */
    public static AbstractDialogInterface$OnClickListenerC1094y0 m5152a(Fragment fragment, Intent intent, int i) {
        return new C1044a1(intent, fragment, i);
    }

    /* renamed from: a */
    public static AbstractDialogInterface$OnClickListenerC1094y0 m5151a(InterfaceC0935a1 interfaceC0935a1, Intent intent, int i) {
        return new C1047b1(intent, interfaceC0935a1, 2);
    }

    /* renamed from: a */
    public abstract void mo5148a();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            mo5148a();
        } catch (ActivityNotFoundException e) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
