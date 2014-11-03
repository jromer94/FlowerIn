package com.jromer.flowerin.app;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

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
