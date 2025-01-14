package org.catacombae.jparted.lib;

import org.catacombae.hfsexplorer.win32.WindowsLowLevelIO;
import org.catacombae.hfsexplorer.win32.WritableWin32File;
import org.catacombae.io.ConcatenatedStream;
import org.catacombae.io.RandomAccessStream;
import org.catacombae.io.ReadableConcatenatedStream;
import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/jparted/lib/WindowsDeviceDataLocator.class
 */
/* loaded from: hfsx.jar:org/catacombae/jparted/lib/WindowsDeviceDataLocator.class */
public class WindowsDeviceDataLocator extends DataLocator {
    private final String devicePath;
    private final Long pos;
    private final Long len;

    public WindowsDeviceDataLocator(String pDevicePath) {
        this.devicePath = pDevicePath;
        this.pos = null;
        this.len = null;
    }

    public WindowsDeviceDataLocator(String pDevicePath, long pPos, long pLen) {
        this.devicePath = pDevicePath;
        this.pos = Long.valueOf(pPos);
        this.len = Long.valueOf(pLen);
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public ReadableRandomAccessStream createReadOnlyFile() {
        ReadableRandomAccessStream llf = new WindowsLowLevelIO(this.devicePath);
        if (this.pos != null && this.len != null) {
            return new ReadableConcatenatedStream(llf, this.pos.longValue(), this.len.longValue());
        }
        return llf;
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public RandomAccessStream createReadWriteFile() {
        RandomAccessStream wllf = new WritableWin32File(this.devicePath);
        if (this.pos != null && this.len != null) {
            return new ConcatenatedStream(wllf, this.pos.longValue(), this.len.longValue());
        }
        return wllf;
    }

    @Override // org.catacombae.jparted.lib.DataLocator
    public boolean isWritable() {
        return true;
    }
}
