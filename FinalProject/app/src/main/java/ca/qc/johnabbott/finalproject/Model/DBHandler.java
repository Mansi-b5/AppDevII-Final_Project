package ca.qc.johnabbott.finalproject.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;

import androidx.annotation.Nullable;

import ca.qc.johnabbott.finalproject.sqlite.Table;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_FILE_NAME = "database.db";
    public static final int DATABASE_VERSION = 1;

    private Table<MenuItem> menuItemTable;

    public DBHandler(@Nullable Context context)
    {
        super(context,DATABASE_FILE_NAME,null,DATABASE_VERSION);
        menuItemTable = new MenuTable(this);

    }
    public Table<MenuItem> getMenuItemTable()
    {
        return menuItemTable;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        menuItemTable.createTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
