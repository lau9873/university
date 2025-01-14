package org.catacombae.dmgextractor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/hfsx_dmglib.jar:org/catacombae/dmgextractor/Util.class
 */
/* loaded from: hfsx_dmglib.jar:org/catacombae/dmgextractor/Util.class */
public class Util {
    public static int sectorSize = 2048;

    public static boolean isJava6OrHigher() {
        return System.getProperty("java.vm.version").compareTo("1.6") >= 0;
    }

    public static String byteArrayToHexString(byte[] array) {
        return byteArrayToHexString(array, 0, array.length);
    }

    public static String byteArrayToHexString(byte[] array, int offset, int length) {
        String result = "";
        for (int i2 = offset; i2 < offset + length; i2++) {
            byte b2 = array[i2];
            String currentHexString = Integer.toHexString(b2 & 255);
            if (currentHexString.length() == 1) {
                currentHexString = "0" + currentHexString;
            }
            result = result + currentHexString;
        }
        return result;
    }

    public static String toHexStringBE(char[] array) {
        return toHexStringBE(array, 0, array.length);
    }

    public static String toHexStringBE(char[] array, int offset, int length) {
        StringBuilder result = new StringBuilder();
        for (int i2 = offset; i2 < length; i2++) {
            result.append(toHexStringBE(array[i2]));
        }
        return result.toString();
    }

    public static String toHexStringBE(short[] array) {
        return toHexStringBE(array, 0, array.length);
    }

    public static String toHexStringBE(short[] array, int offset, int length) {
        StringBuilder result = new StringBuilder();
        for (int i2 = offset; i2 < length; i2++) {
            result.append(toHexStringBE(array[i2]));
        }
        return result.toString();
    }

    public static String toHexStringBE(int[] array) {
        return toHexStringBE(array, 0, array.length);
    }

    public static String toHexStringBE(int[] array, int offset, int length) {
        StringBuilder result = new StringBuilder();
        for (int i2 = offset; i2 < length; i2++) {
            result.append(toHexStringBE(array[i2]));
        }
        return result.toString();
    }

    public static String toHexStringLE(byte n) {
        return byteArrayToHexString(toByteArrayLE(n));
    }

    public static String toHexStringLE(short n) {
        return byteArrayToHexString(toByteArrayLE(n));
    }

    public static String toHexStringLE(char n) {
        return byteArrayToHexString(toByteArrayLE(n));
    }

    public static String toHexStringLE(int n) {
        return byteArrayToHexString(toByteArrayLE(n));
    }

    public static String toHexStringLE(long n) {
        return byteArrayToHexString(toByteArrayLE(n));
    }

    public static String toHexStringBE(byte n) {
        return byteArrayToHexString(toByteArrayBE(n));
    }

    public static String toHexStringBE(short n) {
        return byteArrayToHexString(toByteArrayBE(n));
    }

    public static String toHexStringBE(char n) {
        return byteArrayToHexString(toByteArrayBE(n));
    }

    public static String toHexStringBE(int n) {
        return byteArrayToHexString(toByteArrayBE(n));
    }

    public static String toHexStringBE(long n) {
        return byteArrayToHexString(toByteArrayBE(n));
    }

    public static byte[] invert(byte[] array) {
        byte[] newArray = new byte[array.length];
        for (int i2 = 0; i2 < array.length; i2++) {
            newArray[(newArray.length - i2) - 1] = array[i2];
        }
        return newArray;
    }

    public static long readLongLE(byte[] data) {
        return readLongLE(data, 0);
    }

    public static long readLongLE(byte[] data, int offset) {
        return ((data[offset + 7] & 255) << 56) | ((data[offset + 6] & 255) << 48) | ((data[offset + 5] & 255) << 40) | ((data[offset + 4] & 255) << 32) | ((data[offset + 3] & 255) << 24) | ((data[offset + 2] & 255) << 16) | ((data[offset + 1] & 255) << 8) | ((data[offset + 0] & 255) << 0);
    }

    public static int readIntLE(byte[] data) {
        return readIntLE(data, 0);
    }

    public static int readIntLE(byte[] data, int offset) {
        return ((data[offset + 3] & 255) << 24) | ((data[offset + 2] & 255) << 16) | ((data[offset + 1] & 255) << 8) | ((data[offset + 0] & 255) << 0);
    }

    public static short readShortLE(byte[] data) {
        return readShortLE(data, 0);
    }

    public static short readShortLE(byte[] data, int offset) {
        return (short) (((data[offset + 1] & 255) << 8) | ((data[offset + 0] & 255) << 0));
    }

    public static byte readByteLE(byte[] data) {
        return readByteLE(data, 0);
    }

    public static byte readByteLE(byte[] data, int offset) {
        return data[offset];
    }

    public static long readLongBE(byte[] data) {
        return readLongBE(data, 0);
    }

    public static long readLongBE(byte[] data, int offset) {
        return ((data[offset + 0] & 255) << 56) | ((data[offset + 1] & 255) << 48) | ((data[offset + 2] & 255) << 40) | ((data[offset + 3] & 255) << 32) | ((data[offset + 4] & 255) << 24) | ((data[offset + 5] & 255) << 16) | ((data[offset + 6] & 255) << 8) | ((data[offset + 7] & 255) << 0);
    }

    public static int readIntBE(byte[] data) {
        return readIntBE(data, 0);
    }

    public static int readIntBE(byte[] data, int offset) {
        return ((data[offset + 0] & 255) << 24) | ((data[offset + 1] & 255) << 16) | ((data[offset + 2] & 255) << 8) | ((data[offset + 3] & 255) << 0);
    }

    public static short readShortBE(byte[] data) {
        return readShortBE(data, 0);
    }

    public static short readShortBE(byte[] data, int offset) {
        return (short) (((data[offset + 0] & 255) << 8) | ((data[offset + 1] & 255) << 0));
    }

    public static byte readByteBE(byte[] data) {
        return readByteBE(data, 0);
    }

    public static byte readByteBE(byte[] data, int offset) {
        return data[offset];
    }

    public static byte[] toByteArrayLE(byte b2) {
        byte[] result = {b2};
        return result;
    }

    public static byte[] toByteArrayLE(short s) {
        byte[] result = {(byte) ((s >> 0) & 255), (byte) ((s >> 8) & 255)};
        return result;
    }

    public static byte[] toByteArrayLE(char c2) {
        byte[] result = {(byte) ((c2 >> 0) & 255), (byte) ((c2 >> '\b') & 255)};
        return result;
    }

    public static byte[] toByteArrayLE(int i2) {
        byte[] result = {(byte) ((i2 >> 0) & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)};
        return result;
    }

    public static byte[] toByteArrayLE(long l) {
        byte[] result = {(byte) ((l >> 0) & 255), (byte) ((l >> 8) & 255), (byte) ((l >> 16) & 255), (byte) ((l >> 24) & 255), (byte) ((l >> 32) & 255), (byte) ((l >> 40) & 255), (byte) ((l >> 48) & 255), (byte) ((l >> 56) & 255)};
        return result;
    }

    public static byte[] toByteArrayBE(byte b2) {
        byte[] result = {b2};
        return result;
    }

    public static byte[] toByteArrayBE(short s) {
        byte[] result = {(byte) ((s >> 8) & 255), (byte) ((s >> 0) & 255)};
        return result;
    }

    public static byte[] toByteArrayBE(char c2) {
        byte[] result = {(byte) ((c2 >> '\b') & 255), (byte) ((c2 >> 0) & 255)};
        return result;
    }

    public static byte[] toByteArrayBE(int i2) {
        byte[] result = {(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 0) & 255)};
        return result;
    }

    public static byte[] toByteArrayBE(long l) {
        byte[] result = {(byte) ((l >> 56) & 255), (byte) ((l >> 48) & 255), (byte) ((l >> 40) & 255), (byte) ((l >> 32) & 255), (byte) ((l >> 24) & 255), (byte) ((l >> 16) & 255), (byte) ((l >> 8) & 255), (byte) ((l >> 0) & 255)};
        return result;
    }

    public static boolean zeroed(byte[] ba) {
        for (byte b2 : ba) {
            if (b2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void zero(byte[]... arrays) {
        for (byte[] ba : arrays) {
            set(ba, 0, ba.length, (byte) 0);
        }
    }

    public static void zero(byte[] ba, int offset, int length) {
        set(ba, offset, length, (byte) 0);
    }

    public static void zero(short[]... arrays) {
        for (short[] array : arrays) {
            set(array, 0, array.length, (short) 0);
        }
    }

    public static void zero(short[] ba, int offset, int length) {
        set(ba, offset, length, (short) 0);
    }

    public static void zero(int[]... arrays) {
        for (int[] array : arrays) {
            set(array, 0, array.length, 0);
        }
    }

    public static void zero(int[] ba, int offset, int length) {
        set(ba, offset, length, 0);
    }

    public static void zero(long[]... arrays) {
        for (long[] array : arrays) {
            set(array, 0, array.length, 0L);
        }
    }

    public static void zero(long[] ba, int offset, int length) {
        set(ba, offset, length, 0L);
    }

    public static void set(boolean[] array, boolean value) {
        set(array, 0, array.length, value);
    }

    public static void set(byte[] array, byte value) {
        set(array, 0, array.length, value);
    }

    public static void set(short[] array, short value) {
        set(array, 0, array.length, value);
    }

    public static void set(char[] array, char value) {
        set(array, 0, array.length, value);
    }

    public static void set(int[] array, int value) {
        set(array, 0, array.length, value);
    }

    public static void set(long[] array, long value) {
        set(array, 0, array.length, value);
    }

    public static <T> void set(T[] array, T value) {
        set(array, 0, array.length, value);
    }

    public static void set(boolean[] ba, int offset, int length, boolean value) {
        for (int i2 = offset; i2 < length; i2++) {
            ba[i2] = value;
        }
    }

    public static void set(byte[] ba, int offset, int length, byte value) {
        for (int i2 = offset; i2 < length; i2++) {
            ba[i2] = value;
        }
    }

    public static void set(short[] ba, int offset, int length, short value) {
        for (int i2 = offset; i2 < length; i2++) {
            ba[i2] = value;
        }
    }

    public static void set(char[] ba, int offset, int length, char value) {
        for (int i2 = offset; i2 < length; i2++) {
            ba[i2] = value;
        }
    }

    public static void set(int[] ba, int offset, int length, int value) {
        for (int i2 = offset; i2 < length; i2++) {
            ba[i2] = value;
        }
    }

    public static void set(long[] ba, int offset, int length, long value) {
        for (int i2 = offset; i2 < length; i2++) {
            ba[i2] = value;
        }
    }

    public static <T> void set(T[] ba, int offset, int length, T value) {
        for (int i2 = offset; i2 < length; i2++) {
            ba[i2] = value;
        }
    }

    public static byte[] createCopy(byte[] data) {
        return createCopy(data, 0, data.length);
    }

    public static byte[] createCopy(byte[] data, int offset, int length) {
        byte[] copy = new byte[length];
        System.arraycopy(data, offset, copy, 0, length);
        return copy;
    }

    public static byte[] createReverseCopy(byte[] data) {
        return createReverseCopy(data, 0, data.length);
    }

    public static byte[] createReverseCopy(byte[] data, int offset, int length) {
        byte[] copy = new byte[length];
        for (int i2 = 0; i2 < copy.length; i2++) {
            copy[i2] = data[offset + ((length - i2) - 1)];
        }
        return copy;
    }

    public static byte[] arrayCopy(byte[] source, byte[] dest) {
        return arrayCopy(source, dest, 0);
    }

    public static byte[] arrayCopy(byte[] source, byte[] dest, int destPos) {
        if (dest.length - destPos < source.length) {
            throw new RuntimeException("Destination array not large enough.");
        }
        System.arraycopy(source, 0, dest, 0, source.length);
        return dest;
    }

    public static <T> T[] arrayCopy(T[] source, T[] dest) {
        return (T[]) arrayCopy(source, dest, 0);
    }

    public static <T> T[] arrayCopy(T[] source, T[] dest, int destPos) {
        if (dest.length - destPos < source.length) {
            throw new RuntimeException("Destination array not large enough.");
        }
        System.arraycopy(source, 0, dest, 0, source.length);
        return dest;
    }

    public static boolean arraysEqual(boolean[] a2, boolean[] b2) {
        return arrayRegionsEqual(a2, 0, a2.length, b2, 0, b2.length);
    }

    public static boolean arrayRegionsEqual(boolean[] a2, int aoff, int alen, boolean[] b2, int boff, int blen) {
        if (alen != blen) {
            return false;
        }
        for (int i2 = 0; i2 < alen; i2++) {
            if (a2[aoff + i2] != b2[boff + i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean arraysEqual(byte[] a2, byte[] b2) {
        return arrayRegionsEqual(a2, 0, a2.length, b2, 0, b2.length);
    }

    public static boolean arrayRegionsEqual(byte[] a2, int aoff, int alen, byte[] b2, int boff, int blen) {
        if (a2.length != blen) {
            return false;
        }
        for (int i2 = 0; i2 < alen; i2++) {
            if (a2[aoff + i2] != b2[boff + i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean arraysEqual(char[] a2, char[] b2) {
        return arrayRegionsEqual(a2, 0, a2.length, b2, 0, b2.length);
    }

    public static boolean arrayRegionsEqual(char[] a2, int aoff, int alen, char[] b2, int boff, int blen) {
        if (alen != blen) {
            return false;
        }
        for (int i2 = 0; i2 < alen; i2++) {
            if (a2[aoff + i2] != b2[boff + i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean arraysEqual(short[] a2, short[] b2) {
        return arrayRegionsEqual(a2, 0, a2.length, b2, 0, b2.length);
    }

    public static boolean arrayRegionsEqual(short[] a2, int aoff, int alen, short[] b2, int boff, int blen) {
        if (alen != blen) {
            return false;
        }
        for (int i2 = 0; i2 < alen; i2++) {
            if (a2[aoff + i2] != b2[boff + i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean arraysEqual(int[] a2, int[] b2) {
        return arrayRegionsEqual(a2, 0, a2.length, b2, 0, b2.length);
    }

    public static boolean arrayRegionsEqual(int[] a2, int aoff, int alen, int[] b2, int boff, int blen) {
        if (alen != blen) {
            return false;
        }
        for (int i2 = 0; i2 < alen; i2++) {
            if (a2[aoff + i2] != b2[boff + i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean arraysEqual(long[] a2, long[] b2) {
        return arrayRegionsEqual(a2, 0, a2.length, b2, 0, b2.length);
    }

    public static boolean arrayRegionsEqual(long[] a2, int aoff, int alen, long[] b2, int boff, int blen) {
        if (alen != blen) {
            return false;
        }
        for (int i2 = 0; i2 < alen; i2++) {
            if (a2[aoff + i2] != b2[boff + i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean arraysEqual(Object[] a2, Object[] b2) {
        return arrayRegionsEqual(a2, 0, a2.length, b2, 0, b2.length);
    }

    public static boolean arrayRegionsEqual(Object[] a2, int aoff, int alen, Object[] b2, int boff, int blen) {
        if (alen != blen) {
            return false;
        }
        for (int i2 = 0; i2 < alen; i2++) {
            if (!a2[aoff + i2].equals(b2[boff + i2])) {
                return false;
            }
        }
        return true;
    }

    public static long pow(long a2, long b2) {
        if (b2 < 0) {
            throw new IllegalArgumentException("b can not be negative");
        }
        long result = 1;
        long j = 0;
        while (true) {
            long i2 = j;
            if (i2 < b2) {
                result *= a2;
                j = i2 + 1;
            } else {
                return result;
            }
        }
    }

    public static int strlen(byte[] data) {
        int length = 0;
        for (byte b2 : data) {
            if (b2 == 0) {
                break;
            }
            length++;
        }
        return length;
    }

    public static boolean getBit(long data, int bitNumber) {
        return ((data >>> bitNumber) & 1) == 1;
    }

    public static int arrayCompareLex(byte[] a2, byte[] b2) {
        return arrayCompareLex(a2, 0, a2.length, b2, 0, b2.length);
    }

    public static int arrayCompareLex(byte[] a2, int aoff, int alen, byte[] b2, int boff, int blen) {
        int compareLen = alen < blen ? alen : blen;
        for (int i2 = 0; i2 < compareLen; i2++) {
            byte curA = a2[aoff + i2];
            byte curB = b2[boff + i2];
            if (curA != curB) {
                return curA - curB;
            }
        }
        return alen - blen;
    }

    public static int unsignedArrayCompareLex(char[] a2, char[] b2) {
        return unsignedArrayCompareLex(a2, 0, a2.length, b2, 0, b2.length);
    }

    public static int unsignedArrayCompareLex(char[] a2, int aoff, int alen, char[] b2, int boff, int blen) {
        int compareLen = alen < blen ? alen : blen;
        for (int i2 = 0; i2 < compareLen; i2++) {
            int curA = a2[aoff + i2] & 65535;
            int curB = b2[boff + i2] & 65535;
            if (curA != curB) {
                return curA - curB;
            }
        }
        return alen - blen;
    }

    public static String toASCIIString(byte[] data) {
        return toASCIIString(data, 0, data.length);
    }

    public static String toASCIIString(byte[] data, int offset, int length) {
        return readString(data, offset, length, "US-ASCII");
    }

    public static String toASCIIString(short i2) {
        return toASCIIString(toByteArrayBE(i2));
    }

    public static String toASCIIString(int i2) {
        return toASCIIString(toByteArrayBE(i2));
    }

    public static String readString(byte[] data, String encoding) {
        return readString(data, 0, data.length, encoding);
    }

    public static String readString(byte[] data, int offset, int length, String encoding) {
        try {
            return new String(data, offset, length, encoding);
        } catch (Exception e2) {
            return null;
        }
    }

    public static String readString(short i2, String encoding) {
        return readString(toByteArrayBE(i2), encoding);
    }

    public static String readString(int i2, String encoding) {
        return readString(toByteArrayBE(i2), encoding);
    }

    public static String readNullTerminatedASCIIString(byte[] data) {
        return readNullTerminatedASCIIString(data, 0, data.length);
    }

    public static String readNullTerminatedASCIIString(byte[] data, int offset, int maxLength) {
        int i2 = offset;
        while (i2 < offset + maxLength && data[i2] != 0) {
            i2++;
        }
        return toASCIIString(data, offset, i2 - offset);
    }

    public static char readCharLE(byte[] data) {
        return readCharLE(data, 0);
    }

    public static char readCharLE(byte[] data, int offset) {
        return (char) (((data[offset + 1] & 255) << 8) | ((data[offset + 0] & 255) << 0));
    }

    public static char readCharBE(byte[] data) {
        return readCharBE(data, 0);
    }

    public static char readCharBE(byte[] data, int offset) {
        return (char) (((data[offset + 0] & 255) << 8) | ((data[offset + 1] & 255) << 0));
    }

    public static byte[] readByteArrayBE(byte[] b2) {
        return createCopy(b2);
    }

    public static char[] readCharArrayBE(byte[] b2) {
        char[] result = new char[b2.length / 2];
        for (int i2 = 0; i2 < result.length; i2++) {
            result[i2] = readCharBE(b2, i2 * 2);
        }
        return result;
    }

    public static short[] readShortArrayBE(byte[] b2) {
        short[] result = new short[b2.length / 2];
        for (int i2 = 0; i2 < result.length; i2++) {
            result[i2] = readShortBE(b2, i2 * 2);
        }
        return result;
    }

    public static int[] readIntArrayBE(byte[] b2) {
        int[] result = new int[b2.length / 4];
        for (int i2 = 0; i2 < result.length; i2++) {
            result[i2] = readIntBE(b2, i2 * 4);
        }
        return result;
    }

    public static long[] readLongArrayBE(byte[] b2) {
        long[] result = new long[b2.length / 8];
        for (int i2 = 0; i2 < result.length; i2++) {
            result[i2] = readLongBE(b2, i2 * 8);
        }
        return result;
    }

    public static byte[] readByteArrayLE(char[] data) {
        return readByteArrayLE(data, 0, data.length);
    }

    public static byte[] readByteArrayLE(char[] data, int offset, int size) {
        byte[] result = new byte[data.length * 2];
        for (int i2 = 0; i2 < data.length; i2++) {
            byte[] cur = toByteArrayLE(data[i2]);
            result[i2 * 2] = cur[0];
            result[(i2 * 2) + 1] = cur[1];
        }
        return result;
    }

    public static byte[] readByteArrayBE(char[] data) {
        return readByteArrayBE(data, 0, data.length);
    }

    public static byte[] readByteArrayBE(char[] data, int offset, int size) {
        byte[] result = new byte[data.length * 2];
        for (int i2 = 0; i2 < data.length; i2++) {
            byte[] cur = toByteArrayBE(data[i2]);
            result[i2 * 2] = cur[0];
            result[(i2 * 2) + 1] = cur[1];
        }
        return result;
    }

    public static byte[] fillBuffer(InputStream is, byte[] buffer) throws IOException {
        DataInputStream dis = new DataInputStream(is);
        dis.readFully(buffer);
        return buffer;
    }

    public static short unsign(byte b2) {
        return (short) (b2 & 255);
    }

    public static int unsign(short s) {
        return s & 65535;
    }

    public static long unsign(int i2) {
        return i2 & 4294967295L;
    }

    public static String readFully(Reader r) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] temp = new char[512];
        int read = r.read(temp, 0, temp.length);
        while (true) {
            int curBytesRead = read;
            if (curBytesRead >= 0) {
                sb.append(temp, 0, curBytesRead);
                read = r.read(temp, 0, temp.length);
            } else {
                return sb.toString();
            }
        }
    }

    public static String[] concatenate(String[] a2, String[] b2) {
        String[] c2 = new String[a2.length + b2.length];
        System.arraycopy(a2, 0, c2, 0, a2.length);
        System.arraycopy(b2, 0, c2, a2.length, b2.length);
        return c2;
    }

    public static byte[] encodeString(String string, String encoding) {
        try {
            return string.getBytes(encoding);
        } catch (Exception e2) {
            return null;
        }
    }
}
