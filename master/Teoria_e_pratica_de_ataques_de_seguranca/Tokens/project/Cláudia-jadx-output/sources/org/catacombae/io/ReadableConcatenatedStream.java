package org.catacombae.io;

import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/ReadableConcatenatedStream.class
 */
/* loaded from: csframework.jar:org/catacombae/io/ReadableConcatenatedStream.class */
public class ReadableConcatenatedStream extends BasicReadableRandomAccessStream {
    final List<Part> parts = new ArrayList();
    Part currentPart;
    int currentPartIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/io/ReadableConcatenatedStream$Part.class
     */
    /* loaded from: csframework.jar:org/catacombae/io/ReadableConcatenatedStream$Part.class */
    public static class Part {
        public final ReadableRandomAccessStream file;
        public final long startOffset;
        public final long length;

        public Part(ReadableRandomAccessStream file, long startOffset, long length) {
            this.file = file;
            this.startOffset = startOffset;
            this.length = length;
        }
    }

    public ReadableConcatenatedStream(ReadableRandomAccessStream firstPart, long startOffset, long length) {
        this.currentPart = new Part(firstPart, startOffset, length);
        this.parts.add(this.currentPart);
        this.currentPartIndex = 0;
        seek(0L);
    }

    public void addPart(ReadableRandomAccessStream newFile, long off, long len) {
        Part newPart = new Part(newFile, off, len);
        this.parts.add(newPart);
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public void seek(long pos) {
        long curPos = 0;
        for (Part p : this.parts) {
            if (curPos + p.length > pos) {
                this.currentPart = p;
                this.currentPart.file.seek(this.currentPart.startOffset + (pos - curPos));
                return;
            }
            curPos += p.length;
        }
    }

    @Override // org.catacombae.io.BasicReadable, org.catacombae.io.Readable
    public int read(byte[] data, int pos, int len) {
        int bytesRead = 0;
        while (true) {
            long currentFP = this.currentPart.file.getFilePointer();
            if (currentFP < this.currentPart.startOffset) {
                currentFP = this.currentPart.startOffset;
                this.currentPart.file.seek(currentFP);
            } else if (currentFP > this.currentPart.startOffset + this.currentPart.length) {
                currentFP = this.currentPart.startOffset + this.currentPart.length;
                this.currentPart.file.seek(currentFP);
            }
            long bytesLeftInFile = this.currentPart.length - (currentFP - this.currentPart.startOffset);
            int bytesLeftToRead = len - bytesRead;
            int bytesToRead = (int) (bytesLeftInFile < ((long) bytesLeftToRead) ? bytesLeftInFile : bytesLeftToRead);
            int res = this.currentPart.file.read(data, pos + bytesRead, bytesToRead);
            if (res > 0) {
                bytesRead += res;
                if (bytesRead < len) {
                    if (this.parts.size() < this.currentPartIndex + 1) {
                        this.currentPartIndex++;
                        this.currentPart = this.parts.get(this.currentPartIndex);
                        this.currentPart.file.seek(this.currentPart.startOffset);
                    } else {
                        return bytesRead;
                    }
                } else if (bytesRead == len) {
                    return bytesRead;
                } else {
                    throw new RuntimeException("Read more than I was supposed to! This can't happen.");
                }
            } else if (bytesRead > 0) {
                return bytesRead;
            } else {
                return -1;
            }
        }
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long length() {
        long result = 0;
        for (Part p : this.parts) {
            result += p.length;
        }
        return result;
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.RandomAccess
    public long getFilePointer() {
        long fp = 0;
        for (int i2 = 0; i2 < this.currentPartIndex; i2++) {
            fp += this.parts.get(i2).length;
        }
        Part currentPartLocal = this.parts.get(this.currentPartIndex);
        long currentPartFP = currentPartLocal.file.getFilePointer();
        return fp + (currentPartFP - currentPartLocal.startOffset);
    }

    @Override // org.catacombae.io.BasicReadableRandomAccessStream, org.catacombae.io.Stream
    public void close() {
        for (Part p : this.parts) {
            p.file.close();
        }
    }
}
