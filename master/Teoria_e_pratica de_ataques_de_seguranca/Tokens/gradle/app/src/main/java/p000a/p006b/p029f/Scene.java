package p000a.p006b.p029f;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: a.b.f.l */
/* loaded from: classes.dex */
public class Scene {

    /* renamed from: a */
    public ViewGroup f937a;

    /* renamed from: b */
    public Runnable f938b;

    /* renamed from: a */
    public void m10504a() {
        Runnable runnable;
        if (m10503a(this.f937a) != this || (runnable = this.f938b) == null) {
            return;
        }
        runnable.run();
    }

    /* renamed from: a */
    public static void m10502a(View view, Scene scene) {
        view.setTag(C0119j.transition_current_scene, scene);
    }

    /* renamed from: a */
    public static Scene m10503a(View view) {
        return (Scene) view.getTag(C0119j.transition_current_scene);
    }
}
