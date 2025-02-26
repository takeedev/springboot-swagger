package takee.dev.swagger_springboot;

import io.swagger.v3.oas.annotations.media.Schema;

public record PostModel(
    @Schema(example = "1") Integer id, 
    @Schema(example = "Sawat") String firstname,
    @Schema(example = "Champaine") String lastname) {
}
