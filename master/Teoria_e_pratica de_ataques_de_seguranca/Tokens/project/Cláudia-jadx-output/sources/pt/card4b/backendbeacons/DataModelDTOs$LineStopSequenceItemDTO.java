package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$LineStopSequenceItemDTO {
    public int LineDirectionRef;
    public int LineVariantRef;
    public DataModelDTOs$StopDTO Stop;
    public int StopSequence;

    public DataModelDTOs$LineStopSequenceItemDTO(int i2, int i3, int i4, DataModelDTOs$StopDTO dataModelDTOs$StopDTO) {
        this.LineDirectionRef = i2;
        this.LineVariantRef = i3;
        this.StopSequence = i4;
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

    public void setLineDirectionRef(int i2) {
        this.LineDirectionRef = i2;
    }

    public void setLineVariantRef(int i2) {
        this.LineVariantRef = i2;
    }

    public void setStop(DataModelDTOs$StopDTO dataModelDTOs$StopDTO) {
        this.Stop = dataModelDTOs$StopDTO;
    }

    public void setStopSequence(int i2) {
        this.StopSequence = i2;
    }
}
