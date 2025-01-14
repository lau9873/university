package org.catacombae.hfsexplorer.types.hfscommon;

import org.catacombae.hfsexplorer.types.hfscommon.CommonBTKey;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTNode;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTIndexNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTIndexNode.class */
public abstract class CommonBTIndexNode<K extends CommonBTKey<K>> extends CommonBTNode<CommonBTIndexRecord<K>> {
    /* JADX INFO: Access modifiers changed from: protected */
    public CommonBTIndexNode(byte[] data, int offset, int nodeSize, CommonBTNode.FSType type) {
        super(data, offset, nodeSize, type);
    }
}
