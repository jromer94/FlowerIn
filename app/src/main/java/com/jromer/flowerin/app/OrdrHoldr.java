package com.jromer.flowerin.app;

import android.content.Context;

/**
 * Created by josh on 10/12/14.
 */
public class OrdrHoldr {

    private static OrdrHoldr sOrdrHoldr;
    private Context mAppContext;

    private String mFirstName;
    private String mLastName;
    private String mAddress;
    private String mCity;
    private String mState;
    private String mZip;
    private String mPhone;
    private String mEmail;

    private Menu.MenuItem mItem;

    private String mCardName;
    private String mCardNumber;
    private String mCardCvc;
    private String mCardExpry;
    private String mCardBillAddr;
    private String mCardBillAddr2;
    private String mCardCity;
    private String mCardState;
    private String mCardZip;
    private String mCardPhone;


    public static OrdrHoldr get(Context appContext){

        if(sOrdrHoldr == null){

            sOrdrHoldr = new OrdrHoldr(appContext);

        }

        return sOrdrHoldr;

    }

    public OrdrHoldr(Context c){

        mAppContext = c.getApplicationContext();

    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

    public String getZip() {
        return mZip;
    }

    public void setZip(String zip) {
        mZip = zip;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public Menu.MenuItem getItem() {
        return mItem;
    }

    public void setItem(Menu.MenuItem item) {
        mItem = item;
    }

    public String getCardName() {
        return mCardName;
    }

    public void setCardName(String cardName) {
        mCardName = cardName;
    }

    public String getCardCvc() {
        return mCardCvc;
    }

    public void setCardCvc(String cardCvc) {
        mCardCvc = cardCvc;
    }

    public String getCardNumber() {
        return mCardNumber;
    }

    public void setCardNumber(String cardNumber) {
        mCardNumber = cardNumber;
    }

    public String getCardExpry() {
        return mCardExpry;
    }

    public void setCardExpry(String cardExpry) {
        mCardExpry = cardExpry;
    }

    public String getCardBillAddr() {
        return mCardBillAddr;
    }

    public void setCardBillAddr(String cardBillAddr) {
        mCardBillAddr = cardBillAddr;
    }

    public String getCardBillAddr2() {
        return mCardBillAddr2;
    }

    public void setCardBillAddr2(String cardBillAddr2) {
        mCardBillAddr2 = cardBillAddr2;
    }

    public String getCardCity() {
        return mCardCity;
    }

    public void setCardCity(String cardCity) {
        mCardCity = cardCity;
    }

    public String getCardZip() {
        return mCardZip;
    }

    public void setCardZip(String cardZip) {
        mCardZip = cardZip;
    }

    public String getCardState() {
        return mCardState;
    }

    public void setCardState(String cardState) {
        mCardState = cardState;
    }

    public String getCardPhone() {
        return mCardPhone;
    }

    public void setCardPhone(String cardPhone) {
        mCardPhone = cardPhone;
    }
}
