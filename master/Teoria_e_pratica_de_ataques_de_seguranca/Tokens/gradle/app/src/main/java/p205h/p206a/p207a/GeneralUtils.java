package p205h.p206a.p207a;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import java.math.BigInteger;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.a.a.p */
/* loaded from: classes.dex */
public class GeneralUtils {

    /* renamed from: a */
    public static String f9402a = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: a */
    public static String m1597a(Date date, String str) {
        if (date != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Lisbon"));
                return simpleDateFormat.format(date);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m1593b(Date date) {
        return m1597a(date, f9402a);
    }

    /* renamed from: c */
    public static String m1591c() {
        String language = Locale.getDefault().getLanguage();
        return (language == null || language.equals("null") || language == "") ? "EN" : language.toUpperCase();
    }

    /* renamed from: d */
    public static String m1590d() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "02:00:00:00:00:00";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }

    /* renamed from: e */
    public static String m1589e() {
        String str = "getDeviceSerialNumber";
        String str2 = "";
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                str = Build.getSerial();
                str2 = str;
            } else {
                str2 = (String) Build.class.getField("SERIAL").get(null);
            }
        } catch (SecurityException e) {
            AppLog.m2158a("LIB", "GeneralUtils", str, "exception: " + Log.getStackTraceString(e));
        } catch (Throwable th) {
            AppLog.m2158a("LIB", "GeneralUtils", str, "exception: " + Log.getStackTraceString(th));
        }
        return str2;
    }

    /* renamed from: f */
    public static String m1588f() {
        return "5E9FCDBB-268E-40A1-B770-589149D6E5FA";
    }

    /* renamed from: g */
    public static String m1587g() {
        return m1591c();
    }

    /* renamed from: h */
    public static String m1586h() {
        return "APA91bEOe-V6-w-C91zAYT4EED4mNAoU7EPOVyrRrluCut50Bf0besIlijS30zaMdSadbFL8YeRThEcPuUobExUe3bJhltFPHgeOQdUpJCUSaDqBnjEmO9pHpbA12QN31sPrKki1CovsOSRGaue0XB9e5ORPzt4Bew";
    }

    /* renamed from: i */
    public static boolean m1585i() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) App.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: j */
    public static boolean m1584j() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) App.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() && activeNetworkInfo.getType() == 1;
    }

    /* renamed from: b */
    public static Date m1594b(String str) {
        return m1600a(str, f9402a);
    }

    /* renamed from: b */
    public static double m1592b(List<Integer> list) {
        if (list == null || list.size() <= 0) {
            return 0.0d;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        int size = arrayList.size();
        if (size % 2 == 0) {
            int i = size / 2;
            return (((Integer) arrayList.get(i)).intValue() + ((Integer) arrayList.get(i - 1)).intValue()) / 2.0d;
        }
        return ((Integer) arrayList.get((size - 1) / 2)).intValue();
    }

    /* renamed from: a */
    public static Date m1600a(String str, String str2) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Lisbon"));
                    return simpleDateFormat.parse(str);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* renamed from: a */
    public static Date m1602a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.getTime();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0088 A[Catch: all -> 0x00ab, SecurityException -> 0x00d0, TRY_ENTER, TryCatch #1 {all -> 0x00ab, blocks: (B:8:0x001f, B:10:0x0025, B:32:0x0088, B:34:0x008e, B:36:0x0096, B:17:0x0038, B:19:0x003e), top: B:47:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1595b() {
        /*
            r0 = 0
            pt.card4b.backendbeacons.App r1 = pt.card4b.backendbeacons.App.getInstance()     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.String r2 = "phone"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            r3 = 26
            r4 = 0
            r5 = 1
            if (r2 < r3) goto L2a
            int r2 = r1.getPhoneCount()     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            if (r2 <= 0) goto L43
            java.lang.String r2 = r1.getImei(r4)     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            int r3 = r1.getPhoneCount()     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            if (r3 <= r5) goto L86
            java.lang.String r0 = r1.getImei(r5)     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            goto L86
        L2a:
            r3 = 23
            if (r2 < r3) goto L45
            int r2 = r1.getPhoneCount()     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            if (r2 <= 0) goto L43
            java.lang.String r2 = r1.getDeviceId(r4)     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            int r3 = r1.getPhoneCount()     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            if (r3 <= r5) goto L86
            java.lang.String r0 = r1.getDeviceId(r5)     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            goto L86
        L43:
            r2 = r0
            goto L86
        L45:
            r3 = 21
            if (r2 < r3) goto L81
            java.lang.Class r2 = r1.getClass()     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.Class[] r3 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            r3[r4] = r6     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.String r6 = "getDeviceId"
            java.lang.reflect.Method r2 = r2.getMethod(r6, r3)     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            r3[r4] = r6     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.Object r6 = r2.invoke(r1, r3)     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L7d java.lang.SecurityException -> Ld0
            r3[r4] = r0     // Catch: java.lang.Throwable -> L7d java.lang.SecurityException -> Ld0
            java.lang.Object r0 = r2.invoke(r1, r3)     // Catch: java.lang.Throwable -> L7d java.lang.SecurityException -> Ld0
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L7d java.lang.SecurityException -> Ld0
            r2 = r6
            goto L86
        L7d:
            r0 = move-exception
            r1 = r0
            r0 = r6
            goto Lb1
        L81:
            java.lang.String r1 = r1.getDeviceId()     // Catch: java.lang.Throwable -> Lb0 java.lang.SecurityException -> Ld0
            r2 = r1
        L86:
            if (r0 == 0) goto Laf
            boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            if (r1 != 0) goto Laf
            java.lang.String r1 = "null"
            boolean r1 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            if (r1 != 0) goto Laf
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            r1.<init>()     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            r1.append(r2)     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            java.lang.String r3 = ";"
            r1.append(r3)     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            r1.append(r0)     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            java.lang.String r2 = r1.toString()     // Catch: java.lang.Throwable -> Lab java.lang.SecurityException -> Ld0
            goto Laf
        Lab:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto Lb1
        Laf:
            return r2
        Lb0:
            r1 = move-exception
        Lb1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "exception: "
            r2.append(r3)
            java.lang.String r1 = android.util.Log.getStackTraceString(r1)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "LIB"
            java.lang.String r3 = "GeneralUtils"
            java.lang.String r4 = "getDeviceIMEI"
            p205h.p206a.p207a.AppLog.m2158a(r2, r3, r4, r1)
            return r0
        Ld0:
            pt.card4b.backendbeacons.BackEndExceptions$PhoneStatePermissionException r0 = new pt.card4b.backendbeacons.BackEndExceptions$PhoneStatePermissionException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p205h.p206a.p207a.GeneralUtils.m1595b():java.lang.String");
    }

    /* renamed from: a */
    public static long m1598a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /* renamed from: a */
    public static double m1596a(List<Integer> list) {
        if (list == null || list.size() <= 0) {
            return 0.0d;
        }
        ArrayList<Integer> arrayList = new ArrayList(list);
        int i = 0;
        for (Integer num : arrayList) {
            i += num.intValue();
        }
        return i / arrayList.size();
    }

    /* renamed from: a */
    public static String m1604a() {
        try {
            return Settings.Secure.getString(App.getContext().getContentResolver(), "android_id");
        } catch (Throwable th) {
            AppLog.m2158a("LIB", "GeneralUtils", "getAndroidID", "exception: " + Log.getStackTraceString(th));
            return null;
        }
    }

    /* renamed from: a */
    public static DataModels.Error m1599a(Throwable th) {
        if (th instanceof DataModels.C2698g) {
            DataModels.C2698g c2698g = (DataModels.C2698g) th;
            if (c2698g.m186a() != null) {
                return c2698g.m186a();
            }
        }
        th.printStackTrace();
        return DataModels.Error.internal(th.getLocalizedMessage());
    }

    /* renamed from: a */
    public static byte[] m1601a(String str) {
        String[] split = str.split(":");
        byte[] bArr = new byte[split.length];
        for (int i = 0; i < split.length; i++) {
            byte[] byteArray = new BigInteger(split[i], 16).toByteArray();
            bArr[i] = byteArray[byteArray.length - 1];
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m1603a(int i) {
        try {
            return App.getContext().getString(i);
        } catch (Throwable th) {
            AppLog.m2158a("LIB", "GeneralUtils", "getStringByResId", "exception: " + Log.getStackTraceString(th));
            return App.getContext().getString(i);
        }
    }
}
