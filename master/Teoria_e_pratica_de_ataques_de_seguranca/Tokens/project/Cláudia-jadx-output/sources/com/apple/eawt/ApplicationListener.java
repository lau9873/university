package com.apple.eawt;

import java.util.EventListener;
/* loaded from: hfsexplorer-0_21-src.zip:lib/AppleJavaExtensions.jar:com/apple/eawt/ApplicationListener.class */
public interface ApplicationListener extends EventListener {
    void handleAbout(ApplicationEvent applicationEvent);

    void handleOpenApplication(ApplicationEvent applicationEvent);

    void handleReOpenApplication(ApplicationEvent applicationEvent);

    void handleOpenFile(ApplicationEvent applicationEvent);

    void handlePreferences(ApplicationEvent applicationEvent);

    void handlePrintFile(ApplicationEvent applicationEvent);

    void handleQuit(ApplicationEvent applicationEvent);
}
