package org.catacombae.dmgextractor.io;

import java.io.IOException;
import java.io.Reader;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/io/ConcatenatedReader.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/io/ConcatenatedReader.class */
public class ConcatenatedReader extends Reader {
    private final Reader[] sources;
    private long charPos = 0;
    private int currentSource = 0;

    public ConcatenatedReader(Reader[] sources) {
        this.sources = sources;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader[] arr$ = this.sources;
        for (Reader r : arr$) {
            r.close();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) throws IOException {
        int currentRead;
        int bytesRead = 0;
        while (bytesRead < len) {
            Reader currentReader = this.sources[this.currentSource];
            int read = currentReader.read(cbuf, off + bytesRead, len - bytesRead);
            while (true) {
                currentRead = read;
                if (currentRead == -1 || bytesRead >= len) {
                    break;
                }
                bytesRead += currentRead;
                read = currentReader.read(cbuf, off + bytesRead, len - bytesRead);
            }
            if (currentRead == -1) {
                if (this.currentSource + 1 >= this.sources.length) {
                    break;
                }
                this.currentSource++;
            }
        }
        return bytesRead;
    }
}
