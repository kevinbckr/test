package io.swagger.api;

import java.io.FileNotFoundException;
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

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.adminshell.aas.v3.model.AssetAdministrationShell;
import io.adminshell.aas.v3.model.AssetInformation;
import io.adminshell.aas.v3.model.IdentifierKeyValuePair;
import io.adminshell.aas.v3.model.Reference;
import io.adminshell.aas.v3.model.Submodel;
import io.adminshell.aas.v3.model.SubmodelElement;
import io.swagger.AASSimple;
import io.swagger.repositories.aas.AasRepository;
import io.swagger.repositories.aas.InMemoryAasRepository;
import io.swagger.repositories.aas.InMemoryAasServiceFactory;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-10T15:59:05.892Z[GMT]")
@RestController
public class ShellsApiController implements ShellsApi {

	private static final Logger log = LoggerFactory.getLogger(ShellsApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private final AasRepository aggregator;

	@org.springframework.beans.factory.annotation.Autowired
	public ShellsApiController(ObjectMapper objectMapper, HttpServletRequest request) throws StreamReadException, DatabindException, IOException {
		this.objectMapper = objectMapper;
		this.request = request;
		aggregator = new InMemoryAasRepository(new InMemoryAasServiceFactory());

		createDefaultShell(objectMapper);
	}

	private void createDefaultShell(ObjectMapper objectMapper) throws FileNotFoundException, IOException, StreamReadException, DatabindException {
		aggregator.createAAS(AASSimple.createAAS());
	}

	@Override
	public ResponseEntity<Void> deleteAssetAdministrationShellById(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Void> deleteSubmodelElementByPath(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "IdShort path to the submodel element (dot-separated)", required = true, schema = @Schema()) @PathVariable("idShortPath") String idShortPath) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Void> deleteSubmodelReferenceById(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<List<AssetAdministrationShell>> getAllAssetAdministrationShells(
			@Parameter(in = ParameterIn.QUERY, description = "The key-value-pair of an Asset identifier", schema = @Schema()) @Valid @RequestParam(value = "assetIds", required = false) List<IdentifierKeyValuePair> assetIds,
			@Parameter(in = ParameterIn.QUERY, description = "The Asset Administration Shell’s IdShort", schema = @Schema()) @Valid @RequestParam(value = "idShort", required = false) String idShort) {
		return new ResponseEntity<List<AssetAdministrationShell>>(aggregator.getAASList(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<SubmodelElement>> getAllSubmodelElements(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the structural depth of the respective resource content", schema = @Schema(allowableValues = { "deep",
					"core" }, defaultValue = "deep")) @Valid @RequestParam(value = "level", required = false, defaultValue = "deep") String level,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource", schema = @Schema(allowableValues = { "normal", "trimmed", "value", "reference",
					"path" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content,
			@Parameter(in = ParameterIn.QUERY, description = "Determines to which extent the resource is being serialized", schema = @Schema(allowableValues = { "withBlobValue",
					"withoutBlobValue" })) @Valid @RequestParam(value = "extent", required = false) String extent) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<SubmodelElement>>(objectMapper.readValue("[ \"\", \"\" ]", List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<SubmodelElement>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<SubmodelElement>>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<List<Reference>> getAllSubmodelReferences(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<List<Reference>>(objectMapper.readValue("[ \"\", \"\" ]", List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Reference>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Reference>>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<AssetAdministrationShell> getAssetAdministrationShell(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource", schema = @Schema(allowableValues = { "normal", "trimmed", "value", "reference",
					"path" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<AssetAdministrationShell>(objectMapper.readValue("\"\"", AssetAdministrationShell.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<AssetAdministrationShell>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<AssetAdministrationShell>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<AssetAdministrationShell> getAssetAdministrationShellById(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier) {
		return new ResponseEntity<AssetAdministrationShell>(aggregator.getAAS(aasIdentifier), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<AssetInformation> getAssetInformation(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<AssetInformation>(objectMapper.readValue("\"\"", AssetInformation.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<AssetInformation>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<AssetInformation>(HttpStatus.NOT_IMPLEMENTED);
	}

//	@Override
//	public ResponseEntity<OperationResult> getOperationAsyncResult(
//			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
//			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier,
//			@Parameter(in = ParameterIn.PATH, description = "IdShort path to the submodel element (dot-separated), in this case an operation", required = true, schema = @Schema()) @PathVariable("idShortPath") String idShortPath,
//			@Parameter(in = ParameterIn.PATH, description = "The returned handle id of an operation’s asynchronous invocation used to request the current state of the operation’s execution (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("handleId") String handleId,
//			@Parameter(in = ParameterIn.QUERY, description = "", schema = @Schema(allowableValues = { "normal",
//					"value" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content) {
//		String accept = request.getHeader("Accept");
//		if (accept != null && accept.contains("application/json")) {
//			try {
//				return new ResponseEntity<OperationResult>(objectMapper.readValue(
//						"{\n  \"outputArguments\" : [ null, null ],\n  \"requestId\" : \"requestId\",\n  \"executionResult\" : \"{}\",\n  \"executionState\" : \"Initiated\",\n  \"inoutputArguments\" : [ {\n    \"value\" : \"\"\n  }, {\n    \"value\" : \"\"\n  } ]\n}",
//						OperationResult.class), HttpStatus.NOT_IMPLEMENTED);
//			} catch (IOException e) {
//				log.error("Couldn't serialize response for content type application/json", e);
//				return new ResponseEntity<OperationResult>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}
//
//		return new ResponseEntity<OperationResult>(HttpStatus.NOT_IMPLEMENTED);
//	}

	@Override
	public ResponseEntity<Submodel> getSubmodel(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the structural depth of the respective resource content", schema = @Schema(allowableValues = { "deep",
					"core" }, defaultValue = "deep")) @Valid @RequestParam(value = "level", required = false, defaultValue = "deep") String level,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource", schema = @Schema(allowableValues = { "normal", "trimmed", "value", "reference",
					"path" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content,
			@Parameter(in = ParameterIn.QUERY, description = "Determines to which extent the resource is being serialized", schema = @Schema(allowableValues = { "withBlobValue",
					"withoutBlobValue" })) @Valid @RequestParam(value = "extent", required = false) String extent) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Submodel>(objectMapper.readValue("\"\"", Submodel.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Submodel>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Submodel>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<SubmodelElement> getSubmodelElementByPath(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "IdShort path to the submodel element (dot-separated)", required = true, schema = @Schema()) @PathVariable("idShortPath") String idShortPath,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the structural depth of the respective resource content", schema = @Schema(allowableValues = { "deep",
					"core" }, defaultValue = "deep")) @Valid @RequestParam(value = "level", required = false, defaultValue = "deep") String level,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource", schema = @Schema(allowableValues = { "normal", "trimmed", "value", "reference",
					"path" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content,
			@Parameter(in = ParameterIn.QUERY, description = "Determines to which extent the resource is being serialized", schema = @Schema(allowableValues = { "withBlobValue",
					"withoutBlobValue" })) @Valid @RequestParam(value = "extent", required = false) String extent) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SubmodelElement>(objectMapper.readValue("\"\"", SubmodelElement.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SubmodelElement>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SubmodelElement>(HttpStatus.NOT_IMPLEMENTED);
	}

//	@Override
//	public ResponseEntity<OperationResult> invokeOperation(
//			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
//			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier,
//			@Parameter(in = ParameterIn.PATH, description = "IdShort path to the submodel element (dot-separated), in this case an operation", required = true, schema = @Schema()) @PathVariable("idShortPath") String idShortPath,
//			@Parameter(in = ParameterIn.DEFAULT, description = "Operation request object", required = true, schema = @Schema()) @Valid @RequestBody OperationRequest body,
//			@Parameter(in = ParameterIn.QUERY, description = "Determines whether an operation invocation is performed asynchronously or synchronously", schema = @Schema(defaultValue = "false")) @Valid @RequestParam(value = "async", required = false, defaultValue = "false") Boolean async,
//			@Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource", schema = @Schema(allowableValues = { "normal", "trimmed", "value", "reference",
//					"path" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content) {
//		String accept = request.getHeader("Accept");
//		if (accept != null && accept.contains("application/json")) {
//			try {
//				return new ResponseEntity<OperationResult>(objectMapper.readValue(
//						"{\n  \"outputArguments\" : [ null, null ],\n  \"requestId\" : \"requestId\",\n  \"executionResult\" : \"{}\",\n  \"executionState\" : \"Initiated\",\n  \"inoutputArguments\" : [ {\n    \"value\" : \"\"\n  }, {\n    \"value\" : \"\"\n  } ]\n}",
//						OperationResult.class), HttpStatus.NOT_IMPLEMENTED);
//			} catch (IOException e) {
//				log.error("Couldn't serialize response for content type application/json", e);
//				return new ResponseEntity<OperationResult>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//		}
//
//		return new ResponseEntity<OperationResult>(HttpStatus.NOT_IMPLEMENTED);
//	}

	@Override
	public ResponseEntity<AssetAdministrationShell> postAssetAdministrationShell(
			@Parameter(in = ParameterIn.DEFAULT, description = "Asset Administration Shell object", required = true, schema = @Schema()) @Valid @RequestBody AssetAdministrationShell body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<AssetAdministrationShell>(objectMapper.readValue("\"\"", AssetAdministrationShell.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<AssetAdministrationShell>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<AssetAdministrationShell>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<SubmodelElement> postSubmodelElement(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier,
			@Parameter(in = ParameterIn.DEFAULT, description = "Requested submodel element", required = true, schema = @Schema()) @Valid @RequestBody SubmodelElement body,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the structural depth of the respective resource content", schema = @Schema(allowableValues = { "deep",
					"core" }, defaultValue = "deep")) @Valid @RequestParam(value = "level", required = false, defaultValue = "deep") String level,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource", schema = @Schema(allowableValues = { "normal", "trimmed", "value", "reference",
					"path" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content,
			@Parameter(in = ParameterIn.QUERY, description = "Determines to which extent the resource is being serialized", schema = @Schema(allowableValues = { "withBlobValue",
					"withoutBlobValue" })) @Valid @RequestParam(value = "extent", required = false) String extent) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SubmodelElement>(objectMapper.readValue("\"\"", SubmodelElement.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SubmodelElement>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SubmodelElement>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<SubmodelElement> postSubmodelElementByPath(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "IdShort path to the submodel element (dot-separated)", required = true, schema = @Schema()) @PathVariable("idShortPath") String idShortPath,
			@Parameter(in = ParameterIn.DEFAULT, description = "Requested submodel element", required = true, schema = @Schema()) @Valid @RequestBody SubmodelElement body,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the structural depth of the respective resource content", schema = @Schema(allowableValues = { "deep",
					"core" }, defaultValue = "deep")) @Valid @RequestParam(value = "level", required = false, defaultValue = "deep") String level,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource", schema = @Schema(allowableValues = { "normal", "trimmed", "value", "reference",
					"path" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content,
			@Parameter(in = ParameterIn.QUERY, description = "Determines to which extent the resource is being serialized", schema = @Schema(allowableValues = { "withBlobValue",
					"withoutBlobValue" })) @Valid @RequestParam(value = "extent", required = false) String extent) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<SubmodelElement>(objectMapper.readValue("\"\"", SubmodelElement.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<SubmodelElement>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<SubmodelElement>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Reference> postSubmodelReference(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.DEFAULT, description = "Reference to the Submodel", required = true, schema = @Schema()) @Valid @RequestBody Reference body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				return new ResponseEntity<Reference>(objectMapper.readValue("\"\"", Reference.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (IOException e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<Reference>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<Reference>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Void> putAssetAdministrationShell(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.DEFAULT, description = "Asset Administration Shell object", required = true, schema = @Schema()) @Valid @RequestBody AssetAdministrationShell body,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource", schema = @Schema(allowableValues = { "normal", "trimmed", "value", "reference",
					"path" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Void> putAssetAdministrationShellById(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.DEFAULT, description = "Asset Administration Shell object", required = true, schema = @Schema()) @Valid @RequestBody AssetAdministrationShell body) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Void> putAssetInformation(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.DEFAULT, description = "Asset Information object", required = true, schema = @Schema()) @Valid @RequestBody AssetInformation body) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Void> putSubmodel(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier,
			@Parameter(in = ParameterIn.DEFAULT, description = "Submodel object", required = true, schema = @Schema()) @Valid @RequestBody Submodel body,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the structural depth of the respective resource content", schema = @Schema(allowableValues = { "deep",
					"core" }, defaultValue = "deep")) @Valid @RequestParam(value = "level", required = false, defaultValue = "deep") String level,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource", schema = @Schema(allowableValues = { "normal", "trimmed", "value", "reference",
					"path" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content,
			@Parameter(in = ParameterIn.QUERY, description = "Determines to which extent the resource is being serialized", schema = @Schema(allowableValues = { "withBlobValue",
					"withoutBlobValue" })) @Valid @RequestParam(value = "extent", required = false) String extent) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<Void> putSubmodelElementByPath(
			@Parameter(in = ParameterIn.PATH, description = "The Asset Administration Shell’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("aasIdentifier") String aasIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "The Submodel’s unique id (BASE64-URL-encoded)", required = true, schema = @Schema()) @PathVariable("submodelIdentifier") String submodelIdentifier,
			@Parameter(in = ParameterIn.PATH, description = "IdShort path to the submodel element (dot-separated)", required = true, schema = @Schema()) @PathVariable("idShortPath") String idShortPath,
			@Parameter(in = ParameterIn.DEFAULT, description = "Requested submodel element", required = true, schema = @Schema()) @Valid @RequestBody SubmodelElement body,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the structural depth of the respective resource content", schema = @Schema(allowableValues = { "deep",
					"core" }, defaultValue = "deep")) @Valid @RequestParam(value = "level", required = false, defaultValue = "deep") String level,
			@Parameter(in = ParameterIn.QUERY, description = "Determines the request or response kind of the resource", schema = @Schema(allowableValues = { "normal", "trimmed", "value", "reference",
					"path" }, defaultValue = "normal")) @Valid @RequestParam(value = "content", required = false, defaultValue = "normal") String content,
			@Parameter(in = ParameterIn.QUERY, description = "Determines to which extent the resource is being serialized", schema = @Schema(allowableValues = { "withBlobValue",
					"withoutBlobValue" })) @Valid @RequestParam(value = "extent", required = false) String extent) {
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}
