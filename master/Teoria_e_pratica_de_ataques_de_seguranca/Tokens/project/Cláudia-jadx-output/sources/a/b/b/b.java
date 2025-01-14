package a.b.b;

import a.b.b.h.j.j;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.util.Arrays;
/* compiled from: ConstraintHelper.java */
/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: a  reason: collision with root package name */
    public int[] f54a;

    /* renamed from: b  reason: collision with root package name */
    public int f55b;

    /* renamed from: c  reason: collision with root package name */
    public Context f56c;

    /* renamed from: d  reason: collision with root package name */
    public j f57d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58e;

    /* renamed from: f  reason: collision with root package name */
    public String f59f;

    public b(Context context) {
        super(context);
        this.f54a = new int[32];
        this.f58e = false;
        this.f56c = context;
        a((AttributeSet) null);
    }

    private void setIds(String str) {
        if (str == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(44, i2);
            if (indexOf == -1) {
                a(str.substring(i2));
                return;
            } else {
                a(str.substring(i2, indexOf));
                i2 = indexOf + 1;
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
    }

    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, g.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == g.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f59f = obtainStyledAttributes.getString(index);
                    setIds(this.f59f);
                }
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f59f);
        }
        j jVar = this.f57d;
        if (jVar == null) {
            return;
        }
        jVar.K();
        for (int i2 = 0; i2 < this.f55b; i2++) {
            View b2 = constraintLayout.b(this.f54a[i2]);
            if (b2 != null) {
                this.f57d.b(constraintLayout.a(b2));
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f54a, this.f55b);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f58e) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f55b = 0;
        for (int i2 : iArr) {
            setTag(i2, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i2, Object obj) {
        int i3 = this.f55b + 1;
        int[] iArr = this.f54a;
        if (i3 > iArr.length) {
            this.f54a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f54a;
        int i4 = this.f55b;
        iArr2[i4] = i2;
        this.f55b = i4 + 1;
    }

    public void a() {
        if (this.f57d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).k0 = this.f57d;
        }
    }

    public final void a(String str) {
        int i2;
        Object a2;
        if (str == null || this.f56c == null) {
            return;
        }
        String trim = str.trim();
        try {
            i2 = f.class.getField(trim).getInt(null);
        } catch (Exception unused) {
            i2 = 0;
        }
        if (i2 == 0) {
            i2 = this.f56c.getResources().getIdentifier(trim, DatabaseFieldConfigLoader.FIELD_NAME_ID, this.f56c.getPackageName());
        }
        if (i2 == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) getParent()).a(0, trim)) != null && (a2 instanceof Integer)) {
            i2 = ((Integer) a2).intValue();
        }
        if (i2 != 0) {
            setTag(i2, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }
}
