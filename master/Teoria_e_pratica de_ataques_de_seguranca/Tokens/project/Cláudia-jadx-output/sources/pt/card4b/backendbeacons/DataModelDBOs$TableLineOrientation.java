package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;
@DatabaseTable(tableName = "LineOrientations")
/* loaded from: classes.dex */
public class DataModelDBOs$TableLineOrientation {
    @DatabaseField(id = true)
    public String id;
    @DatabaseField
    public String name;
    @DatabaseField
    public int operatorRef;
    @DatabaseField
    public int ref;

    public DataModelDBOs$TableLineOrientation(DataModelDTOs$LineDirectionDTO dataModelDTOs$LineDirectionDTO) {
        this.id = dataModelDTOs$LineDirectionDTO.getLineDirectionRef() + "|" + dataModelDTOs$LineDirectionDTO.getTransportOperatorRef();
        this.ref = dataModelDTOs$LineDirectionDTO.getLineDirectionRef();
        this.name = dataModelDTOs$LineDirectionDTO.getName();
        this.operatorRef = dataModelDTOs$LineDirectionDTO.getTransportOperatorRef();
    }

    public String a() {
        return this.name;
    }

    public int b() {
        return this.operatorRef;
    }

    public int c() {
        return this.ref;
    }

    public DataModels.k d() {
        return new DataModels.k(c() + "|" + b(), c(), a(), b());
    }

    public DataModelDBOs$TableLineOrientation() {
    }
}
