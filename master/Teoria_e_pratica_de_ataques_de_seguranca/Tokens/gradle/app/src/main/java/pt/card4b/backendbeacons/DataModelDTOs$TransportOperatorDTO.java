package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$TransportOperatorDTO {
    public String Name;
    public int RepeatedInfoReceivedTimeout;
    public int Timeout;
    public int TransportOperatorRef;
    public DataModelDTOs$TransportOperatorTypeDTO TransportOperatorType;
    public String UpdateDate;
    public Boolean hasRepeatedInfoReceivedTimeout;
    public Boolean hasTimeoutBeaconCommunication;

    public DataModelDTOs$TransportOperatorDTO(int i, String str, Boolean bool, int i2, String str2, DataModelDTOs$TransportOperatorTypeDTO dataModelDTOs$TransportOperatorTypeDTO, Boolean bool2, int i3) {
        this.TransportOperatorRef = i;
        this.Name = str;
        this.hasTimeoutBeaconCommunication = bool;
        this.Timeout = i2;
        this.UpdateDate = str2;
        this.TransportOperatorType = dataModelDTOs$TransportOperatorTypeDTO;
        this.hasRepeatedInfoReceivedTimeout = bool2;
        this.RepeatedInfoReceivedTimeout = i3;
    }

    public Boolean getHasRepeatedInfoReceivedTimeout() {
        return this.hasRepeatedInfoReceivedTimeout;
    }

    public Boolean getHasTimeoutBeaconCommunication() {
        return this.hasTimeoutBeaconCommunication;
    }

    public String getName() {
        return this.Name;
    }

    public int getRepeatedInfoReceivedTimeout() {
        return this.RepeatedInfoReceivedTimeout;
    }

    public int getTimeout() {
        return this.Timeout;
    }

    public int getTransportOperatorRef() {
        return this.TransportOperatorRef;
    }

    public DataModelDTOs$TransportOperatorTypeDTO getTransportOperatorType() {
        return this.TransportOperatorType;
    }

    public String getUpdateDate() {
        return this.UpdateDate;
    }

    public void setHasRepeatedInfoReceivedTimeout(Boolean bool) {
        this.hasRepeatedInfoReceivedTimeout = bool;
    }

    public void setHasTimeoutBeaconCommunication(Boolean bool) {
        this.hasTimeoutBeaconCommunication = bool;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setRepeatedInfoReceivedTimeout(int i) {
        this.RepeatedInfoReceivedTimeout = i;
    }

    public void setTimeout(int i) {
        this.Timeout = i;
    }

    public void setTransportOperatorRef(int i) {
        this.TransportOperatorRef = i;
    }

    public void setTransportOperatorType(DataModelDTOs$TransportOperatorTypeDTO dataModelDTOs$TransportOperatorTypeDTO) {
        this.TransportOperatorType = dataModelDTOs$TransportOperatorTypeDTO;
    }

    public void setUpdateDate(String str) {
        this.UpdateDate = str;
    }

    public DataModels.C2704m toOperator() {
        return new DataModels.C2704m(getTransportOperatorRef(), getName(), new DataModels.C2705n(getTransportOperatorType().getOperatorTypeRef(), getTransportOperatorType().getName()), getTimeout(), getRepeatedInfoReceivedTimeout());
    }
}
