package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import h.a.a.n;
import java.util.List;
import pt.card4b.backendbeacons.DataModels;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$StageTariffsDTO {
    public float OptimizedTotal;
    public List<DataModelDTOs$StageDetailsDTO> Stages;
    public float Total;
    public float TotalDebt;
    public float TotalSave;

    public DataModelDTOs$StageTariffsDTO(float f2, float f3, float f4, float f5, List<DataModelDTOs$StageDetailsDTO> list) {
        this.TotalDebt = f2;
        this.Total = f3;
        this.OptimizedTotal = f4;
        this.TotalSave = f5;
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

    public void setOptimizedTotal(float f2) {
        this.OptimizedTotal = f2;
    }

    public void setStages(List<DataModelDTOs$StageDetailsDTO> list) {
        this.Stages = list;
    }

    public void setTotal(float f2) {
        this.Total = f2;
    }

    public void setTotalDebt(float f2) {
        this.TotalDebt = f2;
    }

    public void setTotalSave(float f2) {
        this.TotalSave = f2;
    }

    public DataModels.TariffInfo toTariffInfo() {
        return new DataModels.TariffInfo(n.a().b(getStages()), this.TotalDebt, this.TotalSave, this.Total);
    }
}
