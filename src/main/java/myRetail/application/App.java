package myRetail.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import myRetail.application.model.PriceMaster;


@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
       RedisStandaloneConfiguration redisStandaloneConfiguration = 
    		   new RedisStandaloneConfiguration("localhost", 6379);
       return new JedisConnectionFactory(redisStandaloneConfiguration);
    }
    
    @Bean
    RedisTemplate<String, PriceMaster> redisTemplate() {
        RedisTemplate<String, PriceMaster> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
     }
}
