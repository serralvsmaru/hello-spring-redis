package com.konosuba.spring.redis.contriller;


import com.konosuba.spring.redis.service.RedisService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author konosuba
 */
@RestController
@RequestMapping("/set")
public class TestSetController {

    @Resource
    private RedisService redisService;

    @PostMapping("/aAdd/{key}")
    public Long sAdd(@PathVariable String key, String... values) {
        return redisService.sAdd(key, values);
    }

    @DeleteMapping("/sRemove/{key}")
    public Long sRemove(@PathVariable String key, String... values) {
        return redisService.sRemove(key, values);
    }

    @DeleteMapping("/sPop/{key}")
    public Object sPop(@PathVariable String key) {
        return redisService.sPop(key);
    }

    @GetMapping("/sSize/{key}")
    public Long sSize(@PathVariable String key) {
        return redisService.sSize(key);
    }

    @GetMapping("/sIsMember/{key}/{value}")
    public Boolean sIsMember(@PathVariable String key, @PathVariable Object value) {
        return redisService.sIsMember(key, value);
    }

    @GetMapping("/sMembers/{key}")
    public Set<Object> setMembers(@PathVariable String key) {
        return redisService.sMembers(key);
    }

    @GetMapping("/sRandomMember/{key}")
    public Object sRandomMember(@PathVariable String key) {
        return redisService.sRandomMember(key);
    }

    @GetMapping("/sRandomMembers/{key}/{count}")
    public List<Object> sRandomMembers(@PathVariable String key, @PathVariable long count) {
        return redisService.sRandomMembers(key, count);
    }

    @GetMapping("/sDistinctRandomMembers/{key}/{count}")
    public Set<Object> sDistinctRandomMembers(@PathVariable String key, @PathVariable long count) {
        return redisService.sDistinctRandomMembers(key, count);
    }
}
