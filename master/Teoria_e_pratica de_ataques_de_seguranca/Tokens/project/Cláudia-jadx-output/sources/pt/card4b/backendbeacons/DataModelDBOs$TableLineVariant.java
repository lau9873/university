package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;
@DatabaseTable(tableName = "LineVariants")
/* loaded from: classes.dex */
public class DataModelDBOs$TableLineVariant {
    @DatabaseField
    public String name;
    @DatabaseField(id = true)
    public int ref;

    public DataModelDBOs$TableLineVariant(DataModelDTOs$LineVariantDTO dataModelDTOs$LineVariantDTO) {
        this.ref = dataModelDTOs$LineVariantDTO.getLineVariantRef();
        this.name = dataModelDTOs$LineVariantDTO.getName();
    }

    public String a() {
        return this.name;
    }

    public int b() {
        return this.ref;
    }

    public DataModels.l c() {
        return new DataModels.l(b(), a());
    }

    public DataModelDBOs$TableLineVariant() {
    }
}
