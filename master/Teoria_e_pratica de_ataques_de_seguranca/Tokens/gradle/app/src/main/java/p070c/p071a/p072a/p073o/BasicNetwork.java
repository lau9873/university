package p070c.p071a.p072a.p073o;

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
import p070c.p071a.p072a.Header;
import p070c.p071a.p072a.InterfaceC0779a;
import p070c.p071a.p072a.Network;
import p070c.p071a.p072a.Request;
import p070c.p071a.p072a.RetryPolicy;
import p070c.p071a.p072a.VolleyLog;

/* renamed from: c.a.a.o.c */
/* loaded from: classes.dex */
public class BasicNetwork implements Network {

    /* renamed from: c */
    public static final boolean f4610c = VolleyLog.f4601b;

    /* renamed from: a */
    public final BaseHttpStack f4611a;

    /* renamed from: b */
    public final ByteArrayPool f4612b;

    @Deprecated
    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(4096));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v5 */
    @Override // p070c.p071a.p072a.Network
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p070c.p071a.p072a.NetworkResponse mo6159a(p070c.p071a.p072a.Request<?> r29) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p071a.p072a.p073o.BasicNetwork.mo6159a(c.a.a.i):c.a.a.h");
    }

    @Deprecated
    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.f4611a = new AdaptedHttpStack(httpStack);
        this.f4612b = byteArrayPool;
    }

    public BasicNetwork(BaseHttpStack baseHttpStack) {
        this(baseHttpStack, new ByteArrayPool(4096));
    }

    public BasicNetwork(BaseHttpStack baseHttpStack, ByteArrayPool byteArrayPool) {
        this.f4611a = baseHttpStack;
        this.f4612b = byteArrayPool;
    }

    /* renamed from: a */
    public final void m6161a(long j, Request<?> request, byte[] bArr, int i) {
        if (f4610c || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(request.m6197o().mo6171b());
            VolleyLog.m6168b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* renamed from: a */
    public static void m6157a(String str, Request<?> request, VolleyError volleyError) {
        RetryPolicy m6197o = request.m6197o();
        int m6196p = request.m6196p();
        try {
            m6197o.mo6172a(volleyError);
            request.m6211a(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(m6196p)));
        } catch (VolleyError e) {
            request.m6211a(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(m6196p)));
            throw e;
        }
    }

    /* renamed from: a */
    public final Map<String, String> m6160a(InterfaceC0779a.C0780a c0780a) {
        if (c0780a == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = c0780a.f4525b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = c0780a.f4527d;
        if (j > 0) {
            hashMap.put("If-Modified-Since", HttpHeaderParser.m6120a(j));
        }
        return hashMap;
    }

    /* renamed from: a */
    public final byte[] m6158a(InputStream inputStream, int i) {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.f4612b, i);
        try {
            if (inputStream != null) {
                byte[] m6154a = this.f4612b.m6154a(1024);
                while (true) {
                    int read = inputStream.read(m6154a);
                    if (read == -1) {
                        break;
                    }
                    poolingByteArrayOutputStream.write(m6154a, 0, read);
                }
                byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        VolleyLog.m6166d("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.f4612b.m6153a(m6154a);
                poolingByteArrayOutputStream.close();
                return byteArray;
            }
            throw new ServerError();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    VolleyLog.m6166d("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.f4612b.m6153a((byte[]) null);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    /* renamed from: a */
    public static List<Header> m6156a(List<Header> list, InterfaceC0779a.C0780a c0780a) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (Header header : list) {
                treeSet.add(header.m6229a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<Header> list2 = c0780a.f4531h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (Header header2 : c0780a.f4531h) {
                    if (!treeSet.contains(header2.m6229a())) {
                        arrayList.add(header2);
                    }
                }
            }
        } else if (!c0780a.f4530g.isEmpty()) {
            for (Map.Entry<String, String> entry : c0780a.f4530g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new Header(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }
}
