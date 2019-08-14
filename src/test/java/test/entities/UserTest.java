package test.entities;

import hello.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {

    @Id
    public ObjectId _id;

    @Test
    void setup() {
        System.out.println("Setting up User test");
    }

    @Test
    void testUserFirstName(){
        System.out.println("Test FirstName");
        User userFirst = new User();
        userFirst.setFirstName("firstName");
        Assert.assertEquals(userFirst.getFirstName(), "firstName", "Expect firstName");
    }

    @Test
    void testUserLastName(){
        System.out.println("Test LastName");
        User userLast = new User();
        userLast.setLastName("lastName");
        Assert.assertEquals(userLast.getLastName(), "lastName", "Expect lastName");
    }

    @Test
    void testUserAge(){
        System.out.println("Test Age");
        User userAge = new User();
        userAge.setAge("0");
        Assert.assertEquals(userAge.getAge(), "0", "Expect 0");
    }
}