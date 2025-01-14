package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;

@DatabaseTable(tableName = "Languages")
/* loaded from: classes.dex */
public class DataModelDBOs$TableLanguage {
    @DatabaseField
    public String code;
    @DatabaseField(m4257id = true)

    /* renamed from: id */
    public String f10707id;
    @DatabaseField
    public String name;

    public DataModelDBOs$TableLanguage(DataModelDTOs$LanguageDTO dataModelDTOs$LanguageDTO) {
        this.f10707id = dataModelDTOs$LanguageDTO.getId();
        this.code = dataModelDTOs$LanguageDTO.getCode();
        this.name = dataModelDTOs$LanguageDTO.getName();
    }

    /* renamed from: a */
    public String m313a() {
        return this.code;
    }

    /* renamed from: b */
    public String m312b() {
        return this.f10707id;
    }

    /* renamed from: c */
    public String m311c() {
        return this.name;
    }

    /* renamed from: d */
    public DataModels.Language m310d() {
        return new DataModels.Language(m312b(), m313a(), m311c());
    }

    public DataModelDBOs$TableLanguage() {
    }
}
