package p181e.p182i0.p185g;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import p181e.p182i0.Util;

/* renamed from: e.i0.g.d */
/* loaded from: classes.dex */
public final class HttpDate {

    /* renamed from: a */
    public static final ThreadLocal<DateFormat> f8013a = new C1757a();

    /* renamed from: b */
    public static final String[] f8014b = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};

    /* renamed from: c */
    public static final DateFormat[] f8015c = new DateFormat[f8014b.length];

    /* compiled from: HttpDate.java */
    /* renamed from: e.i0.g.d$a */
    /* loaded from: classes.dex */
    public class C1757a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(Util.f7947n);
            return simpleDateFormat;
        }
    }

    /* renamed from: a */
    public static Date m3075a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f8013a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        synchronized (f8014b) {
            int length = f8014b.length;
            for (int i = 0; i < length; i++) {
                DateFormat dateFormat = f8015c[i];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f8014b[i], Locale.US);
                    dateFormat.setTimeZone(Util.f7947n);
                    f8015c[i] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            return null;
        }
    }

    /* renamed from: a */
    public static String m3074a(Date date) {
        return f8013a.get().format(date);
    }
}
