package com.animal_hub.backend.shared.infrastructure.http.signup;

import java.util.UUID;

public record SignUpRequest(String userId, String email, String password, String validatedPassword, UserRole userRole) {
}

