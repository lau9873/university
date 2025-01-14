package org.jdesktop.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.JComponent;
/* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout.class */
public class GroupLayout implements LayoutManager2 {
    private static final int MIN_SIZE = 0;
    private static final int PREF_SIZE = 1;
    private static final int MAX_SIZE = 2;
    private static final int SPECIFIC_SIZE = 3;
    private static final int UNSET = Integer.MIN_VALUE;
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    private static final int NO_ALIGNMENT = 0;
    public static final int LEADING = 1;
    public static final int TRAILING = 2;
    public static final int CENTER = 4;
    public static final int BASELINE = 3;
    public static final int DEFAULT_SIZE = -1;
    public static final int PREFERRED_SIZE = -2;
    private boolean autocreatePadding;
    private boolean autocreateContainerPadding;
    private Group horizontalGroup;
    private Group verticalGroup;
    private Map componentInfos;
    private Container host;
    private Set tmpParallelSet;
    private boolean springsChanged;
    private boolean isValid;
    private boolean hasPreferredPaddingSprings;
    private LayoutStyle layoutStyle;
    private boolean honorsVisibility;
    static Class class$org$jdesktop$layout$GroupLayout;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.jdesktop.layout.GroupLayout$1  reason: invalid class name */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$1.class */
    public static class AnonymousClass1 {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkSize(int i2, int i3, int i4, boolean z) {
        checkResizeType(i2, z);
        if (!z && i3 < 0) {
            throw new IllegalArgumentException("Pref must be >= 0");
        }
        if (z) {
            checkResizeType(i3, true);
        }
        checkResizeType(i4, z);
        checkLessThan(i2, i3);
        checkLessThan(i3, i4);
    }

    private static void checkResizeType(int i2, boolean z) {
        if (i2 < 0) {
            if ((z && i2 != -1 && i2 != -2) || (!z && i2 != -2)) {
                throw new IllegalArgumentException("Invalid size");
            }
        }
    }

    private static void checkLessThan(int i2, int i3) {
        if (i2 >= 0 && i3 >= 0 && i2 > i3) {
            throw new IllegalArgumentException("Following is not met: min<=pref<=max");
        }
    }

    public GroupLayout(Container container) {
        if (container == null) {
            throw new IllegalArgumentException("Container must be non-null");
        }
        this.honorsVisibility = true;
        this.host = container;
        setHorizontalGroup(createParallelGroup(1, true));
        setVerticalGroup(createParallelGroup(1, true));
        this.componentInfos = new HashMap();
        this.tmpParallelSet = new HashSet();
    }

    public void setHonorsVisibility(boolean z) {
        if (this.honorsVisibility != z) {
            this.honorsVisibility = z;
            this.springsChanged = true;
            this.isValid = false;
            invalidateHost();
        }
    }

    public boolean getHonorsVisibility() {
        return this.honorsVisibility;
    }

    public void setHonorsVisibility(Component component, Boolean bool) {
        if (component == null) {
            throw new IllegalArgumentException("Component must be non-null");
        }
        getComponentInfo(component).setHonorsVisibility(bool);
        this.springsChanged = true;
        this.isValid = false;
        invalidateHost();
    }

    public String toString() {
        if (this.springsChanged) {
            registerComponents(this.horizontalGroup, 1);
            registerComponents(this.verticalGroup, 2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HORIZONTAL\n");
        dump(stringBuffer, this.horizontalGroup, "  ", 1);
        stringBuffer.append("\nVERTICAL\n");
        dump(stringBuffer, this.verticalGroup, "  ", 2);
        return stringBuffer.toString();
    }

    private void dump(StringBuffer stringBuffer, Spring spring, String str, int i2) {
        String str2 = "";
        String str3 = "";
        if (spring instanceof ComponentSpring) {
            ComponentSpring componentSpring = (ComponentSpring) spring;
            str2 = new StringBuffer().append(Integer.toString(componentSpring.getOrigin())).append(" ").toString();
            String name = componentSpring.getComponent().getName();
            if (name != null) {
                str2 = new StringBuffer().append("name=").append(name).append(", ").toString();
            }
        }
        if (spring instanceof AutopaddingSpring) {
            AutopaddingSpring autopaddingSpring = (AutopaddingSpring) spring;
            str3 = new StringBuffer().append(", userCreated=").append(autopaddingSpring.getUserCreated()).append(", matches=").append(autopaddingSpring.getMatchDescription()).toString();
        }
        stringBuffer.append(new StringBuffer().append(str).append(spring.getClass().getName()).append(" ").append(Integer.toHexString(spring.hashCode())).append(" ").append(str2).append(", size=").append(spring.getSize()).append(", alignment=").append(spring.getAlignment()).append(" prefs=[").append(spring.getMinimumSize(i2)).append(" ").append(spring.getPreferredSize(i2)).append(" ").append(spring.getMaximumSize(i2)).append(str3).append("]\n").toString());
        if (spring instanceof Group) {
            List list = ((Group) spring).springs;
            String stringBuffer2 = new StringBuffer().append(str).append("  ").toString();
            for (int i3 = 0; i3 < list.size(); i3++) {
                dump(stringBuffer, (Spring) list.get(i3), stringBuffer2, i2);
            }
        }
    }

    public void setAutocreateGaps(boolean z) {
        if (this.autocreatePadding != z) {
            this.autocreatePadding = z;
            invalidateHost();
        }
    }

    public boolean getAutocreateGaps() {
        return this.autocreatePadding;
    }

    public void setAutocreateContainerGaps(boolean z) {
        if (z != this.autocreateContainerPadding) {
            this.autocreateContainerPadding = z;
            this.horizontalGroup = createTopLevelGroup(getHorizontalGroup());
            this.verticalGroup = createTopLevelGroup(getVerticalGroup());
            invalidateHost();
        }
    }

    public boolean getAutocreateContainerGaps() {
        return this.autocreateContainerPadding;
    }

    public void setHorizontalGroup(Group group) {
        if (group == null) {
            throw new IllegalArgumentException("Group must be non-null");
        }
        this.horizontalGroup = createTopLevelGroup(group);
        invalidateHost();
    }

    public Group getHorizontalGroup() {
        int i2 = 0;
        if (this.horizontalGroup.springs.size() > 1) {
            i2 = 1;
        }
        return (Group) this.horizontalGroup.springs.get(i2);
    }

    public void setVerticalGroup(Group group) {
        if (group == null) {
            throw new IllegalArgumentException("Group must be non-null");
        }
        this.verticalGroup = createTopLevelGroup(group);
        invalidateHost();
    }

    public Group getVerticalGroup() {
        int i2 = 0;
        if (this.verticalGroup.springs.size() > 1) {
            i2 = 1;
        }
        return (Group) this.verticalGroup.springs.get(i2);
    }

    private Group createTopLevelGroup(Group group) {
        SequentialGroup createSequentialGroup = createSequentialGroup();
        if (getAutocreateContainerGaps()) {
            createSequentialGroup.addSpring(new ContainerAutopaddingSpring(this));
            createSequentialGroup.add(group);
            createSequentialGroup.addSpring(new ContainerAutopaddingSpring(this));
        } else {
            createSequentialGroup.add(group);
        }
        return createSequentialGroup;
    }

    public SequentialGroup createSequentialGroup() {
        return new SequentialGroup(this);
    }

    public ParallelGroup createParallelGroup() {
        return createParallelGroup(1);
    }

    public ParallelGroup createParallelGroup(int i2) {
        return createParallelGroup(i2, true);
    }

    public ParallelGroup createParallelGroup(int i2, boolean z) {
        if (i2 == 3) {
            return new BaselineGroup(this, z);
        }
        return new ParallelGroup(this, i2, z);
    }

    public ParallelGroup createBaselineGroup(boolean z, boolean z2) {
        return new BaselineGroup(this, z, z2);
    }

    public void linkSize(Component[] componentArr) {
        linkSize(componentArr, 3);
    }

    public void linkSize(Component[] componentArr, int i2) {
        if (componentArr == null) {
            throw new IllegalArgumentException("Components must be non-null");
        }
        boolean z = (i2 & 1) == 1;
        boolean z2 = (i2 & 2) == 2;
        if (!z2 && !z) {
            throw new IllegalArgumentException("Axis must contain HORIZONTAL or VERTICAL");
        }
        for (int length = componentArr.length - 1; length >= 0; length--) {
            Component component = componentArr[length];
            if (componentArr[length] == null) {
                throw new IllegalArgumentException("Components must be non-null");
            }
            getComponentInfo(component);
        }
        if (z) {
            linkSize0(componentArr, 1);
        }
        if (z2) {
            linkSize0(componentArr, 2);
        }
        invalidateHost();
    }

    private void linkSize0(Component[] componentArr, int i2) {
        LinkInfo linkInfo = getComponentInfo(componentArr[componentArr.length - 1]).getLinkInfo(i2);
        for (int length = componentArr.length - 2; length >= 0; length--) {
            linkInfo.add(getComponentInfo(componentArr[length]));
        }
    }

    public void replace(Component component, Component component2) {
        if (component == null || component2 == null) {
            throw new IllegalArgumentException("Components must be non-null");
        }
        if (this.springsChanged) {
            registerComponents(this.horizontalGroup, 1);
            registerComponents(this.verticalGroup, 2);
        }
        ComponentInfo componentInfo = (ComponentInfo) this.componentInfos.remove(component);
        if (componentInfo == null) {
            throw new IllegalArgumentException("Component must already exist");
        }
        this.host.remove(component);
        if (component2.getParent() != this.host) {
            this.host.add(component2);
        }
        componentInfo.setComponent(component2);
        this.componentInfos.put(component2, componentInfo);
        invalidateHost();
    }

    public void setLayoutStyle(LayoutStyle layoutStyle) {
        this.layoutStyle = layoutStyle;
        invalidateHost();
    }

    public LayoutStyle getLayoutStyle() {
        return this.layoutStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LayoutStyle getLayoutStyle0() {
        LayoutStyle layoutStyle = getLayoutStyle();
        if (layoutStyle == null) {
            layoutStyle = LayoutStyle.getSharedInstance();
        }
        return layoutStyle;
    }

    private void invalidateHost() {
        if (this.host instanceof JComponent) {
            this.host.revalidate();
        } else {
            this.host.invalidate();
        }
        this.host.repaint();
    }

    public void addLayoutComponent(String str, Component component) {
    }

    public void removeLayoutComponent(Component component) {
        ComponentInfo componentInfo = (ComponentInfo) this.componentInfos.remove(component);
        if (componentInfo != null) {
            componentInfo.dispose();
            this.springsChanged = true;
            this.isValid = false;
        }
    }

    public Dimension preferredLayoutSize(Container container) {
        checkParent(container);
        prepare(1);
        return adjustSize(this.horizontalGroup.getPreferredSize(1), this.verticalGroup.getPreferredSize(2));
    }

    public Dimension minimumLayoutSize(Container container) {
        checkParent(container);
        prepare(0);
        return adjustSize(this.horizontalGroup.getMinimumSize(1), this.verticalGroup.getMinimumSize(2));
    }

    public void layoutContainer(Container container) {
        prepare(3);
        Insets insets = container.getInsets();
        int width = (container.getWidth() - insets.left) - insets.right;
        int height = (container.getHeight() - insets.top) - insets.bottom;
        boolean isLeftToRight = isLeftToRight();
        if (getAutocreateGaps() || getAutocreateContainerGaps() || this.hasPreferredPaddingSprings) {
            calculateAutopadding(this.horizontalGroup, 1, 3, 0, width);
            calculateAutopadding(this.verticalGroup, 2, 3, 0, height);
        }
        this.horizontalGroup.setSize(1, 0, width);
        this.verticalGroup.setSize(2, 0, height);
        for (ComponentInfo componentInfo : this.componentInfos.values()) {
            componentInfo.getComponent();
            componentInfo.setBounds(insets, width, isLeftToRight);
        }
    }

    public void addLayoutComponent(Component component, Object obj) {
    }

    public Dimension maximumLayoutSize(Container container) {
        checkParent(container);
        prepare(2);
        return adjustSize(this.horizontalGroup.getMaximumSize(1), this.verticalGroup.getMaximumSize(2));
    }

    public float getLayoutAlignmentX(Container container) {
        checkParent(container);
        return 0.5f;
    }

    public float getLayoutAlignmentY(Container container) {
        checkParent(container);
        return 0.5f;
    }

    public void invalidateLayout(Container container) {
        checkParent(container);
        synchronized (container.getTreeLock()) {
            this.isValid = false;
        }
    }

    private void prepare(int i2) {
        boolean z = false;
        if (!this.isValid) {
            this.isValid = true;
            this.horizontalGroup.setSize(1, UNSET, UNSET);
            this.verticalGroup.setSize(2, UNSET, UNSET);
            for (ComponentInfo componentInfo : this.componentInfos.values()) {
                if (componentInfo.updateVisibility()) {
                    z = true;
                }
                componentInfo.clearCachedSize();
            }
        }
        if (this.springsChanged) {
            registerComponents(this.horizontalGroup, 1);
            registerComponents(this.verticalGroup, 2);
        }
        if (this.springsChanged || z) {
            checkComponents();
            this.horizontalGroup.removeAutopadding();
            this.verticalGroup.removeAutopadding();
            if (getAutocreateGaps()) {
                insertAutopadding(true);
            } else if (this.hasPreferredPaddingSprings || getAutocreateContainerGaps()) {
                insertAutopadding(false);
            }
            this.springsChanged = false;
        }
        if (i2 != 3) {
            if (getAutocreateGaps() || getAutocreateContainerGaps() || this.hasPreferredPaddingSprings) {
                calculateAutopadding(this.horizontalGroup, 1, i2, 0, 0);
                calculateAutopadding(this.verticalGroup, 2, i2, 0, 0);
            }
        }
    }

    private void calculateAutopadding(Group group, int i2, int i3, int i4, int i5) {
        group.unsetAutopadding();
        switch (i3) {
            case 0:
                i5 = group.getMinimumSize(i2);
                break;
            case 1:
                i5 = group.getPreferredSize(i2);
                break;
            case 2:
                i5 = group.getMaximumSize(i2);
                break;
        }
        group.setSize(i2, i4, i5);
        group.calculateAutopadding(i2);
    }

    private void checkComponents() {
        for (ComponentInfo componentInfo : this.componentInfos.values()) {
            if (componentInfo.horizontalSpring == null) {
                throw new IllegalStateException(new StringBuffer().append(componentInfo.component).append(" is not attached to a horizontal group").toString());
            }
            if (componentInfo.verticalSpring == null) {
                throw new IllegalStateException(new StringBuffer().append(componentInfo.component).append(" is not attached to a vertical group").toString());
            }
        }
    }

    private void registerComponents(Group group, int i2) {
        List list = group.springs;
        for (int size = list.size() - 1; size >= 0; size--) {
            Spring spring = (Spring) list.get(size);
            if (spring instanceof ComponentSpring) {
                ((ComponentSpring) spring).installIfNecessary(i2);
            } else if (spring instanceof Group) {
                registerComponents((Group) spring, i2);
            }
        }
    }

    private Dimension adjustSize(int i2, int i3) {
        Insets insets = this.host.getInsets();
        return new Dimension(i2 + insets.left + insets.right, i3 + insets.top + insets.bottom);
    }

    private void checkParent(Container container) {
        if (container != this.host) {
            throw new IllegalArgumentException("GroupLayout can only be used with one Container at a time");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ComponentInfo getComponentInfo(Component component) {
        ComponentInfo componentInfo = (ComponentInfo) this.componentInfos.get(component);
        if (componentInfo == null) {
            componentInfo = new ComponentInfo(this, component);
            this.componentInfos.put(component, componentInfo);
            if (component.getParent() != this.host) {
                this.host.add(component);
            }
        }
        return componentInfo;
    }

    private void insertAutopadding(boolean z) {
        this.horizontalGroup.insertAutopadding(1, new ArrayList(1), new ArrayList(1), new ArrayList(1), new ArrayList(1), z);
        this.verticalGroup.insertAutopadding(2, new ArrayList(1), new ArrayList(1), new ArrayList(1), new ArrayList(1), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean areParallelSiblings(Component component, Component component2, int i2) {
        ComponentSpring componentSpring;
        ComponentSpring componentSpring2;
        ComponentInfo componentInfo = getComponentInfo(component);
        ComponentInfo componentInfo2 = getComponentInfo(component2);
        if (i2 == 1) {
            componentSpring = componentInfo.horizontalSpring;
            componentSpring2 = componentInfo2.horizontalSpring;
        } else {
            componentSpring = componentInfo.verticalSpring;
            componentSpring2 = componentInfo2.verticalSpring;
        }
        Set set = this.tmpParallelSet;
        set.clear();
        Spring parent = componentSpring.getParent();
        while (true) {
            Spring spring = parent;
            if (spring == null) {
                break;
            }
            set.add(spring);
            parent = spring.getParent();
        }
        Spring parent2 = componentSpring2.getParent();
        while (true) {
            Spring spring2 = parent2;
            if (spring2 != null) {
                if (set.contains(spring2)) {
                    set.clear();
                    while (spring2 != null) {
                        if (spring2 instanceof ParallelGroup) {
                            return true;
                        }
                        spring2 = spring2.getParent();
                    }
                    return false;
                }
                parent2 = spring2.getParent();
            } else {
                set.clear();
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLeftToRight() {
        return this.host.getComponentOrientation().isLeftToRight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$Spring.class */
    public abstract class Spring {
        private int size;
        private Spring parent;
        private int alignment;
        private final GroupLayout this$0;
        private int max = GroupLayout.UNSET;
        private int pref = GroupLayout.UNSET;
        private int min = GroupLayout.UNSET;

        abstract int calculateMinimumSize(int i2);

        abstract int calculatePreferredSize(int i2);

        abstract int calculateMaximumSize(int i2);

        abstract boolean willHaveZeroSize(boolean z);

        Spring(GroupLayout groupLayout) {
            this.this$0 = groupLayout;
        }

        void setParent(Spring spring) {
            this.parent = spring;
        }

        Spring getParent() {
            return this.parent;
        }

        void setAlignment(int i2) {
            this.alignment = i2;
        }

        int getAlignment() {
            return this.alignment;
        }

        final int getMinimumSize(int i2) {
            if (this.min == GroupLayout.UNSET) {
                this.min = constrain(calculateMinimumSize(i2));
            }
            return this.min;
        }

        final int getPreferredSize(int i2) {
            if (this.pref == GroupLayout.UNSET) {
                this.pref = constrain(calculatePreferredSize(i2));
            }
            return this.pref;
        }

        final int getMaximumSize(int i2) {
            if (this.max == GroupLayout.UNSET) {
                this.max = constrain(calculateMaximumSize(i2));
            }
            return this.max;
        }

        void unset() {
            this.max = GroupLayout.UNSET;
            this.pref = GroupLayout.UNSET;
            this.min = GroupLayout.UNSET;
            this.size = GroupLayout.UNSET;
        }

        void setSize(int i2, int i3, int i4) {
            this.size = i4;
            if (i4 == GroupLayout.UNSET) {
                unset();
            }
        }

        int getSize() {
            return this.size;
        }

        int constrain(int i2) {
            return Math.min(i2, 32767);
        }

        int getBaseline() {
            return -1;
        }

        int getBaselineResizeBehavior() {
            return 4;
        }

        final boolean isResizable(int i2) {
            int minimumSize = getMinimumSize(i2);
            int preferredSize = getPreferredSize(i2);
            return (minimumSize == preferredSize && preferredSize == getMaximumSize(i2)) ? false : true;
        }
    }

    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$Group.class */
    public abstract class Group extends Spring {
        List springs;
        static final boolean $assertionsDisabled;
        private final GroupLayout this$0;

        abstract void setValidSize(int i2, int i3, int i4);

        abstract int operator(int i2, int i3);

        abstract void insertAutopadding(int i2, List list, List list2, List list3, List list4, boolean z);

        static {
            Class cls;
            if (GroupLayout.class$org$jdesktop$layout$GroupLayout == null) {
                cls = GroupLayout.class$("org.jdesktop.layout.GroupLayout");
                GroupLayout.class$org$jdesktop$layout$GroupLayout = cls;
            } else {
                cls = GroupLayout.class$org$jdesktop$layout$GroupLayout;
            }
            $assertionsDisabled = !cls.desiredAssertionStatus();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Group(GroupLayout groupLayout) {
            super(groupLayout);
            this.this$0 = groupLayout;
            this.springs = new ArrayList();
        }

        int indexOf(Spring spring) {
            return this.springs.indexOf(spring);
        }

        Group addSpring(Spring spring) {
            this.springs.add(spring);
            spring.setParent(this);
            if (!(spring instanceof AutopaddingSpring) || !((AutopaddingSpring) spring).getUserCreated()) {
                this.this$0.springsChanged = true;
            }
            return this;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        void setSize(int i2, int i3, int i4) {
            super.setSize(i2, i3, i4);
            if (i4 == GroupLayout.UNSET) {
                for (int size = this.springs.size() - 1; size >= 0; size--) {
                    getSpring(size).setSize(i2, i3, i4);
                }
                return;
            }
            setValidSize(i2, i3, i4);
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculateMinimumSize(int i2) {
            return calculateSize(i2, 0);
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculatePreferredSize(int i2) {
            return calculateSize(i2, 1);
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculateMaximumSize(int i2) {
            return calculateSize(i2, 2);
        }

        int calculateSize(int i2, int i3) {
            int size = this.springs.size();
            if (size == 0) {
                return 0;
            }
            if (size == 1) {
                return getSpringSize(getSpring(0), i2, i3);
            }
            int constrain = constrain(operator(getSpringSize(getSpring(0), i2, i3), getSpringSize(getSpring(1), i2, i3)));
            for (int i4 = 2; i4 < size; i4++) {
                constrain = constrain(operator(constrain, getSpringSize(getSpring(i4), i2, i3)));
            }
            return constrain;
        }

        Spring getSpring(int i2) {
            return (Spring) this.springs.get(i2);
        }

        int getSpringSize(Spring spring, int i2, int i3) {
            switch (i3) {
                case 0:
                    return spring.getMinimumSize(i2);
                case 1:
                    return spring.getPreferredSize(i2);
                case 2:
                    return spring.getMaximumSize(i2);
                default:
                    if ($assertionsDisabled) {
                        return 0;
                    }
                    throw new AssertionError();
            }
        }

        void removeAutopadding() {
            unset();
            for (int size = this.springs.size() - 1; size >= 0; size--) {
                Spring spring = (Spring) this.springs.get(size);
                if (spring instanceof AutopaddingSpring) {
                    if (((AutopaddingSpring) spring).getUserCreated()) {
                        ((AutopaddingSpring) spring).reset();
                    } else {
                        this.springs.remove(size);
                    }
                } else if (spring instanceof Group) {
                    ((Group) spring).removeAutopadding();
                }
            }
        }

        void unsetAutopadding() {
            unset();
            for (int size = this.springs.size() - 1; size >= 0; size--) {
                Spring spring = (Spring) this.springs.get(size);
                if (spring instanceof AutopaddingSpring) {
                    ((AutopaddingSpring) spring).unset();
                } else if (spring instanceof Group) {
                    ((Group) spring).unsetAutopadding();
                }
            }
        }

        void calculateAutopadding(int i2) {
            for (int size = this.springs.size() - 1; size >= 0; size--) {
                Spring spring = (Spring) this.springs.get(size);
                if (spring instanceof AutopaddingSpring) {
                    spring.unset();
                    ((AutopaddingSpring) spring).calculatePadding(i2);
                } else if (spring instanceof Group) {
                    ((Group) spring).calculateAutopadding(i2);
                }
            }
            unset();
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        boolean willHaveZeroSize(boolean z) {
            for (int size = this.springs.size() - 1; size >= 0; size--) {
                if (!((Spring) this.springs.get(size)).willHaveZeroSize(z)) {
                    return false;
                }
            }
            return true;
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$SequentialGroup.class */
    public class SequentialGroup extends Group {
        private Spring baselineSpring;
        static final boolean $assertionsDisabled;
        private final GroupLayout this$0;

        static {
            Class cls;
            if (GroupLayout.class$org$jdesktop$layout$GroupLayout == null) {
                cls = GroupLayout.class$("org.jdesktop.layout.GroupLayout");
                GroupLayout.class$org$jdesktop$layout$GroupLayout = cls;
            } else {
                cls = GroupLayout.class$org$jdesktop$layout$GroupLayout;
            }
            $assertionsDisabled = !cls.desiredAssertionStatus();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        SequentialGroup(GroupLayout groupLayout) {
            super(groupLayout);
            this.this$0 = groupLayout;
        }

        public SequentialGroup add(Group group) {
            return (SequentialGroup) addSpring(group);
        }

        public SequentialGroup add(boolean z, Group group) {
            add(group);
            if (z) {
                this.baselineSpring = group;
            }
            return this;
        }

        public SequentialGroup add(Component component) {
            return add(component, -1, -1, -1);
        }

        public SequentialGroup add(boolean z, Component component) {
            add(component);
            if (z) {
                this.baselineSpring = getSpring(this.springs.size() - 1);
            }
            return this;
        }

        public SequentialGroup add(Component component, int i2, int i3, int i4) {
            return (SequentialGroup) addSpring(new ComponentSpring(this.this$0, component, i2, i3, i4, null));
        }

        public SequentialGroup add(boolean z, Component component, int i2, int i3, int i4) {
            add(component, i2, i3, i4);
            if (z) {
                this.baselineSpring = getSpring(this.springs.size() - 1);
            }
            return this;
        }

        public SequentialGroup add(int i2) {
            return add(i2, i2, i2);
        }

        public SequentialGroup add(int i2, int i3, int i4) {
            return (SequentialGroup) addSpring(new GapSpring(this.this$0, i2, i3, i4));
        }

        public SequentialGroup addPreferredGap(JComponent jComponent, JComponent jComponent2, int i2) {
            return addPreferredGap(jComponent, jComponent2, i2, false);
        }

        public SequentialGroup addPreferredGap(JComponent jComponent, JComponent jComponent2, int i2, boolean z) {
            if (i2 != 0 && i2 != 1 && i2 != 3) {
                throw new IllegalArgumentException("Invalid type argument");
            }
            if (jComponent == null || jComponent2 == null) {
                throw new IllegalArgumentException("Components must be non-null");
            }
            return (SequentialGroup) addSpring(new PaddingSpring(this.this$0, jComponent, jComponent2, i2, z));
        }

        public SequentialGroup addPreferredGap(int i2) {
            return addPreferredGap(i2, -1, -1);
        }

        public SequentialGroup addPreferredGap(int i2, int i3, int i4) {
            if (i2 != 0 && i2 != 1) {
                throw new IllegalArgumentException("Padding type must be one of Padding.RELATED or Padding.UNRELATED");
            }
            if ((i3 >= 0 || i3 == -1 || i3 == -2) && ((i4 >= 0 || i4 == -1 || i4 == -2) && (i3 < 0 || i4 < 0 || i3 <= i4))) {
                this.this$0.hasPreferredPaddingSprings = true;
                return (SequentialGroup) addSpring(new AutopaddingSpring(this.this$0, i2, i3, i4));
            }
            throw new IllegalArgumentException("Pref and max must be either DEFAULT_SIZE, PREFERRED_SIZE, or >= 0 and pref <= max");
        }

        public SequentialGroup addContainerGap() {
            return addContainerGap(-1, -1);
        }

        public SequentialGroup addContainerGap(int i2, int i3) {
            if ((i2 >= 0 || i2 == -1) && ((i3 >= 0 || i3 == -1 || i3 == -2) && (i2 < 0 || i3 < 0 || i2 <= i3))) {
                this.this$0.hasPreferredPaddingSprings = true;
                return (SequentialGroup) addSpring(new ContainerAutopaddingSpring(this.this$0, i2, i3));
            }
            throw new IllegalArgumentException("Pref and max must be either DEFAULT_VALUE or >= 0 and pref <= max");
        }

        @Override // org.jdesktop.layout.GroupLayout.Group
        int operator(int i2, int i3) {
            return constrain(i2) + constrain(i3);
        }

        @Override // org.jdesktop.layout.GroupLayout.Group
        void setValidSize(int i2, int i3, int i4) {
            if (i4 == getPreferredSize(i2)) {
                int size = this.springs.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Spring spring = getSpring(i5);
                    int preferredSize = spring.getPreferredSize(i2);
                    spring.setSize(i2, i3, preferredSize);
                    i3 += preferredSize;
                }
            } else if (this.springs.size() == 1) {
                Spring spring2 = getSpring(0);
                spring2.setSize(i2, i3, Math.min(Math.max(i4, spring2.getMinimumSize(i2)), spring2.getMaximumSize(i2)));
            } else if (this.springs.size() > 1) {
                setValidSizeNotPreferred(i2, i3, i4);
            }
        }

        private void setValidSizeNotPreferred(int i2, int i3, int i4) {
            int maximumSize;
            int preferredSize = i4 - getPreferredSize(i2);
            if (!$assertionsDisabled && preferredSize == 0) {
                throw new AssertionError();
            }
            boolean z = preferredSize < 0;
            int size = this.springs.size();
            if (z) {
                preferredSize *= -1;
            }
            List buildResizableList = buildResizableList(i2, z);
            int size2 = buildResizableList.size();
            if (size2 > 0) {
                int i5 = preferredSize / size2;
                int i6 = preferredSize - (i5 * size2);
                int[] iArr = new int[size];
                int i7 = z ? -1 : 1;
                for (int i8 = 0; i8 < size2; i8++) {
                    SpringDelta springDelta = (SpringDelta) buildResizableList.get(i8);
                    if (i8 + 1 == size2) {
                        i5 += i6;
                    }
                    springDelta.delta = Math.min(i5, springDelta.delta);
                    preferredSize -= springDelta.delta;
                    if (springDelta.delta != i5 && i8 + 1 < size2) {
                        i5 = preferredSize / ((size2 - i8) - 1);
                        i6 = preferredSize - (i5 * ((size2 - i8) - 1));
                    }
                    iArr[springDelta.index] = i7 * springDelta.delta;
                }
                for (int i9 = 0; i9 < size; i9++) {
                    Spring spring = getSpring(i9);
                    int preferredSize2 = spring.getPreferredSize(i2) + iArr[i9];
                    spring.setSize(i2, i3, preferredSize2);
                    i3 += preferredSize2;
                }
                return;
            }
            for (int i10 = 0; i10 < size; i10++) {
                Spring spring2 = getSpring(i10);
                if (z) {
                    maximumSize = spring2.getMinimumSize(i2);
                } else {
                    maximumSize = spring2.getMaximumSize(i2);
                }
                int i11 = maximumSize;
                spring2.setSize(i2, i3, i11);
                i3 += i11;
            }
        }

        private List buildResizableList(int i2, boolean z) {
            int maximumSize;
            int size = this.springs.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                Spring spring = getSpring(i3);
                if (z) {
                    maximumSize = spring.getPreferredSize(i2) - spring.getMinimumSize(i2);
                } else {
                    maximumSize = spring.getMaximumSize(i2) - spring.getPreferredSize(i2);
                }
                if (maximumSize > 0) {
                    arrayList.add(new SpringDelta(i3, maximumSize));
                }
            }
            Collections.sort(arrayList);
            return arrayList;
        }

        private int indexOfNextNonZeroSpring(int i2, boolean z) {
            while (i2 < this.springs.size()) {
                if (!((Spring) this.springs.get(i2)).willHaveZeroSize(z)) {
                    return i2;
                }
                i2++;
            }
            return i2;
        }

        @Override // org.jdesktop.layout.GroupLayout.Group
        void insertAutopadding(int i2, List list, List list2, List list3, List list4, boolean z) {
            ArrayList arrayList = new ArrayList(list);
            ArrayList arrayList2 = new ArrayList(1);
            ArrayList arrayList3 = new ArrayList(list3);
            ArrayList arrayList4 = null;
            int i3 = 0;
            while (i3 < this.springs.size()) {
                Spring spring = getSpring(i3);
                if (spring instanceof AutopaddingSpring) {
                    if (arrayList.size() == 0) {
                        AutopaddingSpring autopaddingSpring = (AutopaddingSpring) spring;
                        autopaddingSpring.setSources(arrayList3);
                        arrayList3.clear();
                        int indexOfNextNonZeroSpring = indexOfNextNonZeroSpring(i3 + 1, true);
                        if (indexOfNextNonZeroSpring == this.springs.size()) {
                            if (!(autopaddingSpring instanceof ContainerAutopaddingSpring)) {
                                list2.add(autopaddingSpring);
                            }
                        } else {
                            arrayList.clear();
                            arrayList.add(autopaddingSpring);
                        }
                        i3 = indexOfNextNonZeroSpring;
                    } else {
                        i3 = indexOfNextNonZeroSpring(i3 + 1, true);
                    }
                } else if (arrayList3.size() > 0 && z) {
                    this.springs.add(i3, new AutopaddingSpring(this.this$0, null));
                } else if (spring instanceof ComponentSpring) {
                    ComponentSpring componentSpring = (ComponentSpring) spring;
                    if (!componentSpring.isVisible()) {
                        i3++;
                    } else {
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            ((AutopaddingSpring) arrayList.get(i4)).addTarget(componentSpring, i2);
                        }
                        arrayList3.clear();
                        arrayList.clear();
                        int indexOfNextNonZeroSpring2 = indexOfNextNonZeroSpring(i3 + 1, false);
                        if (indexOfNextNonZeroSpring2 == this.springs.size()) {
                            list4.add(componentSpring);
                        } else {
                            arrayList3.add(componentSpring);
                        }
                        i3 = indexOfNextNonZeroSpring2;
                    }
                } else if (spring instanceof Group) {
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList(1);
                    } else {
                        arrayList4.clear();
                    }
                    arrayList2.clear();
                    ((Group) spring).insertAutopadding(i2, arrayList, arrayList2, arrayList3, arrayList4, z);
                    arrayList3.clear();
                    arrayList.clear();
                    int indexOfNextNonZeroSpring3 = indexOfNextNonZeroSpring(i3 + 1, arrayList4.size() == 0);
                    if (indexOfNextNonZeroSpring3 == this.springs.size()) {
                        list4.addAll(arrayList4);
                        list2.addAll(arrayList2);
                    } else {
                        arrayList3.addAll(arrayList4);
                        arrayList.addAll(arrayList2);
                    }
                    i3 = indexOfNextNonZeroSpring3;
                } else {
                    arrayList.clear();
                    arrayList3.clear();
                    i3++;
                }
            }
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int getBaseline() {
            int baseline;
            if (this.baselineSpring != null && (baseline = this.baselineSpring.getBaseline()) >= 0) {
                int i2 = 0;
                int size = this.springs.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Spring spring = getSpring(i3);
                    if (spring == this.baselineSpring) {
                        return i2 + baseline;
                    }
                    i2 += spring.getPreferredSize(2);
                }
                return -1;
            }
            return -1;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int getBaselineResizeBehavior() {
            Spring spring;
            Spring spring2;
            if (isResizable(2)) {
                if (!this.baselineSpring.isResizable(2)) {
                    boolean z = false;
                    int i2 = 0;
                    int size = this.springs.size();
                    while (true) {
                        if (i2 < size && (spring2 = getSpring(i2)) != this.baselineSpring) {
                            if (!spring2.isResizable(2)) {
                                i2++;
                            } else {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    boolean z2 = false;
                    int size2 = this.springs.size() - 1;
                    while (true) {
                        if (size2 >= 0 && (spring = getSpring(size2)) != this.baselineSpring) {
                            if (spring.isResizable(2)) {
                                z2 = true;
                                break;
                            } else {
                                size2--;
                            }
                        } else {
                            break;
                        }
                    }
                    if (z && !z2) {
                        return 2;
                    }
                    if (!z && z2) {
                        return 1;
                    }
                    return 4;
                }
                int baselineResizeBehavior = this.baselineSpring.getBaselineResizeBehavior();
                if (baselineResizeBehavior == 1) {
                    int size3 = this.springs.size();
                    for (int i3 = 0; i3 < size3; i3++) {
                        Spring spring3 = getSpring(i3);
                        if (spring3 == this.baselineSpring) {
                            return 1;
                        }
                        if (spring3.isResizable(2)) {
                            return 4;
                        }
                    }
                    return 4;
                } else if (baselineResizeBehavior == 2) {
                    for (int size4 = this.springs.size() - 1; size4 >= 0; size4--) {
                        Spring spring4 = getSpring(size4);
                        if (spring4 == this.baselineSpring) {
                            return 2;
                        }
                        if (spring4.isResizable(2)) {
                            return 4;
                        }
                    }
                    return 4;
                } else {
                    return 4;
                }
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$SpringDelta.class */
    public static final class SpringDelta implements Comparable {
        public final int index;
        public int delta;

        public SpringDelta(int i2, int i3) {
            this.index = i2;
            this.delta = i3;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.delta - ((SpringDelta) obj).delta;
        }

        public String toString() {
            return new StringBuffer().append(super.toString()).append("[index=").append(this.index).append(", delta=").append(this.delta).append("]").toString();
        }
    }

    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$ParallelGroup.class */
    public class ParallelGroup extends Group {
        private final int childAlignment;
        private final boolean resizable;
        private final GroupLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        ParallelGroup(GroupLayout groupLayout, int i2, boolean z) {
            super(groupLayout);
            this.this$0 = groupLayout;
            this.childAlignment = i2;
            this.resizable = z;
        }

        public ParallelGroup add(Group group) {
            return (ParallelGroup) addSpring(group);
        }

        public ParallelGroup add(Component component) {
            return add(component, -1, -1, -1);
        }

        public ParallelGroup add(Component component, int i2, int i3, int i4) {
            return (ParallelGroup) addSpring(new ComponentSpring(this.this$0, component, i2, i3, i4, null));
        }

        public ParallelGroup add(int i2) {
            return add(i2, i2, i2);
        }

        public ParallelGroup add(int i2, int i3, int i4) {
            return (ParallelGroup) addSpring(new GapSpring(this.this$0, i2, i3, i4));
        }

        public ParallelGroup add(int i2, Group group) {
            checkChildAlignment(i2);
            group.setAlignment(i2);
            return (ParallelGroup) addSpring(group);
        }

        public ParallelGroup add(int i2, Component component) {
            return add(i2, component, -1, -1, -1);
        }

        public ParallelGroup add(int i2, Component component, int i3, int i4, int i5) {
            checkChildAlignment(i2);
            ComponentSpring componentSpring = new ComponentSpring(this.this$0, component, i3, i4, i5, null);
            componentSpring.setAlignment(i2);
            return (ParallelGroup) addSpring(componentSpring);
        }

        boolean isResizable() {
            return this.resizable;
        }

        @Override // org.jdesktop.layout.GroupLayout.Group
        int operator(int i2, int i3) {
            return Math.max(i2, i3);
        }

        @Override // org.jdesktop.layout.GroupLayout.Group, org.jdesktop.layout.GroupLayout.Spring
        int calculateMinimumSize(int i2) {
            if (!isResizable()) {
                return getPreferredSize(i2);
            }
            return super.calculateMinimumSize(i2);
        }

        @Override // org.jdesktop.layout.GroupLayout.Group, org.jdesktop.layout.GroupLayout.Spring
        int calculateMaximumSize(int i2) {
            if (!isResizable()) {
                return getPreferredSize(i2);
            }
            return super.calculateMaximumSize(i2);
        }

        @Override // org.jdesktop.layout.GroupLayout.Group
        void setValidSize(int i2, int i3, int i4) {
            int size = this.springs.size();
            for (int i5 = 0; i5 < size; i5++) {
                setChildSize(getSpring(i5), i2, i3, i4);
            }
        }

        void setChildSize(Spring spring, int i2, int i3, int i4) {
            int alignment = spring.getAlignment();
            int min = Math.min(Math.max(spring.getMinimumSize(i2), i4), spring.getMaximumSize(i2));
            if (alignment == 0) {
                alignment = this.childAlignment;
            }
            switch (alignment) {
                case 2:
                    spring.setSize(i2, (i3 + i4) - min, min);
                    return;
                case 4:
                    spring.setSize(i2, i3 + ((i4 - min) / 2), min);
                    return;
                default:
                    spring.setSize(i2, i3, min);
                    return;
            }
        }

        @Override // org.jdesktop.layout.GroupLayout.Group
        void insertAutopadding(int i2, List list, List list2, List list3, List list4, boolean z) {
            int size = this.springs.size();
            for (int i3 = 0; i3 < size; i3++) {
                Spring spring = getSpring(i3);
                if (spring instanceof ComponentSpring) {
                    if (((ComponentSpring) spring).isVisible()) {
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            ((AutopaddingSpring) list.get(i4)).addTarget((ComponentSpring) spring, i2);
                        }
                        list4.add(spring);
                    }
                } else if (spring instanceof Group) {
                    ((Group) spring).insertAutopadding(i2, list, list2, list3, list4, z);
                } else if (spring instanceof AutopaddingSpring) {
                    ((AutopaddingSpring) spring).setSources(list3);
                    list2.add(spring);
                }
            }
        }

        private void checkChildAlignment(int i2) {
            if (!(this instanceof BaselineGroup) && i2 == 3) {
                throw new IllegalArgumentException("Alignment must be one of:LEADING, TRAILING or CENTER");
            }
            if (i2 != 4 && i2 != 3 && i2 != 1 && i2 != 2) {
                throw new IllegalArgumentException("Alignment must be one of:LEADING, TRAILING or CENTER");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$BaselineGroup.class */
    public class BaselineGroup extends ParallelGroup {
        private boolean allSpringsHaveBaseline;
        private int prefAscent;
        private int prefDescent;
        private boolean baselineAnchorSet;
        private boolean baselineAnchoredToTop;
        private boolean calcedBaseline;
        private final GroupLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        BaselineGroup(GroupLayout groupLayout, boolean z) {
            super(groupLayout, 1, z);
            this.this$0 = groupLayout;
            this.prefDescent = -1;
            this.prefAscent = -1;
            this.calcedBaseline = false;
        }

        BaselineGroup(GroupLayout groupLayout, boolean z, boolean z2) {
            this(groupLayout, z);
            this.baselineAnchoredToTop = z2;
            this.baselineAnchorSet = true;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        void unset() {
            super.unset();
            this.prefDescent = -1;
            this.prefAscent = -1;
            this.calcedBaseline = false;
        }

        @Override // org.jdesktop.layout.GroupLayout.ParallelGroup, org.jdesktop.layout.GroupLayout.Group
        void setValidSize(int i2, int i3, int i4) {
            checkAxis(i2);
            if (this.prefAscent == -1) {
                super.setValidSize(i2, i3, i4);
            } else {
                baselineLayout(i3, i4);
            }
        }

        @Override // org.jdesktop.layout.GroupLayout.Group
        int calculateSize(int i2, int i3) {
            checkAxis(i2);
            if (!this.calcedBaseline) {
                calculateBaselineAndResizeBehavior();
            }
            if (i3 == 0) {
                return calculateMinSize();
            }
            if (i3 == 2) {
                return calculateMaxSize();
            }
            if (this.allSpringsHaveBaseline) {
                return this.prefAscent + this.prefDescent;
            }
            return Math.max(this.prefAscent + this.prefDescent, super.calculateSize(i2, i3));
        }

        private void calculateBaselineAndResizeBehavior() {
            int baseline;
            this.prefAscent = 0;
            this.prefDescent = 0;
            int i2 = 0;
            int i3 = 0;
            for (int size = this.springs.size() - 1; size >= 0; size--) {
                Spring spring = getSpring(size);
                if ((spring.getAlignment() == 0 || spring.getAlignment() == 3) && (baseline = spring.getBaseline()) >= 0) {
                    if (spring.isResizable(2)) {
                        int baselineResizeBehavior = spring.getBaselineResizeBehavior();
                        if (i3 == 0) {
                            i3 = baselineResizeBehavior;
                        } else if (baselineResizeBehavior != i3) {
                            i3 = 1;
                        }
                    }
                    this.prefAscent = Math.max(this.prefAscent, baseline);
                    this.prefDescent = Math.max(this.prefDescent, spring.getPreferredSize(2) - baseline);
                    i2++;
                }
            }
            if (!this.baselineAnchorSet) {
                if (i3 == 2) {
                    this.baselineAnchoredToTop = false;
                } else {
                    this.baselineAnchoredToTop = true;
                }
            }
            this.allSpringsHaveBaseline = i2 == this.springs.size();
            this.calcedBaseline = true;
        }

        private int calculateMaxSize() {
            int baseline;
            int i2 = this.prefAscent;
            int i3 = this.prefDescent;
            int i4 = 0;
            for (int size = this.springs.size() - 1; size >= 0; size--) {
                Spring spring = getSpring(size);
                int maximumSize = spring.getMaximumSize(2);
                if ((spring.getAlignment() == 0 || spring.getAlignment() == 3) && (baseline = spring.getBaseline()) >= 0) {
                    int preferredSize = spring.getPreferredSize(2);
                    if (preferredSize != maximumSize) {
                        switch (spring.getBaselineResizeBehavior()) {
                            case 1:
                                if (this.baselineAnchoredToTop) {
                                    i3 = Math.max(i3, maximumSize - baseline);
                                    break;
                                } else {
                                    continue;
                                }
                            case 2:
                                if (!this.baselineAnchoredToTop) {
                                    i2 = Math.max(i2, (maximumSize - preferredSize) + baseline);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                } else {
                    i4 = Math.max(i4, maximumSize);
                }
            }
            return Math.max(i4, i2 + i3);
        }

        private int calculateMinSize() {
            int baseline;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            if (this.baselineAnchoredToTop) {
                i2 = this.prefAscent;
            } else {
                i3 = this.prefDescent;
            }
            for (int size = this.springs.size() - 1; size >= 0; size--) {
                Spring spring = getSpring(size);
                int minimumSize = spring.getMinimumSize(2);
                if ((spring.getAlignment() == 0 || spring.getAlignment() == 3) && (baseline = spring.getBaseline()) >= 0) {
                    int preferredSize = spring.getPreferredSize(2);
                    switch (spring.getBaselineResizeBehavior()) {
                        case 1:
                            if (this.baselineAnchoredToTop) {
                                i3 = Math.max(minimumSize - baseline, i3);
                                continue;
                            } else {
                                i2 = Math.max(baseline, i2);
                                break;
                            }
                        case 2:
                            if (!this.baselineAnchoredToTop) {
                                i2 = Math.max(baseline - (preferredSize - minimumSize), i2);
                                continue;
                            } else {
                                i3 = Math.max(preferredSize - baseline, i3);
                                break;
                            }
                        default:
                            i2 = Math.max(baseline, i2);
                            i3 = Math.max(preferredSize - baseline, i3);
                            continue;
                    }
                } else {
                    i4 = Math.max(i4, minimumSize);
                }
            }
            return Math.max(i4, i2 + i3);
        }

        private void baselineLayout(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            if (this.baselineAnchoredToTop) {
                i4 = this.prefAscent;
                i5 = i3 - i4;
            } else {
                i4 = i3 - this.prefDescent;
                i5 = this.prefDescent;
            }
            for (int size = this.springs.size() - 1; size >= 0; size--) {
                Spring spring = getSpring(size);
                int alignment = spring.getAlignment();
                if (alignment == 0 || alignment == 3) {
                    int baseline = spring.getBaseline();
                    if (baseline >= 0) {
                        int maximumSize = spring.getMaximumSize(2);
                        int preferredSize = spring.getPreferredSize(2);
                        int i7 = preferredSize;
                        switch (spring.getBaselineResizeBehavior()) {
                            case 1:
                                i6 = (i2 + i4) - baseline;
                                i7 = Math.min(i5, maximumSize - baseline) + baseline;
                                break;
                            case 2:
                                i7 = Math.min(i4, (maximumSize - preferredSize) + baseline) + (preferredSize - baseline);
                                i6 = ((i2 + i4) + (preferredSize - baseline)) - i7;
                                break;
                            default:
                                i6 = (i2 + i4) - baseline;
                                break;
                        }
                        spring.setSize(2, i6, i7);
                    } else {
                        setChildSize(spring, 2, i2, i3);
                    }
                } else {
                    setChildSize(spring, 2, i2, i3);
                }
            }
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int getBaseline() {
            if (this.springs.size() > 1) {
                getPreferredSize(2);
                return this.prefAscent;
            } else if (this.springs.size() == 1) {
                return getSpring(0).getBaseline();
            } else {
                return -1;
            }
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int getBaselineResizeBehavior() {
            if (this.springs.size() == 1) {
                return getSpring(0).getBaselineResizeBehavior();
            }
            if (this.baselineAnchoredToTop) {
                return 1;
            }
            return 2;
        }

        private void checkAxis(int i2) {
            if (i2 == 1) {
                throw new IllegalStateException("Baseline must be used along vertical axis");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$ComponentSpring.class */
    public final class ComponentSpring extends Spring {
        private Component component;
        private int origin;
        private final int min;
        private final int pref;
        private final int max;
        private int baseline;
        private boolean installed;
        static final boolean $assertionsDisabled;
        private final GroupLayout this$0;

        ComponentSpring(GroupLayout groupLayout, Component component, int i2, int i3, int i4, AnonymousClass1 anonymousClass1) {
            this(groupLayout, component, i2, i3, i4);
        }

        static {
            Class cls;
            if (GroupLayout.class$org$jdesktop$layout$GroupLayout == null) {
                cls = GroupLayout.class$("org.jdesktop.layout.GroupLayout");
                GroupLayout.class$org$jdesktop$layout$GroupLayout = cls;
            } else {
                cls = GroupLayout.class$org$jdesktop$layout$GroupLayout;
            }
            $assertionsDisabled = !cls.desiredAssertionStatus();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private ComponentSpring(GroupLayout groupLayout, Component component, int i2, int i3, int i4) {
            super(groupLayout);
            this.this$0 = groupLayout;
            this.baseline = -1;
            this.component = component;
            if (component != null) {
                GroupLayout.checkSize(i2, i3, i4, true);
                this.min = i2;
                this.max = i4;
                this.pref = i3;
                groupLayout.getComponentInfo(component);
                return;
            }
            throw new IllegalArgumentException("Component must be non-null");
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculateMinimumSize(int i2) {
            if (isLinked(i2)) {
                return getLinkSize(i2, 0);
            }
            return calculateNonlinkedMinimumSize(i2);
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculatePreferredSize(int i2) {
            if (isLinked(i2)) {
                return getLinkSize(i2, 1);
            }
            return Math.min(getMaximumSize(i2), Math.max(getMinimumSize(i2), calculateNonlinkedPreferredSize(i2)));
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculateMaximumSize(int i2) {
            if (isLinked(i2)) {
                return getLinkSize(i2, 2);
            }
            return Math.max(getMinimumSize(i2), calculateNonlinkedMaximumSize(i2));
        }

        boolean isVisible() {
            return this.this$0.getComponentInfo(getComponent()).isVisible();
        }

        int calculateNonlinkedMinimumSize(int i2) {
            if (!isVisible()) {
                return 0;
            }
            if (this.min >= 0) {
                return this.min;
            }
            if (this.min == -2) {
                return calculateNonlinkedPreferredSize(i2);
            }
            if ($assertionsDisabled || this.min == -1) {
                return getSizeAlongAxis(i2, this.component.getMinimumSize());
            }
            throw new AssertionError();
        }

        int calculateNonlinkedPreferredSize(int i2) {
            if (!isVisible()) {
                return 0;
            }
            if (this.pref >= 0) {
                return this.pref;
            }
            if ($assertionsDisabled || this.pref == -1 || this.pref == -2) {
                return getSizeAlongAxis(i2, this.component.getPreferredSize());
            }
            throw new AssertionError();
        }

        int calculateNonlinkedMaximumSize(int i2) {
            if (!isVisible()) {
                return 0;
            }
            if (this.max >= 0) {
                return this.max;
            }
            if (this.max == -2) {
                return calculateNonlinkedPreferredSize(i2);
            }
            if ($assertionsDisabled || this.max == -1) {
                return getSizeAlongAxis(i2, this.component.getMaximumSize());
            }
            throw new AssertionError();
        }

        private int getSizeAlongAxis(int i2, Dimension dimension) {
            return i2 == 1 ? dimension.width : dimension.height;
        }

        private int getLinkSize(int i2, int i3) {
            if (!isVisible()) {
                return 0;
            }
            return this.this$0.getComponentInfo(this.component).getLinkSize(i2, i3);
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        void setSize(int i2, int i3, int i4) {
            super.setSize(i2, i3, i4);
            this.origin = i3;
            if (i4 == GroupLayout.UNSET) {
                this.baseline = -1;
            }
        }

        int getOrigin() {
            return this.origin;
        }

        void setComponent(Component component) {
            this.component = component;
        }

        Component getComponent() {
            return this.component;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int getBaseline() {
            if (this.baseline == -1 && (this.component instanceof JComponent)) {
                int preferredSize = this.this$0.getComponentInfo(this.component).horizontalSpring.getPreferredSize(1);
                int preferredSize2 = getPreferredSize(2);
                if (preferredSize > 0 && preferredSize2 > 0) {
                    this.baseline = Baseline.getBaseline(this.component, preferredSize, getPreferredSize(2));
                }
            }
            return this.baseline;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int getBaselineResizeBehavior() {
            return Baseline.getBaselineResizeBehavior(getComponent());
        }

        private boolean isLinked(int i2) {
            return this.this$0.getComponentInfo(this.component).isLinked(i2);
        }

        void installIfNecessary(int i2) {
            if (!this.installed) {
                this.installed = true;
                if (i2 == 1) {
                    this.this$0.getComponentInfo(this.component).horizontalSpring = this;
                } else {
                    this.this$0.getComponentInfo(this.component).verticalSpring = this;
                }
            }
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        boolean willHaveZeroSize(boolean z) {
            return !isVisible();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$PaddingSpring.class */
    public final class PaddingSpring extends Spring {
        private final JComponent source;
        private final JComponent target;
        private final int type;
        private final boolean canGrow;
        private final GroupLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        PaddingSpring(GroupLayout groupLayout, JComponent jComponent, JComponent jComponent2, int i2, boolean z) {
            super(groupLayout);
            this.this$0 = groupLayout;
            this.source = jComponent;
            this.target = jComponent2;
            this.type = i2;
            this.canGrow = z;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculateMinimumSize(int i2) {
            return getPadding(i2);
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculatePreferredSize(int i2) {
            return getPadding(i2);
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculateMaximumSize(int i2) {
            if (this.canGrow) {
                return 32767;
            }
            return getPadding(i2);
        }

        private int getPadding(int i2) {
            int i3;
            if (i2 == 1) {
                i3 = 3;
            } else {
                i3 = 5;
            }
            return this.this$0.getLayoutStyle0().getPreferredGap(this.source, this.target, this.type, i3, this.this$0.host);
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        boolean willHaveZeroSize(boolean z) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$GapSpring.class */
    public final class GapSpring extends Spring {
        private final int min;
        private final int pref;
        private final int max;
        private final GroupLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        GapSpring(GroupLayout groupLayout, int i2, int i3, int i4) {
            super(groupLayout);
            this.this$0 = groupLayout;
            GroupLayout.checkSize(i2, i3, i4, false);
            this.min = i2;
            this.pref = i3;
            this.max = i4;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculateMinimumSize(int i2) {
            if (this.min == -2) {
                return getPreferredSize(i2);
            }
            return this.min;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculatePreferredSize(int i2) {
            return this.pref;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculateMaximumSize(int i2) {
            if (this.max == -2) {
                return getPreferredSize(i2);
            }
            return this.max;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        boolean willHaveZeroSize(boolean z) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$AutopaddingSpring.class */
    public class AutopaddingSpring extends Spring {
        List sources;
        ComponentSpring source;
        private List matches;
        int size;
        int lastSize;
        private final int pref;
        private final int max;
        private int type;
        private boolean userCreated;
        private final GroupLayout this$0;

        AutopaddingSpring(GroupLayout groupLayout, AnonymousClass1 anonymousClass1) {
            this(groupLayout);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private AutopaddingSpring(GroupLayout groupLayout) {
            super(groupLayout);
            this.this$0 = groupLayout;
            this.pref = -2;
            this.max = -2;
            this.type = 0;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AutopaddingSpring(GroupLayout groupLayout, int i2, int i3) {
            super(groupLayout);
            this.this$0 = groupLayout;
            this.pref = i2;
            this.max = i3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AutopaddingSpring(GroupLayout groupLayout, int i2, int i3, int i4) {
            super(groupLayout);
            this.this$0 = groupLayout;
            this.type = i2;
            this.pref = i3;
            this.max = i4;
            this.userCreated = true;
        }

        public void setSource(ComponentSpring componentSpring) {
            this.source = componentSpring;
        }

        public void setSources(List list) {
            this.sources = new ArrayList(list);
        }

        public void setUserCreated(boolean z) {
            this.userCreated = z;
        }

        public boolean getUserCreated() {
            return this.userCreated;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        void unset() {
            this.lastSize = getSize();
            super.unset();
            this.size = 0;
        }

        public void reset() {
            this.size = 0;
            this.sources = null;
            this.source = null;
            this.matches = null;
        }

        public void calculatePadding(int i2) {
            int i3;
            this.size = GroupLayout.UNSET;
            int i4 = GroupLayout.UNSET;
            if (this.matches != null) {
                LayoutStyle layoutStyle0 = this.this$0.getLayoutStyle0();
                if (i2 == 1) {
                    if (this.this$0.isLeftToRight()) {
                        i3 = 3;
                    } else {
                        i3 = 7;
                    }
                } else {
                    i3 = 5;
                }
                for (int size = this.matches.size() - 1; size >= 0; size--) {
                    AutopaddingMatch autopaddingMatch = (AutopaddingMatch) this.matches.get(size);
                    i4 = Math.max(i4, calculatePadding(layoutStyle0, i3, autopaddingMatch.source, autopaddingMatch.target));
                }
            }
            if (this.size == GroupLayout.UNSET) {
                this.size = 0;
            }
            if (i4 == GroupLayout.UNSET) {
                i4 = 0;
            }
            if (this.lastSize != GroupLayout.UNSET) {
                this.size += Math.min(i4, this.lastSize);
            }
        }

        private int calculatePadding(LayoutStyle layoutStyle, int i2, ComponentSpring componentSpring, ComponentSpring componentSpring2) {
            int i3;
            int origin = componentSpring2.getOrigin() - (componentSpring.getOrigin() + componentSpring.getSize());
            if (origin >= 0) {
                if ((componentSpring.getComponent() instanceof JComponent) && (componentSpring2.getComponent() instanceof JComponent)) {
                    i3 = layoutStyle.getPreferredGap((JComponent) componentSpring.getComponent(), (JComponent) componentSpring2.getComponent(), this.type, i2, this.this$0.host);
                } else {
                    i3 = 10;
                }
                if (i3 > origin) {
                    this.size = Math.max(this.size, i3 - origin);
                }
                return i3;
            }
            return 0;
        }

        public void addTarget(ComponentSpring componentSpring, int i2) {
            int i3 = i2 == 1 ? 2 : 1;
            if (this.source != null) {
                if (this.this$0.areParallelSiblings(this.source.getComponent(), componentSpring.getComponent(), i3)) {
                    addValidTarget(this.source, componentSpring);
                    return;
                }
                return;
            }
            Component component = componentSpring.getComponent();
            for (int size = this.sources.size() - 1; size >= 0; size--) {
                ComponentSpring componentSpring2 = (ComponentSpring) this.sources.get(size);
                if (this.this$0.areParallelSiblings(componentSpring2.getComponent(), component, i3)) {
                    addValidTarget(componentSpring2, componentSpring);
                }
            }
        }

        private void addValidTarget(ComponentSpring componentSpring, ComponentSpring componentSpring2) {
            if (this.matches == null) {
                this.matches = new ArrayList(1);
            }
            this.matches.add(new AutopaddingMatch(componentSpring, componentSpring2));
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculateMinimumSize(int i2) {
            return this.size;
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculatePreferredSize(int i2) {
            if (this.pref == -2 || this.pref == -1) {
                return this.size;
            }
            return Math.max(this.size, this.pref);
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        int calculateMaximumSize(int i2) {
            if (this.max >= 0) {
                return Math.max(getPreferredSize(i2), this.max);
            }
            return this.size;
        }

        String getMatchDescription() {
            return this.matches == null ? "" : this.matches.toString();
        }

        public String toString() {
            return new StringBuffer().append(super.toString()).append(getMatchDescription()).toString();
        }

        @Override // org.jdesktop.layout.GroupLayout.Spring
        boolean willHaveZeroSize(boolean z) {
            return z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$AutopaddingMatch.class */
    public static final class AutopaddingMatch {
        public final ComponentSpring source;
        public final ComponentSpring target;

        AutopaddingMatch(ComponentSpring componentSpring, ComponentSpring componentSpring2) {
            this.source = componentSpring;
            this.target = componentSpring2;
        }

        private String toString(ComponentSpring componentSpring) {
            return componentSpring.getComponent().getName();
        }

        public String toString() {
            return new StringBuffer().append("[").append(toString(this.source)).append("-").append(toString(this.target)).append("]").toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$ContainerAutopaddingSpring.class */
    public class ContainerAutopaddingSpring extends AutopaddingSpring {
        private List targets;
        private final GroupLayout this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        ContainerAutopaddingSpring(GroupLayout groupLayout) {
            super(groupLayout, null);
            this.this$0 = groupLayout;
            setUserCreated(true);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        ContainerAutopaddingSpring(GroupLayout groupLayout, int i2, int i3) {
            super(groupLayout, i2, i3);
            this.this$0 = groupLayout;
            setUserCreated(true);
        }

        @Override // org.jdesktop.layout.GroupLayout.AutopaddingSpring
        public void addTarget(ComponentSpring componentSpring, int i2) {
            if (this.targets == null) {
                this.targets = new ArrayList(1);
            }
            this.targets.add(componentSpring);
        }

        @Override // org.jdesktop.layout.GroupLayout.AutopaddingSpring
        public void calculatePadding(int i2) {
            int i3;
            int i4;
            LayoutStyle layoutStyle0 = this.this$0.getLayoutStyle0();
            int i5 = 0;
            this.size = 0;
            if (this.targets != null) {
                if (i2 == 1) {
                    if (this.this$0.isLeftToRight()) {
                        i4 = 7;
                    } else {
                        i4 = 3;
                    }
                } else {
                    i4 = 5;
                }
                for (int size = this.targets.size() - 1; size >= 0; size--) {
                    ComponentSpring componentSpring = (ComponentSpring) this.targets.get(size);
                    int i6 = 10;
                    if (componentSpring.getComponent() instanceof JComponent) {
                        int containerGap = layoutStyle0.getContainerGap((JComponent) componentSpring.getComponent(), i4, this.this$0.host);
                        i5 = Math.max(containerGap, i5);
                        i6 = containerGap - componentSpring.getOrigin();
                    } else {
                        i5 = Math.max(10, i5);
                    }
                    this.size = Math.max(this.size, i6);
                }
            } else {
                if (i2 == 1) {
                    if (this.this$0.isLeftToRight()) {
                        i3 = 3;
                    } else {
                        i3 = 7;
                    }
                } else {
                    i3 = 5;
                }
                if (this.sources != null) {
                    for (int size2 = this.sources.size() - 1; size2 >= 0; size2--) {
                        i5 = Math.max(i5, updateSize(layoutStyle0, (ComponentSpring) this.sources.get(size2), i3));
                    }
                } else if (this.source != null) {
                    i5 = updateSize(layoutStyle0, this.source, i3);
                }
            }
            if (this.lastSize != GroupLayout.UNSET) {
                this.size += Math.min(i5, this.lastSize);
            }
        }

        private int updateSize(LayoutStyle layoutStyle, ComponentSpring componentSpring, int i2) {
            int i3 = 10;
            if (componentSpring.getComponent() instanceof JComponent) {
                i3 = layoutStyle.getContainerGap((JComponent) componentSpring.getComponent(), i2, this.this$0.host);
            }
            this.size = Math.max(this.size, i3 - Math.max(0, (getParent().getSize() - componentSpring.getSize()) - componentSpring.getOrigin()));
            return i3;
        }

        @Override // org.jdesktop.layout.GroupLayout.AutopaddingSpring
        String getMatchDescription() {
            if (this.targets != null) {
                return new StringBuffer().append("leading: ").append(this.targets.toString()).toString();
            }
            if (this.sources != null) {
                return new StringBuffer().append("trailing: ").append(this.sources.toString()).toString();
            }
            return "--";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$LinkInfo.class */
    public static final class LinkInfo {
        private final int axis;
        private final List linked = new ArrayList();
        private int size = GroupLayout.UNSET;
        static final boolean $assertionsDisabled;

        static {
            Class cls;
            if (GroupLayout.class$org$jdesktop$layout$GroupLayout == null) {
                cls = GroupLayout.class$("org.jdesktop.layout.GroupLayout");
                GroupLayout.class$org$jdesktop$layout$GroupLayout = cls;
            } else {
                cls = GroupLayout.class$org$jdesktop$layout$GroupLayout;
            }
            $assertionsDisabled = !cls.desiredAssertionStatus();
        }

        LinkInfo(int i2) {
            this.axis = i2;
        }

        public void add(ComponentInfo componentInfo) {
            LinkInfo linkInfo = componentInfo.getLinkInfo(this.axis, false);
            if (linkInfo == null) {
                this.linked.add(componentInfo);
                componentInfo.setLinkInfo(this.axis, this);
            } else if (linkInfo != this) {
                this.linked.addAll(linkInfo.linked);
                for (int i2 = 0; i2 < linkInfo.linked.size(); i2++) {
                    ((ComponentInfo) linkInfo.linked.get(i2)).setLinkInfo(this.axis, this);
                }
            }
            clearCachedSize();
        }

        public void remove(ComponentInfo componentInfo) {
            this.linked.remove(componentInfo);
            componentInfo.setLinkInfo(this.axis, null);
            if (this.linked.size() == 1) {
                ((ComponentInfo) this.linked.get(0)).setLinkInfo(this.axis, null);
            }
            clearCachedSize();
        }

        public void clearCachedSize() {
            this.size = GroupLayout.UNSET;
        }

        public int getSize(int i2) {
            if (this.size == GroupLayout.UNSET) {
                this.size = calculateLinkedSize(i2);
            }
            return this.size;
        }

        private int calculateLinkedSize(int i2) {
            ComponentSpring componentSpring;
            int i3 = 0;
            for (int i4 = 0; i4 < this.linked.size(); i4++) {
                ComponentInfo componentInfo = (ComponentInfo) this.linked.get(i4);
                if (i2 == 1) {
                    componentSpring = componentInfo.horizontalSpring;
                } else if (!$assertionsDisabled && i2 != 2) {
                    throw new AssertionError();
                } else {
                    componentSpring = componentInfo.verticalSpring;
                }
                i3 = Math.max(i3, componentSpring.calculateNonlinkedPreferredSize(i2));
            }
            return i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: hfsexplorer-0_21-src.zip:dist/lib/swing-layout-1.0.3.jar:org/jdesktop/layout/GroupLayout$ComponentInfo.class */
    public final class ComponentInfo {
        private Component component;
        ComponentSpring horizontalSpring;
        ComponentSpring verticalSpring;
        private LinkInfo horizontalMaster;
        private LinkInfo verticalMaster;
        private boolean visible;
        private Boolean honorsVisibility;
        static final boolean $assertionsDisabled;
        private final GroupLayout this$0;

        static {
            Class cls;
            if (GroupLayout.class$org$jdesktop$layout$GroupLayout == null) {
                cls = GroupLayout.class$("org.jdesktop.layout.GroupLayout");
                GroupLayout.class$org$jdesktop$layout$GroupLayout = cls;
            } else {
                cls = GroupLayout.class$org$jdesktop$layout$GroupLayout;
            }
            $assertionsDisabled = !cls.desiredAssertionStatus();
        }

        ComponentInfo(GroupLayout groupLayout, Component component) {
            this.this$0 = groupLayout;
            this.component = component;
            updateVisibility();
        }

        public void dispose() {
            removeSpring(this.horizontalSpring);
            this.horizontalSpring = null;
            removeSpring(this.verticalSpring);
            this.verticalSpring = null;
            if (this.horizontalMaster != null) {
                this.horizontalMaster.remove(this);
            }
            if (this.verticalMaster != null) {
                this.verticalMaster.remove(this);
            }
        }

        void setHonorsVisibility(Boolean bool) {
            this.honorsVisibility = bool;
        }

        private void removeSpring(Spring spring) {
            if (spring != null) {
                ((Group) spring.getParent()).springs.remove(spring);
            }
        }

        public boolean isVisible() {
            return this.visible;
        }

        boolean updateVisibility() {
            boolean booleanValue;
            if (this.honorsVisibility == null) {
                booleanValue = this.this$0.getHonorsVisibility();
            } else {
                booleanValue = this.honorsVisibility.booleanValue();
            }
            boolean isVisible = booleanValue ? this.component.isVisible() : true;
            if (this.visible != isVisible) {
                this.visible = isVisible;
                return true;
            }
            return false;
        }

        public void setBounds(Insets insets, int i2, boolean z) {
            int origin = this.horizontalSpring.getOrigin();
            int size = this.horizontalSpring.getSize();
            int origin2 = this.verticalSpring.getOrigin();
            int size2 = this.verticalSpring.getSize();
            if (!z) {
                origin = (i2 - origin) - size;
            }
            this.component.setBounds(origin + insets.left, origin2 + insets.top, size, size2);
        }

        public void setComponent(Component component) {
            this.component = component;
            if (this.horizontalSpring != null) {
                this.horizontalSpring.setComponent(component);
            }
            if (this.verticalSpring != null) {
                this.verticalSpring.setComponent(component);
            }
        }

        public Component getComponent() {
            return this.component;
        }

        public boolean isLinked(int i2) {
            if (i2 == 1) {
                return this.horizontalMaster != null;
            } else if ($assertionsDisabled || i2 == 2) {
                return this.verticalMaster != null;
            } else {
                throw new AssertionError();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLinkInfo(int i2, LinkInfo linkInfo) {
            if (i2 == 1) {
                this.horizontalMaster = linkInfo;
            } else if (!$assertionsDisabled && i2 != 2) {
                throw new AssertionError();
            } else {
                this.verticalMaster = linkInfo;
            }
        }

        public LinkInfo getLinkInfo(int i2) {
            return getLinkInfo(i2, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public LinkInfo getLinkInfo(int i2, boolean z) {
            if (i2 == 1) {
                if (this.horizontalMaster == null && z) {
                    new LinkInfo(1).add(this);
                }
                return this.horizontalMaster;
            } else if ($assertionsDisabled || i2 == 2) {
                if (this.verticalMaster == null && z) {
                    new LinkInfo(2).add(this);
                }
                return this.verticalMaster;
            } else {
                throw new AssertionError();
            }
        }

        public void clearCachedSize() {
            if (this.horizontalMaster != null) {
                this.horizontalMaster.clearCachedSize();
            }
            if (this.verticalMaster != null) {
                this.verticalMaster.clearCachedSize();
            }
        }

        int getLinkSize(int i2, int i3) {
            if (i2 == 1) {
                return this.horizontalMaster.getSize(i2);
            }
            if ($assertionsDisabled || i2 == 2) {
                return this.verticalMaster.getSize(i2);
            }
            throw new AssertionError();
        }
    }
}
