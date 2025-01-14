package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$CustomerWalletDTO {
    public float Balance;
    public float Debt;
    public float Savings;

    public DataModelDTOs$CustomerWalletDTO(float f2, float f3, float f4) {
        this.Balance = f2;
        this.Debt = f3;
        this.Savings = f4;
    }

    public float getBalance() {
        return this.Balance;
    }

    public float getDebt() {
        return this.Debt;
    }

    public float getSavings() {
        return this.Savings;
    }

    public void setBalance(float f2) {
        this.Balance = f2;
    }

    public void setDebt(float f2) {
        this.Debt = f2;
    }

    public void setSavings(float f2) {
        this.Savings = f2;
    }
}
