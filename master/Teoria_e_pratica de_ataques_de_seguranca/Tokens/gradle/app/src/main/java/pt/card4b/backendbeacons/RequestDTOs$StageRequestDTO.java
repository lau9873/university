package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.util.ArrayList;
import p070c.p084d.p105b.Gson;
import p070c.p084d.p105b.p111w.TypeToken;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class RequestDTOs$StageRequestDTO extends RequestDTOs$DefaultRequestDTO {
    public String CustomerId;
    public String DeviceEndDate;
    public String DeviceInternalId;
    public String DeviceStartDate;
    public String Email;

    /* renamed from: ID */
    public String f10916ID;
    public String JSONStageInfoBeacons;
    public String StageFinishTypeCode;
    public Boolean StartOffline;
    public int TripCounter;

    /* renamed from: pt.card4b.backendbeacons.RequestDTOs$StageRequestDTO$a */
    /* loaded from: classes.dex */
    public class C2712a extends TypeToken<ArrayList<DataModelDTOs$StageInformationBeaconDTO>> {
        public C2712a(RequestDTOs$StageRequestDTO requestDTOs$StageRequestDTO) {
        }
    }

    public RequestDTOs$StageRequestDTO(String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, int i, String str8, String str9, String str10, String str11, String str12) {
        super(str9, str10, str11, str12);
        this.f10916ID = str;
        this.CustomerId = str2;
        this.StageFinishTypeCode = str3;
        this.DeviceInternalId = str4;
        this.DeviceStartDate = str5;
        this.DeviceEndDate = str6;
        this.JSONStageInfoBeacons = str7;
        this.StartOffline = bool;
        this.TripCounter = i;
        this.Email = str8;
    }

    public RequestDTOs$StageRequestDTO(DataModels.C2706o c2706o, String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        this.f10916ID = c2706o.m151h();
        this.CustomerId = c2706o.m157b();
        this.StageFinishTypeCode = c2706o.m152g();
        this.DeviceInternalId = c2706o.m155d();
        this.DeviceStartDate = c2706o.m154e();
        this.DeviceEndDate = c2706o.m156c();
        this.JSONStageInfoBeacons = new Gson().m4931a(c2706o.m158a(), new C2712a(this).getType());
        this.StartOffline = Boolean.valueOf(c2706o.m149j());
        this.TripCounter = c2706o.m148k();
        this.Email = c2706o.m153f();
    }
}
