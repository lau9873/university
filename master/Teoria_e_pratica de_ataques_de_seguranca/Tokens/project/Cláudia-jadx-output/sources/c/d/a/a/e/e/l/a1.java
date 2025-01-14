package c.d.a.a.e.e.l;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleCallback;
/* loaded from: classes.dex */
public interface a1 {
    <T extends LifecycleCallback> T a(String str, Class<T> cls);

    void a(String str, LifecycleCallback lifecycleCallback);

    Activity c();

    void startActivityForResult(Intent intent, int i2);
}
