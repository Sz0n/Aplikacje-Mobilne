package pl.paul.fragmenty;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LanguageListFragment.LanguageListListener{
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate: Started");
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
        LanguageDetailFragment details = new LanguageDetailFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        details.setLanguage(id);
        ft.replace(R.id.fragment_container, details);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        Toast.makeText(this,"HOW FAST CAN U READ THIS TEXT???", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_LANGUAGE_ID, (int)id);
            startActivity(intent);
            Toast.makeText(this,"HOW FAST CAN U READ THIS TEXT???", Toast.LENGTH_LONG).show();
        }
    }

}
