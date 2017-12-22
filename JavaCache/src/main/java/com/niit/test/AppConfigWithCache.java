package com.niit.test;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
@ComponentScan({ "com.niit.*" })
public class AppConfigWithCache {

	@Bean
	public EhCacheCacheManager cacheManager() {
		System.out.println("EhCacheCacheManager configured!!!");
		return new EhCacheCacheManager();
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		System.out.println("EhCacheManagerFactoryBean configured!!!");
		return cmfb;
	}
}