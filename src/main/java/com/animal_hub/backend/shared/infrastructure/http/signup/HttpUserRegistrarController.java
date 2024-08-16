package com.animal_hub.backend.shared.infrastructure.http.signup;

import com.animal_hub.backend.shared.application.SignUpCommand;
import com.animal_hub.backend.shared.application.SignUpUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class HttpUserRegistrarController {

    private final SignUpUseCase signUpUseCase;

    public HttpUserRegistrarController(final SignUpUseCase signUpUseCase) {
        this.signUpUseCase = signUpUseCase;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest signUpRequest) {
        signUpUseCase.execute(new SignUpCommand(UUID.fromString(signUpRequest.userId()), signUpRequest.email(), signUpRequest.password(),signUpRequest.userRole().getUserType()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
