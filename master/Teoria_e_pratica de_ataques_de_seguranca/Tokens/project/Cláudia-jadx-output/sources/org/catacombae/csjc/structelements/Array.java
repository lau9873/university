package org.catacombae.csjc.structelements;

import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/Array.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/Array.class */
public class Array extends StructElement {
    private final StructElement[] elements;

    public Array(String typeName, StructElement[] elements) {
        super(typeName + "[" + elements.length + "]");
        this.elements = new StructElement[elements.length];
        for (int i2 = 0; i2 < this.elements.length; i2++) {
            this.elements[i2] = elements[i2];
        }
    }

    public StructElement[] getElements() {
        return (StructElement[]) Util.arrayCopy(this.elements, new StructElement[this.elements.length]);
    }
}
