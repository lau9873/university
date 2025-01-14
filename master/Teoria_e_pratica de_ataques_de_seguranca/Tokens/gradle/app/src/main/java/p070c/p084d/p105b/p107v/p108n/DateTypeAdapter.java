package p070c.p084d.p105b.p107v.p108n;

import com.google.gson.JsonSyntaxException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p107v.JavaVersion;
import p070c.p084d.p105b.p107v.PreJava9DateFormatProvider;
import p070c.p084d.p105b.p107v.p108n.p109o.ISO8601Utils;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.c */
/* loaded from: classes.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: b */
    public static final TypeAdapterFactory f5764b = new C1298a();

    /* renamed from: a */
    public final List<DateFormat> f5765a = new ArrayList();

    /* compiled from: DateTypeAdapter.java */
    /* renamed from: c.d.b.v.n.c$a */
    /* loaded from: classes.dex */
    public static class C1298a implements TypeAdapterFactory {
        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    }

    public DateTypeAdapter() {
        this.f5765a.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.f5765a.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.m4844c()) {
            this.f5765a.add(PreJava9DateFormatProvider.m4826a(2, 2));
        }
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Date mo4753a(JsonReader jsonReader) {
        if (jsonReader.mo4738C() == JsonToken.NULL) {
            jsonReader.mo4706z();
            return null;
        }
        return m4813a(jsonReader.mo4740A());
    }

    /* renamed from: a */
    public final synchronized Date m4813a(String str) {
        for (DateFormat dateFormat : this.f5765a) {
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

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public synchronized void mo4752a(JsonWriter jsonWriter, Date date) {
        if (date == null) {
            jsonWriter.mo4679t();
        } else {
            jsonWriter.mo4691e(this.f5765a.get(0).format(date));
        }
    }
}
