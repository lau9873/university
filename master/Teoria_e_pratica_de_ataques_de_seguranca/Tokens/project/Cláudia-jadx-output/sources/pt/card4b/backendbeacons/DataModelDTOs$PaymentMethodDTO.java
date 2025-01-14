package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.util.ArrayList;
import pt.card4b.backendbeacons.DataModels;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$PaymentMethodDTO {
    public String InfoToCustomer;
    public DataModelDTOs$PaymentMethodMessageDTO[] Messages;
    public String Mode;
    public String Name;
    public String RefCode;
    public String Status;
    public String ThumbnailUrl;
    public String Url;

    public DataModelDTOs$PaymentMethodDTO(String str, String str2, String str3, String str4, String str5, String str6, String str7, DataModelDTOs$PaymentMethodMessageDTO[] dataModelDTOs$PaymentMethodMessageDTOArr) {
        this.Name = str;
        this.RefCode = str2;
        this.Mode = str3;
        this.Url = str4;
        this.ThumbnailUrl = str5;
        this.InfoToCustomer = str6;
        this.Status = str7;
        this.Messages = dataModelDTOs$PaymentMethodMessageDTOArr;
    }

    public String getInfoToCustomer() {
        return this.InfoToCustomer;
    }

    public DataModelDTOs$PaymentMethodMessageDTO[] getMessages() {
        return this.Messages;
    }

    public String getMode() {
        return this.Mode;
    }

    public String getName() {
        return this.Name;
    }

    public String getRefCode() {
        return this.RefCode;
    }

    public String getStatus() {
        return this.Status;
    }

    public String getThumbnailUrl() {
        return this.ThumbnailUrl;
    }

    public String getUrl() {
        return this.Url;
    }

    public void setInfoToCustomer(String str) {
        this.InfoToCustomer = str;
    }

    public void setMessages(DataModelDTOs$PaymentMethodMessageDTO[] dataModelDTOs$PaymentMethodMessageDTOArr) {
        this.Messages = dataModelDTOs$PaymentMethodMessageDTOArr;
    }

    public void setMode(String str) {
        this.Mode = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setRefCode(String str) {
        this.RefCode = str;
    }

    public void setStatus(String str) {
        this.Status = str;
    }

    public void setThumbnailUrl(String str) {
        this.ThumbnailUrl = str;
    }

    public void setUrl(String str) {
        this.Url = str;
    }

    public DataModels.PaymentMethod toPaymentMethod() {
        DataModels.PaymentStatus paymentStatus = DataModels.PaymentStatus.UNKNOWN;
        if (getStatus() != null) {
            if (getStatus().toUpperCase().equals("00")) {
                paymentStatus = DataModels.PaymentStatus.ACTIVE;
            } else if (getStatus().toUpperCase().equals("01")) {
                paymentStatus = DataModels.PaymentStatus.INHIBITED;
            } else if (getStatus().toUpperCase().equals("02")) {
                paymentStatus = DataModels.PaymentStatus.CANCELLED;
            } else if (getStatus().toUpperCase().equals("99")) {
                paymentStatus = DataModels.PaymentStatus.ACTIVATION_PENDING;
            }
        }
        DataModels.PaymentStatus paymentStatus2 = paymentStatus;
        ArrayList arrayList = new ArrayList();
        if (getMessages() != null) {
            for (int i2 = 0; i2 < getMessages().length; i2++) {
                if (getMessages()[i2] != null && getMessages()[i2].getValue() != null && getMessages()[i2].getValue() != "") {
                    arrayList.add(getMessages()[i2].toPaymentMethodMessage());
                }
            }
        }
        return new DataModels.PaymentMethod(getRefCode(), getName(), getMode(), getUrl(), getThumbnailUrl(), getInfoToCustomer(), paymentStatus2, !arrayList.isEmpty() ? (DataModels.PaymentMethodMessage[]) arrayList.toArray(new DataModels.PaymentMethodMessage[0]) : null);
    }
}
