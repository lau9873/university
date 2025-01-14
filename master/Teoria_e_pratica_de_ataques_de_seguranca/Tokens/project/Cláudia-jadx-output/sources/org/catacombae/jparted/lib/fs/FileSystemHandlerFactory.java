package org.catacombae.jparted.lib.fs;

import java.util.HashMap;
import java.util.Map;
import org.catacombae.jparted.lib.DataLocator;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerFactory.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerFactory.class */
public abstract class FileSystemHandlerFactory {
    protected final Attributes createAttributes = new Attributes(getSupportedStandardAttributes(), getSupportedCustomAttributes());

    public abstract FileSystemRecognizer getRecognizer();

    public abstract FileSystemHandler createHandler(DataLocator dataLocator);

    public abstract FileSystemHandlerInfo getHandlerInfo();

    public abstract FileSystemHandlerFactory newInstance();

    public abstract StandardAttribute[] getSupportedStandardAttributes();

    public abstract CustomAttribute[] getSupportedCustomAttributes();

    public Attributes getCreateAttributes() {
        return this.createAttributes;
    }

    public boolean isSupported(StandardAttribute attr) {
        StandardAttribute[] arr$ = getSupportedStandardAttributes();
        for (StandardAttribute sa : arr$) {
            if (sa == attr) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStandardAttributeDefaultValue(StandardAttribute attr, Object defaultValue) {
        attr.setDefaultValue(defaultValue);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static CustomAttribute createCustomAttribute(AttributeType iType, String iName, String iDescription, Object iDefaultValue) {
        CustomAttribute createdCustomAttribute = new CustomAttribute(iType, iName, iDescription, iDefaultValue);
        return createdCustomAttribute;
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerFactory$Attributes.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerFactory$Attributes.class */
    public class Attributes {
        private final Map<StandardAttribute, Object> standardCreateAttributeMap;
        private final Map<CustomAttribute, Object> customCreateAttributeMap;

        private Attributes(StandardAttribute[] iSupportedStandardAttributes, CustomAttribute[] iSupportedCustomAttributes) {
            this.standardCreateAttributeMap = new HashMap();
            this.customCreateAttributeMap = new HashMap();
            for (StandardAttribute sa : iSupportedStandardAttributes) {
                this.standardCreateAttributeMap.put(sa, sa.getDefaultValue());
            }
            for (CustomAttribute ca : iSupportedCustomAttributes) {
                this.customCreateAttributeMap.put(ca, ca.getDefaultValue());
            }
        }

        public final Boolean getBooleanAttribute(StandardAttribute attr) {
            return getBooleanAttribute(attr.getType(), this.standardCreateAttributeMap.get(attr));
        }

        public final Long getIntegerAttribute(StandardAttribute attr) {
            return getIntegerAttribute(attr.getType(), this.standardCreateAttributeMap.get(attr));
        }

        public final String getStringAttribute(StandardAttribute attr) {
            return getStringAttribute(attr.getType(), this.standardCreateAttributeMap.get(attr));
        }

        public final Boolean getBooleanAttribute(CustomAttribute attr) {
            return getBooleanAttribute(attr.getType(), this.customCreateAttributeMap.get(attr));
        }

        public final Long getIntegerAttribute(CustomAttribute attr) {
            return getIntegerAttribute(attr.getType(), this.customCreateAttributeMap.get(attr));
        }

        public final String getStringAttribute(CustomAttribute attr) {
            return getStringAttribute(attr.getType(), this.customCreateAttributeMap.get(attr));
        }

        public void setBooleanAttribute(StandardAttribute attr, Boolean value) {
            setAttribute(attr, value, this.standardCreateAttributeMap.get(attr));
        }

        public void setIntegerAttribute(StandardAttribute attr, Integer value) {
            setAttribute(attr, value, this.standardCreateAttributeMap.get(attr));
        }

        public void setStringAttribute(StandardAttribute attr, String value) {
            setAttribute(attr, value, this.standardCreateAttributeMap.get(attr));
        }

        public void setBooleanAttribute(CustomAttribute attr, Boolean value) {
            setAttribute(attr, value, this.customCreateAttributeMap.get(attr));
        }

        public void setIntegerAttribute(CustomAttribute attr, Integer value) {
            setAttribute(attr, value, this.customCreateAttributeMap.get(attr));
        }

        public void setStringAttribute(CustomAttribute attr, String value) {
            setAttribute(attr, value, this.customCreateAttributeMap.get(attr));
        }

        private final Boolean getBooleanAttribute(AttributeType type, Object value) {
            if (type != AttributeType.BOOLEAN) {
                throw new IllegalArgumentException("Tried to get BOOLEAN value from " + type + " type!");
            }
            if (value == null) {
                throw new IllegalArgumentException("Attribute is not supported by this implementation!");
            }
            if (value instanceof Boolean) {
                return (Boolean) value;
            }
            throw new RuntimeException("INTERNAL ERROR: Kick the coder for inserting " + value.getClass() + " values in a BOOLEAN attribute.");
        }

        private final Long getIntegerAttribute(AttributeType type, Object value) {
            if (type != AttributeType.INTEGER) {
                throw new IllegalArgumentException("Tried to get INTEGER value from " + type + " type!");
            }
            if (value == null) {
                throw new IllegalArgumentException("Attribute is not supported by this implementation!");
            }
            if (value instanceof Long) {
                return (Long) value;
            }
            if (value instanceof Number) {
                return Long.valueOf(((Number) value).longValue());
            }
            throw new RuntimeException("INTERNAL ERROR: Kick the coder for inserting " + value.getClass() + " values in an INTEGER attribute.");
        }

        private final String getStringAttribute(AttributeType type, Object value) {
            if (type != AttributeType.STRING) {
                throw new IllegalArgumentException("Tried to get STRING value from " + type + " type!");
            }
            if (value == null) {
                throw new IllegalArgumentException("Attribute is not supported by this implementation!");
            }
            if (value instanceof String) {
                return (String) value;
            }
            throw new RuntimeException("INTERNAL ERROR: Kick the coder for inserting " + value.getClass() + " values in a STRING attribute.");
        }

        private void setAttribute(StandardAttribute attr, Object newValue, Object oldValue) {
            if (!attr.getType().isValidValue(newValue)) {
                throw new IllegalArgumentException("Invalid value type (" + newValue.getClass() + ") for attribute (" + attr + ")!");
            }
            if (oldValue == null) {
                throw new IllegalArgumentException("Attribute " + attr + " is not supported by this implementation!");
            }
            this.standardCreateAttributeMap.put(attr, newValue);
        }

        private void setAttribute(CustomAttribute attr, Object newValue, Object oldValue) {
            if (!attr.getType().isValidValue(newValue)) {
                throw new IllegalArgumentException("Invalid value type (" + newValue.getClass() + ") for attribute (" + attr + ")!");
            }
            if (oldValue == null) {
                throw new IllegalArgumentException("Attribute " + attr + " is not supported by this implementation!");
            }
            this.customCreateAttributeMap.put(attr, newValue);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerFactory$AttributeType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerFactory$AttributeType.class */
    public enum AttributeType {
        BOOLEAN(Boolean.class),
        INTEGER(Byte.class, Short.class, Integer.class, Long.class),
        STRING(String.class);
        
        private final Class[] valueSuperClasses;

        AttributeType(Class... iValueSuperClasses) {
            this.valueSuperClasses = iValueSuperClasses;
        }

        public boolean isValidValue(Object value) {
            Class[] arr$ = this.valueSuperClasses;
            for (Class c2 : arr$) {
                if (c2.isInstance(value)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerFactory$StandardAttribute.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerFactory$StandardAttribute.class */
    public enum StandardAttribute {
        CACHING_ENABLED(AttributeType.BOOLEAN, new Boolean(false));
        
        private final AttributeType type;
        private Object defaultValue;

        StandardAttribute(AttributeType iType, Object iDefaultValue) {
            this.type = iType;
            setDefaultValue(iDefaultValue);
        }

        public AttributeType getType() {
            return this.type;
        }

        public Object getDefaultValue() {
            return this.defaultValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDefaultValue(Object iDefaultValue) {
            if (!this.type.isValidValue(iDefaultValue)) {
                throw new IllegalArgumentException("Illegal default value!");
            }
            this.defaultValue = iDefaultValue;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerFactory$CustomAttribute.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FileSystemHandlerFactory$CustomAttribute.class */
    public static final class CustomAttribute {
        private final AttributeType type;
        private final String name;
        private final String description;
        private final Object defaultValue;

        private CustomAttribute(AttributeType iType, String iName, String iDescription, Object iDefaultValue) {
            if (iType == null) {
                throw new IllegalArgumentException("An attribute must have a type.");
            }
            if (iName == null) {
                throw new IllegalArgumentException("An attribute must have a name.");
            }
            if (iDescription == null) {
                throw new IllegalArgumentException("An attribute must have a description.");
            }
            if (iDefaultValue == null) {
                throw new IllegalArgumentException("An attribute must have a default value.");
            }
            if (!iType.isValidValue(iDefaultValue)) {
                throw new IllegalArgumentException("Illegal default value!");
            }
            this.type = iType;
            this.name = iName;
            this.description = iDescription;
            this.defaultValue = iDefaultValue;
        }

        public AttributeType getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public String getDescription() {
            return this.description;
        }

        public Object getDefaultValue() {
            return this.defaultValue;
        }
    }
}
