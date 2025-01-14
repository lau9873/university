package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Set;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1071n;

/* renamed from: c.d.a.a.e.e.l.t */
/* loaded from: classes.dex */
public final class C1010t extends AbstractRunnableC1026x {

    /* renamed from: b */
    public final ArrayList<C0905a.InterfaceC0916f> f5318b;

    /* renamed from: c */
    public /* synthetic */ C0986n f5319c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1010t(C0986n c0986n, ArrayList<C0905a.InterfaceC0916f> arrayList) {
        super(c0986n, null);
        this.f5319c = c0986n;
        this.f5318b = arrayList;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractRunnableC1026x
    /* renamed from: a */
    public final void mo5332a() {
        C0954f0 c0954f0;
        Set<Scope> m5407i;
        InterfaceC1071n interfaceC1071n;
        C0954f0 c0954f02;
        c0954f0 = this.f5319c.f5247a;
        C0934a0 c0934a0 = c0954f0.f5172m;
        m5407i = this.f5319c.m5407i();
        c0934a0.f5111q = m5407i;
        ArrayList<C0905a.InterfaceC0916f> arrayList = this.f5318b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            C0905a.InterfaceC0916f interfaceC0916f = arrayList.get(i);
            i++;
            interfaceC1071n = this.f5319c.f5261o;
            c0954f02 = this.f5319c.f5247a;
            interfaceC0916f.m5613a(interfaceC1071n, c0954f02.f5172m.f5111q);
        }
    }
}
