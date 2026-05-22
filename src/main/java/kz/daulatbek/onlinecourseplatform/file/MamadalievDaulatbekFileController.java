package kz.daulatbek.onlinecourseplatform.file;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class MamadalievDaulatbekFileController {

    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public String uploadFile(
            @RequestPart("file")
            MultipartFile file
    ) {

        return "FILE UPLOADED: "
                + file.getOriginalFilename();
    }
}