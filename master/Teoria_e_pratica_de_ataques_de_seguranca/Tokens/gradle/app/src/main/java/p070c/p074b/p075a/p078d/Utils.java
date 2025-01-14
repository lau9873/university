package p070c.p074b.p075a.p078d;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* renamed from: c.b.a.d.m0 */
/* loaded from: classes.dex */
public final class Utils {

    /* renamed from: a */
    public static final FilenameFilter f4926a = new C0861a();

    /* compiled from: Utils.java */
    /* renamed from: c.b.a.d.m0$a */
    /* loaded from: classes.dex */
    public static class C0861a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    /* renamed from: a */
    public static int m5749a(File file, int i, Comparator<File> comparator) {
        return m5748a(file, f4926a, i, comparator);
    }

    /* renamed from: a */
    public static int m5748a(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles == null) {
            return 0;
        }
        int length = listFiles.length;
        Arrays.sort(listFiles, comparator);
        for (File file2 : listFiles) {
            if (length <= i) {
                return length;
            }
            file2.delete();
            length--;
        }
        return length;
    }
}
