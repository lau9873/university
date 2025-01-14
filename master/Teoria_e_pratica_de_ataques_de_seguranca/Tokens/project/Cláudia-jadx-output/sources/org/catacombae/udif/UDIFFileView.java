package org.catacombae.udif;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.catacombae.io.ReadableFileStream;
import org.catacombae.io.ReadableRandomAccessStream;
import org.catacombae.io.RuntimeIOException;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/UDIFFileView.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/udif/UDIFFileView.class */
public class UDIFFileView {
    private ReadableRandomAccessStream dmgRaf;

    public UDIFFileView(File file) {
        try {
            this.dmgRaf = new ReadableFileStream(new RandomAccessFile(file, "r"));
        } catch (IOException ioe) {
            throw new RuntimeIOException(ioe);
        }
    }

    public UDIFFileView(ReadableRandomAccessStream dmgRaf) {
        this.dmgRaf = dmgRaf;
    }

    public byte[] getPlistData() throws RuntimeIOException {
        Koly koly = getKoly();
        byte[] plistData = new byte[(int) koly.getPlistSize()];
        this.dmgRaf.seek(koly.getPlistBegin1());
        if (this.dmgRaf.read(plistData) == plistData.length) {
            return plistData;
        }
        throw new RuntimeException("Could not read the entire region of data containing the Plist");
    }

    public Plist getPlist() throws RuntimeIOException {
        return new Plist(getPlistData());
    }

    public Koly getKoly() throws RuntimeIOException {
        this.dmgRaf.seek(this.dmgRaf.length() - 512);
        byte[] kolyData = new byte[512];
        this.dmgRaf.read(kolyData);
        return new Koly(kolyData, 0);
    }

    public void close() throws RuntimeIOException {
        this.dmgRaf.close();
    }
}
