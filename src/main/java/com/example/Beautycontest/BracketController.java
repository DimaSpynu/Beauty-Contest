package com.example.Beautycontest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BracketController {

    @PostMapping("/api/checkBrackets")
    public ResponseEntity<CheckBracketsResponse> checkBrackets(@RequestBody CheckBracketsRequest request) {
        try {
            String text = request.getText().trim();

            // Проверка на пустой текст
            if (text.isEmpty()) {
                return ResponseEntity.badRequest().body(new CheckBracketsResponse(false, "Empty text"));
            }

            // Проверка на правильность расстановки скобок с текстом
            if (checkBracketsWithText(text)) {
                return ResponseEntity.ok(new CheckBracketsResponse(true, null));
            } else {
                return ResponseEntity.ok(new CheckBracketsResponse(false, null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new CheckBracketsResponse(false, e.getMessage()));
        }
    }


    private boolean checkBracketsWithText(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

}