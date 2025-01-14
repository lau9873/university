package pt.card4b.backendbeacons;

import android.support.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$CustomerWalletDTO {
    public float Balance;
    public float Debt;
    public float Savings;

    public DataModelDTOs$CustomerWalletDTO(float f, float f2, float f3) {
        this.Balance = f;
        this.Debt = f2;
        this.Savings = f3;
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

    public void setBalance(float f) {
        this.Balance = f;
    }

    public void setDebt(float f) {
        this.Debt = f;
    }

    public void setSavings(float f) {
        this.Savings = f;
    }
}
