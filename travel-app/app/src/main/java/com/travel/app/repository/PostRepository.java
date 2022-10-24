package com.travel.app.repository;

import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.travel.app.common.DataStatic;
import com.travel.app.common.response.ApiResponse;
import com.travel.app.common.utils.RestUtils;
import com.travel.app.common.utils.UriUtils;
import com.travel.app.data.model.Comment;
import com.travel.app.data.model.Location;
import com.travel.app.data.model.Media;
import com.travel.app.data.model.PostUser;
import com.travel.app.retrofit.LocationRequest;
import com.travel.app.retrofit.PostRequest;
import com.travel.app.retrofit.RetrofitRequest;
import com.travel.app.view.fragment.FragmentMainHotelDetail;
import com.travel.app.view.fragment.FragmentMainTravelDetail;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.ServerResponse;
import net.gotev.uploadservice.UploadInfo;
import net.gotev.uploadservice.UploadStatusDelegate;

import java.io.File;
import java.util.List;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {
    private final PostRequest postRequest;
    private MultipartUploadRequest up;
    private Context context;

    public PostRepository(Context context){
        postRequest = RetrofitRequest.instance().create(PostRequest.class);
        this.context = context;
    }

    public LiveData<ApiResponse<List<Comment>>> getComments(Integer id){
        MutableLiveData<ApiResponse<List<Comment>>> data = new MutableLiveData<>();
        postRequest.getComments(id).enqueue(new Callback<ApiResponse<List<Comment>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Comment>>> call, Response<ApiResponse<List<Comment>>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Comment>>> call, Throwable t) {

            }
        });
        return data;
    }
    /*
    public LiveData<ApiResponse<Comment>> postComment(String token, Comment comment, MultipartBody.Part partFile){
        MutableLiveData<ApiResponse<Comment>> data = new MutableLiveData<>();
        token = (token != null & token.trim().length() > 0) ? "Bearer ".concat(token).replaceAll("\"", "") : "";
        postRequest.postComment(token, comment.getIdPost(), comment.getIdParent(), comment.getContent(), partFile).enqueue(new Callback<ApiResponse<Comment>>() {
            @Override
            public void onResponse(Call<ApiResponse<Comment>> call, Response<ApiResponse<Comment>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<Comment>> call, Throwable t) {

            }
        });
        return data;
    }
    */

    public void postComment(String token, Comment comment, String path, Fragment fragment){
        try{
            String uploadId = UUID.randomUUID().toString();
            up = new MultipartUploadRequest(this.context, uploadId, DataStatic.BASE_URL+"api/post/comment");
            up.addParameter("id_post", comment.getIdPost()+"");
            up.addParameter("id_parent", comment.getIdParent()+"");
            up.addParameter("content", comment.getContent());
            if(path != null && path.length() > 0) up.addFileToUpload(path, "file");

            up.setUtf8Charset();
            up.addHeader("Authorization", String.format("Bearer %s", token).replaceAll("\"", ""));
            System.out.println("TOKEN REQUEST: "+String.format("Bearer %s", token).replaceAll("\"", ""));
            //up.setNotificationConfig(new UploadNotificationConfig());
            up.setDelegate(new UploadStatusDelegate() {
                @Override
                public void onProgress(Context context, UploadInfo uploadInfo) {
                    Log.d("UpFile", "onProgress: "+uploadInfo.getProgressPercent());
                }

                @Override
                public void onError(Context context, UploadInfo uploadInfo, Exception exception) {
                    //progressLoading.dismiss();
                    Toast.makeText(context, "Please check your internet connection!", Toast.LENGTH_SHORT).show();
                    Log.d("UpFile", "onError: "+exception.getMessage());
//                    dialog.dismiss();
                }

                @Override
                public void onCompleted(Context context, UploadInfo uploadInfo, ServerResponse serverResponse) {
                    Log.d("UpFile", "onCompleted: "+serverResponse.getBodyAsString().toString());
                    String response = serverResponse.getBodyAsString().toString();
                    if(fragment instanceof FragmentMainTravelDetail){
                        ((FragmentMainTravelDetail) fragment).loadComment();
                    }else if(fragment instanceof FragmentMainHotelDetail){
                        ((FragmentMainHotelDetail) fragment).loadComment();
                    }
//                   dialog.dismiss();
                    //progressLoading.dismiss();
                }

                @Override
                public void onCancelled(Context context, UploadInfo uploadInfo) {
                    Log.d("UpFile", "onCancelled");
//                    dialog.dismiss();
                }
            });
            up.setMaxRetries(2);
            up.startUpload();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public LiveData<ApiResponse<PostUser>> postLike(String token, PostUser postUser){
        MutableLiveData<ApiResponse<PostUser>> data = new MutableLiveData<>();
        token = (token != null & token.trim().length() > 0) ? "Bearer ".concat(token).replaceAll("\"", "") : "";
        postRequest.postLike(token, postUser).enqueue(new Callback<ApiResponse<PostUser>>() {
            @Override
            public void onResponse(Call<ApiResponse<PostUser>> call, Response<ApiResponse<PostUser>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<PostUser>> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<ApiResponse<PostUser>> postRate(String token, PostUser postUser){
        MutableLiveData<ApiResponse<PostUser>> data = new MutableLiveData<>();
        token = (token != null & token.trim().length() > 0) ? "Bearer ".concat(token).replaceAll("\"", "") : "";
        postRequest.postRate(token, postUser).enqueue(new Callback<ApiResponse<PostUser>>() {
            @Override
            public void onResponse(Call<ApiResponse<PostUser>> call, Response<ApiResponse<PostUser>> response) {
                data.setValue(RestUtils.get(response));
            }

            @Override
            public void onFailure(Call<ApiResponse<PostUser>> call, Throwable t) {

            }
        });
        return data;
    }


}
