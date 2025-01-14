package org.catacombae.csjc.structelements;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/Field.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/Field.class */
public abstract class Field extends StructElement {
    private final FieldType type;

    /* JADX INFO: Access modifiers changed from: protected */
    public Field(String typeName, FieldType type) {
        this(typeName, null, type);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Field(String typeName, String typeDescription, FieldType type) {
        super(typeName, typeDescription);
        this.type = type;
    }

    public FieldType getType() {
        return this.type;
    }
}
