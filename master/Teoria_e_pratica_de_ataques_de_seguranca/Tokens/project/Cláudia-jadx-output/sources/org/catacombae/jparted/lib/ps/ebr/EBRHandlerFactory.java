package org.catacombae.jparted.lib.ps.ebr;

import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.ps.PartitionSystemHandler;
import org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory;
import org.catacombae.jparted.lib.ps.PartitionSystemImplementationInfo;
import org.catacombae.jparted.lib.ps.PartitionSystemRecognizer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/ebr/EBRHandlerFactory.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/ebr/EBRHandlerFactory.class */
public class EBRHandlerFactory extends PartitionSystemHandlerFactory {
    private static final EBRRecognizer recognizer = new EBRRecognizer();

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemHandler createHandler(DataLocator data) {
        return new EBRHandler(data);
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemImplementationInfo getInfo() {
        return new PartitionSystemImplementationInfo("Extended Boot Record", "Catacombae EBR PS Handler", "1.0", "Catacombae");
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemRecognizer getRecognizer() {
        return recognizer;
    }
}
