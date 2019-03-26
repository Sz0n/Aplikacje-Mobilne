package pl.paul.aktywnosci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShowBio(View view){
        Intent intent = new Intent(this, BioActivity.class);
        startActivity(intent);
    }

    public void onShowStats(View view){
        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra("AUTHOR", "Kamil Paul");
        startActivity(intent);
    }
}
