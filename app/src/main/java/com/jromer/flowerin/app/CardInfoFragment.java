package com.jromer.flowerin.app;



import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Use the {@link CardInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class CardInfoFragment extends Fragment {

    TextView mCardNameText;
    TextView mCardNumberText;
    TextView mCvcText;
    TextView mExpiryText;
    TextView mCardAddressText;
    TextView mCardCityText;
    TextView mCardStateText;
    TextView mCardZipText;
    TextView mCardPhoneText;

    EditText mCardNameEdit;
    EditText mCardNumberEdit;
    EditText mCvcEdit;
    EditText mExpiryEdit;
    EditText mCardAddressEdit;
    EditText mCardCityEdit;
    EditText mCardStateEdit;
    EditText mCardZipEdit;
    EditText mCardPhoneEdit;

    Button mButton;


    public CardInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/champagne_limousines.ttf");


        View view = inflater.inflate(R.layout.fragment_card_info, container, false);
        mCardNameText = (TextView)view.findViewById(R.id.card_name_text);
        mCardNameText.setTypeface(type);
        mCardNumberText = (TextView)view.findViewById(R.id.card_number_text);
        mCardNumberText.setTypeface(type);
        mCardAddressText = (TextView)view.findViewById(R.id.card_address_text);
        mCardAddressText.setTypeface(type);
        mCvcText = (TextView)view.findViewById(R.id.cvc_text);
        mCvcText.setTypeface(type);
        mExpiryText = (TextView)view.findViewById(R.id.expiry_text);
        mExpiryText.setTypeface(type);
        mCardCityText = (TextView)view.findViewById(R.id.card_city_text);
        mCardCityText.setTypeface(type);
        mCardStateText = (TextView)view.findViewById(R.id.card_state_text);
        mCardStateText.setTypeface(type);
        mCardZipText = (TextView)view.findViewById(R.id.card_zip_text);
        mCardZipText.setTypeface(type);
        mCardPhoneText = (TextView)view.findViewById(R.id.card_phone_text);
        mCardPhoneText.setTypeface(type);

        mCardNameEdit = (EditText)view.findViewById(R.id.card_name_edit);
        mCardNameEdit.setTypeface(type);
        mCardNumberEdit = (EditText)view.findViewById(R.id.card_number_edit);
        mCardNumberEdit.setTypeface(type);
        mCardAddressEdit = (EditText)view.findViewById(R.id.card_address_edit);
        mCardAddressEdit.setTypeface(type);
        mCvcEdit = (EditText)view.findViewById(R.id.cvc_edit);
        mCvcEdit.setTypeface(type);
        mExpiryEdit = (EditText)view.findViewById(R.id.expiry_edit);
        mExpiryEdit.setTypeface(type);
        mCardCityEdit = (EditText)view.findViewById(R.id.card_city_edit);
        mCardCityEdit.setTypeface(type);
        mCardStateEdit = (EditText)view.findViewById(R.id.card_state_edit);
        mCardStateEdit.setTypeface(type);
        mCardZipEdit = (EditText)view.findViewById(R.id.card_zip_edit);
        mCardZipEdit.setTypeface(type);
        mCardPhoneEdit = (EditText)view.findViewById(R.id.card_phone_edit);
        mCardPhoneEdit.setTypeface(type);

        mButton =(Button)view.findViewById(R.id.Finish_button);
        mButton.setTypeface(type);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrdrHoldr ordrHoldr = OrdrHoldr.get(getActivity());
                ordrHoldr.setCardName(mCardNameEdit.getText().toString());
                ordrHoldr.setCardNumber(mCardNumberEdit.getText().toString());
                ordrHoldr.setCardBillAddr(mCardAddressEdit.getText().toString());
                ordrHoldr.setCardCvc(mCvcEdit.getText().toString());
                ordrHoldr.setCardExpry(mExpiryEdit.getText().toString());
                ordrHoldr.setCardCity(mCardCityEdit.getText().toString());
                ordrHoldr.setCardState(mCardStateEdit.getText().toString());
                ordrHoldr.setCardZip(mCardZipEdit.getText().toString());
                ordrHoldr.setCardPhone(mCardPhoneEdit.getText().toString());

                if(mCardNameEdit.getText().toString().equals("")){
                    Toast.makeText(getActivity(),"Invalid input", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(getActivity(), ConfirmOrdrActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


}
