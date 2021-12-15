package ca.qc.johnabbott.finalproject.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.qc.johnabbott.finalproject.sqlite.Column;
import ca.qc.johnabbott.finalproject.sqlite.DatabaseException;
import ca.qc.johnabbott.finalproject.sqlite.Table;

public class OrderTable extends Table<Order> {
    public static final String TABLE_NAME = "Orders";
    public static final String COLUMN_TIMESTAMP = "Timestamp";
    public static final String COLUMN_STATUS = "Status";
    public static final String COLUMN_LOCATION = "Location";

    public OrderTable(SQLiteOpenHelper dbh) {
        super(dbh, TABLE_NAME);

        addColumn(new Column(COLUMN_TIMESTAMP, Column.Type.TEXT));
        addColumn(new Column(COLUMN_STATUS, Column.Type.INTEGER));
    }

    @Override
    public boolean hasInitialData() {
        return false;
    }

    @Override
    protected ContentValues toContentValues(Order order) throws DatabaseException {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss.SSSZ");

        ContentValues values = new ContentValues();
        values.put(COLUMN_TIMESTAMP, dateFormatter.format(order.getOrderDate()));
        values.put(COLUMN_STATUS, order.getStatus().ordinal());
        values.put(COLUMN_LOCATION, order.getLocation().getName());

        return values;
    }

    @Override
    protected Order fromCursor(Cursor cursor) throws DatabaseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd 'T' HH:mm:ss.SSSZ");
        Order order = new Order().setId(cursor.getLong(0));
        try {
            order.setOrderDate(dateFormatter.parse(cursor.getString(1)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        order.setStatus(OrderStatus.values()[cursor.getInt(2)]);
        order.setLocationName(cursor.getString(3));

        return order;
    }
}
