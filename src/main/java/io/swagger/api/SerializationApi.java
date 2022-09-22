/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.29).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-10T15:59:05.892Z[GMT]")
@Validated
public interface SerializationApi {

    @Operation(summary = "Returns an appropriate serialization based on the specified format (see SerializationFormat)", description = "", tags={ "Asset Administration Shell Repository" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Requested serialization based on SerializationFormat", content = @Content(mediaType = "application/asset-administration-shell-package+xml", schema = @Schema(implementation = Resource.class))) })
    @RequestMapping(value = "/serialization",
        produces = { "application/asset-administration-shell-package+xml", "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<Resource> generateSerializationByIds(@NotNull @Parameter(in = ParameterIn.QUERY, description = "The Asset Administration Shells' unique ids (BASE64-URL-encoded)" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "aasIds", required = true) List<String> aasIds, @NotNull @Parameter(in = ParameterIn.QUERY, description = "The Submodels' unique ids (BASE64-URL-encoded)" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "submodelIds", required = true) List<String> submodelIds, @NotNull @Parameter(in = ParameterIn.QUERY, description = "Include Concept Descriptions?" ,required=true,schema=@Schema( defaultValue="true")) @Valid @RequestParam(value = "includeConceptDescriptions", required = true, defaultValue="true") Boolean includeConceptDescriptions);

}

