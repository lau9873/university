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

    public DataModelDTOs$LineDTO(String str, int i2, int i3, int i4, Date date) {
        this.Name = str;
        this.LineRef = i2;
        this.TransportOperatorRef = i3;
        this.TransportOperatorOwnerRef = i4;
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

    public void setLineRef(int i2) {
        this.LineRef = i2;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setTransportOperatorOwnerRef(int i2) {
        this.TransportOperatorOwnerRef = i2;
    }

    public void setTransportOperatorRef(int i2) {
        this.TransportOperatorRef = i2;
    }

    public void setUpdateDate(Date date) {
        this.UpdateDate = date;
    }

    public DataModels.j toLine() {
        return new DataModels.j(getLineRef() + "|" + getTransportOperatorRef(), getLineRef(), getName(), getTransportOperatorRef(), getTransportOperatorOwnerRef());
    }
}
