package pt.card4b.backendbeacons;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.File;
import java.util.List;
/* loaded from: classes.dex */
public class Database extends OrmLiteSqliteOpenHelper {
    public static String n = "andante_db.sqlite";
    public static int o = 6;
    public static volatile Database p;

    /* renamed from: a  reason: collision with root package name */
    public String f7762a;

    /* renamed from: b  reason: collision with root package name */
    public Context f7763b;

    /* renamed from: c  reason: collision with root package name */
    public RuntimeExceptionDao<DataModelDBOs$TableBeaconInformationType, Integer> f7764c;

    /* renamed from: d  reason: collision with root package name */
    public RuntimeExceptionDao<DataModelDBOs$TableLine, Integer> f7765d;

    /* renamed from: e  reason: collision with root package name */
    public RuntimeExceptionDao<DataModelDBOs$TableLineOrientation, Integer> f7766e;

    /* renamed from: f  reason: collision with root package name */
    public RuntimeExceptionDao<DataModelDBOs$TableLineVariant, Integer> f7767f;

    /* renamed from: g  reason: collision with root package name */
    public RuntimeExceptionDao<DataModelDBOs$TableOperator, Integer> f7768g;

    /* renamed from: h  reason: collision with root package name */
    public RuntimeExceptionDao<DataModelDBOs$TableStop, Integer> f7769h;

    /* renamed from: i  reason: collision with root package name */
    public RuntimeExceptionDao<DataModelDBOs$TableZone, Integer> f7770i;
    public RuntimeExceptionDao<DataModelDBOs$TableConfiguration, Integer> j;
    public RuntimeExceptionDao<DataModelDBOs$TableCustomerProfile, Integer> k;
    public RuntimeExceptionDao<DataModelDBOs$TableCountry, Integer> l;
    public RuntimeExceptionDao<DataModelDBOs$TableLanguage, Integer> m;

    public Database(Context context) {
        super(context, n, null, o);
        this.f7762a = "";
        this.f7764c = null;
        this.f7765d = null;
        this.f7766e = null;
        this.f7767f = null;
        this.f7768g = null;
        this.f7769h = null;
        this.f7770i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f7763b = context;
        this.f7762a = q();
        try {
            a();
            if (t().queryBuilder().where().isNull(DatabaseFieldConfigLoader.FIELD_NAME_ID).countOf() > 0) {
                getWritableDatabase().execSQL("DELETE from Configurations where rowid not in (select max(rowid) from Configurations group by IFNULL(customerId,''),code)");
                getWritableDatabase().execSQL("UPDATE Configurations set id = (IFNULL(customerId||'|','')||code)");
                getWritableDatabase().execSQL("DELETE from Stops where rowid not in (select max(rowid) from Stops group by ref,operatorRef)");
                getWritableDatabase().execSQL("UPDATE Stops set id = ref||'|'||operatorRef");
                getWritableDatabase().execSQL("DELETE from LineOrientations where rowid not in (select max(rowid) from LineOrientations group by ref,operatorRef)");
                getWritableDatabase().execSQL("UPDATE LineOrientations set id = ref||'|'||operatorRef");
                getWritableDatabase().execSQL("DELETE from Lines where rowid not in (select max(rowid) from Lines group by ref,operatorRef)");
                getWritableDatabase().execSQL("UPDATE Lines set id = ref||'|'||operatorRef");
            }
        } catch (Throwable th) {
            throw new RuntimeException("Database: " + Log.getStackTraceString(th));
        }
    }

    private void a() {
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableLine.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableLineOrientation.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableNewLineOrientation.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableLineVariant.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableOperator.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableOperatorType.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableStop.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableStopInfo.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableTimeout.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableUser.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableZone.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableBeaconInformationType.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableBeacon.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableBeaconData.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableConfiguration.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableCustomerProfile.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableCountry.class);
        TableUtils.createTableIfNotExists(this.connectionSource, DataModelDBOs$TableLanguage.class);
    }

    private RuntimeExceptionDao<DataModelDBOs$TableBeaconInformationType, Integer> m() {
        if (this.f7764c == null) {
            this.f7764c = getRuntimeExceptionDao(DataModelDBOs$TableBeaconInformationType.class);
        }
        return this.f7764c;
    }

    private RuntimeExceptionDao<DataModelDBOs$TableConfiguration, Integer> n() {
        if (this.j == null) {
            this.j = getRuntimeExceptionDao(DataModelDBOs$TableConfiguration.class);
        }
        return this.j;
    }

    private RuntimeExceptionDao<DataModelDBOs$TableCountry, Integer> o() {
        if (this.l == null) {
            this.l = getRuntimeExceptionDao(DataModelDBOs$TableCountry.class);
        }
        return this.l;
    }

    private RuntimeExceptionDao<DataModelDBOs$TableCustomerProfile, Integer> p() {
        if (this.k == null) {
            this.k = getRuntimeExceptionDao(DataModelDBOs$TableCustomerProfile.class);
        }
        return this.k;
    }

    private String q() {
        if (!this.f7762a.equals("")) {
            return this.f7762a;
        }
        File file = new File("/data/data/" + this.f7763b.getPackageName(), "databases/");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath() + "/";
    }

    public static Database r() {
        if (p == null) {
            synchronized (Database.class) {
                if (p == null) {
                    p = new Database(App.getInstance());
                }
            }
        }
        return p;
    }

    private RuntimeExceptionDao<DataModelDBOs$TableLanguage, Integer> s() {
        if (this.m == null) {
            this.m = getRuntimeExceptionDao(DataModelDBOs$TableLanguage.class);
        }
        return this.m;
    }

    private RuntimeExceptionDao<DataModelDBOs$TableLine, Integer> t() {
        if (this.f7765d == null) {
            this.f7765d = getRuntimeExceptionDao(DataModelDBOs$TableLine.class);
        }
        return this.f7765d;
    }

    private RuntimeExceptionDao<DataModelDBOs$TableLineOrientation, Integer> u() {
        if (this.f7766e == null) {
            this.f7766e = getRuntimeExceptionDao(DataModelDBOs$TableLineOrientation.class);
        }
        return this.f7766e;
    }

    private RuntimeExceptionDao<DataModelDBOs$TableLineVariant, Integer> v() {
        if (this.f7767f == null) {
            this.f7767f = getRuntimeExceptionDao(DataModelDBOs$TableLineVariant.class);
        }
        return this.f7767f;
    }

    private RuntimeExceptionDao<DataModelDBOs$TableOperator, Integer> w() {
        if (this.f7768g == null) {
            this.f7768g = getRuntimeExceptionDao(DataModelDBOs$TableOperator.class);
        }
        return this.f7768g;
    }

    private RuntimeExceptionDao<DataModelDBOs$TableStop, Integer> x() {
        if (this.f7769h == null) {
            this.f7769h = getRuntimeExceptionDao(DataModelDBOs$TableStop.class);
        }
        return this.f7769h;
    }

    private RuntimeExceptionDao<DataModelDBOs$TableZone, Integer> y() {
        if (this.f7770i == null) {
            this.f7770i = getRuntimeExceptionDao(DataModelDBOs$TableZone.class);
        }
        return this.f7770i;
    }

    public void A() {
        getWritableDatabase().execSQL("DELETE FROM Stops WHERE active = 0");
    }

    public void B() {
        getWritableDatabase().execSQL("UPDATE Lines SET active = 0");
    }

    public void C() {
        getWritableDatabase().execSQL("UPDATE Stops SET active = 0");
    }

    public List<DataModelDBOs$TableBeaconInformationType> b() {
        return m().queryForAll();
    }

    public List<DataModelDBOs$TableConfiguration> c() {
        return n().queryForAll();
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper, android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.f7769h = null;
    }

    public void d(List<DataModelDBOs$TableCustomerProfile> list) {
        for (DataModelDBOs$TableCustomerProfile dataModelDBOs$TableCustomerProfile : list) {
            a(dataModelDBOs$TableCustomerProfile);
        }
    }

    public List<DataModelDBOs$TableCustomerProfile> e() {
        return p().queryForAll();
    }

    public void f(List<DataModelDBOs$TableLine> list) {
        for (DataModelDBOs$TableLine dataModelDBOs$TableLine : list) {
            a(dataModelDBOs$TableLine);
        }
    }

    public void g(List<DataModelDBOs$TableLineOrientation> list) {
        for (DataModelDBOs$TableLineOrientation dataModelDBOs$TableLineOrientation : list) {
            a(dataModelDBOs$TableLineOrientation);
        }
    }

    public void h(List<DataModelDBOs$TableLineVariant> list) {
        for (DataModelDBOs$TableLineVariant dataModelDBOs$TableLineVariant : list) {
            a(dataModelDBOs$TableLineVariant);
        }
    }

    public List<DataModelDBOs$TableLine> i() {
        return t().queryForAll();
    }

    public void j(List<DataModelDBOs$TableStop> list) {
        for (DataModelDBOs$TableStop dataModelDBOs$TableStop : list) {
            a(dataModelDBOs$TableStop);
        }
    }

    public List<DataModelDBOs$TableStop> k() {
        return x().queryForAll();
    }

    public List<DataModelDBOs$TableZone> l() {
        return y().queryForAll();
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i2, int i3) {
        if (i2 < 2) {
            sQLiteDatabase.execSQL("ALTER TABLE Operators ADD COLUMN repeatedInfoReceivedTimeout INTEGER DEFAULT 0");
        }
        if (i2 < 3) {
            sQLiteDatabase.execSQL("ALTER TABLE Configurations ADD COLUMN id STRING");
        }
        if (i2 < 4) {
            sQLiteDatabase.execSQL("ALTER TABLE Lines ADD COLUMN ownerOperatorRef STRING");
            sQLiteDatabase.execSQL("UPDATE Lines SET ownerOperatorRef=operatorRef");
        }
        if (i2 < 5) {
            sQLiteDatabase.execSQL("ALTER TABLE Stops ADD COLUMN beaconStopRef INTEGER");
            sQLiteDatabase.execSQL("UPDATE Stops SET beaconStopRef=ref");
        }
        if (i2 < 5) {
            sQLiteDatabase.execSQL("ALTER TABLE Stops ADD COLUMN beaconStopRef INTEGER");
            sQLiteDatabase.execSQL("UPDATE Stops SET beaconStopRef=ref");
        }
        if (i2 < 6) {
            sQLiteDatabase.execSQL("ALTER TABLE Lines ADD COLUMN active INTEGER");
            sQLiteDatabase.execSQL("UPDATE Lines SET active = 1");
        }
    }

    public void z() {
        getWritableDatabase().execSQL("DELETE FROM Lines WHERE active = 0");
    }

    public void b(List<DataModelDBOs$TableConfiguration> list) {
        for (DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration : list) {
            a(dataModelDBOs$TableConfiguration);
        }
    }

    public void c(List<DataModelDBOs$TableCountry> list) {
        for (DataModelDBOs$TableCountry dataModelDBOs$TableCountry : list) {
            a(dataModelDBOs$TableCountry);
        }
    }

    public void e(List<DataModelDBOs$TableLanguage> list) {
        for (DataModelDBOs$TableLanguage dataModelDBOs$TableLanguage : list) {
            a(dataModelDBOs$TableLanguage);
        }
    }

    public void i(List<DataModelDBOs$TableOperator> list) {
        for (DataModelDBOs$TableOperator dataModelDBOs$TableOperator : list) {
            a(dataModelDBOs$TableOperator);
        }
    }

    public void k(List<DataModelDBOs$TableZone> list) {
        for (DataModelDBOs$TableZone dataModelDBOs$TableZone : list) {
            a(dataModelDBOs$TableZone);
        }
    }

    public List<DataModelDBOs$TableCountry> d() {
        return o().queryForAll();
    }

    public List<DataModelDBOs$TableLanguage> f() {
        return s().queryForAll();
    }

    public List<DataModelDBOs$TableLineOrientation> g() {
        return u().queryForAll();
    }

    public List<DataModelDBOs$TableLineVariant> h() {
        return v().queryForAll();
    }

    public List<DataModelDBOs$TableOperator> j() {
        return w().queryForAll();
    }

    public void b(DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration) {
        n().delete((RuntimeExceptionDao<DataModelDBOs$TableConfiguration, Integer>) dataModelDBOs$TableConfiguration);
    }

    public void a(DataModelDBOs$TableBeaconInformationType dataModelDBOs$TableBeaconInformationType) {
        m().createOrUpdate(dataModelDBOs$TableBeaconInformationType);
    }

    public void a(List<DataModelDBOs$TableBeaconInformationType> list) {
        for (DataModelDBOs$TableBeaconInformationType dataModelDBOs$TableBeaconInformationType : list) {
            a(dataModelDBOs$TableBeaconInformationType);
        }
    }

    public void a(DataModelDBOs$TableStop dataModelDBOs$TableStop) {
        x().createOrUpdate(dataModelDBOs$TableStop);
    }

    public void a(DataModelDBOs$TableLine dataModelDBOs$TableLine) {
        t().createOrUpdate(dataModelDBOs$TableLine);
    }

    public void a(DataModelDBOs$TableLineOrientation dataModelDBOs$TableLineOrientation) {
        u().createOrUpdate(dataModelDBOs$TableLineOrientation);
    }

    public void a(DataModelDBOs$TableLineVariant dataModelDBOs$TableLineVariant) {
        v().createOrUpdate(dataModelDBOs$TableLineVariant);
    }

    public void a(DataModelDBOs$TableOperator dataModelDBOs$TableOperator) {
        w().createOrUpdate(dataModelDBOs$TableOperator);
    }

    public void a(DataModelDBOs$TableZone dataModelDBOs$TableZone) {
        y().createOrUpdate(dataModelDBOs$TableZone);
    }

    public void a(DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration) {
        n().createOrUpdate(dataModelDBOs$TableConfiguration);
    }

    public void a(DataModelDBOs$TableCustomerProfile dataModelDBOs$TableCustomerProfile) {
        p().createOrUpdate(dataModelDBOs$TableCustomerProfile);
    }

    public void a(DataModelDBOs$TableCountry dataModelDBOs$TableCountry) {
        o().createOrUpdate(dataModelDBOs$TableCountry);
    }

    public void a(DataModelDBOs$TableLanguage dataModelDBOs$TableLanguage) {
        s().createOrUpdate(dataModelDBOs$TableLanguage);
    }
}
