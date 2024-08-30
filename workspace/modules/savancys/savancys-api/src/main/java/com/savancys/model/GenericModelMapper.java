package com.savancys.model;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericModelMapper {

//	private static final Log log = LogFactoryUtil.getLog(GenericModelMapper.class);

	/**
	 * Returns list of records of type {@link List<T>}
	 * 
	 * @param 	type	a Class type
	 * @param 	record	list of records containing object array
	 * @return			list of specified Class
	 * @see 			Class
	 */
	
	public static <T> List<T> map(Class<T> type, List<Object[]> records) {
		List<T> result = new LinkedList<T>();
		for (Object[] record : records) {
			result.add(map(type, record));
		}
		return result;
	}

	/**
	 * Returns a record of a specified type {@link T}
	 * 
	 * @param 	type	a Class type
	 * @param 	record	a record of type object array
	 * @return			an instance of specified Class
	 * @see				Class
	 */
	private static <T> T map(Class<T> type, Object[] record) {
		List<Class<?>> recordTypes = new ArrayList<>();
		Object[] recordFinal = new Object[record.length];
		Field[] fields = type.getDeclaredFields();
		int count = 0;
		for (Object field : record) {
			System.out.println("field "+field);
			recordFinal[count] = (field != null && field.getClass().equals(BigInteger.class)) ? 
		                         ((BigInteger) field).longValue() :
		                         (field != null && field.getClass().equals(java.sql.Date.class)) ?
		                         ((java.sql.Date) field).toLocalDate() :
		                         (field != null && field.getClass().equals(Boolean.class)) ?
		                         field :
		                         (field != null && field.getClass().equals(String.class)) ?
		                         field :
		                         field;
		             			count++;
			}
		try {
			Constructor[] constructors = type.getConstructors();
			for (Constructor<T> constructor : constructors) {
				if(constructor.getParameterCount() == record.length) {
					return constructor.newInstance(recordFinal);
				}
			}
			/*Constructor<T> constructor = type.getConstructor(recordTypes.toArray(new Class<?>[record.length]));
			return constructor.newInstance(recordFinal);*/
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}
}
