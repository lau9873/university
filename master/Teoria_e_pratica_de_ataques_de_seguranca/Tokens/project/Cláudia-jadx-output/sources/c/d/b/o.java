package c.d.b;

import java.math.BigInteger;
/* compiled from: JsonPrimitive.java */
/* loaded from: classes.dex */
public final class o extends l {

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f3735b = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: a  reason: collision with root package name */
    public Object f3736a;

    public o(Boolean bool) {
        a(bool);
    }

    public static boolean b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f3735b) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean A() {
        return this.f3736a instanceof Boolean;
    }

    public boolean B() {
        return this.f3736a instanceof Number;
    }

    public boolean C() {
        return this.f3736a instanceof String;
    }

    public void a(Object obj) {
        if (obj instanceof Character) {
            this.f3736a = String.valueOf(((Character) obj).charValue());
            return;
        }
        c.d.b.v.a.a((obj instanceof Number) || b(obj));
        this.f3736a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f3736a == null) {
            return oVar.f3736a == null;
        } else if (a(this) && a(oVar)) {
            return z().longValue() == oVar.z().longValue();
        } else if ((this.f3736a instanceof Number) && (oVar.f3736a instanceof Number)) {
            double doubleValue = z().doubleValue();
            double doubleValue2 = oVar.z().doubleValue();
            if (doubleValue != doubleValue2) {
                return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
            }
            return true;
        } else {
            return this.f3736a.equals(oVar.f3736a);
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f3736a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = z().longValue();
        } else {
            Object obj = this.f3736a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(z().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    @Override // c.d.b.l
    public String p() {
        if (B()) {
            return z().toString();
        }
        if (A()) {
            return v().toString();
        }
        return (String) this.f3736a;
    }

    public boolean u() {
        if (A()) {
            return v().booleanValue();
        }
        return Boolean.parseBoolean(p());
    }

    public Boolean v() {
        return (Boolean) this.f3736a;
    }

    public double w() {
        return B() ? z().doubleValue() : Double.parseDouble(p());
    }

    public int x() {
        return B() ? z().intValue() : Integer.parseInt(p());
    }

    public long y() {
        return B() ? z().longValue() : Long.parseLong(p());
    }

    public Number z() {
        Object obj = this.f3736a;
        return obj instanceof String ? new c.d.b.v.g((String) obj) : (Number) obj;
    }

    public o(Number number) {
        a(number);
    }

    public o(String str) {
        a(str);
    }

    public static boolean a(o oVar) {
        Object obj = oVar.f3736a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }
}
