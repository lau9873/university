package org.catacombae.hfsexplorer.types.resff;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.catacombae.csjc.PrintableStruct;
import org.catacombae.hfsexplorer.io.SynchronizedReadableRandomAccess;
import org.catacombae.util.Util;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/resff/ResourceMap.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/resff/ResourceMap.class */
public class ResourceMap implements PrintableStruct {
    public static final int STRUCTSIZE = 46;
    private final byte[] reserved1 = new byte[16];
    private final byte[] reserved2 = new byte[4];
    private final byte[] reserved3 = new byte[2];
    private final byte[] resourceForkAttributes = new byte[2];
    private final byte[] typeListOffset = new byte[2];
    private final byte[] nameListOffset = new byte[2];
    private final byte[] typeCount = new byte[2];
    private final ResourceType[] resourceTypeList;
    private final List<Util.Pair<ResourceType, ReferenceListEntry[]>> referenceList;
    private final List<Util.Pair<ReferenceListEntry, ResourceName>> resourceNameList;

    public ResourceMap(SynchronizedReadableRandomAccess stream, long offset) {
        byte[] data = new byte[30];
        stream.readFullyFrom(offset, data);
        System.arraycopy(data, 0, this.reserved1, 0, 16);
        System.arraycopy(data, 16, this.reserved2, 0, 4);
        System.arraycopy(data, 20, this.reserved3, 0, 2);
        System.arraycopy(data, 22, this.resourceForkAttributes, 0, 2);
        System.arraycopy(data, 24, this.typeListOffset, 0, 2);
        System.arraycopy(data, 26, this.nameListOffset, 0, 2);
        System.arraycopy(data, 28, this.typeCount, 0, 2);
        long resourceTypeListOffset = org.catacombae.hfsexplorer.Util.unsign(getTypeListOffset());
        long resourceNameListOffset = org.catacombae.hfsexplorer.Util.unsign(getNameListOffset());
        long curOffset = offset + resourceTypeListOffset + 2;
        byte[] curResTypeData = new byte[ResourceType.length()];
        this.resourceTypeList = new ResourceType[getTypeCount() + 1];
        for (int i2 = 0; i2 < this.resourceTypeList.length; i2++) {
            stream.readFullyFrom(curOffset, curResTypeData);
            this.resourceTypeList[i2] = new ResourceType(curResTypeData, 0);
            curOffset += curResTypeData.length;
        }
        int numberOfRefListEntries = 0;
        byte[] curListEntryData = new byte[ReferenceListEntry.length()];
        this.referenceList = new ArrayList(this.resourceTypeList.length);
        for (int i3 = 0; i3 < this.resourceTypeList.length; i3++) {
            ResourceType curType = this.resourceTypeList[i3];
            ReferenceListEntry[] curList = new ReferenceListEntry[curType.getInstanceCount() + 1];
            long curOffset2 = offset + resourceTypeListOffset + org.catacombae.hfsexplorer.Util.unsign(curType.getReferenceListOffset());
            for (int j = 0; j < curList.length; j++) {
                stream.readFullyFrom(curOffset2, curListEntryData);
                curList[j] = new ReferenceListEntry(curListEntryData, 0);
                curOffset2 += curListEntryData.length;
            }
            numberOfRefListEntries += curList.length;
            this.referenceList.add(new Util.Pair<>(curType, curList));
        }
        this.resourceNameList = new ArrayList(numberOfRefListEntries);
        for (Util.Pair<ResourceType, ReferenceListEntry[]> p : this.referenceList) {
            ReferenceListEntry[] arr$ = p.getB();
            for (ReferenceListEntry e2 : arr$) {
                long resNameOffset = e2.getResourceNameOffset();
                if (resNameOffset != -1) {
                    long nameOffset = offset + resourceNameListOffset + resNameOffset;
                    ResourceName resName = new ResourceName(stream, nameOffset);
                    this.resourceNameList.add(new Util.Pair<>(e2, resName));
                }
            }
        }
    }

    public static int length() {
        return 46;
    }

    public int maxSize() {
        return 30 + (ResourceType.length() * 65536);
    }

    public int occupiedSize() {
        return 30 + (this.resourceTypeList.length * ResourceType.length());
    }

    public byte[] getReserved1() {
        return org.catacombae.hfsexplorer.Util.readByteArrayBE(this.reserved1);
    }

    public int getReserved2() {
        return org.catacombae.hfsexplorer.Util.readIntBE(this.reserved2);
    }

    public short getReserved3() {
        return org.catacombae.hfsexplorer.Util.readShortBE(this.reserved3);
    }

    public short getResourceForkAttributes() {
        return org.catacombae.hfsexplorer.Util.readShortBE(this.resourceForkAttributes);
    }

    public short getTypeListOffset() {
        return org.catacombae.hfsexplorer.Util.readShortBE(this.typeListOffset);
    }

    public short getNameListOffset() {
        return org.catacombae.hfsexplorer.Util.readShortBE(this.nameListOffset);
    }

    public short getTypeCount() {
        return org.catacombae.hfsexplorer.Util.readShortBE(this.typeCount);
    }

    public ResourceType[] getResourceTypeList() {
        return (ResourceType[]) org.catacombae.hfsexplorer.Util.arrayCopy(this.resourceTypeList, new ResourceType[this.resourceTypeList.length]);
    }

    public List<Util.Pair<ResourceType, ReferenceListEntry[]>> getReferenceList() {
        return new ArrayList(this.referenceList);
    }

    public List<Util.Pair<ReferenceListEntry, ResourceName>> getResourceNameList() {
        return new ArrayList(this.resourceNameList);
    }

    public ReferenceListEntry[] getReferencesByType(ResourceType resType) {
        for (Util.Pair<ResourceType, ReferenceListEntry[]> entry : this.referenceList) {
            if (entry.getA() == resType) {
                return (ReferenceListEntry[]) org.catacombae.hfsexplorer.Util.arrayCopy(entry.getB(), new ReferenceListEntry[entry.getB().length]);
            }
        }
        return null;
    }

    public ResourceName getNameByReferenceListEntry(ReferenceListEntry entry) {
        for (Util.Pair<ReferenceListEntry, ResourceName> listEntry : this.resourceNameList) {
            if (listEntry.getA() == entry) {
                return listEntry.getB();
            }
        }
        return null;
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void printFields(PrintStream ps, String prefix) {
        ps.println(prefix + " reserved1: " + getReserved1());
        ps.println(prefix + " reserved2: " + getReserved2());
        ps.println(prefix + " reserved3: " + ((int) getReserved3()));
        ps.println(prefix + " resourceForkAttributes: " + ((int) getResourceForkAttributes()));
        ps.println(prefix + " typeListOffset: " + ((int) getTypeListOffset()));
        ps.println(prefix + " nameListOffset: " + ((int) getNameListOffset()));
        ps.println(prefix + " typeCount: " + ((int) getTypeCount()));
        ps.println(prefix + " resourceTypeList: ");
        for (int i2 = 0; i2 < this.resourceTypeList.length; i2++) {
            ps.println(prefix + "  [" + i2 + "]:");
            this.resourceTypeList[i2].print(ps, prefix + "   ");
        }
        ps.println(prefix + " referenceList: ");
        int i3 = 0;
        for (Util.Pair<ResourceType, ReferenceListEntry[]> entry : this.referenceList) {
            ReferenceListEntry[] arr$ = entry.getB();
            for (ReferenceListEntry refListEntry : arr$) {
                int i4 = i3;
                i3++;
                ps.println(prefix + "  [" + i4 + "]:");
                refListEntry.print(ps, prefix + "   ");
            }
        }
        ps.println(prefix + " resourceNameList: ");
        int i5 = 0;
        for (Util.Pair<ReferenceListEntry, ResourceName> entry2 : this.resourceNameList) {
            int i6 = i5;
            i5++;
            ps.println(prefix + "  [" + i6 + "]:");
            entry2.getB().print(ps, prefix + "   ");
        }
    }

    @Override // org.catacombae.csjc.PrintableStruct
    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "ResourceMap:");
        printFields(ps, prefix);
    }
}
