package pt.card4b.backendbeacons;

import android.support.annotation.Keep;
@Keep
/* loaded from: classes.dex */
public class DataModelDTOs$StageStatusDTO {
    public boolean Finished;
    public boolean Ongoing;
    public String StageName;
    public boolean Started;
    public boolean Stoped;

    public DataModelDTOs$StageStatusDTO(boolean z, boolean z2, boolean z3, String str, boolean z4) {
        this.Started = z;
        this.Ongoing = z2;
        this.Finished = z3;
        this.StageName = str;
        this.Stoped = z4;
    }

    public String getStageName() {
        return this.StageName;
    }

    public boolean isFinished() {
        return this.Finished;
    }

    public boolean isOngoing() {
        return this.Ongoing;
    }

    public boolean isStarted() {
        return this.Started;
    }

    public boolean isStoped() {
        return this.Stoped;
    }

    public void setFinished(boolean z) {
        this.Finished = z;
    }

    public void setOngoing(boolean z) {
        this.Ongoing = z;
    }

    public void setStageName(String str) {
        this.StageName = str;
    }

    public void setStarted(boolean z) {
        this.Started = z;
    }

    public void setStoped(boolean z) {
        this.Stoped = z;
    }
}
