package a.b.h.f;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
/* compiled from: PreferenceViewHolder.java */
/* loaded from: classes.dex */
public class l extends RecyclerView.d0 {
    public final SparseArray<View> u;
    public boolean v;
    public boolean w;

    public l(View view) {
        super(view);
        this.u = new SparseArray<>(4);
        this.u.put(16908310, view.findViewById(16908310));
        this.u.put(16908304, view.findViewById(16908304));
        this.u.put(16908294, view.findViewById(16908294));
        SparseArray<View> sparseArray = this.u;
        int i2 = o.icon_frame;
        sparseArray.put(i2, view.findViewById(i2));
        this.u.put(16908350, view.findViewById(16908350));
    }

    public boolean C() {
        return this.v;
    }

    public boolean D() {
        return this.w;
    }

    public void b(boolean z) {
        this.v = z;
    }

    public View c(int i2) {
        View view = this.u.get(i2);
        if (view != null) {
            return view;
        }
        View findViewById = this.f2580a.findViewById(i2);
        if (findViewById != null) {
            this.u.put(i2, findViewById);
        }
        return findViewById;
    }

    public void c(boolean z) {
        this.w = z;
    }
}
