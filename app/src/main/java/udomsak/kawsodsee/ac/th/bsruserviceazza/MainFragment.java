package udomsak.kawsodsee.ac.th.bsruserviceazza;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Register Controller
        registerController();

        // Workshop
        Page1();
        Page2();
        Page3();
        Page4();
        Page5();

    }   //Main Method

    private void registerController() {
        TextView textView = getView().findViewById(R.id.txtRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Replace Fragment
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction().replace(R.id.layoutMainFragment, new RegisterFragment())
                        .addToBackStack(null).commit();

            }
        });
    }
    // Workshop
    private  void  Page1(){
        TextView page1 = getView().findViewById(R.id.txtPage1);
        page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction().replace(R.id.layoutMainFragment, new Page1Fragment())
                        .addToBackStack(null).commit();
            }
        });
    }
    private  void  Page2(){
        TextView page2 = getView().findViewById(R.id.txtPage2);
        page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction().replace(R.id.layoutMainFragment, new Page2Fragment())
                        .addToBackStack(null).commit();
            }
        });
    }
    private  void  Page3(){
        TextView page3 = getView().findViewById(R.id.txtPage3);
        page3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction().replace(R.id.layoutMainFragment, new Page3Fragment())
                        .addToBackStack(null).commit();
            }
        });
    }
    private  void  Page4(){
        TextView page4 = getView().findViewById(R.id.txtPage4);
        page4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction().replace(R.id.layoutMainFragment, new Page4Fragment())
                        .addToBackStack(null).commit();
            }
        });
    }
    private  void  Page5(){
        TextView page5 = getView().findViewById(R.id.txtPage5);
        page5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction().replace(R.id.layoutMainFragment, new Page5Fragment())
                        .addToBackStack(null).commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

}
