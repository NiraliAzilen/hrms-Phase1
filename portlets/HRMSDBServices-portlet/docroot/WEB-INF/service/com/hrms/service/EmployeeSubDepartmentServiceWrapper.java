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

package com.hrms.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeSubDepartmentService}.
 *
 * @author yashpalsinh
 * @see EmployeeSubDepartmentService
 * @generated
 */
public class EmployeeSubDepartmentServiceWrapper
	implements EmployeeSubDepartmentService,
		ServiceWrapper<EmployeeSubDepartmentService> {
	public EmployeeSubDepartmentServiceWrapper(
		EmployeeSubDepartmentService employeeSubDepartmentService) {
		_employeeSubDepartmentService = employeeSubDepartmentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _employeeSubDepartmentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_employeeSubDepartmentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _employeeSubDepartmentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmployeeSubDepartmentService getWrappedEmployeeSubDepartmentService() {
		return _employeeSubDepartmentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmployeeSubDepartmentService(
		EmployeeSubDepartmentService employeeSubDepartmentService) {
		_employeeSubDepartmentService = employeeSubDepartmentService;
	}

	@Override
	public EmployeeSubDepartmentService getWrappedService() {
		return _employeeSubDepartmentService;
	}

	@Override
	public void setWrappedService(
		EmployeeSubDepartmentService employeeSubDepartmentService) {
		_employeeSubDepartmentService = employeeSubDepartmentService;
	}

	private EmployeeSubDepartmentService _employeeSubDepartmentService;
}