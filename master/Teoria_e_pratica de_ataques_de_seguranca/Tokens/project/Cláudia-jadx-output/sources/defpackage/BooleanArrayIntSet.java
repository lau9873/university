package defpackage;
/* renamed from: BooleanArrayIntSet  reason: default package */
/* loaded from: BooleanArrayIntSet.class */
class BooleanArrayIntSet implements IntSet {
    private int size = 0;
    private boolean[] isElem;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BooleanArrayIntSet(int i2) {
        this.isElem = new boolean[i2];
    }

    @Override // defpackage.IntSet
    public boolean add(int i2) {
        if (!contains(i2)) {
            if (this.size == this.isElem.length) {
                throw new RuntimeException("Maximum size of set reached");
            }
            this.isElem[i2 - 1] = true;
            this.size++;
            return true;
        }
        return false;
    }

    @Override // defpackage.IntSet
    public boolean remove(int i2) {
        if (contains(i2)) {
            this.isElem[i2 - 1] = false;
            this.size--;
            return true;
        }
        return false;
    }

    @Override // defpackage.IntSet
    public boolean contains(int i2) {
        return this.isElem[i2 - 1];
    }

    @Override // defpackage.IntSet
    public void clear() {
        for (int i2 = 0; i2 < this.isElem.length; i2++) {
            this.isElem[i2] = false;
        }
        this.size = 0;
    }

    @Override // defpackage.IntSet
    public int size() {
        return this.size;
    }

    public String toString() {
        String str = "{";
        int i2 = 0;
        for (int i3 = 0; i3 < this.isElem.length; i3++) {
            if (this.isElem[i3 - 1] && i2 < this.size) {
                str = str + i3 + ",";
                i2++;
            }
            if (this.isElem[i3]) {
                str = str + i3;
            }
        }
        return str + "}";
    }

    @Override // defpackage.IntSet
    public boolean equals(IntSet intSet) {
        if (size() != intSet.size()) {
            return false;
        }
        for (int i2 = 1; i2 < this.isElem.length; i2++) {
            if (this.isElem[i2 - 1] != intSet.contains(i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.IntSet
    public IntSet intersection(IntSet intSet) {
        BooleanArrayIntSet booleanArrayIntSet = new BooleanArrayIntSet(this.isElem.length);
        int i2 = 0;
        for (int i3 = 1; i3 < this.isElem.length && i2 <= intSet.size(); i3++) {
            if (intSet.contains(i3)) {
                i2++;
            }
            if (this.isElem[i3 - 1] && intSet.contains(i3)) {
                booleanArrayIntSet.add(i3);
            }
        }
        return booleanArrayIntSet;
    }
}
