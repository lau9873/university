package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$LineVariantDTO {
    public int LineVariantRef;
    public String Name;

    public DataModelDTOs$LineVariantDTO(String str, int i2) {
        this.Name = str;
        this.LineVariantRef = i2;
    }

    public int getLineVariantRef() {
        return this.LineVariantRef;
    }

    public String getName() {
        return this.Name;
    }

    public void setLineVariantRef(int i2) {
        this.LineVariantRef = i2;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public DataModels.l toLineVariant() {
        return new DataModels.l(getLineVariantRef(), getName());
    }
}
