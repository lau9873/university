package p070c.p084d.p105b.p107v.p108n;

import com.google.gson.JsonSyntaxException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p111w.TypeToken;
import p070c.p084d.p105b.p112x.JsonReader;
import p070c.p084d.p105b.p112x.JsonToken;
import p070c.p084d.p105b.p112x.JsonWriter;

/* renamed from: c.d.b.v.n.j */
/* loaded from: classes.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    /* renamed from: b */
    public static final TypeAdapterFactory f5802b = new C1307a();

    /* renamed from: a */
    public final DateFormat f5803a = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* renamed from: c.d.b.v.n.j$a */
    /* loaded from: classes.dex */
    public static class C1307a implements TypeAdapterFactory {
        @Override // p070c.p084d.p105b.TypeAdapterFactory
        /* renamed from: a */
        public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public synchronized Date mo4753a(JsonReader jsonReader) {
        if (jsonReader.mo4738C() == JsonToken.NULL) {
            jsonReader.mo4706z();
            return null;
        }
        try {
            return new Date(this.f5803a.parse(jsonReader.mo4740A()).getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override // p070c.p084d.p105b.TypeAdapter
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public synchronized void mo4752a(JsonWriter jsonWriter, Date date) {
        jsonWriter.mo4691e(date == null ? null : this.f5803a.format((java.util.Date) date));
    }
}
