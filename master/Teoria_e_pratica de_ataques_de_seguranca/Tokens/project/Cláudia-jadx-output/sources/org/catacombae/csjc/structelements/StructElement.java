package org.catacombae.csjc.structelements;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/StructElement.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/StructElement.class */
public abstract class StructElement {
    protected final String typeName;
    protected final String typeDescription;

    /* JADX INFO: Access modifiers changed from: protected */
    public StructElement(String typeName) {
        this(typeName, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StructElement(String typeName, String typeDescription) {
        this.typeName = typeName;
        this.typeDescription = typeDescription;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String getTypeDescription() {
        return this.typeDescription;
    }
}
