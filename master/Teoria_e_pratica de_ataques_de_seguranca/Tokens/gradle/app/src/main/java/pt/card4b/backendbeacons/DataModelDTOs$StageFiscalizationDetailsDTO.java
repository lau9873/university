package pt.card4b.backendbeacons;

import android.support.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$StageFiscalizationDetailsDTO {
    public String ValidationFailMessage;
    public boolean isValid;

    public DataModelDTOs$StageFiscalizationDetailsDTO(boolean z, String str) {
        this.isValid = z;
        this.ValidationFailMessage = str;
    }

    public String getValidationFailMessage() {
        return this.ValidationFailMessage;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setValid(boolean z) {
        this.isValid = z;
    }

    public void setValidationFailMessage(String str) {
        this.ValidationFailMessage = str;
    }
}
