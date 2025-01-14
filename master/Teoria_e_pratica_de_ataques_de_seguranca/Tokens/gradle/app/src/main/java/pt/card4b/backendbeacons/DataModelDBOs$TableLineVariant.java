package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;

@DatabaseTable(tableName = "LineVariants")
/* loaded from: classes.dex */
public class DataModelDBOs$TableLineVariant {
    @DatabaseField
    public String name;
    @DatabaseField(m4257id = true)
    public int ref;

    public DataModelDBOs$TableLineVariant(DataModelDTOs$LineVariantDTO dataModelDTOs$LineVariantDTO) {
        this.ref = dataModelDTOs$LineVariantDTO.getLineVariantRef();
        this.name = dataModelDTOs$LineVariantDTO.getName();
    }

    /* renamed from: a */
    public String m299a() {
        return this.name;
    }

    /* renamed from: b */
    public int m298b() {
        return this.ref;
    }

    /* renamed from: c */
    public DataModels.C2703l m297c() {
        return new DataModels.C2703l(m298b(), m299a());
    }

    public DataModelDBOs$TableLineVariant() {
    }
}
