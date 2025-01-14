package org.catacombae.jparted.lib.ps.mbr;

import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.ps.PartitionSystemHandler;
import org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory;
import org.catacombae.jparted.lib.ps.PartitionSystemImplementationInfo;
import org.catacombae.jparted.lib.ps.PartitionSystemRecognizer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/mbr/MBRHandlerFactory.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/mbr/MBRHandlerFactory.class */
public class MBRHandlerFactory extends PartitionSystemHandlerFactory {
    private static final MBRRecognizer recognizer = new MBRRecognizer();

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemHandler createHandler(DataLocator data) {
        return new MBRHandler(data);
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemImplementationInfo getInfo() {
        return new PartitionSystemImplementationInfo("Master Boot Record", "Catacombae MBR PS Handler", "1.0", "Catacombae");
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemRecognizer getRecognizer() {
        return recognizer;
    }
}
