package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
import java.util.Date;
import pt.card4b.backendbeacons.DataModels;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$InvoiceDetailsDTO {
    public Date Date;
    public String DocumentLink;
    public String DocumentNumber;
    public String InvoiceId;
    public float Total;

    public DataModelDTOs$InvoiceDetailsDTO(String str, String str2, String str3, Date date, float f2) {
        this.InvoiceId = str;
        this.DocumentNumber = str2;
        this.DocumentLink = str3;
        this.Date = date;
        this.Total = f2;
    }

    public Date getDate() {
        return this.Date;
    }

    public String getDocumentLink() {
        return this.DocumentLink;
    }

    public String getDocumentNumber() {
        return this.DocumentNumber;
    }

    public String getInvoiceId() {
        return this.InvoiceId;
    }

    public float getTotal() {
        return this.Total;
    }

    public void setDate(Date date) {
        this.Date = date;
    }

    public void setDocumentLink(String str) {
        this.DocumentLink = str;
    }

    public void setDocumentNumber(String str) {
        this.DocumentNumber = str;
    }

    public void setInvoiceId(String str) {
        this.InvoiceId = str;
    }

    public void setTotal(float f2) {
        this.Total = f2;
    }

    public DataModels.InvoiceInfo toInvoiceInfo() {
        return new DataModels.InvoiceInfo(this.InvoiceId, this.DocumentNumber, this.DocumentLink, this.Date, this.Total);
    }
}
