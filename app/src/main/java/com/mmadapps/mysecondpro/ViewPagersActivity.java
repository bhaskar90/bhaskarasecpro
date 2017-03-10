package com.mmadapps.mysecondpro;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mmadapps.mysecondpro.fragments.AndroidFragment;
import com.mmadapps.mysecondpro.fragments.IOSFragment;
import com.mmadapps.mysecondpro.utils.PagerContainer;
import com.squareup.picasso.Picasso;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewPagersActivity extends AppCompatActivity {

    PagerContainer mContainer;
    CirclePageIndicator oCirclePageIndicator;
    ViewPager pager, vP_ah_packagenamepager, vP_agm_notificationpager;
    PagerAdapter adapter, packageAdapter;

    HashMap<Integer, Boolean> invalidateViews;
    HashMap<Integer, View> views, parentView;
    HashMap<Integer, TextView> textviews;

    // for auto scroll of pages
    Runnable runnable;
    private int page = 0;
    private int delay = 2000;
    Handler handler;


    TabLayout tabLayout;


    // initialize values
    int[] imgsforpager = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
    String[] textforpager = {"andoird", "IOS", "WEB", ".NET", "SQL", "JAVA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pagers);
        initializeViews();
    }

    private void initializeViews() {

        handler = new Handler();
        mContainer = (PagerContainer) findViewById(R.id.pager_container);
        oCirclePageIndicator = (CirclePageIndicator) findViewById(R.id.cP_ah_placeIndicator);
        vP_ah_packagenamepager = (ViewPager) findViewById(R.id.vP_ah_packagenamepager);
        vP_agm_notificationpager = (ViewPager) findViewById(R.id.vP_agm_notificationpager);
        tabLayout = (TabLayout) findViewById(R.id.vT_agm_tabLayout);
        setValues();

    }

    private void setValues() {

        invalidateViews = new HashMap<>();
        views = new HashMap<>();
        textviews = new HashMap<>();
        parentView = new HashMap<>();

        adapter = new ViewPagersActivity.HomePagerAdapter(this);
        packageAdapter = new ViewPagersActivity.PackageNameAdapter(this);

        pager = mContainer.getViewPager();
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(adapter.getCount());
        pager.setPageMargin(3);
        pager.setClipChildren(false);
        oCirclePageIndicator.setViewPager(pager);

        vP_ah_packagenamepager.setAdapter(packageAdapter);

        runnable = new Runnable() {
            public void run() {
                if (adapter.getCount() == page) {
                    page = 0;
                } else {
                    page++;
                }
                pager.setCurrentItem(page, true);
                handler.postDelayed(this, delay);
            }
        };

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AndroidFragment());
        adapter.addFragment(new IOSFragment());
        adapter.addFragment(new AndroidFragment());
        adapter.addFragment(new IOSFragment());

        vP_agm_notificationpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(vP_agm_notificationpager);
        try {
            tabLayout.getTabAt(0).setText("Android");
            tabLayout.getTabAt(1).setText("IOS");
            tabLayout.getTabAt(2).setText("JAVA");
            tabLayout.getTabAt(3).setText("SQL");

        } catch (NullPointerException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, delay);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    private class HomePagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public HomePagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imgsforpager.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View itemView = mLayoutInflater.inflate(R.layout.homepager_adapter_layout, container, false);
            ImageView pager_image = (ImageView) itemView.findViewById(R.id.pager_image);

            Picasso.with(ViewPagersActivity.this)
                    .load(imgsforpager[position])
                    .placeholder(R.drawable.placeholder)          // optional
                    .into(pager_image);

            // pager_image.setImageResource(mResources[position]);
            container.addView(itemView);
            return itemView;
        }

       /* @Override
        public float getPageWidth(int position) {
            return(0.3f);
        }*/

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }
    }

    private class PackageNameAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public PackageNameAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            invalidateViews.clear();
            views.clear();
            textviews.clear();
            parentView.clear();

        }

        @Override
        public int getCount() {
            return textforpager.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {

            View itemView = mLayoutInflater.inflate(R.layout.package_name_layout, container, false);
            LinearLayout vL_pkl_packageLayout = (LinearLayout) itemView.findViewById(R.id.vL_pkl_packageLayout);
            final View view = itemView.findViewById(R.id.vV_pkl_package);
            final TextView vT_pkl_packagename = (TextView) itemView.findViewById(R.id.vT_pkl_packagename);

            if (position == 0) {
                view.setBackgroundColor(getResources().getColor(R.color.logincolor));
                vT_pkl_packagename.setTextColor(getResources().getColor(R.color.logincolor));
                vL_pkl_packageLayout.setBackgroundColor(getResources().getColor(R.color.medium_gray));
            }


            vT_pkl_packagename.setText(textforpager[position]);

            invalidateViews.put(position, false);
            views.put(position, view);
            textviews.put(position, vT_pkl_packagename);
            parentView.put(position, vL_pkl_packageLayout);

            // vT_pkl_packagename.setText(mContents[position]);
            container.addView(itemView);

            vL_pkl_packageLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int j = 0; j < invalidateViews.size(); j++) {
                        if (position == j) {
                            invalidateViews.remove(j);
                            invalidateViews.put(j, true);
                        } else {
                            invalidateViews.remove(j);
                            invalidateViews.put(j, false);
                        }
                    }

                    for (int i = 0; i < invalidateViews.size(); i++) {
                        if (invalidateViews.get(i)) {
                            views.get(i).setBackgroundColor(getResources().getColor(R.color.logincolor));
                            textviews.get(i).setTextColor(getResources().getColor(R.color.logincolor));
                            parentView.get(i).setBackgroundColor(getResources().getColor(R.color.medium_gray));
                        } else {
                            views.get(i).setBackgroundColor(getResources().getColor(R.color.black_color));
                            textviews.get(i).setTextColor(getResources().getColor(R.color.white));
                            parentView.get(i).setBackgroundColor(getResources().getColor(R.color.black_color));
                        }
                    }

                }
            });
            return itemView;

        }

        @Override
        public float getPageWidth(int position) {
            return (0.3f);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
//            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "";
        }
    }


}
