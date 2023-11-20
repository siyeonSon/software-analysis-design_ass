package info;

import static org.junit.jupiter.api.Assertions.*;

public class Information {
    private Integer id;
    private String name;

    @org.junit.jupiter.api.Test
    public void info(){
        id = null;   // insert your student ID (학번)
        name = null; // insert your name (이름) in Korean

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);

        assertNotNull(id);
        assertNotNull(name);
    }

}
