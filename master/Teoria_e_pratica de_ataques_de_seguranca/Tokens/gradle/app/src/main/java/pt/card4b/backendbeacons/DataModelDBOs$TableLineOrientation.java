package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;

@DatabaseTable(tableName = "LineOrientations")
/* loaded from: classes.dex */
public class DataModelDBOs$TableLineOrientation {
    @DatabaseField(m4257id = true)

    /* renamed from: id */
    public String f10709id;
    @DatabaseField
    public String name;
    @DatabaseField
    public int operatorRef;
    @DatabaseField
    public int ref;

    public DataModelDBOs$TableLineOrientation(DataModelDTOs$LineDirectionDTO dataModelDTOs$LineDirectionDTO) {
        this.f10709id = dataModelDTOs$LineDirectionDTO.getLineDirectionRef() + "|" + dataModelDTOs$LineDirectionDTO.getTransportOperatorRef();
        this.ref = dataModelDTOs$LineDirectionDTO.getLineDirectionRef();
        this.name = dataModelDTOs$LineDirectionDTO.getName();
        this.operatorRef = dataModelDTOs$LineDirectionDTO.getTransportOperatorRef();
    }

    /* renamed from: a */
    public String m303a() {
        return this.name;
    }

    /* renamed from: b */
    public int m302b() {
        return this.operatorRef;
    }

    /* renamed from: c */
    public int m301c() {
        return this.ref;
    }

    /* renamed from: d */
    public DataModels.C2702k m300d() {
        return new DataModels.C2702k(m301c() + "|" + m302b(), m301c(), m303a(), m302b());
    }

    public DataModelDBOs$TableLineOrientation() {
    }
}
