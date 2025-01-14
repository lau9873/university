package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.util.ArrayList;
import java.util.List;
import p205h.p206a.p207a.Consuela;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$CustomerAccountDTO {
    public DataModelDTOs$AccountPaymentEntityDTO AccountPaymentEntityDetails;
    public DataModelDTOs$AccountStatusDTO AccountStatusDetails;
    public String Address;
    public DataModelDTOs$BillingInformationDTO BillingInformationDetails;
    public String City;
    public DataModelDTOs$PaymentMethodDTO CustomerPaymentMethod;
    public List<DataModelDTOs$CustomerProfileDetailDTO> CustomerProfilesDetails;
    public String Email;

    /* renamed from: ID */
    public String f10718ID;
    public String IdentificationNumber;
    public String Name;
    public String Password;
    public String Phone;
    public String PhotoBase64;
    public String PostalCode;
    public String TIPCode;
    public String str_FiscalNumber;

    public DataModelDTOs$CustomerAccountDTO(DataModels.UserAccountInfo userAccountInfo) {
        this.f10718ID = String.valueOf(userAccountInfo.getId());
        this.Name = userAccountInfo.getName();
        this.Address = userAccountInfo.getAddress();
        this.City = null;
        this.Email = userAccountInfo.getEmail();
        this.PostalCode = userAccountInfo.getPostalcode();
        this.str_FiscalNumber = userAccountInfo.getFiscalnumber();
        this.IdentificationNumber = userAccountInfo.getIdnumber();
        this.TIPCode = userAccountInfo.getTipCode();
        this.Phone = userAccountInfo.getPhonenumber();
        this.PhotoBase64 = userAccountInfo.getPhoto();
        this.BillingInformationDetails = userAccountInfo.getBillingInfo() != null ? new DataModelDTOs$BillingInformationDTO(userAccountInfo.getBillingInfo().getID(), userAccountInfo.getBillingInfo().getName(), userAccountInfo.getBillingInfo().getAddress(), userAccountInfo.getBillingInfo().getCity(), userAccountInfo.getBillingInfo().getPostalCode(), userAccountInfo.getBillingInfo().getFiscalNumber(), userAccountInfo.getBillingInfo().getCountry() != null ? new DataModelDTOs$CountryDTO(userAccountInfo.getBillingInfo().getCountry().getId(), userAccountInfo.getBillingInfo().getCountry().getCode(), userAccountInfo.getBillingInfo().getCountry().getName()) : null, userAccountInfo.getBillingInfo().getNotifyEmail()) : null;
        if (userAccountInfo.getProfileInfo() != null) {
            this.CustomerProfilesDetails = new ArrayList();
            for (DataModels.UserProfileInfo userProfileInfo : userAccountInfo.getProfileInfo()) {
                if (userProfileInfo.getID() != null) {
                    DataModels.CustomerProfile customerProfile = Consuela.m1790k().m1794i().get(userProfileInfo.getProfileId());
                    this.CustomerProfilesDetails.add(new DataModelDTOs$CustomerProfileDetailDTO(userProfileInfo.getID(), userProfileInfo.getProfileId(), customerProfile != null ? customerProfile.getRef() : 0, userProfileInfo.getStartDate(), userProfileInfo.getEndDate()));
                }
            }
        }
    }

    public DataModelDTOs$AccountPaymentEntityDTO getAccountPaymentEntityDetails() {
        return this.AccountPaymentEntityDetails;
    }

    public DataModelDTOs$AccountStatusDTO getAccountStatusDetails() {
        return this.AccountStatusDetails;
    }

    public String getAddress() {
        return this.Address;
    }

    public DataModelDTOs$BillingInformationDTO getBillingInformationDetails() {
        return this.BillingInformationDetails;
    }

    public String getCity() {
        return this.City;
    }

    public DataModelDTOs$PaymentMethodDTO getCustomerPaymentMethod() {
        return this.CustomerPaymentMethod;
    }

    public List<DataModelDTOs$CustomerProfileDetailDTO> getCustomerProfilesDetails() {
        return this.CustomerProfilesDetails;
    }

    public String getEmail() {
        return this.Email;
    }

    public String getFiscalNumber() {
        return this.str_FiscalNumber;
    }

    public String getID() {
        return this.f10718ID;
    }

    public String getIdentificationNumber() {
        return this.IdentificationNumber;
    }

    public String getName() {
        return this.Name;
    }

    public String getPhone() {
        return this.Phone;
    }

    public String getPhotoBase64() {
        return this.PhotoBase64;
    }

    public String getPostalCode() {
        return this.PostalCode;
    }

    public String getTIPCode() {
        return this.TIPCode;
    }

    public void setAccountPaymentEntityDetails(DataModelDTOs$AccountPaymentEntityDTO dataModelDTOs$AccountPaymentEntityDTO) {
        this.AccountPaymentEntityDetails = dataModelDTOs$AccountPaymentEntityDTO;
    }

    public void setAccountStatusDetails(DataModelDTOs$AccountStatusDTO dataModelDTOs$AccountStatusDTO) {
        this.AccountStatusDetails = dataModelDTOs$AccountStatusDTO;
    }

    public void setAddress(String str) {
        this.Address = str;
    }

    public void setBillingInformationDetails(DataModelDTOs$BillingInformationDTO dataModelDTOs$BillingInformationDTO) {
        this.BillingInformationDetails = dataModelDTOs$BillingInformationDTO;
    }

    public void setCity(String str) {
        this.City = str;
    }

    public void setCustomerPaymentMethod(DataModelDTOs$PaymentMethodDTO dataModelDTOs$PaymentMethodDTO) {
        this.CustomerPaymentMethod = dataModelDTOs$PaymentMethodDTO;
    }

    public void setCustomerProfilesDetails(List<DataModelDTOs$CustomerProfileDetailDTO> list) {
        this.CustomerProfilesDetails = list;
    }

    public void setEmail(String str) {
        this.Email = str;
    }

    public void setFiscalNumber(String str) {
        this.str_FiscalNumber = str;
    }

    public void setID(String str) {
        this.f10718ID = str;
    }

    public void setIdentificationNumber(String str) {
        this.IdentificationNumber = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setPhone(String str) {
        this.Phone = str;
    }

    public void setPhotoBase64(String str) {
        this.PhotoBase64 = str;
    }

    public void setPostalCode(String str) {
        this.PostalCode = str;
    }

    public void setTIPCode(String str) {
        this.TIPCode = str;
    }

    public DataModels.UserAccountInfo toAccountInfo() {
        DataModels.UserBillingInfo userBillingInfo;
        ArrayList arrayList;
        DataModels.PaymentMethod paymentMethod = null;
        if (getBillingInformationDetails() == null || getBillingInformationDetails().getID() == null) {
            userBillingInfo = null;
        } else {
            userBillingInfo = new DataModels.UserBillingInfo(getBillingInformationDetails().getID(), getBillingInformationDetails().getName(), getBillingInformationDetails().getAddress(), getBillingInformationDetails().getCity(), getBillingInformationDetails().getPostalCode(), getBillingInformationDetails().getFiscalNumber(), (getBillingInformationDetails().getCountryDetails() == null || getBillingInformationDetails().getCountryDetails().getId() == null) ? null : new DataModels.Country(getBillingInformationDetails().getCountryDetails().getId(), getBillingInformationDetails().getCountryDetails().getCode(), getBillingInformationDetails().getCountryDetails().getName()), DataModelDTOs$BillingInformationDTO.access$000(getBillingInformationDetails()));
        }
        if (getCustomerProfilesDetails() == null || getCustomerProfilesDetails().size() <= 0) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (DataModelDTOs$CustomerProfileDetailDTO dataModelDTOs$CustomerProfileDetailDTO : getCustomerProfilesDetails()) {
                if (dataModelDTOs$CustomerProfileDetailDTO.getID() != null) {
                    DataModels.CustomerProfile customerProfile = Consuela.m1790k().m1794i().get(dataModelDTOs$CustomerProfileDetailDTO.getProfileId());
                    arrayList2.add(new DataModels.UserProfileInfo(dataModelDTOs$CustomerProfileDetailDTO.getID(), dataModelDTOs$CustomerProfileDetailDTO.getProfileId(), customerProfile != null ? customerProfile.getName() : null, dataModelDTOs$CustomerProfileDetailDTO.getStartDate(), dataModelDTOs$CustomerProfileDetailDTO.getEndDate()));
                }
            }
            arrayList = arrayList2;
        }
        if (getCustomerPaymentMethod() != null && getCustomerPaymentMethod().getRefCode() != null) {
            paymentMethod = getCustomerPaymentMethod().toPaymentMethod();
        }
        DataModels.UserAccountInfo userAccountInfo = new DataModels.UserAccountInfo(getID(), getName(), getEmail(), getAddress(), getPhone(), getPostalCode(), getFiscalNumber(), getIdentificationNumber(), getTIPCode(), getPhotoBase64(), userBillingInfo, arrayList, paymentMethod);
        if (getAccountPaymentEntityDetails() != null) {
            userAccountInfo.setAccountPaymentEntity(new DataModels.AccountPaymentEntity(getAccountPaymentEntityDetails().getEntityStartDate(), getAccountPaymentEntityDetails().getEntityEndDate(), getAccountPaymentEntityDetails().getCustomerStartDate(), getAccountPaymentEntityDetails().getCustomerEndDate(), getAccountPaymentEntityDetails().getEntityId(), getAccountPaymentEntityDetails().getEntityName()));
        }
        return userAccountInfo;
    }

    public DataModels.User toUser() {
        return new DataModels.User(getID(), getName(), getEmail(), getPhone(), getPhotoBase64(), Boolean.valueOf((getCustomerPaymentMethod() == null || getCustomerPaymentMethod().getRefCode() == null) ? false : true));
    }

    public DataModelDTOs$CustomerAccountDTO(DataModels.UserAccountInfo userAccountInfo, String str) {
        this(userAccountInfo);
        this.Password = str;
    }
}
