package pt.card4b.backendbeacons;

import android.support.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$TransportOperatorTypeDTO {
    public String Name;
    public int OperatorTypeRef;

    public DataModelDTOs$TransportOperatorTypeDTO(int i, String str) {
        this.OperatorTypeRef = i;
        this.Name = str;
    }

    public String getName() {
        return this.Name;
    }

    public int getOperatorTypeRef() {
        return this.OperatorTypeRef;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setOperatorTypeRef(int i) {
        this.OperatorTypeRef = i;
    }
}
