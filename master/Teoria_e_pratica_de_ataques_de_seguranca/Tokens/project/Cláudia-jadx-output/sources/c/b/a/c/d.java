package c.b.a.c;

import java.io.InputStream;
import java.util.Properties;
/* compiled from: BuildProperties.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f2964a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2965b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2966c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2967d;

    public d(String str, String str2, String str3, String str4) {
        this.f2964a = str;
        this.f2965b = str2;
        this.f2966c = str3;
        this.f2967d = str4;
    }

    public static d a(Properties properties) {
        return new d(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    public static d a(InputStream inputStream) {
        Properties properties = new Properties();
        properties.load(inputStream);
        return a(properties);
    }
}
