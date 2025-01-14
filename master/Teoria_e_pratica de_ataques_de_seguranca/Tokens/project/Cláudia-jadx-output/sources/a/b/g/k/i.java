package a.b.g.k;

import android.view.MotionEvent;
/* compiled from: MotionEventCompat.java */
/* loaded from: classes.dex */
public final class i {
    public static boolean a(MotionEvent motionEvent, int i2) {
        return (motionEvent.getSource() & i2) == i2;
    }
}
