package pt.card4b.backendbeacons;

import android.support.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$BillingInformationDTO {
    public String Address;
    public String City;
    public DataModelDTOs$CountryDTO CountryDetails;

    /* renamed from: ID */
    public String f10716ID;
    public String Name;
    public String NotifyEmail;
    public String PostalCode;
    public String str_FiscalNumber;

    public DataModelDTOs$BillingInformationDTO(String str, String str2, String str3, String str4, String str5, String str6, DataModelDTOs$CountryDTO dataModelDTOs$CountryDTO, String str7) {
        this.f10716ID = str;
        this.Name = str2;
        this.Address = str3;
        this.City = str4;
        this.PostalCode = str5;
        this.str_FiscalNumber = str6;
        this.CountryDetails = dataModelDTOs$CountryDTO;
        this.NotifyEmail = str7;
    }

    public static /* synthetic */ String access$000(DataModelDTOs$BillingInformationDTO dataModelDTOs$BillingInformationDTO) {
        return dataModelDTOs$BillingInformationDTO.NotifyEmail;
    }

    public String getAddress() {
        return this.Address;
    }

    public String getCity() {
        return this.City;
    }

    public DataModelDTOs$CountryDTO getCountryDetails() {
        return this.CountryDetails;
    }

    public String getFiscalNumber() {
        return this.str_FiscalNumber;
    }

    public String getID() {
        return this.f10716ID;
    }

    public String getName() {
        return this.Name;
    }

    public String getNotifyEmail() {
        return this.NotifyEmail;
    }

    public String getPostalCode() {
        return this.PostalCode;
    }

    public void setAddress(String str) {
        this.Address = str;
    }

    public void setCity(String str) {
        this.City = str;
    }

    public void setCountryDetails(DataModelDTOs$CountryDTO dataModelDTOs$CountryDTO) {
        this.CountryDetails = dataModelDTOs$CountryDTO;
    }

    public void setFiscalNumber(String str) {
        this.str_FiscalNumber = str;
    }

    public void setID(String str) {
        this.f10716ID = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setNotifyEmail(String str) {
        this.NotifyEmail = str;
    }

    public void setPostalCode(String str) {
        this.PostalCode = str;
    }
}
