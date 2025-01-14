package c.d.b.v.n;

import c.d.b.s;
import c.d.b.t;
import com.google.gson.JsonSyntaxException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes.dex */
public final class j extends s<Date> {

    /* renamed from: b  reason: collision with root package name */
    public static final t f3840b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final DateFormat f3841a = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* loaded from: classes.dex */
    public static class a implements t {
        @Override // c.d.b.t
        public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new j();
            }
            return null;
        }
    }

    @Override // c.d.b.s
    public synchronized Date a(c.d.b.x.a aVar) {
        if (aVar.C() == c.d.b.x.b.NULL) {
            aVar.z();
            return null;
        }
        try {
            return new Date(this.f3841a.parse(aVar.A()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // c.d.b.s
    public synchronized void a(c.d.b.x.c cVar, Date date) {
        cVar.e(date == null ? null : this.f3841a.format((java.util.Date) date));
    }
}
