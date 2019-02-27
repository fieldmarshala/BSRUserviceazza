package udomsak.kawsodsee.ac.th.bsruserviceazza;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Page1Fragment extends Fragment {


    public Page1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Create Page 1 Toolbar
        page1Toolbar();
    }
    public void page1Toolbar(){
        Toolbar page1toolbar = getView().findViewById(R.id.toolbarPage1);
        ((MainActivity) getActivity()).setSupportActionBar(page1toolbar);

        //Setup Title
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Page 1");
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("Please Go Back to Home Page");

        // Setup Navigation Icon
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        page1toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page1, container, false);
    }

}
