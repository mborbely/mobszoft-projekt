package io.swagger.client.api;

import android.support.annotation.NonNull;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import io.swagger.client.model.Login;
import io.swagger.client.model.Person;
import io.swagger.client.model.PersonDetails;
import io.swagger.client.model.Registration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Path;

public class DefaultApiImpl implements DefaultApi{

    private static Map<BigDecimal, Registration> persons = new HashMap<>();

    private static Set<BigDecimal> friends = new HashSet<>();

    static {
        registerPerson(1);
        registerPerson(2);
        registerPerson(3);
        registerPerson(4);

        friends.add(new BigDecimal(1));
    }

    private static void registerPerson(int intId) {
        Registration reg = new Registration();
        BigDecimal id = new BigDecimal(intId);
        reg.setId(id);
        reg.setName("" + intId);
        reg.setEmail(intId +"");
        reg.setPassword("" +intId);
        reg.setBirthplace("Győr");
        persons.put(id, reg);
    }


    @Override
    public Call<List<Person>> friendsGet() {
        return new Call<List<Person>>() {
            @Override
            public Response<List<Person>> execute() throws IOException {
                List<Person> persons = Lists.transform(Lists.newArrayList(friends), new Function<BigDecimal, Person>() {

                    @Override
                    public Person apply(BigDecimal input) {
                        Registration registration = DefaultApiImpl.persons.get(input);
                        Person result = new Person();

                        result.setName(registration.getName());
                        result.setId(registration.getId());
                        result.setDescription(registration.getDescription());
                        return result;
                    }
                });

                return Response.success(persons);
            }

            @Override
            public void enqueue(Callback<List<Person>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Person>> clone() {
                return this;
            }
        };
    }

    @Override
    public Call<Boolean> login(final Login login) {
        return new Call<Boolean>() {
            @Override
            public Response<Boolean> execute() throws IOException {
                for (Registration reg : persons.values()) {
                    if (reg.getEmail().equals(login.getEmail())){
                        if (reg.getPassword().equals(login.getPassword())){
                            return Response.success(true);
                        }
                    }
                }
                return Response.success(false);
            }

            @Override
            public void enqueue(Callback<Boolean> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Boolean> clone() {
                return null;
            }
        };

    }

    @Override
    public Call<PersonDetails> friendsPersonIdGet(final BigDecimal personId) {
        return new Call<PersonDetails>() {
            @Override
            public Response<PersonDetails> execute() throws IOException {

                Registration registration = DefaultApiImpl.persons.get(personId);
                PersonDetails result = new PersonDetails();

                result.setName(registration.getName());
                result.setId(registration.getId());
                result.setDescription(registration.getDescription());
                result.setBirthplace(registration.getBirthplace());
                result.setEmail(registration.getEmail());


                return Response.success(result);
            }

            @Override
            public void enqueue(Callback<PersonDetails> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<PersonDetails> clone() {
                return this;
            }
        };
    }

    @Override
    public Call<BigDecimal> friendsPersonIdPost(@Path("personId") final BigDecimal personId) {
        return new Call<BigDecimal>() {
            @Override
            public Response<BigDecimal> execute() throws IOException {
                friends.add(personId);
                return Response.success(personId);
            }

            @Override
            public void enqueue(Callback<BigDecimal> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<BigDecimal> clone() {
                return this;
            }
        };
    }

    @Override
    public Call<Registration> usersPut(@Body final PersonDetails user) {
        return null;
    }

    @Override
    public Call<Registration> usersPost(@Body final Registration user) {
        return new Call<Registration>() {
            @Override
            public Response<Registration> execute() throws IOException {
                return register();
            }

            @NonNull
            private Response<Registration> register() {
                BigDecimal id = new BigDecimal(new Random().nextLong());
                user.setId(id);
                persons.put(id, user);
                return Response.success(user);
            }

            @Override
            public void enqueue(Callback<Registration> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<Registration> clone() {
                return this;
            }
        };
    }
}
