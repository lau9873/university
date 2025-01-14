package p000a.p006b.p030g.p032b.p033g;

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
import p000a.p006b.p007a.C0018c;
import p000a.p006b.p030g.p042h.FontRequest;

/* renamed from: a.b.g.b.g.c */
/* loaded from: classes.dex */
public class FontResourcesParserCompat {

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: a.b.g.b.g.c$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0205a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: a.b.g.b.g.c$b */
    /* loaded from: classes.dex */
    public static final class C0206b implements InterfaceC0205a {

        /* renamed from: a */
        public final C0207c[] f1393a;

        public C0206b(C0207c[] c0207cArr) {
            this.f1393a = c0207cArr;
        }

        /* renamed from: a */
        public C0207c[] m9969a() {
            return this.f1393a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: a.b.g.b.g.c$c */
    /* loaded from: classes.dex */
    public static final class C0207c {

        /* renamed from: a */
        public final String f1394a;

        /* renamed from: b */
        public int f1395b;

        /* renamed from: c */
        public boolean f1396c;

        /* renamed from: d */
        public String f1397d;

        /* renamed from: e */
        public int f1398e;

        /* renamed from: f */
        public int f1399f;

        public C0207c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f1394a = str;
            this.f1395b = i;
            this.f1396c = z;
            this.f1397d = str2;
            this.f1398e = i2;
            this.f1399f = i3;
        }

        /* renamed from: a */
        public String m9968a() {
            return this.f1394a;
        }

        /* renamed from: b */
        public int m9967b() {
            return this.f1399f;
        }

        /* renamed from: c */
        public int m9966c() {
            return this.f1398e;
        }

        /* renamed from: d */
        public String m9965d() {
            return this.f1397d;
        }

        /* renamed from: e */
        public int m9964e() {
            return this.f1395b;
        }

        /* renamed from: f */
        public boolean m9963f() {
            return this.f1396c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: a.b.g.b.g.c$d */
    /* loaded from: classes.dex */
    public static final class C0208d implements InterfaceC0205a {

        /* renamed from: a */
        public final FontRequest f1400a;

        /* renamed from: b */
        public final int f1401b;

        /* renamed from: c */
        public final int f1402c;

        public C0208d(FontRequest fontRequest, int i, int i2) {
            this.f1400a = fontRequest;
            this.f1402c = i;
            this.f1401b = i2;
        }

        /* renamed from: a */
        public int m9962a() {
            return this.f1402c;
        }

        /* renamed from: b */
        public FontRequest m9961b() {
            return this.f1400a;
        }

        /* renamed from: c */
        public int m9960c() {
            return this.f1401b;
        }
    }

    /* renamed from: a */
    public static InterfaceC0205a m9974a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m9972b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* renamed from: b */
    public static InterfaceC0205a m9972b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m9971c(xmlPullParser, resources);
        }
        m9975a(xmlPullParser);
        return null;
    }

    /* renamed from: c */
    public static InterfaceC0205a m9971c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0018c.FontFamily);
        String string = obtainAttributes.getString(C0018c.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(C0018c.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(C0018c.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(C0018c.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(C0018c.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(C0018c.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                m9975a(xmlPullParser);
            }
            return new C0208d(new FontRequest(string, string2, string3, m9977a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(m9970d(xmlPullParser, resources));
                } else {
                    m9975a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new C0206b((C0207c[]) arrayList.toArray(new C0207c[arrayList.size()]));
    }

    /* renamed from: d */
    public static C0207c m9970d(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0018c.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(C0018c.FontFamilyFont_fontWeight) ? C0018c.FontFamilyFont_fontWeight : C0018c.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(C0018c.FontFamilyFont_fontStyle) ? C0018c.FontFamilyFont_fontStyle : C0018c.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(C0018c.FontFamilyFont_ttcIndex) ? C0018c.FontFamilyFont_ttcIndex : C0018c.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(C0018c.FontFamilyFont_fontVariationSettings) ? C0018c.FontFamilyFont_fontVariationSettings : C0018c.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        int i4 = obtainAttributes.hasValue(C0018c.FontFamilyFont_font) ? C0018c.FontFamilyFont_font : C0018c.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i4, 0);
        String string2 = obtainAttributes.getString(i4);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m9975a(xmlPullParser);
        }
        return new C0207c(string2, i, z, string, i3, resourceId);
    }

    /* renamed from: a */
    public static int m9976a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    /* renamed from: a */
    public static List<List<byte[]>> m9977a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (m9976a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(m9973a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(m9973a(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    /* renamed from: a */
    public static List<byte[]> m9973a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static void m9975a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
