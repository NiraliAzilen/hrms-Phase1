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

package com.hrms.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the EmployeeDesignation service. Represents a row in the &quot;HRMS_EmployeeDesignation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.hrms.model.impl.EmployeeDesignationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.hrms.model.impl.EmployeeDesignationImpl}.
 * </p>
 *
 * @author yashpalsinh
 * @see EmployeeDesignation
 * @see com.hrms.model.impl.EmployeeDesignationImpl
 * @see com.hrms.model.impl.EmployeeDesignationModelImpl
 * @generated
 */
public interface EmployeeDesignationModel extends BaseModel<EmployeeDesignation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee designation model instance should use the {@link EmployeeDesignation} interface instead.
	 */

	/**
	 * Returns the primary key of this employee designation.
	 *
	 * @return the primary key of this employee designation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee designation.
	 *
	 * @param primaryKey the primary key of this employee designation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee designation ID of this employee designation.
	 *
	 * @return the employee designation ID of this employee designation
	 */
	public long getEmployeeDesignationId();

	/**
	 * Sets the employee designation ID of this employee designation.
	 *
	 * @param employeeDesignationId the employee designation ID of this employee designation
	 */
	public void setEmployeeDesignationId(long employeeDesignationId);

	/**
	 * Returns the designation name of this employee designation.
	 *
	 * @return the designation name of this employee designation
	 */
	@AutoEscape
	public String getDesignationName();

	/**
	 * Sets the designation name of this employee designation.
	 *
	 * @param designationName the designation name of this employee designation
	 */
	public void setDesignationName(String designationName);

	/**
	 * Returns the status of this employee designation.
	 *
	 * @return the status of this employee designation
	 */
	public boolean getStatus();

	/**
	 * Returns <code>true</code> if this employee designation is status.
	 *
	 * @return <code>true</code> if this employee designation is status; <code>false</code> otherwise
	 */
	public boolean isStatus();

	/**
	 * Sets whether this employee designation is status.
	 *
	 * @param status the status of this employee designation
	 */
	public void setStatus(boolean status);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(EmployeeDesignation employeeDesignation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmployeeDesignation> toCacheModel();

	@Override
	public EmployeeDesignation toEscapedModel();

	@Override
	public EmployeeDesignation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}