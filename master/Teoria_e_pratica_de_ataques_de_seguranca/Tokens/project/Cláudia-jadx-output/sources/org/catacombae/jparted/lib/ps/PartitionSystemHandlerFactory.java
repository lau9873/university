package org.catacombae.jparted.lib.ps;

import org.catacombae.jparted.lib.DataLocator;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemHandlerFactory.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/ps/PartitionSystemHandlerFactory.class */
public abstract class PartitionSystemHandlerFactory {
    public abstract PartitionSystemRecognizer getRecognizer();

    public abstract PartitionSystemHandler createHandler(DataLocator dataLocator);

    public abstract PartitionSystemImplementationInfo getInfo();
}
