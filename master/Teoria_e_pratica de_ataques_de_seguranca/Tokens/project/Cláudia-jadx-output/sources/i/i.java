package i;

import e.c0;
import e.t;
import e.x;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Map;
/* compiled from: ParameterHandler.java */
/* loaded from: classes.dex */
public abstract class i<T> {

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public class a extends i<Iterable<T>> {
        public a() {
        }

        @Override // i.i
        public /* bridge */ /* synthetic */ void a(i.k kVar, Object obj) {
            a(kVar, (Iterable) ((Iterable) obj));
        }

        public void a(i.k kVar, Iterable<T> iterable) {
            if (iterable == null) {
                return;
            }
            for (T t : iterable) {
                i.this.a(kVar, t);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public class b extends i<Object> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.i
        public void a(i.k kVar, Object obj) {
            if (obj == null) {
                return;
            }
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                i.this.a(kVar, Array.get(obj, i2));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public static final class c<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final i.e<T, c0> f7454a;

        public c(i.e<T, c0> eVar) {
            this.f7454a = eVar;
        }

        @Override // i.i
        public void a(i.k kVar, T t) {
            if (t != null) {
                try {
                    kVar.a(this.f7454a.a(t));
                    return;
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
                }
            }
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public static final class d<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f7455a;

        /* renamed from: b  reason: collision with root package name */
        public final i.e<T, String> f7456b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f7457c;

        public d(String str, i.e<T, String> eVar, boolean z) {
            o.a(str, "name == null");
            this.f7455a = str;
            this.f7456b = eVar;
            this.f7457c = z;
        }

        @Override // i.i
        public void a(i.k kVar, T t) {
            String a2;
            if (t == null || (a2 = this.f7456b.a(t)) == null) {
                return;
            }
            kVar.a(this.f7455a, a2, this.f7457c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public static final class e<T> extends i<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        public final i.e<T, String> f7458a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f7459b;

        public e(i.e<T, String> eVar, boolean z) {
            this.f7458a = eVar;
            this.f7459b = z;
        }

        @Override // i.i
        public /* bridge */ /* synthetic */ void a(i.k kVar, Object obj) {
            a(kVar, (Map) ((Map) obj));
        }

        public void a(i.k kVar, Map<String, T> map) {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String a2 = this.f7458a.a(value);
                            if (a2 != null) {
                                kVar.a(key, a2, this.f7459b);
                            } else {
                                throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f7458a.getClass().getName() + " for key '" + key + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public static final class f<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f7460a;

        /* renamed from: b  reason: collision with root package name */
        public final i.e<T, String> f7461b;

        public f(String str, i.e<T, String> eVar) {
            o.a(str, "name == null");
            this.f7460a = str;
            this.f7461b = eVar;
        }

        @Override // i.i
        public void a(i.k kVar, T t) {
            String a2;
            if (t == null || (a2 = this.f7461b.a(t)) == null) {
                return;
            }
            kVar.a(this.f7460a, a2);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public static final class g<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final t f7462a;

        /* renamed from: b  reason: collision with root package name */
        public final i.e<T, c0> f7463b;

        public g(t tVar, i.e<T, c0> eVar) {
            this.f7462a = tVar;
            this.f7463b = eVar;
        }

        @Override // i.i
        public void a(i.k kVar, T t) {
            if (t == null) {
                return;
            }
            try {
                kVar.a(this.f7462a, this.f7463b.a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public static final class h<T> extends i<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        public final i.e<T, c0> f7464a;

        /* renamed from: b  reason: collision with root package name */
        public final String f7465b;

        public h(i.e<T, c0> eVar, String str) {
            this.f7464a = eVar;
            this.f7465b = str;
        }

        @Override // i.i
        public /* bridge */ /* synthetic */ void a(i.k kVar, Object obj) {
            a(kVar, (Map) ((Map) obj));
        }

        public void a(i.k kVar, Map<String, T> map) {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            kVar.a(t.a("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f7465b), this.f7464a.a(value));
                        } else {
                            throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0172i<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f7466a;

        /* renamed from: b  reason: collision with root package name */
        public final i.e<T, String> f7467b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f7468c;

        public C0172i(String str, i.e<T, String> eVar, boolean z) {
            o.a(str, "name == null");
            this.f7466a = str;
            this.f7467b = eVar;
            this.f7468c = z;
        }

        @Override // i.i
        public void a(i.k kVar, T t) {
            if (t != null) {
                kVar.b(this.f7466a, this.f7467b.a(t), this.f7468c);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.f7466a + "\" value must not be null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public static final class j<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f7469a;

        /* renamed from: b  reason: collision with root package name */
        public final i.e<T, String> f7470b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f7471c;

        public j(String str, i.e<T, String> eVar, boolean z) {
            o.a(str, "name == null");
            this.f7469a = str;
            this.f7470b = eVar;
            this.f7471c = z;
        }

        @Override // i.i
        public void a(i.k kVar, T t) {
            String a2;
            if (t == null || (a2 = this.f7470b.a(t)) == null) {
                return;
            }
            kVar.c(this.f7469a, a2, this.f7471c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public static final class k<T> extends i<Map<String, T>> {

        /* renamed from: a  reason: collision with root package name */
        public final i.e<T, String> f7472a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f7473b;

        public k(i.e<T, String> eVar, boolean z) {
            this.f7472a = eVar;
            this.f7473b = z;
        }

        @Override // i.i
        public /* bridge */ /* synthetic */ void a(i.k kVar, Object obj) {
            a(kVar, (Map) ((Map) obj));
        }

        public void a(i.k kVar, Map<String, T> map) {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String a2 = this.f7472a.a(value);
                            if (a2 != null) {
                                kVar.c(key, a2, this.f7473b);
                            } else {
                                throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f7472a.getClass().getName() + " for key '" + key + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public static final class l<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        public final i.e<T, String> f7474a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f7475b;

        public l(i.e<T, String> eVar, boolean z) {
            this.f7474a = eVar;
            this.f7475b = z;
        }

        @Override // i.i
        public void a(i.k kVar, T t) {
            if (t == null) {
                return;
            }
            kVar.c(this.f7474a.a(t), null, this.f7475b);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes.dex */
    public static final class m extends i<x.b> {

        /* renamed from: a  reason: collision with root package name */
        public static final m f7476a = new m();

        @Override // i.i
        public void a(i.k kVar, x.b bVar) {
            if (bVar != null) {
                kVar.a(bVar);
            }
        }
    }

    public final i<Object> a() {
        return new b();
    }

    public abstract void a(i.k kVar, T t);

    public final i<Iterable<T>> b() {
        return new a();
    }
}
