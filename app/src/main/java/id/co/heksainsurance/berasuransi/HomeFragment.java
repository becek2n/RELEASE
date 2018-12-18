package id.co.heksainsurance.berasuransi;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import id.co.heksainsurance.berasuransi._silders.SliderIndicator;
import id.co.heksainsurance.berasuransi._silders.SliderView;
import id.co.heksainsurance.berasuransi._silders.SliderPagerAdapter;
import id.co.heksainsurance.berasuransi._silders.FragmentSlider;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import id.co.heksainsurance.berasuransi.VerticalItem.RecyclerViewDataAdapter;
import id.co.heksainsurance.berasuransi.VerticalItem.SectionDataModel;
import id.co.heksainsurance.berasuransi.VerticalItem.SingleItemModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    private RelativeLayout menu1;

    private Toolbar toolbar;

    ArrayList<SectionDataModel> allSampleData;

    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    //public HomeFragment() {
        // Required empty public constructor
    //}

    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //return inflater.inflate(R.layout.fragment_home, container, false);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        activity.getSupportActionBar().setTitle("Release");

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);
        //setupSlider();
        menu1 = (RelativeLayout) rootView.findViewById(R.id.menu1);

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "kllik me", Toast.LENGTH_SHORT).show();

                //Intent goPindah = new Intent(getActivity(), CartFragment.class);
                //startActivity(goPindah);


                product_item fragment = new product_item();

                Bundle args = new Bundle();
                args.putString("product", "Shoes");
                fragment.setArguments(args);

                Intent goPindah = new Intent(getActivity(), product_item_detail.class);
                startActivity(goPindah);

                //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                //FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //fragmentTransaction.replace(R.id.content, fragment);
                //fragmentTransaction.addToBackStack(null);
                //fragmentTransaction.commit();
            }
        });

        // jika internet aktfif
        setupSliderOfline();

        //get toolbar vertical
        toolbar = (Toolbar)rootView.findViewById(R.id.toolbar);

        allSampleData = new ArrayList<SectionDataModel>();

        if (toolbar != null) {
            //setSupportActionBar(toolbar);
            //AppCompatActivity activity = (AppCompatActivity) getActivity();
            //main.setSupportActionBar(toolbar);
            toolbar.setTitle("G PlayStore");

        }

        createDummyData();

        RecyclerView my_recycler_view = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getActivity(), allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);

        return rootView;
    }

    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("pdffile"));
        fragments.add(FragmentSlider.newInstance("remove"));


        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.ic_launcher_foreground);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

    private void setupSliderOfline() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("image_slider_1"));
        fragments.add(FragmentSlider.newInstance("image_slider_2"));
        fragments.add(FragmentSlider.newInstance("image_slider_1"));
        fragments.add(FragmentSlider.newInstance("image_slider_2"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
}
