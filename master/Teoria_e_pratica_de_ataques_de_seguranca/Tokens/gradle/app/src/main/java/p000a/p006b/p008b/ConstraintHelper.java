package p000a.p006b.p008b;

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
import p000a.p006b.p008b.p009h.p010j.Helper;

/* renamed from: a.b.b.b */
/* loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a */
    public int[] f53a;

    /* renamed from: b */
    public int f54b;

    /* renamed from: c */
    public Context f55c;

    /* renamed from: d */
    public Helper f56d;

    /* renamed from: e */
    public boolean f57e;

    /* renamed from: f */
    public String f58f;

    public ConstraintHelper(Context context) {
        super(context);
        this.f53a = new int[32];
        this.f57e = false;
        this.f55c = context;
        mo11257a((AttributeSet) null);
    }

    private void setIds(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                m11256a(str.substring(i));
                return;
            } else {
                m11256a(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    /* renamed from: a */
    public void m11258a(ConstraintLayout constraintLayout) {
    }

    /* renamed from: a */
    public void mo11257a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0023g.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0023g.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f58f = obtainStyledAttributes.getString(index);
                    setIds(this.f58f);
                }
            }
        }
    }

    /* renamed from: b */
    public void m11255b(ConstraintLayout constraintLayout) {
    }

    /* renamed from: c */
    public void m11254c(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f58f);
        }
        Helper helper = this.f56d;
        if (helper == null) {
            return;
        }
        helper.m11012K();
        for (int i = 0; i < this.f54b; i++) {
            View m7926b = constraintLayout.m7926b(this.f53a[i]);
            if (m7926b != null) {
                this.f56d.m11011b(constraintLayout.m7929a(m7926b));
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f53a, this.f54b);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f57e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f54b = 0;
        for (int i : iArr) {
            setTag(i, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        int i2 = this.f54b + 1;
        int[] iArr = this.f53a;
        if (i2 > iArr.length) {
            this.f53a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f53a;
        int i3 = this.f54b;
        iArr2[i3] = i;
        this.f54b = i3 + 1;
    }

    /* renamed from: a */
    public void m11259a() {
        if (this.f56d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.C0520a) {
            ((ConstraintLayout.C0520a) layoutParams).f3117k0 = this.f56d;
        }
    }

    /* renamed from: a */
    public final void m11256a(String str) {
        int i;
        Object m7932a;
        if (str == null || this.f55c == null) {
            return;
        }
        String trim = str.trim();
        try {
            i = C0022f.class.getField(trim).getInt(null);
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            i = this.f55c.getResources().getIdentifier(trim, DatabaseFieldConfigLoader.FIELD_NAME_ID, this.f55c.getPackageName());
        }
        if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (m7932a = ((ConstraintLayout) getParent()).m7932a(0, trim)) != null && (m7932a instanceof Integer)) {
            i = ((Integer) m7932a).intValue();
        }
        if (i != 0) {
            setTag(i, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }
}
