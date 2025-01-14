package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;
@DatabaseTable(tableName = "Countries")
/* loaded from: classes.dex */
public class DataModelDBOs$TableCountry {
    @DatabaseField
    public String code;
    @DatabaseField(id = true)
    public String id;
    @DatabaseField
    public String name;

    public DataModelDBOs$TableCountry(DataModelDTOs$CountryDTO dataModelDTOs$CountryDTO) {
        this.id = dataModelDTOs$CountryDTO.getId();
        this.code = dataModelDTOs$CountryDTO.getCode();
        this.name = dataModelDTOs$CountryDTO.getName();
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

    public DataModels.Country d() {
        return new DataModels.Country(b(), a(), c());
    }

    public DataModelDBOs$TableCountry() {
    }
}
