package udomsak.kawsodsee.ac.th.bsruserviceazza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add Fragment to Activity
        getSupportFragmentManager().beginTransaction().add(R.id.layoutMainFragment,new MainFragment()).commit();




    }   //Main Method
}   //Main Class
