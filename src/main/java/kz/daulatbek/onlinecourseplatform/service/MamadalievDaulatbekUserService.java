package kz.daulatbek.onlinecourseplatform.service;

import kz.daulatbek.onlinecourseplatform.entity.MamadalievDaulatbekUser;
import kz.daulatbek.onlinecourseplatform.repository.MamadalievDaulatbekUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MamadalievDaulatbekUserService {

    private final MamadalievDaulatbekUserRepository userRepository;

    public Page<MamadalievDaulatbekUser> getAllUsers(
            Pageable pageable
    ) {

        return userRepository.findAll(pageable);
    }

    public MamadalievDaulatbekUser createUser(
            MamadalievDaulatbekUser user
    ) {

        return userRepository.save(user);
    }
}