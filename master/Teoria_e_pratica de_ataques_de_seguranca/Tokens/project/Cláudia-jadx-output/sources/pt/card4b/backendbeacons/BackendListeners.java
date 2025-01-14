package pt.card4b.backendbeacons;

import android.location.Location;
import android.support.annotation.Keep;
import java.util.Date;
import java.util.List;
import pt.card4b.backendbeacons.DataModels;
@Keep
/* loaded from: classes.dex */
public class BackendListeners {

    @Keep
    /* loaded from: classes.dex */
    public interface BaseRequestListener {
        void onError(DataModels.Error error);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface BeaconObservingListener extends BaseRequestListener {
        void onReceiveBeaconSighting(DataModels.BeaconSighting beaconSighting);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface CreateCustomerRequestListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface DefaultRequestListener {
        void onError(DataModels.Error error);

        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface DisableHCEValidationsListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface EnableHCEValidationsListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface FinishStageRequestListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface FinishStageUserConfirmationListener extends BaseRequestListener {
        void onSuccess(boolean z);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface GetCardInfoListener extends BaseRequestListener {
        void onSucess(DataModels.CardInfo cardInfo);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface GetCountriesListener extends BaseRequestListener {
        void onSuccess(List<DataModels.Country> list);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface GetFAQsListener extends BaseRequestListener {
        void onSuccess(String str);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface GetLanguagesListener extends BaseRequestListener {
        void onSuccess(List<DataModels.Language> list);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface GetLogListener extends BaseRequestListener {
        void onSuccess(String str);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface GetSavedUserRequestListener extends BaseRequestListener {
        void onSuccess(DataModels.User user);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface GetTermsAndConditionsListener extends BaseRequestListener {
        void onSuccess(String str);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface GetUserAccountListener extends BaseRequestListener {
        void onSuccess(DataModels.UserAccountInfo userAccountInfo);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface HasOngoingStageListener extends BaseRequestListener {
        void onSuccess(boolean z);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface HistoricInfoRequestListener extends BaseRequestListener {
        void onSuccess(List<DataModels.StageInfo> list);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface InitialConfigurationRequestListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface LoginRequestListener extends BaseRequestListener {
        void onSuccess(DataModels.User user);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface LogoutRequestListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface PaymentMethodsRequestListener extends BaseRequestListener {
        void onSuccess(List<DataModels.PaymentMethod> list);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface PossibleStopListener extends BaseRequestListener {
        void onReceiveStop(DataModels.StopInfo stopInfo);

        void onRemoveStops(List<DataModels.StopInfo> list);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface ResetPasswordRequestListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface ScheduleStageStartListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface SelectPaymentMethodRequestListener extends BaseRequestListener {
        void onSuccess(DataModels.PaymentAction paymentAction, DataModels.PaymentInfo paymentInfo);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface SendInvoiceEmailListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface SendReportListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface StageStopListener extends BaseRequestListener {
        void onFinish(boolean z);

        void onFinishConfirmation(int i2, boolean z);

        void onLogoutRequired();

        void onReceiveOtherStop(DataModels.StopInfo stopInfo);

        void onReceiveStageStop(DataModels.StopInfo stopInfo);

        void onRemoveOtherStops(List<DataModels.StopInfo> list);

        void onRestartStageStops(List<DataModels.StopInfo> list);

        void onServiceDisabled(DataModels.Service service);

        void onServiceEnabled(DataModels.Service service);

        void onStartStageStops(List<DataModels.StopInfo> list);

        void onSuccess();

        void onTripAppActivityBlocked();

        void onWakeUpRequired();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface SyncConfigurationDataRequestListener extends BaseRequestListener {
        void onSuccess();
    }

    @Keep
    /* loaded from: classes.dex */
    public interface TariffInfoRequestListener extends BaseRequestListener {
        void onSuccess(List<DataModels.TariffInfo> list, List<DataModels.InvoiceInfo> list2);
    }

    @Keep
    /* loaded from: classes.dex */
    public interface UpdateUserRequestListener extends BaseRequestListener {
        void onSuccess(boolean z);
    }

    /* loaded from: classes.dex */
    public interface a extends BaseRequestListener {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface b extends BaseRequestListener {
        void a(DataModels.p pVar);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(Location location);
    }

    /* loaded from: classes.dex */
    public interface d extends BaseRequestListener {
        void a(DataModelDTOs$CustomerAccountDTO dataModelDTOs$CustomerAccountDTO);
    }

    /* loaded from: classes.dex */
    public interface e extends BaseRequestListener {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface f extends BaseRequestListener {
        void onSuccess(boolean z);
    }

    /* loaded from: classes.dex */
    public interface g extends BaseRequestListener {
        void a(Date date, boolean z, Date date2, boolean z2, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface h<T> extends BaseRequestListener {
        void a(T t);
    }

    /* loaded from: classes.dex */
    public interface i extends BaseRequestListener {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface j extends BaseRequestListener {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface k extends BaseRequestListener {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface l extends BaseRequestListener {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface m extends BaseRequestListener {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface n extends BaseRequestListener {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface o extends BaseRequestListener {
        void onSuccess();
    }

    /* loaded from: classes.dex */
    public interface p extends BaseRequestListener {
        void a(DataModels.NewStageStartInfo newStageStartInfo);
    }

    /* loaded from: classes.dex */
    public interface q extends BaseRequestListener {
        void onSuccess();
    }
}
