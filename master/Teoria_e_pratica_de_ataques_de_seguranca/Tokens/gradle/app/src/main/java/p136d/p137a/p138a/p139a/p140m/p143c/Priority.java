package p136d.p137a.p138a.p139a.p140m.p143c;

/* renamed from: d.a.a.a.m.c.f */
/* loaded from: classes.dex */
public enum Priority {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    /* renamed from: a */
    public static <Y> int m3980a(PriorityProvider priorityProvider, Y y) {
        Priority priority;
        if (y instanceof PriorityProvider) {
            priority = ((PriorityProvider) y).mo3972a();
        } else {
            priority = NORMAL;
        }
        return priority.ordinal() - priorityProvider.mo3972a().ordinal();
    }
}
