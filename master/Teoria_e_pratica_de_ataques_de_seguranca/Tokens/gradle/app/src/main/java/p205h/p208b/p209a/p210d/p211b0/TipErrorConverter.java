package p205h.p208b.p209a.p210d.p211b0;

import p205h.p208b.p209a.p210d.ErrorListener;
import pt.card4b.backendbeacons.DataModels;

/* renamed from: h.b.a.d.b0.b */
/* loaded from: classes.dex */
public final class TipErrorConverter {

    /* compiled from: TipErrorConverter.java */
    /* renamed from: h.b.a.d.b0.b$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C2282a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f9534a = new int[DataModels.Error.ErrorType.values().length];

        static {
            try {
                f9534a[DataModels.Error.ErrorType.COMM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.INTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.BLUETOOTH_DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.LOCATION_DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.LOCATION_PERMISSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.PHONESTATE_PERMISSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.LOGIN_REQUIRED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.MISSING_DATA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.START_STAGE_OFFLINE_NOT_AUTHORIZED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.START_STAGE_NOT_AUTHORIZED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.NFC_DISABLED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.NO_INTERNET.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.PAYMENT_METHOD_MISSING.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.PAYMENT_METHOD_INVALID.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.EQUIPMENT_INVALID.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.ACCOUNT_NOT_CONFIRMED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.ACCOUNT_INTO_BLACK_LIST.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.FAILED_TO_ENROLL_CARD.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f9534a[DataModels.Error.ErrorType.CARD_NOT_ENROLLED.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    /* renamed from: a */
    public static ErrorListener.C2358a m1372a(DataModels.Error error) {
        return new ErrorListener.C2358a(m1373a(error.getType()), error.getMessage(), error.getMessageToUser());
    }

    /* renamed from: a */
    public static ErrorListener.C2358a.EnumC2359a m1373a(DataModels.Error.ErrorType errorType) {
        switch (C2282a.f9534a[errorType.ordinal()]) {
            case 1:
                return ErrorListener.C2358a.EnumC2359a.connectionError;
            case 2:
                return ErrorListener.C2358a.EnumC2359a.internal;
            case 3:
                return ErrorListener.C2358a.EnumC2359a.bluetoothOff;
            case 4:
                return ErrorListener.C2358a.EnumC2359a.locationOff;
            case 5:
                return ErrorListener.C2358a.EnumC2359a.permissionRequired_location;
            case 6:
                return ErrorListener.C2358a.EnumC2359a.permissionRequired_phoneState;
            case 7:
                return ErrorListener.C2358a.EnumC2359a.loginRequired;
            case 8:
                return ErrorListener.C2358a.EnumC2359a.missingData;
            case 9:
                return ErrorListener.C2358a.EnumC2359a.trip_offlineNotAuthorized;
            case 10:
                return ErrorListener.C2358a.EnumC2359a.hce_notAuthorized;
            case 11:
                return ErrorListener.C2358a.EnumC2359a.nfcOff;
            case 12:
                return ErrorListener.C2358a.EnumC2359a.noInternet;
            case 13:
                return ErrorListener.C2358a.EnumC2359a.paymentMethod_missing;
            case 14:
                return ErrorListener.C2358a.EnumC2359a.paymentMethod_invalid;
            case 15:
                return ErrorListener.C2358a.EnumC2359a.invalidEquipment;
            case 16:
                return ErrorListener.C2358a.EnumC2359a.account_notConfirmed;
            case 17:
                return ErrorListener.C2358a.EnumC2359a.account_blackList;
            case 18:
                return ErrorListener.C2358a.EnumC2359a.failed_to_enroll_card;
            case 19:
                return ErrorListener.C2358a.EnumC2359a.card_not_enrolled;
            default:
                return ErrorListener.C2358a.EnumC2359a.unknown;
        }
    }
}
