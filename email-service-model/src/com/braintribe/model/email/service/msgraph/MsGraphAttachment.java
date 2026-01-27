package com.braintribe.model.email.service.msgraph;

import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.annotation.Initializer;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

public interface MsGraphAttachment extends GenericEntity {

	EntityType<MsGraphAttachment> T = EntityTypes.T(MsGraphAttachment.class);

	@Initializer("'#microsoft.graph.fileAttachment'")
	String getAttachmentDataType();
	void setAttachmentDataType(String attachmentDataType);

	String getName();
	void setName(String name);

	String getContentType();
	void setContentType(String contentType);

	String getContentBytes();
	void setContentBytes(String contentBytes);

	Boolean getIsInline();
	void setIsInline(Boolean isInline);

	String getContentId();
	void setContentId(String contentId);
}
