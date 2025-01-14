package org.catacombae.jparted.lib.fs.hfscommon;

import org.catacombae.hfsexplorer.IOUtil;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileRecord;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.fs.FSAttributes;
import org.catacombae.jparted.lib.fs.FSEntry;
import org.catacombae.jparted.lib.fs.FSLink;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFSLink.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFSLink.class */
public class HFSCommonFSLink extends FSLink {
    private final CommonHFSCatalogFileRecord linkRecord;
    private final HFSCommonFileSystemHandler fsHandler;

    public HFSCommonFSLink(HFSCommonFileSystemHandler fsHandler, CommonHFSCatalogFileRecord linkRecord) {
        super(fsHandler);
        this.fsHandler = fsHandler;
        this.linkRecord = linkRecord;
        if (!linkRecord.getData().isSymbolicLink()) {
            throw new IllegalArgumentException("linkRecord is no symbolic link!");
        }
    }

    public String getLinkTargetPosixPath() {
        ReadableRandomAccessStream linkDataStream = this.fsHandler.getReadableDataForkStream(this.linkRecord);
        byte[] linkBytes = IOUtil.readFully(linkDataStream);
        linkDataStream.close();
        return Util.readString(linkBytes, "UTF-8");
    }

    @Override // org.catacombae.jparted.lib.fs.FSLink
    public FSEntry getLinkTarget(String[] parentDir) {
        FSEntry res;
        String posixPath = getLinkTargetPosixPath();
        String[] targetPath = this.fsHandler.getTruePathFromPosixPath(posixPath, parentDir);
        if (targetPath != null) {
            res = this.fsHandler.getEntry(targetPath);
            if (res != null && (res instanceof FSLink)) {
                res = this.fsHandler.resolveLinks(targetPath, (FSLink) res);
                if (res == null) {
                    System.err.println("\ngetLinkTarget(): Could not resolve inner link \"" + Util.concatenateStrings(targetPath, "/") + "\"");
                }
            } else if (res == null) {
                System.err.println("\ngetLinkTarget(): Could not get entry for true path \"" + Util.concatenateStrings(targetPath, "/") + "\"");
            }
            if (res != null && (res instanceof FSLink)) {
                throw new RuntimeException("res still instanceof FSLink!");
            }
        } else {
            System.err.println("\ngetLinkTarget(): Could not get true path!");
            res = null;
        }
        if (res == null) {
            System.err.println("getLinkTarget(): FAILED to get entry by posix path for link " + this.linkRecord.getKey().getParentID().toLong() + ":\"" + this.fsHandler.getProperNodeName(this.linkRecord) + "\":");
            System.err.println("getLinkTarget():   posixPath=\"" + posixPath + "\"");
            System.err.println("getLinkTarget():   parentDir=\"" + Util.concatenateStrings(parentDir, "/") + "\"");
            System.err.println();
        }
        return res;
    }

    @Override // org.catacombae.jparted.lib.fs.FSEntry
    public FSAttributes getAttributes() {
        return new HFSCommonFSAttributes(this, this.linkRecord.getData());
    }

    @Override // org.catacombae.jparted.lib.fs.FSEntry
    public String getName() {
        return this.fsHandler.getProperNodeName(this.linkRecord);
    }

    public CommonHFSCatalogFileRecord getInternalCatalogFileRecord() {
        return this.linkRecord;
    }

    @Override // org.catacombae.jparted.lib.fs.FSLink
    public String getLinkTargetString() {
        return getLinkTargetPosixPath();
    }
}
