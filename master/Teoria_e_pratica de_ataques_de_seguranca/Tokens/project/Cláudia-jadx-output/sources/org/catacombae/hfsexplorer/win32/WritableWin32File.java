package org.catacombae.hfsexplorer.win32;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Random;
import org.apache.tools.bzip2.BZip2Constants;
import org.catacombae.hfsexplorer.Util;
import org.catacombae.io.RandomAccessStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx.jar:org/catacombae/hfsexplorer/win32/WritableWin32File.class
 */
/* loaded from: hfsx.jar:org/catacombae/hfsexplorer/win32/WritableWin32File.class */
public class WritableWin32File extends WindowsLowLevelIO implements RandomAccessStream {
    private byte[] sectorBuffer;
    private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    private static WritableWin32File wwf;
    private static RandomAccessFile ref;
    private static long currentSeekPos;
    private static int currentBufferSize;

    protected static native byte[] openNative(String str);

    protected static native void write(byte[] bArr, int i2, int i3, byte[] bArr2);

    public WritableWin32File(String filename) {
        super(filename);
        this.sectorBuffer = new byte[this.sectorSize];
    }

    @Override // org.catacombae.io.Writable
    public void write(byte[] b2) {
        write(b2, 0, b2.length);
    }

    @Override // org.catacombae.io.Writable
    public void write(byte[] b2, int pos, int len) {
        if (this.fileHandle != null) {
            long fileLength = length(this.fileHandle);
            System.out.println("write(b, " + pos + ", " + len + ");");
            long startFP = this.filePointer;
            long endFP = this.filePointer + len;
            long startSectorFP = (startFP / this.sectorSize) * this.sectorSize;
            int startSectorFPOffset = (int) (startFP - startSectorFP);
            long endSectorFP = (endFP / this.sectorSize) * this.sectorSize;
            int endSectorFPLength = (int) (endFP - endSectorFP);
            seek(startSectorFP, this.fileHandle);
            int bytesToRead = (int) (((long) this.sectorBuffer.length) > fileLength ? fileLength : this.sectorBuffer.length);
            if (read(this.sectorBuffer, 0, bytesToRead, this.fileHandle) != bytesToRead) {
                throw new RuntimeException("Could not read contents of starting sector!");
            }
            System.out.println("Writing first bytes.");
            seek(startSectorFP, this.fileHandle);
            int remainingSpaceInBuffer = this.sectorBuffer.length - startSectorFPOffset;
            int bytesToReplace = len < remainingSpaceInBuffer ? len : remainingSpaceInBuffer;
            System.arraycopy(b2, pos, this.sectorBuffer, startSectorFPOffset, bytesToReplace);
            int inputPos = pos + bytesToReplace;
            write(this.sectorBuffer, 0, startSectorFPOffset + bytesToReplace, this.fileHandle);
            long j = startSectorFP;
            int i2 = this.sectorSize;
            while (true) {
                long currentSectorFP = j + i2;
                if (currentSectorFP >= endSectorFP) {
                    break;
                }
                System.out.println("Writing non-complicated sector " + ((currentSectorFP - startSectorFP) / this.sectorSize) + "...");
                System.arraycopy(b2, inputPos, this.sectorBuffer, 0, this.sectorBuffer.length);
                inputPos += this.sectorBuffer.length;
                write(this.sectorBuffer, 0, this.sectorBuffer.length, this.fileHandle);
                j = currentSectorFP;
                i2 = this.sectorSize;
            }
            if (startSectorFP != endSectorFP && endSectorFPLength > 0) {
                int finalWriteLength = this.sectorSize;
                if (fileLength < endSectorFP + this.sectorSize) {
                    finalWriteLength = endSectorFPLength;
                }
                if (read(this.sectorBuffer, 0, finalWriteLength, this.fileHandle) != finalWriteLength) {
                    throw new RuntimeException("Could not read contents of end sector!");
                }
                System.arraycopy(b2, inputPos, this.sectorBuffer, 0, endSectorFPLength);
                seek(endSectorFP, this.fileHandle);
                write(this.sectorBuffer, 0, finalWriteLength, this.fileHandle);
            }
            seek(endFP);
            return;
        }
        throw new RuntimeException("File closed!");
    }

    @Override // org.catacombae.io.Writable
    public void write(int b2) {
        write(new byte[]{(byte) (b2 & 255)});
    }

    @Override // org.catacombae.hfsexplorer.win32.WindowsLowLevelIO
    protected byte[] open(String filename) {
        return openNative(filename);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("The program takes two different files with identical contents as arguments.");
            return;
        }
        try {
            wwf = new WritableWin32File(args[0]);
            ref = new RandomAccessFile(args[1], "rw");
            Random rnd = new Random();
            if (wwf.length() != ref.length()) {
                System.out.println("The two files must be equal in length! (" + wwf.length() + " != " + ref.length() + ")");
                return;
            }
            new BufferedReader(new InputStreamReader(System.in));
            byte[] constantBufferLeft = new byte[3912];
            byte[] constantBufferRight = new byte[3912];
            while (true) {
                wwf.seek(0L);
                long currentSeekPos2 = (long) ((wwf.length() - 1) * rnd.nextDouble());
                int currentBufferSize2 = rnd.nextInt(BZip2Constants.baseBlockSize);
                if (currentSeekPos2 + currentBufferSize2 > wwf.length()) {
                    currentBufferSize2 = (int) (wwf.length() - currentSeekPos2);
                }
                byte[] currentBufferLeft = new byte[currentBufferSize2];
                byte[] currentBufferRight = new byte[currentBufferSize2];
                wwf.seek(currentSeekPos2);
                ref.seek(currentSeekPos2);
                wwf.readFully(currentBufferLeft);
                ref.readFully(currentBufferRight);
                testEquality(currentBufferLeft, currentBufferRight, "(1) Data not equal after reads!");
                if (currentSeekPos2 + currentBufferSize2 + 3912 <= wwf.length()) {
                    wwf.readFully(constantBufferLeft);
                    ref.readFully(constantBufferRight);
                    testEquality(currentBufferLeft, currentBufferRight, "(2) Data following reads not equal!");
                }
                wwf.seek(0L);
                ref.seek(0L);
                wwf.seek(currentSeekPos2);
                ref.seek(currentSeekPos2);
                wwf.write(currentBufferLeft);
                ref.write(currentBufferRight);
                wwf.seek(currentSeekPos2);
                ref.seek(currentSeekPos2);
                wwf.readFully(currentBufferLeft);
                ref.readFully(currentBufferRight);
                testEquality(currentBufferLeft, currentBufferRight, "(3) Data not equal after writes!");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void testEquality(byte[] a2, byte[] b2, String idMessage) throws Exception {
        if (!Util.arraysEqual(a2, b2)) {
            System.out.println(idMessage);
            System.out.println("  currentSeekPos=" + currentSeekPos);
            System.out.println("  currentBufferSize=" + currentBufferSize);
            System.out.println("  wwf.length()=" + wwf.length());
            System.out.println("  ref.length()=" + ref.length());
            System.out.println("  wwf.getFilePointer()=" + wwf.getFilePointer());
            System.out.println("  ref.getFilePointer()=" + ref.getFilePointer());
            System.out.print("Press enter to continue: ");
            stdin.readLine();
        }
    }
}
