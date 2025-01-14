package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;

@DatabaseTable(tableName = "Countries")
/* loaded from: classes.dex */
public class DataModelDBOs$TableCountry {
    @DatabaseField
    public String code;
    @DatabaseField(m4257id = true)

    /* renamed from: id */
    public String f10705id;
    @DatabaseField
    public String name;

    public DataModelDBOs$TableCountry(DataModelDTOs$CountryDTO dataModelDTOs$CountryDTO) {
        this.f10705id = dataModelDTOs$CountryDTO.getId();
        this.code = dataModelDTOs$CountryDTO.getCode();
        this.name = dataModelDTOs$CountryDTO.getName();
    }

    /* renamed from: a */
    public String m321a() {
        return this.code;
    }

    /* renamed from: b */
    public String m320b() {
        return this.f10705id;
    }

    /* renamed from: c */
    public String m319c() {
        return this.name;
    }

    /* renamed from: d */
    public DataModels.Country m318d() {
        return new DataModels.Country(m320b(), m321a(), m319c());
    }

    public DataModelDBOs$TableCountry() {
    }
}
