package org.catacombae.csjc;

import java.lang.reflect.Field;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/MutableStruct.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/MutableStruct.class */
public abstract class MutableStruct {
    private final boolean mutable = false;

    public MutableStruct() {
    }

    public MutableStruct(boolean mutable) {
    }

    public void setByteField(String fieldName, byte value) {
        if (this.mutable) {
            byte[] fieldData = getFieldData(fieldName);
            if (fieldData.length != 1) {
                throw new IllegalArgumentException("Invalid input! length is not equal to the length of the field data");
            }
            System.arraycopy(Util.toByteArrayBE(value), 0, fieldData, 0, 1);
            return;
        }
        accessViolation();
    }

    public void setShortField(String fieldName, short value) {
        if (this.mutable) {
            byte[] fieldData = getFieldData(fieldName);
            if (fieldData.length != 2) {
                throw new IllegalArgumentException("Invalid input! length is not equal to the length of the field data");
            }
            System.arraycopy(Util.toByteArrayBE(value), 0, fieldData, 0, fieldData.length);
            return;
        }
        accessViolation();
    }

    public void setCharField(String fieldName, char value) {
        if (this.mutable) {
            byte[] fieldData = getFieldData(fieldName);
            if (fieldData.length != 2) {
                throw new IllegalArgumentException("Invalid input! length is not equal to the length of the field data");
            }
            System.arraycopy(Util.toByteArrayBE(value), 0, fieldData, 0, fieldData.length);
            return;
        }
        accessViolation();
    }

    public void setIntField(String fieldName, int value) {
        if (this.mutable) {
            byte[] fieldData = getFieldData(fieldName);
            if (fieldData.length != 4) {
                throw new IllegalArgumentException("Invalid input! length is not equal to the length of the field data");
            }
            System.arraycopy(Util.toByteArrayBE(value), 0, fieldData, 0, fieldData.length);
            return;
        }
        accessViolation();
    }

    public void setLongField(String fieldName, long value) {
        if (this.mutable) {
            byte[] fieldData = getFieldData(fieldName);
            if (fieldData.length != 8) {
                throw new IllegalArgumentException("Invalid input! length is not equal to the length of the field data");
            }
            System.arraycopy(Util.toByteArrayBE(value), 0, fieldData, 0, fieldData.length);
            return;
        }
        accessViolation();
    }

    public void setByteArrayField(String fieldName, byte[] value) {
        setByteArrayField(fieldName, value, 0, value.length);
    }

    public void setByteArrayField(String fieldName, byte[] value, int offset, int length) {
        if (this.mutable) {
            byte[] fieldData = getFieldData(fieldName);
            if (length != fieldData.length) {
                throw new IllegalArgumentException("Invalid input! length is not equal to the length of the field data");
            }
            System.arraycopy(value, offset, fieldData, 0, length);
            return;
        }
        accessViolation();
    }

    public void setStructField(String fieldName, MutableStruct yada) {
        if (this.mutable) {
            Object fieldObject = getFieldObject(fieldName);
            if (!(fieldObject instanceof MutableStruct)) {
                throw new IllegalArgumentException("No such Struct field.");
            }
            return;
        }
        accessViolation();
    }

    protected void accessViolation() {
        throw new RuntimeException("Access violation: Tried to set fields in an immutable object.");
    }

    private byte[] getFieldData(String fieldName) {
        Object o = getFieldObject(fieldName);
        if (o instanceof byte[]) {
            return (byte[]) o;
        }
        throw new IllegalArgumentException("No such byte array field.");
    }

    private Object getFieldObject(String fieldName) {
        try {
            Class thisClass = getClass();
            Field f2 = thisClass.getField(fieldName);
            return f2.get(this);
        } catch (IllegalAccessException iae) {
            throw new IllegalArgumentException(iae);
        } catch (NoSuchFieldException nsfe) {
            throw new IllegalArgumentException(nsfe);
        }
    }
}
