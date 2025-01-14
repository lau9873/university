package org.catacombae.jparted.lib.ps.apm;

import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.ps.PartitionSystemHandler;
import org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory;
import org.catacombae.jparted.lib.ps.PartitionSystemImplementationInfo;
import org.catacombae.jparted.lib.ps.PartitionSystemRecognizer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/apm/APMHandlerFactory.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/apm/APMHandlerFactory.class */
public class APMHandlerFactory extends PartitionSystemHandlerFactory {
    private static final APMRecognizer recognizer = new APMRecognizer();

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemHandler createHandler(DataLocator partitionData) {
        return new APMHandler(partitionData);
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemImplementationInfo getInfo() {
        return new PartitionSystemImplementationInfo("Apple Partition Map", "Catacombae APM PS Handler", "1.0", "Catacombae");
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemRecognizer getRecognizer() {
        return recognizer;
    }
}
