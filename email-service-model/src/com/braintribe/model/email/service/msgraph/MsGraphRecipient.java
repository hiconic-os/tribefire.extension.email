package com.braintribe.model.email.service.msgraph;

import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

public interface MsGraphRecipient extends GenericEntity {

	EntityType<MsGraphRecipient> T = EntityTypes.T(MsGraphRecipient.class);

	MsGraphEmailAddress getEmailAddress();
	void setEmailAddress(MsGraphEmailAddress emailAddress);

	static MsGraphRecipient ofEmail(String emailAddress) {
		MsGraphRecipient result = MsGraphRecipient.T.create();
		MsGraphEmailAddress addr = MsGraphEmailAddress.T.create();
		addr.setAddress(emailAddress);
		result.setEmailAddress(addr);
		return result;
	}
}
