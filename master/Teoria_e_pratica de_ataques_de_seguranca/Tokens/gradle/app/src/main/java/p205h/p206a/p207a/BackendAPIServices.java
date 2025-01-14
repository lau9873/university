package p205h.p206a.p207a;

import p136d.p153c.Observable;
import p136d.p153c.Single;
import p181e.MultipartBody;
import p181e.ResponseBody;
import p220i.p225r.Body;
import p220i.p225r.GET;
import p220i.p225r.Multipart;
import p220i.p225r.POST;
import p220i.p225r.Part;
import p220i.p225r.Path;
import p220i.p225r.Query;
import pt.card4b.backendbeacons.RequestDTOs$CustomerUpdatePwdRequestDTO;
import pt.card4b.backendbeacons.RequestDTOs$CustomerUpdateRequestDTO;
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

/* renamed from: h.a.a.i */
/* loaded from: classes.dex */
public interface BackendAPIServices {
    @POST("Handler/FileUpload.ashx")
    @Multipart
    /* renamed from: a */
    Observable<ResponseBody> m1994a(@Part MultipartBody.C1814b c1814b);

    @GET("customer/details/{CrtyptoTypeCode}/{email-base64}")
    /* renamed from: a */
    Observable<ResponseDTOs$GetCustomerAccountResponseDTO> m1993a(@Path("CrtyptoTypeCode") String str, @Path("email-base64") String str2, @Query("LanguageCode") String str3);

    @GET("invoice/send/{CrtyptoTypeCode}/{invoiceId-base64}/{email-base64}")
    /* renamed from: a */
    Observable<ResponseDTOs$DefaultResponseDTO> m1992a(@Path("CrtyptoTypeCode") String str, @Path("invoiceId-base64") String str2, @Path("email-base64") String str3, @Query("LanguageCode") String str4);

    @GET("invoice/list/{CrtyptoTypeCode}/{email-base64}/{startDate-base64}/{endDate-base64}")
    /* renamed from: a */
    Observable<ResponseDTOs$GetInvoicesResponseDTO> m1991a(@Path("CrtyptoTypeCode") String str, @Path("email-base64") String str2, @Path("startDate-base64") String str3, @Path("endDate-base64") String str4, @Query("LanguageCode") String str5);

    @GET("stage/tariffs/{CrtyptoTypeCode}/{deviceInternalId-base64}/{email-base64}/{startDate-base64}/{endDate-base64}")
    /* renamed from: a */
    Observable<ResponseDTOs$StageTariffsResponseDTO> m1990a(@Path("CrtyptoTypeCode") String str, @Path("deviceInternalId-base64") String str2, @Path("email-base64") String str3, @Path("startDate-base64") String str4, @Path("endDate-base64") String str5, @Query("LanguageCode") String str6);

    @POST("customer/update/pwd")
    /* renamed from: a */
    Observable<ResponseDTOs$CustomerUpdatePwdResponseDTO> m1989a(@Body RequestDTOs$CustomerUpdatePwdRequestDTO requestDTOs$CustomerUpdatePwdRequestDTO);

    @POST("customer/update")
    /* renamed from: a */
    Observable<ResponseDTOs$CustomerUpdateResponseDTO> m1988a(@Body RequestDTOs$CustomerUpdateRequestDTO requestDTOs$CustomerUpdateRequestDTO);

    @POST("application/event/regist")
    /* renamed from: a */
    Observable<ResponseDTOs$EventRegistResponseDTO> m1986a(@Body RequestDTOs$EventRegistRequestDTO requestDTOs$EventRegistRequestDTO);

    @POST("login/new")
    /* renamed from: a */
    Observable<ResponseDTOs$LoginResponseDTO> m1985a(@Body RequestDTOs$LoginRequestDTO requestDTOs$LoginRequestDTO);

    @POST("login/out")
    /* renamed from: a */
    Observable<ResponseDTOs$DefaultResponseDTO> m1984a(@Body RequestDTOs$LogoutRequestDTO requestDTOs$LogoutRequestDTO);

    @POST("stage/offlinePermit")
    /* renamed from: a */
    Observable<ResponseDTOs$OfflinePermitResponseDTO> m1983a(@Body RequestDTOs$OfflinePermitRequestDTO requestDTOs$OfflinePermitRequestDTO);

    @POST("payment/gateways/regist")
    /* renamed from: a */
    Observable<ResponseDTOs$DefaultResponseDTO> m1982a(@Body RequestDTOs$PaymentMethodRegistRequestDTO requestDTOs$PaymentMethodRegistRequestDTO);

    @POST("regist/new")
    /* renamed from: a */
    Observable<ResponseDTOs$RegistrationNewResponseDTO> m1981a(@Body RequestDTOs$RegistrationNewRequestDTO requestDTOs$RegistrationNewRequestDTO);

    @POST("regist/reset")
    /* renamed from: a */
    Observable<ResponseDTOs$RegistrationResetResponseDTO> m1980a(@Body RequestDTOs$RegistrationResetRequestDTO requestDTOs$RegistrationResetRequestDTO);

    @POST("login/renew")
    /* renamed from: a */
    Observable<ResponseDTOs$RenewLoginResponseDTO> m1979a(@Body RequestDTOs$RenewRequestDTO requestDTOs$RenewRequestDTO);

    @POST("session/start")
    /* renamed from: a */
    Observable<ResponseDTOs$SessionResponseDTO> m1978a(@Body RequestDTOs$SessionRequestDTO requestDTOs$SessionRequestDTO);

    @POST("stage/update")
    /* renamed from: a */
    Observable<ResponseDTOs$StageResponseDTO> m1977a(@Body RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO);

    @POST("device/install")
    /* renamed from: a */
    Single<ResponseDTOs$DeviceInstallResponseDTO> m1987a(@Body RequestDTOs$DeviceInstallRequestDTO requestDTOs$DeviceInstallRequestDTO);

    @GET("application/data/get/{CrtyptoTypeCode}/{lastUpdate-base64}")
    /* renamed from: b */
    Observable<ResponseDTOs$GetApplicationDataResponseDTO> m1976b(@Path("CrtyptoTypeCode") String str, @Path("lastUpdate-base64") String str2, @Query("LanguageCode") String str3);

    @GET("stage/historic/{CrtyptoTypeCode}/{deviceInternalId-base64}/{email-base64}/{startDate-base64}/{endDate-base64}")
    /* renamed from: b */
    Observable<ResponseDTOs$StageHistoryResponseDTO> m1975b(@Path("CrtyptoTypeCode") String str, @Path("deviceInternalId-base64") String str2, @Path("email-base64") String str3, @Path("startDate-base64") String str4, @Path("endDate-base64") String str5, @Query("LanguageCode") String str6);

    @POST("stage/start")
    /* renamed from: b */
    Observable<ResponseDTOs$StageResponseDTO> m1974b(@Body RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO);

    @GET("payment/gateways/get/{CrtyptoTypeCode}/{email-base64}")
    /* renamed from: c */
    Observable<ResponseDTOs$PaymentMethodResponseDTO> m1973c(@Path("CrtyptoTypeCode") String str, @Path("email-base64") String str2, @Query("LanguageCode") String str3);

    @POST("stage/finish")
    /* renamed from: c */
    Observable<ResponseDTOs$StageResponseDTO> m1972c(@Body RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO);
}
