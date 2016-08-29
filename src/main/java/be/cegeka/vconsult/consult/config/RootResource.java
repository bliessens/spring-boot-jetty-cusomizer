package be.cegeka.vconsult.consult.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/v1")
public class RootResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getInformation() {
        return ResponseEntity.ok("Application Up and Running " + LocalDateTime.now().toString());
    }

}
