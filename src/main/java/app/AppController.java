package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private final BuildProperties buildProperties;

    @Autowired
    public AppController(BuildProperties buildProperties){
        this.buildProperties = buildProperties;
    }

    @GetMapping(path = "/version")
    public ResponseEntity getAllVersions(){
        return new ResponseEntity(buildProperties.getVersion(), HttpStatus.OK);
    }
}
