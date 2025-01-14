package c.d.b.v.n;

import c.d.b.s;
import c.d.b.t;
import com.google.gson.JsonSyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* compiled from: DateTypeAdapter.java */
/* loaded from: classes.dex */
public final class c extends s<Date> {

    /* renamed from: b  reason: collision with root package name */
    public static final t f3812b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final List<DateFormat> f3813a = new ArrayList();

    /* compiled from: DateTypeAdapter.java */
    /* loaded from: classes.dex */
    public static class a implements t {
        @Override // c.d.b.t
        public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        this.f3813a.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f3813a.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (c.d.b.v.e.c()) {
            this.f3813a.add(c.d.b.v.j.a(2, 2));
        }
    }

    @Override // c.d.b.s
    public Date a(c.d.b.x.a aVar) {
        if (aVar.C() == c.d.b.x.b.NULL) {
            aVar.z();
            return null;
        }
        return a(aVar.A());
    }

    public final synchronized Date a(String str) {
        for (DateFormat dateFormat : this.f3813a) {
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

    @Override // c.d.b.s
    public synchronized void a(c.d.b.x.c cVar, Date date) {
        if (date == null) {
            cVar.t();
        } else {
            cVar.e(this.f3813a.get(0).format(date));
        }
    }
}
