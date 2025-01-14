package org.catacombae.xml;

import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/Attribute.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/xml/Attribute.class */
public class Attribute {
    public String identifier;
    public Value value;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/Attribute$ValueComponent.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/xml/Attribute$ValueComponent.class */
    public static abstract class ValueComponent {
        public abstract String toString();
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/Attribute$StringComponent.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/xml/Attribute$StringComponent.class */
    public static class StringComponent extends ValueComponent {
        public String content;

        public StringComponent(String content) {
            this.content = content;
        }

        @Override // org.catacombae.xml.Attribute.ValueComponent
        public String toString() {
            return this.content;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/Attribute$ReferenceComponent.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/xml/Attribute$ReferenceComponent.class */
    public static class ReferenceComponent extends ValueComponent {
        public String content;

        public ReferenceComponent(String content) {
            this.content = content;
        }

        @Override // org.catacombae.xml.Attribute.ValueComponent
        public String toString() {
            return this.content;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/xml/Attribute$Value.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/xml/Attribute$Value.class */
    public static class Value {
        public List<ValueComponent> components;

        public Value(List<ValueComponent> components) {
            this.components = components;
        }

        public String toString() {
            StringBuilder result = new StringBuilder();
            for (ValueComponent vc : this.components) {
                result.append(vc.toString());
            }
            return result.toString();
        }
    }

    public Attribute(String identifier, Value value) {
        this.identifier = identifier;
        this.value = value;
    }
}
