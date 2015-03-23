/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.hrms.model.impl;

import com.hrms.model.EmployeeProof;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EmployeeProof in entity cache.
 *
 * @author yashpalsinh
 * @see EmployeeProof
 * @generated
 */
public class EmployeeProofCacheModel implements CacheModel<EmployeeProof>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{employeeProofId=");
		sb.append(employeeProofId);
		sb.append(", proofType=");
		sb.append(proofType);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmployeeProof toEntityModel() {
		EmployeeProofImpl employeeProofImpl = new EmployeeProofImpl();

		employeeProofImpl.setEmployeeProofId(employeeProofId);

		if (proofType == null) {
			employeeProofImpl.setProofType(StringPool.BLANK);
		}
		else {
			employeeProofImpl.setProofType(proofType);
		}

		employeeProofImpl.setStatus(status);

		employeeProofImpl.resetOriginalValues();

		return employeeProofImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeProofId = objectInput.readLong();
		proofType = objectInput.readUTF();
		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(employeeProofId);

		if (proofType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(proofType);
		}

		objectOutput.writeBoolean(status);
	}

	public long employeeProofId;
	public String proofType;
	public boolean status;
}