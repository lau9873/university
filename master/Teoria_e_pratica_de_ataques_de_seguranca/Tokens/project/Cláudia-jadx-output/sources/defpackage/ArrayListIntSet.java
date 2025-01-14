package defpackage;
/* renamed from: ArrayListIntSet  reason: default package */
/* loaded from: ArrayListIntSet.class */
public class ArrayListIntSet implements IntSet {
    private int size = 0;
    private int[] elem;

    ArrayListIntSet(int i2) {
        this.elem = new int[i2];
    }

    @Override // defpackage.IntSet
    public boolean add(int i2) {
        if (!contains(i2)) {
            if (this.size == this.elem.length) {
                throw new RuntimeException("Maximum size of set reached");
            }
            this.elem[this.size] = i2;
            this.size++;
            return true;
        }
        return false;
    }

    @Override // defpackage.IntSet
    public boolean remove(int i2) {
        if (contains(i2)) {
            int i3 = 0;
            while (this.elem[i3] != i2) {
                i3++;
            }
            this.size--;
            this.elem[i3] = this.elem[this.size];
            return true;
        }
        return false;
    }

    @Override // defpackage.IntSet
    public boolean contains(int i2) {
        for (int i3 = 0; i3 < this.size; i3++) {
            if (this.elem[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.IntSet
    public void clear() {
        this.size = 0;
    }

    @Override // defpackage.IntSet
    public int size() {
        return this.size;
    }

    public String toString() {
        String str = "{";
        for (int i2 = 0; i2 < this.size; i2++) {
            if (i2 > 0) {
                str = str + ",";
            }
            str = str + this.elem[i2];
        }
        return str + "}";
    }

    @Override // defpackage.IntSet
    public boolean equals(IntSet intSet) {
        if (size() != intSet.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.size; i2++) {
            if (!intSet.contains(this.elem[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.IntSet
    public IntSet intersection(IntSet intSet) {
        ArrayListIntSet arrayListIntSet = new ArrayListIntSet(size() + intSet.size());
        for (int i2 = 0; i2 < size(); i2++) {
            if (intSet.contains(this.elem[i2])) {
                arrayListIntSet.add(this.elem[i2]);
            }
        }
        return arrayListIntSet;
    }
}
