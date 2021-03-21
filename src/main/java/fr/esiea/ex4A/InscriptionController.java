package fr.esiea.ex4A;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InscriptionController {

    @PostMapping(value = "api/inscription", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void inscription(@RequestBody UserInfo userinfo) {
        System.out.println(userinfo.userEmail);
        System.out.println(userinfo.userName);
        System.out.println((userinfo.userTweeter));
        System.out.println(userinfo.userCountry);
        System.out.println(userinfo.userSex);
        System.out.println(userinfo.userSexPref);
    }
    @GetMapping(value = "api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Match> getMatches(String name, String country) {
        return List.of(
            new Match("machin", "machin45"),
            new Match("truc", "trucbidule")
        );
    }
}
