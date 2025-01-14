package org.catacombae.jparted.lib.ps.gpt;

import org.catacombae.jparted.lib.DataLocator;
import org.catacombae.jparted.lib.ps.PartitionSystemHandler;
import org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory;
import org.catacombae.jparted.lib.ps.PartitionSystemImplementationInfo;
import org.catacombae.jparted.lib.ps.PartitionSystemRecognizer;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/gpt/GPTHandlerFactory.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/gpt/GPTHandlerFactory.class */
public class GPTHandlerFactory extends PartitionSystemHandlerFactory {
    private static final GPTRecognizer recognizer = new GPTRecognizer();

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemHandler createHandler(DataLocator data) {
        return new GPTHandler(data);
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemImplementationInfo getInfo() {
        return new PartitionSystemImplementationInfo("GUID Partition Table", "Catacombae GPT PS Handler", "1.0", "Catacombae");
    }

    @Override // org.catacombae.jparted.lib.ps.PartitionSystemHandlerFactory
    public PartitionSystemRecognizer getRecognizer() {
        return recognizer;
    }
}
