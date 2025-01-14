package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$AccountPaymentEntityDTO {
    public String CustomerEndDate;
    public String CustomerStartDate;
    public String EntityEndDate;
    public String EntityId;
    public String EntityName;
    public String EntityStartDate;

    public DataModelDTOs$AccountPaymentEntityDTO(String str, String str2, String str3, String str4, String str5, String str6) {
        this.EntityStartDate = str;
        this.EntityEndDate = str2;
        this.CustomerStartDate = str3;
        this.CustomerEndDate = str4;
        this.EntityId = str5;
        this.EntityName = str6;
    }

    public String getCustomerEndDate() {
        return this.CustomerEndDate;
    }

    public String getCustomerStartDate() {
        return this.CustomerStartDate;
    }

    public String getEntityEndDate() {
        return this.EntityEndDate;
    }

    public String getEntityId() {
        return this.EntityId;
    }

    public String getEntityName() {
        return this.EntityName;
    }

    public String getEntityStartDate() {
        return this.EntityStartDate;
    }

    public void setCustomerEndDate(String str) {
        this.CustomerEndDate = str;
    }

    public void setCustomerStartDate(String str) {
        this.CustomerStartDate = str;
    }

    public void setEntityEndDate(String str) {
        this.EntityEndDate = str;
    }

    public void setEntityId(String str) {
        this.EntityId = str;
    }

    public void setEntityName(String str) {
        this.EntityName = str;
    }

    public void setEntityStartDate(String str) {
        this.EntityStartDate = str;
    }
}
