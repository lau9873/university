class BooleanArrayIntSet implements IntSet {
    private int size;   // Numero de elementos do conjunto
    private boolean isElem[]; // Array que diz se o elem i está ou não

    BooleanArrayIntSet(int maxSize) {
	isElem = new boolean[maxSize];
	size=0;
    }
    public boolean add(int x) {
	if (!contains(x)) {
	    if (size == isElem.length)
		throw new RuntimeException("Maximum size of set reached");
	    isElem[x-1] = true;
	    size++;
	    return true;
	}
	return false;
    }

    public boolean remove(int x) {
	if (contains(x)) {
	    isElem[x-1]=false;
	    size--;
	    return true;
	    
	}
	return false;
    }
    public boolean contains(int x) {
	return isElem[x-1];
    }
    public void clear() {
	for (int i=0; i<isElem.length;i++)
	    isElem[i]=false;
	size=0;
    }
    public int size() {
	return size;
    }
    @Override
    public String toString() {
	String res = "{";
	for (int i=0,s=0;i<isElem.length;i++){
	    if (isElem[i-1] && s<size){
		    res+=i+",";
		    s++;
			}	    
	    if(isElem[i])
		res+=i;
	}
	res+="}";
	return res;
    }

    public boolean equals(IntSet s) {
	if (size()!=s.size())
	    return false;
	for (int i=1;i<isElem.length;i++)
	    if(isElem[i-1] != s.contains(i))
		return false;
	return true;
    }
    public IntSet intersection(IntSet s) {
	IntSet m = new BooleanArrayIntSet(isElem.length);
	for (int i =1, j=0; i<isElem.length && j<=s.size(); i++){
	    if (s.contains(i))
		j++;
	    if (isElem[i-1] && s.contains(i))
		m.add(i);
	}
	return m;
    }
		 
}
	
