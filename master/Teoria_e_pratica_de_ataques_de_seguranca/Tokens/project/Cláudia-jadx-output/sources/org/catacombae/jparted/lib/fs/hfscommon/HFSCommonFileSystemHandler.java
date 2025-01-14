package org.catacombae.jparted.lib.fs.hfscommon;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import org.catacombae.hfsexplorer.IOUtil;
import org.catacombae.hfsexplorer.UnicodeNormalizationToolkit;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.fs.BaseHFSFileSystemView;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFileThreadRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThread;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogFolderThreadRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogLeafRecord;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSCatalogNodeID;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.jparted.lib.fs.FSEntry;
import org.catacombae.jparted.lib.fs.FSFolder;
import org.catacombae.jparted.lib.fs.FSForkType;
import org.catacombae.jparted.lib.fs.FSLink;
import org.catacombae.jparted.lib.fs.FileSystemHandler;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFileSystemHandler.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/hfscommon/HFSCommonFileSystemHandler.class */
public class HFSCommonFileSystemHandler extends FileSystemHandler {
    private static final String FILE_HARD_LINK_DIR = "��������HFS+ Private Data";
    private static final String FILE_HARD_LINK_PREFIX = "iNode";
    private static final String DIRECTORY_HARD_LINK_DIR = ".HFS+ Private Directory Data\r";
    private static final String DIRECTORY_HARD_LINK_PREFIX = "dir_";
    private BaseHFSFileSystemView view;
    private boolean doUnicodeFileNameComposition;

    /* JADX INFO: Access modifiers changed from: protected */
    public HFSCommonFileSystemHandler(BaseHFSFileSystemView iView, boolean iDoUnicodeFileNameComposition) {
        this.view = iView;
        this.doUnicodeFileNameComposition = iDoUnicodeFileNameComposition;
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandler
    public FSEntry[] list(String... path) {
        CommonHFSCatalogFolderRecord curFolder = this.view.getRoot();
        for (String nextFolderName : path) {
            CommonHFSCatalogLeafRecord subRecord = getRecord(curFolder, nextFolderName);
            if (subRecord != null && (subRecord instanceof CommonHFSCatalogFolderRecord)) {
                curFolder = (CommonHFSCatalogFolderRecord) subRecord;
            } else {
                return null;
            }
        }
        return listFSEntries(curFolder);
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandler
    public FSEntry getEntry(String... path) {
        return getEntry(this.view.getRoot(), path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FSEntry getEntry(CommonHFSCatalogFolderRecord rootRecord, String... path) {
        CommonHFSCatalogLeafRecord rec = getRecord(rootRecord, path);
        if (rec == null) {
            return null;
        }
        if (rec instanceof CommonHFSCatalogFileRecord) {
            return entryFromRecord((CommonHFSCatalogFileRecord) rec);
        }
        if (rec instanceof CommonHFSCatalogFolderRecord) {
            return entryFromRecord((CommonHFSCatalogFolderRecord) rec);
        }
        throw new RuntimeException("Did not excpect a " + rec.getClass() + " here!");
    }

    CommonHFSCatalogLeafRecord getRecord(CommonHFSCatalogFolderRecord rootRecord, String... path) {
        String[] absPath;
        if (rootRecord == null) {
            throw new IllegalArgumentException("rootRecord == null");
        }
        if (path == null) {
            throw new IllegalArgumentException("path == null");
        }
        LinkedList<String[]> visitedList = null;
        CommonHFSCatalogLeafRecord currentRoot = rootRecord;
        for (int i2 = 0; i2 < path.length; i2++) {
            String curPathComponent = path[i2];
            LinkedList<String[]> curVisitedList = null;
            while (currentRoot instanceof CommonHFSCatalogFileRecord) {
                CommonHFSCatalogFileRecord fr = (CommonHFSCatalogFileRecord) currentRoot;
                if (fr.getData().isSymbolicLink()) {
                    byte[] data = IOUtil.readFully(getReadableDataForkStream(fr));
                    String posixPath = Util.readString(data, "UTF-8");
                    String[] basePath = (String[]) Util.arrayCopy(path, 0, new String[i2 - 1], 0, i2 - 1);
                    absPath = getTruePathFromPosixPath(posixPath, basePath);
                    if (absPath == null) {
                        return null;
                    }
                } else if (!fr.getData().isHardFileLink()) {
                    if (!fr.getData().isHardDirectoryLink()) {
                        break;
                    }
                    absPath = new String[]{".HFS+ Private Directory Data\r", "dir_" + Util.unsign(fr.getData().getHardLinkInode())};
                } else {
                    absPath = new String[]{"��������HFS+ Private Data", "iNode" + Util.unsign(fr.getData().getHardLinkInode())};
                }
                if (curVisitedList == null) {
                    if (visitedList == null) {
                        visitedList = new LinkedList<>();
                    } else {
                        visitedList.clear();
                    }
                    curVisitedList = visitedList;
                }
                if (absPath == null) {
                    throw new RuntimeException("CHECK YOUR CODE FFS.");
                }
                if (Util.contains(curVisitedList, absPath)) {
                    System.err.println("WARNING: Detected cyclic link structure when resolving link target.");
                    System.err.println("         Resolve stack:");
                    Iterator i$ = curVisitedList.iterator();
                    while (i$.hasNext()) {
                        String[] sa = i$.next();
                        System.err.println("           " + Util.concatenateStrings(sa, "/"));
                    }
                    System.err.println("           " + Util.concatenateStrings(absPath, "/"));
                    return null;
                }
                curVisitedList.addLast(absPath);
                CommonHFSCatalogLeafRecord linkTarget = getRecord(this.view.getRoot(), absPath);
                if (linkTarget != null) {
                    currentRoot = linkTarget;
                }
            }
            if (currentRoot instanceof CommonHFSCatalogFolderRecord) {
                CommonHFSCatalogFolderRecord currentRootFolder = (CommonHFSCatalogFolderRecord) currentRoot;
                CommonHFSCatalogLeafRecord newRoot = this.view.getRecord(currentRootFolder.getData().getFolderID(), this.view.encodeString(curPathComponent));
                if (newRoot != null) {
                    currentRoot = newRoot;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return currentRoot;
    }

    private FSEntry entryFromRecord(CommonHFSCatalogFileRecord fileRecord) {
        if (fileRecord.getData().isSymbolicLink()) {
            return new HFSCommonFSLink(this, fileRecord);
        }
        if (fileRecord.getData().isHardFileLink()) {
            CommonHFSCatalogFileRecord iNode = lookupFileInode(fileRecord.getData().getHardLinkInode());
            if (iNode != null) {
                return new HFSCommonFSFile(this, fileRecord, iNode);
            }
            System.err.println("Looking up file iNode " + fileRecord.getData().getHardLinkInode() + " (" + fileRecord.getKey().getParentID().toLong() + ":\"" + getProperNodeName(fileRecord) + "\") FAILED!");
            return new HFSCommonFSFile(this, fileRecord);
        } else if (fileRecord.getData().isHardDirectoryLink()) {
            CommonHFSCatalogFolderRecord iNode2 = lookupDirectoryInode(fileRecord.getData().getHardLinkInode());
            if (iNode2 != null) {
                return new HFSCommonFSFolder(this, fileRecord, iNode2);
            }
            System.err.println("Looking up directory iNode " + fileRecord.getData().getHardLinkInode() + " (" + fileRecord.getKey().getParentID().toLong() + ":\"" + getProperNodeName(fileRecord) + "\") FAILED!");
            return new HFSCommonFSFile(this, fileRecord);
        } else {
            return new HFSCommonFSFile(this, fileRecord);
        }
    }

    private FSEntry entryFromRecord(CommonHFSCatalogFolderRecord folderRecord) {
        return new HFSCommonFSFolder(this, folderRecord);
    }

    private CommonHFSCatalogFileRecord lookupFileInode(int inodeNumber) {
        long trueInodeNumber = Util.unsign(inodeNumber);
        CommonHFSCatalogLeafRecord res = getRecord(this.view.getRoot(), "��������HFS+ Private Data", "iNode" + trueInodeNumber);
        if (res == null) {
            return null;
        }
        if (res instanceof CommonHFSCatalogFileRecord) {
            return (CommonHFSCatalogFileRecord) res;
        }
        throw new RuntimeException("Error in HFS+ file system structure: Found a " + res.getClass() + " in file hard link dir for iNode" + trueInodeNumber);
    }

    private CommonHFSCatalogFolderRecord lookupDirectoryInode(int inodeNumber) {
        long trueInodeNumber = Util.unsign(inodeNumber);
        CommonHFSCatalogLeafRecord res = getRecord(this.view.getRoot(), ".HFS+ Private Directory Data\r", "dir_" + trueInodeNumber);
        if (res == null) {
            return null;
        }
        if (res instanceof CommonHFSCatalogFolderRecord) {
            return (CommonHFSCatalogFolderRecord) res;
        }
        throw new RuntimeException("Error in HFS+ file system structure: Found a " + res.getClass() + " in directory hard link dir for dir_" + trueInodeNumber);
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandler
    public FSForkType[] getSupportedForkTypes() {
        return new FSForkType[]{FSForkType.DATA, FSForkType.MACOS_RESOURCE};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getProperNodeName(CommonHFSCatalogLeafRecord record) {
        String nodeNameRaw = this.view.decodeString(record.getKey().getNodeName());
        if (this.doUnicodeFileNameComposition) {
            return UnicodeNormalizationToolkit.getDefaultInstance().compose(nodeNameRaw);
        }
        return nodeNameRaw;
    }

    public static String[] splitPOSIXUTF8Path(byte[] path) {
        return splitPOSIXUTF8Path(path, 0, path.length);
    }

    public static String[] splitPOSIXUTF8Path(byte[] path, int offset, int length) {
        try {
            String s = new String(path, offset, length, "UTF-8");
            String[] res = s.split("/");
            for (int i2 = 0; i2 < res.length; i2++) {
                res[i2] = res[i2].replace(':', '/');
            }
            return res;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("REALLY UNEXPECTED: Could not decode UTF-8!", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadableRandomAccessStream getReadableDataForkStream(CommonHFSCatalogFileRecord fileRecord) {
        return this.view.getReadableDataForkStream(fileRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReadableRandomAccessStream getReadableResourceForkStream(CommonHFSCatalogFileRecord fileRecord) {
        return this.view.getReadableResourceForkStream(fileRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] listNames(CommonHFSCatalogFolderRecord folderRecord) {
        CommonHFSCatalogLeafRecord[] subRecords = this.view.listRecords(folderRecord);
        LinkedList<String> result = new LinkedList<>();
        for (CommonHFSCatalogLeafRecord curRecord : subRecords) {
            result.add(getProperNodeName(curRecord));
        }
        return (String[]) result.toArray(new String[result.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FSEntry[] listFSEntries(CommonHFSCatalogFolderRecord folderRecord) {
        CommonHFSCatalogLeafRecord[] subRecords = this.view.listRecords(folderRecord);
        LinkedList<FSEntry> result = new LinkedList<>();
        for (CommonHFSCatalogLeafRecord curRecord : subRecords) {
            FSEntry curEntry = null;
            if (curRecord instanceof CommonHFSCatalogFileRecord) {
                curEntry = entryFromRecord((CommonHFSCatalogFileRecord) curRecord);
            } else if (curRecord instanceof CommonHFSCatalogFolderRecord) {
                curEntry = entryFromRecord((CommonHFSCatalogFolderRecord) curRecord);
            }
            if (curEntry != null) {
                result.addLast(curEntry);
            }
        }
        return (FSEntry[]) result.toArray(new FSEntry[result.size()]);
    }

    HFSCommonFSFolder lookupParentFolder(CommonHFSCatalogLeafRecord childRecord) {
        CommonHFSCatalogFolderRecord folderRec = lookupParentFolderRecord(childRecord);
        if (folderRec != null) {
            return new HFSCommonFSFolder(this, folderRec);
        }
        return null;
    }

    private CommonHFSCatalogFolderRecord lookupParentFolderRecord(CommonHFSCatalogLeafRecord childRecord) {
        CommonHFSCatalogNodeID parentID = childRecord.getKey().getParentID();
        CommonHFSCatalogLeafRecord parent = this.view.getRecord(parentID, this.view.getEmptyString());
        if (parent == null) {
            if (parentID.toLong() == 1) {
                return null;
            }
            throw new RuntimeException("INTERNAL ERROR: No folder thread found for ID " + parentID.toLong() + "!");
        } else if (parent instanceof CommonHFSCatalogFolderThreadRecord) {
            CommonHFSCatalogFolderThread data = ((CommonHFSCatalogFolderThreadRecord) parent).getData();
            CommonHFSCatalogLeafRecord rec = this.view.getRecord(data.getParentID(), data.getNodeName());
            if (rec == null) {
                return null;
            }
            if (rec instanceof CommonHFSCatalogFolderRecord) {
                return (CommonHFSCatalogFolderRecord) rec;
            }
            throw new RuntimeException("Internal error: rec not instanceof CommonHFSCatalogFolderRecord, but instead:" + rec.getClass());
        } else if (parent instanceof CommonHFSCatalogFileThreadRecord) {
            throw new RuntimeException("Tried to get folder thread record (" + parentID + ",\"\") but found a file thread record!");
        } else {
            throw new RuntimeException("Tried to get folder thread record (" + parentID + ",\"\") but found a " + parent.getClass() + "!");
        }
    }

    public BaseHFSFileSystemView getFSView() {
        return this.view;
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandler
    public void close() {
        this.view.close();
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandler
    public FSFolder getRoot() {
        return new HFSCommonFSFolder(this, this.view.getRoot());
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandler
    public String parsePosixPathnameComponent(String posixPathnameComponent) {
        return posixPathnameComponent.replace(':', '/');
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandler
    public String generatePosixPathnameComponent(String fsPathnameComponent) {
        return fsPathnameComponent.replace("/", ":");
    }

    @Override // org.catacombae.jparted.lib.fs.FileSystemHandler
    public String[] getTargetPath(FSLink link, String[] parentDir) {
        if (link instanceof HFSCommonFSLink) {
            HFSCommonFSLink hfsLink = (HFSCommonFSLink) link;
            return getTruePathFromPosixPath(hfsLink.getLinkTargetPosixPath(), parentDir);
        }
        throw new RuntimeException("Invalid type: " + link.getClass());
    }
}
