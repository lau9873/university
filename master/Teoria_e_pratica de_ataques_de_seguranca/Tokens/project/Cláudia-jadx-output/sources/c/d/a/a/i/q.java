package c.d.a.a.i;

import java.util.Comparator;
/* loaded from: classes.dex */
public final class q implements Comparator<c> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(c cVar, c cVar2) {
        c cVar3 = cVar;
        c cVar4 = cVar2;
        int compareTo = Integer.valueOf(cVar4.b()).compareTo(Integer.valueOf(cVar3.b()));
        return compareTo == 0 ? Integer.valueOf(cVar3.c()).compareTo(Integer.valueOf(cVar4.c())) : compareTo;
    }
}
