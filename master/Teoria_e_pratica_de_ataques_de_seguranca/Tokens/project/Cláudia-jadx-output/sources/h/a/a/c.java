package h.a.a;

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
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: AppLog.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f6263a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static FileOutputStream f6264b = null;

    /* renamed from: c  reason: collision with root package name */
    public static BufferedWriter f6265c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f6266d = 5;

    /* compiled from: AppLog.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* compiled from: AppLog.java */
    /* loaded from: classes.dex */
    public class b extends d.c.u<Object> {

        /* compiled from: AppLog.java */
        /* loaded from: classes.dex */
        public class a implements FilenameFilter {
            public a(b bVar) {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".log");
            }
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            File[] listFiles;
            File file = null;
            try {
                synchronized (c.f6263a) {
                    File dir = App.getContext().getDir("anda_backend_logs", 0);
                    if (dir.exists() && (listFiles = dir.listFiles(new a(this))) != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(Arrays.asList(listFiles));
                        File file2 = new File(dir, "Logcat.txt");
                        c.c(file2);
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
                            if (c.b((File[]) arrayList.toArray(new File[arrayList.size()]), file3.getPath())) {
                                file = file3;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                Log.d("BACKEND_", "getLibLog error: " + Log.getStackTraceString(th));
            }
            wVar.b(file);
        }
    }

    /* compiled from: AppLog.java */
    /* renamed from: h.a.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0129c extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Date f6267a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6268b;

        public C0129c(Date date, String str) {
            this.f6267a = date;
            this.f6268b = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            c.b(this.f6267a, this.f6268b);
            wVar.b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: AppLog.java */
    /* loaded from: classes.dex */
    public class d extends d.c.u<Object> {
        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            try {
                synchronized (c.f6263a) {
                    int unused = c.f6266d = 5;
                }
            } catch (Throwable th) {
                Log.d("LOG_FILE", "tripStarted - failed:" + Log.getStackTraceString(th));
            }
            wVar.b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: AppLog.java */
    /* loaded from: classes.dex */
    public class e extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6269a;

        /* compiled from: AppLog.java */
        /* loaded from: classes.dex */
        public class a implements FilenameFilter {
            public a(e eVar) {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".log");
            }
        }

        /* compiled from: AppLog.java */
        /* loaded from: classes.dex */
        public class b implements Comparator<File> {
            public b(e eVar) {
            }

            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(File file, File file2) {
                return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
            }
        }

        public e(String str) {
            this.f6269a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            try {
                synchronized (c.f6263a) {
                    if (c.f6265c != null) {
                        c.f6265c.close();
                        BufferedWriter unused = c.f6265c = null;
                    }
                    if (c.f6264b != null) {
                        c.f6264b.close();
                        FileOutputStream unused2 = c.f6264b = null;
                    }
                    String str = new SimpleDateFormat("yyyyMMdd").format(w.d().f()) + "_" + this.f6269a;
                    File dir = App.getContext().getDir("anda_backend_logs", 0);
                    dir.mkdirs();
                    if (dir.exists()) {
                        File[] listFiles = dir.listFiles(new a(this));
                        if (listFiles.length > 0) {
                            Arrays.sort(listFiles, new b(this));
                            ArrayList arrayList = new ArrayList();
                            int i2 = 0;
                            while (i2 < listFiles.length) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("anda_backend_");
                                int i3 = i2 + 1;
                                sb.append(i3);
                                sb.append("_");
                                sb.append(str);
                                sb.append(".log");
                                File file = new File(dir, sb.toString());
                                listFiles[i2].renameTo(file);
                                arrayList.add(file);
                                i2 = i3;
                            }
                            File file2 = new File(dir, "Logcat.txt");
                            c.c(file2);
                            if (file2.exists()) {
                                arrayList.add(file2);
                            }
                            c.b((File[]) arrayList.toArray(new File[arrayList.size()]), new File(dir, "anda_backend_" + str + ".zip").getPath());
                            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                ((File) arrayList.get(i4)).delete();
                            }
                        }
                    }
                    int unused3 = c.f6266d = 5;
                }
            } catch (Throwable th) {
                Log.d("LOG_FILE", "tripFinished - failed:" + Log.getStackTraceString(th));
            }
            wVar.b(DataModels.EMPTY_OBJECT);
        }
    }

    /* compiled from: AppLog.java */
    /* loaded from: classes.dex */
    public class f implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".zip");
        }
    }

    /* compiled from: AppLog.java */
    /* loaded from: classes.dex */
    public class g implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* compiled from: AppLog.java */
    /* loaded from: classes.dex */
    public class h extends d.c.u<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6270a;

        /* compiled from: AppLog.java */
        /* loaded from: classes.dex */
        public class a implements FilenameFilter {
            public a(h hVar) {
            }

            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.toLowerCase().endsWith(".log");
            }
        }

        public h(String str) {
            this.f6270a = str;
        }

        @Override // d.c.u
        public void subscribeActual(d.c.w<? super Object> wVar) {
            File[] listFiles;
            ArrayList arrayList = new ArrayList();
            File file = null;
            try {
                synchronized (c.f6263a) {
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
                        outputStreamWriter.write(this.f6270a);
                        outputStreamWriter.close();
                        arrayList.add(file3);
                        File dir2 = App.getContext().getDir("anda_backend_logs", 0);
                        if (dir2.exists() && (listFiles = dir2.listFiles(new a(this))) != null) {
                            arrayList.addAll(Arrays.asList(listFiles));
                            File file4 = new File(dir2, "Logcat.txt");
                            c.c(file4);
                            if (file4.exists()) {
                                arrayList.add(file4);
                            }
                        }
                        File file5 = new File(dir, "report_" + new SimpleDateFormat("yyyyMMddHHmmss").format(w.d().f()) + "_" + UUID.randomUUID().toString() + ".zip");
                        if (file5.exists()) {
                            file5.delete();
                        }
                        if (c.b((File[]) arrayList.toArray(new File[arrayList.size()]), file5.getPath())) {
                            file = file5;
                        }
                    }
                }
            } catch (Throwable th) {
                Log.d("BACKEND_", "saveReport error: " + Log.getStackTraceString(th));
            }
            wVar.b(file);
        }
    }

    /* compiled from: AppLog.java */
    /* loaded from: classes.dex */
    public class i implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".zip");
        }
    }

    /* compiled from: AppLog.java */
    /* loaded from: classes.dex */
    public class j implements Comparator<File> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* compiled from: AppLog.java */
    /* loaded from: classes.dex */
    public class k implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".log");
        }
    }

    public static void d(String str) {
        b(str).subscribeOn(d.c.j0.a.b()).subscribe();
    }

    public static void e(String str) {
        c(str).subscribeOn(d.c.j0.a.b()).subscribe();
    }

    public static d.c.u<Object> f() {
        return new b();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005a -> B:14:0x005b). Please submit an issue!!! */
    public static File g() {
        try {
            File dir = App.getContext().getDir("reports", 0);
            if (dir.exists()) {
                File[] listFiles = dir.listFiles(new i());
                if (listFiles.length > 0) {
                    Arrays.sort(listFiles, new j());
                    if (listFiles[0].length() > 10485760) {
                        listFiles[0].delete();
                        return g();
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
    public static File h() {
        try {
            File dir = App.getContext().getDir("anda_backend_logs", 0);
            if (dir.exists()) {
                File[] listFiles = dir.listFiles(new f());
                if (listFiles.length > 0) {
                    Arrays.sort(listFiles, new g());
                    if (listFiles[0].length() > 10485760) {
                        listFiles[0].delete();
                        return h();
                    }
                    return listFiles[0];
                }
            }
        } catch (Throwable th) {
            Log.d("LOG_FILE", "getTripLog error:" + Log.getStackTraceString(th));
        }
        return null;
    }

    public static int b(String str, String str2, String str3, String str4) {
        String str5 = "BACKEND_" + str;
        String str6 = str2 + "_" + str3 + ": " + str4;
        c(w.d().f(), str5 + "_" + str6).subscribeOn(d.c.j0.a.b()).subscribe();
        return Log.w(str5, str6);
    }

    public static d.c.u<Object> c(Date date, String str) {
        return new C0129c(date, str);
    }

    public static void d() {
        try {
            BufferedWriter bufferedWriter = f6265c;
            if (bufferedWriter != null) {
                bufferedWriter.close();
                f6265c = null;
            }
            FileOutputStream fileOutputStream = f6264b;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                f6264b = null;
            }
            File dir = App.getContext().getDir("anda_backend_logs", 0);
            dir.mkdirs();
            File[] listFiles = dir.listFiles(new k());
            int length = listFiles.length;
            if (length >= f6266d) {
                Arrays.sort(listFiles, new a());
                listFiles[0].delete();
                length--;
            }
            int i2 = 1;
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3].exists()) {
                    String str = "anda_backend_" + i2 + ".log";
                    if (!listFiles[i3].getName().equals(str)) {
                        listFiles[i3].renameTo(new File(dir, str));
                    }
                    i2++;
                }
            }
            f6264b = new FileOutputStream(new File(dir, "anda_backend_" + (length + 1) + ".log"), true);
            f6265c = new BufferedWriter(new OutputStreamWriter(f6264b));
        } catch (Throwable th) {
            try {
                BufferedWriter bufferedWriter2 = f6265c;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
            } catch (Throwable unused) {
            }
            try {
                FileOutputStream fileOutputStream2 = f6264b;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable unused2) {
            }
            f6265c = null;
            f6264b = null;
            Log.d("BACKEND_", "Error creating new log file stream. " + Log.getStackTraceString(th));
        }
    }

    public static void e() {
        try {
            BufferedWriter bufferedWriter = f6265c;
            if (bufferedWriter != null) {
                bufferedWriter.close();
                f6265c = null;
            }
            FileOutputStream fileOutputStream = f6264b;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                f6264b = null;
            }
            File dir = App.getContext().getDir("anda_backend_logs", 0);
            dir.mkdirs();
            int b2 = b(dir);
            if (b2 > 0) {
                f6264b = new FileOutputStream(new File(dir, "anda_backend_" + b2 + ".log"), true);
                f6265c = new BufferedWriter(new OutputStreamWriter(f6264b));
            }
        } catch (Throwable th) {
            try {
                BufferedWriter bufferedWriter2 = f6265c;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
            } catch (Throwable unused) {
            }
            try {
                FileOutputStream fileOutputStream2 = f6264b;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable unused2) {
            }
            f6265c = null;
            f6264b = null;
            Log.d("BACKEND_", "Error getting last log file stream." + Log.getStackTraceString(th));
        }
    }

    public static d.c.u<Object> c(String str) {
        return new d();
    }

    public static void c(File file) {
        Throwable th;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        byte[] bArr = new byte[8192];
        InputStream inputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    inputStream = Runtime.getRuntime().exec("logcat -d -v time").getInputStream();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable unused) {
                return;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
        try {
            for (int read = inputStream.read(bArr, 0, 8192); read != -1; read = inputStream.read(bArr, 0, 8192)) {
                fileOutputStream.write(bArr, 0, read);
            }
            try {
                inputStream.close();
            } catch (Throwable unused2) {
            }
            fileOutputStream.flush();
        } catch (Throwable th4) {
            th = th4;
            inputStream2 = inputStream;
            try {
                Log.d("BACKEND_", "Error getting log file:" + Log.getStackTraceString(th));
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                return;
            } finally {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
            }
        }
        fileOutputStream.close();
    }

    public static void b(Date date, String str) {
        try {
            synchronized (f6263a) {
                String format = String.format("%s: %s", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date), str);
                if (f6265c == null) {
                    e();
                    if (f6265c == null) {
                        d();
                    }
                }
                if (f6265c != null && f6264b.getChannel().position() >= 1048576) {
                    d();
                }
                BufferedWriter bufferedWriter = f6265c;
                if (bufferedWriter != null) {
                    bufferedWriter.write(format);
                    f6265c.newLine();
                    f6265c.flush();
                } else {
                    Log.d("LOG_FILE", "Failed to get/create the log file stream");
                }
            }
        } catch (Throwable th) {
            Log.d("LOG_FILE", "Failed to write the log file:" + Log.getStackTraceString(th));
        }
    }

    public static int a(String str, String str2, String str3, String str4) {
        return a(str, str2, str3, str4, true);
    }

    public static int a(String str, String str2, String str3, String str4, boolean z) {
        String str5 = "BACKEND_" + str;
        String str6 = str2 + "_" + str3 + ": " + str4;
        Date f2 = w.d().f();
        if (z) {
            c(f2, str5 + "_" + str6).subscribeOn(d.c.j0.a.b()).subscribe();
        } else {
            b(f2, str5 + "_" + str6);
        }
        return Log.d(str5, str6);
    }

    public static void a(String str, String str2) {
        c(w.d().f(), str + ": " + str2).subscribeOn(d.c.j0.a.b()).subscribe();
    }

    public static d.c.u<Object> a(String str) {
        return new h(str);
    }

    public static d.c.u<Object> b(String str) {
        return new e(str);
    }

    public static int b(File file) {
        if (file.isDirectory() && file.exists()) {
            int i2 = 0;
            for (String str : file.list()) {
                if (str.toLowerCase().endsWith(".log")) {
                    i2++;
                }
            }
            return i2;
        }
        return 0;
    }

    public static boolean b(File[] fileArr, String str) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            byte[] bArr = new byte[4096];
            for (int i2 = 0; i2 < fileArr.length; i2++) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileArr[i2]), 4096);
                zipOutputStream.putNextEntry(new ZipEntry(fileArr[i2].getAbsolutePath().substring(fileArr[i2].getPath().lastIndexOf("/") + 1)));
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
