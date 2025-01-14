package c.d.b.v.n;

import c.d.b.s;
import c.d.b.t;
import com.google.gson.JsonSyntaxException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeTypeAdapter.java */
/* loaded from: classes.dex */
public final class k extends s<Time> {

    /* renamed from: b  reason: collision with root package name */
    public static final t f3842b = new a();

    /* renamed from: a  reason: collision with root package name */
    public final DateFormat f3843a = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter.java */
    /* loaded from: classes.dex */
    public static class a implements t {
        @Override // c.d.b.t
        public <T> s<T> a(c.d.b.f fVar, c.d.b.w.a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new k();
            }
            return null;
        }
    }

    @Override // c.d.b.s
    public synchronized Time a(c.d.b.x.a aVar) {
        if (aVar.C() == c.d.b.x.b.NULL) {
            aVar.z();
            return null;
        }
        try {
            return new Time(this.f3843a.parse(aVar.A()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // c.d.b.s
    public synchronized void a(c.d.b.x.c cVar, Time time) {
        cVar.e(time == null ? null : this.f3843a.format((Date) time));
    }
}
