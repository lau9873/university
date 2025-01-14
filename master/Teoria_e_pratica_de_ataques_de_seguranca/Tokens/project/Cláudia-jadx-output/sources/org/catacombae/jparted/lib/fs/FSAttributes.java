package org.catacombae.jparted.lib.fs;

import g.a.a.n.l;
import g.a.b.c;
import java.util.Date;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FSAttributes.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FSAttributes.class */
public abstract class FSAttributes {

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FSAttributes$POSIXFileAttributes.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FSAttributes$POSIXFileAttributes.class */
    public static abstract class POSIXFileAttributes {
        public static final byte FILETYPE_UNDEFINED = 0;
        public static final byte FILETYPE_FIFO = 1;
        public static final byte FILETYPE_CHARACTER_SPECIAL = 2;
        public static final byte FILETYPE_DIRECTORY = 4;
        public static final byte FILETYPE_BLOCK_SPECIAL = 6;
        public static final byte FILETYPE_REGULAR = 8;
        public static final byte FILETYPE_SYMBOLIC_LINK = 10;
        public static final byte FILETYPE_SOCKET = 12;
        public static final byte FILETYPE_WHITEOUT = 14;

        public abstract long getUserID();

        public abstract long getGroupID();

        public abstract byte getFileType();

        public abstract boolean canUserRead();

        public abstract boolean canUserWrite();

        public abstract boolean canUserExecute();

        public abstract boolean canGroupRead();

        public abstract boolean canGroupWrite();

        public abstract boolean canGroupExecute();

        public abstract boolean canOthersRead();

        public abstract boolean canOthersWrite();

        public abstract boolean canOthersExecute();

        public abstract boolean isSetUID();

        public abstract boolean isSetGID();

        public abstract boolean isStickyBit();

        public abstract String getPermissionString();
    }

    public abstract boolean hasPOSIXFileAttributes();

    public abstract POSIXFileAttributes getPOSIXFileAttributes();

    public abstract boolean hasWindowsFileAttributes();

    public abstract WindowsFileAttributes getWindowsFileAttributes();

    public abstract boolean hasCreateDate();

    public abstract Date getCreateDate();

    public abstract boolean hasModifyDate();

    public abstract Date getModifyDate();

    public abstract boolean hasAttributeModifyDate();

    public abstract Date getAttributeModifyDate();

    public abstract boolean hasAccessDate();

    public abstract Date getAccessDate();

    public abstract boolean hasBackupDate();

    public abstract Date getBackupDate();

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/fs/FSAttributes$DefaultPOSIXFileAttributes.class
     */
    /* loaded from: hfsx.jar:org/catacombae/jparted/lib/fs/FSAttributes$DefaultPOSIXFileAttributes.class */
    public static class DefaultPOSIXFileAttributes extends POSIXFileAttributes {
        private final short fileMode;
        private final long userID;
        private final long groupID;

        public DefaultPOSIXFileAttributes(long userID, long groupID, short fileMode) {
            this.userID = userID;
            this.groupID = groupID;
            this.fileMode = fileMode;
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public long getUserID() {
            return this.userID;
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public long getGroupID() {
            return this.groupID;
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public byte getFileType() {
            int type = (this.fileMode >> 12) & 15;
            return (byte) type;
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean isSetUID() {
            return Util.getBit(this.fileMode, 11);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean isSetGID() {
            return Util.getBit(this.fileMode, 10);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean isStickyBit() {
            return Util.getBit(this.fileMode, 9);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean canUserRead() {
            return Util.getBit(this.fileMode, 8);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean canUserWrite() {
            return Util.getBit(this.fileMode, 7);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean canUserExecute() {
            return Util.getBit(this.fileMode, 6);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean canGroupRead() {
            return Util.getBit(this.fileMode, 5);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean canGroupWrite() {
            return Util.getBit(this.fileMode, 4);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean canGroupExecute() {
            return Util.getBit(this.fileMode, 3);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean canOthersRead() {
            return Util.getBit(this.fileMode, 2);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean canOthersWrite() {
            return Util.getBit(this.fileMode, 1);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public boolean canOthersExecute() {
            return Util.getBit(this.fileMode, 0);
        }

        @Override // org.catacombae.jparted.lib.fs.FSAttributes.POSIXFileAttributes
        public String getPermissionString() {
            String result;
            String result2;
            String result3;
            String result4;
            String result5;
            String result6;
            String result7;
            String result8;
            String result9;
            String result10;
            byte fileType = getFileType();
            switch (fileType) {
                case 0:
                    result = "?";
                    break;
                case 1:
                    result = "p";
                    break;
                case 2:
                    result = c.j;
                    break;
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                default:
                    result = " ";
                    System.err.println("[FSAttributes.POSIXFileAttributes.getFileModeString()] Unknown file type:  " + ((int) fileType) + " Mode: 0x" + Util.toHexStringBE(this.fileMode));
                    break;
                case 4:
                    result = "d";
                    break;
                case 6:
                    result = "b";
                    break;
                case 8:
                    result = "-";
                    break;
                case 10:
                    result = l.k;
                    break;
                case 12:
                    result = "s";
                    break;
                case 14:
                    result = "w";
                    break;
            }
            if (canUserRead()) {
                result2 = result + "r";
            } else {
                result2 = result + "-";
            }
            if (canUserWrite()) {
                result3 = result2 + "w";
            } else {
                result3 = result2 + "-";
            }
            if (canUserExecute()) {
                if (isSetUID()) {
                    result4 = result3 + "s";
                } else {
                    result4 = result3 + "x";
                }
            } else if (isSetUID()) {
                result4 = result3 + "S";
            } else {
                result4 = result3 + "-";
            }
            if (canGroupRead()) {
                result5 = result4 + "r";
            } else {
                result5 = result4 + "-";
            }
            if (canGroupWrite()) {
                result6 = result5 + "w";
            } else {
                result6 = result5 + "-";
            }
            if (canGroupExecute()) {
                if (isSetGID()) {
                    result7 = result6 + "s";
                } else {
                    result7 = result6 + "x";
                }
            } else if (isSetGID()) {
                result7 = result6 + "S";
            } else {
                result7 = result6 + "-";
            }
            if (canOthersRead()) {
                result8 = result7 + "r";
            } else {
                result8 = result7 + "-";
            }
            if (canOthersWrite()) {
                result9 = result8 + "w";
            } else {
                result9 = result8 + "-";
            }
            if (canOthersExecute()) {
                if (isStickyBit()) {
                    result10 = result9 + "t";
                } else {
                    result10 = result9 + "x";
                }
            } else if (isStickyBit()) {
                result10 = result9 + "T";
            } else {
                result10 = result9 + "-";
            }
            return result10;
        }
    }
}
