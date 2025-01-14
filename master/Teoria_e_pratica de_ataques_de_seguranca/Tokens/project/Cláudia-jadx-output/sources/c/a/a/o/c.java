package c.a.a.o;

import c.a.a.a;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* compiled from: BasicNetwork.java */
/* loaded from: classes.dex */
public class c implements c.a.a.f {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f2813c = c.a.a.n.f2804b;

    /* renamed from: a  reason: collision with root package name */
    public final b f2814a;

    /* renamed from: b  reason: collision with root package name */
    public final d f2815b;

    @Deprecated
    public c(i iVar) {
        this(iVar, new d(4096));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v5 */
    @Override // c.a.a.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c.a.a.h a(c.a.a.i<?> r29) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.a.o.c.a(c.a.a.i):c.a.a.h");
    }

    @Deprecated
    public c(i iVar, d dVar) {
        this.f2814a = new a(iVar);
        this.f2815b = dVar;
    }

    public c(b bVar) {
        this(bVar, new d(4096));
    }

    public c(b bVar, d dVar) {
        this.f2814a = bVar;
        this.f2815b = dVar;
    }

    public final void a(long j, c.a.a.i<?> iVar, byte[] bArr, int i2) {
        if (f2813c || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = iVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(iVar.o().b());
            c.a.a.n.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    public static void a(String str, c.a.a.i<?> iVar, VolleyError volleyError) {
        c.a.a.m o = iVar.o();
        int p = iVar.p();
        try {
            o.a(volleyError);
            iVar.a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(p)));
        } catch (VolleyError e2) {
            iVar.a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(p)));
            throw e2;
        }
    }

    public final Map<String, String> a(a.C0051a c0051a) {
        if (c0051a == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = c0051a.f2735b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = c0051a.f2737d;
        if (j > 0) {
            hashMap.put("If-Modified-Since", g.a(j));
        }
        return hashMap;
    }

    public final byte[] a(InputStream inputStream, int i2) {
        m mVar = new m(this.f2815b, i2);
        try {
            if (inputStream != null) {
                byte[] a2 = this.f2815b.a(1024);
                while (true) {
                    int read = inputStream.read(a2);
                    if (read == -1) {
                        break;
                    }
                    mVar.write(a2, 0, read);
                }
                byte[] byteArray = mVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        c.a.a.n.d("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.f2815b.a(a2);
                mVar.close();
                return byteArray;
            }
            throw new ServerError();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    c.a.a.n.d("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.f2815b.a((byte[]) null);
            mVar.close();
            throw th;
        }
    }

    public static List<c.a.a.e> a(List<c.a.a.e> list, a.C0051a c0051a) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (c.a.a.e eVar : list) {
                treeSet.add(eVar.a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<c.a.a.e> list2 = c0051a.f2741h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (c.a.a.e eVar2 : c0051a.f2741h) {
                    if (!treeSet.contains(eVar2.a())) {
                        arrayList.add(eVar2);
                    }
                }
            }
        } else if (!c0051a.f2740g.isEmpty()) {
            for (Map.Entry<String, String> entry : c0051a.f2740g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new c.a.a.e(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }
}
