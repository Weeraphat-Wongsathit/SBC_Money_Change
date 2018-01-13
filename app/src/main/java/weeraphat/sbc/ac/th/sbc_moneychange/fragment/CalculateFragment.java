package weeraphat.sbc.ac.th.sbc_moneychange.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import weeraphat.sbc.ac.th.sbc_moneychange.MainActivity;
import weeraphat.sbc.ac.th.sbc_moneychange.R;

/**
 * Created by LAB3201_00 on 13/1/2561.
 */

public class CalculateFragment extends Fragment {

    private double aDouble;

    public static CalculateFragment calculateInstance(double factorDoble) {
        CalculateFragment calculateFragment = new CalculateFragment();
        Bundle bundle = new Bundle();
        bundle.putDouble("Factor", factorDoble);
        calculateFragment.setArguments(bundle);

        return calculateFragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Toolbar contronler
        toolbarContronler();

        //Get Value From Argument
        getValueFromArgument();

//        Calculate Controler
        calculateControler();


    }//Main Metthod

    private void calculateControler() {
        Button button = getView().findViewById(R.id.btncalculat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Get Value From EditText
                EditText editText = getView().findViewById(R.id.edtMoney);
                String moneyString = editText.getText().toString().trim();

//                Check Space
                if (moneyString.isEmpty()) {
//                    Have Space
                    myAletr("Have Space", "Please Fill Money in Blank");


                } else {
//                    No Space
                    double moneyDouble = Double.parseDouble(moneyString);
                    double answerDouble = moneyDouble * aDouble;
                    String answerString = "Thai Baht = " + Double.toString(answerDouble) + "THB";
                    myAletr("Your " + moneyString + "USD", answerString);
                    editText.setText("");

                }//if

            }//onClick
        });

    }

    private void myAletr(String titleString, String messageString) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle(titleString);
        builder.setMessage(messageString);
        builder.setPositiveButton("You OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });
        builder.show();
    }   //End MyAletr

    private void getValueFromArgument() {
        aDouble = getArguments().getDouble("Factor");
        Log.d("13Jan", "Factor ==>" + aDouble);
    }

    private void toolbarContronler() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarcalculate);
        ((MainActivity) getActivity()).setSupportActionBar((toolbar));

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.th_exchange));
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.th_sub_exchange));

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frafment_calculate, container, false);
        return view;
    }
}//Main Class
