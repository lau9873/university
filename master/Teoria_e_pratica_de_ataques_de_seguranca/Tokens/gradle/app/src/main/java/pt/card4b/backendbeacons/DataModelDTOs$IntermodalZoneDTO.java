package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$IntermodalZoneDTO {
    public String Name;
    public String UpdateDate;
    public int ZoneRef;

    public DataModelDTOs$IntermodalZoneDTO(String str, int i, String str2) {
        this.Name = str;
        this.ZoneRef = i;
        this.UpdateDate = str2;
    }

    public String getName() {
        return this.Name;
    }

    public String getUpdateDate() {
        return this.UpdateDate;
    }

    public int getZoneRef() {
        return this.ZoneRef;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setUpdateDate(String str) {
        this.UpdateDate = str;
    }

    public void setZoneRef(int i) {
        this.ZoneRef = i;
    }

    public DataModels.C2709r toZone() {
        return new DataModels.C2709r(getZoneRef(), getName());
    }
}
