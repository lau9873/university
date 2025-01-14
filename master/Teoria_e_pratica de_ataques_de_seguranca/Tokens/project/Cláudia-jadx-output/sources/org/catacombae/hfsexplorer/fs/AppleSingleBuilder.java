package org.catacombae.hfsexplorer.fs;

import java.util.Iterator;
import java.util.LinkedList;
import org.catacombae.hfsexplorer.types.applesingle.AppleSingleHeader;
import org.catacombae.hfsexplorer.types.applesingle.EntryDescriptor;
import org.catacombae.util.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleBuilder.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleBuilder.class */
public class AppleSingleBuilder {
    private final FileType fileType;
    private final AppleSingleVersion version;
    private final FileSystem homeFileSystem;
    private final LinkedList<Util.Pair<EntryType, byte[]>> entryList = new LinkedList<>();

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleBuilder$FileType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleBuilder$FileType.class */
    public enum FileType {
        APPLESINGLE(333312),
        APPLEDOUBLE(333319);
        
        private final int magic;

        FileType(int magic) {
            this.magic = magic;
        }

        public int getMagic() {
            return this.magic;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleBuilder$AppleSingleVersion.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleBuilder$AppleSingleVersion.class */
    public enum AppleSingleVersion {
        VERSION_1_0(65536),
        VERSION_2_0(131072);
        
        private final int versionNumber;

        AppleSingleVersion(int versionNumber) {
            this.versionNumber = versionNumber;
        }

        public int getVersionNumber() {
            return this.versionNumber;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleBuilder$FileSystem.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleBuilder$FileSystem.class */
    public enum FileSystem {
        MACOS("Macintosh"),
        MACOS_X("Mac OS X"),
        PRODOS("ProDOS"),
        MS_DOS("MS-DOS"),
        UNIS("Unix"),
        VMS("VAX VMS");
        
        private final String identifier;

        FileSystem(String identifier) {
            this.identifier = identifier;
        }

        public byte[] getIdentifier() {
            char[] chars = this.identifier.toCharArray();
            byte[] result = new byte[16];
            for (int i2 = 0; i2 < result.length; i2++) {
                if (i2 < chars.length) {
                    result[i2] = (byte) (chars[i2] & 127);
                } else {
                    result[i2] = 32;
                }
            }
            return result;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleBuilder$EntryType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/AppleSingleBuilder$EntryType.class */
    enum EntryType {
        DATA_FORK(1),
        RESOURCE_FORK(2),
        REAL_NAME(3),
        COMMENT(4),
        ICON_BW(5),
        ICON_COLOR(6),
        FILE_INFO(7),
        FINDER_INFO(9);
        
        private final int typeNumber;

        EntryType(int typeNumber) {
            this.typeNumber = typeNumber;
        }

        public int getTypeNumber() {
            return this.typeNumber;
        }
    }

    public AppleSingleBuilder(FileType fileType, AppleSingleVersion version, FileSystem homeFileSystem) {
        if (fileType == null) {
            throw new IllegalArgumentException("fileType == null");
        }
        if (version == null) {
            throw new IllegalArgumentException("version == null");
        }
        if (homeFileSystem == null) {
            throw new IllegalArgumentException("homeFileSystem == null");
        }
        this.fileType = fileType;
        this.version = version;
        this.homeFileSystem = homeFileSystem;
    }

    public void addDataFork(byte[] resourceForkData) {
        this.entryList.add(new Util.Pair<>(EntryType.DATA_FORK, resourceForkData));
    }

    public void addResourceFork(byte[] resourceForkData) {
        this.entryList.add(new Util.Pair<>(EntryType.RESOURCE_FORK, resourceForkData));
    }

    public byte[] getResult() {
        int dataSize = AppleSingleHeader.length() + (EntryDescriptor.length() * this.entryList.size());
        Iterator i$ = this.entryList.iterator();
        while (i$.hasNext()) {
            dataSize += i$.next().getB().length;
        }
        byte[] result = new byte[dataSize];
        AppleSingleHeader header = new AppleSingleHeader(this.fileType.getMagic(), this.version.getVersionNumber(), this.homeFileSystem, this.entryList.size());
        byte[] headerData = header.getBytes();
        System.arraycopy(headerData, 0, result, 0, headerData.length);
        int pointer = 0 + headerData.length;
        int dataOffset = dataSize;
        Iterator i$2 = this.entryList.iterator();
        while (i$2.hasNext()) {
            Util.Pair<EntryType, byte[]> p = i$2.next();
            byte[] entryData = p.getB();
            EntryDescriptor ed = new EntryDescriptor(p.getA().getTypeNumber(), dataOffset, entryData.length);
            dataOffset += entryData.length;
            byte[] entryDescriptorData = ed.getBytes();
            System.arraycopy(entryDescriptorData, 0, result, pointer, entryDescriptorData.length);
            pointer += entryDescriptorData.length;
        }
        if (pointer != dataSize) {
            throw new RuntimeException("Internal error: Miscalculation of dataStartOffset (should be: " + pointer + ", was: " + dataSize + ")");
        }
        Iterator i$3 = this.entryList.iterator();
        while (i$3.hasNext()) {
            byte[] entryData2 = i$3.next().getB();
            System.arraycopy(entryData2, 0, result, pointer, entryData2.length);
            pointer += entryData2.length;
        }
        if (pointer != result.length) {
            throw new RuntimeException("Internal error: Miscalculation of result.length (should be: " + pointer + ", was: " + result.length + ")");
        }
        return result;
    }
}
