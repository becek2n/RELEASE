package id.co.heksainsurance.berasuransi._API.APIModel;

public class ResultModel<T>
{
    public ResultModel()
    {

    }
    public ResultModel(boolean IsSuccess)
    {
        this.ResponseCode = (IsSuccess) ? "200" : "500";
        this.ResponseMessage = (IsSuccess) ? "success" : "failed";
    }

    public ResultModel<T> SetSuccess(String message, T value)
    {
        this.ResponseCode = "200";
        this.ResponseMessage = message != null ? message : "success";
        this.ResponseData = value;
        return this;
    }

    public ResultModel<T> SetFailed(String message, String statusCode, T value, Exception Ex)
    {
        this.ResponseCode = "500";
        this.ResponseMessage = "failed";
        this.ResponseData = value;
        this.ValException = Ex;
        return this;
    }

    public String ResponseCode;
    public String ResponseMessage ;
    public T ResponseData ;
    public Exception ValException;
}

