package a.b.f;

import android.view.View;
import android.view.WindowId;
/* compiled from: WindowIdApi18.java */
/* loaded from: classes.dex */
public class k0 implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public final WindowId f554a;

    public k0(View view) {
        this.f554a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof k0) && ((k0) obj).f554a.equals(this.f554a);
    }

    public int hashCode() {
        return this.f554a.hashCode();
    }
}
