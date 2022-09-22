package io.swagger.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.adminshell.aas.v3.model.ConceptDescription;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-10T15:59:05.892Z[GMT]")
@RestController
public class ConceptDescriptionsApiController implements ConceptDescriptionsApi {

    private static final Logger log = LoggerFactory.getLogger(ConceptDescriptionsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ConceptDescriptionsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
	public ResponseEntity<Void> deleteConceptDescriptionById(@Parameter(in = ParameterIn.PATH, description = "The Concept Description’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("cdIdentifier") String cdIdentifier) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
	public ResponseEntity<List<ConceptDescription>> getAllConceptDescriptions(@Parameter(in = ParameterIn.QUERY, description = "The Concept Description’s IdShort" ,schema=@Schema()) @Valid @RequestParam(value = "idShort", required = false) String idShort,@Parameter(in = ParameterIn.QUERY, description = "IsCaseOf reference (BASE64-URL-encoded)" ,schema=@Schema()) @Valid @RequestParam(value = "isCaseOf", required = false) String isCaseOf,@Parameter(in = ParameterIn.QUERY, description = "DataSpecification reference (BASE64-URL-encoded)" ,schema=@Schema()) @Valid @RequestParam(value = "dataSpecificationRef", required = false) String dataSpecificationRef) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<ConceptDescription>>(objectMapper.readValue("[ \"\", \"\" ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<ConceptDescription>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<ConceptDescription>>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
	public ResponseEntity<ConceptDescription> getConceptDescriptionById(@Parameter(in = ParameterIn.PATH, description = "The Concept Description’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("cdIdentifier") String cdIdentifier) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConceptDescription>(objectMapper.readValue("\"\"", ConceptDescription.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConceptDescription>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConceptDescription>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ConceptDescription> postConceptDescription(@Parameter(in = ParameterIn.DEFAULT, description = "Concept Description object", required=true, schema=@Schema()) @Valid @RequestBody ConceptDescription body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ConceptDescription>(objectMapper.readValue("\"\"", ConceptDescription.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ConceptDescription>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ConceptDescription>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> putConceptDescriptionById(@Parameter(in = ParameterIn.PATH, description = "The Concept Description’s unique id (BASE64-URL-encoded)", required=true, schema=@Schema()) @PathVariable("cdIdentifier") String cdIdentifier,@Parameter(in = ParameterIn.DEFAULT, description = "Concept Description object", required=true, schema=@Schema()) @Valid @RequestBody ConceptDescription body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
