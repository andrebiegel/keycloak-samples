package io.github.andrebiegel.keycloak.rest;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

public class CustomRealmResourceProvider implements RealmResourceProvider {

	private KeycloakSession session;

	public CustomRealmResourceProvider(KeycloakSession session) {
		this.session = session;
	}

	@Override
	public void close() {
	}

	@Override
	public Object getResource() {
		return new CustomRealmResource(session);
	}

}
