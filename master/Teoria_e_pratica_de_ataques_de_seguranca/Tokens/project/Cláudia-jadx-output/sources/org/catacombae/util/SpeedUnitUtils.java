package org.catacombae.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
/* JADX WARN: Classes with same name are omitted:
  hfsexplorer-0_21-src.zip:dist/lib/csframework.jar:org/catacombae/util/SpeedUnitUtils.class
 */
/* loaded from: csframework.jar:org/catacombae/util/SpeedUnitUtils.class */
public class SpeedUnitUtils {
    protected static final long kibibyte = mypow(2, 10);
    protected static final long mebibyte = mypow(2, 20);
    protected static final long gibibyte = mypow(2, 30);
    protected static final long tebibyte = mypow(2, 40);
    protected static final long pebibyte = mypow(2, 50);
    protected static final long exbibyte = mypow(2, 60);
    protected static final long kilo = mypow(10, 3);
    protected static final long mega = mypow(10, 6);
    protected static final long giga = mypow(10, 9);
    protected static final long tera = mypow(10, 12);
    protected static final long peta = mypow(10, 15);
    protected static final long exa = mypow(10, 18);
    protected static DecimalFormat standardUnitFormatter = new DecimalFormat("0");

    protected static String format(double d2, DecimalFormat unitFormatter) {
        double rounded = roundDoubleToDecimals(d2, unitFormatter.getMaximumFractionDigits());
        return unitFormatter.format(rounded);
    }

    public static double roundDoubleToDecimals(double d2, int decimals) {
        long integerPart = (long) d2;
        double remaining = d2 - integerPart;
        if (decimals > 0) {
            BigDecimal bd = new BigDecimal(remaining, new MathContext(decimals, RoundingMode.DOWN));
            return integerPart + bd.doubleValue();
        }
        return integerPart;
    }

    public static String bytesToBinaryUnit(long size) {
        return bytesToBinaryUnit(size, standardUnitFormatter);
    }

    public static String bytesToBinaryUnit(long size, DecimalFormat unitFormatter) {
        String result;
        if (size >= exbibyte) {
            result = format(size / exbibyte, unitFormatter) + " EiB";
        } else if (size >= pebibyte) {
            result = format(size / pebibyte, unitFormatter) + " PiB";
        } else if (size >= tebibyte) {
            result = format(size / tebibyte, unitFormatter) + " TiB";
        } else if (size >= gibibyte) {
            result = format(size / gibibyte, unitFormatter) + " GiB";
        } else if (size >= mebibyte) {
            result = format(size / mebibyte, unitFormatter) + " MiB";
        } else if (size >= kibibyte) {
            result = format(size / kibibyte, unitFormatter) + " KiB";
        } else {
            result = size + " B";
        }
        return result;
    }

    public static String bytesToDecimalBitUnit(long bytes) {
        return bytesToDecimalBitUnit(bytes, standardUnitFormatter);
    }

    public static String bytesToDecimalBitUnit(long bytes, DecimalFormat unitFormatter) {
        String result;
        long bits = bytes * 8;
        if (bits >= exa) {
            result = format(bits / exa, unitFormatter) + " Ebit";
        } else if (bits >= peta) {
            result = format(bits / peta, unitFormatter) + " Pbit";
        } else if (bits >= tera) {
            result = format(bits / tera, unitFormatter) + " Tbit";
        } else if (bits >= giga) {
            result = format(bits / giga, unitFormatter) + " Gbit";
        } else if (bits >= mega) {
            result = format(bits / mega, unitFormatter) + " Mbit";
        } else if (bits >= kilo) {
            result = format(bits / kilo, unitFormatter) + " Kbit";
        } else {
            result = bits + " bit";
        }
        return result;
    }

    protected static long mypow(long a2, long n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("b can not be negative");
        }
        long result = 1;
        long j = 0;
        while (true) {
            long i2 = j;
            if (i2 < n) {
                result *= a2;
                j = i2 + 1;
            } else {
                return result;
            }
        }
    }
}
