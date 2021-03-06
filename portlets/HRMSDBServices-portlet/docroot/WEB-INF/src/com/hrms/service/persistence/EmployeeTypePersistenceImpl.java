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

package com.hrms.service.persistence;

import com.hrms.NoSuchEmployeeTypeException;

import com.hrms.model.EmployeeType;
import com.hrms.model.impl.EmployeeTypeImpl;
import com.hrms.model.impl.EmployeeTypeModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the employee type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author yashpalsinh
 * @see EmployeeTypePersistence
 * @see EmployeeTypeUtil
 * @generated
 */
public class EmployeeTypePersistenceImpl extends BasePersistenceImpl<EmployeeType>
	implements EmployeeTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmployeeTypeUtil} to access the employee type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmployeeTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeModelImpl.FINDER_CACHE_ENABLED, EmployeeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeModelImpl.FINDER_CACHE_ENABLED, EmployeeTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmployeeTypePersistenceImpl() {
		setModelClass(EmployeeType.class);
	}

	/**
	 * Caches the employee type in the entity cache if it is enabled.
	 *
	 * @param employeeType the employee type
	 */
	@Override
	public void cacheResult(EmployeeType employeeType) {
		EntityCacheUtil.putResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeImpl.class, employeeType.getPrimaryKey(), employeeType);

		employeeType.resetOriginalValues();
	}

	/**
	 * Caches the employee types in the entity cache if it is enabled.
	 *
	 * @param employeeTypes the employee types
	 */
	@Override
	public void cacheResult(List<EmployeeType> employeeTypes) {
		for (EmployeeType employeeType : employeeTypes) {
			if (EntityCacheUtil.getResult(
						EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeTypeImpl.class, employeeType.getPrimaryKey()) == null) {
				cacheResult(employeeType);
			}
			else {
				employeeType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employee types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmployeeTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmployeeTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeType employeeType) {
		EntityCacheUtil.removeResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeImpl.class, employeeType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmployeeType> employeeTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmployeeType employeeType : employeeTypes) {
			EntityCacheUtil.removeResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeTypeImpl.class, employeeType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new employee type with the primary key. Does not add the employee type to the database.
	 *
	 * @param employeeTypeId the primary key for the new employee type
	 * @return the new employee type
	 */
	@Override
	public EmployeeType create(long employeeTypeId) {
		EmployeeType employeeType = new EmployeeTypeImpl();

		employeeType.setNew(true);
		employeeType.setPrimaryKey(employeeTypeId);

		return employeeType;
	}

	/**
	 * Removes the employee type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeTypeId the primary key of the employee type
	 * @return the employee type that was removed
	 * @throws com.hrms.NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeType remove(long employeeTypeId)
		throws NoSuchEmployeeTypeException, SystemException {
		return remove((Serializable)employeeTypeId);
	}

	/**
	 * Removes the employee type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee type
	 * @return the employee type that was removed
	 * @throws com.hrms.NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeType remove(Serializable primaryKey)
		throws NoSuchEmployeeTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmployeeType employeeType = (EmployeeType)session.get(EmployeeTypeImpl.class,
					primaryKey);

			if (employeeType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employeeType);
		}
		catch (NoSuchEmployeeTypeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected EmployeeType removeImpl(EmployeeType employeeType)
		throws SystemException {
		employeeType = toUnwrappedModel(employeeType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeType)) {
				employeeType = (EmployeeType)session.get(EmployeeTypeImpl.class,
						employeeType.getPrimaryKeyObj());
			}

			if (employeeType != null) {
				session.delete(employeeType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employeeType != null) {
			clearCache(employeeType);
		}

		return employeeType;
	}

	@Override
	public EmployeeType updateImpl(com.hrms.model.EmployeeType employeeType)
		throws SystemException {
		employeeType = toUnwrappedModel(employeeType);

		boolean isNew = employeeType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (employeeType.isNew()) {
				session.save(employeeType);

				employeeType.setNew(false);
			}
			else {
				session.merge(employeeType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTypeImpl.class, employeeType.getPrimaryKey(), employeeType);

		return employeeType;
	}

	protected EmployeeType toUnwrappedModel(EmployeeType employeeType) {
		if (employeeType instanceof EmployeeTypeImpl) {
			return employeeType;
		}

		EmployeeTypeImpl employeeTypeImpl = new EmployeeTypeImpl();

		employeeTypeImpl.setNew(employeeType.isNew());
		employeeTypeImpl.setPrimaryKey(employeeType.getPrimaryKey());

		employeeTypeImpl.setEmployeeTypeId(employeeType.getEmployeeTypeId());
		employeeTypeImpl.setEmployeeTypeName(employeeType.getEmployeeTypeName());
		employeeTypeImpl.setStatus(employeeType.isStatus());

		return employeeTypeImpl;
	}

	/**
	 * Returns the employee type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee type
	 * @return the employee type
	 * @throws com.hrms.NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeTypeException, SystemException {
		EmployeeType employeeType = fetchByPrimaryKey(primaryKey);

		if (employeeType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employeeType;
	}

	/**
	 * Returns the employee type with the primary key or throws a {@link com.hrms.NoSuchEmployeeTypeException} if it could not be found.
	 *
	 * @param employeeTypeId the primary key of the employee type
	 * @return the employee type
	 * @throws com.hrms.NoSuchEmployeeTypeException if a employee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeType findByPrimaryKey(long employeeTypeId)
		throws NoSuchEmployeeTypeException, SystemException {
		return findByPrimaryKey((Serializable)employeeTypeId);
	}

	/**
	 * Returns the employee type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee type
	 * @return the employee type, or <code>null</code> if a employee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmployeeType employeeType = (EmployeeType)EntityCacheUtil.getResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeTypeImpl.class, primaryKey);

		if (employeeType == _nullEmployeeType) {
			return null;
		}

		if (employeeType == null) {
			Session session = null;

			try {
				session = openSession();

				employeeType = (EmployeeType)session.get(EmployeeTypeImpl.class,
						primaryKey);

				if (employeeType != null) {
					cacheResult(employeeType);
				}
				else {
					EntityCacheUtil.putResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeTypeImpl.class, primaryKey, _nullEmployeeType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmployeeTypeModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employeeType;
	}

	/**
	 * Returns the employee type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeTypeId the primary key of the employee type
	 * @return the employee type, or <code>null</code> if a employee type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeType fetchByPrimaryKey(long employeeTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)employeeTypeId);
	}

	/**
	 * Returns all the employee types.
	 *
	 * @return the employee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.hrms.model.impl.EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee types
	 * @param end the upper bound of the range of employee types (not inclusive)
	 * @return the range of employee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.hrms.model.impl.EmployeeTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee types
	 * @param end the upper bound of the range of employee types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeType> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<EmployeeType> list = (List<EmployeeType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPLOYEETYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEETYPE;

				if (pagination) {
					sql = sql.concat(EmployeeTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmployeeType>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmployeeType>(list);
				}
				else {
					list = (List<EmployeeType>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the employee types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmployeeType employeeType : findAll()) {
			remove(employeeType);
		}
	}

	/**
	 * Returns the number of employee types.
	 *
	 * @return the number of employee types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EMPLOYEETYPE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the employee type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.hrms.model.EmployeeType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmployeeType>> listenersList = new ArrayList<ModelListener<EmployeeType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmployeeType>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(EmployeeTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPLOYEETYPE = "SELECT employeeType FROM EmployeeType employeeType";
	private static final String _SQL_COUNT_EMPLOYEETYPE = "SELECT COUNT(employeeType) FROM EmployeeType employeeType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmployeeType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmployeeTypePersistenceImpl.class);
	private static EmployeeType _nullEmployeeType = new EmployeeTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmployeeType> toCacheModel() {
				return _nullEmployeeTypeCacheModel;
			}
		};

	private static CacheModel<EmployeeType> _nullEmployeeTypeCacheModel = new CacheModel<EmployeeType>() {
			@Override
			public EmployeeType toEntityModel() {
				return _nullEmployeeType;
			}
		};
}