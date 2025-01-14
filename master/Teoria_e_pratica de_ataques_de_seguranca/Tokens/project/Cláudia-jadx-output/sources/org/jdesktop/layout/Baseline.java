package org.jdesktop.layout;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListCellRenderer;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.text.JTextComponent;
import javax.swing.text.View;
/* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/Baseline.class */
public class Baseline {
    static final int BRB_NONE = 0;
    public static final int BRB_CONSTANT_ASCENT = 1;
    public static final int BRB_CONSTANT_DESCENT = 2;
    public static final int BRB_CENTER_OFFSET = 3;
    public static final int BRB_OTHER = 4;
    private static final Rectangle viewRect;
    private static final Rectangle textRect;
    private static final Rectangle iconRect;
    private static final int EDGE_SPACING = 2;
    private static final int TEXT_SPACING = 2;
    private static final Insets EMPTY_INSETS;
    private static JLabel TABLE_LABEL;
    private static JLabel LIST_LABEL;
    private static JLabel TREE_LABEL;
    private static Class CLASSIC_WINDOWS;
    private static boolean checkedForClassic;
    private static Class WINDOWS_CLASS;
    private static boolean checkedForWindows;
    private static boolean inSandbox;
    private static boolean checkedForOcean;
    private static boolean usingOcean;
    private static final Map BASELINE_MAP;
    private static final Map BRB_I_MAP;
    private static final Method COMPONENT_BASELINE_METHOD;
    private static final Method COMPONENT_BRB_METHOD;
    private static final Object ENUM_BRB_CENTER_OFFSET;
    private static final Object ENUM_BRB_CONSTANT_ASCENT;
    private static final Object ENUM_BRB_CONSTANT_DESCENT;
    private static final Object ENUM_BRB_OTHER;
    private static JList brbList;
    private static ListCellRenderer brbListCellRenderer;
    static Class class$java$awt$Component;
    static final boolean $assertionsDisabled;
    static Class class$org$jdesktop$layout$Baseline;
    static Class class$javax$swing$plaf$metal$MetalLookAndFeel;

    static {
        Class cls;
        Class cls2;
        Class cls3;
        if (class$org$jdesktop$layout$Baseline == null) {
            cls = class$("org.jdesktop.layout.Baseline");
            class$org$jdesktop$layout$Baseline = cls;
        } else {
            cls = class$org$jdesktop$layout$Baseline;
        }
        $assertionsDisabled = !cls.desiredAssertionStatus();
        viewRect = new Rectangle();
        textRect = new Rectangle();
        iconRect = new Rectangle();
        EMPTY_INSETS = new Insets(0, 0, 0, 0);
        BASELINE_MAP = Collections.synchronizedMap(new HashMap(1));
        BRB_I_MAP = Collections.synchronizedMap(new HashMap(1));
        Method method = null;
        Method method2 = null;
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        try {
            if (class$java$awt$Component == null) {
                cls2 = class$("java.awt.Component");
                class$java$awt$Component = cls2;
            } else {
                cls2 = class$java$awt$Component;
            }
            method = cls2.getMethod("getBaseline", Integer.TYPE, Integer.TYPE);
            if (class$java$awt$Component == null) {
                cls3 = class$("java.awt.Component");
                class$java$awt$Component = cls3;
            } else {
                cls3 = class$java$awt$Component;
            }
            method2 = cls3.getMethod("getBaselineResizeBehavior", new Class[0]);
            Class<?> cls4 = Class.forName("java.awt.Component$BaselineResizeBehavior");
            obj = getFieldValue(cls4, "CENTER_OFFSET");
            obj2 = getFieldValue(cls4, "CONSTANT_ASCENT");
            obj3 = getFieldValue(cls4, "CONSTANT_DESCENT");
            obj4 = getFieldValue(cls4, "OTHER");
        } catch (ClassNotFoundException e2) {
        } catch (IllegalAccessException e3) {
        } catch (NoSuchFieldException e4) {
        } catch (NoSuchMethodException e5) {
        }
        if (method == null || method2 == null || obj == null || obj3 == null || obj2 == null || obj4 == null) {
            method2 = null;
            method = null;
            obj4 = null;
            obj3 = null;
            obj2 = null;
            obj = null;
        }
        COMPONENT_BASELINE_METHOD = method;
        COMPONENT_BRB_METHOD = method2;
        ENUM_BRB_CENTER_OFFSET = obj;
        ENUM_BRB_CONSTANT_ASCENT = obj2;
        ENUM_BRB_CONSTANT_DESCENT = obj3;
        ENUM_BRB_OTHER = obj4;
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private static Object getFieldValue(Class cls, String str) throws IllegalAccessException, NoSuchFieldException {
        return cls.getField(str).get(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getBaselineResizeBehavior(Component component) {
        if (component instanceof JComponent) {
            return getBaselineResizeBehavior((JComponent) component);
        }
        return 4;
    }

    public static int getBaselineResizeBehavior(JComponent jComponent) {
        Method bRBIMethod = getBRBIMethod(jComponent);
        if (bRBIMethod != null) {
            return invokeBRBIMethod(bRBIMethod, jComponent);
        }
        if (COMPONENT_BRB_METHOD != null) {
            return getBaselineResizeBehaviorUsingMustang(jComponent);
        }
        String uIClassID = jComponent.getUIClassID();
        if (uIClassID == "ButtonUI" || uIClassID == "CheckBoxUI" || uIClassID == "RadioButtonUI" || uIClassID == "ToggleButtonUI") {
            return getButtonBaselineResizeBehavior((AbstractButton) jComponent);
        }
        if (uIClassID == "ComboBoxUI") {
            return getComboBoxBaselineResizeBehavior((JComboBox) jComponent);
        }
        if (uIClassID == "TextAreaUI") {
            return getTextAreaBaselineResizeBehavior((JTextArea) jComponent);
        }
        if (uIClassID == "TextFieldUI" || uIClassID == "FormattedTextFieldUI" || uIClassID == "PasswordFieldUI") {
            return getSingleLineTextBaselineResizeBehavior((JTextField) jComponent);
        }
        if (uIClassID == "LabelUI") {
            return getLabelBaselineResizeBehavior((JLabel) jComponent);
        }
        if (uIClassID == "ListUI") {
            return getListBaselineResizeBehavior((JList) jComponent);
        }
        if (uIClassID == "PanelUI") {
            return getPanelBaselineResizeBehavior((JPanel) jComponent);
        }
        if (uIClassID == "ProgressBarUI") {
            return getProgressBarBaselineResizeBehavior((JProgressBar) jComponent);
        }
        if (uIClassID == "SliderUI") {
            return getSliderBaselineResizeBehavior((JSlider) jComponent);
        }
        if (uIClassID == "SpinnerUI") {
            return getSpinnerBaselineResizeBehavior((JSpinner) jComponent);
        }
        if (uIClassID == "ScrollPaneUI") {
            return getScrollPaneBaselineBaselineResizeBehavior((JScrollPane) jComponent);
        }
        if (uIClassID == "TabbedPaneUI") {
            return getTabbedPaneBaselineResizeBehavior((JTabbedPane) jComponent);
        }
        if (uIClassID == "TableUI") {
            return getTableBaselineResizeBehavior((JTable) jComponent);
        }
        if (uIClassID == "TreeUI") {
            return getTreeBaselineResizeBehavior((JTree) jComponent);
        }
        return 4;
    }

    private static int getBaselineResizeBehaviorUsingMustang(JComponent jComponent) {
        try {
            Object invoke = COMPONENT_BRB_METHOD.invoke(jComponent, null);
            if (invoke == ENUM_BRB_CENTER_OFFSET) {
                return 3;
            }
            if (invoke == ENUM_BRB_CONSTANT_ASCENT) {
                return 1;
            }
            if (invoke == ENUM_BRB_CONSTANT_DESCENT) {
                return 2;
            }
            return 4;
        } catch (IllegalAccessException e2) {
            if ($assertionsDisabled) {
                return 4;
            }
            throw new AssertionError();
        } catch (IllegalArgumentException e3) {
            if ($assertionsDisabled) {
                return 4;
            }
            throw new AssertionError();
        } catch (InvocationTargetException e4) {
            if ($assertionsDisabled) {
                return 4;
            }
            throw new AssertionError();
        }
    }

    private static Method getBRBIMethod(Component component) {
        Class<?> cls = component.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 != null) {
                if (BRB_I_MAP.containsKey(cls2)) {
                    return (Method) BRB_I_MAP.get(cls2);
                }
                cls = cls2.getSuperclass();
            } else {
                Class<?> cls3 = component.getClass();
                Method[] methods = cls3.getMethods();
                for (int length = methods.length - 1; length >= 0; length--) {
                    Method method = methods[length];
                    if ("getBaselineResizeBehaviorInt".equals(method.getName()) && method.getParameterTypes().length == 0) {
                        BRB_I_MAP.put(cls3, method);
                        return method;
                    }
                }
                BRB_I_MAP.put(cls3, null);
                return null;
            }
        }
    }

    private static int invokeBRBIMethod(Method method, Component component) {
        int i2 = 4;
        try {
            i2 = ((Integer) method.invoke(component, null)).intValue();
        } catch (IllegalAccessException e2) {
        } catch (IllegalArgumentException e3) {
        } catch (InvocationTargetException e4) {
        }
        return i2;
    }

    private static int getTreeBaselineResizeBehavior(JTree jTree) {
        return 1;
    }

    private static int getSingleLineTextBaselineResizeBehavior(JTextField jTextField) {
        return 3;
    }

    private static int getTextAreaBaselineResizeBehavior(JTextArea jTextArea) {
        return 1;
    }

    private static int getTableBaselineResizeBehavior(JTable jTable) {
        return 1;
    }

    private static int getTabbedPaneBaselineResizeBehavior(JTabbedPane jTabbedPane) {
        switch (jTabbedPane.getTabPlacement()) {
            case 1:
            case 2:
            case 4:
                return 1;
            case 3:
                return 2;
            default:
                return 4;
        }
    }

    private static int getSpinnerBaselineResizeBehavior(JSpinner jSpinner) {
        return getBaselineResizeBehavior(jSpinner.getEditor());
    }

    private static int getSliderBaselineResizeBehavior(JSlider jSlider) {
        return 4;
    }

    private static int getScrollPaneBaselineBaselineResizeBehavior(JScrollPane jScrollPane) {
        return 1;
    }

    private static int getProgressBarBaselineResizeBehavior(JProgressBar jProgressBar) {
        if (jProgressBar.isStringPainted() && jProgressBar.getOrientation() == 0) {
            return 3;
        }
        return 4;
    }

    private static int getPanelBaselineResizeBehavior(JPanel jPanel) {
        TitledBorder border = jPanel.getBorder();
        if (border instanceof TitledBorder) {
            switch (border.getTitlePosition()) {
                case 0:
                case 1:
                case 2:
                case 3:
                    return 1;
                case 4:
                case 5:
                case 6:
                    return 2;
                default:
                    return 4;
            }
        }
        return 4;
    }

    private static int getListBaselineResizeBehavior(JList jList) {
        return 1;
    }

    private static int getLabelBaselineResizeBehavior(JLabel jLabel) {
        if (jLabel.getClientProperty("html") != null) {
            return 4;
        }
        switch (jLabel.getVerticalAlignment()) {
            case 0:
                return 3;
            case 1:
                return 1;
            case 2:
            default:
                return 4;
            case 3:
                return 2;
        }
    }

    private static int getButtonBaselineResizeBehavior(AbstractButton abstractButton) {
        if (abstractButton.getClientProperty("html") != null) {
            return 4;
        }
        switch (abstractButton.getVerticalAlignment()) {
            case 0:
                return 3;
            case 1:
                return 1;
            case 2:
            default:
                return 4;
            case 3:
                return 2;
        }
    }

    private static int getComboBoxBaselineResizeBehavior(JComboBox jComboBox) {
        if (jComboBox.isEditable()) {
            return getBaselineResizeBehavior(jComboBox.getEditor().getEditorComponent());
        }
        ListCellRenderer renderer = jComboBox.getRenderer();
        if (renderer == null) {
            if (brbListCellRenderer == null) {
                brbListCellRenderer = new DefaultListCellRenderer();
            }
            renderer = brbListCellRenderer;
        }
        Object obj = null;
        Object prototypeDisplayValue = jComboBox.getPrototypeDisplayValue();
        if (prototypeDisplayValue != null) {
            obj = prototypeDisplayValue;
        } else if (jComboBox.getModel().getSize() > 0) {
            obj = jComboBox.getModel().getElementAt(0);
        }
        if (obj != null) {
            if (brbList == null) {
                brbList = new JList();
            }
            return getBaselineResizeBehavior(renderer.getListCellRendererComponent(brbList, obj, -1, false, false));
        }
        return 4;
    }

    public static int getBaseline(JComponent jComponent) {
        Dimension preferredSize = jComponent.getPreferredSize();
        return getBaseline(jComponent, preferredSize.width, preferredSize.height);
    }

    private static Method getBaselineMethod(JComponent jComponent) {
        if (COMPONENT_BASELINE_METHOD != null) {
            return COMPONENT_BASELINE_METHOD;
        }
        Class<?> cls = jComponent.getClass();
        while (true) {
            Class<?> cls2 = cls;
            if (cls2 != null) {
                if (BASELINE_MAP.containsKey(cls2)) {
                    return (Method) BASELINE_MAP.get(cls2);
                }
                cls = cls2.getSuperclass();
            } else {
                Class<?> cls3 = jComponent.getClass();
                Method[] methods = cls3.getMethods();
                for (int length = methods.length - 1; length >= 0; length--) {
                    Method method = methods[length];
                    if ("getBaseline".equals(method.getName())) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 2 && parameterTypes[0] == Integer.TYPE && parameterTypes[1] == Integer.TYPE) {
                            BASELINE_MAP.put(cls3, method);
                            return method;
                        }
                    }
                }
                BASELINE_MAP.put(cls3, null);
                return null;
            }
        }
    }

    private static int invokeBaseline(Method method, JComponent jComponent, int i2, int i3) {
        int i4 = -1;
        try {
            i4 = ((Integer) method.invoke(jComponent, new Integer(i2), new Integer(i3))).intValue();
        } catch (IllegalAccessException e2) {
        } catch (IllegalArgumentException e3) {
        } catch (InvocationTargetException e4) {
        }
        return i4;
    }

    private static boolean isKnownLookAndFeel() {
        LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
        String id = lookAndFeel.getID();
        return id == "GTK" || id == "Aqua" || isMetal(lookAndFeel) || isWindows(lookAndFeel);
    }

    public static int getBaseline(JComponent jComponent, int i2, int i3) {
        Method baselineMethod = getBaselineMethod(jComponent);
        if (baselineMethod != null) {
            return invokeBaseline(baselineMethod, jComponent, i2, i3);
        }
        Object obj = UIManager.get("Baseline.instance");
        if (obj != null && (obj instanceof Baseline)) {
            return ((Baseline) obj).getComponentBaseline(jComponent, i2, i3);
        }
        if (!isKnownLookAndFeel()) {
            return -1;
        }
        String uIClassID = jComponent.getUIClassID();
        int i4 = -1;
        if (uIClassID == "ButtonUI" || uIClassID == "CheckBoxUI" || uIClassID == "RadioButtonUI" || uIClassID == "ToggleButtonUI") {
            i4 = getButtonBaseline((AbstractButton) jComponent, i3);
        } else if (uIClassID == "ComboBoxUI") {
            return getComboBoxBaseline((JComboBox) jComponent, i3);
        } else {
            if (uIClassID == "TextAreaUI") {
                return getTextAreaBaseline((JTextArea) jComponent, i3);
            }
            if (uIClassID == "FormattedTextFieldUI" || uIClassID == "PasswordFieldUI" || uIClassID == "TextFieldUI") {
                i4 = getSingleLineTextBaseline((JTextComponent) jComponent, i3);
            } else if (uIClassID == "LabelUI") {
                i4 = getLabelBaseline((JLabel) jComponent, i3);
            } else if (uIClassID == "ListUI") {
                i4 = getListBaseline((JList) jComponent, i3);
            } else if (uIClassID == "PanelUI") {
                i4 = getPanelBaseline((JPanel) jComponent, i3);
            } else if (uIClassID == "ProgressBarUI") {
                i4 = getProgressBarBaseline((JProgressBar) jComponent, i3);
            } else if (uIClassID == "SliderUI") {
                i4 = getSliderBaseline((JSlider) jComponent, i3);
            } else if (uIClassID == "SpinnerUI") {
                i4 = getSpinnerBaseline((JSpinner) jComponent, i3);
            } else if (uIClassID == "ScrollPaneUI") {
                i4 = getScrollPaneBaseline((JScrollPane) jComponent, i3);
            } else if (uIClassID == "TabbedPaneUI") {
                i4 = getTabbedPaneBaseline((JTabbedPane) jComponent, i3);
            } else if (uIClassID == "TableUI") {
                i4 = getTableBaseline((JTable) jComponent, i3);
            } else if (uIClassID == "TreeUI") {
                i4 = getTreeBaseline((JTree) jComponent, i3);
            }
        }
        return Math.max(i4, -1);
    }

    private static Insets rotateInsets(Insets insets, int i2) {
        switch (i2) {
            case 2:
                return new Insets(insets.left, insets.top, insets.right, insets.bottom);
            case 3:
                return new Insets(insets.bottom, insets.left, insets.top, insets.right);
            case 4:
                return new Insets(insets.left, insets.bottom, insets.right, insets.top);
            default:
                return new Insets(insets.top, insets.left, insets.bottom, insets.right);
        }
    }

    private static int getMaxTabHeight(JTabbedPane jTabbedPane) {
        int height = jTabbedPane.getFontMetrics(jTabbedPane.getFont()).getHeight();
        int i2 = height;
        boolean z = false;
        for (int tabCount = jTabbedPane.getTabCount() - 1; tabCount >= 0; tabCount--) {
            Icon iconAt = jTabbedPane.getIconAt(tabCount);
            if (iconAt != null) {
                int iconHeight = iconAt.getIconHeight();
                i2 = Math.max(i2, iconHeight);
                if (iconHeight > height) {
                    z = true;
                }
            }
        }
        Insets insets = UIManager.getInsets("TabbedPane.tabInsets");
        int i3 = i2 + 2;
        if (!isMetal() || !z) {
            i3 += insets.top + insets.bottom;
        }
        return i3;
    }

    private static int getTabbedPaneBaseline(JTabbedPane jTabbedPane, int i2) {
        if (jTabbedPane.getTabCount() > 0) {
            if (isAqua()) {
                return getAquaTabbedPaneBaseline(jTabbedPane, i2);
            }
            Insets insets = jTabbedPane.getInsets();
            UIManager.getInsets("TabbedPane.contentBorderInsets");
            Insets rotateInsets = rotateInsets(UIManager.getInsets("TabbedPane.tabAreaInsets"), jTabbedPane.getTabPlacement());
            FontMetrics fontMetrics = jTabbedPane.getFontMetrics(jTabbedPane.getFont());
            int maxTabHeight = getMaxTabHeight(jTabbedPane);
            iconRect.setBounds(0, 0, 0, 0);
            textRect.setBounds(0, 0, 0, 0);
            viewRect.setBounds(0, 0, 32767, maxTabHeight);
            SwingUtilities.layoutCompoundLabel(jTabbedPane, fontMetrics, "A", (Icon) null, 0, 0, 0, 11, viewRect, iconRect, textRect, 0);
            int ascent = textRect.y + fontMetrics.getAscent();
            switch (jTabbedPane.getTabPlacement()) {
                case 1:
                    int i3 = ascent + insets.top + rotateInsets.top;
                    if (isWindows()) {
                        if (jTabbedPane.getTabCount() > 1) {
                            i3++;
                        } else {
                            i3--;
                        }
                    }
                    return i3;
                case 2:
                case 4:
                    if (isAqua()) {
                        return -1;
                    }
                    int i4 = ascent + insets.top + rotateInsets.top;
                    if (isWindows()) {
                        i4 += maxTabHeight % 2;
                    }
                    return i4;
                case 3:
                    int height = (((jTabbedPane.getHeight() - insets.bottom) - rotateInsets.bottom) - maxTabHeight) + ascent;
                    if (isWindows()) {
                        if (jTabbedPane.getTabCount() > 1) {
                            height--;
                        } else {
                            height++;
                        }
                    }
                    return height;
                default:
                    return -1;
            }
        }
        return -1;
    }

    private static int getAquaTabbedPaneBaseline(JTabbedPane jTabbedPane, int i2) {
        int i3;
        FontMetrics fontMetrics = jTabbedPane.getFontMetrics(jTabbedPane.getFont());
        int ascent = fontMetrics.getAscent();
        switch (jTabbedPane.getTabPlacement()) {
            case 1:
                int i4 = 5;
                if (jTabbedPane.getFont().getSize() > 12) {
                    i4 = 6;
                }
                return ((i4 + ((20 - fontMetrics.getHeight()) / 2)) + ascent) - 1;
            case 2:
            case 4:
                return -1;
            case 3:
                if (jTabbedPane.getFont().getSize() > 12) {
                    i3 = 6;
                } else {
                    i3 = 4;
                }
                return (i2 - (20 - (((20 - fontMetrics.getHeight()) / 2) + ascent))) - i3;
            default:
                return -1;
        }
    }

    private static int getSliderBaseline(JSlider jSlider, int i2) {
        Integer minSliderValue;
        double intValue;
        int round;
        if (jSlider.getPaintLabels() && !isGTK()) {
            boolean isAqua = isAqua();
            FontMetrics fontMetrics = jSlider.getFontMetrics(jSlider.getFont());
            Insets insets = jSlider.getInsets();
            Insets insets2 = (Insets) UIManager.get("Slider.focusInsets");
            if (jSlider.getOrientation() == 0) {
                int i3 = 8;
                int i4 = (((i2 - insets.top) - insets.bottom) - insets2.top) - insets2.bottom;
                int i5 = 20;
                if (isMetal()) {
                    i3 = ((Integer) UIManager.get("Slider.majorTickLength")).intValue() + 5;
                    i5 = UIManager.getIcon("Slider.horizontalThumbIcon").getIconHeight();
                } else if (isWindows() && isXP()) {
                    i5 = 20 + 1;
                }
                int i6 = i5;
                if (isAqua || jSlider.getPaintTicks()) {
                    i6 += i3;
                }
                int ascent = insets.top + insets2.top + (((i4 - (i6 + (fontMetrics.getAscent() + fontMetrics.getDescent()))) - 1) / 2);
                if (isAqua) {
                    if (jSlider.getPaintTicks()) {
                        int i7 = i2 - jSlider.getUI().getPreferredSize(jSlider).height;
                        if (i7 > 0) {
                            ascent -= Math.min(1, i7);
                        }
                    } else {
                        ascent--;
                    }
                }
                int i8 = ascent + i5;
                int i9 = i3;
                if (!isAqua && !jSlider.getPaintTicks()) {
                    i9 = 0;
                }
                return i8 + i9 + fontMetrics.getAscent();
            }
            boolean inverted = jSlider.getInverted();
            if ((inverted ? getMinSliderValue(jSlider) : getMaxSliderValue(jSlider)) != null) {
                int i10 = 11;
                if (isMetal()) {
                    i10 = UIManager.getIcon("Slider.verticalThumbIcon").getIconHeight();
                }
                int max = Math.max(fontMetrics.getHeight() / 2, i10 / 2);
                int i11 = insets2.top + insets.top + max;
                int i12 = (((((i2 - insets2.top) - insets2.bottom) - insets.top) - insets.bottom) - max) - max;
                getMaxSliderValue(jSlider).intValue();
                int minimum = jSlider.getMinimum();
                int maximum = jSlider.getMaximum();
                double d2 = i12 / (maximum - minimum);
                int i13 = i11 + (i12 - 1);
                if (isAqua) {
                    i11 -= 3;
                    i13 += 6;
                }
                int i14 = i11;
                if (!inverted) {
                    intValue = d2 * (maximum - minSliderValue.intValue());
                } else {
                    intValue = d2 * (minSliderValue.intValue() - minimum);
                }
                if (isAqua) {
                    round = (int) (i14 + Math.floor(intValue));
                } else {
                    round = (int) (i14 + Math.round(intValue));
                }
                int min = Math.min(i13, Math.max(i11, round));
                if (isAqua) {
                    return min + fontMetrics.getAscent();
                }
                return (min - (fontMetrics.getHeight() / 2)) + fontMetrics.getAscent();
            }
            return -1;
        }
        return -1;
    }

    private static Integer getMaxSliderValue(JSlider jSlider) {
        int i2;
        Dictionary labelTable = jSlider.getLabelTable();
        if (labelTable != null) {
            Enumeration keys = labelTable.keys();
            int minimum = jSlider.getMinimum() - 1;
            while (true) {
                i2 = minimum;
                if (!keys.hasMoreElements()) {
                    break;
                }
                minimum = Math.max(i2, ((Integer) keys.nextElement()).intValue());
            }
            if (i2 == jSlider.getMinimum() - 1) {
                return null;
            }
            return new Integer(i2);
        }
        return null;
    }

    private static Integer getMinSliderValue(JSlider jSlider) {
        int i2;
        Dictionary labelTable = jSlider.getLabelTable();
        if (labelTable != null) {
            Enumeration keys = labelTable.keys();
            int maximum = jSlider.getMaximum() + 1;
            while (true) {
                i2 = maximum;
                if (!keys.hasMoreElements()) {
                    break;
                }
                maximum = Math.min(i2, ((Integer) keys.nextElement()).intValue());
            }
            if (i2 == jSlider.getMaximum() + 1) {
                return null;
            }
            return new Integer(i2);
        }
        return null;
    }

    private static int getProgressBarBaseline(JProgressBar jProgressBar, int i2) {
        int i3;
        if (jProgressBar.isStringPainted() && jProgressBar.getOrientation() == 0) {
            FontMetrics fontMetrics = jProgressBar.getFontMetrics(jProgressBar.getFont());
            Insets insets = jProgressBar.getInsets();
            int i4 = insets.top;
            if (isWindows() && isXP()) {
                if (jProgressBar.isIndeterminate()) {
                    i4 = -1;
                    i3 = i2 - 1;
                } else {
                    i4 = 0;
                    i3 = i2 - 3;
                }
            } else if (isGTK()) {
                return (((i2 - fontMetrics.getAscent()) - fontMetrics.getDescent()) / 2) + fontMetrics.getAscent();
            } else {
                if (isAqua()) {
                    if (jProgressBar.isIndeterminate()) {
                        return -1;
                    }
                    i4--;
                    i3 = i2 - (insets.top + insets.bottom);
                } else {
                    i3 = i2 - (insets.top + insets.bottom);
                }
            }
            return i4 + ((((i3 + fontMetrics.getAscent()) - fontMetrics.getLeading()) - fontMetrics.getDescent()) / 2);
        }
        return -1;
    }

    private static int getTreeBaseline(JTree jTree, int i2) {
        int rowHeight = jTree.getRowHeight();
        if (TREE_LABEL == null) {
            TREE_LABEL = new JLabel("X");
            TREE_LABEL.setIcon(UIManager.getIcon("Tree.closedIcon"));
        }
        JLabel jLabel = TREE_LABEL;
        jLabel.setFont(jTree.getFont());
        if (rowHeight <= 0) {
            rowHeight = jLabel.getPreferredSize().height;
        }
        return getLabelBaseline(jLabel, rowHeight) + jTree.getInsets().top;
    }

    private static int getTableBaseline(JTable jTable, int i2) {
        if (TABLE_LABEL == null) {
            TABLE_LABEL = new JLabel("");
            TABLE_LABEL.setBorder(new EmptyBorder(1, 1, 1, 1));
        }
        JLabel jLabel = TABLE_LABEL;
        jLabel.setFont(jTable.getFont());
        int rowMargin = jTable.getRowMargin();
        return getLabelBaseline(jLabel, jTable.getRowHeight() - rowMargin) + (rowMargin / 2);
    }

    private static int getTextAreaBaseline(JTextArea jTextArea, int i2) {
        return jTextArea.getInsets().top + jTextArea.getFontMetrics(jTextArea.getFont()).getAscent();
    }

    private static int getListBaseline(JList jList, int i2) {
        int fixedCellHeight = jList.getFixedCellHeight();
        if (LIST_LABEL == null) {
            LIST_LABEL = new JLabel("X");
            LIST_LABEL.setBorder(new EmptyBorder(1, 1, 1, 1));
        }
        JLabel jLabel = LIST_LABEL;
        jLabel.setFont(jList.getFont());
        if (fixedCellHeight == -1) {
            fixedCellHeight = jLabel.getPreferredSize().height;
        }
        return getLabelBaseline(jLabel, fixedCellHeight) + jList.getInsets().top;
    }

    private static int getScrollPaneBaseline(JScrollPane jScrollPane, int i2) {
        int baseline;
        JComponent view = jScrollPane.getViewport().getView();
        if ((view instanceof JComponent) && (baseline = getBaseline(view)) > 0) {
            return baseline + jScrollPane.getViewport().getY();
        }
        return -1;
    }

    private static int getPanelBaseline(JPanel jPanel, int i2) {
        Insets insets;
        TitledBorder border = jPanel.getBorder();
        if (border instanceof TitledBorder) {
            TitledBorder titledBorder = border;
            if (titledBorder.getTitle() != null && !"".equals(titledBorder.getTitle())) {
                Font titleFont = titledBorder.getTitleFont();
                if (titleFont == null) {
                    titleFont = jPanel.getFont();
                    if (titleFont == null) {
                        titleFont = new Font("Dialog", 0, 12);
                    }
                }
                Border border2 = titledBorder.getBorder();
                if (border2 != null) {
                    insets = border2.getBorderInsets(jPanel);
                } else {
                    insets = EMPTY_INSETS;
                }
                FontMetrics fontMetrics = jPanel.getFontMetrics(titleFont);
                int height = fontMetrics.getHeight();
                int descent = fontMetrics.getDescent();
                int ascent = fontMetrics.getAscent();
                int i3 = i2 - 4;
                switch (border.getTitlePosition()) {
                    case 0:
                    case 2:
                        return ((2 + Math.max(0, ((ascent / 2) + 2) - 2)) - descent) + (((insets.top + ascent) + descent) / 2);
                    case 1:
                        return (2 + ((ascent + descent) + (Math.max(2, 4) - 2))) - (descent + 2);
                    case 3:
                        return 2 + insets.top + ascent + 2;
                    case 4:
                        return (2 + i3) - ((insets.bottom + descent) + 2);
                    case 5:
                        return ((2 + (i3 - (height / 2))) - descent) + (((ascent + descent) - insets.bottom) / 2);
                    case 6:
                        return 2 + (i3 - height) + ascent + 2;
                    default:
                        return -1;
                }
            }
            return -1;
        }
        return -1;
    }

    private static int getSpinnerBaseline(JSpinner jSpinner, int i2) {
        JSpinner.DefaultEditor editor = jSpinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor defaultEditor = editor;
            JFormattedTextField textField = defaultEditor.getTextField();
            Insets insets = jSpinner.getInsets();
            Insets insets2 = defaultEditor.getInsets();
            int i3 = insets.top + insets2.top;
            int i4 = i2 - ((i3 + insets.bottom) + insets2.bottom);
            if (i4 <= 0) {
                return -1;
            }
            return i3 + getSingleLineTextBaseline(textField, i4);
        }
        return jSpinner.getInsets().top + jSpinner.getFontMetrics(jSpinner.getFont()).getAscent();
    }

    private static int getLabelBaseline(JLabel jLabel, int i2) {
        Icon icon = jLabel.isEnabled() ? jLabel.getIcon() : jLabel.getDisabledIcon();
        FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
        resetRects(jLabel, i2);
        SwingUtilities.layoutCompoundLabel(jLabel, fontMetrics, "a", icon, jLabel.getVerticalAlignment(), jLabel.getHorizontalAlignment(), jLabel.getVerticalTextPosition(), jLabel.getHorizontalTextPosition(), viewRect, iconRect, textRect, jLabel.getIconTextGap());
        return textRect.y + fontMetrics.getAscent();
    }

    private static int getComboBoxBaseline(JComboBox jComboBox, int i2) {
        String property;
        ComboBoxEditor editor;
        Insets insets = jComboBox.getInsets();
        int i3 = insets.top;
        int i4 = i2 - (insets.top + insets.bottom);
        if (jComboBox.isEditable() && (editor = jComboBox.getEditor()) != null && (editor.getEditorComponent() instanceof JTextField)) {
            return i3 + getSingleLineTextBaseline(editor.getEditorComponent(), i4);
        }
        if (isMetal()) {
            if (isOceanTheme()) {
                i3 += 2;
                i4 -= 4;
            }
        } else if (isWindows() && (property = System.getProperty("os.version")) != null && Float.valueOf(property).floatValue() > 4.0d) {
            i3 += 2;
            i4 -= 4;
        }
        JLabel renderer = jComboBox.getRenderer();
        if (renderer instanceof JLabel) {
            int labelBaseline = i3 + getLabelBaseline(renderer, i4);
            if (isAqua()) {
                return labelBaseline - 1;
            }
            return labelBaseline;
        }
        return i3 + jComboBox.getFontMetrics(jComboBox.getFont()).getAscent();
    }

    private static int getSingleLineTextBaseline(JTextComponent jTextComponent, int i2) {
        View rootView = jTextComponent.getUI().getRootView(jTextComponent);
        if (rootView.getViewCount() > 0) {
            Insets insets = jTextComponent.getInsets();
            int i3 = (i2 - insets.top) - insets.bottom;
            int i4 = insets.top;
            int preferredSpan = (int) rootView.getView(0).getPreferredSpan(1);
            if (i3 != preferredSpan) {
                i4 += (i3 - preferredSpan) / 2;
            }
            return i4 + jTextComponent.getFontMetrics(jTextComponent.getFont()).getAscent();
        }
        return -1;
    }

    private static int getButtonBaseline(AbstractButton abstractButton, int i2) {
        FontMetrics fontMetrics = abstractButton.getFontMetrics(abstractButton.getFont());
        resetRects(abstractButton, i2);
        String text = abstractButton.getText();
        if (text != null && text.startsWith("<html>")) {
            return -1;
        }
        SwingUtilities.layoutCompoundLabel(abstractButton, fontMetrics, "a", abstractButton.getIcon(), abstractButton.getVerticalAlignment(), abstractButton.getHorizontalAlignment(), abstractButton.getVerticalTextPosition(), abstractButton.getHorizontalTextPosition(), viewRect, iconRect, textRect, text == null ? 0 : abstractButton.getIconTextGap());
        if (isAqua()) {
            return textRect.y + fontMetrics.getAscent() + 1;
        }
        return textRect.y + fontMetrics.getAscent();
    }

    private static void resetRects(JComponent jComponent, int i2) {
        Insets insets = jComponent.getInsets();
        viewRect.x = insets.left;
        viewRect.y = insets.top;
        viewRect.width = jComponent.getWidth() - (insets.right + viewRect.x);
        viewRect.height = i2 - (insets.bottom + viewRect.y);
        Rectangle rectangle = textRect;
        Rectangle rectangle2 = textRect;
        Rectangle rectangle3 = textRect;
        textRect.height = 0;
        rectangle3.width = 0;
        rectangle2.y = 0;
        rectangle.x = 0;
        Rectangle rectangle4 = iconRect;
        Rectangle rectangle5 = iconRect;
        Rectangle rectangle6 = iconRect;
        iconRect.height = 0;
        rectangle6.width = 0;
        rectangle5.y = 0;
        rectangle4.x = 0;
    }

    private static boolean isOceanTheme() {
        Class cls;
        if (!inSandbox) {
            try {
                if (class$javax$swing$plaf$metal$MetalLookAndFeel == null) {
                    cls = class$("javax.swing.plaf.metal.MetalLookAndFeel");
                    class$javax$swing$plaf$metal$MetalLookAndFeel = cls;
                } else {
                    cls = class$javax$swing$plaf$metal$MetalLookAndFeel;
                }
                Field declaredField = cls.getDeclaredField("currentTheme");
                declaredField.setAccessible(true);
                return "javax.swing.plaf.metal.OceanTheme".equals(declaredField.get(null).getClass().getName());
            } catch (Exception e2) {
                inSandbox = true;
            }
        }
        if (!checkedForOcean) {
            checkedForOcean = true;
            checkForOcean();
        }
        return usingOcean;
    }

    private static void checkForOcean() {
        String str;
        String str2;
        String property = System.getProperty("java.specification.version");
        int indexOf = property.indexOf(46);
        if (indexOf != -1) {
            str = property.substring(0, indexOf);
            int indexOf2 = property.indexOf(46, indexOf + 1);
            if (indexOf2 == -1) {
                str2 = property.substring(indexOf + 1);
            } else {
                str2 = property.substring(indexOf + 1, indexOf2);
            }
        } else {
            str = property;
            str2 = null;
        }
        try {
            usingOcean = Integer.parseInt(str) > 1 || (str2 != null ? Integer.parseInt(str2) : 0) > 4;
        } catch (NumberFormatException e2) {
        }
    }

    private static boolean isWindows() {
        return isWindows(UIManager.getLookAndFeel());
    }

    private static boolean isWindows(LookAndFeel lookAndFeel) {
        if (lookAndFeel.getID() == "Windows") {
            return true;
        }
        if (!checkedForWindows) {
            try {
                WINDOWS_CLASS = Class.forName("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (ClassNotFoundException e2) {
            }
            checkedForWindows = true;
        }
        return WINDOWS_CLASS != null && WINDOWS_CLASS.isInstance(lookAndFeel);
    }

    private static boolean isMetal() {
        return isMetal(UIManager.getLookAndFeel());
    }

    private static boolean isMetal(LookAndFeel lookAndFeel) {
        return lookAndFeel.getID() == "Metal" || (lookAndFeel instanceof MetalLookAndFeel);
    }

    private static boolean isGTK() {
        return UIManager.getLookAndFeel().getID() == "GTK";
    }

    private static boolean isAqua() {
        return UIManager.getLookAndFeel().getID() == "Aqua";
    }

    private static boolean isXP() {
        if (!checkedForClassic) {
            try {
                CLASSIC_WINDOWS = Class.forName("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            } catch (ClassNotFoundException e2) {
            }
            checkedForClassic = true;
        }
        if (CLASSIC_WINDOWS != null && CLASSIC_WINDOWS.isInstance(UIManager.getLookAndFeel())) {
            return false;
        }
        Boolean bool = (Boolean) Toolkit.getDefaultToolkit().getDesktopProperty("win.xpstyle.themeActive");
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }

    protected Baseline() {
    }

    public int getComponentBaseline(JComponent jComponent, int i2, int i3) {
        return -1;
    }
}
