package p136d.p137a.p138a.p139a.p140m.p142b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Logger;

/* renamed from: d.a.a.a.m.b.i */
/* loaded from: classes.dex */
public class CommonUtils {

    /* renamed from: a */
    public static Boolean f6434a;

    /* renamed from: b */
    public static final char[] f6435b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c */
    public static long f6436c = -1;

    /* renamed from: d */
    public static final Comparator<File> f6437d = new C1490a();

    /* compiled from: CommonUtils.java */
    /* renamed from: d.a.a.a.m.b.i$a */
    /* loaded from: classes.dex */
    public static class C1490a implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }
    }

    /* compiled from: CommonUtils.java */
    /* renamed from: d.a.a.a.m.b.i$b */
    /* loaded from: classes.dex */
    public enum EnumC1491b {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        

        /* renamed from: k */
        public static final Map<String, EnumC1491b> f6448k = new HashMap(4);

        static {
            f6448k.put("armeabi-v7a", ARMV7);
            f6448k.put("armeabi", ARMV6);
            f6448k.put("arm64-v8a", ARM64);
            f6448k.put("x86", X86_32);
        }

        /* renamed from: b */
        public static EnumC1491b m4068b() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                Fabric.m4197h().mo4157e("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            EnumC1491b enumC1491b = f6448k.get(str.toLowerCase(Locale.US));
            return enumC1491b == null ? UNKNOWN : enumC1491b;
        }
    }

    /* renamed from: a */
    public static String m4112a(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return "D";
            case 4:
                return "I";
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                return "?";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        r2 = r3[1];
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m4102a(java.io.File r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "Failed to close system file reader."
            boolean r1 = r7.exists()
            r2 = 0
            if (r1 == 0) goto L61
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3f
        L15:
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            if (r3 == 0) goto L36
            java.lang.String r4 = "\\s*:\\s*"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            r5 = 2
            java.lang.String[] r3 = r4.split(r3, r5)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            int r4 = r3.length     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            r5 = 1
            if (r4 <= r5) goto L15
            r4 = 0
            r4 = r3[r4]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            boolean r4 = r4.equals(r8)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            if (r4 == 0) goto L15
            r7 = r3[r5]     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L5c
            r2 = r7
        L36:
            m4103a(r1, r0)
            goto L61
        L3a:
            r8 = move-exception
            goto L41
        L3c:
            r7 = move-exception
            r1 = r2
            goto L5d
        L3f:
            r8 = move-exception
            r1 = r2
        L41:
            d.a.a.a.k r3 = p136d.p137a.p138a.p139a.Fabric.m4197h()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r4 = "Fabric"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
            r5.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r6 = "Error parsing "
            r5.append(r6)     // Catch: java.lang.Throwable -> L5c
            r5.append(r7)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L5c
            r3.mo4159c(r4, r7, r8)     // Catch: java.lang.Throwable -> L5c
            goto L36
        L5c:
            r7 = move-exception
        L5d:
            m4103a(r1, r0)
            throw r7
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils.m4102a(java.io.File, java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public static synchronized long m4090b() {
        long j;
        synchronized (CommonUtils.class) {
            if (f6436c == -1) {
                long j2 = 0;
                String m4102a = m4102a(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(m4102a)) {
                    String upperCase = m4102a.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            j2 = m4094a(upperCase, "KB", 1024);
                        } else if (upperCase.endsWith("MB")) {
                            j2 = m4094a(upperCase, "MB", 1048576);
                        } else if (upperCase.endsWith("GB")) {
                            j2 = m4094a(upperCase, "GB", 1073741824);
                        } else {
                            Logger m4197h = Fabric.m4197h();
                            m4197h.mo4157e("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase);
                        }
                    } catch (NumberFormatException e) {
                        Logger m4197h2 = Fabric.m4197h();
                        m4197h2.mo4159c("Fabric", "Unexpected meminfo format while computing RAM: " + upperCase, e);
                    }
                }
                f6436c = j2;
            }
            j = f6436c;
        }
        return j;
    }

    /* renamed from: c */
    public static String m4081c(String str) {
        return m4095a(str, "SHA-1");
    }

    /* renamed from: d */
    public static int m4080d(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    /* renamed from: e */
    public static Float m4079e(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        return Float.valueOf(registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1));
    }

    /* renamed from: f */
    public static int m4078f(Context context) {
        int i = m4072l(context) ? 1 : 0;
        if (m4071m(context)) {
            i |= 2;
        }
        return m4084c() ? i | 4 : i;
    }

    /* renamed from: g */
    public static boolean m4077g(Context context) {
        return (m4072l(context) || ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) == null) ? false : true;
    }

    /* renamed from: h */
    public static String m4076h(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            return context.getResources().getResourcePackageName(i);
        }
        return context.getPackageName();
    }

    /* renamed from: i */
    public static SharedPreferences m4075i(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    /* renamed from: j */
    public static boolean m4074j(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    /* renamed from: k */
    public static boolean m4073k(Context context) {
        if (f6434a == null) {
            f6434a = Boolean.valueOf(m4106a(context, "com.crashlytics.Trace", false));
        }
        return f6434a.booleanValue();
    }

    /* renamed from: l */
    public static boolean m4072l(Context context) {
        return "sdk".equals(Build.PRODUCT) || "google_sdk".equals(Build.PRODUCT) || Settings.Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    /* renamed from: m */
    public static boolean m4071m(Context context) {
        boolean m4072l = m4072l(context);
        String str = Build.TAGS;
        if ((m4072l || str == null || !str.contains("test-keys")) && !new File("/system/app/Superuser.apk").exists()) {
            return !m4072l && new File("/system/xbin/su").exists();
        }
        return true;
    }

    /* renamed from: n */
    public static String m4070n(Context context) {
        int m4108a = m4108a(context, "io.fabric.android.build_id", "string");
        if (m4108a == 0) {
            m4108a = m4108a(context, "com.crashlytics.android.build_id", "string");
        }
        if (m4108a != 0) {
            String string = context.getResources().getString(m4108a);
            Logger m4197h = Fabric.m4197h();
            m4197h.mo4157e("Fabric", "Build ID is: " + string);
            return string;
        }
        return null;
    }

    /* renamed from: c */
    public static void m4082c(Context context, String str) {
        if (m4073k(context)) {
            Fabric.m4197h().mo4157e("Fabric", str);
        }
    }

    /* renamed from: c */
    public static boolean m4084c() {
        return Debug.isDebuggerConnected() || Debug.waitingForDebugger();
    }

    /* renamed from: c */
    public static String m4083c(Context context) {
        Throwable th;
        InputStream inputStream;
        try {
            inputStream = context.getResources().openRawResource(m4080d(context));
        } catch (Exception e) {
            e = e;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            m4103a((Closeable) inputStream, "Failed to close icon input stream.");
            throw th;
        }
        try {
            try {
                String m4100a = m4100a(inputStream);
                String str = m4085b(m4100a) ? null : m4100a;
                m4103a((Closeable) inputStream, "Failed to close icon input stream.");
                return str;
            } catch (Throwable th3) {
                th = th3;
                m4103a((Closeable) inputStream, "Failed to close icon input stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            Fabric.m4197h().mo4159c("Fabric", "Could not calculate hash for app icon.", e);
            m4103a((Closeable) inputStream, "Failed to close icon input stream.");
            return null;
        }
    }

    /* renamed from: a */
    public static int m4113a() {
        return EnumC1491b.m4068b().ordinal();
    }

    /* renamed from: a */
    public static long m4094a(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * i;
    }

    /* renamed from: a */
    public static ActivityManager.RunningAppProcessInfo m4096a(String str, Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public static String m4086b(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }

    /* renamed from: a */
    public static String m4100a(InputStream inputStream) {
        return m4098a(inputStream, "SHA-1");
    }

    /* renamed from: b */
    public static String m4087b(Context context, String str) {
        int m4108a = m4108a(context, str, "string");
        return m4108a > 0 ? context.getString(m4108a) : "";
    }

    /* renamed from: a */
    public static String m4098a(InputStream inputStream, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    return m4093a(messageDigest.digest());
                }
            }
        } catch (Exception e) {
            Fabric.m4197h().mo4159c("Fabric", "Could not calculate hash for app icon.", e);
            return "";
        }
    }

    /* renamed from: b */
    public static boolean m4085b(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: b */
    public static String m4089b(int i) {
        if (i >= 0) {
            return String.format(Locale.US, "%1$10s", Integer.valueOf(i)).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    /* renamed from: b */
    public static boolean m4088b(Context context) {
        if (m4109a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        return true;
    }

    /* renamed from: a */
    public static String m4092a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return m4093a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            Logger m4197h = Fabric.m4197h();
            m4197h.mo4159c("Fabric", "Could not create hashing algorithm: " + str + ", returning empty string.", e);
            return "";
        }
    }

    /* renamed from: a */
    public static String m4095a(String str, String str2) {
        return m4092a(str.getBytes(), str2);
    }

    /* renamed from: a */
    public static String m4091a(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null) {
                arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
            }
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        for (String str2 : arrayList) {
            sb.append(str2);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            return m4081c(sb2);
        }
        return null;
    }

    /* renamed from: a */
    public static long m4111a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    /* renamed from: a */
    public static long m4097a(String str) {
        StatFs statFs;
        long blockSize = new StatFs(str).getBlockSize();
        return (statFs.getBlockCount() * blockSize) - (blockSize * statFs.getAvailableBlocks());
    }

    /* renamed from: a */
    public static void m4107a(Context context, String str, Throwable th) {
        if (m4073k(context)) {
            Fabric.m4197h().mo4160c("Fabric", str);
        }
    }

    /* renamed from: a */
    public static void m4110a(Context context, int i, String str, String str2) {
        if (m4073k(context)) {
            Fabric.m4197h().mo4167a(i, "Fabric", str2);
        }
    }

    /* renamed from: a */
    public static boolean m4106a(Context context, String str, boolean z) {
        Resources resources;
        if (context != null && (resources = context.getResources()) != null) {
            int m4108a = m4108a(context, str, "bool");
            if (m4108a > 0) {
                return resources.getBoolean(m4108a);
            }
            int m4108a2 = m4108a(context, str, "string");
            if (m4108a2 > 0) {
                return Boolean.parseBoolean(context.getString(m4108a2));
            }
        }
        return z;
    }

    /* renamed from: a */
    public static int m4108a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, m4076h(context));
    }

    /* renamed from: a */
    public static int m4105a(Context context, boolean z) {
        Float m4079e = m4079e(context);
        if (!z || m4079e == null) {
            return 1;
        }
        if (m4079e.floatValue() >= 99.0d) {
            return 3;
        }
        return ((double) m4079e.floatValue()) < 99.0d ? 2 : 0;
    }

    /* renamed from: a */
    public static String m4093a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f6435b;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static void m4103a(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Fabric.m4197h().mo4159c("Fabric", str, e);
            }
        }
    }

    /* renamed from: a */
    public static void m4101a(Flushable flushable, String str) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (IOException e) {
                Fabric.m4197h().mo4159c("Fabric", str, e);
            }
        }
    }

    /* renamed from: a */
    public static void m4099a(InputStream inputStream, OutputStream outputStream, byte[] bArr) {
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public static void m4104a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    public static boolean m4109a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }
}
