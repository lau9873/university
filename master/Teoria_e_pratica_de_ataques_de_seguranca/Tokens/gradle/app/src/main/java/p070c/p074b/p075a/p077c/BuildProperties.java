package p070c.p074b.p075a.p077c;

import java.io.InputStream;
import java.util.Properties;

/* renamed from: c.b.a.c.d */
/* loaded from: classes.dex */
public class BuildProperties {

    /* renamed from: a */
    public final String f4777a;

    /* renamed from: b */
    public final String f4778b;

    /* renamed from: c */
    public final String f4779c;

    /* renamed from: d */
    public final String f4780d;

    public BuildProperties(String str, String str2, String str3, String str4) {
        this.f4777a = str;
        this.f4778b = str2;
        this.f4779c = str3;
        this.f4780d = str4;
    }

    /* renamed from: a */
    public static BuildProperties m5987a(Properties properties) {
        return new BuildProperties(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    /* renamed from: a */
    public static BuildProperties m5988a(InputStream inputStream) {
        Properties properties = new Properties();
        properties.load(inputStream);
        return m5987a(properties);
    }
}
