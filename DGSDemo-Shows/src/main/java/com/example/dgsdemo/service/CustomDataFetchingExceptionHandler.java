package com.example.dgsdemo.service;

import com.netflix.graphql.dgs.exceptions.DefaultDataFetcherExceptionHandler;
import com.netflix.graphql.types.errors.TypedGraphQLError;
import graphql.GraphQLError;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CustomDataFetchingExceptionHandler implements DataFetcherExceptionHandler {
  private final DefaultDataFetcherExceptionHandler defaultHandler = new DefaultDataFetcherExceptionHandler();

  @Override
  public DataFetcherExceptionHandlerResult onException(
      DataFetcherExceptionHandlerParameters handlerParameters) {
    if(handlerParameters.getException() instanceof IllegalArgumentException) {
      Map<String, Object> debugInfo = new HashMap<>();
      debugInfo.put("somefield", "somevalue");

      GraphQLError graphqlError = TypedGraphQLError.INTERNAL.message("This custom thing went wrong!")
          .debugInfo(debugInfo)
          .path(handlerParameters.getPath()).build();

      return DataFetcherExceptionHandlerResult.newResult()
          .error(graphqlError)
          .build();
    } else {
      return defaultHandler.onException(handlerParameters);
    }
  }
}
