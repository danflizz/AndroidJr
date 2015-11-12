package fragment.dany.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dany on 12/10/2015.
 */
public class AccionesDB extends SQLiteOpenHelper {
    public AccionesDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE persona (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,phone TEXT,twitter TEXT,email TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
