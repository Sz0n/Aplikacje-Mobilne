package pl.paul.lista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BooksActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.list_of_books);
        listView.setOnItemClickListener(itemClickListener);

        ArrayAdapter<Books> listAdapter = new ArrayAdapter<Books>(
                this,
                android.R.layout.simple_list_item_1,
                Books.books);
        listView.setAdapter(listAdapter);
    }

    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener(){
                public void onItemClick(AdapterView<?> listView,
                                        View itemView,
                                        int position,
                                        long id) {
                    if (position == 0) {
                        Intent intent = new Intent(BooksActivity.this, PaintedMan.class);
                        startActivity(intent);
                    }
                }
            };
}
