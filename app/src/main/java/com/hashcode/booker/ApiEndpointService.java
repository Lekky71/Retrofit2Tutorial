package com.hashcode.booker;

import com.hashcode.booker.models.BookSearchResult;
import com.hashcode.booker.models.LoginBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by HashCode on 10:21 AM 03/04/2018.
 */

public interface ApiEndpointService {

    @GET("volumes")
    Call<BookSearchResult> searchForBook(@Query("q")String bookName);

    @POST("login")
    Call<Object> loginUser(@Body LoginBody loginBody);

}
