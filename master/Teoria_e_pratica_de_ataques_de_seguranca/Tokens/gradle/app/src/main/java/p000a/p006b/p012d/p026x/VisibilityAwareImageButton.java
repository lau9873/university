package p000a.p006b.p012d.p026x;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* renamed from: a.b.d.x.t */
/* loaded from: classes.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* renamed from: a */
    public int f750a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m10647a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f750a = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f750a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        m10647a(i, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f750a = getVisibility();
    }
}
