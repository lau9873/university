package p205h.p208b.p209a.p210d.p211b0;

import java.text.SimpleDateFormat;
import java.util.Date;
import p205h.p208b.p209a.p210d.Passing;

/* renamed from: h.b.a.d.b0.h */
/* loaded from: classes.dex */
public class TipPassing implements Passing {

    /* renamed from: a */
    public final TipStop f9597a;

    /* renamed from: b */
    public final long f9598b;

    public TipPassing(TipStop tipStop, Date date) {
        this(tipStop, date.getTime());
    }

    @Override // p205h.p208b.p209a.p210d.Passing
    /* renamed from: a */
    public long mo1286a() {
        return this.f9598b;
    }

    public String toString() {
        return super.getClass().getSimpleName() + " [" + this.f9597a + ", " + new SimpleDateFormat("HH:mm:ss,SSS").format(Long.valueOf(this.f9598b)) + "]";
    }

    public TipPassing(TipStop tipStop, long j) {
        this.f9597a = tipStop;
        this.f9598b = j;
    }

    @Override // p205h.p208b.p209a.p210d.Passing
    /* renamed from: d */
    public TipStop mo1285d() {
        return this.f9597a;
    }
}
