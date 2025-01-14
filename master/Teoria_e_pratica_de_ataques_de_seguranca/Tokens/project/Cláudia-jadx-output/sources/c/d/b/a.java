package c.d.b;

import com.google.gson.JsonSyntaxException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* compiled from: DefaultDateTypeAdapter.java */
/* loaded from: classes.dex */
public final class a extends s<Date> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<? extends Date> f3702a;

    /* renamed from: b  reason: collision with root package name */
    public final List<DateFormat> f3703b = new ArrayList();

    public a(Class<? extends Date> cls, String str) {
        a(cls);
        this.f3702a = cls;
        this.f3703b.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.f3703b.add(new SimpleDateFormat(str));
    }

    public String toString() {
        DateFormat dateFormat = this.f3703b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // c.d.b.s
    public void a(c.d.b.x.c cVar, Date date) {
        if (date == null) {
            cVar.t();
            return;
        }
        synchronized (this.f3703b) {
            cVar.e(this.f3703b.get(0).format(date));
        }
    }

    public a(Class<? extends Date> cls, int i2, int i3) {
        a(cls);
        this.f3702a = cls;
        this.f3703b.add(DateFormat.getDateTimeInstance(i2, i3, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f3703b.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (c.d.b.v.e.c()) {
            this.f3703b.add(c.d.b.v.j.a(i2, i3));
        }
    }

    @Override // c.d.b.s
    public Date a(c.d.b.x.a aVar) {
        if (aVar.C() == c.d.b.x.b.NULL) {
            aVar.z();
            return null;
        }
        Date a2 = a(aVar.A());
        Class<? extends Date> cls = this.f3702a;
        if (cls == Date.class) {
            return a2;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(a2.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(a2.getTime());
        }
        throw new AssertionError();
    }

    public final Date a(String str) {
        synchronized (this.f3703b) {
            for (DateFormat dateFormat : this.f3703b) {
                try {
                    return dateFormat.parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return c.d.b.v.n.o.a.a(str, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new JsonSyntaxException(str, e2);
            }
        }
    }
}
