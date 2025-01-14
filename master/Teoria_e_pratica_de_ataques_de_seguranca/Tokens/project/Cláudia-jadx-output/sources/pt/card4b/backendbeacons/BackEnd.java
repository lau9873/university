package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import h.a.a.j;
import h.a.a.l;
import java.util.Date;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* loaded from: classes.dex */
public class BackEnd {
    @Keep
    public static void addListeners(BackendListeners.StageStopListener stageStopListener) {
        l.k().a(stageStopListener);
    }

    @Keep
    public static void addToLog(String str) {
        l.k().a("ANDA_APP", str);
    }

    @Keep
    public static void changeUserPwd(String str, String str2, String str3, BackendListeners.DefaultRequestListener defaultRequestListener) {
        l.k().a(str, str2, str3, defaultRequestListener);
    }

    @Keep
    public static void confirmStageFinished(boolean z, boolean z2, BackendListeners.FinishStageUserConfirmationListener finishStageUserConfirmationListener) {
        j.d().a(z, z2, finishStageUserConfirmationListener);
    }

    @Keep
    public static void createNewCustomerAccount(DataModels.UserAccountInfo userAccountInfo, String str, BackendListeners.CreateCustomerRequestListener createCustomerRequestListener) {
        l.k().a(userAccountInfo, str, createCustomerRequestListener);
    }

    @Keep
    public static void disableHCEValidation(BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener) {
        l.k().a(disableHCEValidationsListener);
    }

    @Keep
    public static void doInitialConfiguration(BackendListeners.InitialConfigurationRequestListener initialConfigurationRequestListener) {
        l.k().a(initialConfigurationRequestListener);
    }

    @Keep
    public static void enableHCEValidation(BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener) {
        l.k().a(enableHCEValidationsListener);
    }

    @Keep
    public static void finishStage(BackendListeners.FinishStageRequestListener finishStageRequestListener) {
        j.d().a(false, DataModels.o.l, finishStageRequestListener);
    }

    @Keep
    public static void getCardInfo(BackendListeners.GetCardInfoListener getCardInfoListener) {
        l.k().a(getCardInfoListener);
    }

    @Keep
    public static void getCountries(BackendListeners.GetCountriesListener getCountriesListener) {
        l.k().a(getCountriesListener);
    }

    @Keep
    public static void getFAQs(BackendListeners.GetFAQsListener getFAQsListener) {
        l.k().a(getFAQsListener);
    }

    @Keep
    public static void getHistoricStageInfo(Date date, BackendListeners.HistoricInfoRequestListener historicInfoRequestListener) {
        l.k().a(date, historicInfoRequestListener);
    }

    @Keep
    public static void getLanguages(BackendListeners.GetLanguagesListener getLanguagesListener) {
        l.k().a(getLanguagesListener);
    }

    @Keep
    public static void getLog(BackendListeners.GetLogListener getLogListener) {
        l.k().a(getLogListener);
    }

    @Keep
    public static void getPaymentMethods(BackendListeners.PaymentMethodsRequestListener paymentMethodsRequestListener) {
        l.k().a(paymentMethodsRequestListener);
    }

    @Keep
    public static void getSavedUser(BackendListeners.GetSavedUserRequestListener getSavedUserRequestListener) {
        l.k().a(getSavedUserRequestListener);
    }

    @Keep
    public static void getTariffInfo(Date date, BackendListeners.TariffInfoRequestListener tariffInfoRequestListener) {
        l.k().a(date, tariffInfoRequestListener);
    }

    @Keep
    public static void getTermsAndConditions(BackendListeners.GetTermsAndConditionsListener getTermsAndConditionsListener) {
        l.k().a(getTermsAndConditionsListener);
    }

    @Keep
    public static void getUserAccount(BackendListeners.GetUserAccountListener getUserAccountListener) {
        l.k().a(getUserAccountListener);
    }

    @Keep
    public static void hasOngoingStage(BackendListeners.HasOngoingStageListener hasOngoingStageListener) {
        l.k().a(hasOngoingStageListener);
    }

    @Keep
    public static void login(String str, String str2, BackendListeners.LoginRequestListener loginRequestListener) {
        l.k().a(str, str2, loginRequestListener);
    }

    @Keep
    public static void logout(BackendListeners.LogoutRequestListener logoutRequestListener) {
        l.k().a(logoutRequestListener);
    }

    @Keep
    public static void possibleStopsInfo(BackendListeners.PossibleStopListener possibleStopListener) {
        j.d().a(possibleStopListener);
    }

    @Keep
    public static void resetUserPassword(String str, BackendListeners.ResetPasswordRequestListener resetPasswordRequestListener) {
        l.k().a(str, resetPasswordRequestListener);
    }

    @Keep
    public static void resumeStage(BackendListeners.StageStopListener stageStopListener) {
        j.d().a(stageStopListener);
    }

    @Keep
    public static void scheduleStageStart(int i2, BackendListeners.ScheduleStageStartListener scheduleStageStartListener) {
        l.k().a(i2, scheduleStageStartListener);
    }

    @Keep
    public static void selectPaymentMethod(DataModels.PaymentMethod paymentMethod, BackendListeners.SelectPaymentMethodRequestListener selectPaymentMethodRequestListener) {
        l.k().a(paymentMethod, selectPaymentMethodRequestListener);
    }

    @Keep
    public static void sendInvoiceEmail(String str, BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener) {
        l.k().a(str, sendInvoiceEmailListener);
    }

    @Keep
    public static void sendLogReport(String str, BackendListeners.SendReportListener sendReportListener) {
        l.k().a(str, sendReportListener);
    }

    @Keep
    public static void startStage(DataModels.StopInfo stopInfo, BackendListeners.StageStopListener stageStopListener) {
        j.d().a(stopInfo, stageStopListener);
    }

    @Keep
    public static void stopBeaconService() {
        j.d().l();
    }

    @Keep
    public static void syncConfigurationData(boolean z, BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener) {
        l.k().a(Boolean.valueOf(z), syncConfigurationDataRequestListener);
    }

    @Keep
    public static void testServiceNotification(boolean z, DataModels.Service service) {
        l.k().a(z, service);
    }

    @Keep
    public static void updateUserData(DataModels.UserAccountInfo userAccountInfo, BackendListeners.UpdateUserRequestListener updateUserRequestListener) {
        l.k().a(userAccountInfo, updateUserRequestListener);
    }
}
