package org.jdesktop.layout;

import java.awt.Container;
import java.awt.Insets;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;
/* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/LayoutStyle.class */
public class LayoutStyle {
    private static final boolean USE_CORE_LAYOUT_STYLE;
    public static final int RELATED = 0;
    public static final int UNRELATED = 1;
    public static final int INDENT = 3;
    private static LayoutStyle layoutStyle;
    private static LookAndFeel laf;
    static final boolean $assertionsDisabled;
    static Class class$org$jdesktop$layout$LayoutStyle;

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    static {
        Class cls;
        if (class$org$jdesktop$layout$LayoutStyle == null) {
            cls = class$("org.jdesktop.layout.LayoutStyle");
            class$org$jdesktop$layout$LayoutStyle = cls;
        } else {
            cls = class$org$jdesktop$layout$LayoutStyle;
        }
        $assertionsDisabled = !cls.desiredAssertionStatus();
        boolean z = false;
        try {
            Class.forName("javax.swing.LayoutStyle");
            z = true;
        } catch (ClassNotFoundException e2) {
        }
        USE_CORE_LAYOUT_STYLE = z;
    }

    public static void setSharedInstance(LayoutStyle layoutStyle2) {
        UIManager.getLookAndFeelDefaults().put("LayoutStyle.instance", layoutStyle2);
    }

    public static LayoutStyle getSharedInstance() {
        Object obj = UIManager.get("LayoutStyle.instance");
        if (obj != null && (obj instanceof LayoutStyle)) {
            return (LayoutStyle) obj;
        }
        LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
        if (layoutStyle == null || lookAndFeel != laf) {
            laf = lookAndFeel;
            String id = laf.getID();
            if (USE_CORE_LAYOUT_STYLE) {
                layoutStyle = new SwingLayoutStyle();
            } else if ("Metal" == id) {
                layoutStyle = new MetalLayoutStyle();
            } else if ("Windows" == id) {
                layoutStyle = new WindowsLayoutStyle();
            } else if ("GTK" == id) {
                layoutStyle = new GnomeLayoutStyle();
            } else if ("Aqua" == id) {
                layoutStyle = new AquaLayoutStyle();
            } else {
                layoutStyle = new LayoutStyle();
            }
        }
        return layoutStyle;
    }

    public int getPreferredGap(JComponent jComponent, JComponent jComponent2, int i2, int i3, Container container) {
        int buttonChildIndent;
        if (i3 != 1 && i3 != 5 && i3 != 7 && i3 != 3) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (jComponent == null || jComponent2 == null) {
            throw new IllegalArgumentException("Components must be non-null");
        }
        if (i2 == 0) {
            return 6;
        }
        if (i2 == 1) {
            return 12;
        }
        if (i2 == 3) {
            if ((i3 == 3 || i3 == 7) && (buttonChildIndent = getButtonChildIndent(jComponent, i3)) != 0) {
                return buttonChildIndent;
            }
            return 6;
        }
        throw new IllegalArgumentException("Invalid type");
    }

    public int getContainerGap(JComponent jComponent, int i2, Container container) {
        if (i2 != 1 && i2 != 5 && i2 != 7 && i2 != 3) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (jComponent == null) {
            throw new IllegalArgumentException("Component must be non-null");
        }
        return 12;
    }

    boolean isDialog(JComponent jComponent) {
        String name = jComponent.getName();
        return name != null && name.endsWith(".contentPane");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCBRBPadding(JComponent jComponent, JComponent jComponent2, int i2, int i3) {
        int cBRBPadding = i3 - getCBRBPadding(jComponent, i2);
        if (cBRBPadding > 0) {
            cBRBPadding -= getCBRBPadding(jComponent2, flipDirection(i2));
        }
        if (cBRBPadding < 0) {
            return 0;
        }
        return cBRBPadding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCBRBPadding(JComponent jComponent, int i2, int i3) {
        return Math.max(i3 - getCBRBPadding(jComponent, i2), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int flipDirection(int i2) {
        switch (i2) {
            case 1:
                return 5;
            case 2:
            case 4:
            case 6:
            default:
                if ($assertionsDisabled) {
                    return 0;
                }
                throw new AssertionError();
            case 3:
                return 7;
            case 5:
                return 1;
            case 7:
                return 3;
        }
    }

    private int getCBRBPadding(JComponent jComponent, int i2) {
        if ((jComponent.getUIClassID() == "CheckBoxUI" || jComponent.getUIClassID() == "RadioButtonUI") && (jComponent.getBorder() instanceof UIResource)) {
            return getInset(jComponent, i2);
        }
        return 0;
    }

    private int getInset(JComponent jComponent, int i2) {
        Insets insets = jComponent.getInsets();
        switch (i2) {
            case 1:
                return insets.top;
            case 2:
            case 4:
            case 6:
            default:
                if ($assertionsDisabled) {
                    return 0;
                }
                throw new AssertionError();
            case 3:
                return insets.right;
            case 5:
                return insets.bottom;
            case 7:
                return insets.left;
        }
    }

    private boolean isLeftAligned(AbstractButton abstractButton, int i2) {
        if (i2 == 7) {
            boolean isLeftToRight = abstractButton.getComponentOrientation().isLeftToRight();
            int horizontalAlignment = abstractButton.getHorizontalAlignment();
            return (isLeftToRight && (horizontalAlignment == 2 || horizontalAlignment == 10)) || (!isLeftToRight && horizontalAlignment == 11);
        }
        return false;
    }

    private boolean isRightAligned(AbstractButton abstractButton, int i2) {
        if (i2 == 3) {
            boolean isLeftToRight = abstractButton.getComponentOrientation().isLeftToRight();
            int horizontalAlignment = abstractButton.getHorizontalAlignment();
            return (isLeftToRight && (horizontalAlignment == 4 || horizontalAlignment == 11)) || (!isLeftToRight && horizontalAlignment == 10);
        }
        return false;
    }

    private Icon getIcon(AbstractButton abstractButton) {
        Icon icon = abstractButton.getIcon();
        if (icon != null) {
            return icon;
        }
        Object obj = null;
        if (abstractButton instanceof JCheckBox) {
            obj = "CheckBox.icon";
        } else if (abstractButton instanceof JRadioButton) {
            obj = "RadioButton.icon";
        }
        if (obj != null) {
            Object obj2 = UIManager.get(obj);
            if (obj2 instanceof Icon) {
                return (Icon) obj2;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getButtonChildIndent(JComponent jComponent, int i2) {
        if ((jComponent instanceof JRadioButton) || (jComponent instanceof JCheckBox)) {
            AbstractButton abstractButton = (AbstractButton) jComponent;
            Insets insets = jComponent.getInsets();
            Icon icon = getIcon(abstractButton);
            int iconTextGap = abstractButton.getIconTextGap();
            if (isLeftAligned(abstractButton, i2)) {
                return insets.left + icon.getIconWidth() + iconTextGap;
            }
            if (isRightAligned(abstractButton, i2)) {
                return insets.right + icon.getIconWidth() + iconTextGap;
            }
            return 0;
        }
        return 0;
    }
}
