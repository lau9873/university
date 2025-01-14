package com.apple.eawt;

import java.awt.Canvas;
import java.awt.Dimension;
/* loaded from: hfsexplorer-0_21-src.zip:lib/AppleJavaExtensions.jar:com/apple/eawt/CocoaComponent.class */
public abstract class CocoaComponent extends Canvas {
    public abstract int createNSView();

    public abstract Dimension getMaximumSize();

    public abstract Dimension getMinimumSize();

    public abstract Dimension getPreferredSize();

    public long createNSViewLong() {
        return 0L;
    }

    public final void sendMessage(int i2, Object obj) {
    }
}
