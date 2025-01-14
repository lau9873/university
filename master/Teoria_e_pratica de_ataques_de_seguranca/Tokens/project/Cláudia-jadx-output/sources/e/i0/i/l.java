package e.i0.i;

import java.util.List;
/* compiled from: PushObserver.java */
/* loaded from: classes.dex */
public interface l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f5814a = new a();

    /* compiled from: PushObserver.java */
    /* loaded from: classes.dex */
    public class a implements l {
        @Override // e.i0.i.l
        public void a(int i2, e.i0.i.a aVar) {
        }

        @Override // e.i0.i.l
        public boolean a(int i2, f.e eVar, int i3, boolean z) {
            eVar.skip(i3);
            return true;
        }

        @Override // e.i0.i.l
        public boolean a(int i2, List<b> list) {
            return true;
        }

        @Override // e.i0.i.l
        public boolean a(int i2, List<b> list, boolean z) {
            return true;
        }
    }

    void a(int i2, e.i0.i.a aVar);

    boolean a(int i2, f.e eVar, int i3, boolean z);

    boolean a(int i2, List<b> list);

    boolean a(int i2, List<b> list, boolean z);
}
