package p070c.p084d.p105b.p107v.p108n;

import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.JsonDeserializer;
import p070c.p084d.p105b.JsonSerializer;
import p070c.p084d.p105b.TypeAdapter;
import p070c.p084d.p105b.TypeAdapterFactory;
import p070c.p084d.p105b.p106u.JsonAdapter;
import p070c.p084d.p105b.p107v.ConstructorConstructor;
import p070c.p084d.p105b.p111w.TypeToken;

/* renamed from: c.d.b.v.n.d */
/* loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    public final ConstructorConstructor f5766a;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f5766a = constructorConstructor;
    }

    @Override // p070c.p084d.p105b.TypeAdapterFactory
    /* renamed from: a */
    public <T> TypeAdapter<T> mo4750a(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (TypeAdapter<T>) m4812a(this.f5766a, gson, typeToken, jsonAdapter);
    }

    /* renamed from: a */
    public TypeAdapter<?> m4812a(ConstructorConstructor constructorConstructor, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        TypeAdapter<?> treeTypeAdapter;
        Object mo4828a = constructorConstructor.m4863a(TypeToken.get((Class) jsonAdapter.value())).mo4828a();
        if (mo4828a instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) mo4828a;
        } else if (mo4828a instanceof TypeAdapterFactory) {
            treeTypeAdapter = ((TypeAdapterFactory) mo4828a).mo4750a(gson, typeToken);
        } else {
            boolean z = mo4828a instanceof JsonSerializer;
            if (!z && !(mo4828a instanceof JsonDeserializer)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + mo4828a.getClass().getName() + " as a @JsonAdapter for " + typeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z ? (JsonSerializer) mo4828a : null, mo4828a instanceof JsonDeserializer ? (JsonDeserializer) mo4828a : null, gson, typeToken, null);
        }
        return (treeTypeAdapter == null || !jsonAdapter.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.m4888a();
    }
}
