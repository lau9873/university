package p000a.p006b.p008b;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import p000a.p006b.p008b.p009h.p010j.C0027b;

/* renamed from: a.b.b.a */
/* loaded from: classes.dex */
public class Barrier extends ConstraintHelper {

    /* renamed from: g */
    public int f50g;

    /* renamed from: h */
    public int f51h;

    /* renamed from: i */
    public C0027b f52i;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // p000a.p006b.p008b.ConstraintHelper
    /* renamed from: a */
    public void mo11257a(AttributeSet attributeSet) {
        super.mo11257a(attributeSet);
        this.f52i = new C0027b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0023g.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0023g.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == C0023g.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f52i.m11146c(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f56d = this.f52i;
        m11259a();
    }

    public int getType() {
        return this.f50g;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f52i.m11146c(z);
    }

    public void setType(int i) {
        this.f50g = i;
        this.f51h = i;
        if (Build.VERSION.SDK_INT < 17) {
            int i2 = this.f50g;
            if (i2 == 5) {
                this.f51h = 0;
            } else if (i2 == 6) {
                this.f51h = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i3 = this.f50g;
                if (i3 == 5) {
                    this.f51h = 1;
                } else if (i3 == 6) {
                    this.f51h = 0;
                }
            } else {
                int i4 = this.f50g;
                if (i4 == 5) {
                    this.f51h = 0;
                } else if (i4 == 6) {
                    this.f51h = 1;
                }
            }
        }
        this.f52i.m11145u(this.f51h);
    }
}
