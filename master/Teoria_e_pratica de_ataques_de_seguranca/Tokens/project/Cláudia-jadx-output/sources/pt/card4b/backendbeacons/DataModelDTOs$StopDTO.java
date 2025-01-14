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

    public DataModelDTOs$StopDTO(String str, int i2, String str2, int i3, int i4, Date date, int i5) {
        this.Name = str;
        this.StopRef = i2;
        this.StopCode = str2;
        this.IntermodalZoneRef = i3;
        this.TransportOperatorRef = i4;
        this.UpdateDate = date;
        this.BeaconStopRef = i5;
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

    public void setBeaconStopRef(int i2) {
        this.BeaconStopRef = i2;
    }

    public void setIntermodalZoneRef(int i2) {
        this.IntermodalZoneRef = i2;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setStopCode(String str) {
        this.StopCode = str;
    }

    public void setStopRef(int i2) {
        this.StopRef = i2;
    }

    public void setTransportOperatorRef(int i2) {
        this.TransportOperatorRef = i2;
    }

    public void setUpdateDate(Date date) {
        this.UpdateDate = date;
    }

    public DataModels.q toStop() {
        return new DataModels.q(getStopRef() + "|" + getTransportOperatorRef(), getStopRef(), getName(), getStopCode());
    }
}
