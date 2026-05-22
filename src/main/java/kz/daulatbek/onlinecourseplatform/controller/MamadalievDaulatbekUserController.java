package kz.daulatbek.onlinecourseplatform.controller;

import jakarta.validation.Valid;
import kz.daulatbek.onlinecourseplatform.entity.MamadalievDaulatbekUser;
import kz.daulatbek.onlinecourseplatform.service.MamadalievDaulatbekUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class MamadalievDaulatbekUserController {

    private final MamadalievDaulatbekUserService userService;

    @GetMapping
    public Page<MamadalievDaulatbekUser> getAllUsers(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size
    ) {

        return userService.getAllUsers(
                PageRequest.of(page, size)
        );
    }

    @PostMapping
    public MamadalievDaulatbekUser createUser(

            @Valid
            @RequestBody
            MamadalievDaulatbekUser user
    ) {

        return userService.createUser(user);
    }
}