package weeraphat.sbc.ac.th.sbc_moneychange.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import weeraphat.sbc.ac.th.sbc_moneychange.R;

/**
 * Created by LAB3201_00 on 13/1/2561.
 */

public class CalculateFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frafment_calculate, container, false);
        return view;
    }
}//Main Class
