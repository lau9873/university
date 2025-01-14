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

    /* renamed from: n */
    public static String f10892n = "andante_db.sqlite";

    /* renamed from: o */
    public static int f10893o = 6;

    /* renamed from: p */
    public static volatile Database f10894p;

    /* renamed from: a */
    public String f10895a;

    /* renamed from: b */
    public Context f10896b;

    /* renamed from: c */
    public RuntimeExceptionDao<DataModelDBOs$TableBeaconInformationType, Integer> f10897c;

    /* renamed from: d */
    public RuntimeExceptionDao<DataModelDBOs$TableLine, Integer> f10898d;

    /* renamed from: e */
    public RuntimeExceptionDao<DataModelDBOs$TableLineOrientation, Integer> f10899e;

    /* renamed from: f */
    public RuntimeExceptionDao<DataModelDBOs$TableLineVariant, Integer> f10900f;

    /* renamed from: g */
    public RuntimeExceptionDao<DataModelDBOs$TableOperator, Integer> f10901g;

    /* renamed from: h */
    public RuntimeExceptionDao<DataModelDBOs$TableStop, Integer> f10902h;

    /* renamed from: i */
    public RuntimeExceptionDao<DataModelDBOs$TableZone, Integer> f10903i;

    /* renamed from: j */
    public RuntimeExceptionDao<DataModelDBOs$TableConfiguration, Integer> f10904j;

    /* renamed from: k */
    public RuntimeExceptionDao<DataModelDBOs$TableCustomerProfile, Integer> f10905k;

    /* renamed from: l */
    public RuntimeExceptionDao<DataModelDBOs$TableCountry, Integer> f10906l;

    /* renamed from: m */
    public RuntimeExceptionDao<DataModelDBOs$TableLanguage, Integer> f10907m;

    public Database(Context context) {
        super(context, f10892n, null, f10893o);
        this.f10895a = "";
        this.f10897c = null;
        this.f10898d = null;
        this.f10899e = null;
        this.f10900f = null;
        this.f10901g = null;
        this.f10902h = null;
        this.f10903i = null;
        this.f10904j = null;
        this.f10905k = null;
        this.f10906l = null;
        this.f10907m = null;
        this.f10896b = context;
        this.f10895a = m67q();
        try {
            m106a();
            if (m64t().queryBuilder().where().isNull(DatabaseFieldConfigLoader.FIELD_NAME_ID).countOf() > 0) {
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

    /* renamed from: a */
    private void m106a() {
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

    /* renamed from: m */
    private RuntimeExceptionDao<DataModelDBOs$TableBeaconInformationType, Integer> m71m() {
        if (this.f10897c == null) {
            this.f10897c = getRuntimeExceptionDao(DataModelDBOs$TableBeaconInformationType.class);
        }
        return this.f10897c;
    }

    /* renamed from: n */
    private RuntimeExceptionDao<DataModelDBOs$TableConfiguration, Integer> m70n() {
        if (this.f10904j == null) {
            this.f10904j = getRuntimeExceptionDao(DataModelDBOs$TableConfiguration.class);
        }
        return this.f10904j;
    }

    /* renamed from: o */
    private RuntimeExceptionDao<DataModelDBOs$TableCountry, Integer> m69o() {
        if (this.f10906l == null) {
            this.f10906l = getRuntimeExceptionDao(DataModelDBOs$TableCountry.class);
        }
        return this.f10906l;
    }

    /* renamed from: p */
    private RuntimeExceptionDao<DataModelDBOs$TableCustomerProfile, Integer> m68p() {
        if (this.f10905k == null) {
            this.f10905k = getRuntimeExceptionDao(DataModelDBOs$TableCustomerProfile.class);
        }
        return this.f10905k;
    }

    /* renamed from: q */
    private String m67q() {
        if (!this.f10895a.equals("")) {
            return this.f10895a;
        }
        File file = new File("/data/data/" + this.f10896b.getPackageName(), "databases/");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath() + "/";
    }

    /* renamed from: r */
    public static Database m66r() {
        if (f10894p == null) {
            synchronized (Database.class) {
                if (f10894p == null) {
                    f10894p = new Database(App.getInstance());
                }
            }
        }
        return f10894p;
    }

    /* renamed from: s */
    private RuntimeExceptionDao<DataModelDBOs$TableLanguage, Integer> m65s() {
        if (this.f10907m == null) {
            this.f10907m = getRuntimeExceptionDao(DataModelDBOs$TableLanguage.class);
        }
        return this.f10907m;
    }

    /* renamed from: t */
    private RuntimeExceptionDao<DataModelDBOs$TableLine, Integer> m64t() {
        if (this.f10898d == null) {
            this.f10898d = getRuntimeExceptionDao(DataModelDBOs$TableLine.class);
        }
        return this.f10898d;
    }

    /* renamed from: u */
    private RuntimeExceptionDao<DataModelDBOs$TableLineOrientation, Integer> m63u() {
        if (this.f10899e == null) {
            this.f10899e = getRuntimeExceptionDao(DataModelDBOs$TableLineOrientation.class);
        }
        return this.f10899e;
    }

    /* renamed from: v */
    private RuntimeExceptionDao<DataModelDBOs$TableLineVariant, Integer> m62v() {
        if (this.f10900f == null) {
            this.f10900f = getRuntimeExceptionDao(DataModelDBOs$TableLineVariant.class);
        }
        return this.f10900f;
    }

    /* renamed from: w */
    private RuntimeExceptionDao<DataModelDBOs$TableOperator, Integer> m61w() {
        if (this.f10901g == null) {
            this.f10901g = getRuntimeExceptionDao(DataModelDBOs$TableOperator.class);
        }
        return this.f10901g;
    }

    /* renamed from: x */
    private RuntimeExceptionDao<DataModelDBOs$TableStop, Integer> m60x() {
        if (this.f10902h == null) {
            this.f10902h = getRuntimeExceptionDao(DataModelDBOs$TableStop.class);
        }
        return this.f10902h;
    }

    /* renamed from: y */
    private RuntimeExceptionDao<DataModelDBOs$TableZone, Integer> m59y() {
        if (this.f10903i == null) {
            this.f10903i = getRuntimeExceptionDao(DataModelDBOs$TableZone.class);
        }
        return this.f10903i;
    }

    /* renamed from: A */
    public void m109A() {
        getWritableDatabase().execSQL("DELETE FROM Stops WHERE active = 0");
    }

    /* renamed from: B */
    public void m108B() {
        getWritableDatabase().execSQL("UPDATE Lines SET active = 0");
    }

    /* renamed from: C */
    public void m107C() {
        getWritableDatabase().execSQL("UPDATE Stops SET active = 0");
    }

    /* renamed from: b */
    public List<DataModelDBOs$TableBeaconInformationType> m93b() {
        return m71m().queryForAll();
    }

    /* renamed from: c */
    public List<DataModelDBOs$TableConfiguration> m90c() {
        return m70n().queryForAll();
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper, android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.f10902h = null;
    }

    /* renamed from: d */
    public void m87d(List<DataModelDBOs$TableCustomerProfile> list) {
        for (DataModelDBOs$TableCustomerProfile dataModelDBOs$TableCustomerProfile : list) {
            m101a(dataModelDBOs$TableCustomerProfile);
        }
    }

    /* renamed from: e */
    public List<DataModelDBOs$TableCustomerProfile> m86e() {
        return m68p().queryForAll();
    }

    /* renamed from: f */
    public void m83f(List<DataModelDBOs$TableLine> list) {
        for (DataModelDBOs$TableLine dataModelDBOs$TableLine : list) {
            m99a(dataModelDBOs$TableLine);
        }
    }

    /* renamed from: g */
    public void m81g(List<DataModelDBOs$TableLineOrientation> list) {
        for (DataModelDBOs$TableLineOrientation dataModelDBOs$TableLineOrientation : list) {
            m98a(dataModelDBOs$TableLineOrientation);
        }
    }

    /* renamed from: h */
    public void m79h(List<DataModelDBOs$TableLineVariant> list) {
        for (DataModelDBOs$TableLineVariant dataModelDBOs$TableLineVariant : list) {
            m97a(dataModelDBOs$TableLineVariant);
        }
    }

    /* renamed from: i */
    public List<DataModelDBOs$TableLine> m78i() {
        return m64t().queryForAll();
    }

    /* renamed from: j */
    public void m75j(List<DataModelDBOs$TableStop> list) {
        for (DataModelDBOs$TableStop dataModelDBOs$TableStop : list) {
            m95a(dataModelDBOs$TableStop);
        }
    }

    /* renamed from: k */
    public List<DataModelDBOs$TableStop> m74k() {
        return m60x().queryForAll();
    }

    /* renamed from: l */
    public List<DataModelDBOs$TableZone> m72l() {
        return m59y().queryForAll();
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            m106a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        if (i < 2) {
            sQLiteDatabase.execSQL("ALTER TABLE Operators ADD COLUMN repeatedInfoReceivedTimeout INTEGER DEFAULT 0");
        }
        if (i < 3) {
            sQLiteDatabase.execSQL("ALTER TABLE Configurations ADD COLUMN id STRING");
        }
        if (i < 4) {
            sQLiteDatabase.execSQL("ALTER TABLE Lines ADD COLUMN ownerOperatorRef STRING");
            sQLiteDatabase.execSQL("UPDATE Lines SET ownerOperatorRef=operatorRef");
        }
        if (i < 5) {
            sQLiteDatabase.execSQL("ALTER TABLE Stops ADD COLUMN beaconStopRef INTEGER");
            sQLiteDatabase.execSQL("UPDATE Stops SET beaconStopRef=ref");
        }
        if (i < 5) {
            sQLiteDatabase.execSQL("ALTER TABLE Stops ADD COLUMN beaconStopRef INTEGER");
            sQLiteDatabase.execSQL("UPDATE Stops SET beaconStopRef=ref");
        }
        if (i < 6) {
            sQLiteDatabase.execSQL("ALTER TABLE Lines ADD COLUMN active INTEGER");
            sQLiteDatabase.execSQL("UPDATE Lines SET active = 1");
        }
    }

    /* renamed from: z */
    public void m58z() {
        getWritableDatabase().execSQL("DELETE FROM Lines WHERE active = 0");
    }

    /* renamed from: b */
    public void m92b(List<DataModelDBOs$TableConfiguration> list) {
        for (DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration : list) {
            m103a(dataModelDBOs$TableConfiguration);
        }
    }

    /* renamed from: c */
    public void m89c(List<DataModelDBOs$TableCountry> list) {
        for (DataModelDBOs$TableCountry dataModelDBOs$TableCountry : list) {
            m102a(dataModelDBOs$TableCountry);
        }
    }

    /* renamed from: e */
    public void m85e(List<DataModelDBOs$TableLanguage> list) {
        for (DataModelDBOs$TableLanguage dataModelDBOs$TableLanguage : list) {
            m100a(dataModelDBOs$TableLanguage);
        }
    }

    /* renamed from: i */
    public void m77i(List<DataModelDBOs$TableOperator> list) {
        for (DataModelDBOs$TableOperator dataModelDBOs$TableOperator : list) {
            m96a(dataModelDBOs$TableOperator);
        }
    }

    /* renamed from: k */
    public void m73k(List<DataModelDBOs$TableZone> list) {
        for (DataModelDBOs$TableZone dataModelDBOs$TableZone : list) {
            m94a(dataModelDBOs$TableZone);
        }
    }

    /* renamed from: d */
    public List<DataModelDBOs$TableCountry> m88d() {
        return m69o().queryForAll();
    }

    /* renamed from: f */
    public List<DataModelDBOs$TableLanguage> m84f() {
        return m65s().queryForAll();
    }

    /* renamed from: g */
    public List<DataModelDBOs$TableLineOrientation> m82g() {
        return m63u().queryForAll();
    }

    /* renamed from: h */
    public List<DataModelDBOs$TableLineVariant> m80h() {
        return m62v().queryForAll();
    }

    /* renamed from: j */
    public List<DataModelDBOs$TableOperator> m76j() {
        return m61w().queryForAll();
    }

    /* renamed from: b */
    public void m91b(DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration) {
        m70n().delete((RuntimeExceptionDao<DataModelDBOs$TableConfiguration, Integer>) dataModelDBOs$TableConfiguration);
    }

    /* renamed from: a */
    public void m104a(DataModelDBOs$TableBeaconInformationType dataModelDBOs$TableBeaconInformationType) {
        m71m().createOrUpdate(dataModelDBOs$TableBeaconInformationType);
    }

    /* renamed from: a */
    public void m105a(List<DataModelDBOs$TableBeaconInformationType> list) {
        for (DataModelDBOs$TableBeaconInformationType dataModelDBOs$TableBeaconInformationType : list) {
            m104a(dataModelDBOs$TableBeaconInformationType);
        }
    }

    /* renamed from: a */
    public void m95a(DataModelDBOs$TableStop dataModelDBOs$TableStop) {
        m60x().createOrUpdate(dataModelDBOs$TableStop);
    }

    /* renamed from: a */
    public void m99a(DataModelDBOs$TableLine dataModelDBOs$TableLine) {
        m64t().createOrUpdate(dataModelDBOs$TableLine);
    }

    /* renamed from: a */
    public void m98a(DataModelDBOs$TableLineOrientation dataModelDBOs$TableLineOrientation) {
        m63u().createOrUpdate(dataModelDBOs$TableLineOrientation);
    }

    /* renamed from: a */
    public void m97a(DataModelDBOs$TableLineVariant dataModelDBOs$TableLineVariant) {
        m62v().createOrUpdate(dataModelDBOs$TableLineVariant);
    }

    /* renamed from: a */
    public void m96a(DataModelDBOs$TableOperator dataModelDBOs$TableOperator) {
        m61w().createOrUpdate(dataModelDBOs$TableOperator);
    }

    /* renamed from: a */
    public void m94a(DataModelDBOs$TableZone dataModelDBOs$TableZone) {
        m59y().createOrUpdate(dataModelDBOs$TableZone);
    }

    /* renamed from: a */
    public void m103a(DataModelDBOs$TableConfiguration dataModelDBOs$TableConfiguration) {
        m70n().createOrUpdate(dataModelDBOs$TableConfiguration);
    }

    /* renamed from: a */
    public void m101a(DataModelDBOs$TableCustomerProfile dataModelDBOs$TableCustomerProfile) {
        m68p().createOrUpdate(dataModelDBOs$TableCustomerProfile);
    }

    /* renamed from: a */
    public void m102a(DataModelDBOs$TableCountry dataModelDBOs$TableCountry) {
        m69o().createOrUpdate(dataModelDBOs$TableCountry);
    }

    /* renamed from: a */
    public void m100a(DataModelDBOs$TableLanguage dataModelDBOs$TableLanguage) {
        m65s().createOrUpdate(dataModelDBOs$TableLanguage);
    }
}
