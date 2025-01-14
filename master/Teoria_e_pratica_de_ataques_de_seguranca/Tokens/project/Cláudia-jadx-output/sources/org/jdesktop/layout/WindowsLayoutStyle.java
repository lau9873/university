package org.jdesktop.layout;

import java.awt.Container;
import java.awt.FontMetrics;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.UIManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/WindowsLayoutStyle.class */
public class WindowsLayoutStyle extends LayoutStyle {
    private int baseUnitX;
    private int baseUnitY;
    static final boolean $assertionsDisabled;
    static Class class$org$jdesktop$layout$WindowsLayoutStyle;

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    static {
        Class cls;
        if (class$org$jdesktop$layout$WindowsLayoutStyle == null) {
            cls = class$("org.jdesktop.layout.WindowsLayoutStyle");
            class$org$jdesktop$layout$WindowsLayoutStyle = cls;
        } else {
            cls = class$org$jdesktop$layout$WindowsLayoutStyle;
        }
        $assertionsDisabled = !cls.desiredAssertionStatus();
    }

    @Override // org.jdesktop.layout.LayoutStyle
    public int getPreferredGap(JComponent jComponent, JComponent jComponent2, int i2, int i3, Container container) {
        super.getPreferredGap(jComponent, jComponent2, i2, i3, container);
        if (i2 == 3) {
            if (i3 == 3 || i3 == 7) {
                int buttonChildIndent = getButtonChildIndent(jComponent, i3);
                if (buttonChildIndent != 0) {
                    return buttonChildIndent;
                }
                return 10;
            }
            i2 = 0;
        }
        if (i2 == 1) {
            return getCBRBPadding(jComponent, jComponent2, i3, dluToPixels(7, i3));
        }
        boolean z = jComponent.getUIClassID() == "LabelUI";
        boolean z2 = jComponent2.getUIClassID() == "LabelUI";
        if (((z && !z2) || (z2 && !z)) && (i3 == 3 || i3 == 7)) {
            return getCBRBPadding(jComponent, jComponent2, i3, dluToPixels(3, i3));
        }
        return getCBRBPadding(jComponent, jComponent2, i3, dluToPixels(4, i3));
    }

    @Override // org.jdesktop.layout.LayoutStyle
    public int getContainerGap(JComponent jComponent, int i2, Container container) {
        super.getContainerGap(jComponent, i2, container);
        return getCBRBPadding(jComponent, i2, dluToPixels(7, i2));
    }

    private int dluToPixels(int i2, int i3) {
        if (this.baseUnitX == 0) {
            calculateBaseUnits();
        }
        if (i3 == 3 || i3 == 7) {
            return (i2 * this.baseUnitX) / 4;
        }
        if ($assertionsDisabled || i3 == 1 || i3 == 5) {
            return (i2 * this.baseUnitY) / 8;
        }
        throw new AssertionError();
    }

    private void calculateBaseUnits() {
        FontMetrics fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(UIManager.getFont("Button.font"));
        this.baseUnitX = fontMetrics.stringWidth("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
        this.baseUnitX = ((this.baseUnitX / 26) + 1) / 2;
        this.baseUnitY = (fontMetrics.getAscent() + fontMetrics.getDescent()) - 1;
    }
}
