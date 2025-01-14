package org.catacombae.hfsexplorer.fs;

import org.catacombae.hfsexplorer.types.hfs.ExtDescriptor;
import org.catacombae.hfsexplorer.types.hfscommon.CommonHFSExtentDescriptor;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/fs/ImplHFSAllocationFileView.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/fs/ImplHFSAllocationFileView.class */
public class ImplHFSAllocationFileView extends BaseHFSAllocationFileView {
    private final ImplHFSFileSystemView hfsParentView;
    private final ReadableRandomAccessStream volumeBitmap;

    public ImplHFSAllocationFileView(ImplHFSFileSystemView parentView, ReadableRandomAccessStream volumeBitmap) {
        super(parentView, volumeBitmap);
        this.hfsParentView = parentView;
        this.volumeBitmap = volumeBitmap;
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSAllocationFileView
    public boolean isAllocationBlockUsed(long blockNumber) throws IllegalArgumentException {
        if (blockNumber < 0 || blockNumber > 65534) {
            throw new IllegalArgumentException("Block number (" + blockNumber + ") out of range for UInt16!");
        }
        return super.isAllocationBlockUsed(blockNumber);
    }

    @Override // org.catacombae.hfsexplorer.fs.BaseHFSAllocationFileView
    public CommonHFSExtentDescriptor createExtentDescriptor(long startBlock, long blockCount) {
        if (startBlock < 0 || startBlock > 65534) {
            throw new IllegalArgumentException("startBlock(" + startBlock + ") out of range for UInt16!");
        }
        if (blockCount < 0 || blockCount > 65534) {
            throw new IllegalArgumentException("blockCount(" + blockCount + ") out of range for UInt16!");
        }
        ExtDescriptor ed = new ExtDescriptor((short) startBlock, (short) blockCount);
        return CommonHFSExtentDescriptor.create(ed);
    }
}
