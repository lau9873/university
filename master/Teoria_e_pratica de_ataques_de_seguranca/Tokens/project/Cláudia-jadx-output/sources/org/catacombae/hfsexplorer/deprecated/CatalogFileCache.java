package org.catacombae.hfsexplorer.deprecated;

import java.util.HashMap;
import org.catacombae.hfsexplorer.types.hfsplus.BTNode;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/deprecated/CatalogFileCache.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/deprecated/CatalogFileCache.class */
class CatalogFileCache {
    private HashMap<Integer, BTNode> cacheMap = new HashMap<>();

    CatalogFileCache() {
    }

    public void put(int nodeNumber, BTNode node) {
        this.cacheMap.put(Integer.valueOf(nodeNumber), node);
    }

    public BTNode get(int nodeNumber) {
        return this.cacheMap.get(Integer.valueOf(nodeNumber));
    }
}
