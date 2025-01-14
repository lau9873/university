package org.catacombae.dmgextractor.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/io/CharByCharReader.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/io/CharByCharReader.class */
public class CharByCharReader extends Reader {
    private InputStream is;
    private Charset cs;
    private CharsetDecoder cdec;
    private byte[] tempBuffer;
    private int tempBufferPtr = 0;

    public CharByCharReader(InputStream is, Charset cs) {
        this.is = is;
        this.cs = cs;
        this.cdec = cs.newDecoder();
        this.tempBuffer = new byte[(int) Math.ceil(this.cdec.maxCharsPerByte())];
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x008a, code lost:
        r11 = r11 + 1;
        r6.tempBufferPtr = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0054, code lost:
        r7[r8 + r11] = r0.get(0);
     */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r11 = r0
        L3:
            r0 = r11
            r1 = r9
            if (r0 >= r1) goto L95
        L9:
            r0 = r6
            java.io.InputStream r0 = r0.is
            int r0 = r0.read()
            r10 = r0
            r0 = r10
            if (r0 < 0) goto L87
            r0 = r6
            byte[] r0 = r0.tempBuffer
            r1 = r6
            r2 = r1
            int r2 = r2.tempBufferPtr
            r3 = r2; r2 = r1; r1 = r3; 
            r4 = 1
            int r3 = r3 + r4
            r2.tempBufferPtr = r3
            r2 = r10
            byte r2 = (byte) r2
            r0[r1] = r2
            r0 = r6
            byte[] r0 = r0.tempBuffer
            r1 = 0
            r2 = r6
            int r2 = r2.tempBufferPtr
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0, r1, r2)
            r12 = r0
            r0 = 1
            java.nio.CharBuffer r0 = java.nio.CharBuffer.allocate(r0)
            r13 = r0
            r0 = r6
            java.nio.charset.CharsetDecoder r0 = r0.cdec
            r1 = r12
            r2 = r13
            r3 = 1
            java.nio.charset.CoderResult r0 = r0.decode(r1, r2, r3)
            r14 = r0
            r0 = r14
            boolean r0 = r0.isError()
            if (r0 != 0) goto L63
            r0 = r7
            r1 = r8
            r2 = r11
            int r1 = r1 + r2
            r2 = r13
            r3 = 0
            char r2 = r2.get(r3)
            r0[r1] = r2
            goto L8a
        L63:
            r0 = r6
            int r0 = r0.tempBufferPtr
            r1 = r6
            byte[] r1 = r1.tempBuffer
            int r1 = r1.length
            if (r0 != r1) goto L84
            java.io.PrintStream r0 = java.lang.System.err
            r1 = r14
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            java.lang.String r2 = "error while decoding"
            r1.<init>(r2)
            throw r0
        L84:
            goto L9
        L87:
            r0 = r11
            return r0
        L8a:
            int r11 = r11 + 1
            r0 = r6
            r1 = 0
            r0.tempBufferPtr = r1
            goto L3
        L95:
            r0 = r11
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.catacombae.dmgextractor.io.CharByCharReader.read(char[], int, int):int");
    }
}
