package com.king.kinghand.common.utils.gson;

import java.lang.annotation.Annotation;
import java.util.Collection;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class IgnoreStrategy implements ExclusionStrategy{

	@Override
	public boolean shouldSkipField(FieldAttributes fieldAttributes) {
		// TODO Auto-generated method stub
		Collection<Annotation> annotations = fieldAttributes.getAnnotations();
		for (Annotation annotation : annotations) {
			if(annotation.annotationType() == GsonIgnore.class) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

}
