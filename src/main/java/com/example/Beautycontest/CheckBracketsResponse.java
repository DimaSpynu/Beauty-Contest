package com.example.Beautycontest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckBracketsResponse {

    private boolean isCorrect;
    private String error;

    public boolean getCorrect() {
        return false;
    }
}