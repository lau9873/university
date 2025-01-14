package c.d.b.v;

import java.math.BigDecimal;
/* compiled from: LazilyParsedNumber.java */
/* loaded from: classes.dex */
public final class g extends Number {

    /* renamed from: a  reason: collision with root package name */
    public final String f3774a;

    public g(String str) {
        this.f3774a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f3774a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            String str = this.f3774a;
            String str2 = ((g) obj).f3774a;
            return str == str2 || str.equals(str2);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f3774a);
    }

    public int hashCode() {
        return this.f3774a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f3774a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f3774a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f3774a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f3774a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f3774a).longValue();
        }
    }

    public String toString() {
        return this.f3774a;
    }
}
