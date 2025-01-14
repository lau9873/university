package a.b.d.x;

import android.graphics.Outline;
/* compiled from: CircularBorderDrawableLollipop.java */
/* loaded from: classes.dex */
public class b extends a {
    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        copyBounds(this.f299b);
        outline.setOval(this.f299b);
    }
}
