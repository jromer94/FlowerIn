package com.jromer.flowerin.app;

import android.net.Uri;
import android.util.Log;

import com.github.kevinsawicki.http.HttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by josh on 9/25/14.
 */
public class MenuFetchr {

    private static final String TAG = "MenuFetchr";

    private static final String ENDPOINT = "https://r-test.ordr.in";
    private static final String API_KEY = "v-4qPjiF9t-YhhiWwREEdQHK6UKp95pz63P4RyRsbXI";
    private static final String RESTAURANT_ID = "24605";
    private static final String GET_MENU = "rd";
    private static final String RID = "24067";
    private static final String ORDER = "o";
    private static final String TRAY = "tray";
    private static final String TIP = "tip";
    private static final String DELIVERY_DATE = "delivery_date";
    private static final String DELIVERY_TIME = "delivery_time";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String ADDRESS = "addr";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String ZIP = "zip";
    private static final String PHONE = "phone";
    private static final String EMAIL = "email";
    private static final String CARD_NAME = "card_name";
    private static final String CARD_NUMBER = "card_number";
    private static final String CARD_CVC = "card_cvc";
    private static final String CARD_EXPIRE = "card_expiry";
    private static final String CARD_ADDR = "card_bill_addr";
    private static final String CARD_ADDR2 = "card_bill_addr2";
    private static final String CARD_CITY = "card_bill_city";
    private static final String CARD_STATE = "card_bill_state";
    private static final String CARD_ZIP = "card_bill_zip";
    private static final String CARD_PHONE = "card_bill_phone";


    byte[] getUrlBytes(String urlSpec) throws IOException {

        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestProperty("X-NAAMA-CLIENT-AUTHENTICATION",  "id=\"v-4qPjiF9t-YhhiWwREEdQHK6UKp95pz63P4RyRsbXI\", version=\"1\"");
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();

            if(connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                return null;
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while((bytesRead = in.read(buffer)) > 0){

                out.write(buffer, 0, bytesRead);

            }

            out.close();
            return out.toByteArray();

        } finally {

            connection.disconnect();

        }




    }

    public Menu fetchMenu() throws JSONException {

        String url = Uri.parse(ENDPOINT).buildUpon().appendPath(GET_MENU).appendPath(RID)
                .build().toString();

        Log.i(TAG, url);

        String jsonString = null;

        try {
           jsonString =  getUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject menuJson = (JSONObject) new JSONTokener(jsonString).nextValue();
        Menu menu = new Menu();
        menu.setName(menuJson.getString("name"));

        Log.i(TAG, menu.getName());

        ArrayList<Menu.MenuCategory> categories = new ArrayList<Menu.MenuCategory>();

        JSONArray catJson = menuJson.getJSONArray("menu");

        for(int i = 0; i < catJson.length(); i++){

            categories.add(parseCategory(catJson.getJSONObject(i)));

        }

        menu.setCategories(categories);

        return menu;

    }

    public Boolean placeOrdr(String tray, String tip, String deliveryDate, String deliveryTime, String firstName, String lastName, String addr, String city, String state, String zip, String phone, String email, String cardName, String cardNumber, String cardCvc, String cardExpire, String cardAddr, String cardAddr2, String cardCity, String cardState, String cardZip, String cardPhone) throws IOException {
        String urlString = Uri.parse(ENDPOINT).buildUpon().appendPath(ORDER).appendPath(RID).build().toString();
        Map<String, String> data  = new HashMap<String, String>();
        data.put(TRAY, tray);
        data.put(TIP, tip);
        data.put(DELIVERY_DATE, deliveryDate);
        data.put(DELIVERY_TIME, deliveryTime);
        data.put(FIRST_NAME, firstName);
        data.put(LAST_NAME, lastName);
        data.put(ADDRESS, addr);
        data.put(CITY, city);
        data.put(STATE, state);
        data.put(ZIP, zip);
        data.put(PHONE, phone);
        data.put(EMAIL, email);
        data.put(CARD_NAME, cardName);
        data.put(CARD_NUMBER, cardNumber);
        data.put(CARD_CVC, cardCvc);
        data.put(CARD_EXPIRE, cardExpire);
        data.put(CARD_ADDR, cardAddr);
        data.put(CARD_CITY, cardCity);
        data.put(CARD_STATE, cardState);
        data.put(CARD_ZIP, cardZip);
        data.put(CARD_PHONE, cardPhone);

        int response = HttpRequest.post(urlString).header("X-NAAMA-CLIENT-AUTHENTICATION",  "id=\"v-4qPjiF9t-YhhiWwREEdQHK6UKp95pz63P4RyRsbXI\", version=\"1\"")
                .form(data)
                .code();
        Log.i("response: ", "" + response);

        return true;

    }

    private Menu.MenuCategory parseCategory(JSONObject category) throws JSONException {

        Menu.MenuCategory menuCategory = new Menu.MenuCategory();
        menuCategory.setCatName(category.getString("name"));

        JSONArray  children = category.getJSONArray("children");
        ArrayList<Menu.MenuItem> items = new ArrayList<Menu.MenuItem>();

        for(int i = 0; i < children.length(); i++){

            items.add(parseMenuItem(children.getJSONObject(i)));

        }

        menuCategory.setMenuItems(items);

        //TODO parse the rest needs loop for category items

        return menuCategory;
    }

    private Menu.MenuItem parseMenuItem(JSONObject item) throws JSONException {

        Menu.MenuItem menuItem = new Menu.MenuItem();
        menuItem.setId(item.getString("id"));
        //menuItem.setOrderable(item.getBoolean("is_orderable"));
        menuItem.setItemName(item.getString("name"));
        menuItem.setPrice(item.getDouble("price"));
        menuItem.setDescription(item.getString("descrip"));

        ArrayList<Menu.OptionOverview> overviews = new ArrayList<Menu.OptionOverview>();
        if(item.has("children")){



            JSONArray  children = item.getJSONArray("children");

            for(int i = 0; i < children.length(); i++){

                overviews.add(parseOptionOverview(children.getJSONObject(i)));

            }

        }

        menuItem.setOptionOverviews(overviews);

        return menuItem;
    }

    private Menu.OptionOverview parseOptionOverview(JSONObject overview) throws JSONException {

        Menu.OptionOverview optionOverview = new Menu.OptionOverview();
        optionOverview.setOptionName(overview.getString("name"));
        optionOverview.setMinOptions(overview.getInt("min_child_select"));
        optionOverview.setMaxOptions(overview.getInt("max_child_select"));

        ArrayList<Menu.Option> options = new ArrayList<Menu.Option>();
        JSONArray  children = overview.getJSONArray("children");

        for(int i = 0; i < children.length(); i ++){

            options.add(parseOption(children.getJSONObject(i)));

        }

        optionOverview.setOptions(options);

        return optionOverview;
    }

    private Menu.Option parseOption(JSONObject option) throws JSONException {
        Menu.Option menuOption = new Menu.Option();
        menuOption.setId(option.getString("id"));
        menuOption.setName(option.getString("name"));
        //menuOption.setOrderable(option.getBoolean("is_orderable"));
        menuOption.setPrice(option.getDouble("price"));

        return menuOption;
    }

    public String getUrl(String urlSpec) throws IOException {

        return new String(getUrlBytes(urlSpec));

    }



}
