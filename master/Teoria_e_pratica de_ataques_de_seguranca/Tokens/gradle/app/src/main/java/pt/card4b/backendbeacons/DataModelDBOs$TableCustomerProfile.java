package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;

@DatabaseTable(tableName = "CustomerProfiles")
/* loaded from: classes.dex */
public class DataModelDBOs$TableCustomerProfile {
    @DatabaseField(m4257id = true)

    /* renamed from: id */
    public String f10706id;
    @DatabaseField
    public String name;
    @DatabaseField
    public int ref;

    public DataModelDBOs$TableCustomerProfile(DataModelDTOs$CustomerProfileDTO dataModelDTOs$CustomerProfileDTO) {
        this.f10706id = dataModelDTOs$CustomerProfileDTO.getID();
        this.ref = dataModelDTOs$CustomerProfileDTO.getRef();
        this.name = dataModelDTOs$CustomerProfileDTO.getName();
    }

    /* renamed from: a */
    public String m317a() {
        return this.f10706id;
    }

    /* renamed from: b */
    public String m316b() {
        return this.name;
    }

    /* renamed from: c */
    public int m315c() {
        return this.ref;
    }

    /* renamed from: d */
    public DataModels.CustomerProfile m314d() {
        return new DataModels.CustomerProfile(m317a(), m315c(), m316b());
    }

    public DataModelDBOs$TableCustomerProfile() {
    }
}
