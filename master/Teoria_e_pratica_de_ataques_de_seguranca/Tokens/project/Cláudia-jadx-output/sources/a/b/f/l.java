package a.b.f;

import android.view.View;
import android.view.ViewGroup;
/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f555a;

    /* renamed from: b  reason: collision with root package name */
    public Runnable f556b;

    public void a() {
        Runnable runnable;
        if (a(this.f555a) != this || (runnable = this.f556b) == null) {
            return;
        }
        runnable.run();
    }

    public static void a(View view, l lVar) {
        view.setTag(j.transition_current_scene, lVar);
    }

    public static l a(View view) {
        return (l) view.getTag(j.transition_current_scene);
    }
}
