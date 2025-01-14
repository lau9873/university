package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;

@DatabaseTable(tableName = "BeaconInformationTypes")
/* loaded from: classes.dex */
public class DataModelDBOs$TableBeaconInformationType {
    @DatabaseField(m4257id = true)
    public String code;
    @DatabaseField

    /* renamed from: id */
    public String f10703id;
    @DatabaseField
    public String name;

    public DataModelDBOs$TableBeaconInformationType(DataModelDTOs$BeaconInformationTypeDTO dataModelDTOs$BeaconInformationTypeDTO) {
        this.f10703id = dataModelDTOs$BeaconInformationTypeDTO.getId();
        this.name = dataModelDTOs$BeaconInformationTypeDTO.getName();
        this.code = dataModelDTOs$BeaconInformationTypeDTO.getCode();
    }

    /* renamed from: a */
    public String m332a() {
        return this.code;
    }

    /* renamed from: b */
    public String m331b() {
        return this.f10703id;
    }

    /* renamed from: c */
    public String m330c() {
        return this.name;
    }

    /* renamed from: d */
    public DataModels.C2695d m329d() {
        return new DataModels.C2695d(m331b(), m330c(), m332a());
    }

    public DataModelDBOs$TableBeaconInformationType() {
    }
}
