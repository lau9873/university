package a.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: g  reason: collision with root package name */
    public int f51g;

    /* renamed from: h  reason: collision with root package name */
    public int f52h;

    /* renamed from: i  reason: collision with root package name */
    public a.b.b.h.j.b f53i;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // a.b.b.b
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f53i = new a.b.b.h.j.b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == g.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == g.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f53i.c(obtainStyledAttributes.getBoolean(index, true));
                }
            }
        }
        this.f57d = this.f53i;
        a();
    }

    public int getType() {
        return this.f51g;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f53i.c(z);
    }

    public void setType(int i2) {
        this.f51g = i2;
        this.f52h = i2;
        if (Build.VERSION.SDK_INT < 17) {
            int i3 = this.f51g;
            if (i3 == 5) {
                this.f52h = 0;
            } else if (i3 == 6) {
                this.f52h = 1;
            }
        } else {
            if (1 == getResources().getConfiguration().getLayoutDirection()) {
                int i4 = this.f51g;
                if (i4 == 5) {
                    this.f52h = 1;
                } else if (i4 == 6) {
                    this.f52h = 0;
                }
            } else {
                int i5 = this.f51g;
                if (i5 == 5) {
                    this.f52h = 0;
                } else if (i5 == 6) {
                    this.f52h = 1;
                }
            }
        }
        this.f53i.u(this.f52h);
    }
}
