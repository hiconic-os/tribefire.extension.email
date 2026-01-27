package com.braintribe.model.email.service.msgraph;

import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

public interface MsGraphBody extends GenericEntity {

	EntityType<MsGraphBody> T = EntityTypes.T(MsGraphBody.class);

	String getContentType();
	void setContentType(String contentType);

	String getContent();
	void setContent(String content);

	static MsGraphBody ofText(String text) {
		MsGraphBody result = MsGraphBody.T.create();
		result.setContentType("Text");
		result.setContent(text);
		return result;
	}
	static MsGraphBody ofHtml(String html) {
		MsGraphBody result = MsGraphBody.T.create();
		result.setContentType("HTML");
		result.setContent(html);
		return result;
	}
}
