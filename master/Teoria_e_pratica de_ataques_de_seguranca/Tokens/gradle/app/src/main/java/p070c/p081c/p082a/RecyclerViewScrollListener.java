package p070c.p081c.p082a;

import android.support.p067v7.widget.RecyclerView;
import com.futuremind.recyclerviewfastscroll.FastScroller;
import java.util.ArrayList;
import java.util.List;

/* renamed from: c.c.a.g */
/* loaded from: classes.dex */
public class RecyclerViewScrollListener extends RecyclerView.AbstractC0731t {

    /* renamed from: a */
    public final FastScroller f5022a;

    /* renamed from: b */
    public List<InterfaceC0888a> f5023b = new ArrayList();

    /* renamed from: c */
    public int f5024c = 0;

    /* compiled from: RecyclerViewScrollListener.java */
    /* renamed from: c.c.a.g$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0888a {
        /* renamed from: a */
        void m5684a(float f);
    }

    public RecyclerViewScrollListener(FastScroller fastScroller) {
        this.f5022a = fastScroller;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0731t
    /* renamed from: a */
    public void mo5685a(RecyclerView recyclerView, int i) {
        super.mo5685a(recyclerView, i);
        if (i == 0 && this.f5024c != 0) {
            this.f5022a.getViewProvider().m5669h();
        } else if (i != 0 && this.f5024c == 0) {
            this.f5022a.getViewProvider().m5668i();
        }
        this.f5024c = i;
    }

    @Override // android.support.p067v7.widget.RecyclerView.AbstractC0731t
    /* renamed from: a */
    public void mo1057a(RecyclerView recyclerView, int i, int i2) {
        if (this.f5022a.m4392f()) {
            m5686a(recyclerView);
        }
    }

    /* renamed from: a */
    public void m5686a(RecyclerView recyclerView) {
        int computeHorizontalScrollOffset;
        int computeHorizontalScrollExtent;
        int computeHorizontalScrollRange;
        if (this.f5022a.m4393e()) {
            computeHorizontalScrollOffset = recyclerView.computeVerticalScrollOffset();
            computeHorizontalScrollExtent = recyclerView.computeVerticalScrollExtent();
            computeHorizontalScrollRange = recyclerView.computeVerticalScrollRange();
        } else {
            computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            computeHorizontalScrollExtent = recyclerView.computeHorizontalScrollExtent();
            computeHorizontalScrollRange = recyclerView.computeHorizontalScrollRange();
        }
        float f = computeHorizontalScrollOffset / (computeHorizontalScrollRange - computeHorizontalScrollExtent);
        this.f5022a.setScrollerPosition(f);
        m5687a(f);
    }

    /* renamed from: a */
    public void m5687a(float f) {
        for (InterfaceC0888a interfaceC0888a : this.f5023b) {
            interfaceC0888a.m5684a(f);
        }
    }
}
