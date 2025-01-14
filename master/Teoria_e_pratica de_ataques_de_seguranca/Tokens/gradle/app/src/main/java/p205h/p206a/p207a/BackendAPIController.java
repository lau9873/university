package p205h.p206a.p207a;

import android.os.Build;
import android.util.Base64;
import android.util.Log;
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
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.GsonBuilder;
import p070c.p084d.p105b.JsonDeserializationContext;
import p070c.p084d.p105b.JsonDeserializer;
import p070c.p084d.p105b.JsonElement;
import p070c.p084d.p105b.p111w.TypeToken;
import p136d.p153c.p159e0.Consumer;
import p136d.p153c.p179j0.Schedulers;
import p181e.Credentials;
import p181e.MediaType;
import p181e.MultipartBody;
import p181e.OkHttpClient;
import p181e.RequestBody;
import p181e.ResponseBody;
import p181e.p191j0.HttpLoggingInterceptor;
import p220i.Retrofit;
import p220i.p221p.p222a.RxJava2CallAdapterFactory;
import p220i.p223q.p224a.GsonConverterFactory;
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

/* renamed from: h.a.a.h */
/* loaded from: classes.dex */
public class BackendAPIController {

    /* renamed from: j */
    public static int f8802j = 401;

    /* renamed from: k */
    public static int f8803k = 403;

    /* renamed from: l */
    public static volatile BackendAPIController f8804l;

    /* renamed from: m */
    public static OkHttpClient.C1816b f8805m;

    /* renamed from: a */
    public Retrofit.C2634b f8806a;

    /* renamed from: b */
    public BackendAPIServices f8807b;

    /* renamed from: c */
    public String f8808c;

    /* renamed from: d */
    public String f8809d;

    /* renamed from: e */
    public long f8810e;

    /* renamed from: f */
    public String[] f8811f;

    /* renamed from: g */
    public Object f8812g = new Object();

    /* renamed from: h */
    public boolean f8813h;

    /* renamed from: i */
    public final C1936k0 f8814i;

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$a */
    /* loaded from: classes.dex */
    public class C1902a implements Consumer<ResponseDTOs$StageHistoryResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8815a;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$a$a */
        /* loaded from: classes.dex */
        public class C1903a extends TypeToken<ArrayList<DataModelDTOs$StageDetailsDTO>> {
            public C1903a(C1902a c1902a) {
            }
        }

        public C1902a(BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8815a = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$StageHistoryResponseDTO responseDTOs$StageHistoryResponseDTO) {
            if (responseDTOs$StageHistoryResponseDTO.Success) {
                this.f8815a.mo334a((List) new Gson().m4927a(responseDTOs$StageHistoryResponseDTO.JSONStagesHistoricDetails, new C1903a(this).getType()));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$StageHistoryResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8815a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$a0 */
    /* loaded from: classes.dex */
    public class C1904a0 implements Consumer<ResponseDTOs$RenewLoginResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2673a f8817a;

        public C1904a0(BackendListeners.InterfaceC2673a interfaceC2673a) {
            this.f8817a = interfaceC2673a;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$RenewLoginResponseDTO responseDTOs$RenewLoginResponseDTO) {
            if (responseDTOs$RenewLoginResponseDTO.Success) {
                synchronized (BackendAPIController.this.f8812g) {
                    if (responseDTOs$RenewLoginResponseDTO.TokenDateMilliseconds >= BackendAPIController.this.f8810e) {
                        BackendAPIController.this.f8809d = responseDTOs$RenewLoginResponseDTO.Token;
                        BackendAPIController.this.f8810e = responseDTOs$RenewLoginResponseDTO.TokenDateMilliseconds;
                        BackendAPIController backendAPIController = BackendAPIController.this;
                        backendAPIController.m2080a(backendAPIController.f8809d);
                        Consuela.m1790k().m1811b(BackendAPIController.this.f8809d);
                    }
                }
                this.f8817a.onSuccess();
            } else {
                DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$RenewLoginResponseDTO.ErrorMessage;
                DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
                BackendAPIController.this.m2053c();
                this.f8817a.onError(error);
            }
            synchronized (BackendAPIController.this.f8812g) {
                BackendAPIController.this.f8813h = false;
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$b */
    /* loaded from: classes.dex */
    public class C1905b implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8819a;

        /* renamed from: b */
        public final /* synthetic */ String f8820b;

        /* renamed from: c */
        public final /* synthetic */ String f8821c;

        /* renamed from: d */
        public final /* synthetic */ String f8822d;

        /* renamed from: e */
        public final /* synthetic */ String f8823e;

        /* renamed from: f */
        public final /* synthetic */ List f8824f;

        /* renamed from: g */
        public final /* synthetic */ boolean f8825g;

        /* renamed from: h */
        public final /* synthetic */ int f8826h;

        /* renamed from: i */
        public final /* synthetic */ String f8827i;

        /* renamed from: j */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8828j;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$b$a */
        /* loaded from: classes.dex */
        public class C1906a implements BackendListeners.InterfaceC2673a {
            public C1906a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1905b.this.f8828j.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1905b c1905b = C1905b.this;
                BackendAPIController.this.m2076a(c1905b.f8819a, c1905b.f8820b, c1905b.f8821c, c1905b.f8822d, c1905b.f8823e, c1905b.f8824f, c1905b.f8825g, c1905b.f8826h, c1905b.f8827i, c1905b.f8828j);
            }
        }

        public C1905b(String str, String str2, String str3, String str4, String str5, List list, boolean z, int i, String str6, BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8819a = str;
            this.f8820b = str2;
            this.f8821c = str3;
            this.f8822d = str4;
            this.f8823e = str5;
            this.f8824f = list;
            this.f8825g = z;
            this.f8826h = i;
            this.f8827i = str6;
            this.f8828j = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8828j.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1906a());
                return;
            }
            th.printStackTrace();
            this.f8828j.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$b0 */
    /* loaded from: classes.dex */
    public class C1907b0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2677e f8831a;

        public C1907b0(BackendListeners.InterfaceC2677e interfaceC2677e) {
            this.f8831a = interfaceC2677e;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            th.printStackTrace();
            BackendAPIController.this.m2053c();
            this.f8831a.onSuccess();
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$c */
    /* loaded from: classes.dex */
    public class C1908c implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8833a;

        /* renamed from: b */
        public final /* synthetic */ String f8834b;

        /* renamed from: c */
        public final /* synthetic */ String f8835c;

        /* renamed from: d */
        public final /* synthetic */ String f8836d;

        /* renamed from: e */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8837e;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$c$a */
        /* loaded from: classes.dex */
        public class C1909a implements BackendListeners.InterfaceC2673a {
            public C1909a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1908c.this.f8837e.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1908c c1908c = C1908c.this;
                BackendAPIController.this.m2073a(c1908c.f8833a, c1908c.f8834b, c1908c.f8835c, c1908c.f8836d, c1908c.f8837e);
            }
        }

        public C1908c(String str, String str2, String str3, String str4, BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8833a = str;
            this.f8834b = str2;
            this.f8835c = str3;
            this.f8836d = str4;
            this.f8837e = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8837e.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1909a());
                return;
            }
            th.printStackTrace();
            this.f8837e.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$c0 */
    /* loaded from: classes.dex */
    public class C1910c0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2673a f8840a;

        public C1910c0(BackendListeners.InterfaceC2673a interfaceC2673a) {
            this.f8840a = interfaceC2673a;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() == BackendAPIController.f8802j || httpException.m1a() == BackendAPIController.f8803k) {
                    BackendAPIController.this.m2053c();
                }
            }
            th.printStackTrace();
            this.f8840a.onError(DataModels.Error.communication());
            synchronized (BackendAPIController.this.f8812g) {
                BackendAPIController.this.f8813h = false;
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$d */
    /* loaded from: classes.dex */
    public class C1911d implements Consumer<ResponseDTOs$OfflinePermitResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2679g f8842a;

        public C1911d(BackendListeners.InterfaceC2679g interfaceC2679g) {
            this.f8842a = interfaceC2679g;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$OfflinePermitResponseDTO responseDTOs$OfflinePermitResponseDTO) {
            StringBuilder sb = new StringBuilder();
            sb.append("Offline start Permit=");
            sb.append(responseDTOs$OfflinePermitResponseDTO.OfflinePermit ? "true" : "false");
            AppLog.m2158a("COMM_HTTP", "BackendAPIController", "offlineStartPermitCheck:onSuccess", sb.toString());
            if (responseDTOs$OfflinePermitResponseDTO.Success) {
                this.f8842a.mo335a(responseDTOs$OfflinePermitResponseDTO.ServerDate, responseDTOs$OfflinePermitResponseDTO.OfflinePermit, responseDTOs$OfflinePermitResponseDTO.LastConfigChange, responseDTOs$OfflinePermitResponseDTO.LogoutNeeded, responseDTOs$OfflinePermitResponseDTO.DenyReason, responseDTOs$OfflinePermitResponseDTO.DenyReasonCode);
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$OfflinePermitResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8842a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$d0 */
    /* loaded from: classes.dex */
    public class C1912d0 implements Consumer<ResponseDTOs$RegistrationNewResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8844a;

        public C1912d0(BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8844a = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$RegistrationNewResponseDTO responseDTOs$RegistrationNewResponseDTO) {
            if (responseDTOs$RegistrationNewResponseDTO.Success) {
                this.f8844a.mo334a(responseDTOs$RegistrationNewResponseDTO.CustomerId);
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$RegistrationNewResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8844a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$e */
    /* loaded from: classes.dex */
    public class C1913e implements Consumer<ResponseDTOs$StageTariffsResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8846a;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$e$a */
        /* loaded from: classes.dex */
        public class C1914a extends TypeToken<ArrayList<DataModelDTOs$StageTariffsDTO>> {
            public C1914a(C1913e c1913e) {
            }
        }

        public C1913e(BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8846a = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$StageTariffsResponseDTO responseDTOs$StageTariffsResponseDTO) {
            if (responseDTOs$StageTariffsResponseDTO.Success) {
                this.f8846a.mo334a((List) new Gson().m4927a(responseDTOs$StageTariffsResponseDTO.JSONStageTariffDetails, new C1914a(this).getType()));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$StageTariffsResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8846a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$e0 */
    /* loaded from: classes.dex */
    public class C1915e0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ DataModelDTOs$CustomerAccountDTO f8848a;

        /* renamed from: b */
        public final /* synthetic */ String f8849b;

        /* renamed from: c */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8850c;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$e0$a */
        /* loaded from: classes.dex */
        public class C1916a implements BackendListeners.InterfaceC2673a {
            public C1916a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1915e0.this.f8850c.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1915e0 c1915e0 = C1915e0.this;
                BackendAPIController.this.m2060a(c1915e0.f8848a, c1915e0.f8849b, c1915e0.f8850c);
            }
        }

        public C1915e0(DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO, String str, BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8848a = dataModelDTOs$CustomerAccountDTO;
            this.f8849b = str;
            this.f8850c = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8850c.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1916a());
                return;
            }
            th.printStackTrace();
            this.f8850c.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$f */
    /* loaded from: classes.dex */
    public class C1917f implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8853a;

        /* renamed from: b */
        public final /* synthetic */ String f8854b;

        /* renamed from: c */
        public final /* synthetic */ String f8855c;

        /* renamed from: d */
        public final /* synthetic */ BackendListeners.InterfaceC2679g f8856d;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$f$a */
        /* loaded from: classes.dex */
        public class C1918a implements BackendListeners.InterfaceC2673a {
            public C1918a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1917f.this.f8856d.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1917f c1917f = C1917f.this;
                BackendAPIController.this.m2070a(c1917f.f8853a, c1917f.f8854b, c1917f.f8855c, c1917f.f8856d);
            }
        }

        public C1917f(String str, String str2, String str3, BackendListeners.InterfaceC2679g interfaceC2679g) {
            this.f8853a = str;
            this.f8854b = str2;
            this.f8855c = str3;
            this.f8856d = interfaceC2679g;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8856d.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1918a());
                return;
            }
            th.printStackTrace();
            this.f8856d.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$f0 */
    /* loaded from: classes.dex */
    public class C1919f0 implements BackendListeners.InterfaceC2673a {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2673a f8859a;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$f0$a */
        /* loaded from: classes.dex */
        public class C1920a implements BackendListeners.InterfaceC2673a {
            public C1920a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1919f0.this.f8859a.onError(error);
                AppLog.m2158a("COMM_HTTP", "BackendAPIController", "renewBackendAuth:renewLogin:onError", error.getMessage());
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1919f0.this.f8859a.onSuccess();
            }
        }

        public C1919f0(BackendListeners.InterfaceC2673a interfaceC2673a) {
            this.f8859a = interfaceC2673a;
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
            this.f8859a.onError(error);
            AppLog.m2158a("COMM_HTTP", "BackendAPIController", "renewBackendAuth:sessionStart:onError", error.getMessage());
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
        public void onSuccess() {
            if (BackendAPIController.this.f8809d != null) {
                BackendAPIController.this.m2066a(SharedPrefsController.m1540d().m1534f(), new C1920a());
                return;
            }
            this.f8859a.onSuccess();
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$g */
    /* loaded from: classes.dex */
    public class C1921g implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8862a;

        /* renamed from: b */
        public final /* synthetic */ String f8863b;

        /* renamed from: c */
        public final /* synthetic */ String f8864c;

        /* renamed from: d */
        public final /* synthetic */ String f8865d;

        /* renamed from: e */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8866e;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$g$a */
        /* loaded from: classes.dex */
        public class C1922a implements BackendListeners.InterfaceC2673a {
            public C1922a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1921g.this.f8866e.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1921g c1921g = C1921g.this;
                BackendAPIController.this.m2056b(c1921g.f8862a, c1921g.f8863b, c1921g.f8864c, c1921g.f8865d, c1921g.f8866e);
            }
        }

        public C1921g(String str, String str2, String str3, String str4, BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8862a = str;
            this.f8863b = str2;
            this.f8864c = str3;
            this.f8865d = str4;
            this.f8866e = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8866e.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1922a());
                return;
            }
            th.printStackTrace();
            this.f8866e.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$g0 */
    /* loaded from: classes.dex */
    public class C1923g0 implements Consumer<ResponseDTOs$GetApplicationDataResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8869a;

        public C1923g0(BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8869a = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
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
                this.f8869a.mo334a(hashMap);
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$GetApplicationDataResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8869a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$h */
    /* loaded from: classes.dex */
    public class C1924h implements Consumer<ResponseBody> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2689q f8871a;

        public C1924h(BackendAPIController backendAPIController, BackendListeners.InterfaceC2689q interfaceC2689q) {
            this.f8871a = interfaceC2689q;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseBody responseBody) {
            AppLog.m2158a("COMM_HTTP", "BackendAPIController", "uploadFile", "send file OK");
            BackendListeners.InterfaceC2689q interfaceC2689q = this.f8871a;
            if (interfaceC2689q != null) {
                interfaceC2689q.onSuccess();
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$h0 */
    /* loaded from: classes.dex */
    public class C1925h0 implements Consumer<ResponseDTOs$RegistrationResetResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2682j f8872a;

        public C1925h0(BackendListeners.InterfaceC2682j interfaceC2682j) {
            this.f8872a = interfaceC2682j;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$RegistrationResetResponseDTO responseDTOs$RegistrationResetResponseDTO) {
            if (responseDTOs$RegistrationResetResponseDTO.Success) {
                this.f8872a.onSuccess();
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$RegistrationResetResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8872a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$i */
    /* loaded from: classes.dex */
    public class C1926i implements Consumer<ResponseDTOs$GetInvoicesResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8874a;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$i$a */
        /* loaded from: classes.dex */
        public class C1927a extends TypeToken<ArrayList<DataModelDTOs$InvoiceDetailsDTO>> {
            public C1927a(C1926i c1926i) {
            }
        }

        public C1926i(BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8874a = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$GetInvoicesResponseDTO responseDTOs$GetInvoicesResponseDTO) {
            if (responseDTOs$GetInvoicesResponseDTO.Success) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.m4914a(Date.class, BackendAPIController.this.f8814i);
                gsonBuilder.m4916a(BackendAPIController.this.f8814i.m2024a());
                this.f8874a.mo334a((List) gsonBuilder.m4917a().m4927a(responseDTOs$GetInvoicesResponseDTO.JSONInvoiceDetails, new C1927a(this).getType()));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$GetInvoicesResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8874a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$i0 */
    /* loaded from: classes.dex */
    public class C1928i0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8876a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.InterfaceC2682j f8877b;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$i0$a */
        /* loaded from: classes.dex */
        public class C1929a implements BackendListeners.InterfaceC2673a {
            public C1929a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1928i0.this.f8877b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1928i0 c1928i0 = C1928i0.this;
                BackendAPIController.this.m2063a(c1928i0.f8876a, c1928i0.f8877b);
            }
        }

        public C1928i0(String str, BackendListeners.InterfaceC2682j interfaceC2682j) {
            this.f8876a = str;
            this.f8877b = interfaceC2682j;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8877b.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1929a());
                return;
            }
            th.printStackTrace();
            this.f8877b.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$j */
    /* loaded from: classes.dex */
    public class C1930j implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8880a;

        /* renamed from: b */
        public final /* synthetic */ String f8881b;

        /* renamed from: c */
        public final /* synthetic */ File f8882c;

        /* renamed from: d */
        public final /* synthetic */ BackendListeners.InterfaceC2689q f8883d;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$j$a */
        /* loaded from: classes.dex */
        public class C1931a implements BackendListeners.InterfaceC2673a {
            public C1931a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1930j.this.f8883d.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1930j c1930j = C1930j.this;
                BackendAPIController.this.m2078a(c1930j.f8880a, c1930j.f8881b, c1930j.f8882c, c1930j.f8883d);
            }
        }

        public C1930j(String str, String str2, File file, BackendListeners.InterfaceC2689q interfaceC2689q) {
            this.f8880a = str;
            this.f8881b = str2;
            this.f8882c = file;
            this.f8883d = interfaceC2689q;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8883d.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1931a());
                return;
            }
            th.printStackTrace();
            this.f8883d.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$j0 */
    /* loaded from: classes.dex */
    public class C1932j0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8886a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8887b;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$j0$a */
        /* loaded from: classes.dex */
        public class C1933a implements BackendListeners.InterfaceC2673a {
            public C1933a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1932j0.this.f8887b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1932j0 c1932j0 = C1932j0.this;
                BackendAPIController.this.m2064a(c1932j0.f8886a, c1932j0.f8887b);
            }
        }

        public C1932j0(String str, BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8886a = str;
            this.f8887b = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8887b.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1933a());
                return;
            }
            th.printStackTrace();
            this.f8887b.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$k */
    /* loaded from: classes.dex */
    public class C1934k implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8890a;

        /* renamed from: b */
        public final /* synthetic */ String f8891b;

        /* renamed from: c */
        public final /* synthetic */ String f8892c;

        /* renamed from: d */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8893d;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$k$a */
        /* loaded from: classes.dex */
        public class C1935a implements BackendListeners.InterfaceC2673a {
            public C1935a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1934k.this.f8893d.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1934k c1934k = C1934k.this;
                BackendAPIController.this.m2069a(c1934k.f8890a, c1934k.f8891b, c1934k.f8892c, c1934k.f8893d);
            }
        }

        public C1934k(String str, String str2, String str3, BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8890a = str;
            this.f8891b = str2;
            this.f8892c = str3;
            this.f8893d = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8893d.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1935a());
                return;
            }
            th.printStackTrace();
            this.f8893d.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$k0 */
    /* loaded from: classes.dex */
    public class C1936k0 implements JsonDeserializer<Date> {

        /* renamed from: a */
        public String f8896a;

        public C1936k0(BackendAPIController backendAPIController, String str) {
            this.f8896a = str;
        }

        /* renamed from: a */
        public String m2024a() {
            return this.f8896a;
        }

        @Override // p070c.p084d.p105b.JsonDeserializer
        /* renamed from: a */
        public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            String mo4896p;
            if (jsonElement != null && (mo4896p = jsonElement.mo4896p()) != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f8896a);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Lisbon"));
                try {
                    return simpleDateFormat.parse(mo4896p);
                } catch (ParseException e) {
                    AppLog.m2158a("LIB", "JsonDateDeserializer", "DateDeserializer", "Exception: " + e.toString());
                }
            }
            return null;
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$l */
    /* loaded from: classes.dex */
    public class C1937l implements Consumer<ResponseDTOs$GetCustomerAccountResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8897a;

        public C1937l(BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8897a = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$GetCustomerAccountResponseDTO responseDTOs$GetCustomerAccountResponseDTO) {
            if (responseDTOs$GetCustomerAccountResponseDTO.Success) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.m4914a(Date.class, BackendAPIController.this.f8814i);
                gsonBuilder.m4916a(BackendAPIController.this.f8814i.m2024a());
                this.f8897a.mo334a((DataModelDTOs$CustomerAccountDTO) gsonBuilder.m4917a().m4928a(responseDTOs$GetCustomerAccountResponseDTO.JSONCustomerAccount, (Class<Object>) DataModelDTOs$CustomerAccountDTO.class));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$GetCustomerAccountResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8897a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$l0 */
    /* loaded from: classes.dex */
    public class C1938l0 implements Consumer<ResponseDTOs$CustomerUpdateResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8899a;

        public C1938l0(BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8899a = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$CustomerUpdateResponseDTO responseDTOs$CustomerUpdateResponseDTO) {
            if (responseDTOs$CustomerUpdateResponseDTO.Success) {
                String str = responseDTOs$CustomerUpdateResponseDTO.Token;
                if (str != null && !str.equals("")) {
                    synchronized (BackendAPIController.this.f8812g) {
                        if (responseDTOs$CustomerUpdateResponseDTO.TokenDateMilliseconds >= BackendAPIController.this.f8810e) {
                            BackendAPIController.this.f8809d = responseDTOs$CustomerUpdateResponseDTO.Token;
                            BackendAPIController.this.f8810e = responseDTOs$CustomerUpdateResponseDTO.TokenDateMilliseconds;
                            BackendAPIController backendAPIController = BackendAPIController.this;
                            backendAPIController.m2080a(backendAPIController.f8809d);
                            Consuela.m1790k().m1811b(BackendAPIController.this.f8809d);
                        }
                    }
                }
                this.f8899a.mo334a(Boolean.valueOf(responseDTOs$CustomerUpdateResponseDTO.ConfirmationNeeded));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$CustomerUpdateResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8899a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$m */
    /* loaded from: classes.dex */
    public class C1939m implements Consumer<ResponseDTOs$PaymentMethodResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8901a;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$m$a */
        /* loaded from: classes.dex */
        public class C1940a extends TypeToken<ArrayList<DataModelDTOs$PaymentMethodDTO>> {
            public C1940a(C1939m c1939m) {
            }
        }

        public C1939m(BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8901a = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$PaymentMethodResponseDTO responseDTOs$PaymentMethodResponseDTO) {
            if (responseDTOs$PaymentMethodResponseDTO.Success) {
                this.f8901a.mo334a((List) new Gson().m4927a(responseDTOs$PaymentMethodResponseDTO.JSONPaymentGateways, new C1940a(this).getType()));
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$PaymentMethodResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8901a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$m0 */
    /* loaded from: classes.dex */
    public class C1941m0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8903a;

        /* renamed from: b */
        public final /* synthetic */ DataModelDTOs$CustomerAccountDTO f8904b;

        /* renamed from: c */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8905c;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$m0$a */
        /* loaded from: classes.dex */
        public class C1942a implements BackendListeners.InterfaceC2673a {
            public C1942a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1941m0.this.f8905c.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1941m0 c1941m0 = C1941m0.this;
                BackendAPIController.this.m2062a(c1941m0.f8903a, c1941m0.f8904b, c1941m0.f8905c);
            }
        }

        public C1941m0(String str, DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO, BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8903a = str;
            this.f8904b = dataModelDTOs$CustomerAccountDTO;
            this.f8905c = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8905c.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1942a());
                return;
            }
            th.printStackTrace();
            this.f8905c.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$n */
    /* loaded from: classes.dex */
    public class C1943n implements Consumer<ResponseDTOs$SessionResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2673a f8908a;

        public C1943n(BackendListeners.InterfaceC2673a interfaceC2673a) {
            this.f8908a = interfaceC2673a;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$SessionResponseDTO responseDTOs$SessionResponseDTO) {
            if (responseDTOs$SessionResponseDTO.Success) {
                BackendAPIController.this.f8808c = responseDTOs$SessionResponseDTO.Token;
                BackendAPIController backendAPIController = BackendAPIController.this;
                backendAPIController.m2080a(backendAPIController.f8808c);
                this.f8908a.onSuccess();
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$SessionResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8908a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$n0 */
    /* loaded from: classes.dex */
    public class C1944n0 implements Consumer<ResponseDTOs$CustomerUpdatePwdResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.DefaultRequestListener f8910a;

        public C1944n0(BackendListeners.DefaultRequestListener defaultRequestListener) {
            this.f8910a = defaultRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$CustomerUpdatePwdResponseDTO responseDTOs$CustomerUpdatePwdResponseDTO) {
            if (responseDTOs$CustomerUpdatePwdResponseDTO.Success) {
                String str = responseDTOs$CustomerUpdatePwdResponseDTO.Token;
                if (str != null && !str.equals("")) {
                    synchronized (BackendAPIController.this.f8812g) {
                        if (responseDTOs$CustomerUpdatePwdResponseDTO.TokenDateMilliseconds >= BackendAPIController.this.f8810e) {
                            BackendAPIController.this.f8809d = responseDTOs$CustomerUpdatePwdResponseDTO.Token;
                            BackendAPIController.this.f8810e = responseDTOs$CustomerUpdatePwdResponseDTO.TokenDateMilliseconds;
                            BackendAPIController backendAPIController = BackendAPIController.this;
                            backendAPIController.m2080a(backendAPIController.f8809d);
                            Consuela.m1790k().m1811b(BackendAPIController.this.f8809d);
                        }
                    }
                }
                this.f8910a.onSuccess();
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$CustomerUpdatePwdResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8910a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$o */
    /* loaded from: classes.dex */
    public class C1945o implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8912a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8913b;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$o$a */
        /* loaded from: classes.dex */
        public class C1946a implements BackendListeners.InterfaceC2673a {
            public C1946a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1945o.this.f8913b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1945o c1945o = C1945o.this;
                BackendAPIController.this.m2050c(c1945o.f8912a, c1945o.f8913b);
            }
        }

        public C1945o(String str, BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8912a = str;
            this.f8913b = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8913b.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1946a());
                return;
            }
            th.printStackTrace();
            this.f8913b.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$o0 */
    /* loaded from: classes.dex */
    public class C1947o0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8916a;

        /* renamed from: b */
        public final /* synthetic */ String f8917b;

        /* renamed from: c */
        public final /* synthetic */ String f8918c;

        /* renamed from: d */
        public final /* synthetic */ BackendListeners.DefaultRequestListener f8919d;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$o0$a */
        /* loaded from: classes.dex */
        public class C1948a implements BackendListeners.InterfaceC2673a {
            public C1948a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1947o0.this.f8919d.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1947o0 c1947o0 = C1947o0.this;
                BackendAPIController.this.m2071a(c1947o0.f8916a, c1947o0.f8917b, c1947o0.f8918c, c1947o0.f8919d);
            }
        }

        public C1947o0(String str, String str2, String str3, BackendListeners.DefaultRequestListener defaultRequestListener) {
            this.f8916a = str;
            this.f8917b = str2;
            this.f8918c = str3;
            this.f8919d = defaultRequestListener;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8919d.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1948a());
                return;
            }
            th.printStackTrace();
            this.f8919d.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$p */
    /* loaded from: classes.dex */
    public class C1949p implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8922a;

        /* renamed from: b */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8923b;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$p$a */
        /* loaded from: classes.dex */
        public class C1950a implements BackendListeners.InterfaceC2673a {
            public C1950a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1949p.this.f8923b.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1949p c1949p = C1949p.this;
                BackendAPIController.this.m2055b(c1949p.f8922a, c1949p.f8923b);
            }
        }

        public C1949p(String str, BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8922a = str;
            this.f8923b = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8923b.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1950a());
                return;
            }
            th.printStackTrace();
            this.f8923b.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$p0 */
    /* loaded from: classes.dex */
    public class C1951p0 implements Consumer<ResponseDTOs$DeviceInstallResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8926a;

        public C1951p0(BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8926a = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$DeviceInstallResponseDTO responseDTOs$DeviceInstallResponseDTO) {
            if (responseDTOs$DeviceInstallResponseDTO.Success) {
                this.f8926a.mo334a(responseDTOs$DeviceInstallResponseDTO);
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$DeviceInstallResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8926a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$q */
    /* loaded from: classes.dex */
    public class C1952q implements Consumer<ResponseDTOs$DefaultResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2684l f8928a;

        public C1952q(BackendListeners.InterfaceC2684l interfaceC2684l) {
            this.f8928a = interfaceC2684l;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$DefaultResponseDTO responseDTOs$DefaultResponseDTO) {
            if (responseDTOs$DefaultResponseDTO.Success) {
                this.f8928a.onSuccess();
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$DefaultResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8928a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$q0 */
    /* loaded from: classes.dex */
    public class C1953q0 implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8930a;

        /* renamed from: b */
        public final /* synthetic */ String f8931b;

        /* renamed from: c */
        public final /* synthetic */ String f8932c;

        /* renamed from: d */
        public final /* synthetic */ String f8933d;

        /* renamed from: e */
        public final /* synthetic */ String f8934e;

        /* renamed from: f */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8935f;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$q0$a */
        /* loaded from: classes.dex */
        public class C1954a implements BackendListeners.InterfaceC2673a {
            public C1954a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1953q0.this.f8935f.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1953q0 c1953q0 = C1953q0.this;
                BackendAPIController.this.m2074a(c1953q0.f8930a, c1953q0.f8931b, c1953q0.f8932c, c1953q0.f8933d, c1953q0.f8934e, c1953q0.f8935f);
            }
        }

        public C1953q0(String str, String str2, String str3, String str4, String str5, BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8930a = str;
            this.f8931b = str2;
            this.f8932c = str3;
            this.f8933d = str4;
            this.f8934e = str5;
            this.f8935f = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8935f.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1954a());
                return;
            }
            th.printStackTrace();
            this.f8935f.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$r */
    /* loaded from: classes.dex */
    public class C1955r implements Consumer<ResponseDTOs$LoginResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2676d f8938a;

        public C1955r(BackendListeners.InterfaceC2676d interfaceC2676d) {
            this.f8938a = interfaceC2676d;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$LoginResponseDTO responseDTOs$LoginResponseDTO) {
            if (responseDTOs$LoginResponseDTO.Success) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.m4914a(Date.class, BackendAPIController.this.f8814i);
                gsonBuilder.m4916a(BackendAPIController.this.f8814i.m2024a());
                DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO = (DataModelDTOs$CustomerAccountDTO) gsonBuilder.m4917a().m4928a(responseDTOs$LoginResponseDTO.JSONCustomerAccount, (Class<Object>) DataModelDTOs$CustomerAccountDTO.class);
                synchronized (BackendAPIController.this.f8812g) {
                    if (responseDTOs$LoginResponseDTO.TokenDateMilliseconds >= BackendAPIController.this.f8810e) {
                        BackendAPIController.this.f8809d = responseDTOs$LoginResponseDTO.Token;
                        BackendAPIController.this.f8810e = responseDTOs$LoginResponseDTO.TokenDateMilliseconds;
                        BackendAPIController backendAPIController = BackendAPIController.this;
                        backendAPIController.m2080a(backendAPIController.f8809d);
                        Consuela.m1790k().m1811b(BackendAPIController.this.f8809d);
                    }
                }
                this.f8938a.mo336a(dataModelDTOs$CustomerAccountDTO);
            } else {
                DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$LoginResponseDTO.ErrorMessage;
                DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
                if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                    BackendAPIController.this.m2053c();
                }
                this.f8938a.onError(error);
            }
            synchronized (BackendAPIController.this.f8812g) {
                BackendAPIController.this.f8813h = false;
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$r0 */
    /* loaded from: classes.dex */
    public class C1956r0 extends TypeToken<ArrayList<DataModelDTOs$StageInformationBeaconDTO>> {
        public C1956r0(BackendAPIController backendAPIController) {
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$s */
    /* loaded from: classes.dex */
    public class C1957s implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8940a;

        /* renamed from: b */
        public final /* synthetic */ String f8941b;

        /* renamed from: c */
        public final /* synthetic */ String f8942c;

        /* renamed from: d */
        public final /* synthetic */ String f8943d;

        /* renamed from: e */
        public final /* synthetic */ boolean f8944e;

        /* renamed from: f */
        public final /* synthetic */ BackendListeners.InterfaceC2676d f8945f;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$s$a */
        /* loaded from: classes.dex */
        public class C1958a implements BackendListeners.InterfaceC2673a {
            public C1958a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1957s.this.f8945f.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1957s c1957s = C1957s.this;
                BackendAPIController.this.m2072a(c1957s.f8940a, c1957s.f8941b, c1957s.f8942c, c1957s.f8943d, c1957s.f8944e, c1957s.f8945f);
            }
        }

        public C1957s(String str, String str2, String str3, String str4, boolean z, BackendListeners.InterfaceC2676d interfaceC2676d) {
            this.f8940a = str;
            this.f8941b = str2;
            this.f8942c = str3;
            this.f8943d = str4;
            this.f8944e = z;
            this.f8945f = interfaceC2676d;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8945f.onError(DataModels.Error.communication());
                } else {
                    BackendAPIController.this.m2061a(new C1958a());
                    return;
                }
            } else {
                th.printStackTrace();
                this.f8945f.onError(DataModels.Error.communication());
            }
            synchronized (BackendAPIController.this.f8812g) {
                BackendAPIController.this.f8813h = false;
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$s0 */
    /* loaded from: classes.dex */
    public class C1959s0 implements Consumer<ResponseDTOs$StageResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2680h f8948a;

        public C1959s0(BackendListeners.InterfaceC2680h interfaceC2680h) {
            this.f8948a = interfaceC2680h;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$StageResponseDTO responseDTOs$StageResponseDTO) {
            AppLog.m2158a("COMM_HTTP", "BackendAPIController", "postStageStart:onSuccess", "Received new stage id = " + responseDTOs$StageResponseDTO.StageId);
            if (responseDTOs$StageResponseDTO.Success) {
                this.f8948a.mo334a(responseDTOs$StageResponseDTO.StageId);
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$StageResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8948a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$t */
    /* loaded from: classes.dex */
    public class C1960t implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8950a;

        /* renamed from: b */
        public final /* synthetic */ String f8951b;

        /* renamed from: c */
        public final /* synthetic */ BackendListeners.InterfaceC2684l f8952c;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$t$a */
        /* loaded from: classes.dex */
        public class C1961a implements BackendListeners.InterfaceC2673a {
            public C1961a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1960t.this.f8952c.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1960t c1960t = C1960t.this;
                BackendAPIController.this.m2068a(c1960t.f8950a, c1960t.f8951b, c1960t.f8952c);
            }
        }

        public C1960t(String str, String str2, BackendListeners.InterfaceC2684l interfaceC2684l) {
            this.f8950a = str;
            this.f8951b = str2;
            this.f8952c = interfaceC2684l;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8952c.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1961a());
                return;
            }
            th.printStackTrace();
            this.f8952c.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$u */
    /* loaded from: classes.dex */
    public class C1962u implements Consumer<ResponseDTOs$DefaultResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2685m f8955a;

        public C1962u(BackendListeners.InterfaceC2685m interfaceC2685m) {
            this.f8955a = interfaceC2685m;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$DefaultResponseDTO responseDTOs$DefaultResponseDTO) {
            if (responseDTOs$DefaultResponseDTO.Success) {
                this.f8955a.onSuccess();
                return;
            }
            DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$DefaultResponseDTO.ErrorMessage;
            DataModels.Error error = dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal();
            if (error.getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                BackendAPIController.this.m2053c();
            }
            this.f8955a.onError(error);
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$v */
    /* loaded from: classes.dex */
    public class C1963v implements BackendListeners.InterfaceC2673a {
        public C1963v(BackendAPIController backendAPIController) {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
        public void onError(DataModels.Error error) {
        }

        @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
        public void onSuccess() {
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$w */
    /* loaded from: classes.dex */
    public class RunnableC1964w implements Runnable {

        /* renamed from: a */
        public boolean f8957a = false;

        /* renamed from: b */
        public boolean f8958b = false;

        /* renamed from: c */
        public boolean f8959c = false;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$w$a */
        /* loaded from: classes.dex */
        public class C1965a implements Consumer<ResponseDTOs$StageResponseDTO> {
            public C1965a() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(ResponseDTOs$StageResponseDTO responseDTOs$StageResponseDTO) {
                if (responseDTOs$StageResponseDTO.Success) {
                    RunnableC1964w.this.f8958b = true;
                    return;
                }
                DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$StageResponseDTO.ErrorMessage;
                if ((dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal()).getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                    BackendAPIController.this.m2053c();
                }
                RunnableC1964w.this.f8957a = true;
                RunnableC1964w.this.f8958b = true;
            }
        }

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$w$b */
        /* loaded from: classes.dex */
        public class C1966b implements Consumer<Throwable> {

            /* compiled from: BackendAPIController.java */
            /* renamed from: h.a.a.h$w$b$a */
            /* loaded from: classes.dex */
            public class C1967a implements BackendListeners.InterfaceC2673a {
                public C1967a() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    RunnableC1964w.this.f8959c = false;
                    AppLog.m2158a("COMM_HTTP", "BackendAPIController", "pendingStageRequests:sessionStart:onError", error.getMessage());
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
                public void onSuccess() {
                    RunnableC1964w.this.f8959c = false;
                }
            }

            public C1966b() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                th.printStackTrace();
                if (th instanceof HttpException) {
                    HttpException httpException = (HttpException) th;
                    if ((httpException.m1a() == BackendAPIController.f8802j || httpException.m1a() == BackendAPIController.f8803k) && !RunnableC1964w.this.f8959c) {
                        RunnableC1964w.this.f8959c = true;
                        BackendAPIController.this.m2061a(new C1967a());
                    }
                }
                RunnableC1964w.this.f8957a = true;
                RunnableC1964w.this.f8958b = true;
            }
        }

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$w$c */
        /* loaded from: classes.dex */
        public class C1968c implements Consumer<ResponseDTOs$EventRegistResponseDTO> {
            public C1968c() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(ResponseDTOs$EventRegistResponseDTO responseDTOs$EventRegistResponseDTO) {
                if (responseDTOs$EventRegistResponseDTO.Success) {
                    RunnableC1964w.this.f8958b = true;
                    return;
                }
                DataModelDTOs$ErrorMessageDTO dataModelDTOs$ErrorMessageDTO = responseDTOs$EventRegistResponseDTO.ErrorMessage;
                if ((dataModelDTOs$ErrorMessageDTO != null ? dataModelDTOs$ErrorMessageDTO.toError() : DataModels.Error.internal()).getType() == DataModels.Error.ErrorType.TOKEN_MISMATCH) {
                    BackendAPIController.this.m2053c();
                }
                RunnableC1964w.this.f8957a = true;
                RunnableC1964w.this.f8958b = true;
            }
        }

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$w$d */
        /* loaded from: classes.dex */
        public class C1969d implements Consumer<Throwable> {

            /* compiled from: BackendAPIController.java */
            /* renamed from: h.a.a.h$w$d$a */
            /* loaded from: classes.dex */
            public class C1970a implements BackendListeners.InterfaceC2673a {
                public C1970a() {
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
                public void onError(DataModels.Error error) {
                    RunnableC1964w.this.f8959c = false;
                    AppLog.m2158a("COMM_HTTP", "BackendAPIController", "pendingStageRequests:sessionStart:onError", error.getMessage());
                }

                @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
                public void onSuccess() {
                    RunnableC1964w.this.f8959c = false;
                }
            }

            public C1969d() {
            }

            @Override // p136d.p153c.p159e0.Consumer
            /* renamed from: a */
            public void accept(Throwable th) {
                th.printStackTrace();
                if (th instanceof HttpException) {
                    HttpException httpException = (HttpException) th;
                    if ((httpException.m1a() == BackendAPIController.f8802j || httpException.m1a() == BackendAPIController.f8803k) && !RunnableC1964w.this.f8959c) {
                        RunnableC1964w.this.f8959c = true;
                        BackendAPIController.this.m2061a(new C1970a());
                    }
                }
                RunnableC1964w.this.f8957a = true;
                RunnableC1964w.this.f8958b = true;
            }
        }

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$w$e */
        /* loaded from: classes.dex */
        public class C1971e implements BackendListeners.InterfaceC2689q {

            /* renamed from: a */
            public final /* synthetic */ File f8967a;

            public C1971e(File file) {
                this.f8967a = file;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                RunnableC1964w.this.f8958b = true;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2689q
            public void onSuccess() {
                RunnableC1964w.this.f8958b = true;
                this.f8967a.delete();
            }
        }

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$w$f */
        /* loaded from: classes.dex */
        public class C1972f implements BackendListeners.InterfaceC2689q {

            /* renamed from: a */
            public final /* synthetic */ File f8969a;

            public C1972f(File file) {
                this.f8969a = file;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                RunnableC1964w.this.f8958b = true;
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2689q
            public void onSuccess() {
                RunnableC1964w.this.f8958b = true;
                this.f8969a.delete();
            }
        }

        public RunnableC1964w() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v9, types: [pt.card4b.backendbeacons.RequestDTOs$EventRegistRequestDTO] */
        @Override // java.lang.Runnable
        public void run() {
            File m2138h;
            while (true) {
                try {
                    Thread.sleep(1000L);
                    try {
                    } catch (Throwable th) {
                        this.f8958b = true;
                        AppLog.m2158a("COMM_HTTP", "BackendAPIController", "Exception on sending data runnable", Log.getStackTraceString(th));
                    }
                    if (GeneralUtils.m1585i()) {
                        DataModels.C2706o m1525i = SharedPrefsController.m1540d().m1525i();
                        if (m1525i != null && BackendAPIController.this.f8809d != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Sending ");
                            sb.append(m1525i.m150i() == DataModels.C2706o.f10840D ? "a start" : m1525i.m150i() == DataModels.C2706o.f10842F ? "a finish" : "an update");
                            sb.append(" stage request for StageId=");
                            sb.append(m1525i.m151h());
                            sb.append("...");
                            AppLog.m2158a("COMM_HTTP", "BackendAPIController", "SendDataThread", sb.toString());
                            this.f8958b = false;
                            this.f8957a = false;
                            RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO = new RequestDTOs$StageRequestDTO(m1525i, "App Anda", "NONE", "NONE", GeneralUtils.m1591c());
                            (m1525i.m150i() == DataModels.C2706o.f10840D ? BackendAPIController.this.f8807b.m1974b(requestDTOs$StageRequestDTO) : m1525i.m150i() == DataModels.C2706o.f10842F ? BackendAPIController.this.f8807b.m1972c(requestDTOs$StageRequestDTO) : BackendAPIController.this.f8807b.m1977a(requestDTOs$StageRequestDTO)).m3305a(Schedulers.m3323b()).m3315a(new C1965a(), new C1966b());
                            while (!this.f8958b) {
                                try {
                                    Thread.sleep(500L);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (!this.f8957a) {
                                SharedPrefsController.m1540d().m1564A();
                            }
                        } else {
                            DataModels.C2699h m1546b = SharedPrefsController.m1540d().m1546b();
                            if (m1546b != null) {
                                AppLog.m2158a("COMM_HTTP", "BackendAPIController", "SendDataThread", "Sending event of type " + m1546b.m184b());
                                this.f8958b = false;
                                this.f8957a = false;
                                final String m185a = m1546b.m185a();
                                final String m181e = m1546b.m181e();
                                final Boolean m179g = m1546b.m179g();
                                final String m1593b = m1546b.m180f() != null ? GeneralUtils.m1593b(m1546b.m180f()) : null;
                                final String m184b = m1546b.m184b();
                                final String m182d = m1546b.m182d();
                                final String m1593b2 = m1546b.m178h() != null ? GeneralUtils.m1593b(m1546b.m178h()) : null;
                                final String m183c = m1546b.m183c();
                                final String m1591c = GeneralUtils.m1591c();
                                BackendAPIController.this.f8807b.m1986a((RequestDTOs$EventRegistRequestDTO) new RequestDTOs$DefaultRequestDTO(m185a, m181e, m179g, m1593b, m184b, m182d, m1593b2, m183c, "App Anda", "NONE", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$EventRegistRequestDTO
                                    public String CustomerId;
                                    public String DeviceStartDate;
                                    public String EventDateTime;
                                    public String EventDescription;
                                    public String EventReportPath;
                                    public String EventTypeCode;
                                    public String StageInfoId;
                                    public Boolean StartOffline;

                                    {
                                        super(r9, r10, r11, m1591c);
                                        this.CustomerId = m185a;
                                        this.StageInfoId = m181e;
                                        this.StartOffline = m179g;
                                        this.DeviceStartDate = m1593b;
                                        this.EventTypeCode = m184b;
                                        this.EventDescription = m182d;
                                        this.EventDateTime = m1593b2;
                                        this.EventReportPath = m183c;
                                    }
                                }).m3305a(Schedulers.m3323b()).m3315a(new C1968c(), new C1969d());
                                while (!this.f8958b) {
                                    try {
                                        Thread.sleep(500L);
                                    } catch (InterruptedException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (!this.f8957a) {
                                    SharedPrefsController.m1540d().m1502z();
                                }
                            }
                            File m2139g = AppLog.m2139g();
                            if (m2139g != null) {
                                AppLog.m2158a("COMM_HTTP", "BackendAPIController", "SendDataThread", "Sending report file");
                                this.f8958b = false;
                                this.f8957a = false;
                                BackendAPIController.this.m2078a("Reports", (String) null, m2139g, new C1971e(m2139g));
                                while (!this.f8958b) {
                                    try {
                                        Thread.sleep(500L);
                                    } catch (InterruptedException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            }
                            if (GeneralUtils.m1584j() && (m2138h = AppLog.m2138h()) != null) {
                                AppLog.m2158a("COMM_HTTP", "BackendAPIController", "SendDataThread", "Sending trip log file");
                                this.f8958b = false;
                                this.f8957a = false;
                                BackendAPIController.this.m2078a("Trips", Consuela.m1790k().m1802e() != null ? Consuela.m1790k().m1802e().getId() : null, m2138h, new C1972f(m2138h));
                                while (!this.f8958b) {
                                    try {
                                        Thread.sleep(500L);
                                    } catch (InterruptedException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                            }
                        }
                        this.f8958b = true;
                        AppLog.m2158a("COMM_HTTP", "BackendAPIController", "Exception on sending data runnable", Log.getStackTraceString(th));
                    }
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                    return;
                }
            }
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$x */
    /* loaded from: classes.dex */
    public class C1973x implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ String f8971a;

        /* renamed from: b */
        public final /* synthetic */ String f8972b;

        /* renamed from: c */
        public final /* synthetic */ BackendListeners.InterfaceC2685m f8973c;

        /* compiled from: BackendAPIController.java */
        /* renamed from: h.a.a.h$x$a */
        /* loaded from: classes.dex */
        public class C1974a implements BackendListeners.InterfaceC2673a {
            public C1974a() {
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
            public void onError(DataModels.Error error) {
                C1973x.this.f8973c.onError(error);
            }

            @Override // pt.card4b.backendbeacons.BackendListeners.InterfaceC2673a
            public void onSuccess() {
                C1973x c1973x = C1973x.this;
                BackendAPIController.this.m2067a(c1973x.f8971a, c1973x.f8972b, c1973x.f8973c);
            }
        }

        public C1973x(String str, String str2, BackendListeners.InterfaceC2685m interfaceC2685m) {
            this.f8971a = str;
            this.f8972b = str2;
            this.f8973c = interfaceC2685m;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            if (th instanceof HttpException) {
                HttpException httpException = (HttpException) th;
                if (httpException.m1a() != BackendAPIController.f8802j && httpException.m1a() != BackendAPIController.f8803k) {
                    th.printStackTrace();
                    this.f8973c.onError(DataModels.Error.communication());
                    return;
                }
                BackendAPIController.this.m2061a(new C1974a());
                return;
            }
            th.printStackTrace();
            this.f8973c.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$y */
    /* loaded from: classes.dex */
    public class C1975y implements Consumer<Throwable> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2673a f8976a;

        public C1975y(BackendAPIController backendAPIController, BackendListeners.InterfaceC2673a interfaceC2673a) {
            this.f8976a = interfaceC2673a;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(Throwable th) {
            th.printStackTrace();
            this.f8976a.onError(DataModels.Error.communication());
        }
    }

    /* compiled from: BackendAPIController.java */
    /* renamed from: h.a.a.h$z */
    /* loaded from: classes.dex */
    public class C1976z implements Consumer<ResponseDTOs$DefaultResponseDTO> {

        /* renamed from: a */
        public final /* synthetic */ BackendListeners.InterfaceC2677e f8977a;

        public C1976z(BackendListeners.InterfaceC2677e interfaceC2677e) {
            this.f8977a = interfaceC2677e;
        }

        @Override // p136d.p153c.p159e0.Consumer
        /* renamed from: a */
        public void accept(ResponseDTOs$DefaultResponseDTO responseDTOs$DefaultResponseDTO) {
            BackendAPIController.this.m2053c();
            this.f8977a.onSuccess();
        }
    }

    static {
        OkHttpClient.C1816b c1816b = new OkHttpClient.C1816b();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        c1816b.m2644a(15L, timeUnit);
        c1816b.m2641b(15L, timeUnit);
        c1816b.m2640c(15L, timeUnit);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.m2818a(HttpLoggingInterceptor.EnumC1799a.BODY);
        c1816b.m2643a(httpLoggingInterceptor);
        f8805m = c1816b;
    }

    public BackendAPIController() {
        C1936k0 c1936k0 = new C1936k0(this, "yyyy-MM-dd'T'HH:mm:ss");
        this.f8814i = c1936k0;
        if (f8804l == null) {
            this.f8811f = App.getServerInfo();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.m4914a(Date.class, c1936k0);
            gsonBuilder.m4916a(c1936k0.m2024a());
            Gson m4917a = gsonBuilder.m4917a();
            Retrofit.C2634b c2634b = new Retrofit.C2634b();
            c2634b.m618a(this.f8811f[0]);
            c2634b.m619a(GsonConverterFactory.m564a(m4917a));
            c2634b.m620a(RxJava2CallAdapterFactory.m566a());
            this.f8806a = c2634b;
            c2634b.m621a(f8805m.m2645a());
            this.f8807b = (BackendAPIServices) this.f8806a.m624a().m632a(BackendAPIServices.class);
            String m1522j = SharedPrefsController.m1540d().m1522j();
            if (m1522j != null) {
                m2079a(m1522j, 0L);
            } else {
                m2054b(new C1963v(this));
            }
            new Thread(new RunnableC1964w()).start();
            return;
        }
        throw new RuntimeException("BackendAPIController: Use getInstance() method to get the single instance of this class.");
    }

    /* renamed from: d */
    public static BackendAPIController m2049d() {
        if (f8804l == null) {
            synchronized (BackendAPIController.class) {
                if (f8804l == null) {
                    f8804l = new BackendAPIController();
                }
            }
        }
        return f8804l;
    }

    /* renamed from: c */
    public void m2050c(String str, BackendListeners.InterfaceC2680h<List<DataModelDTOs$PaymentMethodDTO>> interfaceC2680h) {
        if (this.f8809d == null) {
            interfaceC2680h.onError(DataModels.Error.loginRequired());
            return;
        }
        this.f8807b.m1973c("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(GeneralUtils.m1591c().getBytes(), 2)).m3305a(Schedulers.m3323b()).m3315a(new C1939m(interfaceC2680h), new C1945o(str, interfaceC2680h));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [pt.card4b.backendbeacons.RequestDTOs$SessionRequestDTO] */
    /* renamed from: b */
    private void m2054b(BackendListeners.InterfaceC2673a interfaceC2673a) {
        String[] strArr = this.f8811f;
        f8805m.m2643a(new AuthenticationInterceptor(Credentials.m2788a(strArr[1], strArr[2])));
        this.f8806a.m621a(f8805m.m2645a());
        this.f8807b = (BackendAPIServices) this.f8806a.m624a().m632a(BackendAPIServices.class);
        final String m1593b = GeneralUtils.m1593b(SysDateManager.m1497d().m1496e());
        final String m1591c = GeneralUtils.m1591c();
        this.f8807b.m1978a((RequestDTOs$SessionRequestDTO) new RequestDTOs$DefaultRequestDTO(m1593b, "App Anda", "NONE", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$SessionRequestDTO
            public String DateTimeRequest;

            {
                super(r2, r3, r4, m1591c);
                this.DateTimeRequest = m1593b;
            }
        }).m3305a(Schedulers.m3323b()).m3315a(new C1943n(interfaceC2673a), new C1975y(this, interfaceC2673a));
    }

    /* renamed from: a */
    public void m2079a(String str, long j) {
        synchronized (this.f8812g) {
            this.f8809d = str;
            this.f8810e = j;
            m2080a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m2053c() {
        String str = this.f8809d;
        if (str == null || str.equals("")) {
            return;
        }
        synchronized (this.f8812g) {
            this.f8809d = null;
            this.f8810e = 0L;
            m2080a(this.f8808c);
            Consuela.m1790k().m1811b((String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2080a(String str) {
        if (str != null && !str.equals("")) {
            f8805m.m2643a(new AuthenticationInterceptor("Bearer " + str));
        }
        this.f8806a.m621a(f8805m.m2645a());
        this.f8807b = (BackendAPIServices) this.f8806a.m624a().m632a(BackendAPIServices.class);
    }

    /* renamed from: b */
    public void m2056b(String str, String str2, String str3, String str4, BackendListeners.InterfaceC2680h interfaceC2680h) {
        if (this.f8809d == null) {
            interfaceC2680h.onError(DataModels.Error.loginRequired());
            return;
        }
        this.f8807b.m1990a("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(str2.getBytes(), 2), Base64.encodeToString(str3.getBytes(), 2), Base64.encodeToString(str4.getBytes(), 2), Base64.encodeToString(GeneralUtils.m1591c().getBytes(), 2)).m3305a(Schedulers.m3323b()).m3315a(new C1913e(interfaceC2680h), new C1921g(str, str2, str3, str4, interfaceC2680h));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [pt.card4b.backendbeacons.RequestDTOs$RenewRequestDTO] */
    /* renamed from: a */
    public void m2066a(final String str, BackendListeners.InterfaceC2673a interfaceC2673a) {
        final String m1591c = GeneralUtils.m1591c();
        ?? r6 = new RequestDTOs$DefaultRequestDTO(str, "App Anda", "NONE", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$RenewRequestDTO
            public String Email;

            {
                super(r2, r3, r4, m1591c);
                this.Email = str;
            }
        };
        if (this.f8809d == null) {
            interfaceC2673a.onError(DataModels.Error.loginRequired());
            return;
        }
        synchronized (this.f8812g) {
            if (this.f8813h) {
                interfaceC2673a.onError(DataModels.Error.communication());
                return;
            }
            this.f8813h = true;
            m2080a(this.f8809d);
            this.f8807b.m1979a((RequestDTOs$RenewRequestDTO) r6).m3305a(Schedulers.m3323b()).m3315a(new C1904a0(interfaceC2673a), new C1910c0(interfaceC2673a));
        }
    }

    /* renamed from: b */
    public void m2055b(String str, BackendListeners.InterfaceC2680h<DataModelDTOs$CustomerAccountDTO> interfaceC2680h) {
        try {
            if (this.f8809d == null) {
                interfaceC2680h.onError(DataModels.Error.loginRequired());
                return;
            }
            this.f8807b.m1993a("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(GeneralUtils.m1591c().getBytes(), 2)).m3305a(Schedulers.m3323b()).m3315a(new C1937l(interfaceC2680h), new C1949p(str, interfaceC2680h));
        } catch (Throwable th) {
            AppLog.m2158a("COMM_HTTP", "BackendAPIController", "getCustomerAccount", "Exception: " + Log.getStackTraceString(th));
            if (interfaceC2680h != null) {
                interfaceC2680h.onError(GeneralUtils.m1599a(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m2061a(BackendListeners.InterfaceC2673a interfaceC2673a) {
        SharedPrefsController.m1540d().m1534f();
        m2054b(new C1919f0(interfaceC2673a));
    }

    /* renamed from: a */
    public void m2064a(String str, BackendListeners.InterfaceC2680h<Map<String, String>> interfaceC2680h) {
        this.f8807b.m1976b("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(GeneralUtils.m1591c().getBytes(), 2)).m3305a(Schedulers.m3323b()).m3315a(new C1923g0(interfaceC2680h), new C1932j0(str, interfaceC2680h));
    }

    /* renamed from: a */
    public void m2073a(String str, String str2, String str3, String str4, BackendListeners.InterfaceC2680h<List<DataModelDTOs$StageDetailsDTO>> interfaceC2680h) {
        if (this.f8809d == null) {
            interfaceC2680h.onError(DataModels.Error.loginRequired());
            return;
        }
        this.f8807b.m1975b("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(str2.getBytes(), 2), Base64.encodeToString(str3.getBytes(), 2), Base64.encodeToString(str4.getBytes(), 2), Base64.encodeToString(GeneralUtils.m1591c().getBytes(), 2)).m3305a(Schedulers.m3323b()).m3315a(new C1902a(interfaceC2680h), new C1908c(str, str2, str3, str4, interfaceC2680h));
    }

    /* renamed from: a */
    public void m2069a(String str, String str2, String str3, BackendListeners.InterfaceC2680h interfaceC2680h) {
        if (this.f8809d == null) {
            interfaceC2680h.onError(DataModels.Error.loginRequired());
            return;
        }
        this.f8807b.m1991a("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(str2.getBytes(), 2), Base64.encodeToString(str3.getBytes(), 2), Base64.encodeToString(GeneralUtils.m1591c().getBytes(), 2)).m3305a(Schedulers.m3323b()).m3315a(new C1926i(interfaceC2680h), new C1934k(str, str2, str3, interfaceC2680h));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [pt.card4b.backendbeacons.RequestDTOs$LoginRequestDTO] */
    /* renamed from: a */
    public void m2072a(final String str, final String str2, final String str3, final String str4, final boolean z, BackendListeners.InterfaceC2676d interfaceC2676d) {
        final String m1591c = GeneralUtils.m1591c();
        ?? r1 = new RequestDTOs$DefaultRequestDTO(str, str2, str3, str4, "App Anda", "NONE", "NONE", m1591c, z) { // from class: pt.card4b.backendbeacons.RequestDTOs$LoginRequestDTO
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
                super(r5, r6, r7, m1591c);
                this.Email = str;
                this.Password = str2;
                this.DeviceInternalId = str3;
                this.DeviceManufacturer = Build.MANUFACTURER;
                this.DeviceBrand = Build.BRAND;
                this.DeviceModel = Build.MODEL;
                this.OperatingSystem = "Android";
                this.OperatingSystemVersion = String.format("%s %s %s", Build.VERSION.RELEASE, Build.VERSION.CODENAME, Build.VERSION.INCREMENTAL);
                this.IMEI = str4;
                this.HasDataDownloaded = z;
            }
        };
        synchronized (this.f8812g) {
            if (this.f8813h) {
                interfaceC2676d.onError(DataModels.Error.communication());
                return;
            }
            this.f8813h = true;
            this.f8807b.m1985a((RequestDTOs$LoginRequestDTO) r1).m3305a(Schedulers.m3323b()).m3315a(new C1955r(interfaceC2676d), new C1957s(str, str2, str3, str4, z, interfaceC2676d));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [pt.card4b.backendbeacons.RequestDTOs$LogoutRequestDTO] */
    /* renamed from: a */
    public void m2065a(final String str, BackendListeners.InterfaceC2677e interfaceC2677e) {
        final String m1591c = GeneralUtils.m1591c();
        this.f8807b.m1984a((RequestDTOs$LogoutRequestDTO) new RequestDTOs$DefaultRequestDTO(str, "App Anda", "NONE", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$LogoutRequestDTO
            public String Email;

            {
                super(r2, r3, r4, m1591c);
                this.Email = str;
            }
        }).m3305a(Schedulers.m3323b()).m3315a(new C1976z(interfaceC2677e), new C1907b0(interfaceC2677e));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [pt.card4b.backendbeacons.RequestDTOs$RegistrationNewRequestDTO] */
    /* renamed from: a */
    public void m2060a(DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO, final String str, BackendListeners.InterfaceC2680h<String> interfaceC2680h) {
        final String m4931a = new Gson().m4931a(dataModelDTOs$CustomerAccountDTO, DataModelDTOs$CustomerAccountDTO.class);
        final String m1591c = GeneralUtils.m1591c();
        this.f8807b.m1981a((RequestDTOs$RegistrationNewRequestDTO) new RequestDTOs$DefaultRequestDTO(m4931a, str, "App Anda", "NONE", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$RegistrationNewRequestDTO
            public String DeviceInternalId;
            public String JSONCustomerDetails;

            {
                super(r3, r4, r5, m1591c);
                this.JSONCustomerDetails = m4931a;
                this.DeviceInternalId = str;
            }
        }).m3305a(Schedulers.m3323b()).m3315a(new C1912d0(interfaceC2680h), new C1915e0(dataModelDTOs$CustomerAccountDTO, str, interfaceC2680h));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [pt.card4b.backendbeacons.RequestDTOs$RegistrationResetRequestDTO] */
    /* renamed from: a */
    public void m2063a(final String str, BackendListeners.InterfaceC2682j interfaceC2682j) {
        final String m1591c = GeneralUtils.m1591c();
        this.f8807b.m1980a((RequestDTOs$RegistrationResetRequestDTO) new RequestDTOs$DefaultRequestDTO(str, "App Anda", "NONE", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$RegistrationResetRequestDTO
            public String Email;

            {
                super(r2, r3, r4, m1591c);
                this.Email = str;
            }
        }).m3305a(Schedulers.m3323b()).m3315a(new C1925h0(interfaceC2682j), new C1928i0(str, interfaceC2682j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [pt.card4b.backendbeacons.RequestDTOs$CustomerUpdateRequestDTO] */
    /* renamed from: a */
    public void m2062a(final String str, DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO, BackendListeners.InterfaceC2680h<Boolean> interfaceC2680h) {
        if (this.f8809d == null) {
            interfaceC2680h.onError(DataModels.Error.loginRequired());
            return;
        }
        final String m4931a = new Gson().m4931a(dataModelDTOs$CustomerAccountDTO, DataModelDTOs$CustomerAccountDTO.class);
        final String m1591c = GeneralUtils.m1591c();
        this.f8807b.m1988a((RequestDTOs$CustomerUpdateRequestDTO) new RequestDTOs$DefaultRequestDTO(str, m4931a, "App Anda", "NONE", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$CustomerUpdateRequestDTO
            public String Email;
            public String JSONCustomerDetails;

            {
                super(r3, r4, r5, m1591c);
                this.Email = str;
                this.JSONCustomerDetails = m4931a;
            }
        }).m3305a(Schedulers.m3323b()).m3315a(new C1938l0(interfaceC2680h), new C1941m0(str, dataModelDTOs$CustomerAccountDTO, interfaceC2680h));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [pt.card4b.backendbeacons.RequestDTOs$CustomerUpdatePwdRequestDTO] */
    /* renamed from: a */
    public void m2071a(String str, String str2, String str3, BackendListeners.DefaultRequestListener defaultRequestListener) {
        if (this.f8809d == null) {
            defaultRequestListener.onError(DataModels.Error.loginRequired());
            return;
        }
        final String encodeToString = Base64.encodeToString(str.getBytes(), 2);
        final String encodeToString2 = Base64.encodeToString(str2.getBytes(), 2);
        final String encodeToString3 = Base64.encodeToString(str3.getBytes(), 2);
        final String m1591c = GeneralUtils.m1591c();
        this.f8807b.m1989a((RequestDTOs$CustomerUpdatePwdRequestDTO) new RequestDTOs$DefaultRequestDTO(encodeToString, encodeToString2, encodeToString3, "App Anda", "NORMAL_BASE64", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$CustomerUpdatePwdRequestDTO
            public String Email;
            public String NewPwd;
            public String Pwd;

            {
                super(r4, r5, r6, m1591c);
                this.Email = encodeToString;
                this.Pwd = encodeToString2;
                this.NewPwd = encodeToString3;
            }
        }).m3305a(Schedulers.m3323b()).m3315a(new C1944n0(defaultRequestListener), new C1947o0(str, str2, str3, defaultRequestListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [pt.card4b.backendbeacons.RequestDTOs$DeviceInstallRequestDTO] */
    /* renamed from: a */
    public final void m2074a(final String str, final String str2, final String str3, final String str4, final String str5, BackendListeners.InterfaceC2680h interfaceC2680h) {
        final String m1591c = GeneralUtils.m1591c();
        this.f8807b.m1987a((RequestDTOs$DeviceInstallRequestDTO) new RequestDTOs$DefaultRequestDTO(str, str2, str3, str4, str5, "App Anda", "NONE", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$DeviceInstallRequestDTO
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
                super(r6, r7, r8, m1591c);
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
        }).subscribeOn(Schedulers.m3323b()).subscribe(new C1951p0(interfaceC2680h), new C1953q0(str, str2, str3, str4, str5, interfaceC2680h));
    }

    /* renamed from: a */
    public void m2076a(String str, String str2, String str3, String str4, String str5, List<DataModelDTOs$StageInformationBeaconDTO> list, boolean z, int i, String str6, BackendListeners.InterfaceC2680h<String> interfaceC2680h) {
        if (this.f8809d == null) {
            interfaceC2680h.onError(DataModels.Error.loginRequired());
            return;
        }
        RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO = new RequestDTOs$StageRequestDTO(str, str2, null, str3, str4, str5, new Gson().m4931a(list, new C1956r0(this).getType()), Boolean.valueOf(z), i, str6, "App Anda", "NONE", "NONE", GeneralUtils.m1591c());
        if (!z) {
            AppLog.m2158a("COMM_HTTP", "BackendAPIController", "postStageStart", "Sending a start stage request...");
            this.f8807b.m1974b(requestDTOs$StageRequestDTO).m3305a(Schedulers.m3323b()).m3315a(new C1959s0(interfaceC2680h), new C1905b(str, str2, str3, str4, str5, list, z, i, str6, interfaceC2680h));
            return;
        }
        AppLog.m2158a("COMM_HTTP", "BackendAPIController", "postStageStart", "Sending a start stage (offline)");
        SharedPrefsController.m1540d().m1548a(new DataModels.C2706o(str, str2, null, str3, str4, str5, list, z, i, DataModels.C2706o.f10840D, str6));
        interfaceC2680h.mo334a(str);
    }

    /* renamed from: a */
    public void m2075a(String str, String str2, String str3, String str4, String str5, List<DataModelDTOs$StageInformationBeaconDTO> list, boolean z, int i, String str6, BackendListeners.InterfaceC2687o interfaceC2687o) {
        if (this.f8809d == null) {
            interfaceC2687o.onError(DataModels.Error.loginRequired());
        } else if (str != null && str2 != null && str3 != null && list != null) {
            AppLog.m2158a("LOGIC_BEACONS", "BackendAPIController", "postStageUpdate", "new StageRequest");
            SharedPrefsController.m1540d().m1548a(new DataModels.C2706o(str, str2, null, str3, str4, str5, list, z, i, DataModels.C2706o.f10841E, str6));
            interfaceC2687o.onSuccess();
        } else {
            interfaceC2687o.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "\"Stage Requests (update/finish): one of the parameters is null\"", ""));
        }
    }

    /* renamed from: a */
    public void m2077a(String str, String str2, String str3, String str4, String str5, String str6, List<DataModelDTOs$StageInformationBeaconDTO> list, boolean z, int i, String str7, BackendListeners.InterfaceC2687o interfaceC2687o) {
        if (this.f8809d == null) {
            interfaceC2687o.onError(DataModels.Error.loginRequired());
        } else if (str != null && str2 != null && str4 != null && str6 != null && list != null) {
            SharedPrefsController.m1540d().m1548a(new DataModels.C2706o(str, str2, str3, str4, str5, str6, list, z, i, DataModels.C2706o.f10842F, str7));
            interfaceC2687o.onSuccess();
        } else {
            interfaceC2687o.onError(new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, "Stage Requests (update/finish): one of the parameters is null", ""));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [pt.card4b.backendbeacons.RequestDTOs$OfflinePermitRequestDTO] */
    /* renamed from: a */
    public void m2070a(final String str, final String str2, final String str3, BackendListeners.InterfaceC2679g interfaceC2679g) {
        if (this.f8809d == null) {
            interfaceC2679g.onError(DataModels.Error.loginRequired());
            return;
        }
        AppLog.m2158a("COMM_HTTP", "BackendAPIController", "offlineStartPermitCheck", "Sending a start offline permit validation request...");
        BackendAPIServices backendAPIServices = this.f8807b;
        final String m1591c = GeneralUtils.m1591c();
        backendAPIServices.m1983a((RequestDTOs$OfflinePermitRequestDTO) new RequestDTOs$DefaultRequestDTO(str, str2, str3, "App Anda", "NONE", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$OfflinePermitRequestDTO
            public String CustomerId;
            public String Email;
            public String IMEI;

            {
                super(r4, r5, r6, m1591c);
                this.CustomerId = str;
                this.IMEI = str2;
                this.Email = str3;
            }
        }).m3305a(Schedulers.m3323b()).m3315a(new C1911d(interfaceC2679g), new C1917f(str, str2, str3, interfaceC2679g));
    }

    /* renamed from: a */
    public void m2078a(String str, String str2, File file, BackendListeners.InterfaceC2689q interfaceC2689q) {
        String str3;
        try {
            RequestBody m3245a = RequestBody.m3245a(MediaType.m2692a("multipart/form-data"), file);
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
            this.f8807b.m1994a(MultipartBody.C1814b.m2683a("log file", sb.toString(), m3245a)).m3305a(Schedulers.m3323b()).m3315a(new C1924h(this, interfaceC2689q), new C1930j(str, str2, file, interfaceC2689q));
        } catch (Throwable th) {
            if (interfaceC2689q != null) {
                interfaceC2689q.onError(GeneralUtils.m1599a(th));
            }
        }
    }

    /* renamed from: a */
    public void m2068a(String str, String str2, BackendListeners.InterfaceC2684l interfaceC2684l) {
        try {
            if (this.f8809d == null) {
                interfaceC2684l.onError(DataModels.Error.loginRequired());
                return;
            }
            this.f8807b.m1992a("NONE", Base64.encodeToString(str.getBytes(), 2), Base64.encodeToString(str2.getBytes(), 2), Base64.encodeToString(GeneralUtils.m1591c().getBytes(), 2)).m3305a(Schedulers.m3323b()).m3315a(new C1952q(interfaceC2684l), new C1960t(str, str2, interfaceC2684l));
        } catch (Throwable th) {
            AppLog.m2158a("COMM_HTTP", "BackendAPIController", "sendInvoiceEmail", "Exception: " + Log.getStackTraceString(th));
            if (interfaceC2684l != null) {
                interfaceC2684l.onError(GeneralUtils.m1599a(th));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [pt.card4b.backendbeacons.RequestDTOs$PaymentMethodRegistRequestDTO] */
    /* renamed from: a */
    public void m2067a(final String str, final String str2, BackendListeners.InterfaceC2685m interfaceC2685m) {
        try {
            if (this.f8809d == null) {
                interfaceC2685m.onError(DataModels.Error.loginRequired());
                return;
            }
            final String m1591c = GeneralUtils.m1591c();
            this.f8807b.m1982a((RequestDTOs$PaymentMethodRegistRequestDTO) new RequestDTOs$DefaultRequestDTO(str, str2, "App Anda", "NONE", "NONE", m1591c) { // from class: pt.card4b.backendbeacons.RequestDTOs$PaymentMethodRegistRequestDTO
                public String Email;
                public String PaymentGatewayCode;

                {
                    super(r3, r4, r5, m1591c);
                    this.Email = str;
                    this.PaymentGatewayCode = str2;
                }
            }).m3305a(Schedulers.m3323b()).m3315a(new C1962u(interfaceC2685m), new C1973x(str, str2, interfaceC2685m));
        } catch (Throwable th) {
            AppLog.m2158a("COMM_HTTP", "BackendAPIController", "setPaymentMethod", "Exception: " + Log.getStackTraceString(th));
            if (interfaceC2685m != null) {
                interfaceC2685m.onError(GeneralUtils.m1599a(th));
            }
        }
    }
}
