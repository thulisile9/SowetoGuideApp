package com.example.android.sowetoguideapp;

import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;


    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        if (position ==1){
            return new AttractionFragment();
        }else if (position ==2){
            return new RestaurantFragment();
        }else
            return new HotelFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position ==1){
            return mContext.getString(R.string.category_attraction);
        }else if (position ==2){
            return  mContext.getString(R.string.category_restaurant);
        }else
            return  mContext.getString(R.string.category_hotel);
    }
}
