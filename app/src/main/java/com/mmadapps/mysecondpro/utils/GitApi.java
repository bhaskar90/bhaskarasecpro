package com.mmadapps.mysecondpro.utils;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by bhaskara.reddy on 09-03-2017.
 */

public interface GitApi {


   /* @Headers({
            "OS:ANDROID"
    })
    @POST("UserService.svc/UserLogin")
    Call<Loginbeansresult> userLogin(@Body Loginbeanscons loginpost);*/


   /* @GET("PackageService.svc/GetHomePageDetails")
    Call<Homepagebeansresult> getHomepagedetails();*/

   /* @GET("search?key=AIzaSyDJ1BHVXew1xILL9yszQNBtCQAYta7w_GM&channelId=UCpYTR5JYjj07KrI247vUmKA&part=snippet,id&order=date&maxResults=5")
    Call<Youtubevideobeans> getHomepageyoutubevideo();*/




  /*  @Headers({
            "APIKEY:efuel.MART.P423434OND-Y43458NK4445S-TN78789M789S-P78L89A9S78",
            "Os:ANDROID",
    })
    @GET("TransactionService.svc/GetCAByOwnerId/" + "{userId}" + "/" + "{transaction_id}" + "/" + "{castatus}")
    Call<Cadetailsforowner> getCalistforowner(@Header("UserId") String user_id, @Header("TokenKey") String token, @Header("OwnerId") String OwnerId,
                                              @Header("IsDeligate") Boolean IsDeligate, @Path("userId") String userId, @Path("transaction_id") String transaction_id, @Path("castatus") String castatus);
*/



   /* @Headers({
            "APIKEY:efuel.MART.P423434OND-Y43458NK4445S-TN78789M789S-P78L89A9S78",
            "Os:ANDROID",
    })
    @POST("TransactionService.svc/TerminateCAById")
    Call<Terminateca> terminateCa(@Header("UserId") String user_id, @Header("TokenKey") String token, @Header("OwnerId") String OwnerId, @Header("IsDeligate") Boolean IsDeligate, @Body TerminatecaCons terminatecaCons);

*/







}
