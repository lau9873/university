package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$TransportTitleDTO {
    public String TitleName;
    public int TitleNumberZones;
    public int TitleRef;
    public int TitleTripDuration;
    public DataModelDTOs$TransportTitleGroupDTO TransportTitleGroup;

    public DataModelDTOs$TransportTitleDTO(int i2, String str, int i3, int i4, DataModelDTOs$TransportTitleGroupDTO dataModelDTOs$TransportTitleGroupDTO) {
        this.TitleRef = i2;
        this.TitleName = str;
        this.TitleNumberZones = i3;
        this.TitleTripDuration = i4;
        this.TransportTitleGroup = dataModelDTOs$TransportTitleGroupDTO;
    }

    public String getTitleName() {
        return this.TitleName;
    }

    public int getTitleNumberZones() {
        return this.TitleNumberZones;
    }

    public int getTitleRef() {
        return this.TitleRef;
    }

    public int getTitleTripDuration() {
        return this.TitleTripDuration;
    }

    public DataModelDTOs$TransportTitleGroupDTO getTransportTitleGroup() {
        return this.TransportTitleGroup;
    }

    public void setTitleName(String str) {
        this.TitleName = str;
    }

    public void setTitleNumberZones(int i2) {
        this.TitleNumberZones = i2;
    }

    public void setTitleRef(int i2) {
        this.TitleRef = i2;
    }

    public void setTitleTripDuration(int i2) {
        this.TitleTripDuration = i2;
    }

    public void setTransportTitleGroup(DataModelDTOs$TransportTitleGroupDTO dataModelDTOs$TransportTitleGroupDTO) {
        this.TransportTitleGroup = dataModelDTOs$TransportTitleGroupDTO;
    }
}
