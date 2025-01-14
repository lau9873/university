package p000a.p006b.p012d.p026x;

import android.graphics.Outline;

/* renamed from: a.b.d.x.b */
/* loaded from: classes.dex */
public class CircularBorderDrawableLollipop extends CircularBorderDrawable {
    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        copyBounds(this.f554b);
        outline.setOval(this.f554b);
    }
}
