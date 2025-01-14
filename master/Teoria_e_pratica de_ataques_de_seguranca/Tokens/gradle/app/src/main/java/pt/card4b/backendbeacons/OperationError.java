package pt.card4b.backendbeacons;

import android.support.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class OperationError {
    public static final String BLUETOOTH_SCAN_FAILED = "Bluetoth scan failed";
    public static final String BLUETOOTH_VALIDATION_FAILED = "Bluetoth validation failed";
    public static final String ERROR_BLUETOOTH_DISABLED_DESCRIPTION = "Bluetooth is not enabled on device";
    public static final String ERROR_BLUETOOTH_NEED_LOCATION_PERMISSION = "ACCESS_COARSE_LOCATION denied. Bluetooth scan requires coarse location permission.";
    public static final String ERROR_EMAIL_REQUIRED = "Parameter email is required";
    public static final String ERROR_FISCAL_REQUIRED = "Parameter fiscal code is required";
    public static final String ERROR_NAME_REQUIRED = "Parameter name is required";
    public static final String ERROR_NO_BLUETOOTH_DESCRIPTION = "Device does not support Bluetooth";
    public static final String ERROR_PASSWORD_REQUIRED = "Parameter password is required";
    public static final String ERROR_TIPCODE_REQUIRED = "Parameter TIP code is required";
    public static final String ERROR_USERNAME_REQUIRED = "Parameter username is required";
    public static final String MATCHING_STOP_MISSING = "No object matching the required stop";
    public static final String STAGE_ALREADY_STARTED = "This stage was already started";
    public static final String UNKNOWN_ERROR = "An unknown error occured.";
    public String errorDescription;
    public ErrorType errorType;

    @Keep
    /* loaded from: classes.dex */
    public enum ErrorType {
        BeaconsNoBluetooth,
        BeaconsBluetoothDisabled,
        CoarseLocationDenied,
        UsernameRequired,
        PasswordRequired,
        NameRequired,
        EmailRequired,
        FiscalCodeRequired,
        TipCodeRequired,
        BluetoothScanFailed,
        BluetoothValidationFailed,
        MatchingStopMissing,
        StageAlreadyStarted,
        Unknown
    }

    public static OperationError bluetoothDisabledError() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.BeaconsBluetoothDisabled;
        operationError.errorDescription = ERROR_BLUETOOTH_DISABLED_DESCRIPTION;
        return operationError;
    }

    public static OperationError bluetoothScanFailed() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.BluetoothScanFailed;
        operationError.errorDescription = BLUETOOTH_SCAN_FAILED;
        return operationError;
    }

    public static OperationError bluetoothValidationFailed() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.BluetoothValidationFailed;
        operationError.errorDescription = BLUETOOTH_VALIDATION_FAILED;
        return operationError;
    }

    public static OperationError coarseLocationDenied() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.CoarseLocationDenied;
        operationError.errorDescription = ERROR_BLUETOOTH_NEED_LOCATION_PERMISSION;
        return operationError;
    }

    public static OperationError emailRequired() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.EmailRequired;
        operationError.errorDescription = ERROR_EMAIL_REQUIRED;
        return operationError;
    }

    public static OperationError fiscalCodeRequired() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.FiscalCodeRequired;
        operationError.errorDescription = ERROR_FISCAL_REQUIRED;
        return operationError;
    }

    public static OperationError matchingStopMissing() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.MatchingStopMissing;
        operationError.errorDescription = MATCHING_STOP_MISSING;
        return operationError;
    }

    public static OperationError nameRequired() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.NameRequired;
        operationError.errorDescription = ERROR_NAME_REQUIRED;
        return operationError;
    }

    public static OperationError noBluetoothError() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.BeaconsNoBluetooth;
        operationError.errorDescription = ERROR_NO_BLUETOOTH_DESCRIPTION;
        return operationError;
    }

    public static OperationError operationError(ErrorType errorType, String str) {
        OperationError operationError = new OperationError();
        operationError.errorType = errorType;
        operationError.errorDescription = str;
        return operationError;
    }

    public static OperationError passwordRequired() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.PasswordRequired;
        operationError.errorDescription = ERROR_PASSWORD_REQUIRED;
        return operationError;
    }

    public static OperationError stageAlreadyStarted() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.StageAlreadyStarted;
        operationError.errorDescription = STAGE_ALREADY_STARTED;
        return operationError;
    }

    public static OperationError tipCodeRequired() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.TipCodeRequired;
        operationError.errorDescription = ERROR_TIPCODE_REQUIRED;
        return operationError;
    }

    public static OperationError unknownError() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.Unknown;
        operationError.errorDescription = UNKNOWN_ERROR;
        return operationError;
    }

    public static OperationError usernameRequired() {
        OperationError operationError = new OperationError();
        operationError.errorType = ErrorType.UsernameRequired;
        operationError.errorDescription = ERROR_USERNAME_REQUIRED;
        return operationError;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }
}
