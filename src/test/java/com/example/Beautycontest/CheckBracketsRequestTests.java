package com.example.Beautycontest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckBracketsRequestTests {

    @Test
    public void testGetSetText() {
        CheckBracketsRequest request = new CheckBracketsRequest("An error message describing the cause of the error.");

        String text = request.getText();
        if (text != null) {
            String trimmedText = text.trim();
            request.setText("This is a test");
        } else {

            assertEquals("This is a test", request.getText());
        }
    }
}
