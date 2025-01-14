package p000a.p006b.p030g.p048l;

import android.widget.ListView;

/* renamed from: a.b.g.l.k */
/* loaded from: classes.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {

    /* renamed from: t */
    public final ListView f1832t;

    public ListViewAutoScrollHelper(ListView listView) {
        super(listView);
        this.f1832t = listView;
    }

    @Override // p000a.p006b.p030g.p048l.AutoScrollHelper
    /* renamed from: a */
    public void mo9226a(int i, int i2) {
        ListViewCompat.m9223b(this.f1832t, i2);
    }

    @Override // p000a.p006b.p030g.p048l.AutoScrollHelper
    /* renamed from: a */
    public boolean mo9227a(int i) {
        return false;
    }

    @Override // p000a.p006b.p030g.p048l.AutoScrollHelper
    /* renamed from: b */
    public boolean mo9225b(int i) {
        ListView listView = this.f1832t;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
