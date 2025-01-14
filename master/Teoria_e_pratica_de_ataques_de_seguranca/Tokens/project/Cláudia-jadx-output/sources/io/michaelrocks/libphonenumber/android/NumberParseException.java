package io.michaelrocks.libphonenumber.android;
/* loaded from: classes.dex */
public class NumberParseException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public a f7578a;

    /* renamed from: b  reason: collision with root package name */
    public String f7579b;

    /* loaded from: classes.dex */
    public enum a {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public NumberParseException(a aVar, String str) {
        super(str);
        this.f7579b = str;
        this.f7578a = aVar;
    }

    public a a() {
        return this.f7578a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "Error type: " + this.f7578a + ". " + this.f7579b;
    }
}
