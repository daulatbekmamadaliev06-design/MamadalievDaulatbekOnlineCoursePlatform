package kz.daulatbek.onlinecourseplatform.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MamadalievDaulatbekAsyncService {

    @Async
    public void sendRegistrationEmail(String email) {
        System.out.println("ASYNC EMAIL SENT TO: " + email);
    }

    @Async
    public void generateCourseReport() {
        System.out.println("ASYNC COURSE REPORT GENERATED");
    }

    @Async
    public void processUploadedFile(String fileName) {
        System.out.println("ASYNC FILE PROCESSED: " + fileName);
    }
}