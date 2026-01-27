package com.braintribe.model.email.service.msgraph;

import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

public interface MsGraphEmailAddress extends GenericEntity {

	EntityType<MsGraphEmailAddress> T = EntityTypes.T(MsGraphEmailAddress.class);

	String getAddress();
	void setAddress(String address);

}
