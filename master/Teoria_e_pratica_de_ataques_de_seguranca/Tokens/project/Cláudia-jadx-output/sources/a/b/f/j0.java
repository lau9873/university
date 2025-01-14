package a.b.f;

import android.os.IBinder;
/* compiled from: WindowIdApi14.java */
/* loaded from: classes.dex */
public class j0 implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f552a;

    public j0(IBinder iBinder) {
        this.f552a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j0) && ((j0) obj).f552a.equals(this.f552a);
    }

    public int hashCode() {
        return this.f552a.hashCode();
    }
}
