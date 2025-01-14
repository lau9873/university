package h.b.a.d.b0;

import h.b.a.d.f;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: TipErrorConverter.java */
/* loaded from: classes.dex */
public final class b {

    /* compiled from: TipErrorConverter.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6904a = new int[DataModels.Error.ErrorType.values().length];

        static {
            try {
                f6904a[DataModels.Error.ErrorType.COMM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.INTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.BLUETOOTH_DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.LOCATION_DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.LOCATION_PERMISSION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.PHONESTATE_PERMISSION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.LOGIN_REQUIRED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.MISSING_DATA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.START_STAGE_OFFLINE_NOT_AUTHORIZED.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.START_STAGE_NOT_AUTHORIZED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.NFC_DISABLED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.NO_INTERNET.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.PAYMENT_METHOD_MISSING.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.PAYMENT_METHOD_INVALID.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.EQUIPMENT_INVALID.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.ACCOUNT_NOT_CONFIRMED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.ACCOUNT_INTO_BLACK_LIST.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.FAILED_TO_ENROLL_CARD.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f6904a[DataModels.Error.ErrorType.CARD_NOT_ENROLLED.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    public static f.a a(DataModels.Error error) {
        return new f.a(a(error.getType()), error.getMessage(), error.getMessageToUser());
    }

    public static f.a.EnumC0164a a(DataModels.Error.ErrorType errorType) {
        switch (a.f6904a[errorType.ordinal()]) {
            case 1:
                return f.a.EnumC0164a.connectionError;
            case 2:
                return f.a.EnumC0164a.internal;
            case 3:
                return f.a.EnumC0164a.bluetoothOff;
            case 4:
                return f.a.EnumC0164a.locationOff;
            case 5:
                return f.a.EnumC0164a.permissionRequired_location;
            case 6:
                return f.a.EnumC0164a.permissionRequired_phoneState;
            case 7:
                return f.a.EnumC0164a.loginRequired;
            case 8:
                return f.a.EnumC0164a.missingData;
            case 9:
                return f.a.EnumC0164a.trip_offlineNotAuthorized;
            case 10:
                return f.a.EnumC0164a.hce_notAuthorized;
            case 11:
                return f.a.EnumC0164a.nfcOff;
            case 12:
                return f.a.EnumC0164a.noInternet;
            case 13:
                return f.a.EnumC0164a.paymentMethod_missing;
            case 14:
                return f.a.EnumC0164a.paymentMethod_invalid;
            case 15:
                return f.a.EnumC0164a.invalidEquipment;
            case 16:
                return f.a.EnumC0164a.account_notConfirmed;
            case 17:
                return f.a.EnumC0164a.account_blackList;
            case 18:
                return f.a.EnumC0164a.failed_to_enroll_card;
            case 19:
                return f.a.EnumC0164a.card_not_enrolled;
            default:
                return f.a.EnumC0164a.unknown;
        }
    }
}
