package game.dice.com.dicegameapp.persistence;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;



public class DbHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "dicegame";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "games";
    public static final String COL_PLAYER = "player";
    public static final String COL_ROLLS = "rolls";
    public static final String COL_VICTORIES = "victoies";

    private static final String STRING_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_PLAYER + " TEXT, " + COL_ROLLS + " INTEGER," + COL_VICTORIES + " REAL"+");";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(STRING_CREATE);

        ContentValues cv = new ContentValues(10);
        cv.put(COL_PLAYER, "player");
        cv.put(COL_ROLLS, 20);
        cv.put(COL_VICTORIES, 20);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}