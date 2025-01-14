package p205h.p208b.p209a.p210d;

/* renamed from: h.b.a.d.f */
/* loaded from: classes.dex */
public interface ErrorListener {

    /* compiled from: ErrorListener.java */
    /* renamed from: h.b.a.d.f$b */
    /* loaded from: classes.dex */
    public enum EnumC2360b {
        bluetooth,
        location,
        nfc,
        hce,
        internet
    }

    /* renamed from: a */
    void mo32a(C2358a c2358a);

    /* renamed from: a */
    void mo31a(EnumC2360b enumC2360b);

    /* renamed from: b */
    void mo17b(EnumC2360b enumC2360b);

    /* compiled from: ErrorListener.java */
    /* renamed from: h.b.a.d.f$a */
    /* loaded from: classes.dex */
    public static class C2358a {

        /* renamed from: a */
        public String f9668a;

        /* renamed from: b */
        public String f9669b;

        /* renamed from: c */
        public EnumC2359a f9670c;

        /* renamed from: d */
        public Object f9671d;

        /* renamed from: e */
        public boolean f9672e = false;

        /* compiled from: ErrorListener.java */
        /* renamed from: h.b.a.d.f$a$a */
        /* loaded from: classes.dex */
        public enum EnumC2359a {
            connectionError,
            loginRequired,
            missingData,
            internal,
            permissionRequired_phoneState,
            permissionRequired_location,
            bluetoothOff,
            locationOff,
            nfcOff,
            trip_offlineNotAuthorized,
            unknown,
            hce_notAuthorized,
            hceOff,
            hceError,
            noInternet,
            paymentMethod_missing,
            paymentMethod_invalid,
            invalidEquipment,
            account_notConfirmed,
            account_blackList,
            failed_to_enroll_card,
            card_not_enrolled
        }

        public C2358a(EnumC2359a enumC2359a, String str, String str2) {
            this.f9668a = str;
            this.f9669b = str2;
            this.f9670c = enumC2359a;
        }

        /* renamed from: a */
        public C2358a m1324a(Object obj) {
            if (this.f9671d != null) {
                return this;
            }
            this.f9671d = obj;
            return this;
        }

        /* renamed from: b */
        public EnumC2359a m1323b() {
            return this.f9670c;
        }

        /* renamed from: c */
        public String m1322c() {
            return this.f9669b;
        }

        /* renamed from: d */
        public boolean m1321d() {
            return this.f9672e;
        }

        /* renamed from: e */
        public void m1320e() {
            this.f9672e = true;
        }

        /* renamed from: a */
        public String m1325a() {
            return this.f9668a;
        }
    }
}
