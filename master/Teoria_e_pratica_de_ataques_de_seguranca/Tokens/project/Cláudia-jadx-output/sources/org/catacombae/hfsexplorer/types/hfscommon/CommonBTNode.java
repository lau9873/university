package org.catacombae.hfsexplorer.types.hfscommon;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.hfsexplorer.types.hfs.NodeDescriptor;
import org.catacombae.hfsexplorer.types.hfscommon.CommonBTRecord;
import org.catacombae.hfsexplorer.types.hfsplus.BTNodeDescriptor;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNode.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNode.class */
public abstract class CommonBTNode<R extends CommonBTRecord> {
    protected final CommonBTNode<R>.InternalContainer ic;

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNode$FSType.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNode$FSType.class */
    protected enum FSType {
        HFS,
        HFS_PLUS
    }

    protected abstract R createBTRecord(int i2, byte[] bArr, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    public CommonBTNode(byte[] data, int offset, int nodeSize, FSType type) {
        switch (type) {
            case HFS:
                this.ic = new HFSImplementation(data, offset, nodeSize);
                return;
            case HFS_PLUS:
                this.ic = new HFSPlusImplementation(data, offset, nodeSize);
                return;
            default:
                throw new RuntimeException("unknown HFSType: " + type);
        }
    }

    public CommonBTNodeDescriptor getNodeDescriptor() {
        return this.ic.getNodeDescriptor();
    }

    public R getBTRecord(int index) {
        return (R) this.ic.getBTRecord(index);
    }

    public List<R> getBTRecords() {
        return (List<R>) this.ic.getBTRecords();
    }

    public void print(PrintStream ps, String prefix) {
        ps.println(prefix + "CommonBTNode:");
        this.ic.printFields(ps, prefix);
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNode$InternalContainer.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNode$InternalContainer.class */
    protected abstract class InternalContainer {
        protected final CommonBTNodeDescriptor nodeDescriptor;
        protected final List<R> records;
        protected final short[] offsets;

        protected InternalContainer(CommonBTNodeDescriptor nodeDescriptor, byte[] data, int offset, int nodeSize) {
            this.nodeDescriptor = nodeDescriptor;
            this.offsets = new short[nodeDescriptor.getNumberOfRecords() + 1];
            for (int i2 = 0; i2 < this.offsets.length; i2++) {
                this.offsets[i2] = Util.readShortBE(data, (offset + nodeSize) - ((i2 + 1) * 2));
            }
            ArrayList arrayList = new ArrayList(this.offsets.length - 1);
            for (int i3 = 0; i3 < this.offsets.length - 1; i3++) {
                int len = this.offsets[i3 + 1] - this.offsets[i3];
                arrayList.add(CommonBTNode.this.createBTRecord(i3, data, offset + this.offsets[i3], len));
            }
            this.records = Collections.unmodifiableList(arrayList);
        }

        public CommonBTNodeDescriptor getNodeDescriptor() {
            return this.nodeDescriptor;
        }

        public R getBTRecord(int index) {
            return this.records.get(index);
        }

        public List<R> getBTRecords() {
            return this.records;
        }

        public void printFields(PrintStream ps, String prefix) {
            ps.println(prefix + " nodeDescriptor: ");
            this.nodeDescriptor.print(ps, prefix + "  ");
            ps.println(prefix + " records (CommonBTRecord[" + this.records.size() + "]):");
            int i2 = 0;
            for (R record : this.records) {
                int i3 = i2;
                i2++;
                ps.println(prefix + "  [" + i3 + "]:");
                record.print(ps, prefix + "   ");
            }
            ps.println(prefix + " offsets (short[" + this.offsets.length + "]):");
            for (int i4 = 0; i4 < this.offsets.length; i4++) {
                ps.println(prefix + "  [" + i4 + "]: " + ((int) this.offsets[i4]));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNode$HFSImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNode$HFSImplementation.class */
    private class HFSImplementation extends InternalContainer {
        public HFSImplementation(byte[] data, int offset, int nodeSize) {
            super(CommonBTNodeDescriptor.create(new NodeDescriptor(data, offset)), data, offset, nodeSize);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNode$HFSPlusImplementation.class
     */
    /* loaded from: hfsx.jar:org/catacombae/hfsexplorer/types/hfscommon/CommonBTNode$HFSPlusImplementation.class */
    private class HFSPlusImplementation extends InternalContainer {
        public HFSPlusImplementation(byte[] data, int offset, int nodeSize) {
            super(CommonBTNodeDescriptor.create(new BTNodeDescriptor(data, offset)), data, offset, nodeSize);
        }
    }
}
