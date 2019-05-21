package pl.paul.bazadanych;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TimingLogger;
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

        int filmNo = (Integer) getIntent().getExtras().get(EXTRA_FILMNO);
        try {
            SQLiteOpenHelper filmDatabaseHelper = new FilmDatabaseHelper(this);
            SQLiteDatabase db = filmDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("FILM",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"},
                    "_id = ?",
                    new String[]{Integer.toString(filmNo)},
                    null, null, null);
            if (cursor.moveToFirst()) {
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3) == 1);

                TextView name = (TextView) findViewById(R.id.name);
                name.setText(nameText);

                TextView description = (TextView) findViewById(R.id.description);
                description.setText(descriptionText);

                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);

                CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
                favorite.setChecked(isFavorite);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database is unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void onFavoriteClicked(View view) {
        int filmNo = (Integer) getIntent().getExtras().get("filmNo");
        new UpdateFilmTask().execute(filmNo);
        CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
        if (!favorite.isChecked()) {
            Toast toast = Toast.makeText(FilmActivity.this, "Movie has been removed from favorites", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private class UpdateFilmTask extends AsyncTask<Integer, Integer, Boolean> {

        ContentValues filmValues;

        protected void onPreExecute() {
            CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
            filmValues = new ContentValues();
            filmValues.put("FAVORITE", favorite.isChecked());
        }

        protected Boolean doInBackground(Integer... films) {
            int filmNo = films[0];
            SQLiteOpenHelper filmDatabaseHelper = new FilmDatabaseHelper(FilmActivity.this);
            try {
                SQLiteDatabase db = filmDatabaseHelper.getWritableDatabase();
                db.update("FILM", filmValues,
                        "_id = ?", new String[]{Integer.toString(filmNo)});
                db.close();
                publishProgress(1);
                return true;
            } catch (SQLiteException e) {
                return false;
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Toast toast = Toast.makeText(FilmActivity.this, "Movie has been added to favorites", Toast.LENGTH_SHORT);
            toast.show();
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
