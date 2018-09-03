package com.king.kinghand.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.king.kinghand.common.utils.gson.IgnoreStrategy;

public class GsonUtils {
	  private static Gson instance = null;

	    public synchronized static Gson getGson(TypeAdapterFactory... adapterFactories) {
	        if (instance == null) {
	            GsonBuilder builder = new GsonBuilder();
	            builder.addSerializationExclusionStrategy(new IgnoreStrategy());
//	            builder.registerTypeAdapter(java.util.Date.class, new DateSerializer()).setDateFormat(DateFormat.LONG);
//	            builder.registerTypeAdapter(java.util.Date.class, new DateDeserializer()).setDateFormat(DateFormat.LONG);
	            for (TypeAdapterFactory adapter : adapterFactories) {
	                builder.registerTypeAdapterFactory(adapter);
	            }
	            instance = builder.create();
	        }
	        return instance;
	    }
}

