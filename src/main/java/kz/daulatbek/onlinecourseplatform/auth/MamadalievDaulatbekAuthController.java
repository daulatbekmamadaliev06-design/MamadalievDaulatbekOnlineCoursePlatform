package kz.daulatbek.onlinecourseplatform.auth;

import kz.daulatbek.onlinecourseplatform.dto.AuthResponse;
import kz.daulatbek.onlinecourseplatform.dto.LoginRequest;
import kz.daulatbek.onlinecourseplatform.dto.RegisterRequest;
import kz.daulatbek.onlinecourseplatform.entity.MamadalievDaulatbekUser;
import kz.daulatbek.onlinecourseplatform.repository.MamadalievDaulatbekUserRepository;
import kz.daulatbek.onlinecourseplatform.security.MamadalievDaulatbekJwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class MamadalievDaulatbekAuthController {

    private final MamadalievDaulatbekUserRepository userRepository;
    private final MamadalievDaulatbekJwtUtil jwtUtil;

    @PostMapping("/register")
    public MamadalievDaulatbekUser register(
            @RequestBody RegisterRequest request
    ) {

        MamadalievDaulatbekUser user =
                new MamadalievDaulatbekUser();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("STUDENT");

        return userRepository.save(user);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request
    ) {

        MamadalievDaulatbekUser user = userRepository.findAll()
                .stream()
                .filter(u ->
                        u.getEmail().equals(request.getEmail())
                                &&
                                u.getPassword().equals(request.getPassword())
                )
                .findFirst()
                .orElseThrow();

        String token =
                jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);
    }
}