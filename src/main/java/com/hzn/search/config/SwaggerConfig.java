package com.hzn.search.config;

import com.hzn.search.enums.Status;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.IntegerSchema;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 *
 * @author hzn
 * @date 2/20/24
 */
@Configuration
public class SwaggerConfig {
	@Bean
	public GroupedOpenApi openApiV1 () {
		return GroupedOpenApi.builder ().group ("v1-definition").pathsToMatch ("/api/v1/**")
		                     .addOpenApiCustomizer (openApi -> openApi.info (new Info ().title ("Search API").description ("Search API 명세").version ("v1.0")))
		                     .addOperationCustomizer (operationCustomizer ()).build ();
	}

	@Bean
	public GroupedOpenApi openApiV2 () {
		return GroupedOpenApi.builder ().group ("v2-definition").pathsToMatch ("/api/v2/**")
		                     .addOpenApiCustomizer (openApi -> openApi.info (new Info ().title ("Search API").description ("Search API 명세").version ("v2.0")))
		                     .addOperationCustomizer (operationCustomizer ()).build ();
	}

//	@Bean
//	public OpenAPI openAPI () {
//		return new OpenAPI ().addServersItem (new Server ().url ("/"))
//		                     .addSecurityItem (new SecurityRequirement ().addList (SECURITY_SCHEME_NAME))
//		                     .components (new Components ().addSecuritySchemes (SECURITY_SCHEME_NAME,
//		                                                                        new SecurityScheme ().name (SECURITY_SCHEME_NAME)
//		                                                                                             .type (SecurityScheme.Type.HTTP)
//		                                                                                             .scheme ("bearer").bearerFormat ("JWT")))
//                             .info (new Info ().title ("Search API").description ("Search API 명세").version ("v1.0"));
//	}

	private OperationCustomizer operationCustomizer () {
		return (operation, handlerMethod) -> {
			// 공통 응답 생성
			ApiResponses responses = operation.getResponses ();
			for (Status status : Status.values ()) {
				int code = status.getCode ();

				Schema<?> commonResponse;
				if (code == 200) {
					commonResponse = new Schema<> ().$ref ("CommonResponse");
				} else {
					commonResponse = new Schema<> ().type ("object").title ("공통 응답 객체");
					commonResponse.addProperty ("code", new IntegerSchema ().title ("응답 코드").example (String.valueOf (code)));
					commonResponse.addProperty ("message", new StringSchema ().title ("응답 메시지").example (status.getMessage ()));
				}

				responses.addApiResponse (String.valueOf (code), new ApiResponse ().description (status.getMessage ()).content (
						new Content ().addMediaType (org.springframework.http.MediaType.APPLICATION_JSON_VALUE, new MediaType ().schema (commonResponse))));
			}
			return operation;
		};
	}
}
