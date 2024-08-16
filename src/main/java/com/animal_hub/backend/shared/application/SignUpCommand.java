package com.animal_hub.backend.shared.application;

import java.util.UUID;

public record SignUpCommand(UUID userId, String email, String password, int userType) {
}
