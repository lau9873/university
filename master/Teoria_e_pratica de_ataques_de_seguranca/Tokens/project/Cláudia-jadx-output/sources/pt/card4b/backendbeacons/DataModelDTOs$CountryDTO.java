package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$CountryDTO {
    public String Code;
    public String Id;
    public String Name;

    public DataModelDTOs$CountryDTO(String str, String str2, String str3) {
        this.Id = str;
        this.Code = str2;
        this.Name = str3;
    }

    public String getCode() {
        return this.Code;
    }

    public String getId() {
        return this.Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setCode(String str) {
        this.Code = str;
    }

    public void setId(String str) {
        this.Id = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public DataModels.Country toCountry() {
        return new DataModels.Country(getId(), getCode(), getName());
    }
}
