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

    public DataModelDTOs$TransportTitleDTO(int i, String str, int i2, int i3, DataModelDTOs$TransportTitleGroupDTO dataModelDTOs$TransportTitleGroupDTO) {
        this.TitleRef = i;
        this.TitleName = str;
        this.TitleNumberZones = i2;
        this.TitleTripDuration = i3;
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

    public void setTitleNumberZones(int i) {
        this.TitleNumberZones = i;
    }

    public void setTitleRef(int i) {
        this.TitleRef = i;
    }

    public void setTitleTripDuration(int i) {
        this.TitleTripDuration = i;
    }

    public void setTransportTitleGroup(DataModelDTOs$TransportTitleGroupDTO dataModelDTOs$TransportTitleGroupDTO) {
        this.TransportTitleGroup = dataModelDTOs$TransportTitleGroupDTO;
    }
}
