package a.b.g.l;

import a.b.g.l.g;
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
/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class f extends BaseAdapter implements Filterable, g.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1233a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1234b;

    /* renamed from: c  reason: collision with root package name */
    public Cursor f1235c;

    /* renamed from: d  reason: collision with root package name */
    public Context f1236d;

    /* renamed from: e  reason: collision with root package name */
    public int f1237e;

    /* renamed from: f  reason: collision with root package name */
    public a f1238f;

    /* renamed from: g  reason: collision with root package name */
    public DataSetObserver f1239g;

    /* renamed from: h  reason: collision with root package name */
    public g f1240h;

    /* compiled from: CursorAdapter.java */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            f.this.b();
        }
    }

    /* compiled from: CursorAdapter.java */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            f fVar = f.this;
            fVar.f1233a = true;
            fVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            f fVar = f.this;
            fVar.f1233a = false;
            fVar.notifyDataSetInvalidated();
        }
    }

    public f(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public void a(Context context, Cursor cursor, int i2) {
        if ((i2 & 1) == 1) {
            i2 |= 2;
            this.f1234b = true;
        } else {
            this.f1234b = false;
        }
        boolean z = cursor != null;
        this.f1235c = cursor;
        this.f1233a = z;
        this.f1236d = context;
        this.f1237e = z ? cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX) : -1;
        if ((i2 & 2) == 2) {
            this.f1238f = new a();
            this.f1239g = new b();
        } else {
            this.f1238f = null;
            this.f1239g = null;
        }
        if (z) {
            a aVar = this.f1238f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1239g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public abstract View b(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // a.b.g.l.g.a
    public abstract CharSequence b(Cursor cursor);

    public void b() {
        Cursor cursor;
        if (!this.f1234b || (cursor = this.f1235c) == null || cursor.isClosed()) {
            return;
        }
        this.f1233a = this.f1235c.requery();
    }

    public Cursor c(Cursor cursor) {
        Cursor cursor2 = this.f1235c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            a aVar = this.f1238f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f1239g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1235c = cursor;
        if (cursor != null) {
            a aVar2 = this.f1238f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f1239g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f1237e = cursor.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX);
            this.f1233a = true;
            notifyDataSetChanged();
        } else {
            this.f1237e = -1;
            this.f1233a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f1233a || (cursor = this.f1235c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (this.f1233a) {
            this.f1235c.moveToPosition(i2);
            if (view == null) {
                view = a(this.f1236d, this.f1235c, viewGroup);
            }
            a(view, this.f1236d, this.f1235c);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f1240h == null) {
            this.f1240h = new g(this);
        }
        return this.f1240h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        Cursor cursor;
        if (!this.f1233a || (cursor = this.f1235c) == null) {
            return null;
        }
        cursor.moveToPosition(i2);
        return this.f1235c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        Cursor cursor;
        if (this.f1233a && (cursor = this.f1235c) != null && cursor.moveToPosition(i2)) {
            return this.f1235c.getLong(this.f1237e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (this.f1233a) {
            if (this.f1235c.moveToPosition(i2)) {
                if (view == null) {
                    view = b(this.f1236d, this.f1235c, viewGroup);
                }
                a(view, this.f1236d, this.f1235c);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i2);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // a.b.g.l.g.a
    public Cursor a() {
        return this.f1235c;
    }

    @Override // a.b.g.l.g.a
    public void a(Cursor cursor) {
        Cursor c2 = c(cursor);
        if (c2 != null) {
            c2.close();
        }
    }
}
