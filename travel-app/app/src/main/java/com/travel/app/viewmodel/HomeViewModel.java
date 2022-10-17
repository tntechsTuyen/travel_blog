package com.travel.app.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.travel.app.common.response.ApiResponse;
import com.travel.app.data.model.Comment;
import com.travel.app.data.model.Hotel;
import com.travel.app.data.model.HotelMeta;
import com.travel.app.data.model.Location;
import com.travel.app.data.model.PostUser;
import com.travel.app.data.model.Tag;
import com.travel.app.data.model.Travel;
import com.travel.app.data.model.TravelMeta;
import com.travel.app.repository.HotelRepository;
import com.travel.app.repository.LocationRepository;
import com.travel.app.repository.PostRepository;
import com.travel.app.repository.SettingRepository;
import com.travel.app.repository.TravelRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private TravelRepository travelRepository;
    private LocationRepository locationRepository;
    private PostRepository postRepository;
    private HotelRepository hotelRepository;
    private SettingRepository settingRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.travelRepository = new TravelRepository();
        this.locationRepository = new LocationRepository();
        this.postRepository = new PostRepository();
        this.hotelRepository = new HotelRepository();
        this.settingRepository = new SettingRepository();
    }

    public LiveData<ApiResponse<List<Travel>>> getAds(){
        return this.travelRepository.getAds();
    }

    public LiveData<ApiResponse<List<Travel>>> getTops(){
        return this.travelRepository.getTop();
    }

    public LiveData<ApiResponse<List<Travel>>> getTravelList(String search){
        return this.travelRepository.getList(search);
    }

    public LiveData<ApiResponse<List<Travel>>> getMyHobbies(String token){
        return this.travelRepository.getMyHobbies(token);
    }

    public LiveData<ApiResponse<List<Travel>>> getTravelByCity(Integer zipCode){
        return this.travelRepository.getByCityCode(zipCode);
    }

    public LiveData<ApiResponse<Travel>> getTravelDetail(String token, Integer id){
        return this.travelRepository.getDetail(token, id);
    }

    public LiveData<ApiResponse<List<Hotel>>> getHotelByTravel(Integer id){
        return this.travelRepository.getHotels(id);
    }

    public LiveData<ApiResponse<List<Comment>>> getComment(Integer idPost){
        return this.postRepository.getComments(idPost);
    }

    public LiveData<ApiResponse<List<TravelMeta>>> getTravelMetas(Integer id){
        return this.travelRepository.getMetas(id);
    }

    public LiveData<ApiResponse<List<Location>>> getCity(){
        return this.locationRepository.getList();
    }

    public LiveData<ApiResponse<Hotel>> getHotelDetail(String token, Integer id){
        return this.hotelRepository.getDetail(token, id);
    }

    public LiveData<ApiResponse<List<HotelMeta>>> getHotelMeta(Integer id){
        return this.hotelRepository.getMetas(id);
    }

    public LiveData<ApiResponse<List<Tag>>> getTagList(String token){
        return this.settingRepository.getTagList(token);
    }

    public LiveData<ApiResponse<Boolean>> postTagUpdate(String token, List<Integer> idTags){
        return this.settingRepository.postTagUpdate(token, idTags);
    }

    public LiveData<ApiResponse<Comment>> postComment(String token, Comment comment){
        return this.postRepository.postComment(token, comment);
    }

    public LiveData<ApiResponse<PostUser>> postLike(String token, PostUser postUser){
        return this.postRepository.postRate(token, postUser);
    }

    public LiveData<ApiResponse<PostUser>> postRate(String token, PostUser postUser){
        return this.postRepository.postRate(token, postUser);
    }
}