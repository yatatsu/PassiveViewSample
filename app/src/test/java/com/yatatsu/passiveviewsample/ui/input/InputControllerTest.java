package com.yatatsu.passiveviewsample.ui.input;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.*;

@RunWith(JUnit4.class)
public class InputControllerTest {

    private InputController controller;
    private InputScreen mockInputScreen;

    @Before
    public void setup() throws Exception {
        this.controller = new InputController();
        this.mockInputScreen = mock(InputScreen.class);
        controller.registerScreen(mockInputScreen);
    }

    @Test
    public void testValidUsername() throws Exception {
        controller.onSubmitEditText("abc");
        verify(mockInputScreen).hideError();
        verify(mockInputScreen).navigateToUserScreen("abc");
    }

    @Test
    public void testEmptyString() throws Exception {
        controller.onSubmitEditText("");
        verify(mockInputScreen).showError("input must not be empty.");
    }

    @Test
    public void testNotOneWord() throws Exception {
        controller.onSubmitEditText("one two");
        verify(mockInputScreen).showError("should be one word.");
    }
}