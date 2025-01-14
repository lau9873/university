package h.a.a;

import android.os.Build;
import android.util.Base64;
import android.util.Log;
import e.j0.a;
import e.x;
import e.y;
import i.m;
import java.io.File;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import pt.card4b.backendbeacons.App;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModelDTOs$CustomerAccountDTO;
import pt.card4b.backendbeacons.DataModelDTOs$ErrorMessageDTO;
import pt.card4b.backendbeacons.DataModelDTOs$InvoiceDetailsDTO;
import pt.card4b.backendbeacons.DataModelDTOs$PaymentMethodDTO;
import pt.card4b.backendbeacons.DataModelDTOs$StageDetailsDTO;
import pt.card4b.backendbeacons.DataModelDTOs$StageInformationBeaconDTO;
import pt.card4b.backendbeacons.DataModelDTOs$StageTariffsDTO;
import pt.card4b.backendbeacons.DataModels;
import pt.card4b.backendbeacons.RequestDTOs$CustomerUpdatePwdRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$CustomerUpdateRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$DefaultRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$DeviceInstallRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$EventRegistRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$LoginRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$LogoutRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$OfflinePermitRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$PaymentMethodRegistRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$RegistrationNewRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$RegistrationResetRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$RenewRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$SessionRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$StageRequestDTO;
import pt.card4b.backendbeacons.ResponseDTOs$CustomerUpdatePwdResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$CustomerUpdateResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$DefaultResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$DeviceInstallResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$EventRegistResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$GetApplicationDataResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$GetCustomerAccountResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$GetInvoicesResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$LoginResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$OfflinePermitResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$PaymentMethodResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$RegistrationNewResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$RegistrationResetResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$RenewLoginResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$SessionResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$StageHistoryResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$StageResponseDTO;
import pt.card4b.backendbeacons.ResponseDTOs$StageTariffsResponseDTO;
import retrofit2.HttpException;
/* compiled from: BackendAPIController.java */
/* loaded from: classes.dex */
public class h {
    public static int j = 401;
    public static int k = 403;
    public static volatile h l;
    public static y.b m;

    /* renamed from: a  reason: collision with root package name */
    public m.b f6301a;

    /* renamed from: b  reason: collision with root package name */
    public h.a.a.i f6302b;

    /* renamed from: c  reason: collision with root package name */
    public String f6303c;

    /* renamed from: d  reason: collision with root package name */
    public String f6304d;

    /* renamed from: e  reason: collision with root package name */
    public long f6305e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f6306f;

    /* renamed from: g  reason: collision with root package name */
    public Object f6307g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public boolean f6308h;

    /* renamed from: i  reason: collision with root package name */
    public final k0 f6309i;

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class a implements d.c.e0.f<ResponseDTOs$StageHistoryResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6310a;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0130a extends c.d.b.w.a<ArrayList<DataModelDTOs$StageDetailsDTO>> {
            public C0130a(a aVar) {
            }
        }

        public a(BackendListeners.h hVar) {
            this.f6310a = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$StageHistoryResponseDTO responseDTOs$StageHistoryResponseDTO) {
            if (responseDTOs$StageHistoryResponseDTO.Success) {
                this.f6310a.a((List) new c.d.b.f().a(responseDTOs$StageHistoryResponseDTO.JSONStagesHistoricDetails, new C0130a(this).getType()));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$StageHistoryResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6310a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class a0 implements d.c.e0.f<ResponseDTOs$RenewLoginResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.a f6312a;

        public a0(BackendListeners.a aVar) {
            this.f6312a = aVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$RenewLoginResponseDTO responseDTOs$RenewLoginResponseDTO) {
            if (responseDTOs$RenewLoginResponseDTO.Success) {
                synchronized (h.this.f6307g) {
                    if (responseDTOs$RenewLoginResponseDTO.TokenDateMilliseconds >= h.this.f6305e) {
                        h.this.f6304d = responseDTOs$RenewLoginResponseDTO.Token;
                        h.this.f6305e = responseDTOs$RenewLoginResponseDTO.TokenDateMilliseconds;
                        h hVar = h.this;
                        hVar.a(hVar.f6304d);
                        h.a.a.l.k().b(h.this.f6304d);
                    }
                }
                this.f6312a.onSuccess();
            } else {
                DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$RenewLoginResponseDTO.ErrorMessage;
                DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
                h.this.c();
                this.f6312a.onError(error);
            }
            synchronized (h.this.f6307g) {
                h.this.f6308h = false;
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class b implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6314a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6315b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6316c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6317d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6318e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ List f6319f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f6320g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f6321h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6322i;
        public final /* synthetic */ BackendListeners.h j;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                b.this.j.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                b bVar = b.this;
                h.this.a(bVar.f6314a, bVar.f6315b, bVar.f6316c, bVar.f6317d, bVar.f6318e, bVar.f6319f, bVar.f6320g, bVar.f6321h, bVar.f6322i, bVar.j);
            }
        }

        public b(String str, String str2, String str3, String str4, String str5, List list, boolean z, int i2, String str6, BackendListeners.h hVar) {
            this.f6314a = str;
            this.f6315b = str2;
            this.f6316c = str3;
            this.f6317d = str4;
            this.f6318e = str5;
            this.f6319f = list;
            this.f6320g = z;
            this.f6321h = i2;
            this.f6322i = str6;
            this.j = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.j.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.j.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class b0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.e f6324a;

        public b0(BackendListeners.e eVar) {
            this.f6324a = eVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            th.printStackTrace();
            h.this.c();
            this.f6324a.onSuccess();
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class c implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6326a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6327b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6328c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6329d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6330e;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                c.this.f6330e.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                c cVar = c.this;
                h.this.a(cVar.f6326a, cVar.f6327b, cVar.f6328c, cVar.f6329d, cVar.f6330e);
            }
        }

        public c(String str, String str2, String str3, String str4, BackendListeners.h hVar) {
            this.f6326a = str;
            this.f6327b = str2;
            this.f6328c = str3;
            this.f6329d = str4;
            this.f6330e = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6330e.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6330e.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class c0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.a f6333a;

        public c0(BackendListeners.a aVar) {
            this.f6333a = aVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() == h.j || httpException.a() == h.k) {
                    h.this.c();
                }
            }
            th.printStackTrace();
            this.f6333a.onError(DataModels.Error.communication());
            synchronized (h.this.f6307g) {
                h.this.f6308h = false;
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class d implements d.c.e0.f<ResponseDTOs$OfflinePermitResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.g f6335a;

        public d(BackendListeners.g gVar) {
            this.f6335a = gVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$OfflinePermitResponseDTO responseDTOs$OfflinePermitResponseDTO) {
            StringBuilder sb = new StringBuilder();
            sb.append("Offline start Permit=");
            sb.append(responseDTOs$OfflinePermitResponseDTO.OfflinePermit ? "true" : "false");
            h.a.a.c.a("COMM_HTTP", "BackendAPIController", "offlineStartPermitCheck:onSuccess", sb.toString());
            if (responseDTOs$OfflinePermitResponseDTO.Success) {
                this.f6335a.a(responseDTOs$OfflinePermitResponseDTO.ServerDate, responseDTOs$OfflinePermitResponseDTO.OfflinePermit, responseDTOs$OfflinePermitResponseDTO.LastConfigChange, responseDTOs$OfflinePermitResponseDTO.LogoutNeeded, responseDTOs$OfflinePermitResponseDTO.DenyReason, responseDTOs$OfflinePermitResponseDTO.DenyReasonCode);
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$OfflinePermitResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6335a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class d0 implements d.c.e0.f<ResponseDTOs$RegistrationNewResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6337a;

        public d0(BackendListeners.h hVar) {
            this.f6337a = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$RegistrationNewResponseDTO responseDTOs$RegistrationNewResponseDTO) {
            if (responseDTOs$RegistrationNewResponseDTO.Success) {
                this.f6337a.a(responseDTOs$RegistrationNewResponseDTO.CustomerId);
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$RegistrationNewResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6337a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class e implements d.c.e0.f<ResponseDTOs$StageTariffsResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6339a;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$StageTariffsDTO>> {
            public a(e eVar) {
            }
        }

        public e(BackendListeners.h hVar) {
            this.f6339a = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$StageTariffsResponseDTO responseDTOs$StageTariffsResponseDTO) {
            if (responseDTOs$StageTariffsResponseDTO.Success) {
                this.f6339a.a((List) new c.d.b.f().a(responseDTOs$StageTariffsResponseDTO.JSONStageTariffDetails, new a(this).getType()));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$StageTariffsResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6339a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class e0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DataModelDTOs$CustomerAccountDTO f6341a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6342b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6343c;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                e0.this.f6343c.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                e0 e0Var = e0.this;
                h.this.a(e0Var.f6341a, e0Var.f6342b, e0Var.f6343c);
            }
        }

        public e0(DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO, String str, BackendListeners.h hVar) {
            this.f6341a = dataModelDTOs$CustomerAccountDTO;
            this.f6342b = str;
            this.f6343c = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6343c.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6343c.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class f implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6346a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6347b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6348c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.g f6349d;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                f.this.f6349d.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                f fVar = f.this;
                h.this.a(fVar.f6346a, fVar.f6347b, fVar.f6348c, fVar.f6349d);
            }
        }

        public f(String str, String str2, String str3, BackendListeners.g gVar) {
            this.f6346a = str;
            this.f6347b = str2;
            this.f6348c = str3;
            this.f6349d = gVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6349d.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6349d.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class f0 implements BackendListeners.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.a f6352a;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                f0.this.f6352a.onError(error);
                h.a.a.c.a("COMM_HTTP", "BackendAPIController", "renewBackendAuth:renewLogin:onError", error.getMessage());
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                f0.this.f6352a.onSuccess();
            }
        }

        public f0(BackendListeners.a aVar) {
            this.f6352a = aVar;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f6352a.onError(error);
            h.a.a.c.a("COMM_HTTP", "BackendAPIController", "renewBackendAuth:sessionStart:onError", error.getMessage());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.a
        public void onSuccess() {
            if (h.this.f6304d != null) {
                h.this.a(h.a.a.v.d().f(), new a());
                return;
            }
            this.f6352a.onSuccess();
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class g implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6355a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6356b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6357c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6358d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6359e;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                g.this.f6359e.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                g gVar = g.this;
                h.this.b(gVar.f6355a, gVar.f6356b, gVar.f6357c, gVar.f6358d, gVar.f6359e);
            }
        }

        public g(String str, String str2, String str3, String str4, BackendListeners.h hVar) {
            this.f6355a = str;
            this.f6356b = str2;
            this.f6357c = str3;
            this.f6358d = str4;
            this.f6359e = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6359e.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6359e.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class g0 implements d.c.e0.f<ResponseDTOs$GetApplicationDataResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6362a;

        public g0(BackendListeners.h hVar) {
            this.f6362a = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$GetApplicationDataResponseDTO responseDTOs$GetApplicationDataResponseDTO) {
            if (responseDTOs$GetApplicationDataResponseDTO.Success) {
                HashMap hashMap = new HashMap();
                hashMap.put("adjacentZones", responseDTOs$GetApplicationDataResponseDTO.JSONAdjacentZones);
                hashMap.put("beaconInformationTypes", responseDTOs$GetApplicationDataResponseDTO.JSONBeaconInformationType);
                hashMap.put("configurations", responseDTOs$GetApplicationDataResponseDTO.JSONConfigurations);
                hashMap.put("lineDirections", responseDTOs$GetApplicationDataResponseDTO.JSONLineDirections);
                hashMap.put("lineVariants", responseDTOs$GetApplicationDataResponseDTO.JSONLineVariants);
                hashMap.put("lines", responseDTOs$GetApplicationDataResponseDTO.JSONLines);
                hashMap.put("stops", responseDTOs$GetApplicationDataResponseDTO.JSONStops);
                hashMap.put("operators", responseDTOs$GetApplicationDataResponseDTO.JSONTransportOperatores);
                hashMap.put("zones", responseDTOs$GetApplicationDataResponseDTO.JSONZones);
                hashMap.put("customerProfiles", responseDTOs$GetApplicationDataResponseDTO.JSONSocialProfiles);
                hashMap.put("countries", responseDTOs$GetApplicationDataResponseDTO.JSONCountries);
                hashMap.put("languages", responseDTOs$GetApplicationDataResponseDTO.JSONLanguages);
                this.f6362a.a(hashMap);
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$GetApplicationDataResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6362a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0131h implements d.c.e0.f<e.e0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.q f6364a;

        public C0131h(h hVar, BackendListeners.q qVar) {
            this.f6364a = qVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(e.e0 e0Var) {
            h.a.a.c.a("COMM_HTTP", "BackendAPIController", "uploadFile", "send file OK");
            BackendListeners.q qVar = this.f6364a;
            if (qVar != null) {
                qVar.onSuccess();
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class h0 implements d.c.e0.f<ResponseDTOs$RegistrationResetResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.j f6365a;

        public h0(BackendListeners.j jVar) {
            this.f6365a = jVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$RegistrationResetResponseDTO responseDTOs$RegistrationResetResponseDTO) {
            if (responseDTOs$RegistrationResetResponseDTO.Success) {
                this.f6365a.onSuccess();
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$RegistrationResetResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6365a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class i implements d.c.e0.f<ResponseDTOs$GetInvoicesResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6367a;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$InvoiceDetailsDTO>> {
            public a(i iVar) {
            }
        }

        public i(BackendListeners.h hVar) {
            this.f6367a = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$GetInvoicesResponseDTO responseDTOs$GetInvoicesResponseDTO) {
            if (responseDTOs$GetInvoicesResponseDTO.Success) {
                c.d.b.g gVar = new c.d.b.g();
                gVar.a(Date.class, h.this.f6309i);
                gVar.a(h.this.f6309i.a());
                this.f6367a.a((List) gVar.a().a(responseDTOs$GetInvoicesResponseDTO.JSONInvoiceDetails, new a(this).getType()));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$GetInvoicesResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6367a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class i0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6369a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.j f6370b;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                i0.this.f6370b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                i0 i0Var = i0.this;
                h.this.a(i0Var.f6369a, i0Var.f6370b);
            }
        }

        public i0(String str, BackendListeners.j jVar) {
            this.f6369a = str;
            this.f6370b = jVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6370b.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6370b.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class j implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6373a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6374b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ File f6375c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.q f6376d;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                j.this.f6376d.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                j jVar = j.this;
                h.this.a(jVar.f6373a, jVar.f6374b, jVar.f6375c, jVar.f6376d);
            }
        }

        public j(String str, String str2, File file, BackendListeners.q qVar) {
            this.f6373a = str;
            this.f6374b = str2;
            this.f6375c = file;
            this.f6376d = qVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6376d.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6376d.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class j0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6379a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6380b;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                j0.this.f6380b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                j0 j0Var = j0.this;
                h.this.a(j0Var.f6379a, j0Var.f6380b);
            }
        }

        public j0(String str, BackendListeners.h hVar) {
            this.f6379a = str;
            this.f6380b = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6380b.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6380b.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class k implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6383a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6384b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6385c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6386d;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                k.this.f6386d.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                k kVar = k.this;
                h.this.a(kVar.f6383a, kVar.f6384b, kVar.f6385c, kVar.f6386d);
            }
        }

        public k(String str, String str2, String str3, BackendListeners.h hVar) {
            this.f6383a = str;
            this.f6384b = str2;
            this.f6385c = str3;
            this.f6386d = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6386d.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6386d.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class k0 implements c.d.b.k<Date> {

        /* renamed from: a  reason: collision with root package name */
        public String f6389a;

        public k0(h hVar, String str) {
            this.f6389a = str;
        }

        public String a() {
            return this.f6389a;
        }

        @Override // c.d.b.k
        /* renamed from: a */
        public Date deserialize(c.d.b.l lVar, Type type, c.d.b.j jVar) {
            String p;
            if (lVar != null && (p = lVar.p()) != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f6389a);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Lisbon"));
                try {
                    return simpleDateFormat.parse(p);
                } catch (ParseException e2) {
                    h.a.a.c.a("LIB", "JsonDateDeserializer", "DateDeserializer", "Exception: " + e2.toString());
                }
            }
            return null;
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class l implements d.c.e0.f<ResponseDTOs$GetCustomerAccountResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6390a;

        public l(BackendListeners.h hVar) {
            this.f6390a = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$GetCustomerAccountResponseDTO responseDTOs$GetCustomerAccountResponseDTO) {
            if (responseDTOs$GetCustomerAccountResponseDTO.Success) {
                c.d.b.g gVar = new c.d.b.g();
                gVar.a(Date.class, h.this.f6309i);
                gVar.a(h.this.f6309i.a());
                this.f6390a.a((DataModelDTOs$CustomerAccountDTO) gVar.a().a(responseDTOs$GetCustomerAccountResponseDTO.JSONCustomerAccount, (Class<Object>) DataModelDTOs$CustomerAccountDTO.class));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$GetCustomerAccountResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6390a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class l0 implements d.c.e0.f<ResponseDTOs$CustomerUpdateResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6392a;

        public l0(BackendListeners.h hVar) {
            this.f6392a = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$CustomerUpdateResponseDTO responseDTOs$CustomerUpdateResponseDTO) {
            if (responseDTOs$CustomerUpdateResponseDTO.Success) {
                String str = responseDTOs$CustomerUpdateResponseDTO.Token;
                if (str != null && !str.equals("")) {
                    synchronized (h.this.f6307g) {
                        if (responseDTOs$CustomerUpdateResponseDTO.TokenDateMilliseconds >= h.this.f6305e) {
                            h.this.f6304d = responseDTOs$CustomerUpdateResponseDTO.Token;
                            h.this.f6305e = responseDTOs$CustomerUpdateResponseDTO.TokenDateMilliseconds;
                            h hVar = h.this;
                            hVar.a(hVar.f6304d);
                            h.a.a.l.k().b(h.this.f6304d);
                        }
                    }
                }
                this.f6392a.a(Boolean.valueOf(responseDTOs$CustomerUpdateResponseDTO.ConfirmationNeeded));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$CustomerUpdateResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6392a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class m implements d.c.e0.f<ResponseDTOs$PaymentMethodResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6394a;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$PaymentMethodDTO>> {
            public a(m mVar) {
            }
        }

        public m(BackendListeners.h hVar) {
            this.f6394a = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$PaymentMethodResponseDTO responseDTOs$PaymentMethodResponseDTO) {
            if (responseDTOs$PaymentMethodResponseDTO.Success) {
                this.f6394a.a((List) new c.d.b.f().a(responseDTOs$PaymentMethodResponseDTO.JSONPaymentGateways, new a(this).getType()));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$PaymentMethodResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6394a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class m0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6396a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DataModelDTOs$CustomerAccountDTO f6397b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6398c;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                m0.this.f6398c.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                m0 m0Var = m0.this;
                h.this.a(m0Var.f6396a, m0Var.f6397b, m0Var.f6398c);
            }
        }

        public m0(String str, DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO, BackendListeners.h hVar) {
            this.f6396a = str;
            this.f6397b = dataModelDTOs$CustomerAccountDTO;
            this.f6398c = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6398c.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6398c.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class n implements d.c.e0.f<ResponseDTOs$SessionResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.a f6401a;

        public n(BackendListeners.a aVar) {
            this.f6401a = aVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$SessionResponseDTO responseDTOs$SessionResponseDTO) {
            if (responseDTOs$SessionResponseDTO.Success) {
                h.this.f6303c = responseDTOs$SessionResponseDTO.Token;
                h hVar = h.this;
                hVar.a(hVar.f6303c);
                this.f6401a.onSuccess();
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$SessionResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6401a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class n0 implements d.c.e0.f<ResponseDTOs$CustomerUpdatePwdResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.DefaultRequestListener f6403a;

        public n0(BackendListeners.DefaultRequestListener defaultRequestListener) {
            this.f6403a = defaultRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$CustomerUpdatePwdResponseDTO responseDTOs$CustomerUpdatePwdResponseDTO) {
            if (responseDTOs$CustomerUpdatePwdResponseDTO.Success) {
                String str = responseDTOs$CustomerUpdatePwdResponseDTO.Token;
                if (str != null && !str.equals("")) {
                    synchronized (h.this.f6307g) {
                        if (responseDTOs$CustomerUpdatePwdResponseDTO.TokenDateMilliseconds >= h.this.f6305e) {
                            h.this.f6304d = responseDTOs$CustomerUpdatePwdResponseDTO.Token;
                            h.this.f6305e = responseDTOs$CustomerUpdatePwdResponseDTO.TokenDateMilliseconds;
                            h hVar = h.this;
                            hVar.a(hVar.f6304d);
                            h.a.a.l.k().b(h.this.f6304d);
                        }
                    }
                }
                this.f6403a.onSuccess();
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$CustomerUpdatePwdResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6403a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class o implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6405a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6406b;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                o.this.f6406b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                o oVar = o.this;
                h.this.c(oVar.f6405a, oVar.f6406b);
            }
        }

        public o(String str, BackendListeners.h hVar) {
            this.f6405a = str;
            this.f6406b = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6406b.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6406b.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class o0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6409a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6410b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6411c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.DefaultRequestListener f6412d;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                o0.this.f6412d.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                o0 o0Var = o0.this;
                h.this.a(o0Var.f6409a, o0Var.f6410b, o0Var.f6411c, o0Var.f6412d);
            }
        }

        public o0(String str, String str2, String str3, BackendListeners.DefaultRequestListener defaultRequestListener) {
            this.f6409a = str;
            this.f6410b = str2;
            this.f6411c = str3;
            this.f6412d = defaultRequestListener;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6412d.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6412d.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class p implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6415a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6416b;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                p.this.f6416b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                p pVar = p.this;
                h.this.b(pVar.f6415a, pVar.f6416b);
            }
        }

        public p(String str, BackendListeners.h hVar) {
            this.f6415a = str;
            this.f6416b = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6416b.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6416b.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class p0 implements d.c.e0.f<ResponseDTOs$DeviceInstallResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6419a;

        public p0(BackendListeners.h hVar) {
            this.f6419a = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$DeviceInstallResponseDTO responseDTOs$DeviceInstallResponseDTO) {
            if (responseDTOs$DeviceInstallResponseDTO.Success) {
                this.f6419a.a(responseDTOs$DeviceInstallResponseDTO);
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$DeviceInstallResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6419a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class q implements d.c.e0.f<ResponseDTOs$DefaultResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.l f6421a;

        public q(BackendListeners.l lVar) {
            this.f6421a = lVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$DefaultResponseDTO responseDTOs$DefaultResponseDTO) {
            if (responseDTOs$DefaultResponseDTO.Success) {
                this.f6421a.onSuccess();
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$DefaultResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6421a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class q0 implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6423a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6424b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6425c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6426d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6427e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6428f;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                q0.this.f6428f.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                q0 q0Var = q0.this;
                h.this.a(q0Var.f6423a, q0Var.f6424b, q0Var.f6425c, q0Var.f6426d, q0Var.f6427e, q0Var.f6428f);
            }
        }

        public q0(String str, String str2, String str3, String str4, String str5, BackendListeners.h hVar) {
            this.f6423a = str;
            this.f6424b = str2;
            this.f6425c = str3;
            this.f6426d = str4;
            this.f6427e = str5;
            this.f6428f = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6428f.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6428f.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class r implements d.c.e0.f<ResponseDTOs$LoginResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.d f6431a;

        public r(BackendListeners.d dVar) {
            this.f6431a = dVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$LoginResponseDTO responseDTOs$LoginResponseDTO) {
            if (responseDTOs$LoginResponseDTO.Success) {
                c.d.b.g gVar = new c.d.b.g();
                gVar.a(Date.class, h.this.f6309i);
                gVar.a(h.this.f6309i.a());
                DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO = (DataModelDTOs$CustomerAccountDTO) gVar.a().a(responseDTOs$LoginResponseDTO.JSONCustomerAccount, (Class<Object>) DataModelDTOs$CustomerAccountDTO.class);
                synchronized (h.this.f6307g) {
                    if (responseDTOs$LoginResponseDTO.TokenDateMilliseconds >= h.this.f6305e) {
                        h.this.f6304d = responseDTOs$LoginResponseDTO.Token;
                        h.this.f6305e = responseDTOs$LoginResponseDTO.TokenDateMilliseconds;
                        h hVar = h.this;
                        hVar.a(hVar.f6304d);
                        h.a.a.l.k().b(h.this.f6304d);
                    }
                }
                this.f6431a.a(dataModelDTOs$CustomerAccountDTO);
            } else {
                DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$LoginResponseDTO.ErrorMessage;
                DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
                if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                    h.this.c();
                }
                this.f6431a.onError(error);
            }
            synchronized (h.this.f6307g) {
                h.this.f6308h = false;
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class r0 extends c.d.b.w.a<ArrayList<DataModelDTOs$StageInformationBeaconDTO>> {
        public r0(h hVar) {
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class s implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6434b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6435c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f6436d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6437e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.d f6438f;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                s.this.f6438f.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                s sVar = s.this;
                h.this.a(sVar.f6433a, sVar.f6434b, sVar.f6435c, sVar.f6436d, sVar.f6437e, sVar.f6438f);
            }
        }

        public s(String str, String str2, String str3, String str4, boolean z, BackendListeners.d dVar) {
            this.f6433a = str;
            this.f6434b = str2;
            this.f6435c = str3;
            this.f6436d = str4;
            this.f6437e = z;
            this.f6438f = dVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6438f.onError(DataModels.Error.communication());
                } else {
                    h.this.a(new a());
                    return;
                }
            } else {
                th.printStackTrace();
                this.f6438f.onError(DataModels.Error.communication());
            }
            synchronized (h.this.f6307g) {
                h.this.f6308h = false;
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class s0 implements d.c.e0.f<ResponseDTOs$StageResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.h f6441a;

        public s0(BackendListeners.h hVar) {
            this.f6441a = hVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$StageResponseDTO responseDTOs$StageResponseDTO) {
            h.a.a.c.a("COMM_HTTP", "BackendAPIController", "postStageStart:onSuccess", "Received new stage id = " + responseDTOs$StageResponseDTO.StageId);
            if (responseDTOs$StageResponseDTO.Success) {
                this.f6441a.a(responseDTOs$StageResponseDTO.StageId);
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$StageResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6441a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class t implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6443a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6444b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.l f6445c;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                t.this.f6445c.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                t tVar = t.this;
                h.this.a(tVar.f6443a, tVar.f6444b, tVar.f6445c);
            }
        }

        public t(String str, String str2, BackendListeners.l lVar) {
            this.f6443a = str;
            this.f6444b = str2;
            this.f6445c = lVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6445c.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6445c.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class u implements d.c.e0.f<ResponseDTOs$DefaultResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.m f6448a;

        public u(BackendListeners.m mVar) {
            this.f6448a = mVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$DefaultResponseDTO responseDTOs$DefaultResponseDTO) {
            if (responseDTOs$DefaultResponseDTO.Success) {
                this.f6448a.onSuccess();
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$DefaultResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                h.this.c();
            }
            this.f6448a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class v implements BackendListeners.a {
        public v(h hVar) {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.a
        public void onSuccess() {
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public boolean f6450a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6451b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6452c = false;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements d.c.e0.f<ResponseDTOs$StageResponseDTO> {
            public a() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(ResponseDTOs$StageResponseDTO responseDTOs$StageResponseDTO) {
                if (responseDTOs$StageResponseDTO.Success) {
                    w.this.f6451b = true;
                    return;
                }
                DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$StageResponseDTO.ErrorMessage;
                if ((dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal()).getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                    h.this.c();
                }
                w.this.f6450a = true;
                w.this.f6451b = true;
            }
        }

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class b implements d.c.e0.f<Throwable> {

            /* compiled from: BackendAPIController.java */
            /* loaded from: classes.dex */
            public class a implements BackendListeners.a {
                public a() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    w.this.f6452c = false;
                    h.a.a.c.a("COMM_HTTP", "BackendAPIController", "pendingStageRequests:sessionStart:onError", error.getMessage());
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.a
                public void onSuccess() {
                    w.this.f6452c = false;
                }
            }

            public b() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                th.printStackTrace();
                if (th instanceof HttpException) {
                    HttpException httpException = (HttpException) th;
                    if ((httpException.a() == h.j || httpException.a() == h.k) && !w.this.f6452c) {
                        w.this.f6452c = true;
                        h.this.a(new a());
                    }
                }
                w.this.f6450a = true;
                w.this.f6451b = true;
            }
        }

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class c implements d.c.e0.f<ResponseDTOs$EventRegistResponseDTO> {
            public c() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(ResponseDTOs$EventRegistResponseDTO responseDTOs$EventRegistResponseDTO) {
                if (responseDTOs$EventRegistResponseDTO.Success) {
                    w.this.f6451b = true;
                    return;
                }
                DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$EventRegistResponseDTO.ErrorMessage;
                if ((dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal()).getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                    h.this.c();
                }
                w.this.f6450a = true;
                w.this.f6451b = true;
            }
        }

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class d implements d.c.e0.f<Throwable> {

            /* compiled from: BackendAPIController.java */
            /* loaded from: classes.dex */
            public class a implements BackendListeners.a {
                public a() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    w.this.f6452c = false;
                    h.a.a.c.a("COMM_HTTP", "BackendAPIController", "pendingStageRequests:sessionStart:onError", error.getMessage());
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.a
                public void onSuccess() {
                    w.this.f6452c = false;
                }
            }

            public d() {
            }

            @Override // d.c.e0.f
            /* renamed from: a */
            public void accept(Throwable th) {
                th.printStackTrace();
                if (th instanceof HttpException) {
                    HttpException httpException = (HttpException) th;
                    if ((httpException.a() == h.j || httpException.a() == h.k) && !w.this.f6452c) {
                        w.this.f6452c = true;
                        h.this.a(new a());
                    }
                }
                w.this.f6450a = true;
                w.this.f6451b = true;
            }
        }

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class e implements BackendListeners.q {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File f6460a;

            public e(File file) {
                this.f6460a = file;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                w.this.f6451b = true;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.q
            public void onSuccess() {
                w.this.f6451b = true;
                this.f6460a.delete();
            }
        }

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class f implements BackendListeners.q {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File f6462a;

            public f(File file) {
                this.f6462a = file;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                w.this.f6451b = true;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.q
            public void onSuccess() {
                w.this.f6451b = true;
                this.f6462a.delete();
            }
        }

        public w() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v9, types: [pt.card4b.backendbeacons.RequestDTOs$EventRegistRequestDTO] */
        @Override // java.lang.Runnable
        public void run() {
            File h2;
            while (true) {
                try {
                    Thread.sleep(1000L);
                    try {
                    } catch (Throwable th) {
                        this.f6451b = true;
                        h.a.a.c.a("COMM_HTTP", "BackendAPIController", "Exception on sending data runnable", Log.getStackTraceString(th));
                    }
                    if (h.a.a.p.i()) {
                        DataModels.o i2 = h.a.a.v.d().i();
                        if (i2 != null && h.this.f6304d != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Sending ");
                            sb.append(i2.i() == DataModels.o.D ? "a start" : i2.i() == DataModels.o.F ? "a finish" : "an update");
                            sb.append(" stage request for StageId=");
                            sb.append(i2.h());
                            sb.append("...");
                            h.a.a.c.a("COMM_HTTP", "BackendAPIController", "SendDataThread", sb.toString());
                            this.f6451b = false;
                            this.f6450a = false;
                            RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO = new RequestDTOs$StageRequestDTO(i2, "App Anda", "NONE", "NONE", h.a.a.p.c());
                            (i2.i() == DataModels.o.D ? h.this.f6302b.b(requestDTOs$StageRequestDTO) : i2.i() == DataModels.o.F ? h.this.f6302b.c(requestDTOs$StageRequestDTO) : h.this.f6302b.a(requestDTOs$StageRequestDTO)).a(d.c.j0.a.b()).a(new a(), new b());
                            while (!this.f6451b) {
                                try {
                                    Thread.sleep(500L);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (!this.f6450a) {
                                h.a.a.v.d().A();
                            }
                        } else {
                            DataModels.h b2 = h.a.a.v.d().b();
                            if (b2 != null) {
                                h.a.a.c.a("COMM_HTTP", "BackendAPIController", "SendDataThread", "Sending event of type " + b2.b());
                                this.f6451b = false;
                                this.f6450a = false;
                                final String a2 = b2.a();
                                final String e3 = b2.e();
                                final Boolean g2 = b2.g();
                                final String b3 = b2.f() != null ? h.a.a.p.b(b2.f()) : null;
                                final String b4 = b2.b();
                                final String d2 = b2.d();
                                final String b5 = b2.h() != null ? h.a.a.p.b(b2.h()) : null;
                                final String c2 = b2.c();
                                final String c3 = h.a.a.p.c();
                                h.this.f6302b.a((RequestDTOs$EventRegistRequestDTO) new RequestDTOs$DefaultRequestDTO(a2, e3, g2, b3, b4, d2, b5, c2, "App Anda", "NONE", "NONE", c3) { // from class: pt.card4b.backendbeacons.RequestDTOs$EventRegistRequestDTO
                                    public String CustomerId;
                                    public String DeviceStartDate;
                                    public String EventDateTime;
                                    public String EventDescription;
                                    public String EventReportPath;
                                    public String EventTypeCode;
                                    public String StageInfoId;
                                    public Boolean StartOffline;

                                    {
                                        super(r9, r10, r11, c3);
                                        this.CustomerId = a2;
                                        this.StageInfoId = e3;
                                        this.StartOffline = g2;
                                        this.DeviceStartDate = b3;
                                        this.EventTypeCode = b4;
                                        this.EventDescription = d2;
                                        this.EventDateTime = b5;
                                        this.EventReportPath = c2;
                                    }
                                }).a(d.c.j0.a.b()).a(new c(), new d());
                                while (!this.f6451b) {
                                    try {
                                        Thread.sleep(500L);
                                    } catch (InterruptedException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (!this.f6450a) {
                                    h.a.a.v.d().z();
                                }
                            }
                            File g3 = h.a.a.c.g();
                            if (g3 != null) {
                                h.a.a.c.a("COMM_HTTP", "BackendAPIController", "SendDataThread", "Sending report file");
                                this.f6451b = false;
                                this.f6450a = false;
                                h.this.a("Reports", (String) null, g3, new e(g3));
                                while (!this.f6451b) {
                                    try {
                                        Thread.sleep(500L);
                                    } catch (InterruptedException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                            }
                            if (h.a.a.p.j() && (h2 = h.a.a.c.h()) != null) {
                                h.a.a.c.a("COMM_HTTP", "BackendAPIController", "SendDataThread", "Sending trip log file");
                                this.f6451b = false;
                                this.f6450a = false;
                                h.this.a("Trips", h.a.a.l.k().e() != null ? h.a.a.l.k().e().getId() : null, h2, new f(h2));
                                while (!this.f6451b) {
                                    try {
                                        Thread.sleep(500L);
                                    } catch (InterruptedException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                        }
                        this.f6451b = true;
                        h.a.a.c.a("COMM_HTTP", "BackendAPIController", "Exception on sending data runnable", Log.getStackTraceString(th));
                    }
                } catch (InterruptedException e7) {
                    e7.printStackTrace();
                    return;
                }
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class x implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6464a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6465b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.m f6466c;

        /* compiled from: BackendAPIController.java */
        /* loaded from: classes.dex */
        public class a implements BackendListeners.a {
            public a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                x.this.f6466c.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.a
            public void onSuccess() {
                x xVar = x.this;
                h.this.a(xVar.f6464a, xVar.f6465b, xVar.f6466c);
            }
        }

        public x(String str, String str2, BackendListeners.m mVar) {
            this.f6464a = str;
            this.f6465b = str2;
            this.f6466c = mVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.a() != h.j && httpException.a() != h.k) {
                    th.printStackTrace();
                    this.f6466c.onError(DataModels.Error.communication());
                    return;
                }
                h.this.a(new a());
                return;
            }
            th.printStackTrace();
            this.f6466c.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class y implements d.c.e0.f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.a f6469a;

        public y(h hVar, BackendListeners.a aVar) {
            this.f6469a = aVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(Throwable th) {
            th.printStackTrace();
            this.f6469a.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* loaded from: classes.dex */
    public class z implements d.c.e0.f<ResponseDTOs$DefaultResponseDTO> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendListeners.e f6470a;

        public z(BackendListeners.e eVar) {
            this.f6470a = eVar;
        }

        @Override // d.c.e0.f
        /* renamed from: a */
        public void accept(ResponseDTOs$DefaultResponseDTO responseDTOs$DefaultResponseDTO) {
            h.this.c();
            this.f6470a.onSuccess();
        }
    }

    static {
        y.b bVar = new y.b();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        bVar.a(15L, timeUnit);
        bVar.b(15L, timeUnit);
        bVar.c(15L, timeUnit);
        e.j0.a aVar = new e.j0.a();
        aVar.a(a.EnumC0119a.BODY);
        bVar.a(aVar);
        m = bVar;
    }

    public h() {
        k0 k0Var = new k0(this, "yyyy-MM-dd'T'HH:mm:ss");
        this.f6309i = k0Var;
        if (l == null) {
            this.f6306f = App.getServerInfo();
            c.d.b.g gVar = new c.d.b.g();
            gVar.a(Date.class, k0Var);
            gVar.a(k0Var.a());
            c.d.b.f a2 = gVar.a();
            m.b bVar = new m.b();
            bVar.a(this.f6306f[0]);
            bVar.a(i.q.a.a.a(a2));
            bVar.a(i.p.a.g.a());
            this.f6301a = bVar;
            bVar.a(m.a());
            this.f6302b = (h.a.a.i) this.f6301a.a().a(h.a.a.i.class);
            String j2 = h.a.a.v.d().j();
            if (j2 != null) {
                a(j2, 0L);
            } else {
                b(new v(this));
            }
            new Thread(new w()).start();
            return;
        }
        throw new RuntimeException("BackendAPIController: Use getInstance() method to get the single instance of this class.");
    }

    public static h d() {
        if (l == null) {
            synchronized (h.class) {
                if (l == null) {
                    l = new h();
                }
            }
        }
        return l;
    }

    public void c(String str, BackendListeners.h<List<DataModelDTOs$PaymentMethodDTO>> hVar) {
        if (this.f6304d == null) {
            hVar.onError(DataModels.Error.loginRequired());
            return;
        }
        this.f6302b.c("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(h.a.a.p.c().getBytes(), 2)).a(d.c.j0.a.b()).a(new m(hVar), new o(str, hVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [pt.card4b.backendbeacons.RequestDTOs$SessionRequestDTO] */
    private void b(BackendListeners.a aVar) {
        String[] strArr = this.f6306f;
        m.a(new h.a.a.d(e.n.a(strArr[1], strArr[2])));
        this.f6301a.a(m.a());
        this.f6302b = (h.a.a.i) this.f6301a.a().a(h.a.a.i.class);
        final String b2 = h.a.a.p.b(h.a.a.w.d().e());
        final String c2 = h.a.a.p.c();
        this.f6302b.a((RequestDTOs$SessionRequestDTO) new RequestDTOs$DefaultRequestDTO(b2, "App Anda", "NONE", "NONE", c2) { // from class: pt.card4b.backendbeacons.RequestDTOs$SessionRequestDTO
            public String DateTimeRequest;

            {
                super(r2, r3, r4, c2);
                this.DateTimeRequest = b2;
            }
        }).a(d.c.j0.a.b()).a(new n(aVar), new y(this, aVar));
    }

    public void a(String str, long j2) {
        synchronized (this.f6307g) {
            this.f6304d = str;
            this.f6305e = j2;
            a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str = this.f6304d;
        if (str == null || str.equals("")) {
            return;
        }
        synchronized (this.f6307g) {
            this.f6304d = null;
            this.f6305e = 0L;
            a(this.f6303c);
            h.a.a.l.k().b((String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (str != null && !str.equals("")) {
            m.a(new h.a.a.d("Bearer " + str));
        }
        this.f6301a.a(m.a());
        this.f6302b = (h.a.a.i) this.f6301a.a().a(h.a.a.i.class);
    }

    public void b(String str, String str2, String str3, String str4, BackendListeners.h hVar) {
        if (this.f6304d == null) {
            hVar.onError(DataModels.Error.loginRequired());
            return;
        }
        this.f6302b.a("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(str2.getBytes(), 2), Base64.encodeToString(str3.getBytes(), 2), Base64.encodeToString(str4.getBytes(), 2), Base64.encodeToString(h.a.a.p.c().getBytes(), 2)).a(d.c.j0.a.b()).a(new e(hVar), new g(str, str2, str3, str4, hVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [pt.card4b.backendbeacons.RequestDTOs$RenewRequestDTO] */
    public void a(final String str, BackendListeners.a aVar) {
        final String c2 = h.a.a.p.c();
        ?? r6 = new RequestDTOs$DefaultRequestDTO(str, "App Anda", "NONE", "NONE", c2) { // from class: pt.card4b.backendbeacons.RequestDTOs$RenewRequestDTO
            public String Email;

            {
                super(r2, r3, r4, c2);
                this.Email = str;
            }
        };
        if (this.f6304d == null) {
            aVar.onError(DataModels.Error.loginRequired());
            return;
        }
        synchronized (this.f6307g) {
            if (this.f6308h) {
                aVar.onError(DataModels.Error.communication());
                return;
            }
            this.f6308h = true;
            a(this.f6304d);
            this.f6302b.a((RequestDTOs$RenewRequestDTO) r6).a(d.c.j0.a.b()).a(new a0(aVar), new c0(aVar));
        }
    }

    public void b(String str, BackendListeners.h<DataModelDTOs$CustomerAccountDTO> hVar) {
        try {
            if (this.f6304d == null) {
                hVar.onError(DataModels.Error.loginRequired());
                return;
            }
            this.f6302b.a("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(h.a.a.p.c().getBytes(), 2)).a(d.c.j0.a.b()).a(new l(hVar), new p(str, hVar));
        } catch (Throwable th) {
            h.a.a.c.a("COMM_HTTP", "BackendAPIController", "getCustomerAccount", "Exception: " + Log.getStackTraceString(th));
            if (hVar != null) {
                hVar.onError(h.a.a.p.a(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackendListeners.a aVar) {
        h.a.a.v.d().f();
        b(new f0(aVar));
    }

    public void a(String str, BackendListeners.h<Map<String, String>> hVar) {
        this.f6302b.b("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(h.a.a.p.c().getBytes(), 2)).a(d.c.j0.a.b()).a(new g0(hVar), new j0(str, hVar));
    }

    public void a(String str, String str2, String str3, String str4, BackendListeners.h<List<DataModelDTOs$StageDetailsDTO>> hVar) {
        if (this.f6304d == null) {
            hVar.onError(DataModels.Error.loginRequired());
            return;
        }
        this.f6302b.b("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(str2.getBytes(), 2), Base64.encodeToString(str3.getBytes(), 2), Base64.encodeToString(str4.getBytes(), 2), Base64.encodeToString(h.a.a.p.c().getBytes(), 2)).a(d.c.j0.a.b()).a(new a(hVar), new c(str, str2, str3, str4, hVar));
    }

    public void a(String str, String str2, String str3, BackendListeners.h hVar) {
        if (this.f6304d == null) {
            hVar.onError(DataModels.Error.loginRequired());
            return;
        }
        this.f6302b.a("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(str2.getBytes(), 2), Base64.encodeToString(str3.getBytes(), 2), Base64.encodeToString(h.a.a.p.c().getBytes(), 2)).a(d.c.j0.a.b()).a(new i(hVar), new k(str, str2, str3, hVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [pt.card4b.backendbeacons.RequestDTOs$LoginRequestDTO] */
    public void a(final String str, final String str2, final String str3, final String str4, final boolean z2, BackendListeners.d dVar) {
        final String c2 = h.a.a.p.c();
        ?? r1 = new RequestDTOs$DefaultRequestDTO(str, str2, str3, str4, "App Anda", "NONE", "NONE", c2, z2) { // from class: pt.card4b.backendbeacons.RequestDTOs$LoginRequestDTO
            public String DeviceBrand;
            public String DeviceInternalId;
            public String DeviceManufacturer;
            public String DeviceModel;
            public String Email;
            public boolean HasDataDownloaded;
            public String IMEI;
            public String OperatingSystem;
            public String OperatingSystemVersion;
            public String Password;

            {
                super(r5, r6, r7, c2);
                this.Email = str;
                this.Password = str2;
                this.DeviceInternalId = str3;
                this.DeviceManufacturer = Build.MANUFACTURER;
                this.DeviceBrand = Build.BRAND;
                this.DeviceModel = Build.MODEL;
                this.OperatingSystem = "Android";
                this.OperatingSystemVersion = String.format("%s %s %s", Build.VERSION.RELEASE, Build.VERSION.CODENAME, Build.VERSION.INCREMENTAL);
                this.IMEI = str4;
                this.HasDataDownloaded = z2;
            }
        };
        synchronized (this.f6307g) {
            if (this.f6308h) {
                dVar.onError(DataModels.Error.communication());
                return;
            }
            this.f6308h = true;
            this.f6302b.a((RequestDTOs$LoginRequestDTO) r1).a(d.c.j0.a.b()).a(new r(dVar), new s(str, str2, str3, str4, z2, dVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [pt.card4b.backendbeacons.RequestDTOs$LogoutRequestDTO] */
    public void a(final String str, BackendListeners.e eVar) {
        final String c2 = h.a.a.p.c();
        this.f6302b.a((RequestDTOs$LogoutRequestDTO) new RequestDTOs$DefaultRequestDTO(str, "App Anda", "NONE", "NONE", c2) { // from class: pt.card4b.backendbeacons.RequestDTOs$LogoutRequestDTO
            public String Email;

            {
                super(r2, r3, r4, c2);
                this.Email = str;
            }
        }).a(d.c.j0.a.b()).a(new z(eVar), new b0(eVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [pt.card4b.backendbeacons.RequestDTOs$RegistrationNewRequestDTO] */
    public void a(DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO, final String str, BackendListeners.h<String> hVar) {
        final String a2 = new c.d.b.f().a(dataModelDTOs$CustomerAccountDTO, DataModelDTOs$CustomerAccountDTO.class);
        final String c2 = h.a.a.p.c();
        this.f6302b.a((RequestDTOs$RegistrationNewRequestDTO) new RequestDTOs$DefaultRequestDTO(a2, str, "App Anda", "NONE", "NONE", c2) { // from class: pt.card4b.backendbeacons.RequestDTOs$RegistrationNewRequestDTO
            public String DeviceInternalId;
            public String JSONCustomerDetails;

            {
                super(r3, r4, r5, c2);
                this.JSONCustomerDetails = a2;
                this.DeviceInternalId = str;
            }
        }).a(d.c.j0.a.b()).a(new d0(hVar), new e0(dataModelDTOs$CustomerAccountDTO, str, hVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [pt.card4b.backendbeacons.RequestDTOs$RegistrationResetRequestDTO] */
    public void a(final String str, BackendListeners.j jVar) {
        final String c2 = h.a.a.p.c();
        this.f6302b.a((RequestDTOs$RegistrationResetRequestDTO) new RequestDTOs$DefaultRequestDTO(str, "App Anda", "NONE", "NONE", c2) { // from class: pt.card4b.backendbeacons.RequestDTOs$RegistrationResetRequestDTO
            public String Email;

            {
                super(r2, r3, r4, c2);
                this.Email = str;
            }
        }).a(d.c.j0.a.b()).a(new h0(jVar), new i0(str, jVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [pt.card4b.backendbeacons.RequestDTOs$CustomerUpdateRequestDTO] */
    public void a(final String str, DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO, BackendListeners.h<Boolean> hVar) {
        if (this.f6304d == null) {
            hVar.onError(DataModels.Error.loginRequired());
            return;
        }
        final String a2 = new c.d.b.f().a(dataModelDTOs$CustomerAccountDTO, DataModelDTOs$CustomerAccountDTO.class);
        final String c2 = h.a.a.p.c();
        this.f6302b.a((RequestDTOs$CustomerUpdateRequestDTO) new RequestDTOs$DefaultRequestDTO(str, a2, "App Anda", "NONE", "NONE", c2) { // from class: pt.card4b.backendbeacons.RequestDTOs$CustomerUpdateRequestDTO
            public String Email;
            public String JSONCustomerDetails;

            {
                super(r3, r4, r5, c2);
                this.Email = str;
                this.JSONCustomerDetails = a2;
            }
        }).a(d.c.j0.a.b()).a(new l0(hVar), new m0(str, dataModelDTOs$CustomerAccountDTO, hVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [pt.card4b.backendbeacons.RequestDTOs$CustomerUpdatePwdRequestDTO] */
    public void a(String str, String str2, String str3, BackendListeners.DefaultRequestListener defaultRequestListener) {
        if (this.f6304d == null) {
            defaultRequestListener.onError(DataModels.Error.loginRequired());
            return;
        }
        final String encodeToString = Base64.encodeToString(str.getBytes(), 2);
        final String encodeToString2 = Base64.encodeToString(str2.getBytes(), 2);
        final String encodeToString3 = Base64.encodeToString(str3.getBytes(), 2);
        final String c2 = h.a.a.p.c();
        this.f6302b.a((RequestDTOs$CustomerUpdatePwdRequestDTO) new RequestDTOs$DefaultRequestDTO(encodeToString, encodeToString2, encodeToString3, "App Anda", "NORMAL_BASE64", "NONE", c2) { // from class: pt.card4b.backendbeacons.RequestDTOs$CustomerUpdatePwdRequestDTO
            public String Email;
            public String NewPwd;
            public String Pwd;

            {
                super(r4, r5, r6, c2);
                this.Email = encodeToString;
                this.Pwd = encodeToString2;
                this.NewPwd = encodeToString3;
            }
        }).a(d.c.j0.a.b()).a(new n0(defaultRequestListener), new o0(str, str2, str3, defaultRequestListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [pt.card4b.backendbeacons.RequestDTOs$DeviceInstallRequestDTO] */
    public final void a(final String str, final String str2, final String str3, final String str4, final String str5, BackendListeners.h hVar) {
        final String c2 = h.a.a.p.c();
        this.f6302b.a((RequestDTOs$DeviceInstallRequestDTO) new RequestDTOs$DefaultRequestDTO(str, str2, str3, str4, str5, "App Anda", "NONE", "NONE", c2) { // from class: pt.card4b.backendbeacons.RequestDTOs$DeviceInstallRequestDTO
            public String AndroidId;
            public String DeviceBrand;
            public String DeviceInternalId;
            public String DeviceManufacturer;
            public String DeviceModel;
            public String IMEI;
            public String MAC;
            public String OperatingSystem;
            public String OperatingSystemVersion;
            public String RegistrationID;

            {
                super(r6, r7, r8, c2);
                this.RegistrationID = str;
                this.IMEI = str2;
                this.AndroidId = str3;
                this.MAC = str4;
                this.DeviceInternalId = str5;
                this.DeviceBrand = Build.BRAND;
                this.DeviceModel = Build.MODEL;
                this.DeviceManufacturer = Build.MANUFACTURER;
                this.OperatingSystem = "Android";
                this.OperatingSystemVersion = String.format("%s %s %s", Build.VERSION.RELEASE, Build.VERSION.CODENAME, Build.VERSION.INCREMENTAL);
            }
        }).subscribeOn(d.c.j0.a.b()).subscribe(new p0(hVar), new q0(str, str2, str3, str4, str5, hVar));
    }

    public void a(String str, String str2, String str3, String str4, String str5, List<DataModelDTOs$StageInformationBeaconDTO> list, boolean z2, int i2, String str6, BackendListeners.h<String> hVar) {
        if (this.f6304d == null) {
            hVar.onError(DataModels.Error.loginRequired());
            return;
        }
        RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO = new RequestDTOs$StageRequestDTO(str, str2, null, str3, str4, str5, new c.d.b.f().a(list, new r0(this).getType()), Boolean.valueOf(z2), i2, str6, "App Anda", "NONE", "NONE", h.a.a.p.c());
        if (!z2) {
            h.a.a.c.a("COMM_HTTP", "BackendAPIController", "postStageStart", "Sending a start stage request...");
            this.f6302b.b(requestDTOs$StageRequestDTO).a(d.c.j0.a.b()).a(new s0(hVar), new b(str, str2, str3, str4, str5, list, z2, i2, str6, hVar));
            return;
        }
        h.a.a.c.a("COMM_HTTP", "BackendAPIController", "postStageStart", "Sending a start stage (offline)");
        h.a.a.v.d().a(new DataModels.o(str, str2, null, str3, str4, str5, list, z2, i2, DataModels.o.D, str6));
        hVar.a(str);
    }

    public void a(String str, String str2, String str3, String str4, String str5, List<DataModelDTOs$StageInformationBeaconDTO> list, boolean z2, int i2, String str6, BackendListeners.o oVar) {
        if (this.f6304d == null) {
            oVar.onError(DataModels.Error.loginRequired());
        } else if (str != null && str2 != null && str3 != null && list != null) {
            h.a.a.c.a("LOGIC_BEACONS", "BackendAPIController", "postStageUpdate", "new StageRequest");
            h.a.a.v.d().a(new DataModels.o(str, str2, null, str3, str4, str5, list, z2, i2, DataModels.o.E, str6));
            oVar.onSuccess();
        } else {
            oVar.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "\"Stage Requests (update/finish): one of the parameters is null\"", ""));
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, List<DataModelDTOs$StageInformationBeaconDTO> list, boolean z2, int i2, String str7, BackendListeners.o oVar) {
        if (this.f6304d == null) {
            oVar.onError(DataModels.Error.loginRequired());
        } else if (str != null && str2 != null && str4 != null && str6 != null && list != null) {
            h.a.a.v.d().a(new DataModels.o(str, str2, str3, str4, str5, str6, list, z2, i2, DataModels.o.F, str7));
            oVar.onSuccess();
        } else {
            oVar.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "Stage Requests (update/finish): one of the parameters is null", ""));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [pt.card4b.backendbeacons.RequestDTOs$OfflinePermitRequestDTO] */
    public void a(final String str, final String str2, final String str3, BackendListeners.g gVar) {
        if (this.f6304d == null) {
            gVar.onError(DataModels.Error.loginRequired());
            return;
        }
        h.a.a.c.a("COMM_HTTP", "BackendAPIController", "offlineStartPermitCheck", "Sending a start offline permit validation request...");
        h.a.a.i iVar = this.f6302b;
        final String c2 = h.a.a.p.c();
        iVar.a((RequestDTOs$OfflinePermitRequestDTO) new RequestDTOs$DefaultRequestDTO(str, str2, str3, "App Anda", "NONE", "NONE", c2) { // from class: pt.card4b.backendbeacons.RequestDTOs$OfflinePermitRequestDTO
            public String CustomerId;
            public String Email;
            public String IMEI;

            {
                super(r4, r5, r6, c2);
                this.CustomerId = str;
                this.IMEI = str2;
                this.Email = str3;
            }
        }).a(d.c.j0.a.b()).a(new d(gVar), new f(str, str2, str3, gVar));
    }

    public void a(String str, String str2, File file, BackendListeners.q qVar) {
        String str3;
        try {
            e.c0 a2 = e.c0.a(e.w.a("multipart/form-data"), file);
            StringBuilder sb = new StringBuilder();
            String str4 = "";
            if (str != null) {
                str3 = str + "/";
            } else {
                str3 = "";
            }
            sb.append(str3);
            if (str2 != null) {
                str4 = str2 + "/";
            }
            sb.append(str4);
            sb.append(file.getName());
            this.f6302b.a(x.b.a("log file", sb.toString(), a2)).a(d.c.j0.a.b()).a(new C0131h(this, qVar), new j(str, str2, file, qVar));
        } catch (Throwable th) {
            if (qVar != null) {
                qVar.onError(h.a.a.p.a(th));
            }
        }
    }

    public void a(String str, String str2, BackendListeners.l lVar) {
        try {
            if (this.f6304d == null) {
                lVar.onError(DataModels.Error.loginRequired());
                return;
            }
            this.f6302b.a("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(str2.getBytes(), 2), Base64.encodeToString(h.a.a.p.c().getBytes(), 2)).a(d.c.j0.a.b()).a(new q(lVar), new t(str, str2, lVar));
        } catch (Throwable th) {
            h.a.a.c.a("COMM_HTTP", "BackendAPIController", "sendInvoiceEmail", "Exception: " + Log.getStackTraceString(th));
            if (lVar != null) {
                lVar.onError(h.a.a.p.a(th));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [pt.card4b.backendbeacons.RequestDTOs$PaymentMethodRegistRequestDTO] */
    public void a(final String str, final String str2, BackendListeners.m mVar) {
        try {
            if (this.f6304d == null) {
                mVar.onError(DataModels.Error.loginRequired());
                return;
            }
            final String c2 = h.a.a.p.c();
            this.f6302b.a((RequestDTOs$PaymentMethodRegistRequestDTO) new RequestDTOs$DefaultRequestDTO(str, str2, "App Anda", "NONE", "NONE", c2) { // from class: pt.card4b.backendbeacons.RequestDTOs$PaymentMethodRegistRequestDTO
                public String Email;
                public String PaymentGatewayCode;

                {
                    super(r3, r4, r5, c2);
                    this.Email = str;
                    this.PaymentGatewayCode = str2;
                }
            }).a(d.c.j0.a.b()).a(new u(mVar), new x(str, str2, mVar));
        } catch (Throwable th) {
            h.a.a.c.a("COMM_HTTP", "BackendAPIController", "setPaymentMethod", "Exception: " + Log.getStackTraceString(th));
            if (mVar != null) {
                mVar.onError(h.a.a.p.a(th));
            }
        }
    }
}
