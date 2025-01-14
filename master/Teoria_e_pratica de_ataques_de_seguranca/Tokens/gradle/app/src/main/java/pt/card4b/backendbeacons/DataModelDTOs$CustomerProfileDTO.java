package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$CustomerProfileDTO {

    /* renamed from: ID */
    public String f10719ID;
    public String Name;
    public int Ref;

    public DataModelDTOs$CustomerProfileDTO(String str, int i, String str2) {
        this.f10719ID = str;
        this.Ref = i;
        this.Name = str2;
    }

    public String getID() {
        return this.f10719ID;
    }

    public String getName() {
        return this.Name;
    }

    public int getRef() {
        return this.Ref;
    }

    public void setID(String str) {
        this.f10719ID = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setRef(int i) {
        this.Ref = i;
    }

    public DataModels.CustomerProfile toCustomerProfile() {
        return new DataModels.CustomerProfile(getID(), getRef(), getName());
    }
}
