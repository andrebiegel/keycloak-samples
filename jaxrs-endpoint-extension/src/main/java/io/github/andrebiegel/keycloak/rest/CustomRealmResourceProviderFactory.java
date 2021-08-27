package io.github.andrebiegel.keycloak.rest;

import org.keycloak.Config.Scope;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.services.resource.RealmResourceProviderFactory;

public class CustomRealmResourceProviderFactory implements RealmResourceProviderFactory {

    /**
     *is actually a kind of application path ! (base path of the app)
     */
    private static final String EXTENSION_ID = "custom-jaxrs";

    @Override
    public String getId() {
        return EXTENSION_ID;
    }

    @Override
    public RealmResourceProvider create(KeycloakSession session) {
        return new CustomRealmResourceProvider(session);
    }

    @Override
    public void init(Scope config) {
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
    }

    @Override
    public void close() {
    }

}
