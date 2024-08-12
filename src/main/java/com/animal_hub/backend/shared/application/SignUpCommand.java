package com.animal_hub.backend.shared.application;

public record SignUpCommand(String email, String password, int userType) {
}
