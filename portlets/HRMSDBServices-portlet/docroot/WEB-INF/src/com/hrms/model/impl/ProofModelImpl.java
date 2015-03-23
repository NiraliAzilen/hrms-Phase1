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

import com.hrms.model.Proof;
import com.hrms.model.ProofModel;
import com.hrms.model.ProofSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Proof service. Represents a row in the &quot;HRMS_Proof&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.hrms.model.ProofModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProofImpl}.
 * </p>
 *
 * @author yashpalsinh
 * @see ProofImpl
 * @see com.hrms.model.Proof
 * @see com.hrms.model.ProofModel
 * @generated
 */
@JSON(strict = true)
public class ProofModelImpl extends BaseModelImpl<Proof> implements ProofModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a proof model instance should use the {@link com.hrms.model.Proof} interface instead.
	 */
	public static final String TABLE_NAME = "HRMS_Proof";
	public static final Object[][] TABLE_COLUMNS = {
			{ "proofId", Types.BIGINT },
			{ "proofType", Types.VARCHAR },
			{ "status", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table HRMS_Proof (proofId LONG not null primary key,proofType VARCHAR(75) null,status BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table HRMS_Proof";
	public static final String ORDER_BY_JPQL = " ORDER BY proof.proofId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY HRMS_Proof.proofId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.hrms.model.Proof"), true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.hrms.model.Proof"), true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Proof toModel(ProofSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Proof model = new ProofImpl();

		model.setProofId(soapModel.getProofId());
		model.setProofType(soapModel.getProofType());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Proof> toModels(ProofSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Proof> models = new ArrayList<Proof>(soapModels.length);

		for (ProofSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.hrms.model.Proof"));

	public ProofModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _proofId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProofId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _proofId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Proof.class;
	}

	@Override
	public String getModelClassName() {
		return Proof.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("proofId", getProofId());
		attributes.put("proofType", getProofType());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long proofId = (Long)attributes.get("proofId");

		if (proofId != null) {
			setProofId(proofId);
		}

		String proofType = (String)attributes.get("proofType");

		if (proofType != null) {
			setProofType(proofType);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@JSON
	@Override
	public long getProofId() {
		return _proofId;
	}

	@Override
	public void setProofId(long proofId) {
		_proofId = proofId;
	}

	@JSON
	@Override
	public String getProofType() {
		if (_proofType == null) {
			return StringPool.BLANK;
		}
		else {
			return _proofType;
		}
	}

	@Override
	public void setProofType(String proofType) {
		_proofType = proofType;
	}

	@JSON
	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Proof.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Proof toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Proof)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProofImpl proofImpl = new ProofImpl();

		proofImpl.setProofId(getProofId());
		proofImpl.setProofType(getProofType());
		proofImpl.setStatus(getStatus());

		proofImpl.resetOriginalValues();

		return proofImpl;
	}

	@Override
	public int compareTo(Proof proof) {
		long primaryKey = proof.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Proof)) {
			return false;
		}

		Proof proof = (Proof)obj;

		long primaryKey = proof.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Proof> toCacheModel() {
		ProofCacheModel proofCacheModel = new ProofCacheModel();

		proofCacheModel.proofId = getProofId();

		proofCacheModel.proofType = getProofType();

		String proofType = proofCacheModel.proofType;

		if ((proofType != null) && (proofType.length() == 0)) {
			proofCacheModel.proofType = null;
		}

		proofCacheModel.status = getStatus();

		return proofCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{proofId=");
		sb.append(getProofId());
		sb.append(", proofType=");
		sb.append(getProofType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.hrms.model.Proof");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>proofId</column-name><column-value><![CDATA[");
		sb.append(getProofId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>proofType</column-name><column-value><![CDATA[");
		sb.append(getProofType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Proof.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Proof.class };
	private long _proofId;
	private String _proofType;
	private boolean _status;
	private Proof _escapedModel;
}