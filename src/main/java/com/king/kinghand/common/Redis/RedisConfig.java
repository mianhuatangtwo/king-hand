package com.king.kinghand.common.Redis;

import java.net.UnknownHostException;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.king.kinghand.common.Serializer.FastJsonRedisSerializer;


@Configuration
@ConditionalOnClass({RedisOperations.class })
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig{

//	@Bean
//	@ConditionalOnMissingBean(name = "redisTemplate")
//	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//		CacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory).build();
//		return cacheManager;
//	}
	
	@Bean
	@ConditionalOnMissingBean(name = "redisTemplate")
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory){
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object,Object>();
		FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<Object>(Object.class);
		//key的值采用序列化
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		//value的值采用序列化
		redisTemplate.setValueSerializer(fastJsonRedisSerializer);
		redisTemplate.setHashValueSerializer(fastJsonRedisSerializer);
		
		
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}
	
	@Bean
	@ConditionalOnMissingBean(StringRedisTemplate.class)
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

	
	
}
