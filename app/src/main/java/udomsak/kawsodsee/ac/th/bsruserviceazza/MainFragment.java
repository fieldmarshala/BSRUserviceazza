package udomsak.kawsodsee.ac.th.bsruserviceazza;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

        // Login Controller
        loginController();

        // Workshop
        Page1();
        Page2();
        Page3();
        Page4();
        Page5();

    }   // Main Method

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

                String user = userEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                MyAlert myAlert = new MyAlert(getActivity());

                if (user.isEmpty() || password.isEmpty()) {
                    // Have space
                    myAlert.normalDialog("Have Space","Please fill every blank");
                } else {
                    // No space
                    MyConstant myConstant = new MyConstant();
                    try {
                        GetUserWhereUserThread getUserWhereUserThread = new GetUserWhereUserThread(getActivity());
                        // class object = new class(getActivity)
                        getUserWhereUserThread.execute(user,myConstant.getUrlGetUserWhereUser());

                        String json = getUserWhereUserThread.get();
                        Log.d("5MarchV1","json = " + json);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } // if

            } // onClick
        });
    }

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
