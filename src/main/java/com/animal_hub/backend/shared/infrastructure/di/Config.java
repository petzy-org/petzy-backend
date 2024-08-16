package com.animal_hub.backend.shared.infrastructure.di;

import com.animal_hub.backend.shared.application.SignUpUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SignUpUseCase signUpUseCase() {
        return new SignUpUseCase();
    }
}
