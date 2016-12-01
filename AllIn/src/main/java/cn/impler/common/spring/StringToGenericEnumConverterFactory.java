package cn.impler.common.spring;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import cn.impler.framework.mybatis.dao.dto.IGenericEnum;
import cn.impler.framework.mybatis.dao.util.EnumUtil;

/**
 * the extension of org.springframework.core.convert.support.StringToEnumConverterFactory
 * in order to be compatible with IGenericEnum
 * @author impler
 * @date 2016-12-01
 */
@SuppressWarnings("rawtypes")
public class StringToGenericEnumConverterFactory implements ConverterFactory<String, Enum> {
	
	@Override
	public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
		return new StringToEnum<T>(targetType);
	}

	private class StringToEnum<T extends Enum> implements Converter<String, T> {

		private final Class<T> enumType;

		public StringToEnum(Class<T> enumType) {
			this.enumType = enumType;
		}

		@SuppressWarnings("unchecked")
		public T convert(String source) {
			if (source.length() == 0) {
				return null;
			}
			if(IGenericEnum.class.isAssignableFrom(enumType)){
				return (T) EnumUtil.getEnumConstant(enumType, Integer.parseInt(source));
			}else{
				return (T) Enum.valueOf(this.enumType, source.trim());
			}
		}
	}}
