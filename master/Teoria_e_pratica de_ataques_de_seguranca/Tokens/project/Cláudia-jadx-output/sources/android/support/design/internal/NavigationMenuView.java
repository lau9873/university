package android.support.design.internal;

import a.b.h.j.j.h;
import a.b.h.j.j.q;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements q {
    public NavigationMenuView(Context context) {
        this(context, null);
    }

    @Override // a.b.h.j.j.q
    public void a(h hVar) {
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }
}
