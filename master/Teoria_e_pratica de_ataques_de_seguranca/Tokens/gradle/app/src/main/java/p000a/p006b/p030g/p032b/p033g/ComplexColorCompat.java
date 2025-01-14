package p000a.p006b.p030g.p032b.p033g;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: a.b.g.b.g.b */
/* loaded from: classes.dex */
public final class ComplexColorCompat {

    /* renamed from: a */
    public final Shader f1390a;

    /* renamed from: b */
    public final ColorStateList f1391b;

    /* renamed from: c */
    public int f1392c;

    public ComplexColorCompat(Shader shader, ColorStateList colorStateList, int i) {
        this.f1390a = shader;
        this.f1391b = colorStateList;
        this.f1392c = i;
    }

    /* renamed from: a */
    public static ComplexColorCompat m9985a(Shader shader) {
        return new ComplexColorCompat(shader, null, 0);
    }

    /* renamed from: b */
    public static ComplexColorCompat m9982b(int i) {
        return new ComplexColorCompat(null, null, i);
    }

    /* renamed from: c */
    public boolean m9980c() {
        return this.f1390a != null;
    }

    /* renamed from: d */
    public boolean m9979d() {
        ColorStateList colorStateList;
        return this.f1390a == null && (colorStateList = this.f1391b) != null && colorStateList.isStateful();
    }

    /* renamed from: e */
    public boolean m9978e() {
        return m9980c() || this.f1392c != 0;
    }

    /* renamed from: a */
    public static ComplexColorCompat m9987a(ColorStateList colorStateList) {
        return new ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    /* renamed from: b */
    public Shader m9983b() {
        return this.f1390a;
    }

    /* renamed from: b */
    public static ComplexColorCompat m9981b(Resources resources, int i, Resources.Theme theme) {
        try {
            return m9986a(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    /* renamed from: a */
    public int m9989a() {
        return this.f1392c;
    }

    /* renamed from: a */
    public void m9988a(int i) {
        this.f1392c = i;
    }

    /* renamed from: a */
    public boolean m9984a(int[] iArr) {
        if (m9979d()) {
            ColorStateList colorStateList = this.f1391b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f1392c) {
                this.f1392c = colorForState;
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static ComplexColorCompat m9986a(Resources resources, int i, Resources.Theme theme) {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            char c = 65535;
            int hashCode = name.hashCode();
            if (hashCode != 89650992) {
                if (hashCode == 1191572447 && name.equals("selector")) {
                    c = 0;
                }
            } else if (name.equals("gradient")) {
                c = 1;
            }
            if (c != 0) {
                if (c == 1) {
                    return m9985a(GradientColorInflaterCompat.m9957a(resources, xml, asAttributeSet, theme));
                }
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
            }
            return m9987a(ColorStateListInflaterCompat.m9991a(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException("No start tag found");
    }
}
