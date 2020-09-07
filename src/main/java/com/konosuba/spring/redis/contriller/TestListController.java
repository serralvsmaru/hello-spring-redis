package com.konosuba.spring.redis.contriller;

import com.konosuba.spring.redis.service.RedisService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author konosuba
 */
@RestController
@RequestMapping("/list")
public class TestListController {

    @Resource
    private RedisService redisService;

    @GetMapping("/lIndex/{key}/{index}")
    public Object lIndex(@PathVariable String key, @PathVariable long index){
        return redisService.lIndex(key, index);
    }

    @GetMapping("/lRange/{key}/{start}/{end}")
    public List<Object> lRange(@PathVariable String key, @PathVariable long start, @PathVariable long end){
        return redisService.lRange(key, start, end);
    }

    @PostMapping("/lLeftPush/{key}/{value}")
    public Long lLeftPush(@PathVariable String key, @PathVariable Object value){
        return redisService.lLeftPush(key, value);
    }

    @PostMapping("/lLeftPushIfPresent/{key}/{value}")
    public Long lLeftPushIfPresent(@PathVariable String key, @PathVariable String value){
        return redisService.lLeftPushIfPresent(key, value);
    }

    @PostMapping("/lLeftPush/{key}/{pivot}/{value}")
    public Long lLeftPush(@PathVariable String key, @PathVariable String pivot, @PathVariable String value){
        return redisService.lLeftPush(key, pivot, value);
    }

    @PostMapping("/lRightPush/{key}/{value}")
    public Long lRightPush(@PathVariable String key, @PathVariable String value){
        return redisService.lRightPush(key, value);
    }

    @PostMapping("/lRightPushAll/{key}")
    public Long lRightPushAll(@PathVariable String key, long...value){
        return redisService.lRightPushAll(key, value);
    }
    @PostMapping("/lRightPushIfPresent/{key}/{value}")
    public Long lRightPushIfPresent(@PathVariable String key, @PathVariable String value) {
        return redisService.lRightPushIfPresent(key, value);
    }

    @PostMapping("/lRightPush/{key}/{pivot}/{value}")
    public Long lRightPush(@PathVariable String key, @PathVariable String pivot, @PathVariable String value) {
        return redisService.lRightPush(key, pivot, value);
    }

    @PutMapping("/lSet/{key}/{index}/{value}")
    public void lSet(@PathVariable String key, @PathVariable long index, @PathVariable String value) {
        redisService.lSet(key, index, value);
    }

    @DeleteMapping("/lLeftPop/{key}")
    public Object lLeftPop(@PathVariable String key) {
        return redisService.lLeftPop(key);
    }

    @DeleteMapping("/lRemove/{key}/{index}/{value}")
    public Long lRemove(@PathVariable String key, @PathVariable long index, @PathVariable String value) {
        return redisService.lRemove(key, index, value);
    }

    @GetMapping("/lSize/{key}")
    public Long lSize(@PathVariable String key) {
        return redisService.lSize(key);
    }
}
