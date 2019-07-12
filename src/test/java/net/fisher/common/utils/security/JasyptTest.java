package net.fisher.common.utils.security;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.fisher.LouyiFastApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LouyiFastApplication.class)
public class JasyptTest {
	@Autowired
    private StringEncryptor stringEncryptor;
 
    @Test
    public void testEnvironmentProperties() {
        System.out.println(stringEncryptor.encrypt("xiaoxiao"));
    }
}
