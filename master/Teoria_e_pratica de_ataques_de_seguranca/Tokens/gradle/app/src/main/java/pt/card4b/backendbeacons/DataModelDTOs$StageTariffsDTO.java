package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.util.List;
import p205h.p206a.p207a.DataManager;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$StageTariffsDTO {
    public float OptimizedTotal;
    public List<DataModelDTOs$StageDetailsDTO> Stages;
    public float Total;
    public float TotalDebt;
    public float TotalSave;

    public DataModelDTOs$StageTariffsDTO(float f, float f2, float f3, float f4, List<DataModelDTOs$StageDetailsDTO> list) {
        this.TotalDebt = f;
        this.Total = f2;
        this.OptimizedTotal = f3;
        this.TotalSave = f4;
        this.Stages = list;
    }

    public float getOptimizedTotal() {
        return this.OptimizedTotal;
    }

    public List<DataModelDTOs$StageDetailsDTO> getStages() {
        return this.Stages;
    }

    public float getTotal() {
        return this.Total;
    }

    public float getTotalDebt() {
        return this.TotalDebt;
    }

    public float getTotalSave() {
        return this.TotalSave;
    }

    public void setOptimizedTotal(float f) {
        this.OptimizedTotal = f;
    }

    public void setStages(List<DataModelDTOs$StageDetailsDTO> list) {
        this.Stages = list;
    }

    public void setTotal(float f) {
        this.Total = f;
    }

    public void setTotalDebt(float f) {
        this.TotalDebt = f;
    }

    public void setTotalSave(float f) {
        this.TotalSave = f;
    }

    public DataModels.TariffInfo toTariffInfo() {
        return new DataModels.TariffInfo(DataManager.m1704a().m1675b(getStages()), this.TotalDebt, this.TotalSave, this.Total);
    }
}
