package in.snm.personal_service.info;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class InfoController {
    
    @GetMapping("/info")
    public String hello() {
        return"Assalam!";
    }
}
