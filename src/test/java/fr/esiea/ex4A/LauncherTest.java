package fr.esiea.ex4A;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LauncherTest {
    @Test
    void agifyClientTest(){
        Launcher mock = new Launcher();

        AgifyClient agifyClient = mock.agifyClient();

        assertNotNull(agifyClient);
    }

}
