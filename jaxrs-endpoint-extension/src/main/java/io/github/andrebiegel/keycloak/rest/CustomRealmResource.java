package io.github.andrebiegel.keycloak.rest;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.models.KeycloakSession;
import org.keycloak.services.managers.AppAuthManager;
import org.keycloak.services.managers.AuthenticationManager;

public class CustomRealmResource{

  private static final Logger LOGGER = Logger.getLogger(CustomRealmResource.class);

  private final KeycloakSession session;

  private final AuthenticationManager.AuthResult auth;

  public CustomRealmResource(KeycloakSession session) {
    this.session = session;
    this.auth = new AppAuthManager.BearerTokenAuthenticator(session).authenticate();
    
    LOGGER.info("loading Configuration from Environment ?");

  }

  @GET
  @Path("greetings/{message}")
  @NoCache
  @Produces(MediaType.APPLICATION_JSON)
  public Response provideJitsiToken(@PathParam("message") String message) {
    LOGGER.info("Custom Endpint triggered");
    //this.session.getProvider(clazz)
    return Response
        .ok(Json.createObjectBuilder().add("greets",message ).build())
        .build();
  }

}
