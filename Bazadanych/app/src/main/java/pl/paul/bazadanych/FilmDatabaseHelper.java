package pl.paul.bazadanych;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class FilmDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "films"; // Nazwa bazy danych
    private static final int DB_VERSION = 1; // Numer wersji bazy danych

    FilmDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE FILM (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "IMAGE_RESOURCE_ID INTEGER);");
            insertFilm(db, "Deadpool", "Deadpool is a 2016 American superhero film based on the Marvel Comics character of the same name.", R.drawable.deadpool);
            insertFilm(db, "Deadpool2", "Deadpool 2 is a 2018 American superhero film based on the Marvel Comics character Deadpool. It is the eleventh installment in the X-Men film series, and is the sequel to 2016's Deadpool.", R.drawable.deadpool_2);
        }
        insertFilm(db, "Once upon a Deadpool", "The rebuilt Deadpool 2 movie.", R.drawable.once_deadpool);
        if (oldVersion < 2) {
            db.execSQL("ALTER TABLE FILM ADD COLUMN FAVORITE NUMERIC;");
        }
    }

    private static void insertFilm(SQLiteDatabase db, String name,
                                   String description, int resourceId) {
        ContentValues filmValues = new ContentValues();
        filmValues.put("NAME", name);
        filmValues.put("DESCRIPTION", description);
        filmValues.put("IMAGE_RESOURCE_ID", resourceId);
        db.insert("FILM", null, filmValues);
    }
}
