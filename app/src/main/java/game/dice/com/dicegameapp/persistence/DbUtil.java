package game.dice.com.dicegameapp.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.SimpleCursorAdapter;

public class DbUtil {



    private static DbHelper mHelper;
    private static SQLiteDatabase mDb;
      static Cursor mCursor;
    private static SimpleCursorAdapter mAdapter;
    private static ContentValues cv;

        //puedo utilizar getApplicationContext???
    public static SQLiteDatabase getDbConnection(Context context){
        mHelper = new DbHelper(context);
        mDb = mHelper.getWritableDatabase();
        return mDb;
    }



    public static Cursor getCursor(Context context){

        SQLiteDatabase sqLiteDatabase=getDbConnection(context);

        String[] columns = new String[]{"_id", DbHelper.COL_PLAYER, DbHelper.COL_ROLLS, DbHelper.COL_VICTORIES};

        mCursor = sqLiteDatabase
                .query(DbHelper.TABLE_NAME, columns,
                        null, null, null,
                        null, null, null);

        return mCursor;
    }

    public static SimpleCursorAdapter getSimpleCursorAdapter(Context context){

        String[] headers = new String[]{
                DbHelper.COL_PLAYER, DbHelper.COL_ROLLS,DbHelper.COL_VICTORIES};

        mAdapter = new SimpleCursorAdapter(
                context, android.R.layout.two_line_list_item,
                mCursor, headers, new int[]{
                        android.R.id.text1, android.R.id.text2});

        return mAdapter;
    }

    public static ContentValues getContentValues(){
        cv = new ContentValues(10);
        return cv;
    }
}
