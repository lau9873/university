package c.b.a.d;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
/* compiled from: Utils.java */
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    public static final FilenameFilter f3088a = new a();

    /* compiled from: Utils.java */
    /* loaded from: classes.dex */
    public static class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return true;
        }
    }

    public static int a(File file, int i2, Comparator<File> comparator) {
        return a(file, f3088a, i2, comparator);
    }

    public static int a(File file, FilenameFilter filenameFilter, int i2, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        if (listFiles == null) {
            return 0;
        }
        int length = listFiles.length;
        Arrays.sort(listFiles, comparator);
        for (File file2 : listFiles) {
            if (length <= i2) {
                return length;
            }
            file2.delete();
            length--;
        }
        return length;
    }
}
