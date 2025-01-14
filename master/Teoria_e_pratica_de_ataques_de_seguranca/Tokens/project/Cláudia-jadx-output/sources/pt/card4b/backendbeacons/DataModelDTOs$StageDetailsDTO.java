package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$StageDetailsDTO {
    public int EndPassingRef;
    public String EndPassingTime;
    public String EndPassingZoneName;
    public int EndPassingZoneRef;
    public String EndStageHour;
    public int EndStopRef;
    public String EndZoneName;
    public int EndZoneRef;
    public int LineRef;
    public int OperatorRef;
    public String OptimizedTripInfo;
    public String OptimizedTripInfoId;
    public float OptimizedTripPrice;
    public int StartPassingRef;
    public String StartPassingTime;
    public String StartPassingZoneName;
    public int StartPassingZoneRef;
    public String StartStageHour;
    public int StartStopRef;
    public String StartZoneName;
    public int StartZoneRef;
    public String TripInfo;
    public String TripInfoId;
    public float TripPrice;
    public boolean isPartialStage;

    public DataModelDTOs$StageDetailsDTO(int i2, int i3, int i4, int i5, int i6, int i7, String str, String str2, String str3, String str4, float f2, float f3, String str5, String str6, boolean z, int i8, int i9, String str7, int i10, int i11, String str8, String str9, String str10, String str11, String str12) {
        this.OperatorRef = i2;
        this.LineRef = i3;
        this.StartStopRef = i4;
        this.EndStopRef = i5;
        this.StartZoneRef = i6;
        this.EndZoneRef = i7;
        this.StartStageHour = str;
        this.EndStageHour = str2;
        this.TripInfoId = str3;
        this.OptimizedTripInfoId = str4;
        this.TripPrice = f2;
        this.OptimizedTripPrice = f3;
        this.TripInfo = str5;
        this.OptimizedTripInfo = str6;
        this.isPartialStage = z;
        this.StartPassingRef = i8;
        this.StartPassingZoneRef = i9;
        this.StartPassingTime = str7;
        this.EndPassingRef = i10;
        this.EndPassingZoneRef = i11;
        this.EndPassingTime = str8;
        this.StartZoneName = str9;
        this.EndZoneName = str10;
        this.StartPassingZoneName = str11;
        this.EndPassingZoneName = str12;
    }

    public int getEndPassingRef() {
        return this.EndPassingRef;
    }

    public String getEndPassingTime() {
        return this.EndPassingTime;
    }

    public String getEndPassingZoneName() {
        return this.EndPassingZoneName;
    }

    public int getEndPassingZoneRef() {
        return this.EndPassingZoneRef;
    }

    public String getEndStageHour() {
        return this.EndStageHour;
    }

    public int getEndStopRef() {
        return this.EndStopRef;
    }

    public String getEndZoneName() {
        return this.EndZoneName;
    }

    public int getEndZoneRef() {
        return this.EndZoneRef;
    }

    public boolean getIsPartialStage() {
        return this.isPartialStage;
    }

    public int getLineRef() {
        return this.LineRef;
    }

    public int getOperatorRef() {
        return this.OperatorRef;
    }

    public String getOptimizedTripInfo() {
        return this.OptimizedTripInfo;
    }

    public String getOptimizedTripInfoId() {
        return this.OptimizedTripInfoId;
    }

    public float getOptimizedTripPrice() {
        return this.OptimizedTripPrice;
    }

    public int getStartPassingRef() {
        return this.StartPassingRef;
    }

    public String getStartPassingTime() {
        return this.StartPassingTime;
    }

    public String getStartPassingZoneName() {
        return this.StartPassingZoneName;
    }

    public int getStartPassingZoneRef() {
        return this.StartPassingZoneRef;
    }

    public String getStartStageHour() {
        return this.StartStageHour;
    }

    public int getStartStopRef() {
        return this.StartStopRef;
    }

    public String getStartZoneName() {
        return this.StartZoneName;
    }

    public int getStartZoneRef() {
        return this.StartZoneRef;
    }

    public String getTripInfo() {
        return this.TripInfo;
    }

    public String getTripInfoId() {
        return this.TripInfoId;
    }

    public float getTripPrice() {
        return this.TripPrice;
    }

    public void setEndPassingRef(int i2) {
        this.EndPassingRef = i2;
    }

    public void setEndPassingTime(String str) {
        this.EndPassingTime = str;
    }

    public void setEndPassingZoneName(String str) {
        this.EndPassingZoneName = str;
    }

    public void setEndPassingZoneRef(int i2) {
        this.EndPassingZoneRef = i2;
    }

    public void setEndStageHour(String str) {
        this.EndStageHour = str;
    }

    public void setEndStopRef(int i2) {
        this.EndStopRef = i2;
    }

    public void setEndZoneName(String str) {
        this.EndZoneName = str;
    }

    public void setEndZoneRef(int i2) {
        this.EndZoneRef = i2;
    }

    public void setLineRef(int i2) {
        this.LineRef = i2;
    }

    public void setOperatorRef(int i2) {
        this.OperatorRef = i2;
    }

    public void setOptimizedTripInfo(String str) {
        this.OptimizedTripInfo = str;
    }

    public void setOptimizedTripInfoId(String str) {
        this.OptimizedTripInfoId = str;
    }

    public void setOptimizedTripPrice(float f2) {
        this.OptimizedTripPrice = f2;
    }

    public void setPartialStage(boolean z) {
        this.isPartialStage = z;
    }

    public void setStartPassingRef(int i2) {
        this.StartPassingRef = i2;
    }

    public void setStartPassingTime(String str) {
        this.StartPassingTime = str;
    }

    public void setStartPassingZoneName(String str) {
        this.StartPassingZoneName = str;
    }

    public void setStartPassingZoneRef(int i2) {
        this.StartPassingZoneRef = i2;
    }

    public void setStartStageHour(String str) {
        this.StartStageHour = str;
    }

    public void setStartStopRef(int i2) {
        this.StartStopRef = i2;
    }

    public void setStartZoneName(String str) {
        this.StartZoneName = str;
    }

    public void setStartZoneRef(int i2) {
        this.StartZoneRef = i2;
    }

    public void setTripInfo(String str) {
        this.TripInfo = str;
    }

    public void setTripInfoId(String str) {
        this.TripInfoId = str;
    }

    public void setTripPrice(float f2) {
        this.TripPrice = f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0278  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public pt.card4b.backendbeacons.DataModels.StageInfo toStageInfo() {
        /*
            Method dump skipped, instructions count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pt.card4b.backendbeacons.DataModelDTOs$StageDetailsDTO.toStageInfo():pt.card4b.backendbeacons.DataModels$StageInfo");
    }
}
