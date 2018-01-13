package weeraphat.sbc.ac.th.sbc_moneychange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import weeraphat.sbc.ac.th.sbc_moneychange.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add fragment to activity
        if (savedInstanceState == null)
        {
            getSupportFragmentManager().
                    beginTransaction().add(R.id.contentmainfragment, new MainFragment()).commit();
        }

    }//Main Mettod

}//Main Class
