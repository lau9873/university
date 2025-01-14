package p181e.p182i0.p185g;

import p181e.Headers;
import p181e.MediaType;
import p181e.ResponseBody;
import p192f.BufferedSource;

/* renamed from: e.i0.g.h */
/* loaded from: classes.dex */
public final class RealResponseBody extends ResponseBody {

    /* renamed from: b */
    public final Headers f8023b;

    /* renamed from: c */
    public final BufferedSource f8024c;

    public RealResponseBody(Headers headers, BufferedSource bufferedSource) {
        this.f8023b = headers;
        this.f8024c = bufferedSource;
    }

    @Override // p181e.ResponseBody
    /* renamed from: l */
    public long mo672l() {
        return HttpHeaders.m3071a(this.f8023b);
    }

    @Override // p181e.ResponseBody
    /* renamed from: m */
    public MediaType mo671m() {
        String m2765a = this.f8023b.m2765a("Content-Type");
        if (m2765a != null) {
            return MediaType.m2692a(m2765a);
        }
        return null;
    }

    @Override // p181e.ResponseBody
    /* renamed from: n */
    public BufferedSource mo670n() {
        return this.f8024c;
    }
}
