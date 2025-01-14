package h.a.a;

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
/* compiled from: GeneralUtils.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static String f6847a = "yyyy-MM-dd HH:mm:ss";

    public static String a(Date date, String str) {
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

    public static String b(Date date) {
        return a(date, f6847a);
    }

    public static String c() {
        String language = Locale.getDefault().getLanguage();
        return (language == null || language.equals("null") || language == "") ? "EN" : language.toUpperCase();
    }

    public static String d() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "02:00:00:00:00:00";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }

    public static String e() {
        String str = "getDeviceSerialNumber";
        String str2 = "";
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                str = Build.getSerial();
                str2 = str;
            } else {
                str2 = (String) Build.class.getField("SERIAL").get(null);
            }
        } catch (SecurityException e2) {
            c.a("LIB", "GeneralUtils", str, "exception: " + Log.getStackTraceString(e2));
        } catch (Throwable th) {
            c.a("LIB", "GeneralUtils", str, "exception: " + Log.getStackTraceString(th));
        }
        return str2;
    }

    public static String f() {
        return "5E9FCDBB-268E-40A1-B770-589149D6E5FA";
    }

    public static String g() {
        return c();
    }

    public static String h() {
        return "APA91bEOe-V6-w-C91zAYT4EED4mNAoU7EPOVyrRrluCut50Bf0besIlijS30zaMdSadbFL8YeRThEcPuUobExUe3bJhltFPHgeOQdUpJCUSaDqBnjEmO9pHpbA12QN31sPrKki1CovsOSRGaue0XB9e5ORPzt4Bew";
    }

    public static boolean i() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) App.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean j() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) App.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting() && activeNetworkInfo.getType() == 1;
    }

    public static Date b(String str) {
        return a(str, f6847a);
    }

    public static double b(List<Integer> list) {
        if (list == null || list.size() <= 0) {
            return 0.0d;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        int size = arrayList.size();
        if (size % 2 == 0) {
            int i2 = size / 2;
            return (((Integer) arrayList.get(i2)).intValue() + ((Integer) arrayList.get(i2 - 1)).intValue()) / 2.0d;
        }
        return ((Integer) arrayList.get((size - 1) / 2)).intValue();
    }

    public static Date a(String str, String str2) {
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

    public static Date a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.getTime();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0088 A[Catch: all -> 0x00ab, SecurityException -> 0x00d0, TRY_ENTER, TryCatch #1 {all -> 0x00ab, blocks: (B:8:0x001f, B:10:0x0025, B:32:0x0088, B:34:0x008e, B:36:0x0096, B:17:0x0038, B:19:0x003e), top: B:47:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b() {
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
            h.a.a.c.a(r2, r3, r4, r1)
            return r0
        Ld0:
            pt.card4b.backendbeacons.BackEndExceptions$PhoneStatePermissionException r0 = new pt.card4b.backendbeacons.BackEndExceptions$PhoneStatePermissionException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h.a.a.p.b():java.lang.String");
    }

    public static long a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    public static double a(List<Integer> list) {
        if (list == null || list.size() <= 0) {
            return 0.0d;
        }
        ArrayList<Integer> arrayList = new ArrayList(list);
        int i2 = 0;
        for (Integer num : arrayList) {
            i2 += num.intValue();
        }
        return i2 / arrayList.size();
    }

    public static String a() {
        try {
            return Settings.Secure.getString(App.getContext().getContentResolver(), "android_id");
        } catch (Throwable th) {
            c.a("LIB", "GeneralUtils", "getAndroidID", "exception: " + Log.getStackTraceString(th));
            return null;
        }
    }

    public static DataModels.Error a(Throwable th) {
        if (th instanceof DataModels.g) {
            DataModels.g gVar = (DataModels.g) th;
            if (gVar.a() != null) {
                return gVar.a();
            }
        }
        th.printStackTrace();
        return DataModels.Error.internal(th.getLocalizedMessage());
    }

    public static byte[] a(String str) {
        String[] split = str.split(":");
        byte[] bArr = new byte[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            byte[] byteArray = new BigInteger(split[i2], 16).toByteArray();
            bArr[i2] = byteArray[byteArray.length - 1];
        }
        return bArr;
    }

    public static String a(int i2) {
        try {
            return App.getContext().getString(i2);
        } catch (Throwable th) {
            c.a("LIB", "GeneralUtils", "getStringByResId", "exception: " + Log.getStackTraceString(th));
            return App.getContext().getString(i2);
        }
    }
}
