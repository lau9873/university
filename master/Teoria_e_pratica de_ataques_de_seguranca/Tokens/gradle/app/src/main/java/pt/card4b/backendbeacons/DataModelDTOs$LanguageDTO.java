package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$LanguageDTO {
    public String Code;

    /* renamed from: Id */
    public String f10721Id;
    public String Name;

    public DataModelDTOs$LanguageDTO(String str, String str2, String str3) {
        this.f10721Id = str;
        this.Code = str2;
        this.Name = str3;
    }

    public String getCode() {
        return this.Code;
    }

    public String getId() {
        return this.f10721Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setCode(String str) {
        this.Code = str;
    }

    public void setId(String str) {
        this.f10721Id = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public DataModels.Language toLanguage() {
        return new DataModels.Language(getId(), getCode(), getName());
    }
}
