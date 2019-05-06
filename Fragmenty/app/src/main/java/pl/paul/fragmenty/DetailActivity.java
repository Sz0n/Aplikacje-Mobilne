package pl.paul.fragmenty;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailActivity extends AppCompatActivity implements LanguageListFragment.LanguageListListener{
    public static final String EXTRA_LANGUAGE_ID = "id";
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.d(TAG,"onCreate: Started");
        LanguageDetailFragment languageDetailFragment = (LanguageDetailFragment)getFragmentManager().findFragmentById(R.id.detail_frag);
        int languageId = (int) getIntent().getExtras().get(EXTRA_LANGUAGE_ID);
        languageDetailFragment.setLanguage(languageId);
    }

    @Override
    public void itemClicked(long id) {

    }
}
