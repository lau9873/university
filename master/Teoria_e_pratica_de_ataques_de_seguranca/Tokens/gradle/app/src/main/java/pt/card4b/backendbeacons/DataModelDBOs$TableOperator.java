package pt.card4b.backendbeacons;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import pt.card4b.backendbeacons.DataModels;

@DatabaseTable(tableName = "Operators")
/* loaded from: classes.dex */
public class DataModelDBOs$TableOperator {
    @DatabaseField
    public String name;
    @DatabaseField(m4257id = true)
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

    /* renamed from: a */
    public String m296a() {
        return this.name;
    }

    /* renamed from: b */
    public int m295b() {
        return this.ref;
    }

    /* renamed from: c */
    public int m294c() {
        return this.repeatedInfoReceivedTimeout;
    }

    /* renamed from: d */
    public int m293d() {
        return this.timeout;
    }

    /* renamed from: e */
    public DataModels.C2704m m292e() {
        return new DataModels.C2704m(m295b(), m296a(), new DataModels.C2705n(this.typeRef, ""), m293d(), m294c());
    }

    public DataModelDBOs$TableOperator() {
    }
}
