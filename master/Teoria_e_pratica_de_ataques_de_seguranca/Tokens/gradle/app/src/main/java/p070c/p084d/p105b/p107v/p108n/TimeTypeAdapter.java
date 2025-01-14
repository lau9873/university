package p070c.p084d.p105b.p107v.p108n;

import com.google.gson.JsonSyntaxException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.k */
/* loaded from: classes.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {

    /* renamed from: b */
    public static final TypeAdapterFactory f5804b = new C1308a();

    /* renamed from: a */
    public final DateFormat f5805a = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter.java */
    /* renamed from: c.d.b.v.n.k$a */
    /* loaded from: classes.dex */
    public static class C1308a implements TypeAdapterFactory {
        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public synchronized Time mo4753a(JsonReader jsonReader) {
        if (jsonReader.mo4738C() == JsonToken.NULL) {
            jsonReader.mo4706z();
            return null;
        }
        try {
            return new Time(this.f5805a.parse(jsonReader.mo4740A()).getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public synchronized void mo4752a(JsonWriter jsonWriter, Time time) {
        jsonWriter.mo4691e(time == null ? null : this.f5805a.format((Date) time));
    }
}
