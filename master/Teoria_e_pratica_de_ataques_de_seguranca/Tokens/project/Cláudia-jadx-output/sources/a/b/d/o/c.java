package a.b.d.o;

import a.b.d.o.d;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* compiled from: CircularRevealHelper.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f250a;

    /* compiled from: CircularRevealHelper.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f250a = 2;
        } else if (i2 >= 18) {
            f250a = 1;
        } else {
            f250a = 0;
        }
    }

    public void a() {
        throw null;
    }

    public void a(int i2) {
        throw null;
    }

    public void a(d.e eVar) {
        throw null;
    }

    public void a(Canvas canvas) {
        throw null;
    }

    public void a(Drawable drawable) {
        throw null;
    }

    public void b() {
        throw null;
    }

    public Drawable c() {
        throw null;
    }

    public int d() {
        throw null;
    }

    public d.e e() {
        throw null;
    }

    public boolean f() {
        throw null;
    }
}
