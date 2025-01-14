package p070c.p084d.p085a.p086a.p103i;

import java.util.Comparator;

/* renamed from: c.d.a.a.i.q */
/* loaded from: classes.dex */
public final class C1225q implements Comparator<C1209c> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(C1209c c1209c, C1209c c1209c2) {
        C1209c c1209c3 = c1209c;
        C1209c c1209c4 = c1209c2;
        int compareTo = Integer.valueOf(c1209c4.m4992b()).compareTo(Integer.valueOf(c1209c3.m4992b()));
        return compareTo == 0 ? Integer.valueOf(c1209c3.m4991c()).compareTo(Integer.valueOf(c1209c4.m4991c())) : compareTo;
    }
}
