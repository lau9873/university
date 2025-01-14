package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;
@DatabaseTable(tableName = "Lines")
/* loaded from: classes.dex */
public class DataModelDBOs$TableLine {
    @DatabaseField
    public boolean active;
    @DatabaseField(id = true)
    public String id;
    @DatabaseField
    public String name;
    @DatabaseField
    public int operatorRef;
    @DatabaseField
    public int ownerOperatorRef;
    @DatabaseField
    public int ref;

    public DataModelDBOs$TableLine(DataModelDTOs$LineDTO dataModelDTOs$LineDTO) {
        this.id = dataModelDTOs$LineDTO.getLineRef() + "|" + dataModelDTOs$LineDTO.getTransportOperatorRef();
        this.ref = dataModelDTOs$LineDTO.getLineRef();
        this.name = dataModelDTOs$LineDTO.getName();
        this.operatorRef = dataModelDTOs$LineDTO.getTransportOperatorRef();
        this.ownerOperatorRef = dataModelDTOs$LineDTO.getTransportOperatorOwnerRef();
        this.active = true;
    }

    public String a() {
        return this.id;
    }

    public String b() {
        return this.name;
    }

    public int c() {
        return this.operatorRef;
    }

    public int d() {
        return this.ownerOperatorRef;
    }

    public int e() {
        return this.ref;
    }

    public DataModels.j f() {
        return new DataModels.j(a(), e(), b(), c(), d());
    }

    public DataModelDBOs$TableLine() {
    }
}
