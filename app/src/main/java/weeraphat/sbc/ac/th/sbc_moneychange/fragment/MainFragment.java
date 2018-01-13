package weeraphat.sbc.ac.th.sbc_moneychange.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import weeraphat.sbc.ac.th.sbc_moneychange.R;

/**
 * Created by LAB3201_00 on 12/1/2561.
 */

public class MainFragment extends Fragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Calculate Controller
        Button button = getView().findViewById(R.id.btncalculat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Replace Fragment
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentmainfragment, new CalculateFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }//Main Metthod

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}//End Main class
