package test.controllers;

import hello.controllers.CustomController;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomControllerTest {
    CustomController customController = new CustomController();

    @Test
    public void testCustom() {
        String result = customController.custom();
        Assert.assertEquals(result, "custom");
    }
}