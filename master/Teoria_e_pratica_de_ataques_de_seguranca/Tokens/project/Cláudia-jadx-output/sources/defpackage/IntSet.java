package defpackage;
/* renamed from: IntSet  reason: default package */
/* loaded from: IntSet.class */
public interface IntSet {
    boolean contains(int i2);

    boolean add(int i2);

    boolean remove(int i2);

    int size();

    void clear();

    boolean equals(IntSet intSet);

    IntSet intersection(IntSet intSet);
}
