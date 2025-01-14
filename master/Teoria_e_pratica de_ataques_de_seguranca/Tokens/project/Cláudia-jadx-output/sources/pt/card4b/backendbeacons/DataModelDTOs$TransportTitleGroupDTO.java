package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$TransportTitleGroupDTO {
    public String TitleGroupName;
    public int TitleGroupRef;

    public DataModelDTOs$TransportTitleGroupDTO(int i2, String str) {
        this.TitleGroupRef = i2;
        this.TitleGroupName = str;
    }

    public String getTitleGroupName() {
        return this.TitleGroupName;
    }

    public int getTitleGroupRef() {
        return this.TitleGroupRef;
    }

    public void setTitleGroupName(String str) {
        this.TitleGroupName = str;
    }

    public void setTitleGroupRef(int i2) {
        this.TitleGroupRef = i2;
    }
}
