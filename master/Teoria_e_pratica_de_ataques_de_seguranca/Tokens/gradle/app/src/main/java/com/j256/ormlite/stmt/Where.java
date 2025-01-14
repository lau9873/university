package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p134db.DatabaseType;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.query.Between;
import com.j256.ormlite.stmt.query.C1472In;
import com.j256.ormlite.stmt.query.Clause;
import com.j256.ormlite.stmt.query.Exists;
import com.j256.ormlite.stmt.query.InSubQuery;
import com.j256.ormlite.stmt.query.IsNotNull;
import com.j256.ormlite.stmt.query.IsNull;
import com.j256.ormlite.stmt.query.ManyClause;
import com.j256.ormlite.stmt.query.NeedsFutureClause;
import com.j256.ormlite.stmt.query.Not;
import com.j256.ormlite.stmt.query.Raw;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Where<T, ID> {
    public static final int CLAUSE_STACK_START_SIZE = 4;
    public int clauseStackLevel;
    public final DatabaseType databaseType;
    public final String idColumnName;
    public final FieldType idFieldType;
    public final StatementBuilder<T, ID> statementBuilder;
    public final TableInfo<T, ID> tableInfo;
    public Clause[] clauseStack = new Clause[4];
    public NeedsFutureClause needsFuture = null;

    public Where(TableInfo<T, ID> tableInfo, StatementBuilder<T, ID> statementBuilder, DatabaseType databaseType) {
        this.tableInfo = tableInfo;
        this.statementBuilder = statementBuilder;
        this.idFieldType = tableInfo.getIdField();
        FieldType fieldType = this.idFieldType;
        if (fieldType == null) {
            this.idColumnName = null;
        } else {
            this.idColumnName = fieldType.getColumnName();
        }
        this.databaseType = databaseType;
    }

    private void addClause(Clause clause) {
        NeedsFutureClause needsFutureClause = this.needsFuture;
        if (needsFutureClause == null) {
            push(clause);
            return;
        }
        needsFutureClause.setMissingClause(clause);
        this.needsFuture = null;
    }

    private void addNeedsFuture(NeedsFutureClause needsFutureClause) {
        if (this.needsFuture == null) {
            this.needsFuture = needsFutureClause;
            return;
        }
        throw new IllegalStateException(this.needsFuture + " is already waiting for a future clause, can't add: " + needsFutureClause);
    }

    private Clause[] buildClauseArray(Where<T, ID>[] whereArr, String str) {
        if (whereArr.length == 0) {
            return null;
        }
        Clause[] clauseArr = new Clause[whereArr.length];
        for (int length = whereArr.length - 1; length >= 0; length--) {
            clauseArr[length] = pop(str);
        }
        return clauseArr;
    }

    private QueryBuilder<T, ID> checkQueryBuilderMethod(String str) {
        StatementBuilder<T, ID> statementBuilder = this.statementBuilder;
        if (statementBuilder instanceof QueryBuilder) {
            return (QueryBuilder) statementBuilder;
        }
        throw new SQLException("Cannot call " + str + " on a statement of type " + this.statementBuilder.getType());
    }

    private FieldType findColumnFieldType(String str) {
        return this.tableInfo.getFieldTypeByColumnName(str);
    }

    private Clause peek() {
        return this.clauseStack[this.clauseStackLevel - 1];
    }

    private Clause pop(String str) {
        int i = this.clauseStackLevel;
        if (i != 0) {
            Clause[] clauseArr = this.clauseStack;
            int i2 = i - 1;
            this.clauseStackLevel = i2;
            Clause clause = clauseArr[i2];
            clauseArr[this.clauseStackLevel] = null;
            return clause;
        }
        throw new IllegalStateException("Expecting there to be a clause already defined for '" + str + "' operation");
    }

    private void push(Clause clause) {
        int i = this.clauseStackLevel;
        if (i == this.clauseStack.length) {
            Clause[] clauseArr = new Clause[i * 2];
            for (int i2 = 0; i2 < this.clauseStackLevel; i2++) {
                Clause[] clauseArr2 = this.clauseStack;
                clauseArr[i2] = clauseArr2[i2];
                clauseArr2[i2] = null;
            }
            this.clauseStack = clauseArr;
        }
        Clause[] clauseArr3 = this.clauseStack;
        int i3 = this.clauseStackLevel;
        this.clauseStackLevel = i3 + 1;
        clauseArr3[i3] = clause;
    }

    public Where<T, ID> and() {
        ManyClause manyClause = new ManyClause(pop(ManyClause.AND_OPERATION), ManyClause.AND_OPERATION);
        push(manyClause);
        addNeedsFuture(manyClause);
        return this;
    }

    public void appendSql(String str, StringBuilder sb, List<ArgumentHolder> list) {
        int i = this.clauseStackLevel;
        if (i == 0) {
            throw new IllegalStateException("No where clauses defined.  Did you miss a where operation?");
        }
        if (i == 1) {
            if (this.needsFuture == null) {
                peek().appendSql(this.databaseType, str, sb, list);
                return;
            }
            throw new IllegalStateException("The SQL statement has not been finished since there are previous operations still waiting for clauses.");
        }
        throw new IllegalStateException("Both the \"left-hand\" and \"right-hand\" clauses have been defined.  Did you miss an AND or OR?");
    }

    public Where<T, ID> between(String str, Object obj, Object obj2) {
        addClause(new Between(str, findColumnFieldType(str), obj, obj2));
        return this;
    }

    public long countOf() {
        return checkQueryBuilderMethod("countOf()").countOf();
    }

    /* renamed from: eq */
    public Where<T, ID> m4256eq(String str, Object obj) {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.EQUAL_TO_OPERATION));
        return this;
    }

    public Where<T, ID> exists(QueryBuilder<?, ?> queryBuilder) {
        queryBuilder.enableInnerQuery();
        addClause(new Exists(new QueryBuilder.InternalQueryBuilderWrapper(queryBuilder)));
        return this;
    }

    /* renamed from: ge */
    public Where<T, ID> m4255ge(String str, Object obj) {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION));
        return this;
    }

    public String getStatement() {
        StringBuilder sb = new StringBuilder();
        appendSql(null, sb, new ArrayList());
        return sb.toString();
    }

    /* renamed from: gt */
    public Where<T, ID> m4254gt(String str, Object obj) {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.GREATER_THAN_OPERATION));
        return this;
    }

    public Where<T, ID> idEq(ID id) {
        String str = this.idColumnName;
        if (str != null) {
            addClause(new SimpleComparison(str, this.idFieldType, id, SimpleComparison.EQUAL_TO_OPERATION));
            return this;
        }
        throw new SQLException("Object has no id column specified");
    }

    /* renamed from: in */
    public Where<T, ID> m4252in(String str, Iterable<?> iterable) {
        addClause(new C1472In(str, findColumnFieldType(str), iterable, true));
        return this;
    }

    public Where<T, ID> isNotNull(String str) {
        addClause(new IsNotNull(str, findColumnFieldType(str)));
        return this;
    }

    public Where<T, ID> isNull(String str) {
        addClause(new IsNull(str, findColumnFieldType(str)));
        return this;
    }

    public CloseableIterator<T> iterator() {
        return checkQueryBuilderMethod("iterator()").iterator();
    }

    /* renamed from: le */
    public Where<T, ID> m4248le(String str, Object obj) {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION));
        return this;
    }

    public Where<T, ID> like(String str, Object obj) {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.LIKE_OPERATION));
        return this;
    }

    /* renamed from: lt */
    public Where<T, ID> m4247lt(String str, Object obj) {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.LESS_THAN_OPERATION));
        return this;
    }

    /* renamed from: ne */
    public Where<T, ID> m4246ne(String str, Object obj) {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, SimpleComparison.NOT_EQUAL_TO_OPERATION));
        return this;
    }

    public Where<T, ID> not() {
        Not not = new Not();
        addClause(not);
        addNeedsFuture(not);
        return this;
    }

    public Where<T, ID> notIn(String str, Iterable<?> iterable) {
        addClause(new C1472In(str, findColumnFieldType(str), iterable, false));
        return this;
    }

    /* renamed from: or */
    public Where<T, ID> m4245or() {
        ManyClause manyClause = new ManyClause(pop(ManyClause.OR_OPERATION), ManyClause.OR_OPERATION);
        push(manyClause);
        addNeedsFuture(manyClause);
        return this;
    }

    public PreparedQuery<T> prepare() {
        return this.statementBuilder.prepareStatement(null, false);
    }

    public List<T> query() {
        return checkQueryBuilderMethod("query()").query();
    }

    public T queryForFirst() {
        return checkQueryBuilderMethod("queryForFirst()").queryForFirst();
    }

    public GenericRawResults<String[]> queryRaw() {
        return checkQueryBuilderMethod("queryRaw()").queryRaw();
    }

    public String[] queryRawFirst() {
        return checkQueryBuilderMethod("queryRawFirst()").queryRawFirst();
    }

    public Where<T, ID> raw(String str, ArgumentHolder... argumentHolderArr) {
        for (ArgumentHolder argumentHolder : argumentHolderArr) {
            String columnName = argumentHolder.getColumnName();
            if (columnName == null) {
                if (argumentHolder.getSqlType() == null) {
                    throw new IllegalArgumentException("Either the column name or SqlType must be set on each argument");
                }
            } else {
                argumentHolder.setMetaInfo(findColumnFieldType(columnName));
            }
        }
        addClause(new Raw(str, argumentHolderArr));
        return this;
    }

    public Where<T, ID> rawComparison(String str, String str2, Object obj) {
        addClause(new SimpleComparison(str, findColumnFieldType(str), obj, str2));
        return this;
    }

    public Where<T, ID> reset() {
        for (int i = 0; i < this.clauseStackLevel; i++) {
            this.clauseStack[i] = null;
        }
        this.clauseStackLevel = 0;
        return this;
    }

    public String toString() {
        if (this.clauseStackLevel == 0) {
            return "empty where clause";
        }
        Clause peek = peek();
        return "where clause: " + peek;
    }

    /* renamed from: in */
    public Where<T, ID> m4251in(String str, Object... objArr) {
        return m4249in(true, str, objArr);
    }

    public Where<T, ID> notIn(String str, Object... objArr) {
        return m4249in(false, str, objArr);
    }

    /* renamed from: in */
    public Where<T, ID> m4253in(String str, QueryBuilder<?, ?> queryBuilder) {
        return m4250in(true, str, queryBuilder);
    }

    public Where<T, ID> notIn(String str, QueryBuilder<?, ?> queryBuilder) {
        return m4250in(false, str, queryBuilder);
    }

    /* renamed from: in */
    private Where<T, ID> m4249in(boolean z, String str, Object... objArr) {
        if (objArr.length == 1) {
            if (objArr[0].getClass().isArray()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Object argument to ");
                sb.append(z ? "IN" : "notId");
                sb.append(" seems to be an array within an array");
                throw new IllegalArgumentException(sb.toString());
            } else if (objArr[0] instanceof Where) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Object argument to ");
                sb2.append(z ? "IN" : "notId");
                sb2.append(" seems to be a Where object, did you mean the QueryBuilder?");
                throw new IllegalArgumentException(sb2.toString());
            } else if (objArr[0] instanceof PreparedStmt) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Object argument to ");
                sb3.append(z ? "IN" : "notId");
                sb3.append(" seems to be a prepared statement, did you mean the QueryBuilder?");
                throw new IllegalArgumentException(sb3.toString());
            }
        }
        addClause(new C1472In(str, findColumnFieldType(str), objArr, z));
        return this;
    }

    public Where<T, ID> and(Where<T, ID> where, Where<T, ID> where2, Where<T, ID>... whereArr) {
        Clause[] buildClauseArray = buildClauseArray(whereArr, ManyClause.AND_OPERATION);
        addClause(new ManyClause(pop(ManyClause.AND_OPERATION), pop(ManyClause.AND_OPERATION), buildClauseArray, ManyClause.AND_OPERATION));
        return this;
    }

    public <OD> Where<T, ID> idEq(Dao<OD, ?> dao, OD od) {
        String str = this.idColumnName;
        if (str != null) {
            addClause(new SimpleComparison(str, this.idFieldType, dao.extractId(od), SimpleComparison.EQUAL_TO_OPERATION));
            return this;
        }
        throw new SQLException("Object has no id column specified");
    }

    public Where<T, ID> not(Where<T, ID> where) {
        addClause(new Not(pop("NOT")));
        return this;
    }

    /* renamed from: or */
    public Where<T, ID> m4243or(Where<T, ID> where, Where<T, ID> where2, Where<T, ID>... whereArr) {
        Clause[] buildClauseArray = buildClauseArray(whereArr, ManyClause.OR_OPERATION);
        addClause(new ManyClause(pop(ManyClause.OR_OPERATION), pop(ManyClause.OR_OPERATION), buildClauseArray, ManyClause.OR_OPERATION));
        return this;
    }

    public Where<T, ID> and(int i) {
        if (i != 0) {
            Clause[] clauseArr = new Clause[i];
            while (true) {
                i--;
                if (i >= 0) {
                    clauseArr[i] = pop(ManyClause.AND_OPERATION);
                } else {
                    addClause(new ManyClause(clauseArr, ManyClause.AND_OPERATION));
                    return this;
                }
            }
        } else {
            throw new IllegalArgumentException("Must have at least one clause in and(numClauses)");
        }
    }

    /* renamed from: or */
    public Where<T, ID> m4244or(int i) {
        if (i != 0) {
            Clause[] clauseArr = new Clause[i];
            while (true) {
                i--;
                if (i >= 0) {
                    clauseArr[i] = pop(ManyClause.OR_OPERATION);
                } else {
                    addClause(new ManyClause(clauseArr, ManyClause.OR_OPERATION));
                    return this;
                }
            }
        } else {
            throw new IllegalArgumentException("Must have at least one clause in or(numClauses)");
        }
    }

    /* renamed from: in */
    private Where<T, ID> m4250in(boolean z, String str, QueryBuilder<?, ?> queryBuilder) {
        if (queryBuilder.getSelectColumnCount() != 1) {
            if (queryBuilder.getSelectColumnCount() == 0) {
                throw new SQLException("Inner query must have only 1 select column specified instead of *");
            }
            throw new SQLException("Inner query must have only 1 select column specified instead of " + queryBuilder.getSelectColumnCount() + ": " + queryBuilder.getSelectColumnsAsString());
        }
        queryBuilder.enableInnerQuery();
        addClause(new InSubQuery(str, findColumnFieldType(str), new QueryBuilder.InternalQueryBuilderWrapper(queryBuilder), z));
        return this;
    }
}
