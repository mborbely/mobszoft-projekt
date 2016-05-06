package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import io.swagger.client.model.Person;
import io.swagger.client.model.PersonDetails;
import java.math.BigDecimal;
import io.swagger.client.model.Registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DefaultApi {
  
  /**
   * 
   * Lists friends of logged in user
   * @return Call<List<Person>>
   */
  
  @GET("friends")
  Call<List<Person>> friendsGet();
    

  
  /**
   * 
   * Gets the profile imformation of a friend
   * @param personId Id of person to be added as friend
   * @return Call<List<PersonDetails>>
   */
  
  @GET("friends/{personId}")
  Call<List<PersonDetails>> friendsPersonIdGet(
          @Path("personId") BigDecimal personId
  );

  
  /**
   * 
   * Adds a person to your friends
   * @param personId Id of person to be added as friend
   * @return Call<Void>
   */
  
  @POST("friends/{personId}")
  Call<Void> friendsPersonIdPost(
          @Path("personId") BigDecimal personId
  );

  
  /**
   * 
   * Update profile
   * @param user The pet JSON you want to post
   * @return Call<Void>
   */
  
  @PUT("users")
  Call<Void> usersPut(
          @Body PersonDetails user
  );

  
  /**
   * 
   * Register a new user
   * @param user The pet JSON you want to post
   * @return Call<Void>
   */
  
  @POST("users")
  Call<Void> usersPost(
          @Body Registration user
  );

  
}
