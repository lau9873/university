package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.util.Date;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$CustomerProfileDetailDTO {
    public Date EndDate;

    /* renamed from: ID */
    public String f10720ID;
    public String ProfileId;
    public int ProfileRef;
    public Date StartDate;

    public DataModelDTOs$CustomerProfileDetailDTO(String str, String str2, int i, Date date, Date date2) {
        this.f10720ID = str;
        this.ProfileId = str2;
        this.ProfileRef = i;
        this.StartDate = date;
        this.EndDate = date2;
    }

    public Date getEndDate() {
        return this.EndDate;
    }

    public String getID() {
        return this.f10720ID;
    }

    public String getProfileId() {
        return this.ProfileId;
    }

    public int getProfileRef() {
        return this.ProfileRef;
    }

    public Date getStartDate() {
        return this.StartDate;
    }

    public void setEndDate(Date date) {
        this.EndDate = date;
    }

    public void setID(String str) {
        this.f10720ID = str;
    }

    public void setProfileId(String str) {
        this.ProfileId = str;
    }

    public void setProfileRef(int i) {
        this.ProfileRef = i;
    }

    public void setStartDate(Date date) {
        this.StartDate = date;
    }
}
