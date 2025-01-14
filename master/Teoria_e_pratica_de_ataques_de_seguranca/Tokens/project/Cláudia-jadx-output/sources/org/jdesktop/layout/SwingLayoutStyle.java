package org.jdesktop.layout;

import java.awt.Container;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.JComponent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/SwingLayoutStyle.class */
public class SwingLayoutStyle extends LayoutStyle {
    private static final Method SWING_GET_LAYOUT_STYLE_METHOD;
    private static final Method SWING_GET_PREFERRED_GAP_METHOD;
    private static final Method SWING_GET_CONTAINER_GAP_METHOD;
    private static final Object RELATED_TYPE;
    private static final Object UNRELATED_TYPE;
    private static final Object INDENT_TYPE;
    static Class class$javax$swing$JComponent;
    static Class class$java$awt$Container;
    static final boolean $assertionsDisabled;
    static Class class$org$jdesktop$layout$SwingLayoutStyle;

    static {
        Class cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        Class<?> cls5;
        Class<?> cls6;
        if (class$org$jdesktop$layout$SwingLayoutStyle == null) {
            cls = class$("org.jdesktop.layout.SwingLayoutStyle");
            class$org$jdesktop$layout$SwingLayoutStyle = cls;
        } else {
            cls = class$org$jdesktop$layout$SwingLayoutStyle;
        }
        $assertionsDisabled = !cls.desiredAssertionStatus();
        Method method = null;
        Method method2 = null;
        Method method3 = null;
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        try {
            Class.forName("javax.swing.LayoutStyle");
            Class<?> cls7 = Class.forName("javax.swing.LayoutStyle$ComponentPlacement");
            Class<?> cls8 = Class.forName("javax.swing.LayoutStyle");
            method = cls8.getMethod("getInstance", null);
            Class<?>[] clsArr = new Class[5];
            if (class$javax$swing$JComponent == null) {
                cls2 = class$("javax.swing.JComponent");
                class$javax$swing$JComponent = cls2;
            } else {
                cls2 = class$javax$swing$JComponent;
            }
            clsArr[0] = cls2;
            if (class$javax$swing$JComponent == null) {
                cls3 = class$("javax.swing.JComponent");
                class$javax$swing$JComponent = cls3;
            } else {
                cls3 = class$javax$swing$JComponent;
            }
            clsArr[1] = cls3;
            clsArr[2] = cls7;
            clsArr[3] = Integer.TYPE;
            if (class$java$awt$Container == null) {
                cls4 = class$("java.awt.Container");
                class$java$awt$Container = cls4;
            } else {
                cls4 = class$java$awt$Container;
            }
            clsArr[4] = cls4;
            method2 = cls8.getMethod("getPreferredGap", clsArr);
            Class<?>[] clsArr2 = new Class[3];
            if (class$javax$swing$JComponent == null) {
                cls5 = class$("javax.swing.JComponent");
                class$javax$swing$JComponent = cls5;
            } else {
                cls5 = class$javax$swing$JComponent;
            }
            clsArr2[0] = cls5;
            clsArr2[1] = Integer.TYPE;
            if (class$java$awt$Container == null) {
                cls6 = class$("java.awt.Container");
                class$java$awt$Container = cls6;
            } else {
                cls6 = class$java$awt$Container;
            }
            clsArr2[2] = cls6;
            method3 = cls8.getMethod("getContainerGap", clsArr2);
            obj = cls7.getField("RELATED").get(null);
            obj2 = cls7.getField("UNRELATED").get(null);
            obj3 = cls7.getField("INDENT").get(null);
        } catch (ClassNotFoundException e2) {
        } catch (IllegalAccessException e3) {
        } catch (NoSuchFieldException e4) {
        } catch (NoSuchMethodException e5) {
        }
        SWING_GET_LAYOUT_STYLE_METHOD = method;
        SWING_GET_PREFERRED_GAP_METHOD = method2;
        SWING_GET_CONTAINER_GAP_METHOD = method3;
        RELATED_TYPE = obj;
        UNRELATED_TYPE = obj2;
        INDENT_TYPE = obj3;
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private static final Object layoutStyleTypeToComponentPlacement(int i2) {
        if (i2 == 0) {
            return RELATED_TYPE;
        }
        if (i2 == 1) {
            return UNRELATED_TYPE;
        }
        if ($assertionsDisabled || i2 == 3) {
            return INDENT_TYPE;
        }
        throw new AssertionError();
    }

    private static final Object getSwingLayoutStyle() {
        try {
            return SWING_GET_LAYOUT_STYLE_METHOD.invoke(null, null);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return null;
        }
    }

    @Override // org.jdesktop.layout.LayoutStyle
    public int getPreferredGap(JComponent jComponent, JComponent jComponent2, int i2, int i3, Container container) {
        super.getPreferredGap(jComponent, jComponent2, i2, i3, container);
        Object layoutStyleTypeToComponentPlacement = layoutStyleTypeToComponentPlacement(i2);
        try {
            return ((Integer) SWING_GET_PREFERRED_GAP_METHOD.invoke(getSwingLayoutStyle(), jComponent, jComponent2, layoutStyleTypeToComponentPlacement, new Integer(i3), container)).intValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return 0;
        }
    }

    @Override // org.jdesktop.layout.LayoutStyle
    public int getContainerGap(JComponent jComponent, int i2, Container container) {
        super.getContainerGap(jComponent, i2, container);
        try {
            return ((Integer) SWING_GET_CONTAINER_GAP_METHOD.invoke(getSwingLayoutStyle(), jComponent, new Integer(i2), container)).intValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            return 0;
        }
    }
}
