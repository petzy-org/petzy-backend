package com.animal_hub.backend.shared.infrastructure.http.signup;

import com.animal_hub.backend.shared.application.SignUpCommand;
import com.animal_hub.backend.shared.application.SignUpUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.hamcrest.Matchers.any;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;

@SpringBootTest
@AutoConfigureMockMvc
class HttpUserRegistrarControllerTest {

    @Autowired
    private MockMvc mvc;

    @SpyBean
    private SignUpUseCase signUpUseCase;

    @Test
    public void test() throws Exception {
        doNothing().when(signUpUseCase).execute(any());

        mvc.perform(MockMvcRequestBuilders.post("/signup")
                .content(asJsonString(new SignUpRequest("1d8a9faa-8cbd-4935-8d1a-75e0152d6401", "user_mail@gmail.com", "1234abcd", "1234abcd", UserRole.SHELTER)))
                .contentType(MediaType.APPLICATION_JSON)
        );

        Mockito.verify(signUpUseCase, times(1)).execute(eq(new SignUpCommand(UUID.fromString("1d8a9faa-8cbd-4935-8d1a-75e0152d6401"), "user_mail@gmail.com", "1234abcd", 1)));
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}