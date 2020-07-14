package com.mastercard.challenge;

import com.mastercard.challenge.services.MainService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by ysedn on Jul 13, 2020
 */
@SpringBootTest
public class MockitoMainServiceTest {

    @InjectMocks
    private MainService mainService;


    @Test
    public void testAreCitiesConnected() {
        mainService.setFilePath("src/test/resources/city-test.txt");

        assertTrue(mainService.areCitiesConnected("Dallas", "Houston"));
        assertTrue(mainService.areCitiesConnected("Boston", "Philadelphia"));
        assertFalse(mainService.areCitiesConnected("Boston", "Houston"));
        assertFalse(mainService.areCitiesConnected("", "Houston"));
        assertFalse(mainService.areCitiesConnected(null, "Boston"));
        assertFalse(mainService.areCitiesConnected(null, null));
    }


}
