// ============================================================================
// BRAINTRIBE TECHNOLOGY GMBH - www.braintribe.com
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2018 - All Rights Reserved
// It is strictly forbidden to copy, modify, distribute or use this code without written permission
// To this file the Braintribe License Agreement applies.
// ============================================================================

package com.braintribe.model.email.deployment.connection;

import com.braintribe.model.email.deployment.oauth.OAuthCredentials;
import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.annotation.SelectiveInformation;
import com.braintribe.model.generic.annotation.meta.Name;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@SelectiveInformation("MS Graph Send Connector")
public interface MsGraphSendConnectorConfiguration extends SendConnectorConfiguration, OAuthCredentials {

	final EntityType<MsGraphSendConnectorConfiguration> T = EntityTypes.T(MsGraphSendConnectorConfiguration.class);

	@Name("Tenant ID")
	String getTenantId();
	void setTenantId(String tenantId);

	@Name("Send URL")
	@Initializer("'https://graph.microsoft.com/v1.0/users/${from}/sendMail'")
	String getSendUrl();
	void setSendUrl(String sendUrl);

	@Name("Token URL")
	@Initializer("'https://login.microsoftonline.com/${tenantId}/oauth2/v2.0/token'")
	String getTokenUrl();
	void setTokenUrl(String tokenUrl);
}
