package id.co.heksainsurance.berasuransi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.GridView;
import android.widget.ListView;
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


public class CartFragment extends Fragment {
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
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle("Keranjang");

        stubGrid = (ViewStub) rootView.findViewById(R.id.stub_grid);

        stubGrid.inflate();

        gridView = (GridView) rootView.findViewById(R.id.mygridview);

        GetDataAPIProductByID();
        return rootView;
    }


    private void setAdapters() {

        gridViewAdapter = new GridViewAdapter(getActivity(), R.layout.fragment_grid_item, productList);
        gridView.setAdapter(gridViewAdapter);

    }

    public List<Product> getProductList() {
        //pseudo code to get product, replace your code to get real product here
        productList = new ArrayList<>();
        //productList.add(new Product(R.drawable.ic_android_black_24dp, "Item 1", "This is description 1"));
        //productList.add(new Product(R.drawable.ic_android_black_24dp, "Item 2", "This is description 2"));
        //productList.add(new Product(R.drawable.ic_android_black_24dp, "Item 3", "This is description 3"));
        //productList.add(new Product(R.drawable.ic_android_black_24dp, "Item 4", "This is description 4"));
        //productList.add(new Product(R.drawable.ic_android_black_24dp, "Item 5", "This is description 5"));
        //productList.add(new Product(R.drawable.ic_android_black_24dp, "Item 6", "This is description 6"));
        //productList.add(new Product(R.drawable.ic_android_black_24dp, "Item 7", "This is description 7"));
        //productList.add(new Product(R.drawable.ic_android_black_24dp, "Item 8", "This is description 8"));
        //productList.add(new Product(R.drawable.ic_android_black_24dp, "Item 9", "This is description 9"));
        //productList.add(new Product(R.drawable.ic_android_black_24dp, "Item 10", "This is description 10"));

        return productList;
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
