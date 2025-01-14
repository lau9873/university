package android.support.p065v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.j256.ormlite.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;
import p000a.p006b.p030g.p032b.ContextCompat;

/* renamed from: android.support.v4.content.FileProvider */
/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: b */
    public static final String[] f3546b = {"_display_name", "_size"};

    /* renamed from: c */
    public static final File f3547c = new File("/");

    /* renamed from: d */
    public static HashMap<String, InterfaceC0611a> f3548d = new HashMap<>();

    /* renamed from: a */
    public InterfaceC0611a f3549a;

    /* renamed from: android.support.v4.content.FileProvider$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0611a {
        /* renamed from: a */
        Uri mo7409a(File file);

        /* renamed from: a */
        File mo7410a(Uri uri);
    }

    /* renamed from: a */
    public static Uri m7416a(Context context, String str, File file) {
        return m7417a(context, str).mo7409a(file);
    }

    /* renamed from: b */
    public static InterfaceC0611a m7411b(Context context, String str) {
        C0612b c0612b = new C0612b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, Logger.DEFAULT_FULL_MESSAGE_LENGTH).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = loadXmlMetaData.next();
            if (next == 1) {
                return c0612b;
            }
            if (next == 2) {
                String name = loadXmlMetaData.getName();
                File file = null;
                String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    file = f3547c;
                } else if ("files-path".equals(name)) {
                    file = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    file = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] m10017b = ContextCompat.m10017b(context, (String) null);
                    if (m10017b.length > 0) {
                        file = m10017b[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] m10019b = ContextCompat.m10019b(context);
                    if (m10019b.length > 0) {
                        file = m10019b[0];
                    }
                } else if (Build.VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        file = externalMediaDirs[0];
                    }
                }
                if (file != null) {
                    c0612b.m7408a(attributeValue, m7415a(file, attributeValue2));
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                this.f3549a = m7417a(context, providerInfo.authority);
                return;
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f3549a.mo7410a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File mo7410a = this.f3549a.mo7410a(uri);
        int lastIndexOf = mo7410a.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(mo7410a.getName().substring(lastIndexOf + 1));
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.f3549a.mo7410a(uri), m7414a(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File mo7410a = this.f3549a.mo7410a(uri);
        if (strArr == null) {
            strArr = f3546b;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = mo7410a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(mo7410a.length());
            }
            i2 = i;
        }
        String[] m7412a = m7412a(strArr3, i2);
        Object[] m7413a = m7413a(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(m7412a, 1);
        matrixCursor.addRow(m7413a);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    /* renamed from: a */
    public static InterfaceC0611a m7417a(Context context, String str) {
        InterfaceC0611a interfaceC0611a;
        synchronized (f3548d) {
            interfaceC0611a = f3548d.get(str);
            if (interfaceC0611a == null) {
                try {
                    interfaceC0611a = m7411b(context, str);
                    f3548d.put(str, interfaceC0611a);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return interfaceC0611a;
    }

    /* renamed from: android.support.v4.content.FileProvider$b */
    /* loaded from: classes.dex */
    public static class C0612b implements InterfaceC0611a {

        /* renamed from: a */
        public final String f3550a;

        /* renamed from: b */
        public final HashMap<String, File> f3551b = new HashMap<>();

        public C0612b(String str) {
            this.f3550a = str;
        }

        /* renamed from: a */
        public void m7408a(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f3551b.put(str, file.getCanonicalFile());
                    return;
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
                }
            }
            throw new IllegalArgumentException("Name must not be empty");
        }

        @Override // android.support.p065v4.content.FileProvider.InterfaceC0611a
        /* renamed from: a */
        public Uri mo7409a(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f3551b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry != null) {
                    String path2 = entry.getValue().getPath();
                    if (path2.endsWith("/")) {
                        substring = canonicalPath.substring(path2.length());
                    } else {
                        substring = canonicalPath.substring(path2.length() + 1);
                    }
                    return new Uri.Builder().scheme("content").authority(this.f3550a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(substring, "/")).build();
                }
                throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // android.support.p065v4.content.FileProvider.InterfaceC0611a
        /* renamed from: a */
        public File mo7410a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f3551b.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            }
            throw new IllegalArgumentException("Unable to find configured root for " + uri);
        }
    }

    /* renamed from: a */
    public static int m7414a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    /* renamed from: a */
    public static File m7415a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    /* renamed from: a */
    public static String[] m7412a(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    /* renamed from: a */
    public static Object[] m7413a(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }
}
