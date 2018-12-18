package id.co.heksainsurance.berasuransi._API;

import id.co.heksainsurance.berasuransi._API.APIInterface.IProduct;

public class APICategory {
    private static final String URL = "http://172.20.10.32/release-api/api/";
    private retrofit.RestAdapter restAdapter;
    private IProduct apiService;

    public APICategory()
    {
        restAdapter = new retrofit.RestAdapter.Builder()
                .setEndpoint(URL)
                .setLogLevel(retrofit.RestAdapter.LogLevel.FULL)
                .build();

        apiService = restAdapter.create(IProduct.class);
    }

    public IProduct getService()
    {
        return apiService;
    }
}

