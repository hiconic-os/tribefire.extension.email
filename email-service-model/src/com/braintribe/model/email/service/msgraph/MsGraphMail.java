package com.braintribe.model.email.service.msgraph;

import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

public interface MsGraphMail extends GenericEntity {

	EntityType<MsGraphMail> T = EntityTypes.T(MsGraphMail.class);

	MsGraphMessage getMessage();
	void setMessage(MsGraphMessage message);
}
