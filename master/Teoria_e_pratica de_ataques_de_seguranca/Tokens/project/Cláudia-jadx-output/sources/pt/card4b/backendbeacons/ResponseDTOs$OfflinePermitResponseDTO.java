package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.util.Date;
@Keep
/* loaded from: classes.dex */
public class ResponseDTOs$OfflinePermitResponseDTO extends ResponseDTOs$DefaultResponseDTO {
    public String DenyReason;
    public String DenyReasonCode;
    public Date LastConfigChange;
    public boolean LogoutNeeded;
    public boolean OfflinePermit;
    public Date ServerDate;
}
