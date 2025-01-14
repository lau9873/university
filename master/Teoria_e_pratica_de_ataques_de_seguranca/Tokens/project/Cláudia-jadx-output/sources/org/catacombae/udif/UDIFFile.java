package org.catacombae.udif;

import org.catacombae.io.ReadableRandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/udif/UDIFFile.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/udif/UDIFFile.class */
public class UDIFFile {
    private ReadableRandomAccessStream stream;
    private UDIFFileView dmgView;

    public UDIFFile(ReadableRandomAccessStream stream) {
        this.stream = stream;
        this.dmgView = new UDIFFileView(stream);
    }

    public UDIFFileView getView() {
        return this.dmgView;
    }

    public ReadableRandomAccessStream getStream() {
        return this.stream;
    }
}
