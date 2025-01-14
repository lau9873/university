package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$LineVariantDTO {
    public int LineVariantRef;
    public String Name;

    public DataModelDTOs$LineVariantDTO(String str, int i) {
        this.Name = str;
        this.LineVariantRef = i;
    }

    public int getLineVariantRef() {
        return this.LineVariantRef;
    }

    public String getName() {
        return this.Name;
    }

    public void setLineVariantRef(int i) {
        this.LineVariantRef = i;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public DataModels.C2703l toLineVariant() {
        return new DataModels.C2703l(getLineVariantRef(), getName());
    }
}
