package test.controllers;

import hello.controllers.UserController;
import hello.entities.User;
import hello.error.NotFoundException;
import hello.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.*;

public class UserControllerTest {
    @Id
    public ObjectId _id;

    @Mock
    UserRepository repository;
    @InjectMocks
    UserController userController;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllUsers() {
        List<User> result = userController.getAllUsers();
        Assert.assertEquals(result.size(), 0, "Expect 0");
    }

    @Test(expectedExceptions = NotFoundException.class)
    public void testGetUserResponse() throws NotFoundException {
            ObjectId testId = ObjectId.get();
            ResponseEntity<User> response = userController.getUserById(testId);
            fail();
    }

    @Test
    public void testModifyUserById() {
        userController.modifyUserById(null, new User(null, null, null, null));
    }

    @Test
    public void testCreateUser(){
        ObjectId testId = ObjectId.get();
        ResponseEntity<User> response = userController.createUser(new User(testId, "test", "test", "test"));
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    public void testDeleteUser() {
        ObjectId testId = ObjectId.get();
        when(repository.findBy_id(any())).thenReturn(new User(testId, "firstName", "lastName", "age"));
        userController.deleteUser(testId);
    }
}