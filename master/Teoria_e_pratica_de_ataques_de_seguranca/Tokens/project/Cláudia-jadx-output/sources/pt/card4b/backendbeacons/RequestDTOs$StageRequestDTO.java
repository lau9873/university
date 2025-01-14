package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import c.d.b.f;
import java.util.ArrayList;
import pt.card4b.backendbeacons.DataModels;
@Keep
/* loaded from: classes.dex */
public class RequestDTOs$StageRequestDTO extends RequestDTOs$DefaultRequestDTO {
    public String CustomerId;
    public String DeviceEndDate;
    public String DeviceInternalId;
    public String DeviceStartDate;
    public String Email;
    public String ID;
    public String JSONStageInfoBeacons;
    public String StageFinishTypeCode;
    public Boolean StartOffline;
    public int TripCounter;

    /* loaded from: classes.dex */
    public class a extends c.d.b.w.a<ArrayList<DataModelDTOs$StageInformationBeaconDTO>> {
        public a(RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO) {
        }
    }

    public RequestDTOs$StageRequestDTO(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, int i2, String str8, String str9, String str10, String str11, String str12) {
        super(str9, str10, str11, str12);
        this.ID = str;
        this.CustomerId = str2;
        this.StageFinishTypeCode = str3;
        this.DeviceInternalId = str4;
        this.DeviceStartDate = str5;
        this.DeviceEndDate = str6;
        this.JSONStageInfoBeacons = str7;
        this.StartOffline = bool;
        this.TripCounter = i2;
        this.Email = str8;
    }

    public RequestDTOs$StageRequestDTO(DataModels.o oVar, String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.ID = oVar.h();
        this.CustomerId = oVar.b();
        this.StageFinishTypeCode = oVar.g();
        this.DeviceInternalId = oVar.d();
        this.DeviceStartDate = oVar.e();
        this.DeviceEndDate = oVar.c();
        this.JSONStageInfoBeacons = new f().a(oVar.a(), new a(this).getType());
        this.StartOffline = Boolean.valueOf(oVar.j());
        this.TripCounter = oVar.k();
        this.Email = oVar.f();
    }
}
