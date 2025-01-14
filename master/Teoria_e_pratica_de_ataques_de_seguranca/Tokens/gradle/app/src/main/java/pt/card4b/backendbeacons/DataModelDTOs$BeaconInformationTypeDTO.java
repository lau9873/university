package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$BeaconInformationTypeDTO {
    public String Code;

    /* renamed from: Id */
    public String f10715Id;
    public String Name;

    public DataModelDTOs$BeaconInformationTypeDTO(String str, String str2, String str3) {
        this.f10715Id = str;
        this.Name = str2;
        this.Code = str3;
    }

    public String getCode() {
        return this.Code;
    }

    public String getId() {
        return this.f10715Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setCode(String str) {
        this.Code = str;
    }

    public void setId(String str) {
        this.f10715Id = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public DataModels.C2695d toBeaconInformationType() {
        return new DataModels.C2695d(getId(), getName(), getCode());
    }
}
