package takee.dev.swagger_springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @GetMapping("/getRequest")
    @Operation(summary = "ทดสอบ api get request", description = "Api จะตอบกลับเป็นคำว่า Hello Word")
    public String getMethodName() {
        return "Hello Word";
    }

    @PostMapping("/postRequest")
    @Operation(summary = "ทดสอบ api post request", description = "Api จะตอบกลับตามที่ได้ request")
    public PostModel postMethodName(@RequestBody PostModel request) {
        return new PostModel(1, request.firstname(), request.lastname());
    }

}
