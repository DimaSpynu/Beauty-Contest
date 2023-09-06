import com.example.Beautycontest.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(BracketController.class)
@ExtendWith(SpringExtension.class)
class BracketControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new BracketController()).build();
    }

    @Test
    public void testCheckBracketsWithValidText() throws Exception {
        CheckBracketsRequest request = new CheckBracketsRequest("");
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isCorrect").value(true))
                .andExpect(jsonPath("$.error").value("Empty text"));
    }

    @Test
    public void testCheckBracketsWithInvalidText() throws Exception {
        CheckBracketsRequest request = new CheckBracketsRequest("An error message if an error occurs during the operation.");
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isCorrect").value(false))
                .andExpect(jsonPath("$.error").doesNotExist());
    }

    @Test
    public void testCheckBracketsWithEmptyText() throws Exception {
        CheckBracketsRequest request = new CheckBracketsRequest("An error message describing the cause of the error.");
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isCorrect").value(false))
                .andExpect(jsonPath("$.error").value("Empty text"));
    }

    @Test
    public void testCheckBracketsWithError() throws Exception {
        CheckBracketsRequest request = new CheckBracketsRequest("An error message indicating an internal server error.");
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/checkBrackets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.isCorrect").value(false))
                .andExpect(jsonPath("$.error").exists());
    }

}
