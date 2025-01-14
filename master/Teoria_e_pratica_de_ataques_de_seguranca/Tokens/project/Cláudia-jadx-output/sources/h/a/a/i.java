package h.a.a;

import e.e0;
import e.x;
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
/* compiled from: BackendAPIServices.java */
/* loaded from: classes.dex */
public interface i {
    @i.r.m("Handler/FileUpload.ashx")
    @i.r.j
    d.c.o<e0> a(@i.r.o x.b bVar);

    @i.r.e("customer/details/{CrtyptoTypeCode}/{email-base64}")
    d.c.o<ResponseDTOs$GetCustomerAccountResponseDTO> a(@i.r.q("CrtyptoTypeCode") String str, @i.r.q("email-base64") String str2, @i.r.r("LanguageCode") String str3);

    @i.r.e("invoice/send/{CrtyptoTypeCode}/{invoiceId-base64}/{email-base64}")
    d.c.o<ResponseDTOs$DefaultResponseDTO> a(@i.r.q("CrtyptoTypeCode") String str, @i.r.q("invoiceId-base64") String str2, @i.r.q("email-base64") String str3, @i.r.r("LanguageCode") String str4);

    @i.r.e("invoice/list/{CrtyptoTypeCode}/{email-base64}/{startDate-base64}/{endDate-base64}")
    d.c.o<ResponseDTOs$GetInvoicesResponseDTO> a(@i.r.q("CrtyptoTypeCode") String str, @i.r.q("email-base64") String str2, @i.r.q("startDate-base64") String str3, @i.r.q("endDate-base64") String str4, @i.r.r("LanguageCode") String str5);

    @i.r.e("stage/tariffs/{CrtyptoTypeCode}/{deviceInternalId-base64}/{email-base64}/{startDate-base64}/{endDate-base64}")
    d.c.o<ResponseDTOs$StageTariffsResponseDTO> a(@i.r.q("CrtyptoTypeCode") String str, @i.r.q("deviceInternalId-base64") String str2, @i.r.q("email-base64") String str3, @i.r.q("startDate-base64") String str4, @i.r.q("endDate-base64") String str5, @i.r.r("LanguageCode") String str6);

    @i.r.m("customer/update/pwd")
    d.c.o<ResponseDTOs$CustomerUpdatePwdResponseDTO> a(@i.r.a RequestDTOs$CustomerUpdatePwdRequestDTO requestDTOs$CustomerUpdatePwdRequestDTO);

    @i.r.m("customer/update")
    d.c.o<ResponseDTOs$CustomerUpdateResponseDTO> a(@i.r.a RequestDTOs$CustomerUpdateRequestDTO requestDTOs$CustomerUpdateRequestDTO);

    @i.r.m("application/event/regist")
    d.c.o<ResponseDTOs$EventRegistResponseDTO> a(@i.r.a RequestDTOs$EventRegistRequestDTO requestDTOs$EventRegistRequestDTO);

    @i.r.m("login/new")
    d.c.o<ResponseDTOs$LoginResponseDTO> a(@i.r.a RequestDTOs$LoginRequestDTO requestDTOs$LoginRequestDTO);

    @i.r.m("login/out")
    d.c.o<ResponseDTOs$DefaultResponseDTO> a(@i.r.a RequestDTOs$LogoutRequestDTO requestDTOs$LogoutRequestDTO);

    @i.r.m("stage/offlinePermit")
    d.c.o<ResponseDTOs$OfflinePermitResponseDTO> a(@i.r.a RequestDTOs$OfflinePermitRequestDTO requestDTOs$OfflinePermitRequestDTO);

    @i.r.m("payment/gateways/regist")
    d.c.o<ResponseDTOs$DefaultResponseDTO> a(@i.r.a RequestDTOs$PaymentMethodRegistRequestDTO requestDTOs$PaymentMethodRegistRequestDTO);

    @i.r.m("regist/new")
    d.c.o<ResponseDTOs$RegistrationNewResponseDTO> a(@i.r.a RequestDTOs$RegistrationNewRequestDTO requestDTOs$RegistrationNewRequestDTO);

    @i.r.m("regist/reset")
    d.c.o<ResponseDTOs$RegistrationResetResponseDTO> a(@i.r.a RequestDTOs$RegistrationResetRequestDTO requestDTOs$RegistrationResetRequestDTO);

    @i.r.m("login/renew")
    d.c.o<ResponseDTOs$RenewLoginResponseDTO> a(@i.r.a RequestDTOs$RenewRequestDTO requestDTOs$RenewRequestDTO);

    @i.r.m("session/start")
    d.c.o<ResponseDTOs$SessionResponseDTO> a(@i.r.a RequestDTOs$SessionRequestDTO requestDTOs$SessionRequestDTO);

    @i.r.m("stage/update")
    d.c.o<ResponseDTOs$StageResponseDTO> a(@i.r.a RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO);

    @i.r.m("device/install")
    d.c.u<ResponseDTOs$DeviceInstallResponseDTO> a(@i.r.a RequestDTOs$DeviceInstallRequestDTO requestDTOs$DeviceInstallRequestDTO);

    @i.r.e("application/data/get/{CrtyptoTypeCode}/{lastUpdate-base64}")
    d.c.o<ResponseDTOs$GetApplicationDataResponseDTO> b(@i.r.q("CrtyptoTypeCode") String str, @i.r.q("lastUpdate-base64") String str2, @i.r.r("LanguageCode") String str3);

    @i.r.e("stage/historic/{CrtyptoTypeCode}/{deviceInternalId-base64}/{email-base64}/{startDate-base64}/{endDate-base64}")
    d.c.o<ResponseDTOs$StageHistoryResponseDTO> b(@i.r.q("CrtyptoTypeCode") String str, @i.r.q("deviceInternalId-base64") String str2, @i.r.q("email-base64") String str3, @i.r.q("startDate-base64") String str4, @i.r.q("endDate-base64") String str5, @i.r.r("LanguageCode") String str6);

    @i.r.m("stage/start")
    d.c.o<ResponseDTOs$StageResponseDTO> b(@i.r.a RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO);

    @i.r.e("payment/gateways/get/{CrtyptoTypeCode}/{email-base64}")
    d.c.o<ResponseDTOs$PaymentMethodResponseDTO> c(@i.r.q("CrtyptoTypeCode") String str, @i.r.q("email-base64") String str2, @i.r.r("LanguageCode") String str3);

    @i.r.m("stage/finish")
    d.c.o<ResponseDTOs$StageResponseDTO> c(@i.r.a RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO);
}
