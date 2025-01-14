package p070c.p084d.p105b.p107v;

import java.math.BigDecimal;

/* renamed from: c.d.b.v.g */
/* loaded from: classes.dex */
public final class LazilyParsedNumber extends Number {

    /* renamed from: a */
    public final String f5726a;

    public LazilyParsedNumber(String str) {
        this.f5726a = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f5726a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LazilyParsedNumber) {
            String str = this.f5726a;
            String str2 = ((LazilyParsedNumber) obj).f5726a;
            return str == str2 || str.equals(str2);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f5726a);
    }

    public int hashCode() {
        return this.f5726a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f5726a);
            } catch (NumberFormatException unused) {
                return new BigDecimal(this.f5726a).intValue();
            }
        } catch (NumberFormatException unused2) {
            return (int) Long.parseLong(this.f5726a);
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f5726a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f5726a).longValue();
        }
    }

    public String toString() {
        return this.f5726a;
    }
}
