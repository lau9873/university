package a.b.g.l;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: ResourceCursorAdapter.java */
/* loaded from: classes.dex */
public abstract class n extends f {

    /* renamed from: i  reason: collision with root package name */
    public int f1252i;
    public int j;
    public LayoutInflater k;

    @Deprecated
    public n(Context context, int i2, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.j = i2;
        this.f1252i = i2;
        this.k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // a.b.g.l.f
    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.k.inflate(this.j, viewGroup, false);
    }

    @Override // a.b.g.l.f
    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.k.inflate(this.f1252i, viewGroup, false);
    }
}
