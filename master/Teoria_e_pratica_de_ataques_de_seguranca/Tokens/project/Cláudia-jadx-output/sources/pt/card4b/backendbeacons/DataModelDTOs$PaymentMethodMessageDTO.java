package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$PaymentMethodMessageDTO {
    public String RefCode;
    public String Value;

    public DataModelDTOs$PaymentMethodMessageDTO(String str, String str2) {
        this.RefCode = str;
        this.Value = str2;
    }

    public String getRefCode() {
        return this.RefCode;
    }

    public String getValue() {
        return this.Value;
    }

    public void setRefCode(String str) {
        this.RefCode = str;
    }

    public void setValue(String str) {
        this.Value = str;
    }

    public DataModels.PaymentMethodMessage toPaymentMethodMessage() {
        return new DataModels.PaymentMethodMessage(getRefCode(), getValue());
    }
}
