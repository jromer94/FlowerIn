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


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class UserInfoFragment extends Fragment {


    TextView mFirstText;
    TextView mLastText;
    TextView mAddressText;
    TextView mCityText;
    TextView mStateText;
    TextView mZipText;
    TextView mPhoneText;
    TextView mEmailText;

    EditText mFirstEdit;
    EditText mLastEdit;
    EditText mAddressEdit;
    EditText mCityEdit;
    EditText mStateEdit;
    EditText mZipEdit;
    EditText mPhoneEdit;
    EditText mEmailEdit;

    Button mButton;

    public UserInfoFragment() {
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

        View view = inflater.inflate(R.layout.fragment_user_info, container, false);

        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/champagne_limousines.ttf");

        mFirstText = (TextView)view.findViewById(R.id.first_name_text);
        mFirstText.setTypeface(type);
        mLastText = (TextView)view.findViewById(R.id.last_name_text);
        mLastText.setTypeface(type);
        mAddressText = (TextView)view.findViewById(R.id.address_text);
        mAddressText.setTypeface(type);
        mCityText = (TextView)view.findViewById(R.id.city_text);
        mCityText.setTypeface(type);
        mStateText = (TextView)view.findViewById(R.id.state_text);
        mStateText.setTypeface(type);
        mZipText = (TextView)view.findViewById(R.id.zip_text);
        mZipText.setTypeface(type);
        mPhoneText = (TextView)view.findViewById(R.id.phone_text);
        mPhoneText.setTypeface(type);
        mEmailText = (TextView)view.findViewById(R.id.email_text);
        mEmailText.setTypeface(type);

        mFirstEdit = (EditText)view.findViewById(R.id.first_name_edit);
        mFirstEdit.setTypeface(type);
        mLastEdit = (EditText)view.findViewById(R.id.last_name_edit);
        mLastEdit.setTypeface(type);
        mAddressEdit = (EditText)view.findViewById(R.id.address_edit);
        mAddressEdit.setTypeface(type);
        mCityEdit = (EditText)view.findViewById(R.id.city_edit);
        mCityEdit.setTypeface(type);
        mStateEdit = (EditText)view.findViewById(R.id.state_edit);
        mStateEdit.setTypeface(type);
        mZipEdit = (EditText)view.findViewById(R.id.zip_edit);
        mZipEdit.setTypeface(type);
        mPhoneEdit = (EditText)view.findViewById(R.id.phone_edit);
        mPhoneEdit.setTypeface(type);
        mEmailEdit = (EditText)view.findViewById(R.id.email_edit);
        mEmailEdit.setTypeface(type);

        mButton = (Button)view.findViewById(R.id.continue_button);
        mButton.setTypeface(type);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrdrHoldr  ordrHoldr = OrdrHoldr.get(getActivity());
                ordrHoldr.setFirstName(mFirstEdit.getText().toString());
                ordrHoldr.setLastName(mLastEdit.getText().toString());
                ordrHoldr.setAddress(mAddressEdit.getText().toString());
                ordrHoldr.setCity(mCityEdit.getText().toString());
                ordrHoldr.setState(mStateEdit.getText().toString());
                ordrHoldr.setZip(mZipEdit.getText().toString());
                ordrHoldr.setPhone(mPhoneEdit.getText().toString());
                ordrHoldr.setEmail(mEmailEdit.getText().toString());

                Intent intent = new Intent(getActivity(), FlowerMenuActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }


}
