package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;
@DatabaseTable(tableName = "BeaconInformationTypes")
/* loaded from: classes.dex */
public class DataModelDBOs$TableBeaconInformationType {
    @DatabaseField(id = true)
    public String code;
    @DatabaseField
    public String id;
    @DatabaseField
    public String name;

    public DataModelDBOs$TableBeaconInformationType(DataModelDTOs$BeaconInformationTypeDTO dataModelDTOs$BeaconInformationTypeDTO) {
        this.id = dataModelDTOs$BeaconInformationTypeDTO.getId();
        this.name = dataModelDTOs$BeaconInformationTypeDTO.getName();
        this.code = dataModelDTOs$BeaconInformationTypeDTO.getCode();
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

    public DataModels.d d() {
        return new DataModels.d(b(), c(), a());
    }

    public DataModelDBOs$TableBeaconInformationType() {
    }
}
