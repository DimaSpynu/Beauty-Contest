package com.example.Beautycontest;

import com.example.Beautycontest.CheckBracketsResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckBracketsResponseTests {

    @Test
    public void testGetSetIsCorrect() {
        CheckBracketsResponse response = new CheckBracketsResponse(true, null);
        response.setCorrect(false);
        assertFalse(response.getCorrect());
    }

    @Test
    public void testGetSetError() {
        CheckBracketsResponse response = new CheckBracketsResponse(true, "");
        response.setError("Invalid brackets");

        assertEquals("Invalid brackets", response.getError());
    }
}