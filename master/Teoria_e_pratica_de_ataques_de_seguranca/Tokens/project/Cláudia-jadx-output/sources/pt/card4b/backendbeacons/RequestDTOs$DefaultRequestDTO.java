package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes.dex */
public class RequestDTOs$DefaultRequestDTO {
    public String CrtyptoTypeCode;
    public String LanguageCode;
    public String RequestAction;
    public String SystemName;

    public RequestDTOs$DefaultRequestDTO(String str, String str2, String str3, String str4) {
        this.SystemName = str;
        this.CrtyptoTypeCode = str2;
        this.RequestAction = str3;
        this.LanguageCode = str4;
    }
}
