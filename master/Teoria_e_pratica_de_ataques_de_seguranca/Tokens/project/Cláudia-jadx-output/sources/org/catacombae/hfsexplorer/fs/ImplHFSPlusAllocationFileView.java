package org.catacombae.hfsexplorer.fs;

import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor;
import org.catacombae.hfsexplorer.types.hfsplus.HFSPlusExtentDescriptor;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/ImplHFSPlusAllocationFileView.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/ImplHFSPlusAllocationFileView.class */
public class ImplHFSPlusAllocationFileView extends BaseHFSAllocationFileView {
    private ImplHFSPlusFileSystemView hfsPlusParentView;
    private ReadableRandomAccessStream allocationFile;

    public ImplHFSPlusAllocationFileView(ImplHFSPlusFileSystemView parentView, ReadableRandomAccessStream allocationFile) {
        super(parentView, allocationFile);
        this.hfsPlusParentView = parentView;
        this.allocationFile = allocationFile;
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSAllocationFileView
    public boolean isAllocationBlockUsed(long blockNumber) throws IllegalArgumentException {
        if (blockNumber < 0 || blockNumber > 4294967294L) {
            throw new IllegalArgumentException("Block number (" + blockNumber + ") out of range for UInt32!");
        }
        return super.isAllocationBlockUsed(blockNumber);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSAllocationFileView
    public CommonHFSExtentDescriptor createExtentDescriptor(long startBlock, long blockCount) {
        if (startBlock < 0 || startBlock > 4294967294L) {
            throw new IllegalArgumentException("startBlock(" + startBlock + ") out of range for UInt32!");
        }
        if (blockCount < 0 || blockCount > 4294967294L) {
            throw new IllegalArgumentException("blockCount(" + blockCount + ") out of range for UInt32!");
        }
        HFSPlusExtentDescriptor hped = new HFSPlusExtentDescriptor((int) startBlock, (int) blockCount);
        return CommonHFSExtentDescriptor.create(hped);
    }
}
