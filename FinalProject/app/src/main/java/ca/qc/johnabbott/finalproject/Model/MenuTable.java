package ca.qc.johnabbott.finalproject.Model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.qc.johnabbott.finalproject.sqlite.Column;
import ca.qc.johnabbott.finalproject.sqlite.DatabaseException;
import ca.qc.johnabbott.finalproject.sqlite.Table;


public class MenuTable extends Table<MenuItem> {
    public static final String TABLE_NAME = "Menu";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_SIZE = "size";
    public static final String COLUMN_IMAGE_ID = "imageId";

    public  MenuTable(SQLiteOpenHelper dbh)
    {
        super(dbh,TABLE_NAME);

        addColumn(new Column(COLUMN_CATEGORY,Column.Type.TEXT));
        addColumn(new Column(COLUMN_TITLE, Column.Type.TEXT));
        addColumn(new Column(COLUMN_DESCRIPTION, Column.Type.TEXT));
        addColumn(new Column(COLUMN_PRICE, Column.Type.REAL));
        addColumn(new Column(COLUMN_SIZE, Column.Type.INTEGER));
        addColumn(new Column(COLUMN_IMAGE_ID, Column.Type.INTEGER));
    }

    @Override
    public boolean hasInitialData() {
        return true;
    }

    @Override
    public void initialize(SQLiteDatabase database) {
       HashMap<String,List<MenuItem>> menuItem = MenuData.getData();

       for(Map.Entry<String,List<MenuItem>> entry : menuItem.entrySet())
       {
           String key = entry.getKey();
           List<MenuItem> value = entry.getValue();
           try {
               for(MenuItem values : value)
               {
                   database.insert(TABLE_NAME,null, toContentValues(values));

               }



           }catch (DatabaseException e)
           {
               e.printStackTrace();
           }
       }
    }

    @Override
    protected ContentValues toContentValues(MenuItem element) throws DatabaseException {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CATEGORY, element.getCategory());
        values.put(COLUMN_TITLE, element.getTitle());
        values.put(COLUMN_DESCRIPTION, element.getDescription());
        values.put(COLUMN_PRICE, element.getPrice());
        if(element.getSize() !=null )
        {
            values.put(COLUMN_SIZE, element.getSize().ordinal());

        }
        values.put(COLUMN_IMAGE_ID, element.getImageResourceId());
        return values;

    }

    @Override
    protected MenuItem fromCursor(Cursor cursor) throws DatabaseException {
       MenuItem menuItem = new MenuItem()
               .setId(cursor.getLong(0))
               .setCategory(cursor.getString(1))
               .setTitle(cursor.getString(2))
               .setDescription(cursor.getString(3))
               .setPrice(cursor.getDouble(4))
               .setSize(Size.values()[cursor.getInt(5)])
               .setImageResourceId(cursor.getInt(6));

       return menuItem;
    }

}
