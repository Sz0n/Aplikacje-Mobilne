package pl.paul.bazadanych;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FilmActivity extends AppCompatActivity {

    public static final String EXTRA_FILMNO = "filmNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        // Pobieramy identyfikator napoju z intencji
        int filmNo = (Integer)getIntent().getExtras().get(EXTRA_FILMNO);

        // Tworzymy kursor
        try {
            SQLiteOpenHelper filmDatabaseHelper = new FilmDatabaseHelper(this);
            SQLiteDatabase db = filmDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query ("FILM",
                    new String[] {"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"},
                    "_id = ?",
                    new String[] {Integer.toString(filmNo)},
                    null, null,null);

            // Przechodzimy do pierwszego rekordu w kursorze
            if (cursor.moveToFirst()) {

                // Pobieramy z kursora szczegółowe informacje o napoju
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3) == 1);

                // Wyświetlamy zdjęcie napoju
                TextView name = (TextView)findViewById(R.id.name);
                name.setText(nameText);

                // Wyświetlamy nazwę napoju
                TextView description = (TextView)findViewById(R.id.description);
                description.setText(descriptionText);

                // Wyświetlamy opis napoju
                ImageView photo = (ImageView)findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                // Zaznaczamy pole wyboru ulubionego napoju
                CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
                favorite.setChecked(isFavorite);
            }
            cursor.close();
            db.close();
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database is unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    // Aktualizujemy bazę po zaznaczeniu pola wyboru
    public void onFavoriteClicked(View view){
        int filmNo = (Integer)getIntent().getExtras().get("filmNo");
        new UpdateFilmTask().execute(filmNo);
        Toast toast = Toast.makeText(FilmActivity.this,"Movie has been added to favorites", Toast.LENGTH_SHORT);
        toast.show();
    }

    // Klasa wewnętrzna służąca do aktualizacji danych napoju
    private class UpdateFilmTask extends AsyncTask<Integer, Void, Boolean> {
        ContentValues filmValues;
        protected void onPreExecute() {
            CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
            filmValues = new ContentValues(); filmValues.put("FAVORITE", favorite.isChecked());
        }
        protected Boolean doInBackground(Integer... films) {
            int filmNo = films[0];
            SQLiteOpenHelper filmDatabaseHelper = new FilmDatabaseHelper(FilmActivity.this);
            try {
                SQLiteDatabase db = filmDatabaseHelper.getWritableDatabase();
                db.update("FILM", filmValues,
                        "_id = ?", new String[] {Integer.toString(filmNo)});
                db.close();
                return true;
            } catch(SQLiteException e) {
                return false;
            }
        }
        protected void onPostExecute(Boolean success) {
            if (!success) {
                Toast toast = Toast.makeText(FilmActivity.this,
                        "Database is unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
