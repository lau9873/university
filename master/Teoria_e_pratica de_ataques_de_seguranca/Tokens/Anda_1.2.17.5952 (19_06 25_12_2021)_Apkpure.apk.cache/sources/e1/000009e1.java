package com.spirtech.android.hce.calypso;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import java.util.Arrays;
import org.json.JSONObject;
import p215c.p112g.p113a.p114a.p115a.C2016d;
import p215c.p112g.p113a.p114a.p115a.p116a.AbstractC2005a;
import p215c.p112g.p113a.p114a.p115a.p116a.AbstractC2010b;
import p215c.p112g.p113a.p114a.p115a.p116a.EnumC2011c;
import p215c.p112g.p113a.p114a.p115a.p121e.AbstractAsyncTaskC2055b;
import p215c.p112g.p113a.p114a.p115a.p121e.C2052a;
import p215c.p112g.p125c.p126a.p127a.C2066a;
import p215c.p112g.p125c.p126a.p127a.C2068c;

@TargetApi(19)
/* loaded from: classes.dex */
public class ContactlessService extends HostApduService {

    /* renamed from: a */
    public AbstractC2005a f6347a;

    /* renamed from: b */
    public AbstractAsyncTaskC2055b.AbstractC2057b<JSONObject> f6348b = new C2118b(this);

    /* renamed from: c */
    public AbstractC2005a.AbstractC2006a f6349c = new C2119c();

    /* renamed from: com.spirtech.android.hce.calypso.ContactlessService$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC2117a extends AbstractAsyncTaskC2055b<Integer, Integer, JSONObject> {

        /* renamed from: e */
        public final /* synthetic */ byte[] f6350e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncTaskC2117a(AbstractAsyncTaskC2055b.AbstractC2057b abstractC2057b, long j, byte[] bArr) {
            super(abstractC2057b, j);
            this.f6350e = bArr;
        }

        @Override // p215c.p112g.p113a.p114a.p115a.p121e.AbstractAsyncTaskC2055b
        /* renamed from: a */
        public JSONObject mo4236b(Integer... numArr) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (this.f6350e != null) {
                    jSONObject2.put("AID", C2068c.m4469a(this.f6350e));
                }
                C2052a.m4551b(C2052a.m4552a(jSONObject2, 326, -2, 0, ContactlessService.this.getApplicationContext()), ContactlessService.this.getApplicationContext());
            } catch (Exception e) {
                C2066a.m4477a("performNoticiationContactlessInBackground", C2016d.class, e);
            }
            return jSONObject;
        }
    }

    /* renamed from: com.spirtech.android.hce.calypso.ContactlessService$b */
    /* loaded from: classes.dex */
    public class C2118b implements AbstractAsyncTaskC2055b.AbstractC2057b<JSONObject> {
        public C2118b(ContactlessService contactlessService) {
        }

        @Override // p215c.p112g.p113a.p114a.p115a.p121e.AbstractAsyncTaskC2055b.AbstractC2057b
        /* renamed from: a */
        public void mo4234a(String str) {
        }

        @Override // p215c.p112g.p113a.p114a.p115a.p121e.AbstractAsyncTaskC2055b.AbstractC2057b
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4235a(JSONObject jSONObject, String str) {
        }
    }

    /* renamed from: com.spirtech.android.hce.calypso.ContactlessService$c */
    /* loaded from: classes.dex */
    public class C2119c implements AbstractC2005a.AbstractC2006a {
        public C2119c() {
        }

        @Override // p215c.p112g.p113a.p114a.p115a.p116a.AbstractC2005a.AbstractC2006a
        /* renamed from: a */
        public void mo4232a(byte[] bArr) {
            byte[] m4239a = ContactlessService.this.m4239a(bArr);
            ContactlessService contactlessService = ContactlessService.this;
            contactlessService.m4238a(m4239a, contactlessService.f6348b);
        }
    }

    static {
        Boolean.valueOf(false);
    }

    /* renamed from: a */
    public final void m4238a(byte[] bArr, AbstractAsyncTaskC2055b.AbstractC2057b<JSONObject> abstractC2057b) {
        new AsyncTaskC2117a(abstractC2057b, 30000L, bArr).m4544a((Object[]) null);
    }

    /* renamed from: a */
    public final byte[] m4239a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOfRange(bArr, 5, Arrays.copyOfRange(bArr, 4, 5)[0] + 5);
    }

    @Override // android.app.Service
    public void onCreate() {
        C2052a.m4555a(getApplicationContext(), C2052a.C2054b.m4550a(getApplicationContext()));
        this.f6347a = AbstractC2010b.m4641a(getApplicationContext(), EnumC2011c.VALIDATING_DEVICE_APDU, true);
        this.f6347a.mo4651a(this.f6349c);
    }

    @Override // android.nfc.cardemulation.HostApduService
    public void onDeactivated(int i) {
        try {
            if (i == 0) {
                this.f6347a.mo4652a();
            } else if (i != 1) {
            } else {
                this.f6347a.mo4649b();
            }
        } catch (Exception e) {
            C2066a.m4477a("onDeactivated", ContactlessService.class, e);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        C2052a.m4555a(getApplicationContext(), C2052a.C2054b.m4550a(getApplicationContext()));
        return 1;
    }

    @Override // android.nfc.cardemulation.HostApduService
    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        return this.f6347a.mo4643a(bArr);
    }
}