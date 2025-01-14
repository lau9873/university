package io.michaelrocks.libphonenumber.android;

/* loaded from: classes.dex */
public class NumberParseException extends Exception {

    /* renamed from: a */
    public EnumC2652a f10555a;

    /* renamed from: b */
    public String f10556b;

    /* renamed from: io.michaelrocks.libphonenumber.android.NumberParseException$a */
    /* loaded from: classes.dex */
    public enum EnumC2652a {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public NumberParseException(EnumC2652a enumC2652a, String str) {
        super(str);
        this.f10556b = str;
        this.f10555a = enumC2652a;
    }

    /* renamed from: a */
    public EnumC2652a m500a() {
        return this.f10555a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error type: " + this.f10555a + ". " + this.f10556b;
    }
}
