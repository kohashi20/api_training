package fr.esiea.ex4A;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoTest1 {
    @ParameterizedTest
    @ValueSource(strings = {"{\"userEmail\":\"laurent@esiea.fr\",\"userName\":\"Laurent\",\"userTweeter\":\"Lololalali\",\"userCountry\":\"FR\",\"userSex\":\"M\",\"userSexPref\":\"F\"}"
    })
    void userJsonTest(String json){
        try {
            UserInfo userInfo = new ObjectMapper().readValue(json, UserInfo.class);
            System.out.println(userInfo.toString());
            Assertions.assertTrue(json.contains(userInfo.userCountry));
            Assertions.assertTrue(json.contains(userInfo.userEmail));
            Assertions.assertTrue(json.contains(userInfo.userName));
            Assertions.assertTrue(json.contains(userInfo.userTweeter));
            Assertions.assertTrue(json.contains(userInfo.userSex));
            Assertions.assertTrue(json.contains(userInfo.userSexPref));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            Assertions.fail();
        }
    }
}
