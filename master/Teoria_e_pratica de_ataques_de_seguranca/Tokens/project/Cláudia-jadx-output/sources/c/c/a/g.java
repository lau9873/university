package c.c.a;

import android.support.v7.widget.RecyclerView;
import com.futuremind.recyclerviewfastscroll.FastScroller;
import java.util.ArrayList;
import java.util.List;
/* compiled from: RecyclerViewScrollListener.java */
/* loaded from: classes.dex */
public class g extends RecyclerView.t {

    /* renamed from: a  reason: collision with root package name */
    public final FastScroller f3184a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f3185b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f3186c = 0;

    /* compiled from: RecyclerViewScrollListener.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(float f2);
    }

    public g(FastScroller fastScroller) {
        this.f3184a = fastScroller;
    }

    @Override // android.support.v7.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i2) {
        super.a(recyclerView, i2);
        if (i2 == 0 && this.f3186c != 0) {
            this.f3184a.getViewProvider().h();
        } else if (i2 != 0 && this.f3186c == 0) {
            this.f3184a.getViewProvider().i();
        }
        this.f3186c = i2;
    }

    @Override // android.support.v7.widget.RecyclerView.t
    public void a(RecyclerView recyclerView, int i2, int i3) {
        if (this.f3184a.f()) {
            a(recyclerView);
        }
    }

    public void a(RecyclerView recyclerView) {
        int computeHorizontalScrollOffset;
        int computeHorizontalScrollExtent;
        int computeHorizontalScrollRange;
        if (this.f3184a.e()) {
            computeHorizontalScrollOffset = recyclerView.computeVerticalScrollOffset();
            computeHorizontalScrollExtent = recyclerView.computeVerticalScrollExtent();
            computeHorizontalScrollRange = recyclerView.computeVerticalScrollRange();
        } else {
            computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            computeHorizontalScrollExtent = recyclerView.computeHorizontalScrollExtent();
            computeHorizontalScrollRange = recyclerView.computeHorizontalScrollRange();
        }
        float f2 = computeHorizontalScrollOffset / (computeHorizontalScrollRange - computeHorizontalScrollExtent);
        this.f3184a.setScrollerPosition(f2);
        a(f2);
    }

    public void a(float f2) {
        for (a aVar : this.f3185b) {
            aVar.a(f2);
        }
    }
}
