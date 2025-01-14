package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.util.Date;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$StopDTO {
    public int BeaconStopRef;
    public int IntermodalZoneRef;
    public String Name;
    public String StopCode;
    public int StopRef;
    public int TransportOperatorRef;
    public Date UpdateDate;

    public DataModelDTOs$StopDTO(String str, int i, String str2, int i2, int i3, Date date, int i4) {
        this.Name = str;
        this.StopRef = i;
        this.StopCode = str2;
        this.IntermodalZoneRef = i2;
        this.TransportOperatorRef = i3;
        this.UpdateDate = date;
        this.BeaconStopRef = i4;
    }

    public int getBeaconStopRef() {
        return this.BeaconStopRef;
    }

    public int getIntermodalZoneRef() {
        return this.IntermodalZoneRef;
    }

    public String getName() {
        return this.Name;
    }

    public String getStopCode() {
        return this.StopCode;
    }

    public int getStopRef() {
        return this.StopRef;
    }

    public int getTransportOperatorRef() {
        return this.TransportOperatorRef;
    }

    public Date getUpdateDate() {
        return this.UpdateDate;
    }

    public void setBeaconStopRef(int i) {
        this.BeaconStopRef = i;
    }

    public void setIntermodalZoneRef(int i) {
        this.IntermodalZoneRef = i;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setStopCode(String str) {
        this.StopCode = str;
    }

    public void setStopRef(int i) {
        this.StopRef = i;
    }

    public void setTransportOperatorRef(int i) {
        this.TransportOperatorRef = i;
    }

    public void setUpdateDate(Date date) {
        this.UpdateDate = date;
    }

    public DataModels.C2708q toStop() {
        return new DataModels.C2708q(getStopRef() + "|" + getTransportOperatorRef(), getStopRef(), getName(), getStopCode());
    }
}
