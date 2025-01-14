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
    @DatabaseField(m4257id = true)

    /* renamed from: id */
    public String f10704id;
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
        this.f10704id = sb.toString();
        this.name = dataModelDTOs$ConfigurationDTO.getName();
        this.value = dataModelDTOs$ConfigurationDTO.getValue();
        this.active = dataModelDTOs$ConfigurationDTO.getActive();
        this.customerId = dataModelDTOs$ConfigurationDTO.getCustomerId();
        this.code = dataModelDTOs$ConfigurationDTO.getCode();
    }

    /* renamed from: a */
    public boolean m328a() {
        return this.active;
    }

    /* renamed from: b */
    public String m327b() {
        return this.code;
    }

    /* renamed from: c */
    public String m326c() {
        return this.customerId;
    }

    /* renamed from: d */
    public String m325d() {
        return this.f10704id;
    }

    /* renamed from: e */
    public String m324e() {
        return this.name;
    }

    /* renamed from: f */
    public String m323f() {
        return this.value;
    }

    /* renamed from: g */
    public DataModels.C2697f m322g() {
        return new DataModels.C2697f(m324e(), m323f(), m328a(), m326c(), m327b());
    }

    public DataModelDBOs$TableConfiguration() {
    }
}
