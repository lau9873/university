package org.catacombae.csjc.structelements;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/BooleanRepresentableField.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/BooleanRepresentableField.class */
public abstract class BooleanRepresentableField extends Field {
    public abstract boolean getValueAsBoolean();

    public abstract void setBooleanValue(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public BooleanRepresentableField(String typeName, FieldType type) {
        super(typeName, type);
    }
}
