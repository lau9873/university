package p181e.p182i0.p187i;

import java.util.List;
import p192f.BufferedSource;

/* renamed from: e.i0.i.l */
/* loaded from: classes.dex */
public interface PushObserver {

    /* renamed from: a */
    public static final PushObserver f8222a = new C1790a();

    /* compiled from: PushObserver.java */
    /* renamed from: e.i0.i.l$a */
    /* loaded from: classes.dex */
    public class C1790a implements PushObserver {
        @Override // p181e.p182i0.p187i.PushObserver
        /* renamed from: a */
        public void mo2889a(int i, ErrorCode errorCode) {
        }

        @Override // p181e.p182i0.p187i.PushObserver
        /* renamed from: a */
        public boolean mo2888a(int i, BufferedSource bufferedSource, int i2, boolean z) {
            bufferedSource.skip(i2);
            return true;
        }

        @Override // p181e.p182i0.p187i.PushObserver
        /* renamed from: a */
        public boolean mo2887a(int i, List<C1766b> list) {
            return true;
        }

        @Override // p181e.p182i0.p187i.PushObserver
        /* renamed from: a */
        public boolean mo2886a(int i, List<C1766b> list, boolean z) {
            return true;
        }
    }

    /* renamed from: a */
    void mo2889a(int i, ErrorCode errorCode);

    /* renamed from: a */
    boolean mo2888a(int i, BufferedSource bufferedSource, int i2, boolean z);

    /* renamed from: a */
    boolean mo2887a(int i, List<C1766b> list);

    /* renamed from: a */
    boolean mo2886a(int i, List<C1766b> list, boolean z);
}
