package id.co.heksainsurance.berasuransi;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import id.co.heksainsurance.berasuransi._API.APICategory;
import id.co.heksainsurance.berasuransi._API.APIModel.CategoryModel;
import id.co.heksainsurance.berasuransi._API.APIModel.ProductModel;
import id.co.heksainsurance.berasuransi._API.APIModel.ResultModel;
import id.co.heksainsurance.berasuransi._GridView.GridViewAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;
import java.util.List;

public class product_item extends Fragment {
    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode = 0;

    static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;
    public static CartFragment newInstance(){
        CartFragment fragment = new CartFragment();
        return fragment;
    }

    @Override
    public  void onCreate(Bundle savedInstanceState){ super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        stubGrid = (ViewStub) rootView.findViewById(R.id.stub_grid);

        stubGrid.inflate();

        gridView = (GridView) rootView.findViewById(R.id.mygridview);

        Bundle args = getArguments();
        String sProduct = this.getArguments().getString("product");

        TextView txt = (TextView) rootView.findViewById(R.id.lblProduct);

        txt.setText("All " + sProduct);


        GetDataAPIProductByID();


        return rootView;
    }


    private void setAdapters() {

        gridViewAdapter = new GridViewAdapter(getActivity(), R.layout.fragment_grid_item, productList);
        gridView.setAdapter(gridViewAdapter);

    }

    APICategory apiCategory;
    private void DataAPI()
    {
        apiCategory = new APICategory();
        apiCategory.getService().GetDataCategory(new Callback<CategoryModel>() {
            @Override
            public void success(CategoryModel student, Response response) {

                String sid = String.valueOf(student.ID);
                String sCategory = String.valueOf(student.Categori);

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private  void GetDataAPIProductByID()
    {
        apiCategory = new APICategory();
        productList = new ArrayList<>();

        apiCategory.getService().GetDataProductByIDP(1, new Callback<ResultModel<List<ProductModel>>>() {
            @Override
            public void success(ResultModel<List<ProductModel>> responseData, Response response) {

                List<ProductModel> listProduct = (List<ProductModel>)(List<?>)responseData.ResponseData;

                for(ProductModel model : listProduct)
                {
                    productList.add(new Product(R.drawable.ic_android_black_24dp, model.Title, model.Description, model.Photo1));
                    gridViewAdapter = new GridViewAdapter(getActivity(), R.layout.fragment_grid_item, productList);
                    gridView.setAdapter(gridViewAdapter);
                }
            }
            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
