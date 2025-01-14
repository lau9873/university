package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p070c.p084d.p105b.Gson;
import p205h.p206a.p207a.C1863a;
import p205h.p206a.p207a.GeneralUtils;

@Keep
/* loaded from: classes.dex */
public class DataModels {
    public static final Object EMPTY_OBJECT = new Object();

    @Keep
    /* loaded from: classes.dex */
    public static class AccountPaymentEntity implements Serializable {
        public String CustomerEndDate;
        public String CustomerStartDate;
        public String EntityEndDate;
        public String EntityId;
        public String EntityName;
        public String EntityStartDate;

        public AccountPaymentEntity(String str, String str2, String str3, String str4, String str5, String str6) {
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

    @Keep
    /* loaded from: classes.dex */
    public static class BeaconSighting {
        public boolean isAndante;
        public String lineName;
        public String lineOrientationName;
        public int lineOrientationRef;
        public int lineRef;
        public String lineVariantName;
        public int lineVariantRef;
        public String mac;
        public String name;
        public String operatorName;
        public int operatorRef;
        public int position;
        public int rfu;
        public int rssi;
        public String stopName;
        public int stopRef;
        public long timestamp;
        public int txPower;
        public String uuid;
        public int vehicle;
        public int version;
        public String zoneName;
        public int zoneRef;

        public String getLineName() {
            return this.lineName;
        }

        public String getLineOrientationName() {
            return this.lineOrientationName;
        }

        public int getLineOrientationRef() {
            return this.lineOrientationRef;
        }

        public int getLineRef() {
            return this.lineRef;
        }

        public String getLineVariantName() {
            return this.lineVariantName;
        }

        public int getLineVariantRef() {
            return this.lineVariantRef;
        }

        public String getMac() {
            return this.mac;
        }

        public String getName() {
            return this.name;
        }

        public String getOperatorName() {
            return this.operatorName;
        }

        public int getOperatorRef() {
            return this.operatorRef;
        }

        public int getPosition() {
            return this.position;
        }

        public int getRfu() {
            return this.rfu;
        }

        public int getRssi() {
            return this.rssi;
        }

        public String getStopName() {
            return this.stopName;
        }

        public int getStopRef() {
            return this.stopRef;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public int getTxPower() {
            return this.txPower;
        }

        public String getUuid() {
            return this.uuid;
        }

        public int getVehicle() {
            return this.vehicle;
        }

        public int getVersion() {
            return this.version;
        }

        public String getZoneName() {
            return this.zoneName;
        }

        public int getZoneRef() {
            return this.zoneRef;
        }

        public boolean isAndante() {
            return this.isAndante;
        }

        public void setAndante(boolean z) {
            this.isAndante = z;
        }

        public void setLineName(String str) {
            this.lineName = str;
        }

        public void setLineOrientationName(String str) {
            this.lineOrientationName = str;
        }

        public void setLineOrientationRef(int i) {
            this.lineOrientationRef = i;
        }

        public void setLineRef(int i) {
            this.lineRef = i;
        }

        public void setLineVariantName(String str) {
            this.lineVariantName = str;
        }

        public void setLineVariantRef(int i) {
            this.lineVariantRef = i;
        }

        public void setMac(String str) {
            this.mac = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setOperatorName(String str) {
            this.operatorName = str;
        }

        public void setOperatorRef(int i) {
            this.operatorRef = i;
        }

        public void setPosition(int i) {
            this.position = i;
        }

        public void setRfu(int i) {
            this.rfu = i;
        }

        public void setRssi(int i) {
            this.rssi = i;
        }

        public void setStopName(String str) {
            this.stopName = str;
        }

        public void setStopRef(int i) {
            this.stopRef = i;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public void setTxPower(int i) {
            this.txPower = i;
        }

        public void setUuid(String str) {
            this.uuid = str;
        }

        public void setVehicle(int i) {
            this.vehicle = i;
        }

        public void setVersion(int i) {
            this.version = i;
        }

        public void setZoneName(String str) {
            this.zoneName = str;
        }

        public void setZoneRef(int i) {
            this.zoneRef = i;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class CardInfo implements Serializable {
        public String serialNumber;

        public CardInfo(String str) {
            this.serialNumber = str;
        }

        public String getSerialNumber() {
            return this.serialNumber;
        }

        public void setSerialNumber(String str) {
            this.serialNumber = str;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class Country implements Serializable {
        public String code;

        /* renamed from: id */
        public String f10722id;
        public String name;

        public Country(String str, String str2, String str3) {
            this.f10722id = str;
            this.code = str2;
            this.name = str3;
        }

        public String getCode() {
            return this.code;
        }

        public String getId() {
            return this.f10722id;
        }

        public String getName() {
            return this.name;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setId(String str) {
            this.f10722id = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class CustomerProfile {

        /* renamed from: ID */
        public String f10723ID;
        public String Name;
        public int Ref;

        public CustomerProfile(String str, int i, String str2) {
            this.f10723ID = str;
            this.Ref = i;
            this.Name = str2;
        }

        public String getID() {
            return this.f10723ID;
        }

        public String getName() {
            return this.Name;
        }

        public int getRef() {
            return this.Ref;
        }

        public void setID(String str) {
            this.f10723ID = str;
        }

        public void setName(String str) {
            this.Name = str;
        }

        public void setRef(int i) {
            this.Ref = i;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class InvoiceInfo {
        public String DocumentLink;
        public String DocumentNumber;
        public String InvoiceId;
        public Date IssueDate;
        public float Total;

        public InvoiceInfo(String str, String str2, String str3, Date date, float f) {
            this.InvoiceId = str;
            this.DocumentNumber = str2;
            this.DocumentLink = str3;
            this.IssueDate = date;
            this.Total = f;
        }

        public String getDocumentLink() {
            return this.DocumentLink;
        }

        public String getDocumentNumber() {
            return this.DocumentNumber;
        }

        public String getInvoiceId() {
            return this.InvoiceId;
        }

        public Date getIssueDate() {
            return this.IssueDate;
        }

        public float getTotal() {
            return this.Total;
        }

        public void setDocumentLink(String str) {
            this.DocumentLink = str;
        }

        public void setDocumentNumber(String str) {
            this.DocumentNumber = str;
        }

        public void setInvoiceId(String str) {
            this.InvoiceId = str;
        }

        public void setIssueDate(Date date) {
            this.IssueDate = date;
        }

        public void setTotal(float f) {
            this.Total = f;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class Language implements Serializable {
        public String code;

        /* renamed from: id */
        public String f10724id;
        public String name;

        public Language(String str, String str2, String str3) {
            this.f10724id = str;
            this.code = str2;
            this.name = str3;
        }

        public String getCode() {
            return this.code;
        }

        public String getId() {
            return this.f10724id;
        }

        public String getName() {
            return this.name;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setId(String str) {
            this.f10724id = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class NewStageStartInfo {

        /* renamed from: id */
        public String f10725id;
        public Date startDate;
        public boolean startOffline;
        public int tripCounter;

        public NewStageStartInfo(String str, Date date, boolean z, int i) {
            this.f10725id = str;
            this.startDate = date;
            this.startOffline = z;
            this.tripCounter = i;
        }

        public String getId() {
            return this.f10725id;
        }

        public Date getStartDate() {
            return this.startDate;
        }

        public boolean getStartOffline() {
            return this.startOffline;
        }

        public int getTripCounter() {
            return this.tripCounter;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public enum PaymentAction {
        NO_ACTION_NEEDED,
        URL
    }

    @Keep
    /* loaded from: classes.dex */
    public static class PaymentInfo {
        public String infoToCustomer;
        public String procedureURL;

        public String getInfoToCustomer() {
            return this.infoToCustomer;
        }

        public String getProcedureURL() {
            return this.procedureURL;
        }

        public void setInfoToCustomer(String str) {
            this.infoToCustomer = str;
        }

        public void setProcedureURL(String str) {
            this.procedureURL = str;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class PaymentMethod implements Serializable {
        public String code;
        public String infoToCustomer;
        public PaymentMethodMessage[] messages;
        public String mode;
        public String name;
        public PaymentStatus status;
        public String thumbnailURL;
        public String url;

        public PaymentMethod(String str, String str2, String str3, String str4, String str5, String str6, PaymentStatus paymentStatus, PaymentMethodMessage[] paymentMethodMessageArr) {
            this.code = str;
            this.name = str2;
            this.mode = str3;
            this.thumbnailURL = str5;
            this.url = str4;
            this.infoToCustomer = str6;
            this.status = paymentStatus;
            this.messages = paymentMethodMessageArr;
        }

        public String getCode() {
            return this.code;
        }

        public String getInfoToCustomer() {
            return this.infoToCustomer;
        }

        public PaymentMethodMessage[] getMessages() {
            return this.messages;
        }

        public String getMode() {
            return this.mode;
        }

        public String getName() {
            return this.name;
        }

        public PaymentStatus getStatus() {
            return this.status;
        }

        public String getThumbnailURL() {
            return this.thumbnailURL;
        }

        public String getUrl() {
            return this.url;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setInfoToCustomer(String str) {
            this.infoToCustomer = str;
        }

        public void setMessages(PaymentMethodMessage[] paymentMethodMessageArr) {
            this.messages = paymentMethodMessageArr;
        }

        public void setMode(String str) {
            this.mode = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setStatus(PaymentStatus paymentStatus) {
            this.status = paymentStatus;
        }

        public void setThumbnailURL(String str) {
            this.thumbnailURL = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public String toString() {
            return new Gson().m4931a(this, PaymentMethod.class);
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class PaymentMethodMessage {
        public String Code;
        public String Value;

        public PaymentMethodMessage(String str, String str2) {
            this.Code = str;
            this.Value = str2;
        }

        public String getCode() {
            return this.Code;
        }

        public String getValue() {
            return this.Value;
        }

        public void setCode(String str) {
            this.Code = str;
        }

        public void setValue(String str) {
            this.Value = str;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public enum PaymentStatus {
        UNKNOWN,
        ACTIVE,
        INHIBITED,
        CANCELLED,
        ACTIVATION_PENDING
    }

    @Keep
    /* loaded from: classes.dex */
    public enum Service {
        BLUETOOTH,
        LOCATION,
        NFC,
        HCE_VALIDATION,
        INTERNET
    }

    @Keep
    /* loaded from: classes.dex */
    public static class StageInfo {
        public int beaconDataId;
        public String endPassingStopName;
        public Date endPassingTime;
        public String endPassingZoneName;
        public Date finishDate;
        public String finishStopName;
        public String finishZoneName;
        public boolean isFinished;
        public boolean isPartialStage;
        public String lineName;
        public String optimizedTariffInfo;
        public String optimizedTripId;
        public String stageId;
        public Date startDate;
        public String startPassingStopName;
        public Date startPassingTime;
        public String startPassingZoneName;
        public String startStopName;
        public String startZoneName;
        public String tariffInfo;
        public String transportOperatorName;
        public int transportOperatorRef;
        public String tripId;

        public StageInfo() {
        }

        public int getBeaconDataId() {
            return this.beaconDataId;
        }

        public String getEndPassingStopName() {
            return this.endPassingStopName;
        }

        public Date getEndPassingTime() {
            return this.endPassingTime;
        }

        public String getEndPassingZoneName() {
            return this.endPassingZoneName;
        }

        public Date getFinishDate() {
            return this.finishDate;
        }

        public String getFinishStopName() {
            return this.finishStopName;
        }

        public String getFinishZoneName() {
            return this.finishZoneName;
        }

        public boolean getIsPartialStage() {
            return this.isPartialStage;
        }

        public String getLineName() {
            return this.lineName;
        }

        public String getOptimizedTariffInfo() {
            return this.optimizedTariffInfo;
        }

        public String getOptimizedTripId() {
            return this.optimizedTripId;
        }

        public String getStageId() {
            return this.stageId;
        }

        public Date getStartDate() {
            return this.startDate;
        }

        public String getStartPassingStopName() {
            return this.startPassingStopName;
        }

        public Date getStartPassingTime() {
            return this.startPassingTime;
        }

        public String getStartPassingZoneName() {
            return this.startPassingZoneName;
        }

        public String getStartStopName() {
            return this.startStopName;
        }

        public String getStartZoneName() {
            return this.startZoneName;
        }

        public String getTariffInfo() {
            return this.tariffInfo;
        }

        public String getTransportOperatorName() {
            return this.transportOperatorName;
        }

        public int getTransportOperatorRef() {
            return this.transportOperatorRef;
        }

        public String getTripId() {
            return this.tripId;
        }

        public boolean isFinished() {
            return this.isFinished;
        }

        public void setBeaconDataId(int i) {
            this.beaconDataId = i;
        }

        public void setEndPassingStopName(String str) {
            this.endPassingStopName = str;
        }

        public void setEndPassingTime(Date date) {
            this.endPassingTime = date;
        }

        public void setEndPassingZoneName(String str) {
            this.endPassingZoneName = str;
        }

        public void setFinishDate(Date date) {
            this.finishDate = date;
        }

        public void setFinishStopName(String str) {
            this.finishStopName = str;
        }

        public void setFinishZoneName(String str) {
            this.finishZoneName = str;
        }

        public void setFinished(boolean z) {
            this.isFinished = z;
        }

        public void setIsPartialStage(boolean z) {
            this.isPartialStage = z;
        }

        public void setLineName(String str) {
            this.lineName = str;
        }

        public void setOptimizedTariffInfo(String str) {
            this.optimizedTariffInfo = str;
        }

        public void setOptimizedTripId(String str) {
            this.optimizedTripId = str;
        }

        public void setStageId(String str) {
            this.stageId = str;
        }

        public void setStartDate(Date date) {
            this.startDate = date;
        }

        public void setStartPassingStopName(String str) {
            this.startPassingStopName = str;
        }

        public void setStartPassingTime(Date date) {
            this.startPassingTime = date;
        }

        public void setStartPassingZoneName(String str) {
            this.startPassingZoneName = str;
        }

        public void setStartStopName(String str) {
            this.startStopName = str;
        }

        public void setStartZoneName(String str) {
            this.startZoneName = str;
        }

        public void setTariffInfo(String str) {
            this.tariffInfo = str;
        }

        public void setTransportOperatorName(String str) {
            this.transportOperatorName = str;
        }

        public void setTransportOperatorRef(int i) {
            this.transportOperatorRef = i;
        }

        public void setTripId(String str) {
            this.tripId = str;
        }

        public StageInfo(String str, int i, int i2, String str2, String str3, String str4, String str5, String str6, String str7, Date date, Date date2, boolean z, String str8, String str9, String str10, String str11, boolean z2, String str12, String str13, Date date3, String str14, String str15, Date date4) {
            this.stageId = str;
            this.beaconDataId = i;
            this.transportOperatorRef = i2;
            this.transportOperatorName = str2;
            this.lineName = str3;
            this.startZoneName = str4;
            this.finishZoneName = str5;
            this.startStopName = str6;
            this.finishStopName = str7;
            this.startDate = date;
            this.finishDate = date2;
            this.isFinished = z;
            this.tripId = str8;
            this.optimizedTripId = str9;
            this.tariffInfo = str10;
            this.optimizedTariffInfo = str11;
            this.isPartialStage = z2;
            this.startPassingStopName = str12;
            this.startPassingZoneName = str13;
            this.startPassingTime = date3;
            this.endPassingStopName = str14;
            this.endPassingZoneName = str15;
            this.endPassingTime = date4;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class StopInfo implements Serializable {
        public String approximateTariff;
        public Date datetime;
        public String key;
        public String lineName;
        public boolean onTrip;
        public String operatorName;
        public int operatorRef;
        public String orientation;
        public String stageId;
        public String stopCode;
        public String stopName;
        public int stopOrder;
        public String tariff;
        public Date validationDatetime;
        public String zone;

        public StopInfo() {
        }

        public StopInfo getCopy() {
            return new StopInfo(this.key, this.operatorRef, this.operatorName, this.lineName, this.stopName, this.stopCode, this.orientation, this.zone, this.datetime, this.validationDatetime);
        }

        public Date getDatetime() {
            return this.datetime;
        }

        public String getKey() {
            return this.key;
        }

        public String getLineName() {
            return this.lineName;
        }

        public String getOperatorName() {
            return this.operatorName;
        }

        public int getOperatorRef() {
            return this.operatorRef;
        }

        public String getOrientation() {
            return this.orientation;
        }

        public String getStageId() {
            return this.stageId;
        }

        public String getStopCode() {
            return this.stopCode;
        }

        public String getStopName() {
            return this.stopName;
        }

        public int getStopOrder() {
            return this.stopOrder;
        }

        public String getTariff() {
            return this.tariff;
        }

        public Date getValidationDatetime() {
            return this.validationDatetime;
        }

        public String getZone() {
            return this.zone;
        }

        public boolean isOnTrip() {
            return this.onTrip;
        }

        public void setDatetime(Date date) {
            this.datetime = date;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setLineName(String str) {
            this.lineName = str;
        }

        public void setOnTrip(boolean z) {
            this.onTrip = z;
        }

        public void setOperatorName(String str) {
            this.operatorName = str;
        }

        public void setOperatorRef(int i) {
            this.operatorRef = i;
        }

        public void setOrientation(String str) {
            this.orientation = str;
        }

        public void setStageId(String str) {
            this.stageId = str;
        }

        public void setStopCode(String str) {
            this.stopCode = str;
        }

        public void setStopName(String str) {
            this.stopName = str;
        }

        public void setStopOrder(int i) {
            this.stopOrder = i;
        }

        public void setTariff(String str) {
            this.tariff = str;
        }

        public void setValidationDatetime(Date date) {
            this.validationDatetime = this.validationDatetime;
        }

        public void setZone(String str) {
            this.zone = str;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Operator: ");
            String str2 = "????";
            String str3 = "";
            sb.append((getOperatorName() == null || getOperatorName().equals("")) ? "????" : getOperatorName());
            sb.append(" Stop: ");
            if (getStopName() != null && !getStopName().equals("")) {
                str2 = getStopName();
            }
            sb.append(str2);
            if (getLineName() == null || getLineName().equals("")) {
                str = "";
            } else {
                str = "Line: " + getLineName();
            }
            sb.append(str);
            if (getValidationDatetime() != null) {
                str3 = " Validation: " + GeneralUtils.m1593b(getValidationDatetime());
            } else if (getDatetime() != null) {
                str3 = GeneralUtils.m1593b(getDatetime());
            }
            sb.append(str3);
            return sb.toString();
        }

        public StopInfo(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, Date date, Date date2) {
            this.key = str == null ? "" : str;
            this.operatorRef = i;
            this.operatorName = str2 == null ? "" : str2;
            this.lineName = str3 == null ? "" : str3;
            this.stopName = str4 == null ? "" : str4;
            this.stopCode = str5 == null ? "" : str5;
            this.zone = str7 == null ? "" : str7;
            this.orientation = str6 == null ? "" : str6;
            this.datetime = date;
            this.validationDatetime = date2;
        }

        public StopInfo(C2692b c2692b) {
            this.key = c2692b.m230n();
            this.operatorRef = c2692b.m233k() == null ? 0 : c2692b.m233k().m163b();
            this.operatorName = c2692b.m233k() == null ? "" : c2692b.m233k().m164a();
            this.lineName = c2692b.m236h() == null ? "" : c2692b.m236h().m173b();
            C2708q m231m = c2692b.m231m();
            if (m231m != null) {
                this.stopName = m231m.m113c() == null ? "" : m231m.m113c();
                this.stopCode = m231m.m115a() == null ? "" : m231m.m115a();
            } else {
                this.stopName = "";
                this.stopCode = "";
            }
            this.zone = c2692b.m227q() == null ? "" : c2692b.m227q().m111a();
            this.orientation = c2692b.m235i() != null ? c2692b.m235i().m168b() : "";
            this.datetime = c2692b.m240d();
            this.validationDatetime = c2692b.m229o();
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class TariffInfo {
        public List<StageInfo> stageInfoList;
        public float totalCredit;
        public float totalDebt;
        public float totalSave;

        public TariffInfo() {
        }

        public List<StageInfo> getStageInfo() {
            return this.stageInfoList;
        }

        public float getTotalCredit() {
            return this.totalCredit;
        }

        public float getTotalDebt() {
            return this.totalDebt;
        }

        public float getTotalSave() {
            return this.totalSave;
        }

        public void setStageInfo(List<StageInfo> list) {
            this.stageInfoList = list;
        }

        public void setTotalCredit(float f) {
            this.totalCredit = f;
        }

        public void setTotalDebt(float f) {
            this.totalDebt = f;
        }

        public void setTotalSave(float f) {
            this.totalSave = f;
        }

        public TariffInfo(List<StageInfo> list, float f, float f2, float f3) {
            this.stageInfoList = list;
            this.totalDebt = f;
            this.totalSave = f2;
            this.totalCredit = f3;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class User {
        public String email;
        public boolean hasPaymentMethod;

        /* renamed from: id */
        public String f10726id;
        public String name;
        public String phonenumber;
        public String photo;

        public User() {
        }

        public User getCopy() {
            return new User(getId(), getName(), getEmail(), getPhonenumber(), getPhoto(), getHasPaymentMethod());
        }

        public String getEmail() {
            return this.email;
        }

        public Boolean getHasPaymentMethod() {
            return Boolean.valueOf(this.hasPaymentMethod);
        }

        public String getId() {
            return this.f10726id;
        }

        public String getName() {
            return this.name;
        }

        public String getPhonenumber() {
            return this.phonenumber;
        }

        public String getPhoto() {
            return this.photo;
        }

        public void setEmail(String str) {
            this.email = str;
        }

        public void setHasPaymentMethod(boolean z) {
            this.hasPaymentMethod = z;
        }

        public void setId(String str) {
            this.f10726id = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPhonenumber(String str) {
            this.phonenumber = str;
        }

        public void setPhoto(String str) {
            this.photo = str;
        }

        public User(User user) {
            this.f10726id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
            this.photo = user.getPhoto();
        }

        public User(String str, String str2, String str3, String str4, String str5, Boolean bool) {
            this.f10726id = str;
            this.name = str2;
            this.email = str3;
            this.phonenumber = str4;
            this.photo = str5;
            this.hasPaymentMethod = bool.booleanValue();
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class UserAccountInfo implements Serializable {
        public AccountPaymentEntity accountPaymentEntity;
        public String address;
        public UserBillingInfo billingInfo;
        public String email;
        public String fiscalnumber;

        /* renamed from: id */
        public String f10727id;
        public String idnumber;
        public String name;
        public PaymentMethod paymentMethod;
        public String phonenumber;
        public String photo;
        public String postalcode;
        public List<UserProfileInfo> profileInfo;
        public String tipCode;

        public UserAccountInfo() {
        }

        public AccountPaymentEntity getAccountPaymentEntity() {
            return this.accountPaymentEntity;
        }

        public String getAddress() {
            return this.address;
        }

        public UserBillingInfo getBillingInfo() {
            return this.billingInfo;
        }

        public UserAccountInfo getCopy() {
            UserBillingInfo userBillingInfo;
            ArrayList arrayList;
            if (this.billingInfo != null) {
                userBillingInfo = new UserBillingInfo(getBillingInfo().getID(), getBillingInfo().getName(), getBillingInfo().getAddress(), getBillingInfo().getCity(), getBillingInfo().getPostalCode(), getBillingInfo().getFiscalNumber(), getBillingInfo().getCountry() != null ? new Country(getBillingInfo().getCountry().getId(), getBillingInfo().getCountry().getCode(), getBillingInfo().getCountry().getName()) : null, getBillingInfo().getNotifyEmail());
            } else {
                userBillingInfo = null;
            }
            if (this.profileInfo != null) {
                ArrayList arrayList2 = new ArrayList();
                for (UserProfileInfo userProfileInfo : getProfileInfo()) {
                    arrayList2.add(new UserProfileInfo(userProfileInfo.getID(), userProfileInfo.getProfileId(), userProfileInfo.getProfileName(), userProfileInfo.getStartDate(), userProfileInfo.getEndDate()));
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new UserAccountInfo(getId(), getName(), getEmail(), getAddress(), getPhonenumber(), getPostalcode(), getFiscalnumber(), getIdnumber(), getTipCode(), getPhoto(), userBillingInfo, arrayList, getPaymentMethod() != null ? new PaymentMethod(getPaymentMethod().getCode(), getPaymentMethod().getName(), getPaymentMethod().getMode(), getPaymentMethod().getUrl(), getPaymentMethod().getThumbnailURL(), getPaymentMethod().getInfoToCustomer(), getPaymentMethod().getStatus(), getPaymentMethod().getMessages()) : null);
        }

        public String getEmail() {
            return this.email;
        }

        public String getFiscalnumber() {
            return this.fiscalnumber;
        }

        public String getId() {
            return this.f10727id;
        }

        public String getIdnumber() {
            return this.idnumber;
        }

        public String getName() {
            return this.name;
        }

        public PaymentMethod getPaymentMethod() {
            return this.paymentMethod;
        }

        public String getPhonenumber() {
            return this.phonenumber;
        }

        public String getPhoto() {
            return this.photo;
        }

        public String getPostalcode() {
            return this.postalcode;
        }

        public List<UserProfileInfo> getProfileInfo() {
            return this.profileInfo;
        }

        public String getTipCode() {
            return this.tipCode;
        }

        public void setAccountPaymentEntity(AccountPaymentEntity accountPaymentEntity) {
            this.accountPaymentEntity = accountPaymentEntity;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setBillingInfo(UserBillingInfo userBillingInfo) {
            this.billingInfo = userBillingInfo;
        }

        public void setEmail(String str) {
            this.email = str;
        }

        public void setFiscalnumber(String str) {
            this.fiscalnumber = str;
        }

        public void setId(String str) {
            this.f10727id = str;
        }

        public void setIdnumber(String str) {
            this.idnumber = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public void setPhonenumber(String str) {
            this.phonenumber = str;
        }

        public void setPhoto(String str) {
            this.photo = str;
        }

        public void setPostalcode(String str) {
            this.postalcode = str;
        }

        public void setProfileInfo(List<UserProfileInfo> list) {
            this.profileInfo = list;
        }

        public void setTipCode(String str) {
            this.tipCode = str;
        }

        public User toUser() {
            return new User(getId(), getName(), getEmail(), getPhonenumber(), getPhoto(), Boolean.valueOf((getPaymentMethod() == null || getPaymentMethod().getCode() == null) ? false : true));
        }

        public UserAccountInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, UserBillingInfo userBillingInfo, List<UserProfileInfo> list, PaymentMethod paymentMethod) {
            this.f10727id = str;
            this.name = str2;
            this.email = str3;
            this.address = str4;
            this.phonenumber = str5;
            this.postalcode = str6;
            this.fiscalnumber = str7;
            this.idnumber = str8;
            this.tipCode = str9;
            this.photo = str10;
            this.billingInfo = userBillingInfo;
            this.profileInfo = list;
            this.paymentMethod = paymentMethod;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class UserBillingInfo implements Serializable {
        public String Address;
        public String City;
        public Country Country;
        public String FiscalNumber;

        /* renamed from: ID */
        public String f10728ID;
        public String Name;
        public String NotifyEmail;
        public String PostalCode;

        public UserBillingInfo(String str, String str2, String str3, String str4, String str5, String str6, Country country, String str7) {
            this.f10728ID = str;
            this.Name = str2;
            this.Address = str3;
            this.City = str4;
            this.PostalCode = str5;
            this.FiscalNumber = str6;
            this.Country = country;
            this.NotifyEmail = str7;
        }

        public String getAddress() {
            return this.Address;
        }

        public String getCity() {
            return this.City;
        }

        public Country getCountry() {
            return this.Country;
        }

        public String getFiscalNumber() {
            return this.FiscalNumber;
        }

        public String getID() {
            return this.f10728ID;
        }

        public String getName() {
            return this.Name;
        }

        public String getNotifyEmail() {
            return this.NotifyEmail;
        }

        public String getPostalCode() {
            return this.PostalCode;
        }

        public void setAddress(String str) {
            this.Address = str;
        }

        public void setCity(String str) {
            this.City = str;
        }

        public void setCountry(Country country) {
            this.Country = country;
        }

        public void setFiscalNumber(String str) {
            this.FiscalNumber = str;
        }

        public void setID(String str) {
            this.f10728ID = str;
        }

        public void setName(String str) {
            this.Name = str;
        }

        public void setNotifyEmail(String str) {
            this.NotifyEmail = str;
        }

        public void setPostalCode(String str) {
            this.PostalCode = str;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class UserProfileInfo implements Serializable {
        public Date EndDate;

        /* renamed from: ID */
        public String f10729ID;
        public String ProfileId;
        public String ProfileName;
        public Date StartDate;

        public UserProfileInfo(String str, String str2, String str3, Date date, Date date2) {
            this.f10729ID = str;
            this.ProfileId = str2;
            this.ProfileName = str3;
            this.StartDate = date;
            this.EndDate = date2;
        }

        public Date getEndDate() {
            return this.EndDate;
        }

        public String getID() {
            return this.f10729ID;
        }

        public String getProfileId() {
            return this.ProfileId;
        }

        public String getProfileName() {
            return this.ProfileName;
        }

        public Date getStartDate() {
            return this.StartDate;
        }

        public void setEndDate(Date date) {
            this.EndDate = date;
        }

        public void setID(String str) {
            this.f10729ID = str;
        }

        public void setProfileId(String str) {
            this.ProfileId = str;
        }

        public void setProfileName(String str) {
            this.ProfileName = str;
        }

        public void setStartDate(Date date) {
            this.StartDate = date;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$a */
    /* loaded from: classes.dex */
    public static class C2691a {

        /* renamed from: a */
        public Date f10730a;

        /* renamed from: b */
        public Date f10731b;

        /* renamed from: c */
        public Date f10732c;

        /* renamed from: d */
        public String f10733d;

        /* renamed from: e */
        public int f10734e;

        /* renamed from: f */
        public Date f10735f;

        /* renamed from: g */
        public long f10736g;

        /* renamed from: h */
        public boolean f10737h;

        /* renamed from: i */
        public double f10738i;

        /* renamed from: j */
        public double f10739j;

        /* renamed from: k */
        public double f10740k;

        /* renamed from: l */
        public String f10741l;

        /* renamed from: m */
        public Date f10742m;

        public C2691a(String str, String str2, int i, String str3, boolean z) {
            this.f10733d = str2;
            this.f10734e = i;
            this.f10737h = z;
        }

        /* renamed from: a */
        public void m276a(Date date) {
            this.f10730a = date;
        }

        /* renamed from: b */
        public void m272b(Date date) {
            this.f10732c = date;
        }

        /* renamed from: c */
        public void m270c(double d) {
            this.f10739j = d;
        }

        /* renamed from: d */
        public void m267d(Date date) {
            this.f10731b = date;
        }

        /* renamed from: e */
        public Boolean m266e() {
            return Boolean.valueOf(this.f10737h);
        }

        /* renamed from: f */
        public Date m265f() {
            return this.f10731b;
        }

        /* renamed from: g */
        public double m264g() {
            return this.f10738i;
        }

        /* renamed from: h */
        public double m263h() {
            return this.f10740k;
        }

        /* renamed from: i */
        public double m262i() {
            return this.f10739j;
        }

        /* renamed from: j */
        public String m261j() {
            return this.f10733d;
        }

        /* renamed from: k */
        public int m260k() {
            return this.f10734e;
        }

        /* renamed from: l */
        public Date m259l() {
            return this.f10735f;
        }

        /* renamed from: m */
        public long m258m() {
            return this.f10736g;
        }

        /* renamed from: a */
        public Date m279a() {
            return this.f10730a;
        }

        /* renamed from: b */
        public Date m274b() {
            return this.f10732c;
        }

        /* renamed from: c */
        public String m271c() {
            return this.f10741l;
        }

        /* renamed from: d */
        public Date m268d() {
            return this.f10742m;
        }

        /* renamed from: a */
        public void m275a(Date date, long j) {
            this.f10735f = date;
            this.f10736g = j;
        }

        /* renamed from: b */
        public void m273b(double d) {
            this.f10740k = d;
        }

        /* renamed from: c */
        public void m269c(Date date) {
            this.f10742m = date;
        }

        /* renamed from: a */
        public void m278a(double d) {
            this.f10738i = d;
        }

        /* renamed from: a */
        public void m277a(String str) {
            this.f10741l = str;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$b */
    /* loaded from: classes.dex */
    public static class C2692b {

        /* renamed from: a */
        public String f10743a;

        /* renamed from: b */
        public int f10744b;

        /* renamed from: c */
        public C2704m f10745c;

        /* renamed from: d */
        public C2701j f10746d;

        /* renamed from: e */
        public C2709r f10747e;

        /* renamed from: f */
        public C2708q f10748f;

        /* renamed from: g */
        public C2703l f10749g;

        /* renamed from: h */
        public C2702k f10750h;

        /* renamed from: i */
        public int f10751i;

        /* renamed from: j */
        public boolean f10752j;

        /* renamed from: k */
        public String f10753k;

        /* renamed from: l */
        public Date f10754l;

        /* renamed from: m */
        public Date f10755m;

        /* renamed from: n */
        public Date f10756n;

        /* renamed from: o */
        public C2695d f10757o;

        /* renamed from: p */
        public List<C2691a> f10758p = new ArrayList();

        /* renamed from: q */
        public Map<String, C2691a> f10759q = new HashMap();

        /* renamed from: r */
        public Date f10760r;

        public C2692b() {
        }

        /* renamed from: a */
        public void m256a(int i) {
        }

        /* renamed from: a */
        public void m248a(C2704m c2704m) {
            this.f10745c = c2704m;
        }

        /* renamed from: b */
        public void m243b(Date date) {
            this.f10756n = date;
        }

        /* renamed from: c */
        public void m241c(Date date) {
            this.f10755m = date;
        }

        /* renamed from: d */
        public Date m240d() {
            return this.f10754l;
        }

        /* renamed from: e */
        public Date m239e() {
            return this.f10756n;
        }

        /* renamed from: f */
        public String m238f() {
            return this.f10743a;
        }

        /* renamed from: g */
        public Date m237g() {
            return this.f10755m;
        }

        /* renamed from: h */
        public C2701j m236h() {
            return this.f10746d;
        }

        /* renamed from: i */
        public C2702k m235i() {
            return this.f10750h;
        }

        /* renamed from: j */
        public C2703l m234j() {
            return this.f10749g;
        }

        /* renamed from: k */
        public C2704m m233k() {
            return this.f10745c;
        }

        /* renamed from: l */
        public int m232l() {
            return this.f10744b;
        }

        /* renamed from: m */
        public C2708q m231m() {
            return this.f10748f;
        }

        /* renamed from: n */
        public String m230n() {
            if (this.f10753k == null) {
                int m163b = m233k() == null ? 0 : m233k().m163b();
                int m170e = m236h() == null ? 0 : m236h().m170e();
                int m167c = m235i() == null ? 0 : m235i().m167c();
                int m112d = m231m() == null ? 0 : m231m().m112d();
                int m110b = m227q() != null ? m227q().m110b() : 0;
                this.f10753k = m163b + "|" + m170e + "|" + m112d + "|" + m167c + "|" + m110b;
            }
            return this.f10753k;
        }

        /* renamed from: o */
        public Date m229o() {
            return this.f10760r;
        }

        /* renamed from: p */
        public int m228p() {
            return this.f10751i;
        }

        /* renamed from: q */
        public C2709r m227q() {
            return this.f10747e;
        }

        /* renamed from: r */
        public boolean m226r() {
            return this.f10752j;
        }

        public String toString() {
            String str;
            String str2;
            String str3;
            if (m236h() == null) {
                str = "Line: null";
            } else {
                str = "Line: " + m236h().m173b();
            }
            String str4 = str + "; Orientation: ";
            if (m235i() == null) {
                str2 = str4 + "null";
            } else {
                str2 = str4 + m235i().m168b();
            }
            String str5 = str2 + "; Stop: ";
            if (m231m() == null) {
                str3 = str5 + "null";
            } else {
                str3 = str5 + m231m().m113c();
            }
            String str6 = str3 + "; BeaconInfoType: ";
            if (m257a() == null) {
                return str6 + "null";
            }
            return str6 + "id = " + m257a().m195b() + ", code = " + m257a().m196a() + ", name = " + m257a().m194c();
        }

        /* renamed from: a */
        public void m251a(C2701j c2701j) {
            this.f10746d = c2701j;
        }

        /* renamed from: b */
        public List<C2691a> m244b() {
            return this.f10758p;
        }

        /* renamed from: c */
        public Map<String, C2691a> m242c() {
            return this.f10759q;
        }

        /* renamed from: a */
        public void m246a(C2709r c2709r) {
            this.f10747e = c2709r;
        }

        public C2692b(C2693c c2693c) {
            this.f10743a = c2693c.m218f();
            c2693c.m198z();
            this.f10751i = c2693c.m199y();
            this.f10744b = c2693c.m210n();
            c2693c.m209o();
            this.f10756n = null;
            Date m1602a = GeneralUtils.m1602a(c2693c.m206r());
            this.f10755m = m1602a;
            this.f10754l = m1602a;
            m253a(c2693c);
        }

        /* renamed from: a */
        public void m247a(C2708q c2708q) {
            this.f10748f = c2708q;
        }

        /* renamed from: a */
        public void m249a(C2703l c2703l) {
            this.f10749g = c2703l;
        }

        /* renamed from: a */
        public void m250a(C2702k c2702k) {
            this.f10750h = c2702k;
        }

        /* renamed from: a */
        public void m245a(boolean z) {
            this.f10752j = z;
        }

        /* renamed from: a */
        public void m255a(String str) {
            this.f10752j = str != null;
        }

        /* renamed from: a */
        public void m254a(Date date) {
            this.f10754l = date;
        }

        /* renamed from: a */
        public C2695d m257a() {
            return this.f10757o;
        }

        /* renamed from: a */
        public void m252a(C2695d c2695d) {
            this.f10757o = c2695d;
        }

        /* renamed from: a */
        public void m253a(C2693c c2693c) {
            Date m1602a = GeneralUtils.m1602a(c2693c.m206r());
            GeneralUtils.m1602a(c2693c.m205s());
            Date m1602a2 = c2693c.m201w() > 0 ? GeneralUtils.m1602a(c2693c.m201w()) : null;
            long m202v = c2693c.m202v();
            this.f10756n = null;
            C2691a c2691a = this.f10759q.get(c2693c.m224a());
            if (c2691a == null) {
                c2691a = new C2691a(c2693c.m213k(), c2693c.m224a(), c2693c.m208p(), c2693c.m203u(), c2693c.m219e());
                c2691a.m276a(GeneralUtils.m1602a(c2693c.m206r()));
                if (m1602a2 != null) {
                    c2691a.m275a(m1602a2, m202v);
                }
                if (c2693c.m221c() != null) {
                    c2691a.m277a(c2693c.m221c());
                    c2691a.m269c(c2693c.m220d() > 0 ? GeneralUtils.m1602a(c2693c.m220d()) : null);
                }
                this.f10759q.put(c2691a.m261j(), c2691a);
                this.f10758p.add(c2691a);
            }
            c2691a.m267d(m1602a);
            c2691a.m272b((Date) null);
            c2691a.m278a(c2693c.m217g());
            c2691a.m270c(c2693c.m214j());
            c2691a.m273b(c2693c.m215i());
            this.f10755m = m1602a;
            if (m1602a2 != null) {
                this.f10760r = m1602a2;
            }
            if (c2693c.m221c() != null) {
                c2693c.m221c();
                if (c2693c.m220d() > 0) {
                    GeneralUtils.m1602a(c2693c.m220d());
                }
            }
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$c */
    /* loaded from: classes.dex */
    public static class C2693c {

        /* renamed from: A */
        public long f10761A;

        /* renamed from: a */
        public String f10762a;

        /* renamed from: b */
        public String f10763b;

        /* renamed from: c */
        public String f10764c;

        /* renamed from: d */
        public String f10765d;

        /* renamed from: e */
        public int f10766e;

        /* renamed from: f */
        public long f10767f;

        /* renamed from: g */
        public long f10768g;

        /* renamed from: h */
        public int f10769h;

        /* renamed from: i */
        public List<Integer> f10770i;

        /* renamed from: j */
        public int f10771j;

        /* renamed from: k */
        public int f10772k;

        /* renamed from: l */
        public int f10773l;

        /* renamed from: m */
        public int f10774m;

        /* renamed from: n */
        public int f10775n;

        /* renamed from: o */
        public int f10776o;

        /* renamed from: p */
        public int f10777p;

        /* renamed from: q */
        public int f10778q;

        /* renamed from: r */
        public int f10779r;

        /* renamed from: s */
        public int f10780s;

        /* renamed from: t */
        public boolean f10781t;

        /* renamed from: u */
        public long f10782u;

        /* renamed from: v */
        public double f10783v;

        /* renamed from: w */
        public double f10784w;

        /* renamed from: x */
        public double f10785x;

        /* renamed from: y */
        public long f10786y;

        /* renamed from: z */
        public String f10787z;

        /* renamed from: pt.card4b.backendbeacons.DataModels$c$a */
        /* loaded from: classes.dex */
        public class C2694a implements Comparator<C2693c> {
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(C2693c c2693c, C2693c c2693c2) {
                return c2693c.m222b() - c2693c2.m222b();
            }
        }

        static {
            new C2694a();
        }

        public C2693c() {
        }

        /* renamed from: A */
        public int m225A() {
            return this.f10779r;
        }

        /* renamed from: a */
        public void m223a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.f10771j = i;
            this.f10772k = i2;
            this.f10773l = i3;
            this.f10774m = i4;
            this.f10775n = i5;
            this.f10776o = i6;
            this.f10777p = i7;
            this.f10778q = i8;
            this.f10779r = i9;
            this.f10780s = i11;
        }

        /* renamed from: b */
        public int m222b() {
            List<Integer> list = this.f10770i;
            if (list != null) {
                return (int) GeneralUtils.m1592b(list);
            }
            return 65536;
        }

        /* renamed from: c */
        public String m221c() {
            return this.f10787z;
        }

        /* renamed from: d */
        public long m220d() {
            return this.f10761A;
        }

        /* renamed from: e */
        public boolean m219e() {
            return this.f10781t;
        }

        /* renamed from: f */
        public String m218f() {
            return this.f10762a;
        }

        /* renamed from: g */
        public double m217g() {
            return this.f10783v;
        }

        /* renamed from: h */
        public int m216h() {
            return this.f10775n;
        }

        /* renamed from: i */
        public double m215i() {
            return this.f10785x;
        }

        /* renamed from: j */
        public double m214j() {
            return this.f10784w;
        }

        /* renamed from: k */
        public String m213k() {
            return this.f10763b;
        }

        /* renamed from: l */
        public int m212l() {
            return this.f10772k;
        }

        /* renamed from: m */
        public int m211m() {
            return this.f10777p;
        }

        /* renamed from: n */
        public int m210n() {
            return this.f10774m;
        }

        /* renamed from: o */
        public int m209o() {
            return this.f10780s;
        }

        /* renamed from: p */
        public int m208p() {
            return this.f10766e;
        }

        /* renamed from: q */
        public int m207q() {
            return this.f10778q;
        }

        /* renamed from: r */
        public long m206r() {
            return this.f10767f;
        }

        /* renamed from: s */
        public long m205s() {
            return this.f10768g;
        }

        /* renamed from: t */
        public int m204t() {
            return this.f10769h;
        }

        public String toString() {
            return (((((("MAC: " + this.f10764c + "\n") + "Op: " + m212l() + "\n") + "LC: " + m216h() + "\n") + "Dr: " + m211m() + "\n") + "Va: " + m200x() + "\n") + "St: " + m207q() + "\n") + "Zn: " + m225A() + "\n";
        }

        /* renamed from: u */
        public String m203u() {
            return this.f10765d;
        }

        /* renamed from: v */
        public long m202v() {
            return this.f10786y;
        }

        /* renamed from: w */
        public long m201w() {
            return this.f10782u;
        }

        /* renamed from: x */
        public int m200x() {
            return this.f10776o;
        }

        /* renamed from: y */
        public int m199y() {
            return this.f10773l;
        }

        /* renamed from: z */
        public int m198z() {
            return this.f10771j;
        }

        public C2693c(String str, String str2, String str3, int i, int i2, long j, long j2, boolean z, long j3, double d, double d2, double d3, long j4, String str4, long j5) {
            this.f10762a = str;
            this.f10763b = str2;
            this.f10764c = str3;
            this.f10766e = i;
            this.f10769h = i2;
            this.f10767f = j;
            this.f10768g = j2;
            this.f10781t = z;
            this.f10782u = j3;
            this.f10783v = d;
            this.f10784w = d2;
            this.f10785x = d3;
            this.f10786y = j4;
            this.f10787z = str4;
            this.f10761A = j5;
        }

        /* renamed from: a */
        public String m224a() {
            return this.f10764c;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$d */
    /* loaded from: classes.dex */
    public static class C2695d {

        /* renamed from: a */
        public String f10788a;

        /* renamed from: b */
        public String f10789b;

        /* renamed from: c */
        public String f10790c;

        public C2695d(String str, String str2, String str3) {
            this.f10788a = str;
            this.f10789b = str2;
            this.f10790c = str3;
        }

        /* renamed from: a */
        public String m196a() {
            return this.f10790c;
        }

        /* renamed from: b */
        public String m195b() {
            return this.f10788a;
        }

        /* renamed from: c */
        public String m194c() {
            return this.f10789b;
        }

        public String toString() {
            return this.f10789b;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$e */
    /* loaded from: classes.dex */
    public static class C2696e {

        /* renamed from: a */
        public Date f10791a;

        /* renamed from: b */
        public boolean f10792b;

        /* renamed from: c */
        public Date f10793c;

        /* renamed from: d */
        public boolean f10794d;

        /* renamed from: e */
        public String f10795e;

        /* renamed from: f */
        public String f10796f;

        public C2696e(Date date, boolean z, Date date2, boolean z2, String str, String str2) {
            this.f10791a = date;
            this.f10792b = z;
            this.f10793c = date2;
            this.f10794d = z2;
            this.f10795e = str;
            this.f10796f = str2;
        }

        /* renamed from: a */
        public String m193a() {
            return this.f10795e;
        }

        /* renamed from: b */
        public String m192b() {
            return this.f10796f;
        }

        /* renamed from: c */
        public Date m191c() {
            return this.f10793c;
        }

        /* renamed from: d */
        public boolean m190d() {
            return this.f10794d;
        }

        /* renamed from: e */
        public boolean m189e() {
            return this.f10792b;
        }

        /* renamed from: f */
        public Date m188f() {
            return this.f10791a;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$f */
    /* loaded from: classes.dex */
    public static class C2697f {

        /* renamed from: a */
        public String f10797a;

        /* renamed from: b */
        public String f10798b;

        public C2697f(String str, String str2, boolean z, String str3, String str4) {
            this.f10797a = str;
            this.f10798b = str2;
        }

        /* renamed from: a */
        public String m187a() {
            return this.f10798b;
        }

        public String toString() {
            return this.f10797a;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$g */
    /* loaded from: classes.dex */
    public static class C2698g extends Throwable {

        /* renamed from: a */
        public Error f10799a;

        public C2698g(Error error) {
            this.f10799a = error;
        }

        /* renamed from: a */
        public Error m186a() {
            return this.f10799a;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$h */
    /* loaded from: classes.dex */
    public static class C2699h {

        /* renamed from: i */
        public static String f10800i = "BLUETOOTH_STATE_CHANGE_ON";

        /* renamed from: j */
        public static String f10801j = "BLUETOOTH_STATE_CHANGE_OFF";

        /* renamed from: k */
        public static String f10802k = "EVENT_TYPE_APP_CRASH";

        /* renamed from: l */
        public static String f10803l = "EVENT_TYPE_BATTERY_LEVEL";

        /* renamed from: m */
        public static String f10804m = "CUSTOMER_REPORT";

        /* renamed from: n */
        public static String f10805n = "TRIP_ACTIVITY_BLOCKED";

        /* renamed from: o */
        public static String f10806o = "EVENT_TYPE_ENROLL_FAIL";

        /* renamed from: p */
        public static String f10807p = "EVENT_TYPE_ENROLL_OK";

        /* renamed from: a */
        public String f10808a;

        /* renamed from: b */
        public String f10809b;

        /* renamed from: c */
        public boolean f10810c;

        /* renamed from: d */
        public Date f10811d;

        /* renamed from: e */
        public String f10812e;

        /* renamed from: f */
        public Date f10813f;

        /* renamed from: g */
        public String f10814g;

        /* renamed from: h */
        public String f10815h;

        public C2699h(String str, String str2, Boolean bool, Date date, String str3, Date date2, String str4, String str5) {
            this.f10808a = str;
            this.f10809b = str2;
            this.f10810c = bool.booleanValue();
            this.f10811d = date;
            this.f10812e = str3;
            this.f10813f = date2;
            this.f10814g = str4;
            this.f10815h = str5;
        }

        /* renamed from: a */
        public String m185a() {
            return this.f10808a;
        }

        /* renamed from: b */
        public String m184b() {
            return this.f10812e;
        }

        /* renamed from: c */
        public String m183c() {
            return this.f10815h;
        }

        /* renamed from: d */
        public String m182d() {
            return this.f10814g;
        }

        /* renamed from: e */
        public String m181e() {
            return this.f10809b;
        }

        /* renamed from: f */
        public Date m180f() {
            return this.f10811d;
        }

        /* renamed from: g */
        public Boolean m179g() {
            return Boolean.valueOf(this.f10810c);
        }

        /* renamed from: h */
        public Date m178h() {
            return this.f10813f;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$i */
    /* loaded from: classes.dex */
    public static class C2700i {

        /* renamed from: a */
        public String f10816a;

        /* renamed from: b */
        public String f10817b;

        /* renamed from: c */
        public long f10818c;

        public C2700i(String str, String str2, String str3, long j) {
            this.f10816a = str2;
            this.f10817b = str3;
            this.f10818c = j;
        }

        /* renamed from: a */
        public long m177a() {
            return this.f10818c;
        }

        /* renamed from: b */
        public String m176b() {
            return this.f10817b;
        }

        /* renamed from: c */
        public String m175c() {
            return this.f10816a;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$j */
    /* loaded from: classes.dex */
    public static class C2701j {

        /* renamed from: a */
        public String f10819a;

        /* renamed from: b */
        public int f10820b;

        /* renamed from: c */
        public String f10821c;

        /* renamed from: d */
        public int f10822d;

        /* renamed from: e */
        public int f10823e;

        public C2701j(String str, int i, String str2, int i2, int i3) {
            this.f10819a = str;
            this.f10820b = i;
            this.f10821c = str2;
            this.f10822d = i2;
            this.f10823e = i3;
        }

        /* renamed from: a */
        public String m174a() {
            return this.f10819a;
        }

        /* renamed from: b */
        public String m173b() {
            return this.f10821c;
        }

        /* renamed from: c */
        public int m172c() {
            return this.f10822d;
        }

        /* renamed from: d */
        public int m171d() {
            return this.f10823e;
        }

        /* renamed from: e */
        public int m170e() {
            return this.f10820b;
        }

        public String toString() {
            return this.f10821c;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$k */
    /* loaded from: classes.dex */
    public static class C2702k {

        /* renamed from: a */
        public String f10824a;

        /* renamed from: b */
        public int f10825b;

        /* renamed from: c */
        public String f10826c;

        public C2702k(String str, int i, String str2, int i2) {
            this.f10824a = str;
            this.f10825b = i;
            this.f10826c = str2;
        }

        /* renamed from: a */
        public String m169a() {
            return this.f10824a;
        }

        /* renamed from: b */
        public String m168b() {
            return this.f10826c;
        }

        /* renamed from: c */
        public int m167c() {
            return this.f10825b;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$l */
    /* loaded from: classes.dex */
    public static class C2703l {

        /* renamed from: a */
        public int f10827a;

        /* renamed from: b */
        public String f10828b;

        public C2703l(int i, String str) {
            this.f10827a = i;
            this.f10828b = str;
        }

        /* renamed from: a */
        public String m166a() {
            return this.f10828b;
        }

        /* renamed from: b */
        public int m165b() {
            return this.f10827a;
        }

        public String toString() {
            return this.f10828b;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$m */
    /* loaded from: classes.dex */
    public static class C2704m {

        /* renamed from: a */
        public int f10829a;

        /* renamed from: b */
        public String f10830b;

        /* renamed from: c */
        public C2705n f10831c;

        /* renamed from: d */
        public int f10832d;

        /* renamed from: e */
        public int f10833e;

        public C2704m(int i, String str, C2705n c2705n, int i2, int i3) {
            this.f10829a = i;
            this.f10830b = str;
            this.f10831c = c2705n;
            this.f10832d = i2;
            this.f10833e = i3;
        }

        /* renamed from: a */
        public String m164a() {
            return this.f10830b;
        }

        /* renamed from: b */
        public int m163b() {
            return this.f10829a;
        }

        /* renamed from: c */
        public int m162c() {
            return this.f10833e;
        }

        /* renamed from: d */
        public int m161d() {
            return this.f10832d;
        }

        /* renamed from: e */
        public C2705n m160e() {
            return this.f10831c;
        }

        public String toString() {
            return this.f10830b;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$n */
    /* loaded from: classes.dex */
    public static class C2705n {

        /* renamed from: c */
        public static int f10834c = 1;

        /* renamed from: a */
        public int f10835a;

        /* renamed from: b */
        public String f10836b;

        public C2705n(int i, String str) {
            this.f10835a = i;
            this.f10836b = str;
        }

        /* renamed from: a */
        public int m159a() {
            return this.f10835a;
        }

        public String toString() {
            return this.f10836b;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$o */
    /* loaded from: classes.dex */
    public static class C2706o {

        /* renamed from: A */
        public static String f10837A = "FIRST_STOP_TIMEOUT_FINISH_CONFIRMED";

        /* renamed from: B */
        public static String f10838B = "FIRST_STOP_TIMEOUT_FINISH_NOT_CONFIRMED";

        /* renamed from: C */
        public static String f10839C = "NOT_AUTHORIZED_FINISH";

        /* renamed from: D */
        public static short f10840D = 1;

        /* renamed from: E */
        public static short f10841E = 2;

        /* renamed from: F */
        public static short f10842F = 3;

        /* renamed from: l */
        public static String f10843l = "MANUAL_FINISH";

        /* renamed from: m */
        public static String f10844m = "TIMEOUT_FINISH";

        /* renamed from: n */
        public static String f10845n = "STEP_DETECTION_FINISH";

        /* renamed from: o */
        public static String f10846o = "NEWSTAGE_FINISH";

        /* renamed from: p */
        public static String f10847p = "APP_START_WITH_ONGOING_STAGE_FINISH";

        /* renamed from: q */
        public static String f10848q = "REPEATED_INFO_RECEIVED_FINISH";

        /* renamed from: r */
        public static String f10849r = "FIRST_STOP_TIMEOUT_FINISH";

        /* renamed from: s */
        public static String f10850s = "TIMEOUT_FINISH_CONFIRMED";

        /* renamed from: t */
        public static String f10851t = "TIMEOUT_FINISH_NOT_CONFIRMED";

        /* renamed from: u */
        public static String f10852u = "STEP_DETECTION_FINISH_CONFIRMED";

        /* renamed from: v */
        public static String f10853v = "STEP_DETECTION_FINISH_NOT_CONFIRMED";

        /* renamed from: w */
        public static String f10854w = "REPEATED_INFO_RECEIVED_CONFIRMED";

        /* renamed from: x */
        public static String f10855x = "REPEATED_INFO_RECEIVED_NOT_CONFIRMED";

        /* renamed from: y */
        public static String f10856y = "BT_OFF_TIMEOUT_FINISH";

        /* renamed from: z */
        public static String f10857z = "BT_OFF_MAX_OCCUR_FINISH";

        /* renamed from: a */
        public String f10858a;

        /* renamed from: b */
        public String f10859b;

        /* renamed from: c */
        public String f10860c;

        /* renamed from: d */
        public String f10861d;

        /* renamed from: e */
        public String f10862e;

        /* renamed from: f */
        public String f10863f;

        /* renamed from: g */
        public List<DataModelDTOs$StageInformationBeaconDTO> f10864g;

        /* renamed from: h */
        public short f10865h;

        /* renamed from: i */
        public boolean f10866i;

        /* renamed from: j */
        public int f10867j;

        /* renamed from: k */
        public String f10868k;

        public C2706o(String str, String str2, String str3, String str4, String str5, String str6, List<DataModelDTOs$StageInformationBeaconDTO> list, boolean z, int i, short s, String str7) {
            this.f10858a = str;
            this.f10859b = str2;
            this.f10860c = str3;
            this.f10861d = str4;
            this.f10862e = str5;
            this.f10863f = str6;
            this.f10864g = list;
            this.f10866i = z;
            this.f10865h = s;
            this.f10867j = i;
            this.f10868k = str7;
        }

        /* renamed from: a */
        public List<DataModelDTOs$StageInformationBeaconDTO> m158a() {
            return this.f10864g;
        }

        /* renamed from: b */
        public String m157b() {
            return this.f10859b;
        }

        /* renamed from: c */
        public String m156c() {
            return this.f10863f;
        }

        /* renamed from: d */
        public String m155d() {
            return this.f10861d;
        }

        /* renamed from: e */
        public String m154e() {
            return this.f10862e;
        }

        /* renamed from: f */
        public String m153f() {
            return this.f10868k;
        }

        /* renamed from: g */
        public String m152g() {
            return this.f10860c;
        }

        /* renamed from: h */
        public String m151h() {
            return this.f10858a;
        }

        /* renamed from: i */
        public short m150i() {
            return this.f10865h;
        }

        /* renamed from: j */
        public boolean m149j() {
            return this.f10866i;
        }

        /* renamed from: k */
        public int m148k() {
            return this.f10867j;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$p */
    /* loaded from: classes.dex */
    public static class C2707p {

        /* renamed from: a */
        public int f10869a;

        /* renamed from: b */
        public String f10870b;

        /* renamed from: c */
        public String f10871c;

        /* renamed from: d */
        public int f10872d;

        /* renamed from: e */
        public int f10873e;

        /* renamed from: f */
        public int f10874f;

        /* renamed from: g */
        public int f10875g;

        /* renamed from: h */
        public int f10876h;

        /* renamed from: i */
        public List<C2692b> f10877i = new ArrayList();

        /* renamed from: j */
        public Boolean f10878j;

        /* renamed from: k */
        public Date f10879k;

        /* renamed from: l */
        public int f10880l;

        /* renamed from: m */
        public Date f10881m;

        /* renamed from: n */
        public long f10882n;

        /* renamed from: o */
        public Date f10883o;

        /* renamed from: p */
        public short f10884p;

        /* renamed from: q */
        public Date f10885q;

        /* renamed from: a */
        public void m144a(String str) {
            this.f10870b = str;
        }

        /* renamed from: b */
        public void m138b(String str) {
            this.f10871c = str;
        }

        /* renamed from: c */
        public void m135c(int i) {
            this.f10875g = i;
        }

        /* renamed from: d */
        public String m133d() {
            return this.f10870b;
        }

        /* renamed from: e */
        public void m130e(int i) {
            this.f10869a = i;
        }

        /* renamed from: f */
        public int m129f() {
            return this.f10876h;
        }

        /* renamed from: g */
        public int m127g() {
            return this.f10873e;
        }

        /* renamed from: h */
        public int m125h() {
            return this.f10875g;
        }

        /* renamed from: i */
        public int m124i() {
            return this.f10872d;
        }

        /* renamed from: j */
        public Date m123j() {
            return this.f10881m;
        }

        /* renamed from: k */
        public long m122k() {
            return this.f10882n;
        }

        /* renamed from: l */
        public String m121l() {
            return this.f10871c;
        }

        /* renamed from: m */
        public Date m120m() {
            return this.f10879k;
        }

        /* renamed from: n */
        public Boolean m119n() {
            return this.f10878j;
        }

        /* renamed from: o */
        public int m118o() {
            return this.f10869a;
        }

        /* renamed from: p */
        public int m117p() {
            return this.f10880l;
        }

        /* renamed from: q */
        public int m116q() {
            return this.f10874f;
        }

        /* renamed from: a */
        public void m146a(int i) {
            this.f10876h = i;
        }

        /* renamed from: b */
        public void m139b(int i) {
            this.f10873e = i;
        }

        /* renamed from: c */
        public void m134c(Date date) {
            this.f10879k = date;
        }

        /* renamed from: d */
        public void m132d(int i) {
            this.f10872d = i;
        }

        /* renamed from: e */
        public Date m131e() {
            return this.f10885q;
        }

        /* renamed from: f */
        public void m128f(int i) {
            this.f10880l = i;
        }

        /* renamed from: g */
        public void m126g(int i) {
            this.f10874f = i;
        }

        /* renamed from: a */
        public void m145a(Boolean bool) {
            this.f10878j = bool;
        }

        /* renamed from: b */
        public Date m140b() {
            return this.f10883o;
        }

        /* renamed from: c */
        public short m136c() {
            return this.f10884p;
        }

        /* renamed from: a */
        public void m142a(Date date, long j) {
            this.f10881m = date;
            this.f10882n = j;
        }

        /* renamed from: b */
        public void m137b(Date date) {
            this.f10885q = date;
        }

        /* renamed from: a */
        public List<C2692b> m147a() {
            return this.f10877i;
        }

        /* renamed from: a */
        public void m143a(Date date) {
            this.f10883o = date;
        }

        /* renamed from: a */
        public void m141a(short s) {
            this.f10884p = s;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$q */
    /* loaded from: classes.dex */
    public static class C2708q {

        /* renamed from: a */
        public String f10886a;

        /* renamed from: b */
        public int f10887b;

        /* renamed from: c */
        public String f10888c;

        /* renamed from: d */
        public String f10889d;

        public C2708q(String str, int i, String str2, String str3) {
            this.f10886a = str;
            this.f10887b = i;
            this.f10888c = str2;
            this.f10889d = str3;
        }

        /* renamed from: a */
        public String m115a() {
            return this.f10889d;
        }

        /* renamed from: b */
        public String m114b() {
            return this.f10886a;
        }

        /* renamed from: c */
        public String m113c() {
            return this.f10888c;
        }

        /* renamed from: d */
        public int m112d() {
            return this.f10887b;
        }

        public String toString() {
            return this.f10888c;
        }
    }

    /* renamed from: pt.card4b.backendbeacons.DataModels$r */
    /* loaded from: classes.dex */
    public static class C2709r {

        /* renamed from: a */
        public int f10890a;

        /* renamed from: b */
        public String f10891b;

        public C2709r(int i, String str) {
            this.f10890a = i;
            this.f10891b = str;
        }

        /* renamed from: a */
        public String m111a() {
            return this.f10891b;
        }

        /* renamed from: b */
        public int m110b() {
            return this.f10890a;
        }

        public String toString() {
            return this.f10891b;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class Error {
        public String message;
        public String messageToUser;
        public ErrorType type;
        public static final int ERROR_COMM_DESCRIPTION = C1863a.err_msg_connectiontimeout;
        public static final int ERROR_COMM_USER_DESCRIPTION = C1863a.err_msguser_connectiontimeout;
        public static final int ERROR_NO_BLUETOOTH_DESCRIPTION = C1863a.err_msg_bluetoothnotsupported;
        public static final int ERROR_BLUETOOTH_DISABLED_DESCRIPTION = C1863a.err_msg_bluetoothdisabled;
        public static final int ERROR_NO_BLE_DESCRIPTION = C1863a.err_msg_ble_not_supported;
        public static final int ERROR_PHONESTATE_PERMISSION_DESCRIPTION = C1863a.err_msg_phonestatepermission;
        public static final int ERROR_PHONESTATE_PERMISSION_USER_DESCRIPTION = C1863a.err_msguser_phonestatepermission;
        public static final int ERROR_LOCATION_PERMISSION_DESCRIPTION = C1863a.err_msg_locationpermission;
        public static final int ERROR_LOCATION_DISABLED_DESCRIPTION = C1863a.err_msg_locationdisabled;
        public static final int ERROR_BLUETOOTH_SCAN_FAILED_DESCRIPTION = C1863a.err_msg_bluetoothscanfailed;
        public static final int ERROR_FIELD_REQUIRED_DESCRIPTION = C1863a.err_msg_missingfields;
        public static final int ERROR_EMAIL_ALREADY_REGISTERED_DESCRIPTION = C1863a.err_msg_emailalreadyregistered;
        public static final int ERROR_LOGIN_REQUIRED_DESCRIPTION = C1863a.err_msg_loginrequired;
        public static final int ERROR_STAGE_REQUIRED_DESCRIPTION = C1863a.err_msg_stagerequired;
        public static final int ERROR_STAGE_ALREADY_STARTED_DESCRIPTION = C1863a.err_msg_stagealreadystarted;
        public static final int ERROR_MISSING_DATA_DESCRIPTION = C1863a.err_msg_missingdata;
        public static final int ERROR_NO_CHANGES_DESCRIPTION = C1863a.err_msg_customerupdatenochanges;
        public static final int ERROR_STAGE_ONGOING_DESCRIPTION = C1863a.err_msg_stageongoing;
        public static final int ERROR_PAYMENTMETHOD_NOT_RECOGNIZED_DESCRIPTION = C1863a.err_msg_paymentmethod_not_recognized;
        public static final int START_STAGE_OFFLINE_NOT_AUTHORIZED_DESCRIPTION = C1863a.err_msg_start_stage_offline_not_authorized;
        public static final int ERROR_NO_NFC_DESCRIPTION = C1863a.err_msg_nfc_not_supported;
        public static final int ERROR_NFC_DISABLED_DESCRIPTION = C1863a.err_msg_nfc_disabled;
        public static final int ERROR_LOGIN_FAILED_DESCRIPTION = C1863a.err_msg_loginfailed;
        public static final int START_STAGE_NOT_AUTHORIZED_DESCRIPTION = C1863a.err_msg_start_stage_not_authorized;
        public static final int INIT_FAILED_DATA_SUSPECT_DESCRIPTION = C1863a.err_msg_init_failed_data_suspect;
        public static final int ERROR_NO_INTERNET_DESCRIPTION = C1863a.err_msg_no_internet;
        public static final int PAYMENT_METHOD_MISSING_DESCRIPTION = C1863a.err_msg_payment_method_missing_description;
        public static final int PAYMENT_METHOD_INVALID_DESCRIPTION = C1863a.err_msg_payment_method_invalid_description;
        public static final int EQUIPMENT_INVALID_DESCRIPTION = C1863a.err_msg_equipment_invalid_description;
        public static final int ACCOUNT_INTO_BLACK_LIST_DESCRIPTION = C1863a.err_msg_account_into_black_list_description;
        public static final int ACCOUNT_NOT_CONFIRMED_DESCRIPTION = C1863a.err_msg_account_not_confirmed_description;
        public static final int ACCOUNT_NOT_EXIST_DESCRIPTION = C1863a.err_msg_account_not_exist_description;
        public static final int FAILED_TO_SEND_REPORT_DESCRIPTION = C1863a.err_msg_failed_to_send_report_description;
        public static final int FAILED_TO_ENROLL_CARD_DESCRIPTION = C1863a.err_msg_failed_to_enroll_card_description;
        public static final int ERROR_CARD_NOT_ENROLLED_DESCRIPTION = C1863a.err_msg_card_not_enrolled_description;
        public static final int ERROR_ACCOUNT_MISMATCH_DESCRIPTION = C1863a.err_msg_account_mismatch_description;
        public static final int ERROR_TOKEN_MISMATCH_DESCRIPTION = C1863a.err_msg_token_mismatch_description;
        public static final int ERROR_INTERNAL_DESCRIPTION = C1863a.err_msg_internal_description;
        public static final int ERROR_MISSING_REGISTRATION_KEY_DESCRIPTION = C1863a.err_msg_missing_registration_key_description;

        @Keep
        /* loaded from: classes.dex */
        public enum ErrorType {
            COMM,
            VALIDATION,
            INTERNAL,
            NO_BLUETOOTH,
            NO_BLE,
            BLUETOOTH_DISABLED,
            LOCATION_PERMISSION,
            LOCATION_DISABLED,
            PHONESTATE_PERMISSION,
            BLUETOOTH_SCAN_FAILED,
            FIELD_REQUIRED,
            EMAIL_ALREADY_REGISTERED,
            LOGIN_REQUIRED,
            LOGIN_FAILED,
            NO_RESULTS,
            STAGE_REQUIRED,
            STAGE_ONGOING,
            STAGE_ALREADY_STARTED,
            MISSING_DATA,
            NO_CHANGES,
            PAYMENTMETHOD_NOT_RECOGNIZED,
            START_STAGE_OFFLINE_NOT_AUTHORIZED,
            NO_NFC,
            NFC_DISABLED,
            START_STAGE_NOT_AUTHORIZED,
            INIT_FAILED_DATA_SUSPECT,
            NO_INTERNET,
            PAYMENT_METHOD_MISSING,
            PAYMENT_METHOD_INVALID,
            EQUIPMENT_INVALID,
            ACCOUNT_INTO_BLACK_LIST,
            ACCOUNT_NOT_CONFIRMED,
            ACCOUNT_NOT_EXIST,
            FAILED_TO_SEND_REPORT,
            FAILED_TO_ENROLL_CARD,
            CARD_NOT_ENROLLED,
            ACCOUNT_MISMATCH,
            TOKEN_MISMATCH,
            MISSING_REGISTRATION_KEY
        }

        public Error(ErrorType errorType, String str, String str2) {
            this.type = errorType;
            this.message = str;
            this.messageToUser = str2;
        }

        public static Error account_into_black_list() {
            String m1603a = GeneralUtils.m1603a(ACCOUNT_INTO_BLACK_LIST_DESCRIPTION);
            return new Error(ErrorType.ACCOUNT_INTO_BLACK_LIST, m1603a, m1603a);
        }

        public static Error account_mismatch(String str) {
            String m1603a = GeneralUtils.m1603a(ERROR_ACCOUNT_MISMATCH_DESCRIPTION);
            return new Error(ErrorType.ACCOUNT_MISMATCH, m1603a + " [" + str + "]", m1603a + " [" + str + "]");
        }

        public static Error account_not_confirmed() {
            String m1603a = GeneralUtils.m1603a(ACCOUNT_NOT_CONFIRMED_DESCRIPTION);
            return new Error(ErrorType.ACCOUNT_NOT_CONFIRMED, m1603a, m1603a);
        }

        public static Error account_not_exist() {
            String m1603a = GeneralUtils.m1603a(ACCOUNT_NOT_EXIST_DESCRIPTION);
            return new Error(ErrorType.ACCOUNT_NOT_EXIST, m1603a, m1603a);
        }

        public static Error bleNotSupported() {
            String m1603a = GeneralUtils.m1603a(ERROR_NO_BLE_DESCRIPTION);
            return new Error(ErrorType.NO_BLE, m1603a, m1603a);
        }

        public static Error bluetoothDisabled() {
            String m1603a = GeneralUtils.m1603a(ERROR_BLUETOOTH_DISABLED_DESCRIPTION);
            return new Error(ErrorType.BLUETOOTH_DISABLED, m1603a, m1603a);
        }

        public static Error bluetoothScanFailed() {
            String m1603a = GeneralUtils.m1603a(ERROR_BLUETOOTH_SCAN_FAILED_DESCRIPTION);
            return new Error(ErrorType.BLUETOOTH_SCAN_FAILED, m1603a, m1603a);
        }

        public static Error card_not_enrolled() {
            String m1603a = GeneralUtils.m1603a(ERROR_CARD_NOT_ENROLLED_DESCRIPTION);
            return new Error(ErrorType.CARD_NOT_ENROLLED, m1603a, m1603a);
        }

        public static Error communication() {
            String m1603a = GeneralUtils.m1603a(ERROR_COMM_DESCRIPTION);
            return new Error(ErrorType.COMM, m1603a, m1603a);
        }

        public static Error emailAlreadyRegistered() {
            String m1603a = GeneralUtils.m1603a(ERROR_EMAIL_ALREADY_REGISTERED_DESCRIPTION);
            return new Error(ErrorType.EMAIL_ALREADY_REGISTERED, m1603a, m1603a);
        }

        public static Error equipment_invalid() {
            String m1603a = GeneralUtils.m1603a(EQUIPMENT_INVALID_DESCRIPTION);
            return new Error(ErrorType.EQUIPMENT_INVALID, m1603a, m1603a);
        }

        public static Error failed_to_enroll_card() {
            String m1603a = GeneralUtils.m1603a(FAILED_TO_ENROLL_CARD_DESCRIPTION);
            return new Error(ErrorType.FAILED_TO_ENROLL_CARD, m1603a, m1603a);
        }

        public static Error failed_to_send_report() {
            String m1603a = GeneralUtils.m1603a(FAILED_TO_SEND_REPORT_DESCRIPTION);
            return new Error(ErrorType.FAILED_TO_SEND_REPORT, m1603a, m1603a);
        }

        public static Error fieldRequired(String... strArr) {
            String m1603a = GeneralUtils.m1603a(ERROR_FIELD_REQUIRED_DESCRIPTION);
            for (String str : strArr) {
                m1603a = m1603a + " " + str + ";";
            }
            if (m1603a.substring(m1603a.length() - 1).equals(";")) {
                m1603a = m1603a.substring(0, m1603a.length() - 1);
            }
            return new Error(ErrorType.FIELD_REQUIRED, m1603a, m1603a);
        }

        public static Error getOfflinePermitError(String str) {
            String str2;
            if (str == null || !str.contains(";")) {
                str2 = "";
            } else {
                String[] split = str.split(";");
                str2 = split.length > 0 ? split[0] : "";
                str = split.length > 1 ? split[1] : "";
            }
            Error error = new DataModelDTOs$ErrorMessageDTO(str2.toUpperCase(), str, str).toError();
            if (error.getType() == ErrorType.INTERNAL) {
                error.setType(ErrorType.START_STAGE_OFFLINE_NOT_AUTHORIZED);
            }
            return error;
        }

        public static Error initFailedDataSuspect() {
            String m1603a = GeneralUtils.m1603a(INIT_FAILED_DATA_SUSPECT_DESCRIPTION);
            return new Error(ErrorType.INIT_FAILED_DATA_SUSPECT, m1603a, m1603a);
        }

        public static Error internal() {
            String m1603a = GeneralUtils.m1603a(ERROR_INTERNAL_DESCRIPTION);
            return new Error(ErrorType.INTERNAL, m1603a, m1603a);
        }

        public static Error locationDisabled() {
            String m1603a = GeneralUtils.m1603a(ERROR_LOCATION_DISABLED_DESCRIPTION);
            return new Error(ErrorType.LOCATION_DISABLED, m1603a, m1603a);
        }

        public static Error locationPermission() {
            String m1603a = GeneralUtils.m1603a(ERROR_LOCATION_PERMISSION_DESCRIPTION);
            return new Error(ErrorType.LOCATION_PERMISSION, m1603a, m1603a);
        }

        public static Error loginFailed() {
            String m1603a = GeneralUtils.m1603a(ERROR_LOGIN_FAILED_DESCRIPTION);
            return new Error(ErrorType.LOGIN_FAILED, m1603a, m1603a);
        }

        public static Error loginRequired() {
            String m1603a = GeneralUtils.m1603a(ERROR_LOGIN_REQUIRED_DESCRIPTION);
            return new Error(ErrorType.LOGIN_REQUIRED, m1603a, m1603a);
        }

        public static Error missingData() {
            String m1603a = GeneralUtils.m1603a(ERROR_MISSING_DATA_DESCRIPTION);
            return new Error(ErrorType.MISSING_DATA, m1603a, m1603a);
        }

        public static Error missingRegistrationKey() {
            String m1603a = GeneralUtils.m1603a(ERROR_MISSING_REGISTRATION_KEY_DESCRIPTION);
            return new Error(ErrorType.MISSING_REGISTRATION_KEY, m1603a, m1603a);
        }

        public static Error nfcDisabled() {
            String m1603a = GeneralUtils.m1603a(ERROR_NFC_DISABLED_DESCRIPTION);
            return new Error(ErrorType.NFC_DISABLED, m1603a, m1603a);
        }

        public static Error noBluetooth() {
            String m1603a = GeneralUtils.m1603a(ERROR_NO_BLUETOOTH_DESCRIPTION);
            return new Error(ErrorType.NO_BLUETOOTH, m1603a, m1603a);
        }

        public static Error noChanges() {
            String m1603a = GeneralUtils.m1603a(ERROR_NO_CHANGES_DESCRIPTION);
            return new Error(ErrorType.NO_CHANGES, m1603a, m1603a);
        }

        public static Error noInternet() {
            String m1603a = GeneralUtils.m1603a(ERROR_NO_INTERNET_DESCRIPTION);
            return new Error(ErrorType.NO_INTERNET, m1603a, m1603a);
        }

        public static Error noNFC() {
            String m1603a = GeneralUtils.m1603a(ERROR_NO_NFC_DESCRIPTION);
            return new Error(ErrorType.NO_NFC, m1603a, m1603a);
        }

        public static Error paymentMethodNotRecognized() {
            String m1603a = GeneralUtils.m1603a(ERROR_PAYMENTMETHOD_NOT_RECOGNIZED_DESCRIPTION);
            return new Error(ErrorType.PAYMENTMETHOD_NOT_RECOGNIZED, m1603a, m1603a);
        }

        public static Error payment_method_invalid() {
            String m1603a = GeneralUtils.m1603a(PAYMENT_METHOD_INVALID_DESCRIPTION);
            return new Error(ErrorType.PAYMENT_METHOD_INVALID, m1603a, m1603a);
        }

        public static Error payment_method_missing() {
            String m1603a = GeneralUtils.m1603a(PAYMENT_METHOD_MISSING_DESCRIPTION);
            return new Error(ErrorType.PAYMENT_METHOD_MISSING, m1603a, m1603a);
        }

        public static Error phonestatePermission() {
            String m1603a = GeneralUtils.m1603a(ERROR_PHONESTATE_PERMISSION_DESCRIPTION);
            return new Error(ErrorType.PHONESTATE_PERMISSION, m1603a, m1603a);
        }

        public static Error stageAlreadyStarted() {
            String m1603a = GeneralUtils.m1603a(ERROR_STAGE_ALREADY_STARTED_DESCRIPTION);
            return new Error(ErrorType.STAGE_ALREADY_STARTED, m1603a, m1603a);
        }

        public static Error stageOngoing() {
            String m1603a = GeneralUtils.m1603a(ERROR_STAGE_ONGOING_DESCRIPTION);
            return new Error(ErrorType.STAGE_ONGOING, m1603a, m1603a);
        }

        public static Error stageRequired() {
            String m1603a = GeneralUtils.m1603a(ERROR_STAGE_REQUIRED_DESCRIPTION);
            return new Error(ErrorType.STAGE_REQUIRED, m1603a, m1603a);
        }

        public static Error startStageNotAuthorized() {
            String m1603a = GeneralUtils.m1603a(START_STAGE_NOT_AUTHORIZED_DESCRIPTION);
            return new Error(ErrorType.START_STAGE_NOT_AUTHORIZED, m1603a, m1603a);
        }

        public static Error startStageOfflineNotAuthorized() {
            String m1603a = GeneralUtils.m1603a(START_STAGE_OFFLINE_NOT_AUTHORIZED_DESCRIPTION);
            return new Error(ErrorType.START_STAGE_OFFLINE_NOT_AUTHORIZED, m1603a, m1603a);
        }

        public static Error token_mistach() {
            String m1603a = GeneralUtils.m1603a(ERROR_TOKEN_MISMATCH_DESCRIPTION);
            return new Error(ErrorType.TOKEN_MISMATCH, m1603a, m1603a);
        }

        public static Error validation(String str, String str2) {
            return new Error(ErrorType.VALIDATION, str, str);
        }

        public String getMessage() {
            return this.message;
        }

        public String getMessageToUser() {
            return this.messageToUser;
        }

        public ErrorType getType() {
            return this.type;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        public void setMessageToUser(String str) {
            this.messageToUser = str;
        }

        public void setType(ErrorType errorType) {
            this.type = errorType;
        }

        public static Error internal(String str) {
            return new Error(ErrorType.INTERNAL, str, str);
        }
    }
}
