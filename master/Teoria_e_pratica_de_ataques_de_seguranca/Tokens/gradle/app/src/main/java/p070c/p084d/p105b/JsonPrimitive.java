package p070c.p084d.p105b;

import java.math.BigInteger;
import p070c.p084d.p105b.p107v.C$Gson$Preconditions;
import p070c.p084d.p105b.p107v.LazilyParsedNumber;

/* renamed from: c.d.b.o */
/* loaded from: classes.dex */
public final class JsonPrimitive extends JsonElement {

    /* renamed from: b */
    public static final Class<?>[] f5687b = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: a */
    public Object f5688a;

    public JsonPrimitive(Boolean bool) {
        m4898a(bool);
    }

    /* renamed from: b */
    public static boolean m4897b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f5687b) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: A */
    public boolean m4902A() {
        return this.f5688a instanceof Boolean;
    }

    /* renamed from: B */
    public boolean m4901B() {
        return this.f5688a instanceof Number;
    }

    /* renamed from: C */
    public boolean m4900C() {
        return this.f5688a instanceof String;
    }

    /* renamed from: a */
    public void m4898a(Object obj) {
        if (obj instanceof Character) {
            this.f5688a = String.valueOf(((Character) obj).charValue());
            return;
        }
        C$Gson$Preconditions.m4885a((obj instanceof Number) || m4897b(obj));
        this.f5688a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.f5688a == null) {
            return jsonPrimitive.f5688a == null;
        } else if (m4899a(this) && m4899a(jsonPrimitive)) {
            return m4890z().longValue() == jsonPrimitive.m4890z().longValue();
        } else if ((this.f5688a instanceof Number) && (jsonPrimitive.f5688a instanceof Number)) {
            double doubleValue = m4890z().doubleValue();
            double doubleValue2 = jsonPrimitive.m4890z().doubleValue();
            if (doubleValue != doubleValue2) {
                return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
            }
            return true;
        } else {
            return this.f5688a.equals(jsonPrimitive.f5688a);
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f5688a == null) {
            return 31;
        }
        if (m4899a(this)) {
            doubleToLongBits = m4890z().longValue();
        } else {
            Object obj = this.f5688a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(m4890z().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    @Override // p070c.p084d.p105b.JsonElement
    /* renamed from: p */
    public String mo4896p() {
        if (m4901B()) {
            return m4890z().toString();
        }
        if (m4902A()) {
            return m4894v().toString();
        }
        return (String) this.f5688a;
    }

    /* renamed from: u */
    public boolean m4895u() {
        if (m4902A()) {
            return m4894v().booleanValue();
        }
        return Boolean.parseBoolean(mo4896p());
    }

    /* renamed from: v */
    public Boolean m4894v() {
        return (Boolean) this.f5688a;
    }

    /* renamed from: w */
    public double m4893w() {
        return m4901B() ? m4890z().doubleValue() : Double.parseDouble(mo4896p());
    }

    /* renamed from: x */
    public int m4892x() {
        return m4901B() ? m4890z().intValue() : Integer.parseInt(mo4896p());
    }

    /* renamed from: y */
    public long m4891y() {
        return m4901B() ? m4890z().longValue() : Long.parseLong(mo4896p());
    }

    /* renamed from: z */
    public Number m4890z() {
        Object obj = this.f5688a;
        return obj instanceof String ? new LazilyParsedNumber((String) obj) : (Number) obj;
    }

    public JsonPrimitive(Number number) {
        m4898a(number);
    }

    public JsonPrimitive(String str) {
        m4898a(str);
    }

    /* renamed from: a */
    public static boolean m4899a(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.f5688a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }
}
