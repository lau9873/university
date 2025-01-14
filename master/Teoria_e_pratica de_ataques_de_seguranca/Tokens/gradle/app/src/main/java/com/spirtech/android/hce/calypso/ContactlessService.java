package com.spirtech.android.hce.calypso;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import java.util.Arrays;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1373d;
import p070c.p115g.p116a.p117a.p118a.p119a.AbstractC1367b;
import p070c.p115g.p116a.p117a.p118a.p119a.EnumC1368c;
import p070c.p115g.p116a.p117a.p118a.p119a.InterfaceC1362a;
import p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b;
import p070c.p115g.p116a.p117a.p118a.p124e.C1409a;
import p070c.p115g.p128c.p129a.p130a.C1423a;
import p070c.p115g.p128c.p129a.p130a.C1425c;

@TargetApi(19)
/* loaded from: classes.dex */
public class ContactlessService extends HostApduService {

    /* renamed from: a */
    public InterfaceC1362a f6349a;

    /* renamed from: b */
    public AbstractAsyncTaskC1412b.InterfaceC1414b<JSONObject> f6350b = new C1474b(this);

    /* renamed from: c */
    public InterfaceC1362a.InterfaceC1363a f6351c = new C1475c();

    /* renamed from: com.spirtech.android.hce.calypso.ContactlessService$a */
    /* loaded from: classes.dex */
    public class AsyncTaskC1473a extends AbstractAsyncTaskC1412b<Integer, Integer, JSONObject> {

        /* renamed from: e */
        public final /* synthetic */ byte[] f6352e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AsyncTaskC1473a(AbstractAsyncTaskC1412b.InterfaceC1414b interfaceC1414b, long j, byte[] bArr) {
            super(interfaceC1414b, j);
            this.f6352e = bArr;
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b
        /* renamed from: a */
        public JSONObject mo4236b(Integer... numArr) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (this.f6352e != null) {
                    jSONObject2.put("AID", C1425c.m4469a(this.f6352e));
                }
                C1409a.m4551b(C1409a.m4552a(jSONObject2, 326, -2, 0, ContactlessService.this.getApplicationContext()), ContactlessService.this.getApplicationContext());
            } catch (Exception e) {
                C1423a.m4477a("performNoticiationContactlessInBackground", C1373d.class, e);
            }
            return jSONObject;
        }
    }

    /* renamed from: com.spirtech.android.hce.calypso.ContactlessService$b */
    /* loaded from: classes.dex */
    public class C1474b implements AbstractAsyncTaskC1412b.InterfaceC1414b<JSONObject> {
        public C1474b(ContactlessService contactlessService) {
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b.InterfaceC1414b
        /* renamed from: a */
        public void mo4234a(String str) {
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p124e.AbstractAsyncTaskC1412b.InterfaceC1414b
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public void mo4235a(JSONObject jSONObject, String str) {
        }
    }

    /* renamed from: com.spirtech.android.hce.calypso.ContactlessService$c */
    /* loaded from: classes.dex */
    public class C1475c implements InterfaceC1362a.InterfaceC1363a {
        public C1475c() {
        }

        @Override // p070c.p115g.p116a.p117a.p118a.p119a.InterfaceC1362a.InterfaceC1363a
        /* renamed from: a */
        public void mo4232a(byte[] bArr) {
            byte[] m4239a = ContactlessService.this.m4239a(bArr);
            ContactlessService contactlessService = ContactlessService.this;
            contactlessService.m4238a(m4239a, contactlessService.f6350b);
        }
    }

    static {
        Boolean.valueOf(false);
    }

    /* renamed from: a */
    public final void m4238a(byte[] bArr, AbstractAsyncTaskC1412b.InterfaceC1414b<JSONObject> interfaceC1414b) {
        new AsyncTaskC1473a(interfaceC1414b, 30000L, bArr).m4544a((Object[]) null);
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
        C1409a.m4555a(getApplicationContext(), C1409a.C1411b.m4550a(getApplicationContext()));
        this.f6349a = AbstractC1367b.m4641a(getApplicationContext(), EnumC1368c.VALIDATING_DEVICE_APDU, true);
        this.f6349a.mo4651a(this.f6351c);
    }

    @Override // android.nfc.cardemulation.HostApduService
    public void onDeactivated(int i) {
        try {
            if (i == 0) {
                this.f6349a.mo4652a();
            } else if (i != 1) {
            } else {
                this.f6349a.mo4649b();
            }
        } catch (Exception e) {
            C1423a.m4477a("onDeactivated", ContactlessService.class, e);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        C1409a.m4555a(getApplicationContext(), C1409a.C1411b.m4550a(getApplicationContext()));
        return 1;
    }

    @Override // android.nfc.cardemulation.HostApduService
    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        return this.f6349a.mo4643a(bArr);
    }
}
