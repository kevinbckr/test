package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-10T15:59:05.892Z[GMT]")
@RestController
public class SerializationApiController implements SerializationApi {

    private static final Logger log = LoggerFactory.getLogger(SerializationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public SerializationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Resource> generateSerializationByIds(@NotNull @Parameter(in = ParameterIn.QUERY, description = "The Asset Administration Shells' unique ids (BASE64-URL-encoded)" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "aasIds", required = true) List<String> aasIds,@NotNull @Parameter(in = ParameterIn.QUERY, description = "The Submodels' unique ids (BASE64-URL-encoded)" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "submodelIds", required = true) List<String> submodelIds,@NotNull @Parameter(in = ParameterIn.QUERY, description = "Include Concept Descriptions?" ,required=true,schema=@Schema( defaultValue="true")) @Valid @RequestParam(value = "includeConceptDescriptions", required = true, defaultValue="true") Boolean includeConceptDescriptions) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Resource>(objectMapper.readValue("\"\"", Resource.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Resource>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Resource>(HttpStatus.NOT_IMPLEMENTED);
    }

}
