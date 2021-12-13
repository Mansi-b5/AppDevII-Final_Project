package ca.qc.johnabbott.finalproject.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import ca.qc.johnabbott.finalproject.sqlite.Column;
import ca.qc.johnabbott.finalproject.sqlite.DatabaseException;
import ca.qc.johnabbott.finalproject.sqlite.Table;

public class LocationTable extends Table<LocationD> {

    public static final String TABLE_NAME = "location";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_HOURS = "hours";
    public static final String COLUMN_PHONENUMBER = "phoneNumber";
    public static final String COLUMN_LATITUDE = "latitude";
    public static final String COLUMN_LONGITUDE = "longitude";

    public LocationTable(SQLiteOpenHelper dbh){
        super(dbh, TABLE_NAME);
        addColumn(new Column(COLUMN_NAME, Column.Type.TEXT));
        addColumn(new Column(COLUMN_ADDRESS, Column.Type.TEXT));
        addColumn(new Column(COLUMN_HOURS, Column.Type.TEXT));
        addColumn(new Column(COLUMN_PHONENUMBER, Column.Type.TEXT));
        addColumn(new Column(COLUMN_LATITUDE, Column.Type.REAL));
        addColumn(new Column(COLUMN_LONGITUDE, Column.Type.REAL));
    }

    @Override
    protected ContentValues toContentValues(LocationD element) throws DatabaseException {
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, element.getName());
        values.put(COLUMN_ADDRESS, element.getAddress());
        values.put(COLUMN_HOURS, element.getHours());
        values.put(COLUMN_PHONENUMBER, element.getPhoneNumber());
        values.put(COLUMN_LATITUDE, element.getLatitude());
        values.put(COLUMN_LONGITUDE, element.getLongitude());

        return values;
    }

    @Override
    protected LocationD fromCursor(Cursor cursor) throws DatabaseException {
        LocationD location = new LocationD()
                .setId(cursor.getInt(0))
                .setName(cursor.getString(1))
                .setAddress(cursor.getString(2))
                .setHours(cursor.getString(3))
                .setPhoneNumber(cursor.getString(4))
                .setLatitude(cursor.getDouble(5))
                .setLongitude(cursor.getDouble(6));
        return location;
    }
}
