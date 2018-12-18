package id.co.heksainsurance.berasuransi._API.APIInterface;

import java.util.List;

import id.co.heksainsurance.berasuransi._API.APIModel.CategoryModel;
import id.co.heksainsurance.berasuransi._API.APIModel.ProductModel;
import id.co.heksainsurance.berasuransi._API.APIModel.ResultModel;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface IProduct {
    //i.e. http://localhost/api/institute/Students
    @GET("/institute/Students")
    public void getStudent(Callback<List<CategoryModel>> callback);

    //i.e. http://localhost/api/institute/Students/1
    //Get student record base on ID
    @GET("/Product/GetDataProductCategory")
    public void GetDataCategory(Callback<CategoryModel> callback);

    //i.e. http://localhost/api/institute/Students/1
    //Delete student record base on ID
    @GET("/Product/GetDataProductByID/{id}")
    public void GetDataProductByID(@Path("id") Integer id);

    @GET("/Product/GetDataProductByID/{id}")
    public void GetDataProductByIDP(@Path("id") Integer id, Callback<ResultModel<List<ProductModel>>> callback);

    //i.e. http://localhost/api/institute/Students/1
    //PUT student record and post content in HTTP request BODY
    @PUT("/institute/Students/{id}")
    public void updateStudentById(@Path("id") Integer id, @Body CategoryModel student, Callback<CategoryModel> callback);

    //i.e. http://localhost/api/institute/Students
    //Add student record and post content in HTTP request BODY
    @POST("/institute/Students")
    public void addStudent(@Body CategoryModel student,Callback<CategoryModel> callback);

}
