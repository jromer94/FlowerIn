package com.jromer.flowerin.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jromer.flowerin.app.dummy.DummyContent;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONException;

import java.util.ArrayList;

/**

 */
public class MenuItemFragment extends ListFragment {

    ArrayList<Menu.MenuItem> mMenuItems;
    MenuHoldr mMenuHoldr;

    private OnFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MenuItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mMenuHoldr = MenuHoldr.get(getActivity());
        if(mMenuHoldr.getMenu() == null){

            new fetchMenuTask().execute();

        }

        // TODO: Change Adapter to display your content
        setupAdapter();
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        OrdrHoldr ordrHoldr = OrdrHoldr.get(getActivity());
        ordrHoldr.setItem((Menu.MenuItem) getListAdapter().getItem(position));
        Intent intent = new Intent(getActivity(), CardInfoActivity.class);
        startActivity(intent);

    }



    /**
    * This interface must be implemented by activities that contain this
    * fragment to allow an interaction in this fragment to be communicated
    * to the activity and potentially other fragments contained in that
    * activity.
    * <p>
    * See the Android Training lesson <a href=
    * "http://developer.android.com/training/basics/fragments/communicating.html"
    * >Communicating with Other Fragments</a> for more information.
    */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(String id);
    }

    public class MenuItemAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return mMenuItems.size();
        }

        @Override
        public Object getItem(int i) {
            return mMenuItems.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view == null){

               LayoutInflater layoutInflater = (LayoutInflater) getActivity().
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(R.layout.flower_list_item, null);

            }

            Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/champagne_limousines.ttf");


            TextView name = (TextView) view.findViewById(R.id.flower_name);
            name.setText(mMenuItems.get(i).getItemName());
            name.setTypeface(type);


            TextView description = (TextView)view.findViewById(R.id.flower_description);
            description.setText(mMenuItems.get(i).getDescription());
            description.setTypeface(type);

            TextView price = (TextView)view.findViewById(R.id.price);
            price.setText("$" + mMenuItems.get(i).getPrice());
            price.setTypeface(type);

            ImageView image = (ImageView) view.findViewById(R.id.flower_image);
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(getFlowerPicUrl(mMenuItems.get(i).getItemName()), image);

            return view;
        }


    }

    private class fetchMenuTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            try {
                mMenuHoldr.setMenu(new MenuFetchr().fetchMenu());
                Log.i("MenuFragment", "downloaded menu");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void none){

            setupAdapter();

        }
    }

    private void setupAdapter(){

         mMenuItems = new ArrayList<Menu.MenuItem>();
        if(mMenuHoldr.getMenu() != null){

            Menu  menu= mMenuHoldr.getMenu();
            Log.i("MenuFragment", "Set new menu");
            mMenuItems = mMenuHoldr.getMenu().getCategories().get(0).getMenuItems();
            //mMenuItems.remove(8);

        }
        MenuItemAdapter expandableListAdapter = new MenuItemAdapter();
        setListAdapter(expandableListAdapter);
        Log.i("MenuFragment", "updated adapter");

    }

    private String getFlowerPicUrl(String name){

        if(name.equals("Come to Me")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/2_Come-with-me.jpg";

        } else if(name.equals("Eye of Heaven")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/1_Eye-of-Heaven.jpg";

        } else if(name.equals("Go For It")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/2_Go-for-it.jpg";

        } else if(name.equals("Heart - Large")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/2_Heart-$96.99.jpg";

        } else if(name.equals("Heart - Medium")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/2_Heart-$79.99.jpg";

        } else if(name.equals("Heart - Small")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/2_Heart-$57.99.jpg";

        } else if(name.equals("Inspiration")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/1_Inspiration.jpg";

        } else if(name.equals("Medallion")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/2_Medallion.jpg";

        } else if(name.equals("Perfume")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/1_Perfume.jpg";

        } else if(name.equals("Sunrise")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/1_Sunrise.jpg";

        } else if(name.equals("Swear")){

            return "http://www.bestfloraldesign.com/galleries/classic_design_fresh_cut_flowers/2_Swear.jpg";

        } else if(name.equals("Tender Trio")){

            return "";

        } else if(name.equals("Delightfully Daisy")){

            return "";

        }

        return null;
    }

}
