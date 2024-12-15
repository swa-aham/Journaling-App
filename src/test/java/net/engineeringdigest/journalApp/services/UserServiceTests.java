package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest
    @ValueSource(strings = {
            "Soham",
            "admin",
            "wrong"
    })
    public void testFindByUserName(String name) {
        assertNotNull(userRepository.findByUserName(name));
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,3,5",
    })
    public void solve(int a, int b, int c) {
        assertEquals(c, a+b);
    }
}
