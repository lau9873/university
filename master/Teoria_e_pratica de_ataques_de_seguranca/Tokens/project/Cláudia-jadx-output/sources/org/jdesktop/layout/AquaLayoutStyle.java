package org.jdesktop.layout;

import java.applet.Applet;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Panel;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/AquaLayoutStyle.class */
public class AquaLayoutStyle extends LayoutStyle {
    private static final Insets EMPTY_INSETS;
    private static final int MINI = 0;
    private static final int SMALL = 1;
    private static final int REGULAR = 2;
    private static final Object[][] containerGapDefinitions;
    private static final Object[][] relatedGapDefinitions;
    private static final Object[][] unrelatedGapDefinitions;
    private static final Object[][] indentGapDefinitions;
    private static final Object[][] visualMarginDefinitions;
    private static final Map RELATED_GAPS;
    private static final Map UNRELATED_GAPS;
    private static final Map CONTAINER_GAPS;
    private static final Map INDENT_GAPS;
    private static final Map VISUAL_MARGINS;
    static final boolean $assertionsDisabled;
    static Class class$org$jdesktop$layout$AquaLayoutStyle;

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object[], java.lang.Object[][]] */
    static {
        Class cls;
        if (class$org$jdesktop$layout$AquaLayoutStyle == null) {
            cls = class$("org.jdesktop.layout.AquaLayoutStyle");
            class$org$jdesktop$layout$AquaLayoutStyle = cls;
        } else {
            cls = class$org$jdesktop$layout$AquaLayoutStyle;
        }
        $assertionsDisabled = !cls.desiredAssertionStatus();
        EMPTY_INSETS = new Insets(0, 0, 0, 0);
        containerGapDefinitions = new Object[]{new Object[]{"TabbedPaneUI", new Insets(6, 10, 10, 10), new Insets(6, 10, 10, 12), new Insets(12, 20, 20, 20)}, new Object[]{"RootPaneUI", new Insets(8, 10, 10, 10), new Insets(8, 10, 10, 12), new Insets(14, 20, 20, 20)}, new Object[]{"default", new Insets(8, 10, 10, 10), new Insets(8, 10, 10, 12), new Insets(14, 20, 20, 20)}};
        relatedGapDefinitions = new Object[]{new Object[]{"ButtonUI", "ButtonUI.push", "ButtonUI.text", "ToggleButtonUI.push", "ToggleButtonUI.text", new Insets(8, 8, 8, 8), new Insets(10, 10, 10, 10), new Insets(12, 12, 12, 12)}, new Object[]{"ButtonUI.metal", "ToggleButtonUI.metal", new Insets(8, 8, 8, 8), new Insets(8, 8, 8, 8), new Insets(12, 12, 12, 12)}, new Object[]{"ButtonUI.bevel", "ButtonUI.toggle", "ButtonUI.square", "ToggleButtonUI", "ToggleButtonUI.bevel", "ToggleButtonUI.square", "ToggleButtonUI.toggle", new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0)}, new Object[]{"ButtonUI.bevel.largeIcon", "ToggleButtonUI.bevel.largeIcon", new Insets(8, 8, 8, 8), new Insets(8, 8, 8, 8), new Insets(8, 8, 8, 8)}, new Object[]{"ButtonUI.icon", new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0)}, new Object[]{"ButtonUI.icon.largeIcon", new Insets(8, 8, 8, 8), new Insets(8, 8, 8, 8), new Insets(8, 8, 8, 8)}, new Object[]{"ButtonUI.round", "ToggleButtonUI.round", new Insets(12, 12, 12, 12), new Insets(12, 12, 12, 12), new Insets(12, 12, 12, 12)}, new Object[]{"ButtonUI.help", new Insets(12, 12, 12, 12), new Insets(12, 12, 12, 12), new Insets(12, 12, 12, 12)}, new Object[]{"ButtonUI.toggleCenter", "ToggleButtonUI.toggleCenter", new Insets(8, 0, 8, 0), new Insets(10, 0, 10, 0), new Insets(12, 0, 12, 0)}, new Object[]{"ButtonUI.toggleEast", "ToggleButtonUI.toggleEast", new Insets(8, 0, 8, 8), new Insets(10, 0, 10, 10), new Insets(12, 0, 12, 12)}, new Object[]{"ButtonUI.toggleWest", "ToggleButtonUI.toggleWest", new Insets(8, 8, 8, 0), new Insets(10, 10, 10, 0), new Insets(12, 12, 12, 0)}, new Object[]{"ButtonUI.toolBarTab", "ToggleButtonUI.toolBarTab", new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0)}, new Object[]{"ButtonUI.colorWell", "ToggleButtonUI.colorWell", new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0)}, new Object[]{"CheckBoxUI", new Insets(6, 5, 6, 5), new Insets(7, 6, 7, 6), new Insets(7, 6, 7, 6)}, new Object[]{"ComboBoxUI.editable", new Insets(8, 5, 8, 5), new Insets(10, 6, 10, 6), new Insets(12, 8, 12, 8)}, new Object[]{"ComboBoxUI.uneditable", new Insets(6, 5, 6, 5), new Insets(8, 6, 8, 6), new Insets(10, 8, 10, 8)}, new Object[]{"LabelUI", new Insets(8, 8, 8, 8), new Insets(8, 8, 8, 8), new Insets(8, 8, 8, 8)}, new Object[]{"ListUI", new Insets(5, 5, 5, 5), new Insets(6, 6, 6, 6), new Insets(6, 6, 6, 6)}, new Object[]{"PanelUI", new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0)}, new Object[]{"ProgressBarUI", new Insets(8, 8, 8, 8), new Insets(10, 10, 10, 10), new Insets(12, 12, 12, 12)}, new Object[]{"RadioButtonUI", new Insets(5, 5, 5, 5), new Insets(6, 6, 6, 6), new Insets(6, 6, 6, 6)}, new Object[]{"ScrollPaneUI", new Insets(6, 8, 6, 8), new Insets(6, 8, 6, 8), new Insets(8, 10, 8, 10)}, new Object[]{"SeparatorUI", new Insets(8, 8, 8, 8), new Insets(10, 10, 10, 10), new Insets(12, 12, 12, 12)}, new Object[]{"SliderUI.horizontal", new Insets(8, 8, 8, 8), new Insets(10, 10, 10, 10), new Insets(12, 12, 12, 12)}, new Object[]{"SliderUI.vertical", new Insets(8, 8, 8, 8), new Insets(10, 10, 10, 10), new Insets(12, 12, 12, 12)}, new Object[]{"SpinnerUI", new Insets(6, 8, 6, 8), new Insets(6, 8, 6, 8), new Insets(8, 10, 8, 10)}, new Object[]{"SplitPaneUI", new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0)}, new Object[]{"TabbedPaneUI", new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0)}, new Object[]{"TableUI", new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0)}, new Object[]{"TextAreaUI", "EditorPaneUI", "TextPaneUI", new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0)}, new Object[]{"TextFieldUI", "FormattedTextFieldUI", "PasswordFieldUI", new Insets(6, 8, 6, 8), new Insets(6, 8, 6, 8), new Insets(8, 10, 8, 10)}, new Object[]{"TreeUI", new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0), new Insets(0, 0, 0, 0)}};
        unrelatedGapDefinitions = new Object[]{new Object[]{"ButtonUI.help", new Insets(24, 24, 24, 24), new Insets(24, 24, 24, 24), new Insets(24, 24, 24, 24)}, new Object[]{"default", new Insets(10, 10, 10, 10), new Insets(12, 12, 12, 12), new Insets(14, 14, 14, 14)}};
        indentGapDefinitions = new Object[]{new Object[]{"CheckBoxUI", "RadioButtonUI", new Insets(16, 24, 16, 24), new Insets(20, 24, 20, 24), new Insets(24, 24, 24, 24)}, new Object[]{"default", new Insets(16, 16, 16, 16), new Insets(20, 20, 20, 20), new Insets(24, 24, 24, 24)}};
        visualMarginDefinitions = new Object[]{new Object[]{"ButtonUI", "ButtonUI.text", "ToggleButtonUI", "ToggleButtonUI.text", new Insets(5, 3, 3, 3)}, new Object[]{"ButtonUI.icon", "ToggleButtonUI.icon", new Insets(5, 2, 3, 2)}, new Object[]{"ButtonUI.toolbar", "ToggleButtonUI.toolbar", new Insets(0, 0, 0, 0)}, new Object[]{"CheckBoxUI", new Insets(4, 4, 3, 3)}, new Object[]{"ComboBoxUI", new Insets(2, 3, 4, 3)}, new Object[]{"DesktopPaneUI", new Insets(0, 0, 0, 0)}, new Object[]{"EditorPaneUI", "TextAreaUI", "TextPaneUI", new Insets(0, 0, 0, 0)}, new Object[]{"FormattedTextFieldUI", "PasswordFieldUI", "TextFieldUI", new Insets(0, 0, 0, 0)}, new Object[]{"LabelUI", new Insets(0, 0, 0, 0)}, new Object[]{"ListUI", new Insets(0, 0, 0, 0)}, new Object[]{"PanelUI", new Insets(0, 0, 0, 0)}, new Object[]{"ProgressBarUI", "ProgressBarUI.horizontal", new Insets(0, 2, 4, 2)}, new Object[]{"ProgressBarUI.vertical", new Insets(2, 0, 2, 4)}, new Object[]{"RadioButtonUI", new Insets(4, 4, 3, 3)}, new Object[]{"ScrollBarUI", new Insets(0, 0, 0, 0)}, new Object[]{"ScrollPaneUI", new Insets(0, 0, 0, 0)}, new Object[]{"SpinnerUI", new Insets(0, 0, 0, 0)}, new Object[]{"SeparatorUI", new Insets(0, 0, 0, 0)}, new Object[]{"SplitPaneUI", new Insets(0, 0, 0, 0)}, new Object[]{"SliderUI", "SliderUI.horizontal", new Insets(3, 6, 3, 6)}, new Object[]{"SliderUI.vertical", new Insets(6, 3, 6, 3)}, new Object[]{"TabbedPaneUI", "TabbedPaneUI.top", new Insets(5, 7, 10, 7)}, new Object[]{"TabbedPaneUI.bottom", new Insets(4, 7, 5, 7)}, new Object[]{"TabbedPaneUI.left", new Insets(4, 6, 10, 7)}, new Object[]{"TabbedPaneUI.right", new Insets(4, 7, 10, 6)}, new Object[]{"TableUI", new Insets(0, 0, 0, 0)}, new Object[]{"TreeUI", new Insets(0, 0, 0, 0)}, new Object[]{"default", new Insets(0, 0, 0, 0)}};
        RELATED_GAPS = createInsetsMap(relatedGapDefinitions);
        UNRELATED_GAPS = createInsetsMap(unrelatedGapDefinitions);
        CONTAINER_GAPS = createInsetsMap(containerGapDefinitions);
        INDENT_GAPS = createInsetsMap(indentGapDefinitions);
        VISUAL_MARGINS = createInsetsMap(visualMarginDefinitions);
    }

    private static Map createInsetsMap(Object[][] objArr) {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            int i3 = 0;
            while (i3 < objArr[i2].length && (objArr[i2][i3] instanceof String)) {
                i3++;
            }
            Insets[] insetsArr = new Insets[objArr[i2].length - i3];
            for (int i4 = i3; i4 < objArr[i2].length; i4++) {
                insetsArr[i4 - i3] = (Insets) objArr[i2][i4];
            }
            for (int i5 = 0; i5 < i3; i5++) {
                String str = (String) objArr[i2][i5];
                int indexOf = str.indexOf(46);
                if (indexOf == -1) {
                    ComponentInsets componentInsets = (ComponentInsets) hashMap.get(str);
                    if (componentInsets == null) {
                        new ComponentInsets(insetsArr);
                        hashMap.put(str, new ComponentInsets(insetsArr));
                    } else if (!$assertionsDisabled && componentInsets.getInsets() != null) {
                        throw new AssertionError();
                    } else {
                        componentInsets.setInsets(insetsArr);
                    }
                } else {
                    String substring = str.substring(indexOf + 1);
                    String substring2 = str.substring(0, indexOf);
                    ComponentInsets componentInsets2 = (ComponentInsets) hashMap.get(substring2);
                    if (componentInsets2 == null) {
                        componentInsets2 = new ComponentInsets();
                        hashMap.put(substring2, componentInsets2);
                    }
                    componentInsets2.addSubinsets(substring, new ComponentInsets(insetsArr));
                }
            }
        }
        return hashMap;
    }

    public static void main(String[] strArr) {
        JComponent jButton = new JButton();
        jButton.putClientProperty("JButton.buttonType", "metal");
        JComponent jButton2 = new JButton();
        AquaLayoutStyle aquaLayoutStyle = new AquaLayoutStyle();
        System.err.println(new StringBuffer().append("gap= ").append(aquaLayoutStyle.getPreferredGap(jButton, jButton2, 0, 3, null)).toString());
        jButton.putClientProperty("JButton.buttonType", "square");
        jButton2.putClientProperty("JButton.buttonType", "square");
        System.err.println(new StringBuffer().append("gap= ").append(aquaLayoutStyle.getPreferredGap(jButton, jButton2, 0, 3, null)).toString());
    }

    @Override // org.jdesktop.layout.LayoutStyle
    public int getPreferredGap(JComponent jComponent, JComponent jComponent2, int i2, int i3, Container container) {
        int max;
        int buttonChildIndent;
        super.getPreferredGap(jComponent, jComponent2, i2, i3, container);
        if (i2 == 3) {
            if ((i3 == 3 || i3 == 7) && (buttonChildIndent = getButtonChildIndent(jComponent, i3)) != 0) {
                return buttonChildIndent;
            }
            Insets preferredGap = getPreferredGap(jComponent, i2, getSizeStyle(jComponent));
            switch (i3) {
                case 1:
                    max = preferredGap.bottom;
                    break;
                case 2:
                case 4:
                case 6:
                case 7:
                default:
                    max = preferredGap.right;
                    break;
                case 3:
                    max = preferredGap.left;
                    break;
                case 5:
                    max = preferredGap.top;
                    break;
            }
            Insets visualMargin = getVisualMargin(jComponent2);
            switch (i3) {
                case 1:
                    max -= visualMargin.bottom;
                    break;
                case 3:
                    max -= visualMargin.left;
                    break;
                case 5:
                    max -= visualMargin.top;
                    break;
                case 7:
                    max -= visualMargin.right;
                    break;
            }
        } else {
            int min = Math.min(getSizeStyle(jComponent), getSizeStyle(jComponent2));
            Insets preferredGap2 = getPreferredGap(jComponent, i2, min);
            Insets preferredGap3 = getPreferredGap(jComponent2, i2, min);
            switch (i3) {
                case 1:
                    max = Math.max(preferredGap2.top, preferredGap3.bottom);
                    break;
                case 2:
                case 4:
                case 6:
                case 7:
                default:
                    max = Math.max(preferredGap2.left, preferredGap3.right);
                    break;
                case 3:
                    max = Math.max(preferredGap2.right, preferredGap3.left);
                    break;
                case 5:
                    max = Math.max(preferredGap2.bottom, preferredGap3.top);
                    break;
            }
            Insets visualMargin2 = getVisualMargin(jComponent);
            Insets visualMargin3 = getVisualMargin(jComponent2);
            switch (i3) {
                case 1:
                    max -= visualMargin2.top + visualMargin3.bottom;
                    break;
                case 3:
                    max -= visualMargin2.right + visualMargin3.left;
                    break;
                case 5:
                    max -= visualMargin2.bottom + visualMargin3.top;
                    break;
                case 7:
                    max -= visualMargin2.left + visualMargin3.right;
                    break;
            }
        }
        return Math.max(0, max);
    }

    private Insets getPreferredGap(JComponent jComponent, int i2, int i3) {
        Map map;
        switch (i2) {
            case 0:
                map = RELATED_GAPS;
                break;
            case 1:
            case 2:
            default:
                map = UNRELATED_GAPS;
                break;
            case 3:
                map = INDENT_GAPS;
                break;
        }
        String uIClassID = jComponent.getUIClassID();
        String str = null;
        if (uIClassID == "ButtonUI" || uIClassID == "ToggleButtonUI") {
            str = (String) jComponent.getClientProperty("JButton.buttonType");
        } else if (uIClassID == "ProgressBarUI") {
            str = ((JProgressBar) jComponent).getOrientation() == 0 ? "horizontal" : "vertical";
        } else if (uIClassID == "SliderUI") {
            str = ((JSlider) jComponent).getOrientation() == 0 ? "horizontal" : "vertical";
        } else if (uIClassID == "TabbedPaneUI") {
            switch (((JTabbedPane) jComponent).getTabPlacement()) {
                case 1:
                    str = "top";
                    break;
                case 2:
                    str = "left";
                    break;
                case 3:
                    str = "bottom";
                    break;
                case 4:
                    str = "right";
                    break;
            }
        } else if (uIClassID == "ComboBoxUI") {
            str = ((JComboBox) jComponent).isEditable() ? "editable" : "uneditable";
        }
        return getInsets(map, uIClassID, str, i3);
    }

    @Override // org.jdesktop.layout.LayoutStyle
    public int getContainerGap(JComponent jComponent, int i2, Container container) {
        int i3;
        Insets containerGap = getContainerGap(container, Math.min(getSizeStyle(jComponent), getSizeStyle(container)));
        switch (i2) {
            case 1:
                i3 = containerGap.top;
                break;
            case 2:
            case 4:
            case 6:
            case 7:
            default:
                i3 = containerGap.left;
                break;
            case 3:
                i3 = containerGap.right;
                break;
            case 5:
                i3 = containerGap.bottom;
                break;
        }
        Insets visualMargin = getVisualMargin(jComponent);
        switch (i2) {
            case 1:
                i3 -= visualMargin.top;
                break;
            case 3:
                i3 -= visualMargin.left;
                break;
            case 5:
                i3 -= visualMargin.bottom;
                if (jComponent instanceof JRadioButton) {
                    i3--;
                    break;
                }
                break;
            case 7:
                i3 -= visualMargin.right;
                break;
        }
        return Math.max(0, i3);
    }

    private Insets getContainerGap(Container container, int i2) {
        String str;
        if (container instanceof JComponent) {
            str = ((JComponent) container).getUIClassID();
        } else if (container instanceof Dialog) {
            str = "Dialog";
        } else if (container instanceof Frame) {
            str = "Frame";
        } else if (container instanceof Applet) {
            str = "Applet";
        } else if (container instanceof Panel) {
            str = "Panel";
        } else {
            str = "default";
        }
        return getInsets(CONTAINER_GAPS, str, null, i2);
    }

    private Insets getInsets(Map map, String str, String str2, int i2) {
        ComponentInsets subinsets;
        if (str == null) {
            str = "default";
        }
        ComponentInsets componentInsets = (ComponentInsets) map.get(str);
        if (componentInsets == null) {
            componentInsets = (ComponentInsets) map.get("default");
            if (componentInsets == null) {
                return EMPTY_INSETS;
            }
        } else if (str2 != null && (subinsets = componentInsets.getSubinsets(str2)) != null) {
            componentInsets = subinsets;
        }
        return componentInsets.getInsets(i2);
    }

    private Insets getVisualMargin(JComponent jComponent) {
        String uIClassID = jComponent.getUIClassID();
        String str = null;
        if (uIClassID == "ButtonUI" || uIClassID == "ToggleButtonUI") {
            str = (String) jComponent.getClientProperty("JButton.buttonType");
        } else if (uIClassID == "ProgressBarUI") {
            str = ((JProgressBar) jComponent).getOrientation() == 0 ? "horizontal" : "vertical";
        } else if (uIClassID == "SliderUI") {
            str = ((JSlider) jComponent).getOrientation() == 0 ? "horizontal" : "vertical";
        } else if (uIClassID == "TabbedPaneUI") {
            switch (((JTabbedPane) jComponent).getTabPlacement()) {
                case 1:
                    str = "top";
                    break;
                case 2:
                    str = "left";
                    break;
                case 3:
                    str = "bottom";
                    break;
                case 4:
                    str = "right";
                    break;
            }
        }
        Insets insets = getInsets(VISUAL_MARGINS, uIClassID, str, 0);
        if (uIClassID == "RadioButtonUI" || uIClassID == "CheckBoxUI") {
            switch (((AbstractButton) jComponent).getHorizontalTextPosition()) {
                case 0:
                    insets = new Insets(insets.top, insets.right, insets.bottom, insets.right);
                    break;
                case 4:
                    insets = new Insets(insets.top, insets.right, insets.bottom, insets.left);
                    break;
                default:
                    insets = new Insets(insets.top, insets.left, insets.bottom, insets.right);
                    break;
            }
            if (jComponent.getBorder() instanceof EmptyBorder) {
                insets.left -= 2;
                insets.right -= 2;
                insets.top -= 2;
                insets.bottom -= 2;
            }
        }
        return insets;
    }

    private int getSizeStyle(Component component) {
        Font font;
        int size;
        if (component == null || (font = component.getFont()) == null || (size = font.getSize()) >= 13) {
            return 2;
        }
        return size > 9 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/AquaLayoutStyle$ComponentInsets.class */
    public static class ComponentInsets {
        private Map children;
        private Insets[] insets;

        public ComponentInsets() {
        }

        public ComponentInsets(Insets[] insetsArr) {
            this.insets = insetsArr;
        }

        public void setInsets(Insets[] insetsArr) {
            this.insets = insetsArr;
        }

        public Insets[] getInsets() {
            return this.insets;
        }

        public Insets getInsets(int i2) {
            if (this.insets == null) {
                return AquaLayoutStyle.EMPTY_INSETS;
            }
            return this.insets[i2];
        }

        void addSubinsets(String str, ComponentInsets componentInsets) {
            if (this.children == null) {
                this.children = new HashMap(5);
            }
            this.children.put(str, componentInsets);
        }

        ComponentInsets getSubinsets(String str) {
            if (this.children == null) {
                return null;
            }
            return (ComponentInsets) this.children.get(str);
        }
    }
}
