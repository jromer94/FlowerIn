package com.jromer.flowerin.app;

import java.util.ArrayList;

/**
 * Created by josh on 9/25/14.
 */
public class Menu {

    String mName;
    ArrayList<MenuCategory> mCategories;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public ArrayList<MenuCategory> getCategories() {
        return mCategories;
    }

    public void setCategories(ArrayList<MenuCategory> categories) {
        mCategories = categories;
    }

    public static class MenuCategory{


        String mCatName;
        ArrayList<MenuItem> mMenuItems;
        // GNU = GNU is Not UNIX


        public String getCatName() {
            return mCatName;
        }

        public void setCatName(String catName) {
            mCatName = catName;
        }

        public ArrayList<MenuItem> getMenuItems() {
            return mMenuItems;
        }

        public void setMenuItems(ArrayList<MenuItem> menuItems) {
            mMenuItems = menuItems;
        }
    }

    public static class MenuItem{

        String mItemName;
        double mPrice;
        boolean mIsOrderable;
        String mId;
        String mDescription;
        ArrayList<OptionOverview> mOptionOverviews;

        public String getItemName() {
            return mItemName;
        }

        public void setItemName(String itemName) {
            mItemName = itemName;
        }

        public double getPrice() {
            return mPrice;
        }

        public void setPrice(double price) {
            mPrice = price;
        }

        public boolean isOrderable() {
            return mIsOrderable;
        }

        public void setOrderable(boolean isOrderable) {
            mIsOrderable = isOrderable;
        }

        public String getId() {
            return mId;
        }

        public void setId(String id) {
            mId = id;
        }

        public ArrayList<OptionOverview> getOptionOverviews() {
            return mOptionOverviews;
        }

        public void setOptionOverviews(ArrayList<OptionOverview> optionOverviews) {
            mOptionOverviews = optionOverviews;
        }

        public String getDescription() {
            return mDescription;
        }

        public void setDescription(String description) {
            mDescription = description;
        }
    }

    public static class OptionOverview{

        String mOptionName;
        int mMinOptions;
        int mMaxOptions;
        ArrayList<Option> mOptions;

        public String getOptionName() {
            return mOptionName;
        }

        public void setOptionName(String optionName) {
            mOptionName = optionName;
        }

        public int getMinOptions() {
            return mMinOptions;
        }

        public void setMinOptions(int minOptions) {
            mMinOptions = minOptions;
        }

        public ArrayList<Option> getOptions() {
            return mOptions;
        }

        public void setOptions(ArrayList<Option> options) {
            mOptions = options;
        }

        public int getMaxOptions() {
            return mMaxOptions;
        }

        public void setMaxOptions(int maxOptions) {
            mMaxOptions = maxOptions;
        }
    }

    public static class Option{
        String mName;
        String mId;
        boolean mIsOrderable;
        Double mPrice;

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public String getId() {
            return mId;
        }

        public void setId(String id) {
            mId = id;
        }

        public boolean isOrderable() {
            return mIsOrderable;
        }

        public void setOrderable(boolean isOrderable) {
            mIsOrderable = isOrderable;
        }

        public Double getPrice() {
            return mPrice;
        }

        public void setPrice(Double price) {
            mPrice = price;
        }
    }

}
