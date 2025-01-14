package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;
@DatabaseTable(tableName = "Configurations")
/* loaded from: classes.dex */
public class DataModelDBOs$TableConfiguration {
    @DatabaseField
    public boolean active;
    @DatabaseField
    public String code;
    @DatabaseField
    public String customerId;
    @DatabaseField(id = true)
    public String id;
    @DatabaseField
    public String name;
    @DatabaseField
    public String value;

    public DataModelDBOs$TableConfiguration(DataModelDTOs$ConfigurationDTO dataModelDTOs$ConfigurationDTO) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (dataModelDTOs$ConfigurationDTO.getCustomerId() != null) {
            str = dataModelDTOs$ConfigurationDTO.getCustomerId() + "|";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(dataModelDTOs$ConfigurationDTO.getCode());
        this.id = sb.toString();
        this.name = dataModelDTOs$ConfigurationDTO.getName();
        this.value = dataModelDTOs$ConfigurationDTO.getValue();
        this.active = dataModelDTOs$ConfigurationDTO.getActive();
        this.customerId = dataModelDTOs$ConfigurationDTO.getCustomerId();
        this.code = dataModelDTOs$ConfigurationDTO.getCode();
    }

    public boolean a() {
        return this.active;
    }

    public String b() {
        return this.code;
    }

    public String c() {
        return this.customerId;
    }

    public String d() {
        return this.id;
    }

    public String e() {
        return this.name;
    }

    public String f() {
        return this.value;
    }

    public DataModels.f g() {
        return new DataModels.f(e(), f(), a(), c(), b());
    }

    public DataModelDBOs$TableConfiguration() {
    }
}
