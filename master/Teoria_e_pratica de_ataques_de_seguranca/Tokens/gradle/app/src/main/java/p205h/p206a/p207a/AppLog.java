package p205h.p206a.p207a;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import p136d.p153c.Single;
import p136d.p153c.SingleObserver;
import p136d.p153c.p179j0.Schedulers;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.a.a.c */
/* loaded from: classes.dex */
public class AppLog {

    /* renamed from: a */
    public static final Object f8760a = new Object();

    /* renamed from: b */
    public static FileOutputStream f8761b = null;

    /* renamed from: c */
    public static BufferedWriter f8762c = null;

    /* renamed from: d */
    public static int f8763d = 5;

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$a */
    /* loaded from: classes.dex */
    public class C1877a implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$b */
    /* loaded from: classes.dex */
    public class C1878b extends Single<Object> {

        /* compiled from: AppLog.java */
        /* renamed from: h.a.a.c$b$a */
        /* loaded from: classes.dex */
        public class C1879a implements FilenameFilter {
            public C1879a(C1878b c1878b) {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".log");
            }
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            File[] listFiles;
            File file = null;
            try {
                synchronized (AppLog.f8760a) {
                    File dir = App.getContext().getDir("anda_backend_logs", 0);
                    if (dir.exists() && (listFiles = dir.listFiles(new C1879a(this))) != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(Arrays.asList(listFiles));
                        File file2 = new File(dir, "Logcat.txt");
                        AppLog.m2147c(file2);
                        if (file2.exists()) {
                            arrayList.add(file2);
                        }
                        File filesDir = App.getContext().getFilesDir();
                        filesDir.mkdir();
                        if (filesDir.exists()) {
                            File file3 = new File(filesDir, "backend_lib_log.zip");
                            if (file3.exists()) {
                                file3.delete();
                            }
                            if (AppLog.m2149b((File[]) arrayList.toArray(new File[arrayList.size()]), file3.getPath())) {
                                file = file3;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                Log.d("BACKEND_", "getLibLog error: " + Log.getStackTraceString(th));
            }
            singleObserver.mo3282b(file);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$c */
    /* loaded from: classes.dex */
    public class C1880c extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ Date f8764a;

        /* renamed from: b */
        public final /* synthetic */ String f8765b;

        public C1880c(Date date, String str) {
            this.f8764a = date;
            this.f8765b = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            AppLog.m2150b(this.f8764a, this.f8765b);
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$d */
    /* loaded from: classes.dex */
    public class C1881d extends Single<Object> {
        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            try {
                synchronized (AppLog.f8760a) {
                    int unused = AppLog.f8763d = 5;
                }
            } catch (Throwable th) {
                Log.d("LOG_FILE", "tripStarted - failed:" + Log.getStackTraceString(th));
            }
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$e */
    /* loaded from: classes.dex */
    public class C1882e extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f8766a;

        /* compiled from: AppLog.java */
        /* renamed from: h.a.a.c$e$a */
        /* loaded from: classes.dex */
        public class C1883a implements FilenameFilter {
            public C1883a(C1882e c1882e) {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".log");
            }
        }

        /* compiled from: AppLog.java */
        /* renamed from: h.a.a.c$e$b */
        /* loaded from: classes.dex */
        public class C1884b implements Comparator<File> {
            public C1884b(C1882e c1882e) {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file, File file2) {
                return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
            }
        }

        public C1882e(String str) {
            this.f8766a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            try {
                synchronized (AppLog.f8760a) {
                    if (AppLog.f8762c != null) {
                        AppLog.f8762c.close();
                        BufferedWriter unused = AppLog.f8762c = null;
                    }
                    if (AppLog.f8761b != null) {
                        AppLog.f8761b.close();
                        FileOutputStream unused2 = AppLog.f8761b = null;
                    }
                    String str = new SimpleDateFormat("yyyyMMdd").format(SysDateManager.m1497d().m1495f()) + "_" + this.f8766a;
                    File dir = App.getContext().getDir("anda_backend_logs", 0);
                    dir.mkdirs();
                    if (dir.exists()) {
                        File[] listFiles = dir.listFiles(new C1883a(this));
                        if (listFiles.length > 0) {
                            Arrays.sort(listFiles, new C1884b(this));
                            ArrayList arrayList = new ArrayList();
                            int i = 0;
                            while (i < listFiles.length) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("anda_backend_");
                                int i2 = i + 1;
                                sb.append(i2);
                                sb.append("_");
                                sb.append(str);
                                sb.append(".log");
                                File file = new File(dir, sb.toString());
                                listFiles[i].renameTo(file);
                                arrayList.add(file);
                                i = i2;
                            }
                            File file2 = new File(dir, "Logcat.txt");
                            AppLog.m2147c(file2);
                            if (file2.exists()) {
                                arrayList.add(file2);
                            }
                            AppLog.m2149b((File[]) arrayList.toArray(new File[arrayList.size()]), new File(dir, "anda_backend_" + str + ".zip").getPath());
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                ((File) arrayList.get(i3)).delete();
                            }
                        }
                    }
                    int unused3 = AppLog.f8763d = 5;
                }
            } catch (Throwable th) {
                Log.d("LOG_FILE", "tripFinished - failed:" + Log.getStackTraceString(th));
            }
            singleObserver.mo3282b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$f */
    /* loaded from: classes.dex */
    public class C1885f implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".zip");
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$g */
    /* loaded from: classes.dex */
    public class C1886g implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$h */
    /* loaded from: classes.dex */
    public class C1887h extends Single<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f8767a;

        /* compiled from: AppLog.java */
        /* renamed from: h.a.a.c$h$a */
        /* loaded from: classes.dex */
        public class C1888a implements FilenameFilter {
            public C1888a(C1887h c1887h) {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".log");
            }
        }

        public C1887h(String str) {
            this.f8767a = str;
        }

        @Override // p136d.p153c.Single
        public void subscribeActual(SingleObserver<? super Object> singleObserver) {
            File[] listFiles;
            ArrayList arrayList = new ArrayList();
            File file = null;
            try {
                synchronized (AppLog.f8760a) {
                    File dir = App.getContext().getDir("reports", 0);
                    dir.mkdir();
                    if (dir.exists()) {
                        File[] listFiles2 = dir.listFiles();
                        if (listFiles2 != null) {
                            for (File file2 : listFiles2) {
                                if (!file2.getName().toUpperCase().endsWith("*.zip")) {
                                    file2.delete();
                                }
                            }
                        }
                        File file3 = new File(dir, "device.txt");
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file3, false));
                        outputStreamWriter.write(this.f8767a);
                        outputStreamWriter.close();
                        arrayList.add(file3);
                        File dir2 = App.getContext().getDir("anda_backend_logs", 0);
                        if (dir2.exists() && (listFiles = dir2.listFiles(new C1888a(this))) != null) {
                            arrayList.addAll(Arrays.asList(listFiles));
                            File file4 = new File(dir2, "Logcat.txt");
                            AppLog.m2147c(file4);
                            if (file4.exists()) {
                                arrayList.add(file4);
                            }
                        }
                        File file5 = new File(dir, "report_" + new SimpleDateFormat("yyyyMMddHHmmss").format(SysDateManager.m1497d().m1495f()) + "_" + UUID.randomUUID().toString() + ".zip");
                        if (file5.exists()) {
                            file5.delete();
                        }
                        if (AppLog.m2149b((File[]) arrayList.toArray(new File[arrayList.size()]), file5.getPath())) {
                            file = file5;
                        }
                    }
                }
            } catch (Throwable th) {
                Log.d("BACKEND_", "saveReport error: " + Log.getStackTraceString(th));
            }
            singleObserver.mo3282b(file);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$i */
    /* loaded from: classes.dex */
    public class C1889i implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".zip");
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$j */
    /* loaded from: classes.dex */
    public class C1890j implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$k */
    /* loaded from: classes.dex */
    public class C1891k implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".log");
        }
    }

    /* renamed from: d */
    public static void m2143d(String str) {
        m2152b(str).subscribeOn(Schedulers.m3323b()).subscribe();
    }

    /* renamed from: e */
    public static void m2141e(String str) {
        m2146c(str).subscribeOn(Schedulers.m3323b()).subscribe();
    }

    /* renamed from: f */
    public static Single<Object> m2140f() {
        return new C1878b();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005a -> B:14:0x005b). Please submit an issue!!! */
    /* renamed from: g */
    public static File m2139g() {
        try {
            File dir = App.getContext().getDir("reports", 0);
            if (dir.exists()) {
                File[] listFiles = dir.listFiles(new C1889i());
                if (listFiles.length > 0) {
                    Arrays.sort(listFiles, new C1890j());
                    if (listFiles[0].length() > 10485760) {
                        listFiles[0].delete();
                        return m2139g();
                    }
                    return listFiles[0];
                }
            }
        } catch (Throwable th) {
            Log.d("LOG_FILE", "getReport error:" + Log.getStackTraceString(th));
        }
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005a -> B:14:0x005b). Please submit an issue!!! */
    /* renamed from: h */
    public static File m2138h() {
        try {
            File dir = App.getContext().getDir("anda_backend_logs", 0);
            if (dir.exists()) {
                File[] listFiles = dir.listFiles(new C1885f());
                if (listFiles.length > 0) {
                    Arrays.sort(listFiles, new C1886g());
                    if (listFiles[0].length() > 10485760) {
                        listFiles[0].delete();
                        return m2138h();
                    }
                    return listFiles[0];
                }
            }
        } catch (Throwable th) {
            Log.d("LOG_FILE", "getTripLog error:" + Log.getStackTraceString(th));
        }
        return null;
    }

    /* renamed from: b */
    public static int m2151b(String str, String str2, String str3, String str4) {
        String str5 = "BACKEND_" + str;
        String str6 = str2 + "_" + str3 + ": " + str4;
        m2145c(SysDateManager.m1497d().m1495f(), str5 + "_" + str6).subscribeOn(Schedulers.m3323b()).subscribe();
        return Log.w(str5, str6);
    }

    /* renamed from: c */
    public static Single<Object> m2145c(Date date, String str) {
        return new C1880c(date, str);
    }

    /* renamed from: d */
    public static void m2144d() {
        try {
            BufferedWriter bufferedWriter = f8762c;
            if (bufferedWriter != null) {
                bufferedWriter.close();
                f8762c = null;
            }
            FileOutputStream fileOutputStream = f8761b;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                f8761b = null;
            }
            File dir = App.getContext().getDir("anda_backend_logs", 0);
            dir.mkdirs();
            File[] listFiles = dir.listFiles(new C1891k());
            int length = listFiles.length;
            if (length >= f8763d) {
                Arrays.sort(listFiles, new C1877a());
                listFiles[0].delete();
                length--;
            }
            int i = 1;
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2].exists()) {
                    String str = "anda_backend_" + i + ".log";
                    if (!listFiles[i2].getName().equals(str)) {
                        listFiles[i2].renameTo(new File(dir, str));
                    }
                    i++;
                }
            }
            f8761b = new FileOutputStream(new File(dir, "anda_backend_" + (length + 1) + ".log"), true);
            f8762c = new BufferedWriter(new OutputStreamWriter(f8761b));
        } catch (Throwable th) {
            try {
                BufferedWriter bufferedWriter2 = f8762c;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
            } catch (Throwable unused) {
            }
            try {
                FileOutputStream fileOutputStream2 = f8761b;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable unused2) {
            }
            f8762c = null;
            f8761b = null;
            Log.d("BACKEND_", "Error creating new log file stream. " + Log.getStackTraceString(th));
        }
    }

    /* renamed from: e */
    public static void m2142e() {
        try {
            BufferedWriter bufferedWriter = f8762c;
            if (bufferedWriter != null) {
                bufferedWriter.close();
                f8762c = null;
            }
            FileOutputStream fileOutputStream = f8761b;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                f8761b = null;
            }
            File dir = App.getContext().getDir("anda_backend_logs", 0);
            dir.mkdirs();
            int m2153b = m2153b(dir);
            if (m2153b > 0) {
                f8761b = new FileOutputStream(new File(dir, "anda_backend_" + m2153b + ".log"), true);
                f8762c = new BufferedWriter(new OutputStreamWriter(f8761b));
            }
        } catch (Throwable th) {
            try {
                BufferedWriter bufferedWriter2 = f8762c;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
            } catch (Throwable unused) {
            }
            try {
                FileOutputStream fileOutputStream2 = f8761b;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable unused2) {
            }
            f8762c = null;
            f8761b = null;
            Log.d("BACKEND_", "Error getting last log file stream." + Log.getStackTraceString(th));
        }
    }

    /* renamed from: c */
    public static Single<Object> m2146c(String str) {
        return new C1881d();
    }

    /* renamed from: c */
    public static void m2147c(File file) {
        Throwable th;
        FileOutputStream fileOutputStream;
        byte[] bArr = new byte[8192];
        InputStream inputStream = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    InputStream inputStream2 = Runtime.getRuntime().exec("logcat -d -v time").getInputStream();
                    try {
                        for (int read = inputStream2.read(bArr, 0, 8192); read != -1; read = inputStream2.read(bArr, 0, 8192)) {
                            fileOutputStream.write(bArr, 0, read);
                        }
                        try {
                            inputStream2.close();
                        } catch (Throwable unused) {
                        }
                        fileOutputStream.flush();
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        try {
                            Log.d("BACKEND_", "Error getting log file:" + Log.getStackTraceString(th));
                            if (fileOutputStream != null) {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            }
                            return;
                        } finally {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            fileOutputStream.close();
        } catch (Throwable unused4) {
        }
    }

    /* renamed from: b */
    public static void m2150b(Date date, String str) {
        try {
            synchronized (f8760a) {
                String format = String.format("%s: %s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date), str);
                if (f8762c == null) {
                    m2142e();
                    if (f8762c == null) {
                        m2144d();
                    }
                }
                if (f8762c != null && f8761b.getChannel().position() >= 1048576) {
                    m2144d();
                }
                BufferedWriter bufferedWriter = f8762c;
                if (bufferedWriter != null) {
                    bufferedWriter.write(format);
                    f8762c.newLine();
                    f8762c.flush();
                } else {
                    Log.d("LOG_FILE", "Failed to get/create the log file stream");
                }
            }
        } catch (Throwable th) {
            Log.d("LOG_FILE", "Failed to write the log file:" + Log.getStackTraceString(th));
        }
    }

    /* renamed from: a */
    public static int m2158a(String str, String str2, String str3, String str4) {
        return m2157a(str, str2, str3, str4, true);
    }

    /* renamed from: a */
    public static int m2157a(String str, String str2, String str3, String str4, boolean z) {
        String str5 = "BACKEND_" + str;
        String str6 = str2 + "_" + str3 + ": " + str4;
        Date m1495f = SysDateManager.m1497d().m1495f();
        if (z) {
            m2145c(m1495f, str5 + "_" + str6).subscribeOn(Schedulers.m3323b()).subscribe();
        } else {
            m2150b(m1495f, str5 + "_" + str6);
        }
        return Log.d(str5, str6);
    }

    /* renamed from: a */
    public static void m2159a(String str, String str2) {
        m2145c(SysDateManager.m1497d().m1495f(), str + ": " + str2).subscribeOn(Schedulers.m3323b()).subscribe();
    }

    /* renamed from: a */
    public static Single<Object> m2160a(String str) {
        return new C1887h(str);
    }

    /* renamed from: b */
    public static Single<Object> m2152b(String str) {
        return new C1882e(str);
    }

    /* renamed from: b */
    public static int m2153b(File file) {
        if (file.isDirectory() && file.exists()) {
            int i = 0;
            for (String str : file.list()) {
                if (str.toLowerCase().endsWith(".log")) {
                    i++;
                }
            }
            return i;
        }
        return 0;
    }

    /* renamed from: b */
    public static boolean m2149b(File[] fileArr, String str) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            byte[] bArr = new byte[4096];
            for (int i = 0; i < fileArr.length; i++) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileArr[i]), 4096);
                zipOutputStream.putNextEntry(new ZipEntry(fileArr[i].getAbsolutePath().substring(fileArr[i].getPath().lastIndexOf("/") + 1)));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 4096);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedInputStream.close();
            }
            zipOutputStream.close();
            return true;
        } catch (Throwable th) {
            Log.d("BACKEND_", "Error creating zip file: " + Log.getStackTraceString(th));
            return false;
        }
    }
}