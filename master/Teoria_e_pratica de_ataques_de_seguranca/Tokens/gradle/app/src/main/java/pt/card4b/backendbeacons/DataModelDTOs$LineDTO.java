package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.util.Date;
import pt.card4b.backendbeacons.DataModels;

@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$LineDTO {
    public int LineRef;
    public String Name;
    public int TransportOperatorOwnerRef;
    public int TransportOperatorRef;
    public Date UpdateDate;

    public DataModelDTOs$LineDTO(String str, int i, int i2, int i3, Date date) {
        this.Name = str;
        this.LineRef = i;
        this.TransportOperatorRef = i2;
        this.TransportOperatorOwnerRef = i3;
        this.UpdateDate = date;
    }

    public int getLineRef() {
        return this.LineRef;
    }

    public String getName() {
        return this.Name;
    }

    public int getTransportOperatorOwnerRef() {
        return this.TransportOperatorOwnerRef;
    }

    public int getTransportOperatorRef() {
        return this.TransportOperatorRef;
    }

    public Date getUpdateDate() {
        return this.UpdateDate;
    }

    public void setLineRef(int i) {
        this.LineRef = i;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setTransportOperatorOwnerRef(int i) {
        this.TransportOperatorOwnerRef = i;
    }

    public void setTransportOperatorRef(int i) {
        this.TransportOperatorRef = i;
    }

    public void setUpdateDate(Date date) {
        this.UpdateDate = date;
    }

    public DataModels.C2701j toLine() {
        return new DataModels.C2701j(getLineRef() + "|" + getTransportOperatorRef(), getLineRef(), getName(), getTransportOperatorRef(), getTransportOperatorOwnerRef());
    }
}
