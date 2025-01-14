package p000a.p006b.p049h.p057f;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.support.p067v7.preference.Preference;
import android.support.p067v7.preference.PreferenceGroup;
import android.support.v14.preference.SwitchPreference;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: a.b.h.f.i */
/* loaded from: classes.dex */
public class PreferenceInflater {

    /* renamed from: e */
    public static final Class<?>[] f2171e = {Context.class, AttributeSet.class};

    /* renamed from: f */
    public static final HashMap<String, Constructor> f2172f = new HashMap<>();

    /* renamed from: a */
    public final Context f2173a;

    /* renamed from: b */
    public final Object[] f2174b = new Object[2];

    /* renamed from: c */
    public PreferenceManager f2175c;

    /* renamed from: d */
    public String[] f2176d;

    public PreferenceInflater(Context context, PreferenceManager preferenceManager) {
        this.f2173a = context;
        m8844a(preferenceManager);
    }

    /* renamed from: a */
    public final void m8844a(PreferenceManager preferenceManager) {
        this.f2175c = preferenceManager;
        m8837a(new String[]{Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."});
    }

    /* renamed from: b */
    public Preference m8836b(String str, AttributeSet attributeSet) {
        return m8841a(str, this.f2176d, attributeSet);
    }

    /* renamed from: a */
    public void m8837a(String[] strArr) {
        this.f2176d = strArr;
    }

    /* renamed from: a */
    public Context m8846a() {
        return this.f2173a;
    }

    /* renamed from: a */
    public Preference m8845a(int i, PreferenceGroup preferenceGroup) {
        XmlResourceParser xml = m8846a().getResources().getXml(i);
        try {
            return m8838a(xml, preferenceGroup);
        } finally {
            xml.close();
        }
    }

    /* renamed from: a */
    public Preference m8838a(XmlPullParser xmlPullParser, PreferenceGroup preferenceGroup) {
        int next;
        PreferenceGroup m8843a;
        synchronized (this.f2174b) {
            AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
            this.f2174b[0] = this.f2173a;
            do {
                try {
                    next = xmlPullParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (InflateException e) {
                    throw e;
                } catch (IOException e2) {
                    InflateException inflateException = new InflateException(xmlPullParser.getPositionDescription() + ": " + e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (XmlPullParserException e3) {
                    InflateException inflateException2 = new InflateException(e3.getMessage());
                    inflateException2.initCause(e3);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next == 2) {
                m8843a = m8843a(preferenceGroup, (PreferenceGroup) m8842a(xmlPullParser.getName(), asAttributeSet));
                m8839a(xmlPullParser, m8843a, asAttributeSet);
            } else {
                throw new InflateException(xmlPullParser.getPositionDescription() + ": No start tag found!");
            }
        }
        return m8843a;
    }

    /* renamed from: a */
    public final PreferenceGroup m8843a(PreferenceGroup preferenceGroup, PreferenceGroup preferenceGroup2) {
        if (preferenceGroup == null) {
            preferenceGroup2.m7252a(this.f2175c);
            return preferenceGroup2;
        }
        return preferenceGroup;
    }

    /* renamed from: a */
    public final Preference m8841a(String str, String[] strArr, AttributeSet attributeSet) {
        Class<?> loadClass;
        Constructor<?> constructor = f2172f.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.f2173a.getClassLoader();
                    if (strArr != null && strArr.length != 0) {
                        loadClass = null;
                        ClassNotFoundException e = null;
                        for (String str2 : strArr) {
                            try {
                                loadClass = classLoader.loadClass(str2 + str);
                                break;
                            } catch (ClassNotFoundException e2) {
                                e = e2;
                            }
                        }
                        if (loadClass == null) {
                            if (e == null) {
                                throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                            }
                            throw e;
                        }
                        constructor = loadClass.getConstructor(f2171e);
                        constructor.setAccessible(true);
                        f2172f.put(str, constructor);
                    }
                    loadClass = classLoader.loadClass(str);
                    constructor = loadClass.getConstructor(f2171e);
                    constructor.setAccessible(true);
                    f2172f.put(str, constructor);
                } catch (Exception e3) {
                    InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                    inflateException.initCause(e3);
                    throw inflateException;
                }
            } catch (ClassNotFoundException e4) {
                throw e4;
            }
        }
        Object[] objArr = this.f2174b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    /* renamed from: a */
    public final Preference m8842a(String str, AttributeSet attributeSet) {
        try {
            if (-1 == str.indexOf(46)) {
                return m8836b(str, attributeSet);
            }
            return m8841a(str, (String[]) null, attributeSet);
        } catch (InflateException e) {
            throw e;
        } catch (ClassNotFoundException e2) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Exception e3) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e3);
            throw inflateException2;
        }
    }

    /* renamed from: a */
    public final void m8839a(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) {
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
                        preference.m7250a(Intent.parseIntent(m8846a().getResources(), xmlPullParser, attributeSet));
                    } catch (IOException e) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    m8846a().getResources().parseBundleExtra("extra", attributeSet, preference.m7219e());
                    try {
                        m8840a(xmlPullParser);
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e2);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference m8842a = m8842a(name, attributeSet);
                    ((PreferenceGroup) preference).m7181d(m8842a);
                    m8839a(xmlPullParser, m8842a, attributeSet);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m8840a(XmlPullParser xmlPullParser) {
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
