package h.b.a.d;
/* compiled from: ErrorListener.java */
/* loaded from: classes.dex */
public interface f {

    /* compiled from: ErrorListener.java */
    /* loaded from: classes.dex */
    public enum b {
        bluetooth,
        location,
        nfc,
        hce,
        internet
    }

    void a(a aVar);

    void a(b bVar);

    void b(b bVar);

    /* compiled from: ErrorListener.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f7027a;

        /* renamed from: b  reason: collision with root package name */
        public String f7028b;

        /* renamed from: c  reason: collision with root package name */
        public EnumC0164a f7029c;

        /* renamed from: d  reason: collision with root package name */
        public Object f7030d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7031e = false;

        /* compiled from: ErrorListener.java */
        /* renamed from: h.b.a.d.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0164a {
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

        public a(EnumC0164a enumC0164a, String str, String str2) {
            this.f7027a = str;
            this.f7028b = str2;
            this.f7029c = enumC0164a;
        }

        public a a(Object obj) {
            if (this.f7030d != null) {
                return this;
            }
            this.f7030d = obj;
            return this;
        }

        public EnumC0164a b() {
            return this.f7029c;
        }

        public String c() {
            return this.f7028b;
        }

        public boolean d() {
            return this.f7031e;
        }

        public void e() {
            this.f7031e = true;
        }

        public String a() {
            return this.f7027a;
        }
    }
}
