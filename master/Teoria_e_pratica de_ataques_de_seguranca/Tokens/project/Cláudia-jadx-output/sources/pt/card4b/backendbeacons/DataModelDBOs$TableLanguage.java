package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;
@DatabaseTable(tableName = "Languages")
/* loaded from: classes.dex */
public class DataModelDBOs$TableLanguage {
    @DatabaseField
    public String code;
    @DatabaseField(id = true)
    public String id;
    @DatabaseField
    public String name;

    public DataModelDBOs$TableLanguage(DataModelDTOs$LanguageDTO dataModelDTOs$LanguageDTO) {
        this.id = dataModelDTOs$LanguageDTO.getId();
        this.code = dataModelDTOs$LanguageDTO.getCode();
        this.name = dataModelDTOs$LanguageDTO.getName();
    }

    public String a() {
        return this.code;
    }

    public String b() {
        return this.id;
    }

    public String c() {
        return this.name;
    }

    public DataModels.Language d() {
        return new DataModels.Language(b(), a(), c());
    }

    public DataModelDBOs$TableLanguage() {
    }
}
