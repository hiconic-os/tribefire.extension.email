package com.braintribe.model.email.service.reason;

import com.braintribe.gm.model.security.reason.AuthenticationFailure;
import com.braintribe.model.generic.annotation.meta.Description;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

@Description("Could not obtain an access token.")
public interface OAuthAuthenticationFailed extends AuthenticationFailure {
	EntityType<OAuthAuthenticationFailed> T = EntityTypes.T(OAuthAuthenticationFailed.class);
}
