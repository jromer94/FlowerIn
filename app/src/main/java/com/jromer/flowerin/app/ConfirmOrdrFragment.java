package com.jromer.flowerin.app;



import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class ConfirmOrdrFragment extends Fragment {


    public ConfirmOrdrFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/champagne_limousines.ttf");

        View view = inflater.inflate(R.layout.fragment_confirm_ordr, container, false);
        TextView textView =(TextView)view.findViewById(R.id.confirmation);
        textView.setTypeface(type);
        new placeOrdrTask().execute();
        return view;
    }

    private class placeOrdrTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            OrdrHoldr ordrHoldr = OrdrHoldr.get(getActivity());
            try {
                new MenuFetchr().placeOrdr(ordrHoldr.getItem().getId(), "0.00", "ASAP", "ASAP", ordrHoldr.getFirstName(), ordrHoldr.getLastName(), ordrHoldr.getAddress(), ordrHoldr.getCity(), ordrHoldr.getState(), ordrHoldr.getZip(), ordrHoldr.getPhone(), ordrHoldr.getEmail(), ordrHoldr.getCardName(), ordrHoldr.getCardNumber(), ordrHoldr.getCardCvc(), ordrHoldr.getCardExpry() , ordrHoldr.getCardBillAddr(), ordrHoldr.getCardBillAddr2(), ordrHoldr.getCardCity(), ordrHoldr.getCardState() ,ordrHoldr.getCardZip(), ordrHoldr.getCardPhone());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}
