package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$AdjacentIntermodalZoneDTO {
    public int AdjacentZoneRef;
    public int IntermodalZoneRef;
    public int TransportOperatorRef;

    public DataModelDTOs$AdjacentIntermodalZoneDTO(int i2, int i3, int i4) {
        this.TransportOperatorRef = i2;
        this.IntermodalZoneRef = i3;
        this.AdjacentZoneRef = i4;
    }

    public int getAdjacentZoneRef() {
        return this.AdjacentZoneRef;
    }

    public int getIntermodalZoneRef() {
        return this.IntermodalZoneRef;
    }

    public int getTransportOperatorRef() {
        return this.TransportOperatorRef;
    }

    public void setAdjacentZoneRef(int i2) {
        this.AdjacentZoneRef = i2;
    }

    public void setIntermodalZoneRef(int i2) {
        this.IntermodalZoneRef = i2;
    }

    public void setTransportOperatorRef(int i2) {
        this.TransportOperatorRef = i2;
    }
}
