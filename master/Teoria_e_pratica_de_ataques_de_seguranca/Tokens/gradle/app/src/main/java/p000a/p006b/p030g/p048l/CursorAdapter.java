package p000a.p006b.p030g.p048l;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.j256.ormlite.field.FieldType;
import p000a.p006b.p030g.p048l.CursorFilter;

/* renamed from: a.b.g.l.f */
/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.InterfaceC0316a {

    /* renamed from: a */
    public boolean f1817a;

    /* renamed from: b */
    public boolean f1818b;

    /* renamed from: c */
    public Cursor f1819c;

    /* renamed from: d */
    public Context f1820d;

    /* renamed from: e */
    public int f1821e;

    /* renamed from: f */
    public C0314a f1822f;

    /* renamed from: g */
    public DataSetObserver f1823g;

    /* renamed from: h */
    public CursorFilter f1824h;

    /* compiled from: CursorAdapter.java */
    /* renamed from: a.b.g.l.f$a */
    /* loaded from: classes.dex */
    public class C0314a extends ContentObserver {
        public C0314a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            CursorAdapter.this.m9246b();
        }
    }

    /* compiled from: CursorAdapter.java */
    /* renamed from: a.b.g.l.f$b */
    /* loaded from: classes.dex */
    public class C0315b extends DataSetObserver {
        public C0315b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f1817a = true;
            cursorAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.f1817a = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    public CursorAdapter(Context context, Cursor cursor, boolean z) {
        m9247a(context, cursor, z ? 1 : 2);
    }

    /* renamed from: a */
    public abstract View mo9219a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* renamed from: a */
    public void m9247a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.f1818b = true;
        } else {
            this.f1818b = false;
        }
        boolean z = cursor != null;
        this.f1819c = cursor;
        this.f1817a = z;
        this.f1820d = context;
        this.f1821e = z ? cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX) : -1;
        if ((i & 2) == 2) {
            this.f1822f = new C0314a();
            this.f1823g = new C0315b();
        } else {
            this.f1822f = null;
            this.f1823g = null;
        }
        if (z) {
            C0314a c0314a = this.f1822f;
            if (c0314a != null) {
                cursor.registerContentObserver(c0314a);
            }
            DataSetObserver dataSetObserver = this.f1823g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: a */
    public abstract void mo8392a(View view, Context context, Cursor cursor);

    /* renamed from: b */
    public abstract View mo8385b(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // p000a.p006b.p030g.p048l.CursorFilter.InterfaceC0316a
    /* renamed from: b */
    public abstract CharSequence mo8384b(Cursor cursor);

    /* renamed from: b */
    public void m9246b() {
        Cursor cursor;
        if (!this.f1818b || (cursor = this.f1819c) == null || cursor.isClosed()) {
            return;
        }
        this.f1817a = this.f1819c.requery();
    }

    /* renamed from: c */
    public Cursor m9245c(Cursor cursor) {
        Cursor cursor2 = this.f1819c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0314a c0314a = this.f1822f;
            if (c0314a != null) {
                cursor2.unregisterContentObserver(c0314a);
            }
            DataSetObserver dataSetObserver = this.f1823g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1819c = cursor;
        if (cursor != null) {
            C0314a c0314a2 = this.f1822f;
            if (c0314a2 != null) {
                cursor.registerContentObserver(c0314a2);
            }
            DataSetObserver dataSetObserver2 = this.f1823g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f1821e = cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX);
            this.f1817a = true;
            notifyDataSetChanged();
        } else {
            this.f1821e = -1;
            this.f1817a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f1817a || (cursor = this.f1819c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f1817a) {
            this.f1819c.moveToPosition(i);
            if (view == null) {
                view = mo9219a(this.f1820d, this.f1819c, viewGroup);
            }
            mo8392a(view, this.f1820d, this.f1819c);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f1824h == null) {
            this.f1824h = new CursorFilter(this);
        }
        return this.f1824h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f1817a || (cursor = this.f1819c) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f1819c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f1817a && (cursor = this.f1819c) != null && cursor.moveToPosition(i)) {
            return this.f1819c.getLong(this.f1821e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f1817a) {
            if (this.f1819c.moveToPosition(i)) {
                if (view == null) {
                    view = mo8385b(this.f1820d, this.f1819c, viewGroup);
                }
                mo8392a(view, this.f1820d, this.f1819c);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // p000a.p006b.p030g.p048l.CursorFilter.InterfaceC0316a
    /* renamed from: a */
    public Cursor mo9244a() {
        return this.f1819c;
    }

    @Override // p000a.p006b.p030g.p048l.CursorFilter.InterfaceC0316a
    /* renamed from: a */
    public void mo8396a(Cursor cursor) {
        Cursor m9245c = m9245c(cursor);
        if (m9245c != null) {
            m9245c.close();
        }
    }
}
