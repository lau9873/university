package p181e;

import java.util.ArrayList;
import java.util.List;
import p181e.p182i0.Util;
import p192f.Buffer;
import p192f.BufferedSink;

/* renamed from: e.r */
/* loaded from: classes.dex */
public final class FormBody extends RequestBody {

    /* renamed from: c */
    public static final MediaType f8322c = MediaType.m2692a("application/x-www-form-urlencoded");

    /* renamed from: a */
    public final List<String> f8323a;

    /* renamed from: b */
    public final List<String> f8324b;

    public FormBody(List<String> list, List<String> list2) {
        this.f8323a = Util.m3157a(list);
        this.f8324b = Util.m3157a(list2);
    }

    @Override // p181e.RequestBody
    /* renamed from: a */
    public long mo645a() {
        return m2774a((BufferedSink) null, true);
    }

    @Override // p181e.RequestBody
    /* renamed from: b */
    public MediaType mo643b() {
        return f8322c;
    }

    /* compiled from: FormBody.java */
    /* renamed from: e.r$a */
    /* loaded from: classes.dex */
    public static final class C1808a {

        /* renamed from: a */
        public final List<String> f8325a = new ArrayList();

        /* renamed from: b */
        public final List<String> f8326b = new ArrayList();

        /* renamed from: a */
        public C1808a m2772a(String str, String str2) {
            this.f8325a.add(HttpUrl.m2744a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f8326b.add(HttpUrl.m2744a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        /* renamed from: b */
        public C1808a m2771b(String str, String str2) {
            this.f8325a.add(HttpUrl.m2744a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f8326b.add(HttpUrl.m2744a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }

        /* renamed from: a */
        public FormBody m2773a() {
            return new FormBody(this.f8325a, this.f8326b);
        }
    }

    @Override // p181e.RequestBody
    /* renamed from: a */
    public void mo644a(BufferedSink bufferedSink) {
        m2774a(bufferedSink, false);
    }

    /* renamed from: a */
    public final long m2774a(BufferedSink bufferedSink, boolean z) {
        Buffer mo2569a;
        if (z) {
            mo2569a = new Buffer();
        } else {
            mo2569a = bufferedSink.mo2569a();
        }
        int size = this.f8323a.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                mo2569a.writeByte(38);
            }
            mo2569a.mo2573a(this.f8323a.get(i));
            mo2569a.writeByte(61);
            mo2569a.mo2573a(this.f8324b.get(i));
        }
        if (z) {
            long m2605s = mo2569a.m2605s();
            mo2569a.m2612l();
            return m2605s;
        }
        return 0L;
    }
}
