package c.d.a.a.e.f;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
/* loaded from: classes.dex */
public abstract class y0 implements DialogInterface.OnClickListener {
    public static y0 a(Activity activity, Intent intent, int i2) {
        return new z0(intent, activity, i2);
    }

    public static y0 a(Fragment fragment, Intent intent, int i2) {
        return new a1(intent, fragment, i2);
    }

    public static y0 a(c.d.a.a.e.e.l.a1 a1Var, Intent intent, int i2) {
        return new b1(intent, a1Var, 2);
    }

    public abstract void a();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        try {
            a();
        } catch (ActivityNotFoundException e2) {
            Log.e("DialogRedirect", "Failed to start resolution intent", e2);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
