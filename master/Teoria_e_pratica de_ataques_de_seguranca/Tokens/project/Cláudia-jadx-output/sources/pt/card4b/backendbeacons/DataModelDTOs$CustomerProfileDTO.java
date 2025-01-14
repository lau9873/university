package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$CustomerProfileDTO {
    public String ID;
    public String Name;
    public int Ref;

    public DataModelDTOs$CustomerProfileDTO(String str, int i2, String str2) {
        this.ID = str;
        this.Ref = i2;
        this.Name = str2;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.Name;
    }

    public int getRef() {
        return this.Ref;
    }

    public void setID(String str) {
        this.ID = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setRef(int i2) {
        this.Ref = i2;
    }

    public DataModels.CustomerProfile toCustomerProfile() {
        return new DataModels.CustomerProfile(getID(), getRef(), getName());
    }
}
