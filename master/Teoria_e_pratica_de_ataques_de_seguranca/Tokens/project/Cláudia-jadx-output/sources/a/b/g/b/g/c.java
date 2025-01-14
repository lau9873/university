package a.b.g.b.g;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        public final C0020c[] f887a;

        public b(C0020c[] c0020cArr) {
            this.f887a = c0020cArr;
        }

        public C0020c[] a() {
            return this.f887a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: a.b.g.b.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0020c {

        /* renamed from: a  reason: collision with root package name */
        public final String f888a;

        /* renamed from: b  reason: collision with root package name */
        public int f889b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f890c;

        /* renamed from: d  reason: collision with root package name */
        public String f891d;

        /* renamed from: e  reason: collision with root package name */
        public int f892e;

        /* renamed from: f  reason: collision with root package name */
        public int f893f;

        public C0020c(String str, int i2, boolean z, String str2, int i3, int i4) {
            this.f888a = str;
            this.f889b = i2;
            this.f890c = z;
            this.f891d = str2;
            this.f892e = i3;
            this.f893f = i4;
        }

        public String a() {
            return this.f888a;
        }

        public int b() {
            return this.f893f;
        }

        public int c() {
            return this.f892e;
        }

        public String d() {
            return this.f891d;
        }

        public int e() {
            return this.f889b;
        }

        public boolean f() {
            return this.f890c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        public final a.b.g.h.a f894a;

        /* renamed from: b  reason: collision with root package name */
        public final int f895b;

        /* renamed from: c  reason: collision with root package name */
        public final int f896c;

        public d(a.b.g.h.a aVar, int i2, int i3) {
            this.f894a = aVar;
            this.f896c = i2;
            this.f895b = i3;
        }

        public int a() {
            return this.f896c;
        }

        public a.b.g.h.a b() {
            return this.f894a;
        }

        public int c() {
            return this.f895b;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    public static a c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.b.a.c.FontFamily);
        String string = obtainAttributes.getString(a.b.a.c.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(a.b.a.c.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(a.b.a.c.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(a.b.a.c.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(a.b.a.c.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(a.b.a.c.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new d(new a.b.g.h.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(d(xmlPullParser, resources));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0020c[]) arrayList.toArray(new C0020c[arrayList.size()]));
    }

    public static C0020c d(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.b.a.c.FontFamilyFont);
        int i2 = obtainAttributes.getInt(obtainAttributes.hasValue(a.b.a.c.FontFamilyFont_fontWeight) ? a.b.a.c.FontFamilyFont_fontWeight : a.b.a.c.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(a.b.a.c.FontFamilyFont_fontStyle) ? a.b.a.c.FontFamilyFont_fontStyle : a.b.a.c.FontFamilyFont_android_fontStyle, 0);
        int i3 = obtainAttributes.hasValue(a.b.a.c.FontFamilyFont_ttcIndex) ? a.b.a.c.FontFamilyFont_ttcIndex : a.b.a.c.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(a.b.a.c.FontFamilyFont_fontVariationSettings) ? a.b.a.c.FontFamilyFont_fontVariationSettings : a.b.a.c.FontFamilyFont_android_fontVariationSettings);
        int i4 = obtainAttributes.getInt(i3, 0);
        int i5 = obtainAttributes.hasValue(a.b.a.c.FontFamilyFont_font) ? a.b.a.c.FontFamilyFont_font : a.b.a.c.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i5, 0);
        String string2 = obtainAttributes.getString(i5);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new C0020c(string2, i2, z, string, i4, resourceId);
    }

    public static int a(TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        return typedValue.type;
    }

    public static List<List<byte[]>> a(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    public static void a(XmlPullParser xmlPullParser) {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }
}
