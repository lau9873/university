package p000a.p006b.p049h.p057f;

import android.support.p067v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/* renamed from: a.b.h.f.l */
/* loaded from: classes.dex */
public class PreferenceViewHolder extends RecyclerView.AbstractC0708d0 {

    /* renamed from: u */
    public final SparseArray<View> f2195u;

    /* renamed from: v */
    public boolean f2196v;

    /* renamed from: w */
    public boolean f2197w;

    public PreferenceViewHolder(View view) {
        super(view);
        this.f2195u = new SparseArray<>(4);
        this.f2195u.put(16908310, view.findViewById(16908310));
        this.f2195u.put(16908304, view.findViewById(16908304));
        this.f2195u.put(16908294, view.findViewById(16908294));
        SparseArray<View> sparseArray = this.f2195u;
        int i = C0401o.icon_frame;
        sparseArray.put(i, view.findViewById(i));
        this.f2195u.put(16908350, view.findViewById(16908350));
    }

    /* renamed from: C */
    public boolean m8811C() {
        return this.f2196v;
    }

    /* renamed from: D */
    public boolean m8810D() {
        return this.f2197w;
    }

    /* renamed from: b */
    public void m8809b(boolean z) {
        this.f2196v = z;
    }

    /* renamed from: c */
    public View m8808c(int i) {
        View view = this.f2195u.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = this.f4213a.findViewById(i);
        if (findViewById != null) {
            this.f2195u.put(i, findViewById);
        }
        return findViewById;
    }

    /* renamed from: c */
    public void m8807c(boolean z) {
        this.f2197w = z;
    }
}
