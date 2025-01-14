package com.spirtech.android.hce.calypso;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import c.g.a.a.a.a.a;
import c.g.a.a.a.d;
import c.g.a.a.a.e.a;
import c.g.a.a.a.e.b;
import java.util.Arrays;
import org.json.JSONObject;
@TargetApi(19)
/* loaded from: classes.dex */
public class ContactlessService extends HostApduService {

    /* renamed from: a  reason: collision with root package name */
    public c.g.a.a.a.a.a f4170a;

    /* renamed from: b  reason: collision with root package name */
    public b.InterfaceC0079b<JSONObject> f4171b = new b(this);

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0072a f4172c = new c();

    /* loaded from: classes.dex */
    public class a extends c.g.a.a.a.e.b<Integer, Integer, JSONObject> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f4173e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b.InterfaceC0079b interfaceC0079b, long j, byte[] bArr) {
            super(interfaceC0079b, j);
            this.f4173e = bArr;
        }

        @Override // c.g.a.a.a.e.b
        /* renamed from: a */
        public JSONObject b(Integer... numArr) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (this.f4173e != null) {
                    jSONObject2.put("AID", c.g.c.a.a.c.a(this.f4173e));
                }
                c.g.a.a.a.e.a.b(c.g.a.a.a.e.a.a(jSONObject2, 326, -2, 0, ContactlessService.this.getApplicationContext()), ContactlessService.this.getApplicationContext());
            } catch (Exception e2) {
                c.g.c.a.a.a.a("performNoticiationContactlessInBackground", d.class, e2);
            }
            return jSONObject;
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.InterfaceC0079b<JSONObject> {
        public b(ContactlessService contactlessService) {
        }

        @Override // c.g.a.a.a.e.b.InterfaceC0079b
        public void a(String str) {
        }

        @Override // c.g.a.a.a.e.b.InterfaceC0079b
        public void a(JSONObject jSONObject, String str) {
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.InterfaceC0072a {
        public c() {
        }

        @Override // c.g.a.a.a.a.a.InterfaceC0072a
        public void a(byte[] bArr) {
            byte[] a2 = ContactlessService.this.a(bArr);
            ContactlessService contactlessService = ContactlessService.this;
            contactlessService.a(a2, contactlessService.f4171b);
        }
    }

    static {
        Boolean.valueOf(false);
    }

    public final void a(byte[] bArr, b.InterfaceC0079b<JSONObject> interfaceC0079b) {
        new a(interfaceC0079b, 30000L, bArr).a((Object[]) null);
    }

    public final byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOfRange(bArr, 5, Arrays.copyOfRange(bArr, 4, 5)[0] + 5);
    }

    @Override // android.app.Service
    public void onCreate() {
        c.g.a.a.a.e.a.a(getApplicationContext(), a.b.a(getApplicationContext()));
        this.f4170a = c.g.a.a.a.a.b.a(getApplicationContext(), c.g.a.a.a.a.c.VALIDATING_DEVICE_APDU, true);
        this.f4170a.a(this.f4172c);
    }

    @Override // android.nfc.cardemulation.HostApduService
    public void onDeactivated(int i2) {
        try {
            if (i2 == 0) {
                this.f4170a.a();
            } else if (i2 != 1) {
            } else {
                this.f4170a.b();
            }
        } catch (Exception e2) {
            c.g.c.a.a.a.a("onDeactivated", ContactlessService.class, e2);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        c.g.a.a.a.e.a.a(getApplicationContext(), a.b.a(getApplicationContext()));
        return 1;
    }

    @Override // android.nfc.cardemulation.HostApduService
    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        return this.f4170a.a(bArr);
    }
}
