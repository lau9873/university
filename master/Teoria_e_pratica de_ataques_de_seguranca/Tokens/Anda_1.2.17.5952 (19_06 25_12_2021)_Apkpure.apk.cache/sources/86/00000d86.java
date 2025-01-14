package p205h.p198a.p199a;

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
import p216d.p149c.AbstractC2745u;
import p216d.p149c.AbstractC2747w;
import p216d.p149c.p175j0.C2720a;
import p227pt.card4b.backendbeacons.App;
import p227pt.card4b.backendbeacons.DataModels;

/* compiled from: AppLog.java */
/* renamed from: h.a.a.c */
/* loaded from: classes.dex */
public class C3048c {

    /* renamed from: a */
    public static final Object f8758a = new Object();

    /* renamed from: b */
    public static FileOutputStream f8759b = null;

    /* renamed from: c */
    public static BufferedWriter f8760c = null;

    /* renamed from: d */
    public static int f8761d = 5;

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$a */
    /* loaded from: classes.dex */
    public class C3049a implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$b */
    /* loaded from: classes.dex */
    public class C3050b extends AbstractC2745u<Object> {

        /* compiled from: AppLog.java */
        /* renamed from: h.a.a.c$b$a */
        /* loaded from: classes.dex */
        public class C3051a implements FilenameFilter {
            public C3051a(C3050b c3050b) {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".log");
            }
        }

        @Override // p216d.p149c.AbstractC2745u
        public void subscribeActual(AbstractC2747w<? super Object> abstractC2747w) {
            File[] listFiles;
            File file = null;
            try {
                synchronized (C3048c.f8758a) {
                    File dir = App.getContext().getDir("anda_backend_logs", 0);
                    if (dir.exists() && (listFiles = dir.listFiles(new C3051a(this))) != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(Arrays.asList(listFiles));
                        File file2 = new File(dir, "Logcat.txt");
                        C3048c.m2147c(file2);
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
                            if (C3048c.m2149b((File[]) arrayList.toArray(new File[arrayList.size()]), file3.getPath())) {
                                file = file3;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                Log.d("BACKEND_", "getLibLog error: " + Log.getStackTraceString(th));
            }
            abstractC2747w.mo3282b(file);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$c */
    /* loaded from: classes.dex */
    public class C3052c extends AbstractC2745u<Object> {

        /* renamed from: a */
        public final /* synthetic */ Date f8762a;

        /* renamed from: b */
        public final /* synthetic */ String f8763b;

        public C3052c(Date date, String str) {
            this.f8762a = date;
            this.f8763b = str;
        }

        @Override // p216d.p149c.AbstractC2745u
        public void subscribeActual(AbstractC2747w<? super Object> abstractC2747w) {
            C3048c.m2150b(this.f8762a, this.f8763b);
            abstractC2747w.mo3282b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$d */
    /* loaded from: classes.dex */
    public class C3053d extends AbstractC2745u<Object> {
        @Override // p216d.p149c.AbstractC2745u
        public void subscribeActual(AbstractC2747w<? super Object> abstractC2747w) {
            try {
                synchronized (C3048c.f8758a) {
                    int unused = C3048c.f8761d = 5;
                }
            } catch (Throwable th) {
                Log.d("LOG_FILE", "tripStarted - failed:" + Log.getStackTraceString(th));
            }
            abstractC2747w.mo3282b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$e */
    /* loaded from: classes.dex */
    public class C3054e extends AbstractC2745u<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f8764a;

        /* compiled from: AppLog.java */
        /* renamed from: h.a.a.c$e$a */
        /* loaded from: classes.dex */
        public class C3055a implements FilenameFilter {
            public C3055a(C3054e c3054e) {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".log");
            }
        }

        /* compiled from: AppLog.java */
        /* renamed from: h.a.a.c$e$b */
        /* loaded from: classes.dex */
        public class C3056b implements Comparator<File> {
            public C3056b(C3054e c3054e) {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file, File file2) {
                return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
            }
        }

        public C3054e(String str) {
            this.f8764a = str;
        }

        @Override // p216d.p149c.AbstractC2745u
        public void subscribeActual(AbstractC2747w<? super Object> abstractC2747w) {
            try {
                synchronized (C3048c.f8758a) {
                    if (C3048c.f8760c != null) {
                        C3048c.f8760c.close();
                        BufferedWriter unused = C3048c.f8760c = null;
                    }
                    if (C3048c.f8759b != null) {
                        C3048c.f8759b.close();
                        FileOutputStream unused2 = C3048c.f8759b = null;
                    }
                    String str = new SimpleDateFormat("yyyyMMdd").format(C3452w.m1497d().m1495f()) + "_" + this.f8764a;
                    File dir = App.getContext().getDir("anda_backend_logs", 0);
                    dir.mkdirs();
                    if (dir.exists()) {
                        File[] listFiles = dir.listFiles(new C3055a(this));
                        if (listFiles.length > 0) {
                            Arrays.sort(listFiles, new C3056b(this));
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
                            C3048c.m2147c(file2);
                            if (file2.exists()) {
                                arrayList.add(file2);
                            }
                            C3048c.m2149b((File[]) arrayList.toArray(new File[arrayList.size()]), new File(dir, "anda_backend_" + str + ".zip").getPath());
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                ((File) arrayList.get(i3)).delete();
                            }
                        }
                    }
                    int unused3 = C3048c.f8761d = 5;
                }
            } catch (Throwable th) {
                Log.d("LOG_FILE", "tripFinished - failed:" + Log.getStackTraceString(th));
            }
            abstractC2747w.mo3282b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$f */
    /* loaded from: classes.dex */
    public class C3057f implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".zip");
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$g */
    /* loaded from: classes.dex */
    public class C3058g implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$h */
    /* loaded from: classes.dex */
    public class C3059h extends AbstractC2745u<Object> {

        /* renamed from: a */
        public final /* synthetic */ String f8765a;

        /* compiled from: AppLog.java */
        /* renamed from: h.a.a.c$h$a */
        /* loaded from: classes.dex */
        public class C3060a implements FilenameFilter {
            public C3060a(C3059h c3059h) {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".log");
            }
        }

        public C3059h(String str) {
            this.f8765a = str;
        }

        @Override // p216d.p149c.AbstractC2745u
        public void subscribeActual(AbstractC2747w<? super Object> abstractC2747w) {
            File[] listFiles;
            ArrayList arrayList = new ArrayList();
            File file = null;
            try {
                synchronized (C3048c.f8758a) {
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
                        outputStreamWriter.write(this.f8765a);
                        outputStreamWriter.close();
                        arrayList.add(file3);
                        File dir2 = App.getContext().getDir("anda_backend_logs", 0);
                        if (dir2.exists() && (listFiles = dir2.listFiles(new C3060a(this))) != null) {
                            arrayList.addAll(Arrays.asList(listFiles));
                            File file4 = new File(dir2, "Logcat.txt");
                            C3048c.m2147c(file4);
                            if (file4.exists()) {
                                arrayList.add(file4);
                            }
                        }
                        File file5 = new File(dir, "report_" + new SimpleDateFormat("yyyyMMddHHmmss").format(C3452w.m1497d().m1495f()) + "_" + UUID.randomUUID().toString() + ".zip");
                        if (file5.exists()) {
                            file5.delete();
                        }
                        if (C3048c.m2149b((File[]) arrayList.toArray(new File[arrayList.size()]), file5.getPath())) {
                            file = file5;
                        }
                    }
                }
            } catch (Throwable th) {
                Log.d("BACKEND_", "saveReport error: " + Log.getStackTraceString(th));
            }
            abstractC2747w.mo3282b(file);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$i */
    /* loaded from: classes.dex */
    public class C3061i implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".zip");
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$j */
    /* loaded from: classes.dex */
    public class C3062j implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$k */
    /* loaded from: classes.dex */
    public class C3063k implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".log");
        }
    }

    /* renamed from: d */
    public static void m2143d(String str) {
        m2152b(str).subscribeOn(C2720a.m3323b()).subscribe();
    }

    /* renamed from: e */
    public static void m2141e(String str) {
        m2146c(str).subscribeOn(C2720a.m3323b()).subscribe();
    }

    /* renamed from: f */
    public static AbstractC2745u<Object> m2140f() {
        return new C3050b();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005a -> B:14:0x005b). Please submit an issue!!! */
    /* renamed from: g */
    public static File m2139g() {
        try {
            File dir = App.getContext().getDir("reports", 0);
            if (dir.exists()) {
                File[] listFiles = dir.listFiles(new C3061i());
                if (listFiles.length > 0) {
                    Arrays.sort(listFiles, new C3062j());
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
                File[] listFiles = dir.listFiles(new C3057f());
                if (listFiles.length > 0) {
                    Arrays.sort(listFiles, new C3058g());
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
        m2145c(C3452w.m1497d().m1495f(), str5 + "_" + str6).subscribeOn(C2720a.m3323b()).subscribe();
        return Log.w(str5, str6);
    }

    /* renamed from: c */
    public static AbstractC2745u<Object> m2145c(Date date, String str) {
        return new C3052c(date, str);
    }

    /* renamed from: d */
    public static void m2144d() {
        try {
            BufferedWriter bufferedWriter = f8760c;
            if (bufferedWriter != null) {
                bufferedWriter.close();
                f8760c = null;
            }
            FileOutputStream fileOutputStream = f8759b;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                f8759b = null;
            }
            File dir = App.getContext().getDir("anda_backend_logs", 0);
            dir.mkdirs();
            File[] listFiles = dir.listFiles(new C3063k());
            int length = listFiles.length;
            if (length >= f8761d) {
                Arrays.sort(listFiles, new C3049a());
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
            f8759b = new FileOutputStream(new File(dir, "anda_backend_" + (length + 1) + ".log"), true);
            f8760c = new BufferedWriter(new OutputStreamWriter(f8759b));
        } catch (Throwable th) {
            try {
                BufferedWriter bufferedWriter2 = f8760c;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
            } catch (Throwable unused) {
            }
            try {
                FileOutputStream fileOutputStream2 = f8759b;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable unused2) {
            }
            f8760c = null;
            f8759b = null;
            Log.d("BACKEND_", "Error creating new log file stream. " + Log.getStackTraceString(th));
        }
    }

    /* renamed from: e */
    public static void m2142e() {
        try {
            BufferedWriter bufferedWriter = f8760c;
            if (bufferedWriter != null) {
                bufferedWriter.close();
                f8760c = null;
            }
            FileOutputStream fileOutputStream = f8759b;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                f8759b = null;
            }
            File dir = App.getContext().getDir("anda_backend_logs", 0);
            dir.mkdirs();
            int m2153b = m2153b(dir);
            if (m2153b > 0) {
                f8759b = new FileOutputStream(new File(dir, "anda_backend_" + m2153b + ".log"), true);
                f8760c = new BufferedWriter(new OutputStreamWriter(f8759b));
            }
        } catch (Throwable th) {
            try {
                BufferedWriter bufferedWriter2 = f8760c;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
            } catch (Throwable unused) {
            }
            try {
                FileOutputStream fileOutputStream2 = f8759b;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable unused2) {
            }
            f8760c = null;
            f8759b = null;
            Log.d("BACKEND_", "Error getting last log file stream." + Log.getStackTraceString(th));
        }
    }

    /* renamed from: c */
    public static AbstractC2745u<Object> m2146c(String str) {
        return new C3053d();
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
            synchronized (f8758a) {
                String format = String.format("%s: %s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date), str);
                if (f8760c == null) {
                    m2142e();
                    if (f8760c == null) {
                        m2144d();
                    }
                }
                if (f8760c != null && f8759b.getChannel().position() >= 1048576) {
                    m2144d();
                }
                BufferedWriter bufferedWriter = f8760c;
                if (bufferedWriter != null) {
                    bufferedWriter.write(format);
                    f8760c.newLine();
                    f8760c.flush();
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
        Date m1495f = C3452w.m1497d().m1495f();
        if (z) {
            m2145c(m1495f, str5 + "_" + str6).subscribeOn(C2720a.m3323b()).subscribe();
        } else {
            m2150b(m1495f, str5 + "_" + str6);
        }
        return Log.d(str5, str6);
    }

    /* renamed from: a */
    public static void m2159a(String str, String str2) {
        m2145c(C3452w.m1497d().m1495f(), str + ": " + str2).subscribeOn(C2720a.m3323b()).subscribe();
    }

    /* renamed from: a */
    public static AbstractC2745u<Object> m2160a(String str) {
        return new C3059h(str);
    }

    /* renamed from: b */
    public static AbstractC2745u<Object> m2152b(String str) {
        return new C3054e(str);
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