package a.b.g.l;

import android.database.Cursor;
import android.widget.Filter;
/* compiled from: CursorFilter.java */
/* loaded from: classes.dex */
public class g extends Filter {

    /* renamed from: a  reason: collision with root package name */
    public a f1243a;

    /* compiled from: CursorFilter.java */
    /* loaded from: classes.dex */
    public interface a {
        Cursor a();

        Cursor a(CharSequence charSequence);

        void a(Cursor cursor);

        CharSequence b(Cursor cursor);
    }

    public g(a aVar) {
        this.f1243a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f1243a.b((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor a2 = this.f1243a.a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (a2 != null) {
            filterResults.count = a2.getCount();
            filterResults.values = a2;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor a2 = this.f1243a.a();
        Object obj = filterResults.values;
        if (obj == null || obj == a2) {
            return;
        }
        this.f1243a.a((Cursor) obj);
    }
}
