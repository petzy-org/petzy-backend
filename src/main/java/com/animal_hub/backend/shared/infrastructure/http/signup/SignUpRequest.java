package com.animal_hub.backend.shared.infrastructure.http.signup;

public record SignUpRequest(String email, String password, UserRole userRole) {
}

