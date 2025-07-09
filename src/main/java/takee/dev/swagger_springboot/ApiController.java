package takee.dev.swagger_springboot;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "Api Controller", description = "Learning Swagger")
public class ApiController {

    @GetMapping("/getRequest")
    @Operation(summary = "ทดสอบ api get request", description = "Api จะตอบกลับเป็นคำว่า Hello Word")
    public String getMethodName() {
        return "Hello Word";
    }

    @PostMapping("/postRequest")
    @Operation(summary = "ทดสอบ api post request", description = "Api จะตอบกลับตามที่ได้ request")
    public PostModel postMethodName(
            @RequestBody PostModel request)
    {
        return new PostModel(1, request.firstname(), request.lastname());
    }

    @PostMapping("/postRequestHeader")
    @Operation(summary = "ทดสอบ api post request header", description = "Api จะตอบกลับตามที่ได้ request")
    public PostModel postMethodHeader(
            @RequestHeader("X-Custom-Header") String customHeader ,
            @RequestBody PostModel request)
    {
        return new PostModel(1, request.firstname(), request.lastname());
    }

    @PostMapping("/postRequestParam")
    @Operation(summary = "ทดสอบ api post request param", description = "Api request param")
    public PostModel postRequstParam(
            @RequestParam(name = "firstname", required = true) String firstname,
            @RequestParam(name = "lastname", required = true) String lastname)
    {
        return new PostModel(1,firstname,lastname);
    }

}
