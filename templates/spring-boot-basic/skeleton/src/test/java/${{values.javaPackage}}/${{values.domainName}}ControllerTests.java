package ${{ values.groupId }};

import org.instancio.Instancio;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import ${{ values.groupId }}.domain.${{ values.domainName }};

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ${{ values.domainName }}ControllerTests {

    private static final String API_PATH = "${{values.apiPath}}";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void add() {
        ${{ values.domainName }} obj = restTemplate.postForObject(API_PATH, Instancio.create(${{ values.domainName }}.class), ${{ values.domainName }}.class);
        assertNotNull(obj);
        assertEquals(1, obj.getId());
    }

    @Test
    @Order(2)
    void findAll() {
        ${{ values.domainName }}[] objs = restTemplate.getForObject(API_PATH, ${{ values.domainName }}[].class);
        assertTrue(objs.length > 0);
    }

    @Test
    @Order(2)
    void findById() {
        ${{ values.domainName }} obj = restTemplate.getForObject(API_PATH + "/{id}", ${{ values.domainName }}.class, 1L);
        assertNotNull(obj);
        assertEquals(1, obj.getId());
    }

    @Test
    @Order(3)
    void delete() {
        restTemplate.delete(API_PATH + "/{id}", 1L);
        ${{ values.domainName }} obj = restTemplate.getForObject(API_PATH + "/{id}", ${{ values.domainName }}.class, 1L);
        assertNull(obj.getId());
    }

}