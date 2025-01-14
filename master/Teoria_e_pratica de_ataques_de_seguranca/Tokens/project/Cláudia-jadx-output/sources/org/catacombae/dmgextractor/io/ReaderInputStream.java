package org.catacombae.dmgextractor.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/io/ReaderInputStream.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/io/ReaderInputStream.class */
public class ReaderInputStream extends InputStream {
    private Reader r;
    private CharsetEncoder encoder;
    private byte[] chardata;
    private int remainingChardata = 0;
    private LousyByteArrayStream lbas;
    private OutputStreamWriter osw;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/io/ReaderInputStream$LousyByteArrayStream.class
     */
    /* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/io/ReaderInputStream$LousyByteArrayStream.class */
    public static class LousyByteArrayStream extends OutputStream {
        private final byte[] buffer;
        private int bufpos = 0;

        public LousyByteArrayStream(int buflen) {
            this.buffer = new byte[buflen];
        }

        @Override // java.io.OutputStream
        public void write(int b2) {
            byte[] bArr = this.buffer;
            int i2 = this.bufpos;
            this.bufpos = i2 + 1;
            bArr[i2] = (byte) b2;
        }

        public int reset(byte[] chardata) {
            int length = this.bufpos;
            System.arraycopy(this.buffer, 0, chardata, 0, length);
            this.bufpos = 0;
            return length;
        }
    }

    public ReaderInputStream(Reader r, Charset c2) {
        this.r = r;
        this.encoder = c2.newEncoder();
        this.chardata = new byte[(int) Math.ceil(this.encoder.maxBytesPerChar())];
        this.lbas = new LousyByteArrayStream(this.chardata.length);
        this.osw = new OutputStreamWriter(this.lbas, this.encoder);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] b2 = new byte[1];
        int res = read(b2, 0, 1);
        if (res == 1) {
            return b2[0] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b2) throws IOException {
        return read(b2, 0, b2.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b2, int off, int len) throws IOException {
        if (len < 0) {
            throw new IllegalArgumentException();
        }
        if (len == 0) {
            return 0;
        }
        int endPos = off + len;
        if (this.remainingChardata > 0) {
            int bytesToCopy = this.remainingChardata > len ? len : this.remainingChardata;
            System.arraycopy(this.chardata, 0, b2, off, bytesToCopy);
            off += bytesToCopy;
            this.remainingChardata -= bytesToCopy;
        }
        if (off == endPos) {
            return off - off;
        }
        while (off < endPos) {
            int cur = this.r.read();
            if (cur < 0) {
                break;
            }
            if (Character.isHighSurrogate((char) cur)) {
                int lowSurrogate = this.r.read();
                if (lowSurrogate < 0) {
                    throw new IOException("Too lazy to handle this error...");
                }
                if (!Character.isSurrogatePair((char) cur, (char) lowSurrogate)) {
                    throw new IOException("Encountered a high surrogate without a matching low surrogate... oh crap.");
                }
                cur = Character.toCodePoint((char) cur, (char) lowSurrogate);
            }
            char[] charArray = Character.toChars(cur);
            String charString = new String(charArray, 0, charArray.length);
            this.osw.write(charString);
            this.osw.flush();
            int chardataLength = this.lbas.reset(this.chardata);
            int remainingLength = endPos - off;
            int bytesToCopy2 = chardataLength > remainingLength ? remainingLength : chardataLength;
            System.arraycopy(this.chardata, 0, b2, off, bytesToCopy2);
            off += bytesToCopy2;
            if (chardataLength > remainingLength) {
                this.remainingChardata = chardataLength - remainingLength;
                System.arraycopy(this.chardata, bytesToCopy2, this.chardata, 0, this.remainingChardata);
            }
        }
        int bytesRead = off - off;
        if (off < endPos && bytesRead == 0) {
            return -1;
        }
        return bytesRead;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        long bytesSkipped;
        System.err.println("ReaderInputStream.skip(" + n + ")");
        byte[] skipBuffer = new byte[4096];
        long j = 0;
        while (true) {
            bytesSkipped = j;
            if (bytesSkipped >= n) {
                break;
            }
            long remainingBytes = n - bytesSkipped;
            int bytesToSkip = (int) (((long) skipBuffer.length) < remainingBytes ? skipBuffer.length : remainingBytes);
            int res = read(skipBuffer, 0, bytesToSkip);
            if (res <= 0) {
                break;
            }
            j = bytesSkipped + res;
        }
        return bytesSkipped;
    }
}
