package a.b.h.f;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceGroup;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: PreferenceInflater.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: e  reason: collision with root package name */
    public static final Class<?>[] f1430e = {Context.class, AttributeSet.class};

    /* renamed from: f  reason: collision with root package name */
    public static final HashMap<String, Constructor> f1431f = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public final Context f1432a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f1433b = new Object[2];

    /* renamed from: c  reason: collision with root package name */
    public j f1434c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f1435d;

    public i(Context context, j jVar) {
        this.f1432a = context;
        a(jVar);
    }

    public final void a(j jVar) {
        this.f1434c = jVar;
        a(new String[]{Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."});
    }

    public Preference b(String str, AttributeSet attributeSet) {
        return a(str, this.f1435d, attributeSet);
    }

    public void a(String[] strArr) {
        this.f1435d = strArr;
    }

    public Context a() {
        return this.f1432a;
    }

    public Preference a(int i2, PreferenceGroup preferenceGroup) {
        XmlResourceParser xml = a().getResources().getXml(i2);
        try {
            return a(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    public Preference a(XmlPullParser xmlPullParser, PreferenceGroup preferenceGroup) {
        int next;
        PreferenceGroup a2;
        synchronized (this.f1433b) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f1433b[0] = this.f1432a;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException e2) {
                    throw e2;
                } catch (IOException e3) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e3.getMessage());
                    inflateException.initCause(e3);
                    throw inflateException;
                } catch (XmlPullParserException e4) {
                    InflateException inflateException2 = new InflateException(e4.getMessage());
                    inflateException2.initCause(e4);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next == 2) {
                a2 = a(preferenceGroup, (PreferenceGroup) a(xmlPullParser.getName(), asAttributeSet));
                a(xmlPullParser, a2, asAttributeSet);
            } else {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
        }
        return a2;
    }

    public final PreferenceGroup a(PreferenceGroup preferenceGroup, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup == null) {
            preferenceGroup2.a(this.f1434c);
            return preferenceGroup2;
        }
        return preferenceGroup;
    }

    public final Preference a(String str, String[] strArr, AttributeSet attributeSet) {
        Class<?> loadClass;
        Constructor<?> constructor = f1431f.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f1432a.getClassLoader();
                    if (strArr != null && strArr.length != 0) {
                        loadClass = null;
                        ClassNotFoundException e2 = null;
                        for (String str2 : strArr) {
                            try {
                                loadClass = classLoader.loadClass(str2 + str);
                                break;
                            } catch (ClassNotFoundException e3) {
                                e2 = e3;
                            }
                        }
                        if (loadClass == null) {
                            if (e2 == null) {
                                throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                            }
                            throw e2;
                        }
                        constructor = loadClass.getConstructor(f1430e);
                        constructor.setAccessible(true);
                        f1431f.put(str, constructor);
                    }
                    loadClass = classLoader.loadClass(str);
                    constructor = loadClass.getConstructor(f1430e);
                    constructor.setAccessible(true);
                    f1431f.put(str, constructor);
                } catch (ClassNotFoundException e4) {
                    throw e4;
                }
            } catch (Exception e5) {
                InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                inflateException.initCause(e5);
                throw inflateException;
            }
        }
        Object[] objArr = this.f1433b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    public final Preference a(String str, AttributeSet attributeSet) {
        try {
            if (-1 == str.indexOf(46)) {
                return b(str, attributeSet);
            }
            return a(str, (String[]) null, attributeSet);
        } catch (InflateException e2) {
            throw e2;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e3);
            throw inflateException;
        } catch (Exception e4) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e4);
            throw inflateException2;
        }
    }

    public final void a(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.a(Intent.parseIntent(a().getResources(), xmlPullParser, attributeSet));
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e2);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    a().getResources().parseBundleExtra("extra", attributeSet, preference.e());
                    try {
                        a(xmlPullParser);
                    } catch (IOException e3) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e3);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference a2 = a(name, attributeSet);
                    ((PreferenceGroup) preference).d(a2);
                    a(xmlPullParser, a2, attributeSet);
                }
            }
        }
    }

    public static void a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }
}
