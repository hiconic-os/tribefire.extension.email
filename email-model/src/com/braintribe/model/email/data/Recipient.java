// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
package com.braintribe.model.email.data;

import com.braintribe.model.generic.annotation.SelectiveInformation;
import com.braintribe.model.generic.reflection.EntityType;
import com.braintribe.model.generic.reflection.EntityTypes;

/**
 *
 */
@SelectiveInformation("${eMailAddress}")
public interface Recipient extends HasEmailAddress {

	final EntityType<Recipient> T = EntityTypes.T(Recipient.class);

	/**
	 * @deprecated use {@link #create(String)} instead
	 */
	@Deprecated
	static Recipient getRecipient(String eMailAddress) {
		return create(eMailAddress);
	}
	
	static Recipient create(String eMailAddress) {
		Recipient recipient = Recipient.T.create();
		recipient.setEMailAddress(eMailAddress);
		return recipient;
	}

}
