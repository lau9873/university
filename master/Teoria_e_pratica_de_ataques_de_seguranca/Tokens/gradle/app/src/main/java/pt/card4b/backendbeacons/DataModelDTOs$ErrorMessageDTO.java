package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$ErrorMessageDTO {
    public String ErrorType;
    public String Message;
    public String MessageToUser;

    public DataModelDTOs$ErrorMessageDTO(String str, String str2, String str3) {
        this.ErrorType = str;
        this.Message = str2;
        this.MessageToUser = str3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public DataModels.Error toError() {
        char c;
        String str = this.ErrorType;
        str.hashCode();
        switch (str.hashCode()) {
            case -1760703482:
                if (str.equals("EQUIPMENT_INVALID")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1625320408:
                if (str.equals("MISMATCH_TOKEN")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -924914560:
                if (str.equals("NOT_VALID_REQUEST")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -418091167:
                if (str.equals("PAYMENT_METHOD_MISSING")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 84776601:
                if (str.equals("ACCOUNT_NOT_EXIST")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 472244210:
                if (str.equals("PAYMENT_METHOD_INVALID")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 589743617:
                if (str.equals("ACCOUNT_NOT_CONFIRMED")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 675620696:
                if (str.equals("NO_RESULTS")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 996853466:
                if (str.equals("NO_USER_ACCESS")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1062193675:
                if (str.equals("ACCOUNT_INTO_BLACK_LIST")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1715232457:
                if (str.equals("NOT_VALID_CUSTOMER_MAIL")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return DataModels.Error.equipment_invalid();
            case 1:
                return DataModels.Error.token_mistach();
            case 2:
            case '\n':
                return new DataModels.Error(DataModels.Error.ErrorType.VALIDATION, this.Message, this.MessageToUser);
            case 3:
                return DataModels.Error.payment_method_missing();
            case 4:
                return DataModels.Error.account_not_exist();
            case 5:
                return DataModels.Error.payment_method_invalid();
            case 6:
                return DataModels.Error.account_not_confirmed();
            case 7:
                return new DataModels.Error(DataModels.Error.ErrorType.NO_RESULTS, this.Message, this.MessageToUser);
            case '\b':
                return new DataModels.Error(DataModels.Error.ErrorType.FIELD_REQUIRED, this.Message, this.MessageToUser);
            case '\t':
                return DataModels.Error.account_into_black_list();
            default:
                return new DataModels.Error(DataModels.Error.ErrorType.INTERNAL, this.Message, this.MessageToUser);
        }
    }
}