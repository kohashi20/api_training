package fr.esiea.ex4A;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AgifyClientTestIT {

        @ParameterizedTest
        @CsvSource({
            "Gavin,FR",
            "Shaw,FR",
            "Kiro,US",
            "Victor,FR"
        })
        void agifyClientTestIT(String name, String country){
            Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.agify.io/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

            AgifyClient agifyClient = retrofit.create(AgifyClient.class);

            try {
                Response<UserAgify> execute = agifyClient.getAgeOf(name, country).execute();
                UserAgify ageOf = execute.body();
                if(ageOf == null){
                    fail();
                    return;
                }
                assertEquals(ageOf.name, name);
                assertEquals(ageOf.country_id, country);
            } catch (IOException e) {
                e.printStackTrace();
                fail();
            }
        }
}
