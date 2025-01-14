package p181e;

import java.util.Collections;
import java.util.List;

/* renamed from: e.m */
/* loaded from: classes.dex */
public interface CookieJar {

    /* renamed from: a */
    public static final CookieJar f8311a = new C1803a();

    /* compiled from: CookieJar.java */
    /* renamed from: e.m$a */
    /* loaded from: classes.dex */
    public class C1803a implements CookieJar {
        @Override // p181e.CookieJar
        /* renamed from: a */
        public List<Cookie> mo2790a(HttpUrl httpUrl) {
            return Collections.emptyList();
        }

        @Override // p181e.CookieJar
        /* renamed from: a */
        public void mo2789a(HttpUrl httpUrl, List<Cookie> list) {
        }
    }

    /* renamed from: a */
    List<Cookie> mo2790a(HttpUrl httpUrl);

    /* renamed from: a */
    void mo2789a(HttpUrl httpUrl, List<Cookie> list);
}
