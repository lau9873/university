package net.iharder.base64;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/iharder-base64.jar:net/iharder/base64/Base64.class
 */
/* loaded from: iharder-base64.jar:net/iharder/base64/Base64.class */
public class Base64 {
    public static final int NO_OPTIONS = 0;
    public static final int ENCODE = 1;
    public static final int DECODE = 0;
    public static final int GZIP = 2;
    public static final int DONT_BREAK_LINES = 8;
    public static final int URL_SAFE = 16;
    public static final int ORDERED = 32;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte EQUALS_SIGN = 61;
    private static final byte NEW_LINE = 10;
    private static final String PREFERRED_ENCODING = "UTF-8";
    private static final byte WHITE_SPACE_ENC = -5;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final byte[] _STANDARD_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] _STANDARD_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};
    private static final byte[] _URL_SAFE_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] _URL_SAFE_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9};
    private static final byte[] _ORDERED_ALPHABET = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] _ORDERED_DECODABET = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9};

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getAlphabet(int i2) {
        return (i2 & 16) == 16 ? _URL_SAFE_ALPHABET : (i2 & 32) == 32 ? _ORDERED_ALPHABET : _STANDARD_ALPHABET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] getDecodabet(int i2) {
        return (i2 & 16) == 16 ? _URL_SAFE_DECODABET : (i2 & 32) == 32 ? _ORDERED_DECODABET : _STANDARD_DECODABET;
    }

    private Base64() {
    }

    public static final void main(String[] strArr) {
        if (strArr.length < 3) {
            usage("Not enough arguments.");
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        String str3 = strArr[2];
        if (str.equals("-e")) {
            encodeFileToFile(str2, str3);
        } else if (str.equals("-d")) {
            decodeFileToFile(str2, str3);
        } else {
            usage("Unknown flag: " + str);
        }
    }

    private static final void usage(String str) {
        System.err.println(str);
        System.err.println("Usage: java Base64 -e|-d inputfile outputfile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, byte[] bArr2, int i2, int i3) {
        encode3to4(bArr2, 0, i2, bArr, 0, i3);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] encode3to4(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        byte[] alphabet = getAlphabet(i5);
        int i6 = (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0) | (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 2 ? (bArr[i2 + 2] << 24) >>> 24 : 0);
        switch (i3) {
            case 1:
                bArr2[i4] = alphabet[i6 >>> 18];
                bArr2[i4 + 1] = alphabet[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = 61;
                bArr2[i4 + 3] = 61;
                return bArr2;
            case 2:
                bArr2[i4] = alphabet[i6 >>> 18];
                bArr2[i4 + 1] = alphabet[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = alphabet[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = 61;
                return bArr2;
            case 3:
                bArr2[i4] = alphabet[i6 >>> 18];
                bArr2[i4 + 1] = alphabet[(i6 >>> 12) & 63];
                bArr2[i4 + 2] = alphabet[(i6 >>> 6) & 63];
                bArr2[i4 + 3] = alphabet[i6 & 63];
                return bArr2;
            default:
                return bArr2;
        }
    }

    public static String encodeObject(Serializable serializable) {
        return encodeObject(serializable, 0);
    }

    public static String encodeObject(Serializable serializable, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        OutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        GZIPOutputStream gZIPOutputStream = null;
        int i3 = i2 & 2;
        int i4 = i2 & 8;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                outputStream = new OutputStream(byteArrayOutputStream, 1 | i2);
                if (i3 == 2) {
                    gZIPOutputStream = new GZIPOutputStream(outputStream);
                    objectOutputStream = new ObjectOutputStream(gZIPOutputStream);
                } else {
                    objectOutputStream = new ObjectOutputStream(outputStream);
                }
                objectOutputStream.writeObject(serializable);
                try {
                    objectOutputStream.close();
                } catch (Exception e2) {
                }
                try {
                    gZIPOutputStream.close();
                } catch (Exception e3) {
                }
                try {
                    outputStream.close();
                } catch (Exception e4) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e5) {
                }
                try {
                    return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                } catch (UnsupportedEncodingException e6) {
                    return new String(byteArrayOutputStream.toByteArray());
                }
            } catch (Throwable th) {
                try {
                    objectOutputStream.close();
                } catch (Exception e7) {
                }
                try {
                    gZIPOutputStream.close();
                } catch (Exception e8) {
                }
                try {
                    outputStream.close();
                } catch (Exception e9) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e10) {
                }
                throw th;
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            try {
                objectOutputStream.close();
            } catch (Exception e12) {
            }
            try {
                gZIPOutputStream.close();
            } catch (Exception e13) {
            }
            try {
                outputStream.close();
            } catch (Exception e14) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (Exception e15) {
            }
            return null;
        }
    }

    public static String encodeBytes(byte[] bArr) {
        return encodeBytes(bArr, 0, bArr.length, 0);
    }

    public static String encodeBytes(byte[] bArr, int i2) {
        return encodeBytes(bArr, 0, bArr.length, i2);
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3) {
        return encodeBytes(bArr, i2, i3, 0);
    }

    public static String encodeBytes(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i4 & 8;
        if ((i4 & 2) == 2) {
            ByteArrayOutputStream byteArrayOutputStream = null;
            GZIPOutputStream gZIPOutputStream = null;
            OutputStream outputStream = null;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    outputStream = new OutputStream(byteArrayOutputStream, 1 | i4);
                    gZIPOutputStream = new GZIPOutputStream(outputStream);
                    gZIPOutputStream.write(bArr, i2, i3);
                    gZIPOutputStream.close();
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e2) {
                    }
                    try {
                        outputStream.close();
                    } catch (Exception e3) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e4) {
                    }
                    try {
                        return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    } catch (UnsupportedEncodingException e5) {
                        return new String(byteArrayOutputStream.toByteArray());
                    }
                } catch (IOException e6) {
                    e6.printStackTrace();
                    try {
                        gZIPOutputStream.close();
                    } catch (Exception e7) {
                    }
                    try {
                        outputStream.close();
                    } catch (Exception e8) {
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e9) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Exception e10) {
                }
                try {
                    outputStream.close();
                } catch (Exception e11) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e12) {
                }
                throw th;
            }
        }
        boolean z = i5 == 0;
        int i6 = (i3 * 4) / 3;
        byte[] bArr2 = new byte[i6 + (i3 % 3 > 0 ? 4 : 0) + (z ? i6 / 76 : 0)];
        int i7 = 0;
        int i8 = 0;
        int i9 = i3 - 2;
        int i10 = 0;
        while (i7 < i9) {
            encode3to4(bArr, i7 + i2, 3, bArr2, i8, i4);
            i10 += 4;
            if (z && i10 == 76) {
                bArr2[i8 + 4] = 10;
                i8++;
                i10 = 0;
            }
            i7 += 3;
            i8 += 4;
        }
        if (i7 < i3) {
            encode3to4(bArr, i7 + i2, i3 - i7, bArr2, i8, i4);
            i8 += 4;
        }
        try {
            return new String(bArr2, 0, i8, "UTF-8");
        } catch (UnsupportedEncodingException e13) {
            return new String(bArr2, 0, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int decode4to3(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        byte[] decodabet = getDecodabet(i4);
        if (bArr[i2 + 2] == 61) {
            bArr2[i3] = (byte) ((((decodabet[bArr[i2]] & 255) << 18) | ((decodabet[bArr[i2 + 1]] & 255) << 12)) >>> 16);
            return 1;
        } else if (bArr[i2 + 3] == 61) {
            int i5 = ((decodabet[bArr[i2]] & 255) << 18) | ((decodabet[bArr[i2 + 1]] & 255) << 12) | ((decodabet[bArr[i2 + 2]] & 255) << 6);
            bArr2[i3] = (byte) (i5 >>> 16);
            bArr2[i3 + 1] = (byte) (i5 >>> 8);
            return 2;
        } else {
            try {
                int i6 = ((decodabet[bArr[i2]] & 255) << 18) | ((decodabet[bArr[i2 + 1]] & 255) << 12) | ((decodabet[bArr[i2 + 2]] & 255) << 6) | (decodabet[bArr[i2 + 3]] & 255);
                bArr2[i3] = (byte) (i6 >> 16);
                bArr2[i3 + 1] = (byte) (i6 >> 8);
                bArr2[i3 + 2] = (byte) i6;
                return 3;
            } catch (Exception e2) {
                System.out.println("" + ((int) bArr[i2]) + ": " + ((int) decodabet[bArr[i2]]));
                System.out.println("" + ((int) bArr[i2 + 1]) + ": " + ((int) decodabet[bArr[i2 + 1]]));
                System.out.println("" + ((int) bArr[i2 + 2]) + ": " + ((int) decodabet[bArr[i2 + 2]]));
                System.out.println("" + ((int) bArr[i2 + 3]) + ": " + ((int) decodabet[bArr[i2 + 3]]));
                return -1;
            }
        }
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) {
        byte[] decodabet = getDecodabet(i4);
        byte[] bArr2 = new byte[(i3 * 3) / 4];
        int i5 = 0;
        byte[] bArr3 = new byte[4];
        int i6 = 0;
        for (int i7 = i2; i7 < i2 + i3; i7++) {
            byte b2 = (byte) (bArr[i7] & Byte.MAX_VALUE);
            byte b3 = decodabet[b2];
            if (b3 >= -5) {
                if (b3 >= -1) {
                    int i8 = i6;
                    i6++;
                    bArr3[i8] = b2;
                    if (i6 > 3) {
                        i5 += decode4to3(bArr3, 0, bArr2, i5, i4);
                        i6 = 0;
                        if (b2 == 61) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                System.err.println("Bad Base64 input character at " + i7 + ": " + ((int) bArr[i7]) + "(decimal)");
                return null;
            }
        }
        byte[] bArr4 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr4, 0, i5);
        return bArr4;
    }

    public static byte[] decode(String str) {
        return decode(str, 0);
    }

    public static byte[] decode(String str, int i2) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            bytes = str.getBytes();
        }
        byte[] decode = decode(bytes, 0, bytes.length, i2);
        if (decode != null && decode.length >= 4 && 35615 == ((decode[0] & 255) | ((decode[1] << 8) & 65280))) {
            ByteArrayInputStream byteArrayInputStream = null;
            GZIPInputStream gZIPInputStream = null;
            ByteArrayOutputStream byteArrayOutputStream = null;
            byte[] bArr = new byte[2048];
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayInputStream = new ByteArrayInputStream(decode);
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                decode = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e3) {
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception e4) {
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception e5) {
                }
            } catch (IOException e6) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e7) {
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception e8) {
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception e9) {
                }
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e10) {
                }
                try {
                    gZIPInputStream.close();
                } catch (Exception e11) {
                }
                try {
                    byteArrayInputStream.close();
                } catch (Exception e12) {
                }
                throw th;
            }
        }
        return decode;
    }

    public static Object decodeToObject(String str) {
        Object obj;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(decode(str));
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                obj = objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (Exception e2) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception e3) {
                }
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Exception e4) {
                }
                try {
                    objectInputStream.close();
                } catch (Exception e5) {
                }
                throw th;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
            obj = null;
            try {
                byteArrayInputStream.close();
            } catch (Exception e7) {
            }
            try {
                objectInputStream.close();
            } catch (Exception e8) {
            }
        } catch (ClassNotFoundException e9) {
            e9.printStackTrace();
            obj = null;
            try {
                byteArrayInputStream.close();
            } catch (Exception e10) {
            }
            try {
                objectInputStream.close();
            } catch (Exception e11) {
            }
        }
        return obj;
    }

    public static boolean encodeToFile(byte[] bArr, String str) {
        boolean z;
        OutputStream outputStream = null;
        try {
            outputStream = new OutputStream(new FileOutputStream(str), 1);
            outputStream.write(bArr);
            z = true;
            try {
                outputStream.close();
            } catch (Exception e2) {
            }
        } catch (IOException e3) {
            z = false;
            try {
                outputStream.close();
            } catch (Exception e4) {
            }
        } catch (Throwable th) {
            try {
                outputStream.close();
            } catch (Exception e5) {
            }
            throw th;
        }
        return z;
    }

    public static boolean decodeToFile(String str, String str2) {
        boolean z;
        OutputStream outputStream = null;
        try {
            outputStream = new OutputStream(new FileOutputStream(str2), 0);
            outputStream.write(str.getBytes("UTF-8"));
            z = true;
            try {
                outputStream.close();
            } catch (Exception e2) {
            }
        } catch (IOException e3) {
            z = false;
            try {
                outputStream.close();
            } catch (Exception e4) {
            }
        } catch (Throwable th) {
            try {
                outputStream.close();
            } catch (Exception e5) {
            }
            throw th;
        }
        return z;
    }

    public static byte[] decodeFromFile(String str) {
        File file;
        int i2;
        byte[] bArr = null;
        InputStream inputStream = null;
        try {
            try {
                file = new File(str);
                i2 = 0;
            } catch (IOException e2) {
                System.err.println("Error decoding from file " + str);
                try {
                    inputStream.close();
                } catch (Exception e3) {
                }
            }
            if (file.length() > 2147483647L) {
                System.err.println("File is too big for this convenience method (" + file.length() + " bytes).");
                try {
                    inputStream.close();
                } catch (Exception e4) {
                }
                return null;
            }
            byte[] bArr2 = new byte[(int) file.length()];
            InputStream inputStream2 = new InputStream(new BufferedInputStream(new FileInputStream(file)), 0);
            while (true) {
                int read = inputStream2.read(bArr2, i2, 4096);
                if (read < 0) {
                    break;
                }
                i2 += read;
            }
            bArr = new byte[i2];
            System.arraycopy(bArr2, 0, bArr, 0, i2);
            try {
                inputStream2.close();
            } catch (Exception e5) {
            }
            return bArr;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Exception e6) {
            }
            throw th;
        }
    }

    public static String encodeFromFile(String str) {
        String str2 = null;
        InputStream inputStream = null;
        try {
            try {
                File file = new File(str);
                byte[] bArr = new byte[Math.max((int) (file.length() * 1.4d), 40)];
                int i2 = 0;
                inputStream = new InputStream(new BufferedInputStream(new FileInputStream(file)), 1);
                while (true) {
                    int read = inputStream.read(bArr, i2, 4096);
                    if (read < 0) {
                        break;
                    }
                    i2 += read;
                }
                str2 = new String(bArr, 0, i2, "UTF-8");
                try {
                    inputStream.close();
                } catch (Exception e2) {
                }
            } catch (IOException e3) {
                System.err.println("Error encoding from file " + str);
                try {
                    inputStream.close();
                } catch (Exception e4) {
                }
            }
            return str2;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (Exception e5) {
            }
            throw th;
        }
    }

    public static void encodeFileToFile(String str, String str2) {
        String encodeFromFile = encodeFromFile(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                bufferedOutputStream.write(encodeFromFile.getBytes("US-ASCII"));
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e3) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
            try {
                bufferedOutputStream.close();
            } catch (Exception e5) {
            }
        }
    }

    public static void decodeFileToFile(String str, String str2) {
        byte[] decodeFromFile = decodeFromFile(str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                bufferedOutputStream.write(decodeFromFile);
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                try {
                    bufferedOutputStream.close();
                } catch (Exception e4) {
                }
            }
        } catch (Throwable th) {
            try {
                bufferedOutputStream.close();
            } catch (Exception e5) {
            }
            throw th;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/iharder-base64.jar:net/iharder/base64/Base64$InputStream.class
     */
    /* loaded from: iharder-base64.jar:net/iharder/base64/Base64$InputStream.class */
    public static class InputStream extends FilterInputStream {
        private boolean encode;
        private int position;
        private byte[] buffer;
        private int bufferLength;
        private int numSigBytes;
        private int lineLength;
        private boolean breakLines;
        private int options;
        private byte[] alphabet;
        private byte[] decodabet;

        public InputStream(java.io.InputStream inputStream) {
            this(inputStream, 0);
        }

        public InputStream(java.io.InputStream inputStream, int i2) {
            super(inputStream);
            this.breakLines = (i2 & 8) != 8;
            this.encode = (i2 & 1) == 1;
            this.bufferLength = this.encode ? 4 : 3;
            this.buffer = new byte[this.bufferLength];
            this.position = -1;
            this.lineLength = 0;
            this.options = i2;
            this.alphabet = Base64.getAlphabet(i2);
            this.decodabet = Base64.getDecodabet(i2);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read;
            if (this.position < 0) {
                if (this.encode) {
                    byte[] bArr = new byte[3];
                    int i2 = 0;
                    for (int i3 = 0; i3 < 3; i3++) {
                        try {
                            int read2 = this.in.read();
                            if (read2 >= 0) {
                                bArr[i3] = (byte) read2;
                                i2++;
                            }
                        } catch (IOException e2) {
                            if (i3 == 0) {
                                throw e2;
                            }
                        }
                    }
                    if (i2 > 0) {
                        Base64.encode3to4(bArr, 0, i2, this.buffer, 0, this.options);
                        this.position = 0;
                        this.numSigBytes = 4;
                    } else {
                        return -1;
                    }
                } else {
                    byte[] bArr2 = new byte[4];
                    int i4 = 0;
                    while (i4 < 4) {
                        do {
                            read = this.in.read();
                            if (read < 0) {
                                break;
                            }
                        } while (this.decodabet[read & 127] <= -5);
                        if (read < 0) {
                            break;
                        }
                        bArr2[i4] = (byte) read;
                        i4++;
                    }
                    if (i4 == 4) {
                        this.numSigBytes = Base64.decode4to3(bArr2, 0, this.buffer, 0, this.options);
                        this.position = 0;
                    } else if (i4 == 0) {
                        return -1;
                    } else {
                        throw new IOException("Improperly padded Base64 input.");
                    }
                }
            }
            if (this.position >= 0) {
                if (this.position >= this.numSigBytes) {
                    return -1;
                }
                if (this.encode && this.breakLines && this.lineLength >= 76) {
                    this.lineLength = 0;
                    return 10;
                }
                this.lineLength++;
                byte[] bArr3 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                byte b2 = bArr3[i5];
                if (this.position >= this.bufferLength) {
                    this.position = -1;
                }
                return b2 & 255;
            }
            throw new IOException("Error in Base64 code reading stream.");
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                int read = read();
                if (read >= 0) {
                    bArr[i2 + i4] = (byte) read;
                    i4++;
                } else if (i4 == 0) {
                    return -1;
                }
            }
            return i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
      hfsexplorer-0_21-src.zip:dist/lib/iharder-base64.jar:net/iharder/base64/Base64$OutputStream.class
     */
    /* loaded from: iharder-base64.jar:net/iharder/base64/Base64$OutputStream.class */
    public static class OutputStream extends FilterOutputStream {
        private boolean encode;
        private int position;
        private byte[] buffer;
        private int bufferLength;
        private int lineLength;
        private boolean breakLines;
        private byte[] b4;
        private boolean suspendEncoding;
        private int options;
        private byte[] alphabet;
        private byte[] decodabet;

        public OutputStream(java.io.OutputStream outputStream) {
            this(outputStream, 1);
        }

        public OutputStream(java.io.OutputStream outputStream, int i2) {
            super(outputStream);
            this.breakLines = (i2 & 8) != 8;
            this.encode = (i2 & 1) == 1;
            this.bufferLength = this.encode ? 3 : 4;
            this.buffer = new byte[this.bufferLength];
            this.position = 0;
            this.lineLength = 0;
            this.suspendEncoding = false;
            this.b4 = new byte[4];
            this.options = i2;
            this.alphabet = Base64.getAlphabet(i2);
            this.decodabet = Base64.getDecodabet(i2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(i2);
            } else if (this.encode) {
                byte[] bArr = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr[i3] = (byte) i2;
                if (this.position >= this.bufferLength) {
                    this.out.write(Base64.encode3to4(this.b4, this.buffer, this.bufferLength, this.options));
                    this.lineLength += 4;
                    if (this.breakLines && this.lineLength >= 76) {
                        this.out.write(10);
                        this.lineLength = 0;
                    }
                    this.position = 0;
                }
            } else if (this.decodabet[i2 & 127] > -5) {
                byte[] bArr2 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr2[i4] = (byte) i2;
                if (this.position >= this.bufferLength) {
                    this.out.write(this.b4, 0, Base64.decode4to3(this.buffer, 0, this.b4, 0, this.options));
                    this.position = 0;
                }
            } else if (this.decodabet[i2 & 127] != -5) {
                throw new IOException("Invalid character in Base64 data.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            if (this.suspendEncoding) {
                ((FilterOutputStream) this).out.write(bArr, i2, i3);
                return;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                write(bArr[i2 + i4]);
            }
        }

        public void flushBase64() throws IOException {
            if (this.position > 0) {
                if (this.encode) {
                    this.out.write(Base64.encode3to4(this.b4, this.buffer, this.position, this.options));
                    this.position = 0;
                    return;
                }
                throw new IOException("Base64 input not properly padded.");
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            flushBase64();
            super.close();
            this.buffer = null;
            this.out = null;
        }

        public void suspendEncoding() throws IOException {
            flushBase64();
            this.suspendEncoding = true;
        }

        public void resumeEncoding() {
            this.suspendEncoding = false;
        }
    }
}
