package org.jdesktop.layout;

import java.awt.Container;
import javax.swing.JComponent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GnomeLayoutStyle.class */
public class GnomeLayoutStyle extends LayoutStyle {
    @Override // org.jdesktop.layout.LayoutStyle
    public int getPreferredGap(JComponent jComponent, JComponent jComponent2, int i2, int i3, Container container) {
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
        if (i3 == 3 || i3 == 7) {
            boolean z = jComponent.getUIClassID() == "LabelUI";
            boolean z2 = jComponent2.getUIClassID() == "LabelUI";
            if (z && !z2) {
                return 12;
            }
            if (!z && z2) {
                return 12;
            }
        }
        if (i2 == 0) {
            return 6;
        }
        return 12;
    }

    @Override // org.jdesktop.layout.LayoutStyle
    public int getContainerGap(JComponent jComponent, int i2, Container container) {
        super.getContainerGap(jComponent, i2, container);
        return 12;
    }
}
