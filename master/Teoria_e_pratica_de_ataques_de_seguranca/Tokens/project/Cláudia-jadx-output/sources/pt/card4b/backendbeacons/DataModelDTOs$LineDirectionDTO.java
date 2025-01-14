package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$LineDirectionDTO {
    public int LineDirectionRef;
    public String Name;
    public int TransportOperatorRef;

    public DataModelDTOs$LineDirectionDTO(String str, int i2, int i3) {
        this.Name = str;
        this.LineDirectionRef = i2;
        this.TransportOperatorRef = i3;
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

    public void setLineDirectionRef(int i2) {
        this.LineDirectionRef = i2;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setTransportOperatorRef(int i2) {
        this.TransportOperatorRef = i2;
    }

    public DataModels.k toLineOrientation() {
        return new DataModels.k(getLineDirectionRef() + "|" + getTransportOperatorRef(), getLineDirectionRef(), getName(), getTransportOperatorRef());
    }
}
