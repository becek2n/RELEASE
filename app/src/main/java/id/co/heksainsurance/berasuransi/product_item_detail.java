package id.co.heksainsurance.berasuransi;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.co.heksainsurance.berasuransi.VerticalItem.SectionDataModel;
import id.co.heksainsurance.berasuransi._silders.FragmentSlider;
import id.co.heksainsurance.berasuransi._silders.SliderIndicator;
import id.co.heksainsurance.berasuransi._silders.SliderIndicatorItem;
import id.co.heksainsurance.berasuransi._silders.SliderPagerAdapter;
import id.co.heksainsurance.berasuransi._silders.SliderView;
import id.co.heksainsurance.berasuransi._silders.SliderViewItem;

public class product_item_detail extends AppCompatActivity {

    private SliderPagerAdapter mAdapter;
    private SliderIndicatorItem mIndicator;

    private SliderViewItem sliderView;
    private LinearLayout mLinearLayout;
    private RelativeLayout menu1;

    private Toolbar toolbar;

    ArrayList<SectionDataModel> allSampleData;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                //case R.id.navigation_home:
                //    mTextMessage.setText(R.string.title_home);
                //    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_product_item_detail);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        sliderView = (SliderViewItem) findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout)findViewById(R.id.pagesContainer);

        setupSliderOfline();

    }

    private void setupSliderOfline() {
        //sliderView.setDurationScroll(0);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("image_slider_1"));
        fragments.add(FragmentSlider.newInstance("image_slider_2"));
        fragments.add(FragmentSlider.newInstance("image_slider_1"));
        fragments.add(FragmentSlider.newInstance("image_slider_2"));

        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicatorItem(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }



}
