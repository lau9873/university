package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$ConfigurationDTO {
    public boolean Active;
    public String Code;
    public String CustomerId;
    public String Name;
    public String UpdateDate;
    public String Value;

    public DataModelDTOs$ConfigurationDTO(String str, String str2, boolean z, String str3, String str4, String str5) {
        this.Name = str;
        this.Value = str2;
        this.Active = z;
        this.CustomerId = str3;
        this.Code = str4;
        this.UpdateDate = str5;
    }

    public boolean getActive() {
        return this.Active;
    }

    public String getCode() {
        return this.Code;
    }

    public String getCustomerId() {
        return this.CustomerId;
    }

    public String getName() {
        return this.Name;
    }

    public String getUpdateDate() {
        return this.UpdateDate;
    }

    public String getValue() {
        return this.Value;
    }

    public void setActive(boolean z) {
        this.Active = z;
    }

    public void setCode(String str) {
        this.Code = str;
    }

    public void setCustomerId(String str) {
        this.CustomerId = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setUpdateDate(String str) {
        this.UpdateDate = str;
    }

    public void setValue(String str) {
        this.Value = str;
    }

    public DataModels.C2697f toConfiguration() {
        return new DataModels.C2697f(getName(), getValue(), getActive(), getCustomerId(), getCode());
    }
}
