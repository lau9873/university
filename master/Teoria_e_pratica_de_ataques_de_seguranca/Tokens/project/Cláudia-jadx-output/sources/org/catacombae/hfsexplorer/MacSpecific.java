package org.catacombae.hfsexplorer;

import com.apple.eawt.Application;
import com.apple.eawt.ApplicationAdapter;
import com.apple.eawt.ApplicationEvent;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/MacSpecific.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/MacSpecific.class */
public class MacSpecific {

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/MacSpecific$MacApplicationHandler.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/MacSpecific$MacApplicationHandler.class */
    public interface MacApplicationHandler {
        boolean acceptQuit();

        void showAboutDialog();
    }

    public static void registerMacApplicationHandler(final MacApplicationHandler qh) {
        Application thisApplication = Application.getApplication();
        thisApplication.addApplicationListener(new ApplicationAdapter() { // from class: org.catacombae.hfsexplorer.MacSpecific.1
            @Override // com.apple.eawt.ApplicationAdapter, com.apple.eawt.ApplicationListener
            public void handleQuit(ApplicationEvent ae) {
                if (MacApplicationHandler.this.acceptQuit()) {
                    ae.setHandled(true);
                } else {
                    ae.setHandled(false);
                }
            }

            @Override // com.apple.eawt.ApplicationAdapter, com.apple.eawt.ApplicationListener
            public void handleAbout(ApplicationEvent event) {
                MacApplicationHandler.this.showAboutDialog();
                event.setHandled(true);
            }
        });
    }
}
