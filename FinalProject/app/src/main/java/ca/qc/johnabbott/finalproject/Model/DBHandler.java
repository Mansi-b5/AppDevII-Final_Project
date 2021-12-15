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
    private Table<Order> orderTable;
    private Table<CartItem> cartItemTable;

    public DBHandler(@Nullable Context context)
    {
        super(context,DATABASE_FILE_NAME,null,DATABASE_VERSION);
        menuItemTable = new MenuTable(this);
        orderTable = new OrderTable(this);
        cartItemTable = new CartItemTable(this);

    }
    public Table<MenuItem> getMenuItemTable()
    {
        return menuItemTable;
    }

    public Table<Order> getOrderTable() { return orderTable; }

    public Table<CartItem> getCartItemTable() { return cartItemTable; }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        menuItemTable.createTable(sqLiteDatabase);
        orderTable.createTable(sqLiteDatabase);
        cartItemTable.createTable(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
