package p000a.p006b.p030g.p048l;

import android.database.Cursor;
import android.widget.Filter;

/* renamed from: a.b.g.l.g */
/* loaded from: classes.dex */
public class CursorFilter extends Filter {

    /* renamed from: a */
    public InterfaceC0316a f1827a;

    /* compiled from: CursorFilter.java */
    /* renamed from: a.b.g.l.g$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0316a {
        /* renamed from: a */
        Cursor mo9244a();

        /* renamed from: a */
        Cursor mo8389a(CharSequence charSequence);

        /* renamed from: a */
        void mo8396a(Cursor cursor);

        /* renamed from: b */
        CharSequence mo8384b(Cursor cursor);
    }

    public CursorFilter(InterfaceC0316a interfaceC0316a) {
        this.f1827a = interfaceC0316a;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f1827a.mo8384b((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor mo8389a = this.f1827a.mo8389a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (mo8389a != null) {
            filterResults.count = mo8389a.getCount();
            filterResults.values = mo8389a;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor mo9244a = this.f1827a.mo9244a();
        Object obj = filterResults.values;
        if (obj == null || obj == mo9244a) {
            return;
        }
        this.f1827a.mo8396a((Cursor) obj);
    }
}
