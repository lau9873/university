package p000a.p006b.p030g.p048l;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: a.b.g.l.n */
/* loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: i */
    public int f1837i;

    /* renamed from: j */
    public int f1838j;

    /* renamed from: k */
    public LayoutInflater f1839k;

    @Deprecated
    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1838j = i;
        this.f1837i = i;
        this.f1839k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // p000a.p006b.p030g.p048l.CursorAdapter
    /* renamed from: a */
    public View mo9219a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1839k.inflate(this.f1838j, viewGroup, false);
    }

    @Override // p000a.p006b.p030g.p048l.CursorAdapter
    /* renamed from: b */
    public View mo8385b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1839k.inflate(this.f1837i, viewGroup, false);
    }
}
