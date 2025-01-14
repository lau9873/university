package pt.card4b.backendbeacons;

import android.support.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$AccountStatusDTO {

    /* renamed from: ID */
    public int f10714ID;
    public String Name;
    public String RefCode;
    public boolean isConfirmed;
    public boolean isCreated;
    public boolean isLocked;

    public DataModelDTOs$AccountStatusDTO(int i, String str, String str2, boolean z, boolean z2, boolean z3) {
        this.f10714ID = i;
        this.RefCode = str;
        this.Name = str2;
        this.isCreated = z;
        this.isConfirmed = z2;
        this.isLocked = z3;
    }

    public int getID() {
        return this.f10714ID;
    }

    public String getName() {
        return this.Name;
    }

    public String getRefCode() {
        return this.RefCode;
    }

    public boolean isConfirmed() {
        return this.isConfirmed;
    }

    public boolean isCreated() {
        return this.isCreated;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setConfirmed(boolean z) {
        this.isConfirmed = z;
    }

    public void setCreated(boolean z) {
        this.isCreated = z;
    }

    public void setID(int i) {
        this.f10714ID = i;
    }

    public void setLocked(boolean z) {
        this.isLocked = z;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setRefCode(String str) {
        this.RefCode = str;
    }
}
