// ============================================================================
// BRAINTRIBE TECHNOLOGY GMBH - www.braintribe.com
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2018 - All Rights Reserved
// It is strictly forbidden to copy, modify, distribute or use this code without written permission
// To this file the Braintribe License Agreement applies.
// ============================================================================

package com.braintribe.model.email.deployment.oauth;

import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.annotation.SelectiveInformation;
import com.braintribe.model.generic.annotation.meta.Confidential;
import com.braintribe.model.generic.annotation.meta.Name;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@SelectiveInformation("OAuth Credentials")
public interface OAuthCredentials extends GenericEntity {

	final EntityType<OAuthCredentials> T = EntityTypes.T(OAuthCredentials.class);

	@Name("Client ID")
	String getClientId();
	void setClientId(String clientId);

	@Confidential
	@Name("Client Secret")
	String getSecret();
	void setSecret(String secret);

	@Name("Scope")
	@Initializer("'https://graph.microsoft.com/.default'")
	String getScope();
	void setScope(String scope);

	@Name("Grant Type")
	@Initializer("'client_credentials'")
	String getGrantType();
	void setGrantType(String grantType);

}
