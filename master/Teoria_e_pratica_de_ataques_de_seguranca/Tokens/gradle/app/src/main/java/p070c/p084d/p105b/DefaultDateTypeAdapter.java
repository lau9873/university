package p070c.p084d.p105b;

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
import p070c.p084d.p105b.p107v.JavaVersion;
import p070c.p084d.p105b.p107v.PreJava9DateFormatProvider;
import p070c.p084d.p105b.p107v.p108n.p109o.ISO8601Utils;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.a */
/* loaded from: classes.dex */
public final class DefaultDateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: a */
    public final Class<? extends Date> f5645a;

    /* renamed from: b */
    public final List<DateFormat> f5646b = new ArrayList();

    public DefaultDateTypeAdapter(Class<? extends Date> cls, String str) {
        m4954a(cls);
        this.f5645a = cls;
        this.f5646b.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.f5646b.add(new SimpleDateFormat(str));
    }

    public String toString() {
        DateFormat dateFormat = this.f5646b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    /* renamed from: a */
    public static Class<? extends Date> m4954a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo4752a(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            jsonWriter.mo4679t();
            return;
        }
        synchronized (this.f5646b) {
            jsonWriter.mo4691e(this.f5646b.get(0).format(date));
        }
    }

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i, int i2) {
        m4954a(cls);
        this.f5645a = cls;
        this.f5646b.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f5646b.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (JavaVersion.m4844c()) {
            this.f5646b.add(PreJava9DateFormatProvider.m4826a(i, i2));
        }
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Date mo4753a(JsonReader jsonReader) {
        if (jsonReader.mo4738C() == JsonToken.NULL) {
            jsonReader.mo4706z();
            return null;
        }
        Date m4953a = m4953a(jsonReader.mo4740A());
        Class<? extends Date> cls = this.f5645a;
        if (cls == Date.class) {
            return m4953a;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(m4953a.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(m4953a.getTime());
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public final Date m4953a(String str) {
        synchronized (this.f5646b) {
            for (DateFormat dateFormat : this.f5646b) {
                try {
                    return dateFormat.parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return ISO8601Utils.m4746a(str, new ParsePosition(0));
            } catch (ParseException e) {
                throw new JsonSyntaxException(str, e);
            }
        }
    }
}
