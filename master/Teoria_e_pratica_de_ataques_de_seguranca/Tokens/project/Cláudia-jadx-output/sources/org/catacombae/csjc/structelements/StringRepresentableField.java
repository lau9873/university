package org.catacombae.csjc.structelements;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/StringRepresentableField.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/StringRepresentableField.class */
public abstract class StringRepresentableField extends Field {
    private final String unitComponent;

    public abstract String getValueAsString();

    public abstract void setStringValue(String str) throws IllegalArgumentException;

    public abstract String validateStringValue(String str);

    public StringRepresentableField(String typeName, FieldType type) {
        this(typeName, null, type, null);
    }

    public StringRepresentableField(String typeName, FieldType type, String unitComponent) {
        this(typeName, null, type, unitComponent);
    }

    public StringRepresentableField(String typeName, String typeDescription, FieldType type, String unitComponent) {
        super(typeName, typeDescription, type);
        this.unitComponent = unitComponent;
    }

    public String getUnitComponent() {
        return this.unitComponent;
    }
}
