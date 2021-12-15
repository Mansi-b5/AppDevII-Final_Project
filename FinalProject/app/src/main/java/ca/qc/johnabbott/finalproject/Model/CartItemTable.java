package ca.qc.johnabbott.finalproject.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import ca.qc.johnabbott.finalproject.sqlite.Column;
import ca.qc.johnabbott.finalproject.sqlite.DatabaseException;
import ca.qc.johnabbott.finalproject.sqlite.Table;

public class CartItemTable extends Table<CartItem> {
    public static final String TABLE_NAME = "CartItems";
    public static final String COLUMN_CART_ID = "CartId";
    public static final String COLUMN_MENU_ITEM_ID = "MenuItemId";
    public static final String COLUMN_QUANTITY = "Quantity";
    public static final String COLUMN_UNIT_PRICE = "UnitPrice";

    public CartItemTable(SQLiteOpenHelper dbh) {
        super(dbh, TABLE_NAME);

        addColumn(new Column(COLUMN_CART_ID, Column.Type.INTEGER));
        addColumn(new Column(COLUMN_MENU_ITEM_ID, Column.Type.INTEGER));
        addColumn(new Column(COLUMN_QUANTITY, Column.Type.INTEGER));
        addColumn(new Column(COLUMN_UNIT_PRICE, Column.Type.REAL));
    }

    @Override
    public boolean hasInitialData() {
        return false;
    }

    @Override
    protected ContentValues toContentValues(CartItem cartItem) throws DatabaseException {
        ContentValues values = new ContentValues();

        values.put(COLUMN_CART_ID, cartItem.getCartId());
        values.put(COLUMN_MENU_ITEM_ID, cartItem.getMenuItem().getId());
        values.put(COLUMN_QUANTITY, cartItem.getQuantity());
        values.put(COLUMN_UNIT_PRICE, cartItem.getUnitPrice());

        return values;
    }

    @Override
    protected CartItem fromCursor(Cursor cursor) throws DatabaseException {
        CartItem cartItem = new CartItem()
                .setCartId(cursor.getLong(1))
                .setMenuItemId(cursor.getLong(2))
                .setQuantity(cursor.getInt(3))
                .setUnitPrice(cursor.getDouble(4));

        return cartItem;
    }
}
