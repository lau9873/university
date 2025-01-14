package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        public void setLineOrientationRef(int i2) {
            this.lineOrientationRef = i2;
        }

        public void setLineRef(int i2) {
            this.lineRef = i2;
        }

        public void setLineVariantName(String str) {
            this.lineVariantName = str;
        }

        public void setLineVariantRef(int i2) {
            this.lineVariantRef = i2;
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

        public void setOperatorRef(int i2) {
            this.operatorRef = i2;
        }

        public void setPosition(int i2) {
            this.position = i2;
        }

        public void setRfu(int i2) {
            this.rfu = i2;
        }

        public void setRssi(int i2) {
            this.rssi = i2;
        }

        public void setStopName(String str) {
            this.stopName = str;
        }

        public void setStopRef(int i2) {
            this.stopRef = i2;
        }

        public void setTimestamp(long j) {
            this.timestamp = j;
        }

        public void setTxPower(int i2) {
            this.txPower = i2;
        }

        public void setUuid(String str) {
            this.uuid = str;
        }

        public void setVehicle(int i2) {
            this.vehicle = i2;
        }

        public void setVersion(int i2) {
            this.version = i2;
        }

        public void setZoneName(String str) {
            this.zoneName = str;
        }

        public void setZoneRef(int i2) {
            this.zoneRef = i2;
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
        public String id;
        public String name;

        public Country(String str, String str2, String str3) {
            this.id = str;
            this.code = str2;
            this.name = str3;
        }

        public String getCode() {
            return this.code;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class CustomerProfile {
        public String ID;
        public String Name;
        public int Ref;

        public CustomerProfile(String str, int i2, String str2) {
            this.ID = str;
            this.Ref = i2;
            this.Name = str2;
        }

        public String getID() {
            return this.ID;
        }

        public String getName() {
            return this.Name;
        }

        public int getRef() {
            return this.Ref;
        }

        public void setID(String str) {
            this.ID = str;
        }

        public void setName(String str) {
            this.Name = str;
        }

        public void setRef(int i2) {
            this.Ref = i2;
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

        public InvoiceInfo(String str, String str2, String str3, Date date, float f2) {
            this.InvoiceId = str;
            this.DocumentNumber = str2;
            this.DocumentLink = str3;
            this.IssueDate = date;
            this.Total = f2;
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

        public void setTotal(float f2) {
            this.Total = f2;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class Language implements Serializable {
        public String code;
        public String id;
        public String name;

        public Language(String str, String str2, String str3) {
            this.id = str;
            this.code = str2;
            this.name = str3;
        }

        public String getCode() {
            return this.code;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class NewStageStartInfo {
        public String id;
        public Date startDate;
        public boolean startOffline;
        public int tripCounter;

        public NewStageStartInfo(String str, Date date, boolean z, int i2) {
            this.id = str;
            this.startDate = date;
            this.startOffline = z;
            this.tripCounter = i2;
        }

        public String getId() {
            return this.id;
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
            return new c.d.b.f().a(this, PaymentMethod.class);
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

        public void setBeaconDataId(int i2) {
            this.beaconDataId = i2;
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

        public void setTransportOperatorRef(int i2) {
            this.transportOperatorRef = i2;
        }

        public void setTripId(String str) {
            this.tripId = str;
        }

        public StageInfo(String str, int i2, int i3, String str2, String str3, String str4, String str5, String str6, String str7, Date date, Date date2, boolean z, String str8, String str9, String str10, String str11, boolean z2, String str12, String str13, Date date3, String str14, String str15, Date date4) {
            this.stageId = str;
            this.beaconDataId = i2;
            this.transportOperatorRef = i3;
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

        public void setOperatorRef(int i2) {
            this.operatorRef = i2;
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

        public void setStopOrder(int i2) {
            this.stopOrder = i2;
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
                str3 = " Validation: " + h.a.a.p.b(getValidationDatetime());
            } else if (getDatetime() != null) {
                str3 = h.a.a.p.b(getDatetime());
            }
            sb.append(str3);
            return sb.toString();
        }

        public StopInfo(String str, int i2, String str2, String str3, String str4, String str5, String str6, String str7, Date date, Date date2) {
            this.key = str == null ? "" : str;
            this.operatorRef = i2;
            this.operatorName = str2 == null ? "" : str2;
            this.lineName = str3 == null ? "" : str3;
            this.stopName = str4 == null ? "" : str4;
            this.stopCode = str5 == null ? "" : str5;
            this.zone = str7 == null ? "" : str7;
            this.orientation = str6 == null ? "" : str6;
            this.datetime = date;
            this.validationDatetime = date2;
        }

        public StopInfo(b bVar) {
            this.key = bVar.n();
            this.operatorRef = bVar.k() == null ? 0 : bVar.k().b();
            this.operatorName = bVar.k() == null ? "" : bVar.k().a();
            this.lineName = bVar.h() == null ? "" : bVar.h().b();
            q m = bVar.m();
            if (m != null) {
                this.stopName = m.c() == null ? "" : m.c();
                this.stopCode = m.a() == null ? "" : m.a();
            } else {
                this.stopName = "";
                this.stopCode = "";
            }
            this.zone = bVar.q() == null ? "" : bVar.q().a();
            this.orientation = bVar.i() != null ? bVar.i().b() : "";
            this.datetime = bVar.d();
            this.validationDatetime = bVar.o();
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

        public void setTotalCredit(float f2) {
            this.totalCredit = f2;
        }

        public void setTotalDebt(float f2) {
            this.totalDebt = f2;
        }

        public void setTotalSave(float f2) {
            this.totalSave = f2;
        }

        public TariffInfo(List<StageInfo> list, float f2, float f3, float f4) {
            this.stageInfoList = list;
            this.totalDebt = f2;
            this.totalSave = f3;
            this.totalCredit = f4;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class User {
        public String email;
        public boolean hasPaymentMethod;
        public String id;
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
            return this.id;
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
            this.id = str;
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
            this.id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
            this.photo = user.getPhoto();
        }

        public User(String str, String str2, String str3, String str4, String str5, Boolean bool) {
            this.id = str;
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
        public String id;
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
            return this.id;
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
            this.id = str;
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
            this.id = str;
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
        public String ID;
        public String Name;
        public String NotifyEmail;
        public String PostalCode;

        public UserBillingInfo(String str, String str2, String str3, String str4, String str5, String str6, Country country, String str7) {
            this.ID = str;
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
            return this.ID;
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
            this.ID = str;
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
        public String ID;
        public String ProfileId;
        public String ProfileName;
        public Date StartDate;

        public UserProfileInfo(String str, String str2, String str3, Date date, Date date2) {
            this.ID = str;
            this.ProfileId = str2;
            this.ProfileName = str3;
            this.StartDate = date;
            this.EndDate = date2;
        }

        public Date getEndDate() {
            return this.EndDate;
        }

        public String getID() {
            return this.ID;
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
            this.ID = str;
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

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Date f7669a;

        /* renamed from: b  reason: collision with root package name */
        public Date f7670b;

        /* renamed from: c  reason: collision with root package name */
        public Date f7671c;

        /* renamed from: d  reason: collision with root package name */
        public String f7672d;

        /* renamed from: e  reason: collision with root package name */
        public int f7673e;

        /* renamed from: f  reason: collision with root package name */
        public Date f7674f;

        /* renamed from: g  reason: collision with root package name */
        public long f7675g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f7676h;

        /* renamed from: i  reason: collision with root package name */
        public double f7677i;
        public double j;
        public double k;
        public String l;
        public Date m;

        public a(String str, String str2, int i2, String str3, boolean z) {
            this.f7672d = str2;
            this.f7673e = i2;
            this.f7676h = z;
        }

        public void a(Date date) {
            this.f7669a = date;
        }

        public void b(Date date) {
            this.f7671c = date;
        }

        public void c(double d2) {
            this.j = d2;
        }

        public void d(Date date) {
            this.f7670b = date;
        }

        public Boolean e() {
            return Boolean.valueOf(this.f7676h);
        }

        public Date f() {
            return this.f7670b;
        }

        public double g() {
            return this.f7677i;
        }

        public double h() {
            return this.k;
        }

        public double i() {
            return this.j;
        }

        public String j() {
            return this.f7672d;
        }

        public int k() {
            return this.f7673e;
        }

        public Date l() {
            return this.f7674f;
        }

        public long m() {
            return this.f7675g;
        }

        public Date a() {
            return this.f7669a;
        }

        public Date b() {
            return this.f7671c;
        }

        public String c() {
            return this.l;
        }

        public Date d() {
            return this.m;
        }

        public void a(Date date, long j) {
            this.f7674f = date;
            this.f7675g = j;
        }

        public void b(double d2) {
            this.k = d2;
        }

        public void c(Date date) {
            this.m = date;
        }

        public void a(double d2) {
            this.f7677i = d2;
        }

        public void a(String str) {
            this.l = str;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f7678a;

        /* renamed from: b  reason: collision with root package name */
        public int f7679b;

        /* renamed from: c  reason: collision with root package name */
        public m f7680c;

        /* renamed from: d  reason: collision with root package name */
        public j f7681d;

        /* renamed from: e  reason: collision with root package name */
        public r f7682e;

        /* renamed from: f  reason: collision with root package name */
        public q f7683f;

        /* renamed from: g  reason: collision with root package name */
        public l f7684g;

        /* renamed from: h  reason: collision with root package name */
        public k f7685h;

        /* renamed from: i  reason: collision with root package name */
        public int f7686i;
        public boolean j;
        public String k;
        public Date l;
        public Date m;
        public Date n;
        public d o;
        public List<a> p = new ArrayList();
        public Map<String, a> q = new HashMap();
        public Date r;

        public b() {
        }

        public void a(int i2) {
        }

        public void a(m mVar) {
            this.f7680c = mVar;
        }

        public void b(Date date) {
            this.n = date;
        }

        public void c(Date date) {
            this.m = date;
        }

        public Date d() {
            return this.l;
        }

        public Date e() {
            return this.n;
        }

        public String f() {
            return this.f7678a;
        }

        public Date g() {
            return this.m;
        }

        public j h() {
            return this.f7681d;
        }

        public k i() {
            return this.f7685h;
        }

        public l j() {
            return this.f7684g;
        }

        public m k() {
            return this.f7680c;
        }

        public int l() {
            return this.f7679b;
        }

        public q m() {
            return this.f7683f;
        }

        public String n() {
            if (this.k == null) {
                int b2 = k() == null ? 0 : k().b();
                int e2 = h() == null ? 0 : h().e();
                int c2 = i() == null ? 0 : i().c();
                int d2 = m() == null ? 0 : m().d();
                int b3 = q() != null ? q().b() : 0;
                this.k = b2 + "|" + e2 + "|" + d2 + "|" + c2 + "|" + b3;
            }
            return this.k;
        }

        public Date o() {
            return this.r;
        }

        public int p() {
            return this.f7686i;
        }

        public r q() {
            return this.f7682e;
        }

        public boolean r() {
            return this.j;
        }

        public String toString() {
            String str;
            String str2;
            String str3;
            if (h() == null) {
                str = "Line: null";
            } else {
                str = "Line: " + h().b();
            }
            String str4 = str + "; Orientation: ";
            if (i() == null) {
                str2 = str4 + "null";
            } else {
                str2 = str4 + i().b();
            }
            String str5 = str2 + "; Stop: ";
            if (m() == null) {
                str3 = str5 + "null";
            } else {
                str3 = str5 + m().c();
            }
            String str6 = str3 + "; BeaconInfoType: ";
            if (a() == null) {
                return str6 + "null";
            }
            return str6 + "id = " + a().b() + ", code = " + a().a() + ", name = " + a().c();
        }

        public void a(j jVar) {
            this.f7681d = jVar;
        }

        public List<a> b() {
            return this.p;
        }

        public Map<String, a> c() {
            return this.q;
        }

        public void a(r rVar) {
            this.f7682e = rVar;
        }

        public b(c cVar) {
            this.f7678a = cVar.f();
            cVar.z();
            this.f7686i = cVar.y();
            this.f7679b = cVar.n();
            cVar.o();
            this.n = null;
            Date a2 = h.a.a.p.a(cVar.r());
            this.m = a2;
            this.l = a2;
            a(cVar);
        }

        public void a(q qVar) {
            this.f7683f = qVar;
        }

        public void a(l lVar) {
            this.f7684g = lVar;
        }

        public void a(k kVar) {
            this.f7685h = kVar;
        }

        public void a(boolean z) {
            this.j = z;
        }

        public void a(String str) {
            this.j = str != null;
        }

        public void a(Date date) {
            this.l = date;
        }

        public d a() {
            return this.o;
        }

        public void a(d dVar) {
            this.o = dVar;
        }

        public void a(c cVar) {
            Date a2 = h.a.a.p.a(cVar.r());
            h.a.a.p.a(cVar.s());
            Date a3 = cVar.w() > 0 ? h.a.a.p.a(cVar.w()) : null;
            long v = cVar.v();
            this.n = null;
            a aVar = this.q.get(cVar.a());
            if (aVar == null) {
                aVar = new a(cVar.k(), cVar.a(), cVar.p(), cVar.u(), cVar.e());
                aVar.a(h.a.a.p.a(cVar.r()));
                if (a3 != null) {
                    aVar.a(a3, v);
                }
                if (cVar.c() != null) {
                    aVar.a(cVar.c());
                    aVar.c(cVar.d() > 0 ? h.a.a.p.a(cVar.d()) : null);
                }
                this.q.put(aVar.j(), aVar);
                this.p.add(aVar);
            }
            aVar.d(a2);
            aVar.b((Date) null);
            aVar.a(cVar.g());
            aVar.c(cVar.j());
            aVar.b(cVar.i());
            this.m = a2;
            if (a3 != null) {
                this.r = a3;
            }
            if (cVar.c() != null) {
                cVar.c();
                if (cVar.d() > 0) {
                    h.a.a.p.a(cVar.d());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public long A;

        /* renamed from: a  reason: collision with root package name */
        public String f7687a;

        /* renamed from: b  reason: collision with root package name */
        public String f7688b;

        /* renamed from: c  reason: collision with root package name */
        public String f7689c;

        /* renamed from: d  reason: collision with root package name */
        public String f7690d;

        /* renamed from: e  reason: collision with root package name */
        public int f7691e;

        /* renamed from: f  reason: collision with root package name */
        public long f7692f;

        /* renamed from: g  reason: collision with root package name */
        public long f7693g;

        /* renamed from: h  reason: collision with root package name */
        public int f7694h;

        /* renamed from: i  reason: collision with root package name */
        public List<Integer> f7695i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public boolean t;
        public long u;
        public double v;
        public double w;
        public double x;
        public long y;
        public String z;

        /* loaded from: classes.dex */
        public class a implements Comparator<c> {
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(c cVar, c cVar2) {
                return cVar.b() - cVar2.b();
            }
        }

        static {
            new a();
        }

        public c() {
        }

        public int A() {
            return this.r;
        }

        public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.j = i2;
            this.k = i3;
            this.l = i4;
            this.m = i5;
            this.n = i6;
            this.o = i7;
            this.p = i8;
            this.q = i9;
            this.r = i10;
            this.s = i12;
        }

        public int b() {
            List<Integer> list = this.f7695i;
            if (list != null) {
                return (int) h.a.a.p.b(list);
            }
            return 65536;
        }

        public String c() {
            return this.z;
        }

        public long d() {
            return this.A;
        }

        public boolean e() {
            return this.t;
        }

        public String f() {
            return this.f7687a;
        }

        public double g() {
            return this.v;
        }

        public int h() {
            return this.n;
        }

        public double i() {
            return this.x;
        }

        public double j() {
            return this.w;
        }

        public String k() {
            return this.f7688b;
        }

        public int l() {
            return this.k;
        }

        public int m() {
            return this.p;
        }

        public int n() {
            return this.m;
        }

        public int o() {
            return this.s;
        }

        public int p() {
            return this.f7691e;
        }

        public int q() {
            return this.q;
        }

        public long r() {
            return this.f7692f;
        }

        public long s() {
            return this.f7693g;
        }

        public int t() {
            return this.f7694h;
        }

        public String toString() {
            return (((((("MAC: " + this.f7689c + "\n") + "Op: " + l() + "\n") + "LC: " + h() + "\n") + "Dr: " + m() + "\n") + "Va: " + x() + "\n") + "St: " + q() + "\n") + "Zn: " + A() + "\n";
        }

        public String u() {
            return this.f7690d;
        }

        public long v() {
            return this.y;
        }

        public long w() {
            return this.u;
        }

        public int x() {
            return this.o;
        }

        public int y() {
            return this.l;
        }

        public int z() {
            return this.j;
        }

        public c(String str, String str2, String str3, int i2, int i3, long j, long j2, boolean z, long j3, double d2, double d3, double d4, long j4, String str4, long j5) {
            this.f7687a = str;
            this.f7688b = str2;
            this.f7689c = str3;
            this.f7691e = i2;
            this.f7694h = i3;
            this.f7692f = j;
            this.f7693g = j2;
            this.t = z;
            this.u = j3;
            this.v = d2;
            this.w = d3;
            this.x = d4;
            this.y = j4;
            this.z = str4;
            this.A = j5;
        }

        public String a() {
            return this.f7689c;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f7696a;

        /* renamed from: b  reason: collision with root package name */
        public String f7697b;

        /* renamed from: c  reason: collision with root package name */
        public String f7698c;

        public d(String str, String str2, String str3) {
            this.f7696a = str;
            this.f7697b = str2;
            this.f7698c = str3;
        }

        public String a() {
            return this.f7698c;
        }

        public String b() {
            return this.f7696a;
        }

        public String c() {
            return this.f7697b;
        }

        public String toString() {
            return this.f7697b;
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public Date f7699a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7700b;

        /* renamed from: c  reason: collision with root package name */
        public Date f7701c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f7702d;

        /* renamed from: e  reason: collision with root package name */
        public String f7703e;

        /* renamed from: f  reason: collision with root package name */
        public String f7704f;

        public e(Date date, boolean z, Date date2, boolean z2, String str, String str2) {
            this.f7699a = date;
            this.f7700b = z;
            this.f7701c = date2;
            this.f7702d = z2;
            this.f7703e = str;
            this.f7704f = str2;
        }

        public String a() {
            return this.f7703e;
        }

        public String b() {
            return this.f7704f;
        }

        public Date c() {
            return this.f7701c;
        }

        public boolean d() {
            return this.f7702d;
        }

        public boolean e() {
            return this.f7700b;
        }

        public Date f() {
            return this.f7699a;
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f7705a;

        /* renamed from: b  reason: collision with root package name */
        public String f7706b;

        public f(String str, String str2, boolean z, String str3, String str4) {
            this.f7705a = str;
            this.f7706b = str2;
        }

        public String a() {
            return this.f7706b;
        }

        public String toString() {
            return this.f7705a;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends Throwable {

        /* renamed from: a  reason: collision with root package name */
        public Error f7707a;

        public g(Error error) {
            this.f7707a = error;
        }

        public Error a() {
            return this.f7707a;
        }
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: i  reason: collision with root package name */
        public static String f7708i = "BLUETOOTH_STATE_CHANGE_ON";
        public static String j = "BLUETOOTH_STATE_CHANGE_OFF";
        public static String k = "EVENT_TYPE_APP_CRASH";
        public static String l = "EVENT_TYPE_BATTERY_LEVEL";
        public static String m = "CUSTOMER_REPORT";
        public static String n = "TRIP_ACTIVITY_BLOCKED";
        public static String o = "EVENT_TYPE_ENROLL_FAIL";
        public static String p = "EVENT_TYPE_ENROLL_OK";

        /* renamed from: a  reason: collision with root package name */
        public String f7709a;

        /* renamed from: b  reason: collision with root package name */
        public String f7710b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7711c;

        /* renamed from: d  reason: collision with root package name */
        public Date f7712d;

        /* renamed from: e  reason: collision with root package name */
        public String f7713e;

        /* renamed from: f  reason: collision with root package name */
        public Date f7714f;

        /* renamed from: g  reason: collision with root package name */
        public String f7715g;

        /* renamed from: h  reason: collision with root package name */
        public String f7716h;

        public h(String str, String str2, Boolean bool, Date date, String str3, Date date2, String str4, String str5) {
            this.f7709a = str;
            this.f7710b = str2;
            this.f7711c = bool.booleanValue();
            this.f7712d = date;
            this.f7713e = str3;
            this.f7714f = date2;
            this.f7715g = str4;
            this.f7716h = str5;
        }

        public String a() {
            return this.f7709a;
        }

        public String b() {
            return this.f7713e;
        }

        public String c() {
            return this.f7716h;
        }

        public String d() {
            return this.f7715g;
        }

        public String e() {
            return this.f7710b;
        }

        public Date f() {
            return this.f7712d;
        }

        public Boolean g() {
            return Boolean.valueOf(this.f7711c);
        }

        public Date h() {
            return this.f7714f;
        }
    }

    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public String f7717a;

        /* renamed from: b  reason: collision with root package name */
        public String f7718b;

        /* renamed from: c  reason: collision with root package name */
        public long f7719c;

        public i(String str, String str2, String str3, long j) {
            this.f7717a = str2;
            this.f7718b = str3;
            this.f7719c = j;
        }

        public long a() {
            return this.f7719c;
        }

        public String b() {
            return this.f7718b;
        }

        public String c() {
            return this.f7717a;
        }
    }

    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public String f7720a;

        /* renamed from: b  reason: collision with root package name */
        public int f7721b;

        /* renamed from: c  reason: collision with root package name */
        public String f7722c;

        /* renamed from: d  reason: collision with root package name */
        public int f7723d;

        /* renamed from: e  reason: collision with root package name */
        public int f7724e;

        public j(String str, int i2, String str2, int i3, int i4) {
            this.f7720a = str;
            this.f7721b = i2;
            this.f7722c = str2;
            this.f7723d = i3;
            this.f7724e = i4;
        }

        public String a() {
            return this.f7720a;
        }

        public String b() {
            return this.f7722c;
        }

        public int c() {
            return this.f7723d;
        }

        public int d() {
            return this.f7724e;
        }

        public int e() {
            return this.f7721b;
        }

        public String toString() {
            return this.f7722c;
        }
    }

    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public String f7725a;

        /* renamed from: b  reason: collision with root package name */
        public int f7726b;

        /* renamed from: c  reason: collision with root package name */
        public String f7727c;

        public k(String str, int i2, String str2, int i3) {
            this.f7725a = str;
            this.f7726b = i2;
            this.f7727c = str2;
        }

        public String a() {
            return this.f7725a;
        }

        public String b() {
            return this.f7727c;
        }

        public int c() {
            return this.f7726b;
        }
    }

    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a  reason: collision with root package name */
        public int f7728a;

        /* renamed from: b  reason: collision with root package name */
        public String f7729b;

        public l(int i2, String str) {
            this.f7728a = i2;
            this.f7729b = str;
        }

        public String a() {
            return this.f7729b;
        }

        public int b() {
            return this.f7728a;
        }

        public String toString() {
            return this.f7729b;
        }
    }

    /* loaded from: classes.dex */
    public static class m {

        /* renamed from: a  reason: collision with root package name */
        public int f7730a;

        /* renamed from: b  reason: collision with root package name */
        public String f7731b;

        /* renamed from: c  reason: collision with root package name */
        public n f7732c;

        /* renamed from: d  reason: collision with root package name */
        public int f7733d;

        /* renamed from: e  reason: collision with root package name */
        public int f7734e;

        public m(int i2, String str, n nVar, int i3, int i4) {
            this.f7730a = i2;
            this.f7731b = str;
            this.f7732c = nVar;
            this.f7733d = i3;
            this.f7734e = i4;
        }

        public String a() {
            return this.f7731b;
        }

        public int b() {
            return this.f7730a;
        }

        public int c() {
            return this.f7734e;
        }

        public int d() {
            return this.f7733d;
        }

        public n e() {
            return this.f7732c;
        }

        public String toString() {
            return this.f7731b;
        }
    }

    /* loaded from: classes.dex */
    public static class n {

        /* renamed from: c  reason: collision with root package name */
        public static int f7735c = 1;

        /* renamed from: a  reason: collision with root package name */
        public int f7736a;

        /* renamed from: b  reason: collision with root package name */
        public String f7737b;

        public n(int i2, String str) {
            this.f7736a = i2;
            this.f7737b = str;
        }

        public int a() {
            return this.f7736a;
        }

        public String toString() {
            return this.f7737b;
        }
    }

    /* loaded from: classes.dex */
    public static class o {
        public static String A = "FIRST_STOP_TIMEOUT_FINISH_CONFIRMED";
        public static String B = "FIRST_STOP_TIMEOUT_FINISH_NOT_CONFIRMED";
        public static String C = "NOT_AUTHORIZED_FINISH";
        public static short D = 1;
        public static short E = 2;
        public static short F = 3;
        public static String l = "MANUAL_FINISH";
        public static String m = "TIMEOUT_FINISH";
        public static String n = "STEP_DETECTION_FINISH";
        public static String o = "NEWSTAGE_FINISH";
        public static String p = "APP_START_WITH_ONGOING_STAGE_FINISH";
        public static String q = "REPEATED_INFO_RECEIVED_FINISH";
        public static String r = "FIRST_STOP_TIMEOUT_FINISH";
        public static String s = "TIMEOUT_FINISH_CONFIRMED";
        public static String t = "TIMEOUT_FINISH_NOT_CONFIRMED";
        public static String u = "STEP_DETECTION_FINISH_CONFIRMED";
        public static String v = "STEP_DETECTION_FINISH_NOT_CONFIRMED";
        public static String w = "REPEATED_INFO_RECEIVED_CONFIRMED";
        public static String x = "REPEATED_INFO_RECEIVED_NOT_CONFIRMED";
        public static String y = "BT_OFF_TIMEOUT_FINISH";
        public static String z = "BT_OFF_MAX_OCCUR_FINISH";

        /* renamed from: a  reason: collision with root package name */
        public String f7738a;

        /* renamed from: b  reason: collision with root package name */
        public String f7739b;

        /* renamed from: c  reason: collision with root package name */
        public String f7740c;

        /* renamed from: d  reason: collision with root package name */
        public String f7741d;

        /* renamed from: e  reason: collision with root package name */
        public String f7742e;

        /* renamed from: f  reason: collision with root package name */
        public String f7743f;

        /* renamed from: g  reason: collision with root package name */
        public List<DataModelDTOs$StageInformationBeaconDTO> f7744g;

        /* renamed from: h  reason: collision with root package name */
        public short f7745h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f7746i;
        public int j;
        public String k;

        public o(String str, String str2, String str3, String str4, String str5, String str6, List<DataModelDTOs$StageInformationBeaconDTO> list, boolean z2, int i2, short s2, String str7) {
            this.f7738a = str;
            this.f7739b = str2;
            this.f7740c = str3;
            this.f7741d = str4;
            this.f7742e = str5;
            this.f7743f = str6;
            this.f7744g = list;
            this.f7746i = z2;
            this.f7745h = s2;
            this.j = i2;
            this.k = str7;
        }

        public List<DataModelDTOs$StageInformationBeaconDTO> a() {
            return this.f7744g;
        }

        public String b() {
            return this.f7739b;
        }

        public String c() {
            return this.f7743f;
        }

        public String d() {
            return this.f7741d;
        }

        public String e() {
            return this.f7742e;
        }

        public String f() {
            return this.k;
        }

        public String g() {
            return this.f7740c;
        }

        public String h() {
            return this.f7738a;
        }

        public short i() {
            return this.f7745h;
        }

        public boolean j() {
            return this.f7746i;
        }

        public int k() {
            return this.j;
        }
    }

    /* loaded from: classes.dex */
    public static class p {

        /* renamed from: a  reason: collision with root package name */
        public int f7747a;

        /* renamed from: b  reason: collision with root package name */
        public String f7748b;

        /* renamed from: c  reason: collision with root package name */
        public String f7749c;

        /* renamed from: d  reason: collision with root package name */
        public int f7750d;

        /* renamed from: e  reason: collision with root package name */
        public int f7751e;

        /* renamed from: f  reason: collision with root package name */
        public int f7752f;

        /* renamed from: g  reason: collision with root package name */
        public int f7753g;

        /* renamed from: h  reason: collision with root package name */
        public int f7754h;

        /* renamed from: i  reason: collision with root package name */
        public List<b> f7755i = new ArrayList();
        public Boolean j;
        public Date k;
        public int l;
        public Date m;
        public long n;
        public Date o;
        public short p;
        public Date q;

        public void a(String str) {
            this.f7748b = str;
        }

        public void b(String str) {
            this.f7749c = str;
        }

        public void c(int i2) {
            this.f7753g = i2;
        }

        public String d() {
            return this.f7748b;
        }

        public void e(int i2) {
            this.f7747a = i2;
        }

        public int f() {
            return this.f7754h;
        }

        public int g() {
            return this.f7751e;
        }

        public int h() {
            return this.f7753g;
        }

        public int i() {
            return this.f7750d;
        }

        public Date j() {
            return this.m;
        }

        public long k() {
            return this.n;
        }

        public String l() {
            return this.f7749c;
        }

        public Date m() {
            return this.k;
        }

        public Boolean n() {
            return this.j;
        }

        public int o() {
            return this.f7747a;
        }

        public int p() {
            return this.l;
        }

        public int q() {
            return this.f7752f;
        }

        public void a(int i2) {
            this.f7754h = i2;
        }

        public void b(int i2) {
            this.f7751e = i2;
        }

        public void c(Date date) {
            this.k = date;
        }

        public void d(int i2) {
            this.f7750d = i2;
        }

        public Date e() {
            return this.q;
        }

        public void f(int i2) {
            this.l = i2;
        }

        public void g(int i2) {
            this.f7752f = i2;
        }

        public void a(Boolean bool) {
            this.j = bool;
        }

        public Date b() {
            return this.o;
        }

        public short c() {
            return this.p;
        }

        public void a(Date date, long j) {
            this.m = date;
            this.n = j;
        }

        public void b(Date date) {
            this.q = date;
        }

        public List<b> a() {
            return this.f7755i;
        }

        public void a(Date date) {
            this.o = date;
        }

        public void a(short s) {
            this.p = s;
        }
    }

    /* loaded from: classes.dex */
    public static class q {

        /* renamed from: a  reason: collision with root package name */
        public String f7756a;

        /* renamed from: b  reason: collision with root package name */
        public int f7757b;

        /* renamed from: c  reason: collision with root package name */
        public String f7758c;

        /* renamed from: d  reason: collision with root package name */
        public String f7759d;

        public q(String str, int i2, String str2, String str3) {
            this.f7756a = str;
            this.f7757b = i2;
            this.f7758c = str2;
            this.f7759d = str3;
        }

        public String a() {
            return this.f7759d;
        }

        public String b() {
            return this.f7756a;
        }

        public String c() {
            return this.f7758c;
        }

        public int d() {
            return this.f7757b;
        }

        public String toString() {
            return this.f7758c;
        }
    }

    /* loaded from: classes.dex */
    public static class r {

        /* renamed from: a  reason: collision with root package name */
        public int f7760a;

        /* renamed from: b  reason: collision with root package name */
        public String f7761b;

        public r(int i2, String str) {
            this.f7760a = i2;
            this.f7761b = str;
        }

        public String a() {
            return this.f7761b;
        }

        public int b() {
            return this.f7760a;
        }

        public String toString() {
            return this.f7761b;
        }
    }

    @Keep
    /* loaded from: classes.dex */
    public static class Error {
        public String message;
        public String messageToUser;
        public ErrorType type;
        public static final int ERROR_COMM_DESCRIPTION = h.a.a.a.err_msg_connectiontimeout;
        public static final int ERROR_COMM_USER_DESCRIPTION = h.a.a.a.err_msguser_connectiontimeout;
        public static final int ERROR_NO_BLUETOOTH_DESCRIPTION = h.a.a.a.err_msg_bluetoothnotsupported;
        public static final int ERROR_BLUETOOTH_DISABLED_DESCRIPTION = h.a.a.a.err_msg_bluetoothdisabled;
        public static final int ERROR_NO_BLE_DESCRIPTION = h.a.a.a.err_msg_ble_not_supported;
        public static final int ERROR_PHONESTATE_PERMISSION_DESCRIPTION = h.a.a.a.err_msg_phonestatepermission;
        public static final int ERROR_PHONESTATE_PERMISSION_USER_DESCRIPTION = h.a.a.a.err_msguser_phonestatepermission;
        public static final int ERROR_LOCATION_PERMISSION_DESCRIPTION = h.a.a.a.err_msg_locationpermission;
        public static final int ERROR_LOCATION_DISABLED_DESCRIPTION = h.a.a.a.err_msg_locationdisabled;
        public static final int ERROR_BLUETOOTH_SCAN_FAILED_DESCRIPTION = h.a.a.a.err_msg_bluetoothscanfailed;
        public static final int ERROR_FIELD_REQUIRED_DESCRIPTION = h.a.a.a.err_msg_missingfields;
        public static final int ERROR_EMAIL_ALREADY_REGISTERED_DESCRIPTION = h.a.a.a.err_msg_emailalreadyregistered;
        public static final int ERROR_LOGIN_REQUIRED_DESCRIPTION = h.a.a.a.err_msg_loginrequired;
        public static final int ERROR_STAGE_REQUIRED_DESCRIPTION = h.a.a.a.err_msg_stagerequired;
        public static final int ERROR_STAGE_ALREADY_STARTED_DESCRIPTION = h.a.a.a.err_msg_stagealreadystarted;
        public static final int ERROR_MISSING_DATA_DESCRIPTION = h.a.a.a.err_msg_missingdata;
        public static final int ERROR_NO_CHANGES_DESCRIPTION = h.a.a.a.err_msg_customerupdatenochanges;
        public static final int ERROR_STAGE_ONGOING_DESCRIPTION = h.a.a.a.err_msg_stageongoing;
        public static final int ERROR_PAYMENTMETHOD_NOT_RECOGNIZED_DESCRIPTION = h.a.a.a.err_msg_paymentmethod_not_recognized;
        public static final int START_STAGE_OFFLINE_NOT_AUTHORIZED_DESCRIPTION = h.a.a.a.err_msg_start_stage_offline_not_authorized;
        public static final int ERROR_NO_NFC_DESCRIPTION = h.a.a.a.err_msg_nfc_not_supported;
        public static final int ERROR_NFC_DISABLED_DESCRIPTION = h.a.a.a.err_msg_nfc_disabled;
        public static final int ERROR_LOGIN_FAILED_DESCRIPTION = h.a.a.a.err_msg_loginfailed;
        public static final int START_STAGE_NOT_AUTHORIZED_DESCRIPTION = h.a.a.a.err_msg_start_stage_not_authorized;
        public static final int INIT_FAILED_DATA_SUSPECT_DESCRIPTION = h.a.a.a.err_msg_init_failed_data_suspect;
        public static final int ERROR_NO_INTERNET_DESCRIPTION = h.a.a.a.err_msg_no_internet;
        public static final int PAYMENT_METHOD_MISSING_DESCRIPTION = h.a.a.a.err_msg_payment_method_missing_description;
        public static final int PAYMENT_METHOD_INVALID_DESCRIPTION = h.a.a.a.err_msg_payment_method_invalid_description;
        public static final int EQUIPMENT_INVALID_DESCRIPTION = h.a.a.a.err_msg_equipment_invalid_description;
        public static final int ACCOUNT_INTO_BLACK_LIST_DESCRIPTION = h.a.a.a.err_msg_account_into_black_list_description;
        public static final int ACCOUNT_NOT_CONFIRMED_DESCRIPTION = h.a.a.a.err_msg_account_not_confirmed_description;
        public static final int ACCOUNT_NOT_EXIST_DESCRIPTION = h.a.a.a.err_msg_account_not_exist_description;
        public static final int FAILED_TO_SEND_REPORT_DESCRIPTION = h.a.a.a.err_msg_failed_to_send_report_description;
        public static final int FAILED_TO_ENROLL_CARD_DESCRIPTION = h.a.a.a.err_msg_failed_to_enroll_card_description;
        public static final int ERROR_CARD_NOT_ENROLLED_DESCRIPTION = h.a.a.a.err_msg_card_not_enrolled_description;
        public static final int ERROR_ACCOUNT_MISMATCH_DESCRIPTION = h.a.a.a.err_msg_account_mismatch_description;
        public static final int ERROR_TOKEN_MISMATCH_DESCRIPTION = h.a.a.a.err_msg_token_mismatch_description;
        public static final int ERROR_INTERNAL_DESCRIPTION = h.a.a.a.err_msg_internal_description;
        public static final int ERROR_MISSING_REGISTRATION_KEY_DESCRIPTION = h.a.a.a.err_msg_missing_registration_key_description;

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
            String a2 = h.a.a.p.a(ACCOUNT_INTO_BLACK_LIST_DESCRIPTION);
            return new Error(ErrorType.ACCOUNT_INTO_BLACK_LIST, a2, a2);
        }

        public static Error account_mismatch(String str) {
            String a2 = h.a.a.p.a(ERROR_ACCOUNT_MISMATCH_DESCRIPTION);
            return new Error(ErrorType.ACCOUNT_MISMATCH, a2 + " [" + str + "]", a2 + " [" + str + "]");
        }

        public static Error account_not_confirmed() {
            String a2 = h.a.a.p.a(ACCOUNT_NOT_CONFIRMED_DESCRIPTION);
            return new Error(ErrorType.ACCOUNT_NOT_CONFIRMED, a2, a2);
        }

        public static Error account_not_exist() {
            String a2 = h.a.a.p.a(ACCOUNT_NOT_EXIST_DESCRIPTION);
            return new Error(ErrorType.ACCOUNT_NOT_EXIST, a2, a2);
        }

        public static Error bleNotSupported() {
            String a2 = h.a.a.p.a(ERROR_NO_BLE_DESCRIPTION);
            return new Error(ErrorType.NO_BLE, a2, a2);
        }

        public static Error bluetoothDisabled() {
            String a2 = h.a.a.p.a(ERROR_BLUETOOTH_DISABLED_DESCRIPTION);
            return new Error(ErrorType.BLUETOOTH_DISABLED, a2, a2);
        }

        public static Error bluetoothScanFailed() {
            String a2 = h.a.a.p.a(ERROR_BLUETOOTH_SCAN_FAILED_DESCRIPTION);
            return new Error(ErrorType.BLUETOOTH_SCAN_FAILED, a2, a2);
        }

        public static Error card_not_enrolled() {
            String a2 = h.a.a.p.a(ERROR_CARD_NOT_ENROLLED_DESCRIPTION);
            return new Error(ErrorType.CARD_NOT_ENROLLED, a2, a2);
        }

        public static Error communication() {
            String a2 = h.a.a.p.a(ERROR_COMM_DESCRIPTION);
            return new Error(ErrorType.COMM, a2, a2);
        }

        public static Error emailAlreadyRegistered() {
            String a2 = h.a.a.p.a(ERROR_EMAIL_ALREADY_REGISTERED_DESCRIPTION);
            return new Error(ErrorType.EMAIL_ALREADY_REGISTERED, a2, a2);
        }

        public static Error equipment_invalid() {
            String a2 = h.a.a.p.a(EQUIPMENT_INVALID_DESCRIPTION);
            return new Error(ErrorType.EQUIPMENT_INVALID, a2, a2);
        }

        public static Error failed_to_enroll_card() {
            String a2 = h.a.a.p.a(FAILED_TO_ENROLL_CARD_DESCRIPTION);
            return new Error(ErrorType.FAILED_TO_ENROLL_CARD, a2, a2);
        }

        public static Error failed_to_send_report() {
            String a2 = h.a.a.p.a(FAILED_TO_SEND_REPORT_DESCRIPTION);
            return new Error(ErrorType.FAILED_TO_SEND_REPORT, a2, a2);
        }

        public static Error fieldRequired(String... strArr) {
            String a2 = h.a.a.p.a(ERROR_FIELD_REQUIRED_DESCRIPTION);
            for (String str : strArr) {
                a2 = a2 + " " + str + ";";
            }
            if (a2.substring(a2.length() - 1).equals(";")) {
                a2 = a2.substring(0, a2.length() - 1);
            }
            return new Error(ErrorType.FIELD_REQUIRED, a2, a2);
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
            String a2 = h.a.a.p.a(INIT_FAILED_DATA_SUSPECT_DESCRIPTION);
            return new Error(ErrorType.INIT_FAILED_DATA_SUSPECT, a2, a2);
        }

        public static Error internal() {
            String a2 = h.a.a.p.a(ERROR_INTERNAL_DESCRIPTION);
            return new Error(ErrorType.INTERNAL, a2, a2);
        }

        public static Error locationDisabled() {
            String a2 = h.a.a.p.a(ERROR_LOCATION_DISABLED_DESCRIPTION);
            return new Error(ErrorType.LOCATION_DISABLED, a2, a2);
        }

        public static Error locationPermission() {
            String a2 = h.a.a.p.a(ERROR_LOCATION_PERMISSION_DESCRIPTION);
            return new Error(ErrorType.LOCATION_PERMISSION, a2, a2);
        }

        public static Error loginFailed() {
            String a2 = h.a.a.p.a(ERROR_LOGIN_FAILED_DESCRIPTION);
            return new Error(ErrorType.LOGIN_FAILED, a2, a2);
        }

        public static Error loginRequired() {
            String a2 = h.a.a.p.a(ERROR_LOGIN_REQUIRED_DESCRIPTION);
            return new Error(ErrorType.LOGIN_REQUIRED, a2, a2);
        }

        public static Error missingData() {
            String a2 = h.a.a.p.a(ERROR_MISSING_DATA_DESCRIPTION);
            return new Error(ErrorType.MISSING_DATA, a2, a2);
        }

        public static Error missingRegistrationKey() {
            String a2 = h.a.a.p.a(ERROR_MISSING_REGISTRATION_KEY_DESCRIPTION);
            return new Error(ErrorType.MISSING_REGISTRATION_KEY, a2, a2);
        }

        public static Error nfcDisabled() {
            String a2 = h.a.a.p.a(ERROR_NFC_DISABLED_DESCRIPTION);
            return new Error(ErrorType.NFC_DISABLED, a2, a2);
        }

        public static Error noBluetooth() {
            String a2 = h.a.a.p.a(ERROR_NO_BLUETOOTH_DESCRIPTION);
            return new Error(ErrorType.NO_BLUETOOTH, a2, a2);
        }

        public static Error noChanges() {
            String a2 = h.a.a.p.a(ERROR_NO_CHANGES_DESCRIPTION);
            return new Error(ErrorType.NO_CHANGES, a2, a2);
        }

        public static Error noInternet() {
            String a2 = h.a.a.p.a(ERROR_NO_INTERNET_DESCRIPTION);
            return new Error(ErrorType.NO_INTERNET, a2, a2);
        }

        public static Error noNFC() {
            String a2 = h.a.a.p.a(ERROR_NO_NFC_DESCRIPTION);
            return new Error(ErrorType.NO_NFC, a2, a2);
        }

        public static Error paymentMethodNotRecognized() {
            String a2 = h.a.a.p.a(ERROR_PAYMENTMETHOD_NOT_RECOGNIZED_DESCRIPTION);
            return new Error(ErrorType.PAYMENTMETHOD_NOT_RECOGNIZED, a2, a2);
        }

        public static Error payment_method_invalid() {
            String a2 = h.a.a.p.a(PAYMENT_METHOD_INVALID_DESCRIPTION);
            return new Error(ErrorType.PAYMENT_METHOD_INVALID, a2, a2);
        }

        public static Error payment_method_missing() {
            String a2 = h.a.a.p.a(PAYMENT_METHOD_MISSING_DESCRIPTION);
            return new Error(ErrorType.PAYMENT_METHOD_MISSING, a2, a2);
        }

        public static Error phonestatePermission() {
            String a2 = h.a.a.p.a(ERROR_PHONESTATE_PERMISSION_DESCRIPTION);
            return new Error(ErrorType.PHONESTATE_PERMISSION, a2, a2);
        }

        public static Error stageAlreadyStarted() {
            String a2 = h.a.a.p.a(ERROR_STAGE_ALREADY_STARTED_DESCRIPTION);
            return new Error(ErrorType.STAGE_ALREADY_STARTED, a2, a2);
        }

        public static Error stageOngoing() {
            String a2 = h.a.a.p.a(ERROR_STAGE_ONGOING_DESCRIPTION);
            return new Error(ErrorType.STAGE_ONGOING, a2, a2);
        }

        public static Error stageRequired() {
            String a2 = h.a.a.p.a(ERROR_STAGE_REQUIRED_DESCRIPTION);
            return new Error(ErrorType.STAGE_REQUIRED, a2, a2);
        }

        public static Error startStageNotAuthorized() {
            String a2 = h.a.a.p.a(START_STAGE_NOT_AUTHORIZED_DESCRIPTION);
            return new Error(ErrorType.START_STAGE_NOT_AUTHORIZED, a2, a2);
        }

        public static Error startStageOfflineNotAuthorized() {
            String a2 = h.a.a.p.a(START_STAGE_OFFLINE_NOT_AUTHORIZED_DESCRIPTION);
            return new Error(ErrorType.START_STAGE_OFFLINE_NOT_AUTHORIZED, a2, a2);
        }

        public static Error token_mistach() {
            String a2 = h.a.a.p.a(ERROR_TOKEN_MISMATCH_DESCRIPTION);
            return new Error(ErrorType.TOKEN_MISMATCH, a2, a2);
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
