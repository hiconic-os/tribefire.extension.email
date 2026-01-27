package com.braintribe.model.email.service.msgraph;

import java.util.Set;

import com.braintribe.model.generic.GenericEntity;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

public interface MsGraphMessage extends GenericEntity {

	EntityType<MsGraphMessage> T = EntityTypes.T(MsGraphMessage.class);

	String getSubject();
	void setSubject(String subject);

	MsGraphBody getBody();
	void setBody(MsGraphBody body);

	MsGraphRecipient getFrom();
	void setFrom(MsGraphRecipient from);

	Set<MsGraphRecipient> getToRecipients();
	void setToRecipients(Set<MsGraphRecipient> toRecipients);

	Set<MsGraphRecipient> getCcRecipients();
	void setCcRecipients(Set<MsGraphRecipient> ccRecipients);

	Set<MsGraphRecipient> getBccRecipients();
	void setBccRecipients(Set<MsGraphRecipient> bccRecipients);

	Set<MsGraphRecipient> getReplyTo();
	void setReplyTo(Set<MsGraphRecipient> replyTo);

	Boolean getHasAttachments();
	void setHasAttachments(Boolean hasAttachments);

	String getInternetMessageId();
	void setInternetMessageId(String internetMessageId);

	Set<MsGraphRecipient> getReplyToReceipients();
	void setReplyToReceipients(Set<MsGraphRecipient> replyToRecipients);

	Set<MsGraphAttachment> getAttachments();
	void setAttachments(Set<MsGraphAttachment> attachments);
}
