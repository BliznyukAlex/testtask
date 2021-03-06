package com.testtask.customergetter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories(basePackages = "com.testtask.customergetter.repo")
public class RedisConfig {

    private static String HOSTNAME_REDIS;
    @Value("${hostname_redis}")
    public void setMinSecCreateCustomer(String hostname_redis) {
        HOSTNAME_REDIS = hostname_redis;
    }

    RedisStandaloneConfiguration standaloneoconfig() {
        RedisStandaloneConfiguration standaloneoconfig = new RedisStandaloneConfiguration(HOSTNAME_REDIS, 6379);
        return standaloneoconfig;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(standaloneoconfig());
        jedisConnectionFactory.setPassword("admin");
        return jedisConnectionFactory;
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
