package com.konosuba.spring.redis.contriller;

import com.konosuba.spring.redis.service.RedisService;
import org.springframework.data.redis.connection.DataType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author konosuba
 */
@RestController
@RequestMapping("/string")
public class TestStringController {

    @Resource
    private RedisService redisService;

    @DeleteMapping("/delete/{key}")
    public boolean delete(@PathVariable String key){
        return redisService.delete(key);
    }

    @GetMapping("/hasKey/{key}")
    public boolean hasKey(@PathVariable String key){
        return redisService.hashKey(key);
    }

    @GetMapping("/expire/{key}/{timeout}")
    public boolean expire(@PathVariable String key, @PathVariable long timeout){
        return redisService.expire(key, timeout, TimeUnit.SECONDS);
    }

    @GetMapping("/getExpire/{key}")
    public Long getExpire(@PathVariable String key){
        return redisService.getExpire(key, TimeUnit.SECONDS);
    }

    @GetMapping("/type/{key}")
    public DataType type(@PathVariable String key){
        return redisService.type(key);
    }

    @PostMapping("/set/{key}/{value}")
    public void set(@PathVariable String key, @PathVariable Object value){
        redisService.set(key, value);
    }

    @PostMapping("/setInt/{key}/{value}")
    public void setInt(@PathVariable String key, @PathVariable Integer value){
        redisService.set(key, value);
    }

    @GetMapping("/get/{key}")
    public Object get(@PathVariable String key){
        return redisService.get(key);
    }

    @PostMapping("/setIfAbsent/{key}/{value}")
    public boolean setIfAbsent(@PathVariable String key, @PathVariable String value){
        return redisService.setIfAbsent(key, value);
    }

    @GetMapping("/size/{key}")
    public Long size(@PathVariable String key){
        return redisService.size(key);
    }

    @PutMapping("/incrBy/{key}/{increment}")
    public Long incrBy(@PathVariable String key, @PathVariable long incremint){
        return redisService.incrBy(key, incremint);
    }

    @PutMapping("/incrByDouble/{key}/{increment}")
    public Double incrByDouble(@PathVariable String key, @PathVariable double increment){
        return redisService.incrByDouble(key, increment);
    }

    @PutMapping("/append/{key}/{value}")
    public Integer append(@PathVariable String key, @PathVariable String value){
        return redisService.append(key, value);
    }
}
