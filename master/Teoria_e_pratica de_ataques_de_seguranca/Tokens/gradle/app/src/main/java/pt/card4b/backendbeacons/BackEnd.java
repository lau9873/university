package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.util.Date;
import p205h.p206a.p207a.BeaconManager;
import p205h.p206a.p207a.Consuela;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* loaded from: classes.dex */
public class BackEnd {
    @Keep
    public static void addListeners(BackendListeners.StageStopListener stageStopListener) {
        Consuela.m1790k().m1825a(stageStopListener);
    }

    @Keep
    public static void addToLog(String str) {
        Consuela.m1790k().m1854a("ANDA_APP", str);
    }

    @Keep
    public static void changeUserPwd(String str, String str2, String str3, BackendListeners.DefaultRequestListener defaultRequestListener) {
        Consuela.m1790k().m1851a(str, str2, str3, defaultRequestListener);
    }

    @Keep
    public static void confirmStageFinished(boolean z, boolean z2, BackendListeners.FinishStageUserConfirmationListener finishStageUserConfirmationListener) {
        BeaconManager.m1922d().m1938a(z, z2, finishStageUserConfirmationListener);
    }

    @Keep
    public static void createNewCustomerAccount(DataModels.UserAccountInfo userAccountInfo, String str, BackendListeners.CreateCustomerRequestListener createCustomerRequestListener) {
        Consuela.m1790k().m1820a(userAccountInfo, str, createCustomerRequestListener);
    }

    @Keep
    public static void disableHCEValidation(BackendListeners.DisableHCEValidationsListener disableHCEValidationsListener) {
        Consuela.m1790k().m1841a(disableHCEValidationsListener);
    }

    @Keep
    public static void doInitialConfiguration(BackendListeners.InitialConfigurationRequestListener initialConfigurationRequestListener) {
        Consuela.m1790k().m1828a(initialConfigurationRequestListener);
    }

    @Keep
    public static void enableHCEValidation(BackendListeners.EnableHCEValidationsListener enableHCEValidationsListener) {
        Consuela.m1790k().m1839a(enableHCEValidationsListener);
    }

    @Keep
    public static void finishStage(BackendListeners.FinishStageRequestListener finishStageRequestListener) {
        BeaconManager.m1922d().m1939a(false, DataModels.C2706o.f10843l, finishStageRequestListener);
    }

    @Keep
    public static void getCardInfo(BackendListeners.GetCardInfoListener getCardInfoListener) {
        Consuela.m1790k().m1837a(getCardInfoListener);
    }

    @Keep
    public static void getCountries(BackendListeners.GetCountriesListener getCountriesListener) {
        Consuela.m1790k().m1836a(getCountriesListener);
    }

    @Keep
    public static void getFAQs(BackendListeners.GetFAQsListener getFAQsListener) {
        Consuela.m1790k().m1835a(getFAQsListener);
    }

    @Keep
    public static void getHistoricStageInfo(Date date, BackendListeners.HistoricInfoRequestListener historicInfoRequestListener) {
        Consuela.m1790k().m1844a(date, historicInfoRequestListener);
    }

    @Keep
    public static void getLanguages(BackendListeners.GetLanguagesListener getLanguagesListener) {
        Consuela.m1790k().m1834a(getLanguagesListener);
    }

    @Keep
    public static void getLog(BackendListeners.GetLogListener getLogListener) {
        Consuela.m1790k().m1833a(getLogListener);
    }

    @Keep
    public static void getPaymentMethods(BackendListeners.PaymentMethodsRequestListener paymentMethodsRequestListener) {
        Consuela.m1790k().m1826a(paymentMethodsRequestListener);
    }

    @Keep
    public static void getSavedUser(BackendListeners.GetSavedUserRequestListener getSavedUserRequestListener) {
        Consuela.m1790k().m1832a(getSavedUserRequestListener);
    }

    @Keep
    public static void getTariffInfo(Date date, BackendListeners.TariffInfoRequestListener tariffInfoRequestListener) {
        Consuela.m1790k().m1843a(date, tariffInfoRequestListener);
    }

    @Keep
    public static void getTermsAndConditions(BackendListeners.GetTermsAndConditionsListener getTermsAndConditionsListener) {
        Consuela.m1790k().m1831a(getTermsAndConditionsListener);
    }

    @Keep
    public static void getUserAccount(BackendListeners.GetUserAccountListener getUserAccountListener) {
        Consuela.m1790k().m1830a(getUserAccountListener);
    }

    @Keep
    public static void hasOngoingStage(BackendListeners.HasOngoingStageListener hasOngoingStageListener) {
        Consuela.m1790k().m1829a(hasOngoingStageListener);
    }

    @Keep
    public static void login(String str, String str2, BackendListeners.LoginRequestListener loginRequestListener) {
        Consuela.m1790k().m1849a(str, str2, loginRequestListener);
    }

    @Keep
    public static void logout(BackendListeners.LogoutRequestListener logoutRequestListener) {
        Consuela.m1790k().m1827a(logoutRequestListener);
    }

    @Keep
    public static void possibleStopsInfo(BackendListeners.PossibleStopListener possibleStopListener) {
        BeaconManager.m1922d().m1949a(possibleStopListener);
    }

    @Keep
    public static void resetUserPassword(String str, BackendListeners.ResetPasswordRequestListener resetPasswordRequestListener) {
        Consuela.m1790k().m1848a(str, resetPasswordRequestListener);
    }

    @Keep
    public static void resumeStage(BackendListeners.StageStopListener stageStopListener) {
        BeaconManager.m1922d().m1948a(stageStopListener);
    }

    @Keep
    public static void scheduleStageStart(int i, BackendListeners.ScheduleStageStartListener scheduleStageStartListener) {
        Consuela.m1790k().m1870a(i, scheduleStageStartListener);
    }

    @Keep
    public static void selectPaymentMethod(DataModels.PaymentMethod paymentMethod, BackendListeners.SelectPaymentMethodRequestListener selectPaymentMethodRequestListener) {
        Consuela.m1790k().m1821a(paymentMethod, selectPaymentMethodRequestListener);
    }

    @Keep
    public static void sendInvoiceEmail(String str, BackendListeners.SendInvoiceEmailListener sendInvoiceEmailListener) {
        Consuela.m1790k().m1847a(str, sendInvoiceEmailListener);
    }

    @Keep
    public static void sendLogReport(String str, BackendListeners.SendReportListener sendReportListener) {
        Consuela.m1790k().m1846a(str, sendReportListener);
    }

    @Keep
    public static void startStage(DataModels.StopInfo stopInfo, BackendListeners.StageStopListener stageStopListener) {
        BeaconManager.m1922d().m1947a(stopInfo, stageStopListener);
    }

    @Keep
    public static void stopBeaconService() {
        BeaconManager.m1922d().m1905l();
    }

    @Keep
    public static void syncConfigurationData(boolean z, BackendListeners.SyncConfigurationDataRequestListener syncConfigurationDataRequestListener) {
        Consuela.m1790k().m1856a(Boolean.valueOf(z), syncConfigurationDataRequestListener);
    }

    @Keep
    public static void testServiceNotification(boolean z, DataModels.Service service) {
        Consuela.m1790k().m1816a(z, service);
    }

    @Keep
    public static void updateUserData(DataModels.UserAccountInfo userAccountInfo, BackendListeners.UpdateUserRequestListener updateUserRequestListener) {
        Consuela.m1790k().m1819a(userAccountInfo, updateUserRequestListener);
    }
}
