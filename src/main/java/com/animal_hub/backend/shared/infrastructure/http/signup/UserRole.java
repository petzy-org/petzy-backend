package com.animal_hub.backend.shared.infrastructure.http.signup;

public enum UserRole{
    SHELTER(1),
    ADOPTER(2);

    private final int userType;

    UserRole(int userType) {
        this.userType = userType;
    }

    public int getUserType() {
        return userType;
    }
}
