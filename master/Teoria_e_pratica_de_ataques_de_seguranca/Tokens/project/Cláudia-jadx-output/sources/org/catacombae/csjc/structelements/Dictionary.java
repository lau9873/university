package org.catacombae.csjc.structelements;

import java.util.Hashtable;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/csjc/structelements/Dictionary.class
 */
/* loaded from: hfsx.jar:org/catacombae/csjc/structelements/Dictionary.class */
public class Dictionary extends StructElement {
    private final String[] keys;
    private final Hashtable<String, StructElement> mappings;
    private final Hashtable<String, String> descriptions;

    Dictionary(String typeName, String[] keys, Hashtable<String, StructElement> mappings, Hashtable<String, String> descriptions) {
        this(typeName, null, keys, mappings, descriptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Dictionary(String typeName, String typeDescription, String[] keys, Hashtable<String, StructElement> mappings, Hashtable<String, String> descriptions) {
        super(typeName, typeDescription);
        this.keys = new String[keys.length];
        System.arraycopy(keys, 0, this.keys, 0, keys.length);
        this.mappings = new Hashtable<>();
        this.descriptions = new Hashtable<>();
        for (String key : keys) {
            this.mappings.put(key, mappings.get(key));
            String description = descriptions.get(key);
            if (description != null) {
                this.descriptions.put(key, description);
            }
        }
    }

    public StructElement getElement(String name) {
        return this.mappings.get(name);
    }

    public String getDescription(String name) {
        return this.descriptions.get(name);
    }

    public int getElementCount() {
        return this.keys.length;
    }

    public String[] getKeys() {
        return (String[]) Util.arrayCopy(this.keys, new String[this.keys.length]);
    }
}
