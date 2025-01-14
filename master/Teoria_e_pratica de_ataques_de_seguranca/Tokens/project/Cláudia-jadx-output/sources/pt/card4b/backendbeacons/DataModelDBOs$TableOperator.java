package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;
@DatabaseTable(tableName = "Operators")
/* loaded from: classes.dex */
public class DataModelDBOs$TableOperator {
    @DatabaseField
    public String name;
    @DatabaseField(id = true)
    public int ref;
    @DatabaseField
    public int repeatedInfoReceivedTimeout;
    @DatabaseField
    public int timeout;
    @DatabaseField
    public int typeRef;

    public DataModelDBOs$TableOperator(DataModelDTOs$TransportOperatorDTO dataModelDTOs$TransportOperatorDTO) {
        this.ref = dataModelDTOs$TransportOperatorDTO.getTransportOperatorRef();
        this.name = dataModelDTOs$TransportOperatorDTO.getName();
        this.typeRef = dataModelDTOs$TransportOperatorDTO.getTransportOperatorType().getOperatorTypeRef();
        this.timeout = dataModelDTOs$TransportOperatorDTO.getTimeout();
        this.repeatedInfoReceivedTimeout = dataModelDTOs$TransportOperatorDTO.getRepeatedInfoReceivedTimeout();
    }

    public String a() {
        return this.name;
    }

    public int b() {
        return this.ref;
    }

    public int c() {
        return this.repeatedInfoReceivedTimeout;
    }

    public int d() {
        return this.timeout;
    }

    public DataModels.m e() {
        return new DataModels.m(b(), a(), new DataModels.n(this.typeRef, ""), d(), c());
    }

    public DataModelDBOs$TableOperator() {
    }
}
