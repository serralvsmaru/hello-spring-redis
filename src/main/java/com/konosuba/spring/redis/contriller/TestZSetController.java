package com.konosuba.spring.redis.contriller;

import com.konosuba.spring.redis.service.RedisService;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author konosuba
 */

@RestController
@RequestMapping("/zSet")
public class TestZSetController {

    @Resource
    private RedisService redisService;

    @PostMapping("/zAdd/{key}/{value}/{score}")
    public Boolean zAdd(@PathVariable String key, @PathVariable String value, @PathVariable double score) {
        return redisService.zAdd(key, value, score);
    }

    @DeleteMapping("/zRemove/{key}/")
    public Long zRemove(@PathVariable String key, String... values) {
        return redisService.zRemove(key, values);
    }

    @PutMapping("/zIncrementScore/{key}/{value}/{delta}")
    public Double zIncrementScore(@PathVariable String key, @PathVariable String value, @PathVariable double delta) {
        return redisService.zIncrementScore(key, value, delta);
    }

    @GetMapping("/zRank/{key}/{value}")
    public Long zRank(@PathVariable String key, @PathVariable Object value) {
        return redisService.zRank(key, value);
    }

    @GetMapping("/zReverseRank/{key}/{value}")
    public Long zReverseRank(@PathVariable String key, @PathVariable Object value) {
        return redisService.zReverseRank(key, value);
    }

    @GetMapping("/zRange/{key}/{start}/{end}")
    public Set<Object> zRange(@PathVariable String key, @PathVariable long start, @PathVariable long end) {
        return redisService.zRange(key, start, end);
    }

    @GetMapping("/zRangeWithScores/{key}/{start}/{end}")
    public Set<ZSetOperations.TypedTuple<Object>> zRangeWithScores(@PathVariable String key,
                                                                   @PathVariable long start, @PathVariable long end) {
        return redisService.zRangeWithScores(key, start, end);
    }

    @GetMapping("/zRangeByScore/{key}/{min}/{max}")
    public Set<Object> zRangeByScore(@PathVariable String key, @PathVariable double min, @PathVariable double max) {
        return redisService.zRangeByScore(key, min, max);
    }

    @GetMapping("/zRangeByScoreWithScores/{key}/{min}/{max}/{start}/{end}")
    public Set<ZSetOperations.TypedTuple<Object>> zRangeByScoreWithScores(@PathVariable String key,
                                                                          @PathVariable double min,
                                                                          @PathVariable double max,
                                                                          @PathVariable long start,
                                                                          @PathVariable long end) {
        return redisService.zRangeByScoreWithScores(key, min, max, start, end);
    }

    @GetMapping("/zReverseRangeWithScores/{key}/{start}/{end}")
    public Set<ZSetOperations.TypedTuple<Object>> zReverseRangeWithScores(@PathVariable String key,
                                                                          @PathVariable long start,
                                                                          @PathVariable long end) {
        return redisService.zReverseRangeWithScores(key, start, end);
    }

    @GetMapping("/zReverseRangeByScore/{key}/{min}/{max}")
    public Set<Object> zReverseRangeByScore(@PathVariable String key, @PathVariable double min, @PathVariable double max) {
        return redisService.zReverseRangeByScore(key, min, max);
    }

    @GetMapping("/zCount/{key}/{min}/{max}")
    public Long zCount(@PathVariable String key, @PathVariable double min, @PathVariable double max) {
        return redisService.zCount(key, min, max);
    }

    @GetMapping("/zSize/{key}")
    public Long zSize(@PathVariable String key) {
        return redisService.zSize(key);
    }

    @GetMapping("/zCard/{key}")
    public Long zCard(@PathVariable String key) {
        return redisService.zCard(key);
    }

    @GetMapping("/zScore/{key}/{value}")
    public Double zScore(@PathVariable String key, @PathVariable Object value) {
        return redisService.zScore(key, value);
    }

    @DeleteMapping("/zRemoveRange/{key}/{start}/{end}")
    public Long zRemoveRange(@PathVariable String key, @PathVariable long start, @PathVariable long end) {
        return redisService.zRemoveRange(key, start, end);
    }

    @DeleteMapping("/zRemoveRangeByScore/{key}/{min}/{max}")
    public Long zRemoveRangeByScore(@PathVariable String key, @PathVariable double min, @PathVariable double max) {
        return redisService.zRemoveRangeByScore(key, min, max);
    }
}
