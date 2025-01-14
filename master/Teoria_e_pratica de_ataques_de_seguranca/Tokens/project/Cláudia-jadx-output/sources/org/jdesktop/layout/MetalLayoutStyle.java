package org.jdesktop.layout;

import java.awt.Container;
import java.lang.reflect.InvocationTargetException;
import javax.swing.DefaultButtonModel;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalTheme;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/MetalLayoutStyle.class */
public class MetalLayoutStyle extends LayoutStyle {
    private boolean isOcean;
    static Class class$javax$swing$plaf$metal$MetalLookAndFeel;

    public MetalLayoutStyle() {
        Class cls;
        this.isOcean = false;
        try {
            if (class$javax$swing$plaf$metal$MetalLookAndFeel == null) {
                cls = class$("javax.swing.plaf.metal.MetalLookAndFeel");
                class$javax$swing$plaf$metal$MetalLookAndFeel = cls;
            } else {
                cls = class$javax$swing$plaf$metal$MetalLookAndFeel;
            }
            this.isOcean = ((MetalTheme) cls.getMethod("getCurrentTheme", null).invoke(null, null)).getName() == "Ocean";
        } catch (IllegalAccessException e2) {
        } catch (IllegalArgumentException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (InvocationTargetException e5) {
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    @Override // org.jdesktop.layout.LayoutStyle
    public int getPreferredGap(JComponent jComponent, JComponent jComponent2, int i2, int i3, Container container) {
        int i4;
        super.getPreferredGap(jComponent, jComponent2, i2, i3, container);
        if (i2 == 3) {
            if (i3 == 3 || i3 == 7) {
                int buttonChildIndent = getButtonChildIndent(jComponent, i3);
                if (buttonChildIndent != 0) {
                    return buttonChildIndent;
                }
                return 12;
            }
            i2 = 0;
        }
        String uIClassID = jComponent.getUIClassID();
        String uIClassID2 = jComponent2.getUIClassID();
        if (i2 == 0) {
            if (uIClassID == "ToggleButtonUI" && uIClassID2 == "ToggleButtonUI") {
                DefaultButtonModel model = ((JToggleButton) jComponent).getModel();
                DefaultButtonModel model2 = ((JToggleButton) jComponent2).getModel();
                if ((model instanceof DefaultButtonModel) && (model2 instanceof DefaultButtonModel) && model.getGroup() == model2.getGroup() && model.getGroup() != null) {
                    return 2;
                }
                if (this.isOcean) {
                    return 6;
                }
                return 5;
            }
            i4 = 6;
        } else {
            i4 = 12;
        }
        if ((i3 == 3 || i3 == 7) && ((uIClassID == "LabelUI" && uIClassID2 != "LabelUI") || (uIClassID != "LabelUI" && uIClassID2 == "LabelUI"))) {
            return getCBRBPadding(jComponent, jComponent2, i3, i4 + 6);
        }
        return getCBRBPadding(jComponent, jComponent2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.jdesktop.layout.LayoutStyle
    public int getCBRBPadding(JComponent jComponent, JComponent jComponent2, int i2, int i3) {
        int cBRBPadding = super.getCBRBPadding(jComponent, jComponent2, i2, i3);
        if (cBRBPadding > 0) {
            int buttonAdjustment = getButtonAdjustment(jComponent, i2);
            if (buttonAdjustment == 0) {
                buttonAdjustment = getButtonAdjustment(jComponent2, flipDirection(i2));
            }
            cBRBPadding -= buttonAdjustment;
        }
        if (cBRBPadding < 0) {
            return 0;
        }
        return cBRBPadding;
    }

    private int getButtonAdjustment(JComponent jComponent, int i2) {
        String uIClassID = jComponent.getUIClassID();
        if (uIClassID == "ButtonUI" || uIClassID == "ToggleButtonUI") {
            if (this.isOcean) {
                return 0;
            }
            if (i2 == 3 || i2 == 5) {
                return 1;
            }
            return 0;
        } else if (i2 == 5) {
            if (uIClassID != "RadioButtonUI") {
                if (!this.isOcean && uIClassID == "CheckBoxUI") {
                    return 1;
                }
                return 0;
            }
            return 1;
        } else {
            return 0;
        }
    }

    @Override // org.jdesktop.layout.LayoutStyle
    public int getContainerGap(JComponent jComponent, int i2, Container container) {
        super.getContainerGap(jComponent, i2, container);
        return getCBRBPadding(jComponent, i2, 12 - getButtonAdjustment(jComponent, i2));
    }
}
