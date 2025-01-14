package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;
@DatabaseTable(tableName = "CustomerProfiles")
/* loaded from: classes.dex */
public class DataModelDBOs$TableCustomerProfile {
    @DatabaseField(id = true)
    public String id;
    @DatabaseField
    public String name;
    @DatabaseField
    public int ref;

    public DataModelDBOs$TableCustomerProfile(DataModelDTOs$CustomerProfileDTO dataModelDTOs$CustomerProfileDTO) {
        this.id = dataModelDTOs$CustomerProfileDTO.getID();
        this.ref = dataModelDTOs$CustomerProfileDTO.getRef();
        this.name = dataModelDTOs$CustomerProfileDTO.getName();
    }

    public String a() {
        return this.id;
    }

    public String b() {
        return this.name;
    }

    public int c() {
        return this.ref;
    }

    public DataModels.CustomerProfile d() {
        return new DataModels.CustomerProfile(a(), c(), b());
    }

    public DataModelDBOs$TableCustomerProfile() {
    }
}
