package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p134db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.j256.ormlite.stmt.query.In */
/* loaded from: classes.dex */
public class C1472In extends BaseComparison {

    /* renamed from: in */
    public final boolean f6347in;
    public Iterable<?> objects;

    public C1472In(String str, FieldType fieldType, Iterable<?> iterable, boolean z) {
        super(str, fieldType, null, true);
        this.objects = iterable;
        this.f6347in = z;
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public void appendOperation(StringBuilder sb) {
        if (this.f6347in) {
            sb.append("IN ");
        } else {
            sb.append("NOT IN ");
        }
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Clause
    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list) {
        super.appendSql(databaseType, str, sb, list);
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) {
        sb.append('(');
        boolean z = true;
        for (Object obj : this.objects) {
            if (obj != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                super.appendArgOrValue(databaseType, this.fieldType, sb, list, obj);
            } else {
                throw new IllegalArgumentException("one of the IN values for '" + this.columnName + "' is null");
            }
        }
        sb.append(") ");
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public C1472In(String str, FieldType fieldType, Object[] objArr, boolean z) {
        super(str, fieldType, null, true);
        this.objects = Arrays.asList(objArr);
        this.f6347in = z;
    }
}
