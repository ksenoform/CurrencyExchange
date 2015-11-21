package com.luxoft.cantor.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class HelloControllerTest {
    @Mock Model model;
    
    @Test
    public void shouldReturnWelcomeMessage() {
        HelloController controller = new HelloController();
        assertEquals("welcome", controller.helloMessage(model));
    }

}
