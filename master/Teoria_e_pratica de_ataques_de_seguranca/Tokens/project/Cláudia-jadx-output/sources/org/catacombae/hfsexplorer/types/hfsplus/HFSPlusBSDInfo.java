package org.catacombae.hfsexplorer.types.hfsplus;

import g.a.a.n.l;
import g.a.b.c;
import java.io.PrintStream;
import org.catacombae.csjc.StructElements;
import org.catacombae.csjc.structelements.Dictionary;
import org.catacombae.csjc.structelements.StringRepresentableField;
import org.catacombae.hfsexplorer.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusBSDInfo.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusBSDInfo.class */
public class HFSPlusBSDInfo implements StructElements {
    public static final byte MASK_ADMIN_ARCHIVED = 1;
    public static final byte MASK_ADMIN_IMMUTABLE = 2;
    public static final byte MASK_ADMIN_APPEND = 4;
    public static final byte MASK_OWNER_NODUMP = 1;
    public static final byte MASK_OWNER_IMMUTABLE = 2;
    public static final byte MASK_OWNER_APPEND = 4;
    public static final byte MASK_OWNER_OPAQUE = 8;
    public static final byte FILETYPE_UNDEFINED = 0;
    public static final byte FILETYPE_FIFO = 1;
    public static final byte FILETYPE_CHARACTER_SPECIAL = 2;
    public static final byte FILETYPE_DIRECTORY = 4;
    public static final byte FILETYPE_BLOCK_SPECIAL = 6;
    public static final byte FILETYPE_REGULAR = 8;
    public static final byte FILETYPE_SYMBOLIC_LINK = 10;
    public static final byte FILETYPE_SOCKET = 12;
    public static final byte FILETYPE_WHITEOUT = 14;
    private final byte[] ownerID = new byte[4];
    private final byte[] groupID = new byte[4];
    private final byte[] adminFlags = new byte[1];
    private final byte[] ownerFlags = new byte[1];
    private final byte[] fileMode = new byte[2];
    private final byte[] special = new byte[4];

    public HFSPlusBSDInfo(byte[] data, int offset) {
        System.arraycopy(data, offset + 0, this.ownerID, 0, 4);
        System.arraycopy(data, offset + 4, this.groupID, 0, 4);
        System.arraycopy(data, offset + 8, this.adminFlags, 0, 1);
        System.arraycopy(data, offset + 9, this.ownerFlags, 0, 1);
        System.arraycopy(data, offset + 10, this.fileMode, 0, 2);
        System.arraycopy(data, offset + 12, this.special, 0, 4);
    }

    public static int length() {
        return 16;
    }

    public int getOwnerID() {
        return Util.readIntBE(this.ownerID);
    }

    public int getGroupID() {
        return Util.readIntBE(this.groupID);
    }

    public byte getAdminFlags() {
        return Util.readByteBE(this.adminFlags);
    }

    public byte getOwnerFlags() {
        return Util.readByteBE(this.ownerFlags);
    }

    public short getFileMode() {
        return Util.readShortBE(this.fileMode);
    }

    public int getSpecial() {
        return Util.readIntBE(this.special);
    }

    public boolean getAdminArchivedFlag() {
        return (getAdminFlags() & 1) != 0;
    }

    public boolean getAdminImmutableFlag() {
        return (getAdminFlags() & 2) != 0;
    }

    public boolean getAdminAppendFlag() {
        return (getAdminFlags() & 4) != 0;
    }

    public boolean getOwnerNodumpFlag() {
        return (getOwnerFlags() & 1) != 0;
    }

    public boolean getOwnerImmutableFlag() {
        return (getOwnerFlags() & 2) != 0;
    }

    public boolean getOwnerAppendFlag() {
        return (getOwnerFlags() & 4) != 0;
    }

    public boolean getOwnerOpaqueFlag() {
        return (getOwnerFlags() & 8) != 0;
    }

    public byte getFileModeFileType() {
        int type = (getFileMode() >> 12) & 15;
        return (byte) type;
    }

    public boolean getFileModeSetUserID() {
        return ((getFileMode() >> 9) & 4) != 0;
    }

    public boolean getFileModeSetGroupID() {
        return ((getFileMode() >> 9) & 2) != 0;
    }

    public boolean getFileModeSticky() {
        return ((getFileMode() >> 9) & 1) != 0;
    }

    public boolean getFileModeOwnerRead() {
        return ((getFileMode() >> 6) & 4) != 0;
    }

    public boolean getFileModeOwnerWrite() {
        return ((getFileMode() >> 6) & 2) != 0;
    }

    public boolean getFileModeOwnerExecute() {
        return ((getFileMode() >> 6) & 1) != 0;
    }

    public boolean getFileModeGroupRead() {
        return ((getFileMode() >> 3) & 4) != 0;
    }

    public boolean getFileModeGroupWrite() {
        return ((getFileMode() >> 3) & 2) != 0;
    }

    public boolean getFileModeGroupExecute() {
        return ((getFileMode() >> 3) & 1) != 0;
    }

    public boolean getFileModeOtherRead() {
        return ((getFileMode() >> 0) & 4) != 0;
    }

    public boolean getFileModeOtherWrite() {
        return ((getFileMode() >> 0) & 2) != 0;
    }

    public boolean getFileModeOtherExecute() {
        return ((getFileMode() >> 0) & 1) != 0;
    }

    public String getFileModeString() {
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
        byte fileType = getFileModeFileType();
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
                throw new RuntimeException("Unknown file type (read: " + ((int) fileType) + " REGULAR: 8 MODE: 0x" + Util.toHexStringBE(getFileMode()) + ")!");
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
        if (getFileModeOwnerRead()) {
            result2 = result + "r";
        } else {
            result2 = result + "-";
        }
        if (getFileModeOwnerWrite()) {
            result3 = result2 + "w";
        } else {
            result3 = result2 + "-";
        }
        if (getFileModeOwnerExecute()) {
            if (getFileModeSetUserID()) {
                result4 = result3 + "s";
            } else {
                result4 = result3 + "x";
            }
        } else if (getFileModeSetUserID()) {
            result4 = result3 + "S";
        } else {
            result4 = result3 + "-";
        }
        if (getFileModeGroupRead()) {
            result5 = result4 + "r";
        } else {
            result5 = result4 + "-";
        }
        if (getFileModeGroupWrite()) {
            result6 = result5 + "w";
        } else {
            result6 = result5 + "-";
        }
        if (getFileModeGroupExecute()) {
            if (getFileModeSetGroupID()) {
                result7 = result6 + "s";
            } else {
                result7 = result6 + "x";
            }
        } else if (getFileModeSetGroupID()) {
            result7 = result6 + "S";
        } else {
            result7 = result6 + "-";
        }
        if (getFileModeOtherRead()) {
            result8 = result7 + "r";
        } else {
            result8 = result7 + "-";
        }
        if (getFileModeOtherWrite()) {
            result9 = result8 + "w";
        } else {
            result9 = result8 + "-";
        }
        if (getFileModeOtherExecute()) {
            if (getFileModeSticky()) {
                result10 = result9 + "t";
            } else {
                result10 = result9 + "x";
            }
        } else if (getFileModeSticky()) {
            result10 = result9 + "T";
        } else {
            result10 = result9 + "-";
        }
        return result10;
    }

    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " ownerID: " + getOwnerID());
        ps.println(prefix + " groupID: " + getGroupID());
        ps.println(prefix + " adminFlags: " + ((int) getAdminFlags()));
        ps.println(prefix + " ownerFlags: " + ((int) getOwnerFlags()));
        ps.println(prefix + " fileMode: " + ((int) getFileMode()));
        ps.println(prefix + " special: " + getSpecial());
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "HFSPlusBSDInfo:");
        printFields(ps, prefix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getBytes() {
        byte[] result = new byte[length()];
        System.arraycopy(this.ownerID, 0, result, 0, this.ownerID.length);
        int offset = 0 + this.ownerID.length;
        System.arraycopy(this.groupID, 0, result, offset, this.groupID.length);
        int offset2 = offset + this.groupID.length;
        System.arraycopy(this.adminFlags, 0, result, offset2, this.adminFlags.length);
        int offset3 = offset2 + this.adminFlags.length;
        System.arraycopy(this.ownerFlags, 0, result, offset3, this.ownerFlags.length);
        int offset4 = offset3 + this.ownerFlags.length;
        System.arraycopy(this.fileMode, 0, result, offset4, this.fileMode.length);
        int offset5 = offset4 + this.fileMode.length;
        System.arraycopy(this.special, 0, result, offset5, this.special.length);
        int length = offset5 + this.special.length;
        return result;
    }

    @Override // org.catacombae.csjc.StructElements
    public Dictionary getStructElements() {
        StructElements.DictionaryBuilder db = new StructElements.DictionaryBuilder(HFSPlusBSDInfo.class.getSimpleName());
        db.addUIntBE("ownerID", this.ownerID);
        db.addUIntBE("groupID", this.groupID);
        StructElements.DictionaryBuilder dbAdminFlags = new StructElements.DictionaryBuilder("UInt8");
        dbAdminFlags.addFlag("append", this.adminFlags, 2, "Writes to file may only append");
        dbAdminFlags.addFlag("immutable", this.adminFlags, 1, "File may not be changed");
        dbAdminFlags.addFlag("archived", this.adminFlags, 0, "File has been archived");
        Dictionary adminFlagsDict = dbAdminFlags.getResult();
        db.add("adminFlags", adminFlagsDict);
        StructElements.DictionaryBuilder dbOwnerFlags = new StructElements.DictionaryBuilder("UInt8");
        dbOwnerFlags.addFlag("opaque", this.ownerFlags, 3, "Directory is opaque");
        dbOwnerFlags.addFlag("append", this.ownerFlags, 2, "Writes to file may only append");
        dbOwnerFlags.addFlag("immutable", this.ownerFlags, 1, "File may not be changed");
        dbOwnerFlags.addFlag("nodump", this.ownerFlags, 0, "Do not dump (backup or archive) this file");
        Dictionary ownerFlagsDict = dbOwnerFlags.getResult();
        db.add("ownerFlags", ownerFlagsDict);
        StructElements.DictionaryBuilder dbFileModeFlags = new StructElements.DictionaryBuilder("UInt16");
        dbFileModeFlags.add("fileType", new FileTypeField());
        dbFileModeFlags.addFlag("setUserID", this.fileMode, 11, "Set user ID on execution");
        dbFileModeFlags.addFlag("setGroupID", this.fileMode, 10, "Set group ID on execution");
        dbFileModeFlags.addFlag("sticky", this.fileMode, 9, "Sticky bit");
        dbFileModeFlags.addFlag("ownerRead", this.fileMode, 8, "Owner can read");
        dbFileModeFlags.addFlag("ownerWrite", this.fileMode, 7, "Owner can write");
        dbFileModeFlags.addFlag("ownerExecute", this.fileMode, 6, "Owner can execute");
        dbFileModeFlags.addFlag("groupRead", this.fileMode, 5, "Group can read");
        dbFileModeFlags.addFlag("groupWrite", this.fileMode, 4, "Group can write");
        dbFileModeFlags.addFlag("groupExecute", this.fileMode, 3, "Group can execute");
        dbFileModeFlags.addFlag("otherRead", this.fileMode, 2, "Others can read");
        dbFileModeFlags.addFlag("otherWrite", this.fileMode, 1, "Others can write");
        dbFileModeFlags.addFlag("otherExecute", this.fileMode, 0, "Others can execute");
        Dictionary fileModeFlagsDict = dbFileModeFlags.getResult();
        db.add("fileMode", fileModeFlagsDict);
        db.addUIntBE("special", this.special);
        return db.getResult();
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusBSDInfo$FileTypeField.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfsplus/HFSPlusBSDInfo$FileTypeField.class */
    private class FileTypeField extends StringRepresentableField {
        public FileTypeField() {
            super("FileType", StructElements.ASCIISTRING);
        }

        @Override // org.catacombae.csjc.structelements.StringRepresentableField
        public String getValueAsString() {
            byte fileTypeByte = HFSPlusBSDInfo.this.getFileModeFileType();
            switch (fileTypeByte) {
                case 0:
                    return "Undefined";
                case 1:
                    return "FIFO";
                case 2:
                    return "Character special file";
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                default:
                    return "[Unknown file type: " + ((int) fileTypeByte) + "]";
                case 4:
                    return "Directory";
                case 6:
                    return "Block special file";
                case 8:
                    return "Regular file";
                case 10:
                    return "Symbolic link";
                case 12:
                    return "Socket";
                case 14:
                    return "Whiteout";
            }
        }

        @Override // org.catacombae.csjc.structelements.StringRepresentableField
        public void setStringValue(String value) throws IllegalArgumentException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override // org.catacombae.csjc.structelements.StringRepresentableField
        public String validateStringValue(String s) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
