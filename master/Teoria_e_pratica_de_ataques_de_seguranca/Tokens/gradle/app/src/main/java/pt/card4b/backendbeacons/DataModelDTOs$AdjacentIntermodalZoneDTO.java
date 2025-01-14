package pt.card4b.backendbeacons;

import android.support.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$AdjacentIntermodalZoneDTO {
    public int AdjacentZoneRef;
    public int IntermodalZoneRef;
    public int TransportOperatorRef;

    public DataModelDTOs$AdjacentIntermodalZoneDTO(int i, int i2, int i3) {
        this.TransportOperatorRef = i;
        this.IntermodalZoneRef = i2;
        this.AdjacentZoneRef = i3;
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

    public void setAdjacentZoneRef(int i) {
        this.AdjacentZoneRef = i;
    }

    public void setIntermodalZoneRef(int i) {
        this.IntermodalZoneRef = i;
    }

    public void setTransportOperatorRef(int i) {
        this.TransportOperatorRef = i;
    }
}
