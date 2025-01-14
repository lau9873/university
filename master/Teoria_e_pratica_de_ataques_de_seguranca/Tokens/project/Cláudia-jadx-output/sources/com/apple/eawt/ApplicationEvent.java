package com.apple.eawt;

import java.util.EventObject;
/* loaded from: hfsexplorer-0_21-src.zip:lib/AppleJavaExtensions.jar:com/apple/eawt/ApplicationEvent.class */
public class ApplicationEvent extends EventObject {
    ApplicationEvent(Object obj) {
        super(obj);
    }

    ApplicationEvent(Object obj, String str) {
        super(obj);
    }

    public boolean isHandled() {
        return false;
    }

    public void setHandled(boolean z) {
    }

    public String getFilename() {
        return null;
    }
}
