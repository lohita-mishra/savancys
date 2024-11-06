package com.savancys.contactus.web.util;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "sapnexx", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "com.savancys.contactus.web.util.ContactUsEmailConfig")
public interface ContactUsEmailConfig {
	@Meta.AD(required = false)
	String recipientName();

	@Meta.AD(required = false)
	String toEmailAddress();

	@Meta.AD(required = false)
	String fromEmailAddress();

	@Meta.AD(required = false)
	String subject();

	@Meta.AD(required = false)
	String body();

}
