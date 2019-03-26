package pl.paul.aktywnosci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        textView = (TextView) findViewById(R.id.textViewExtra);
        Intent intent = getIntent();
        String user_name = intent.getStringExtra("AUTHOR");
        textView.setText(user_name);
    }

    public void onShowMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onShowBio(View view) {
        Intent intent = new Intent(this, BioActivity.class);
        startActivity(intent);
    }
}
