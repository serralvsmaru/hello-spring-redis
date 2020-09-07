package com.konosuba.spring.redis.contriller;

import com.konosuba.spring.redis.service.RedisService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author konosuba
 */
@RestController
@RequestMapping("/hash")
public class TestHashController {

    @Resource
    private RedisService redisService;

    @GetMapping("/get/{key}/{field}")
    public Object hGet(@PathVariable String key, @PathVariable String field){
        return redisService.hGet(key, field);
    }

    @GetMapping("/getAll/{key}")
    public Map<String, Object> hGetAll(@PathVariable String key){
        return redisService.hGetAll(key);
    }

    /**
     * 批量删除
     * @param key 删除字段的hash名
     * @param fields 删除的 key， 这里用Object类型会报错
     * @return 删除数量
     */
    @DeleteMapping("/delete")
    public Long hDelete(String key, String...fields){
        return redisService.hDelete(key, fields);
    }

    @GetMapping("/hHasKey/{key}/{field}")
    public boolean hHasKey(@PathVariable String key, @PathVariable String field){
        return redisService.hHasKey(key, field);
    }

    @PutMapping("/hIncrBy/{key}/{field}/{increment}")
    public Long hIncrBy(@PathVariable String key, @PathVariable String field, @PathVariable long increment){
        return redisService.hIncrBy(key, field, increment);
    }

    @GetMapping("/hKeys/{key}")
    public Set<String> hKeys(@PathVariable String key){
        return redisService.hKeys(key);
    }

    @GetMapping("/hSize/{key}")
    public Long hSize(@PathVariable String key){
        return redisService.hSize(key);
    }

    @GetMapping("/hValues/{key}")
    public List<Object> hValues(@PathVariable String key) {
        return redisService.hValues(key);
    }

    @PostMapping("/hPut/{key}/{hashKey}/{value}")
    public void hPut(@PathVariable String key, @PathVariable String hashKey, @PathVariable String value) {
        redisService.hPut(key, hashKey, value);
    }

    @PostMapping("/hPutLong/{key}/{hashKey}/{value}")
    public void hPutLong(@PathVariable String key, @PathVariable String hashKey, @PathVariable Long value) {
        redisService.hPut(key, hashKey, value);
    }

    @PostMapping("/hPutIfAbsent/{key}/{hashKey}/{value}")
    public Boolean hPutIfAbsent(@PathVariable String key, @PathVariable String hashKey, @PathVariable String value) {
        return redisService.hPutIfAbsent(key, hashKey, value);
    }
}
