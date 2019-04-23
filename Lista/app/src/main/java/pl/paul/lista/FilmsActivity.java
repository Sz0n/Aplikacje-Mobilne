package pl.paul.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class FilmsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.list_of_films);
        listView.setOnItemClickListener(itemClickListener);
    }

    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> listView,
                                        View itemView,
                                        int position,
                                        long id) {
                    if (position == 0) {
                        Intent intent = new Intent(FilmsActivity.this, Deadpool.class);
                        startActivity(intent);
                    }
                }
            };
}
