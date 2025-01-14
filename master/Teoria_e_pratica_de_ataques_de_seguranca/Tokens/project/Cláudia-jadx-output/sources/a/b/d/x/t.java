package a.b.d.x;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
/* compiled from: VisibilityAwareImageButton.java */
/* loaded from: classes.dex */
public class t extends ImageButton {

    /* renamed from: a  reason: collision with root package name */
    public int f408a;

    public t(Context context) {
        this(context, null);
    }

    public final void a(int i2, boolean z) {
        super.setVisibility(i2);
        if (z) {
            this.f408a = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.f408a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        a(i2, true);
    }

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public t(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f408a = getVisibility();
    }
}
