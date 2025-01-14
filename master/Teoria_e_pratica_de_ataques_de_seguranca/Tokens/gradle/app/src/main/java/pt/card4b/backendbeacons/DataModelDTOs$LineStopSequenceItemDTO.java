package pt.card4b.backendbeacons;

import android.support.annotation.Keep;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$LineStopSequenceItemDTO {
    public int LineDirectionRef;
    public int LineVariantRef;
    public DataModelDTOs$StopDTO Stop;
    public int StopSequence;

    public DataModelDTOs$LineStopSequenceItemDTO(int i, int i2, int i3, DataModelDTOs$StopDTO dataModelDTOs$StopDTO) {
        this.LineDirectionRef = i;
        this.LineVariantRef = i2;
        this.StopSequence = i3;
        this.Stop = dataModelDTOs$StopDTO;
    }

    public int getLineDirectionRef() {
        return this.LineDirectionRef;
    }

    public int getLineVariantRef() {
        return this.LineVariantRef;
    }

    public DataModelDTOs$StopDTO getStop() {
        return this.Stop;
    }

    public int getStopSequence() {
        return this.StopSequence;
    }

    public void setLineDirectionRef(int i) {
        this.LineDirectionRef = i;
    }

    public void setLineVariantRef(int i) {
        this.LineVariantRef = i;
    }

    public void setStop(DataModelDTOs$StopDTO dataModelDTOs$StopDTO) {
        this.Stop = dataModelDTOs$StopDTO;
    }

    public void setStopSequence(int i) {
        this.StopSequence = i;
    }
}
