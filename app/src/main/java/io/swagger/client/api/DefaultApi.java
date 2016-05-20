package io.swagger.client.api;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.client.model.Login;
import io.swagger.client.model.Person;
import io.swagger.client.model.PersonDetails;
import io.swagger.client.model.Registration;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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
   * @return Call<List<PersonDetails>>
   */
  
  @GET("friends")
  Call<PersonDetails> friendsPersonIdGet(BigDecimal personId);

  @GET("friends")
  Call<Boolean> login(Login login);

  
  /**
   * 
   * Adds a person to your friends
   * @param personId Id of person to be added as friend
   * @return Call<Void>
   */
  
  @POST("friends/{personId}")
  Call<BigDecimal> friendsPersonIdPost(
          @Path("personId") BigDecimal personId
  );

  
  /**
   * 
   * Update profile
   * @param user The pet JSON you want to post
   * @return Call<Void>
   */
  
  @PUT("users")
  Call<Registration> usersPut(
          @Body PersonDetails user
  );

  
  /**
   * 
   * Register a new user
   * @param user The pet JSON you want to post
   * @return Call<Void>
   */
  
  @POST("users")
  Call<Registration> usersPost(
          @Body Registration user
  );

  @GET("users")
  Call<List<Person>> usersGet(
  );

  
}
