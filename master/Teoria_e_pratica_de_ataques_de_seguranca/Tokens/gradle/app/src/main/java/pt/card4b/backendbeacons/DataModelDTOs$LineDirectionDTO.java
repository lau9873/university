package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$LineDirectionDTO {
    public int LineDirectionRef;
    public String Name;
    public int TransportOperatorRef;

    public DataModelDTOs$LineDirectionDTO(String str, int i, int i2) {
        this.Name = str;
        this.LineDirectionRef = i;
        this.TransportOperatorRef = i2;
    }

    public int getLineDirectionRef() {
        return this.LineDirectionRef;
    }

    public String getName() {
        return this.Name;
    }

    public int getTransportOperatorRef() {
        return this.TransportOperatorRef;
    }

    public void setLineDirectionRef(int i) {
        this.LineDirectionRef = i;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setTransportOperatorRef(int i) {
        this.TransportOperatorRef = i;
    }

    public DataModels.C2702k toLineOrientation() {
        return new DataModels.C2702k(getLineDirectionRef() + "|" + getTransportOperatorRef(), getLineDirectionRef(), getName(), getTransportOperatorRef());
    }
}
