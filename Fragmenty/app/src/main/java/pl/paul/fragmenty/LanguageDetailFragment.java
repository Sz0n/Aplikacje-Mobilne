package pl.paul.fragmenty;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 */
public class LanguageDetailFragment extends Fragment {

    private long languageId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            languageId = savedInstanceState.getLong("languageId");
        }
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        StopwatchFragment stopwatchFragment = new StopwatchFragment();
        ft.replace(R.id.stopwatch_container, stopwatchFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        return inflater.inflate(R.layout.fragment_language_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            ImageView title = (ImageView) view.findViewById(R.id.imageTitle);
            Language language = Language.languages[(int) languageId];
            title.setImageResource(language.getImage());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(language.getDescription());
        }
    }

    public void setLanguage(long id) {
        this.languageId = id;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("languageId", languageId);
    }
}
