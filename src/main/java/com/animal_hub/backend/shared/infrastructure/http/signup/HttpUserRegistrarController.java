package com.animal_hub.backend.shared.infrastructure.http.signup;

import com.animal_hub.backend.shared.application.SignUpCommand;
import com.animal_hub.backend.shared.application.SignUpUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/signup")
public class HttpUserRegistrarController {

    private final SignUpUseCase signUpUseCase;

    public HttpUserRegistrarController(final SignUpUseCase signUpUseCase) {
        this.signUpUseCase = signUpUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> signUp(@RequestBody SignUpRequest signUpRequest) {
        signUpUseCase.execute(new SignUpCommand(signUpRequest.email(), signUpRequest.password(),signUpRequest.userRole().getUserType()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
