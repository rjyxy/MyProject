package top.yxy.boot.cache.service.impl;

import cn.hutool.core.util.ObjectUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.yxy.boot.cache.config.RedisCache;
import top.yxy.boot.cache.config.RedisKeys;
import top.yxy.boot.cache.exception.ErrorCode;
import top.yxy.boot.cache.exception.ServerException;
import top.yxy.boot.cache.service.AuthService;

import java.util.UUID;
@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    @Resource
    private RedisCache redisCache;

    @Override
    public String loginByPhone(String phone,String code){
//        获取验证码 cacheKey
        String smsCacheKey = RedisKeys.getSmsKey(phone);
//        从 redis 中获取验证码
        Integer redisCode = (Integer) redisCache.get(smsCacheKey);
//        校验验证码合格性
        if (ObjectUtil.isEmpty(redisCode)){
            throw new ServerException(ErrorCode.SMS_CODE_EXPIRE);
        } else if (!redisCode.toString().equals(code)) {
//            验证码错误
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);

        }
//        删除用过的验证码
        redisCache.delete(smsCacheKey);
//        返回 token ,这里用 UUID 模拟，实际上是根据用户id ,构造一个 JWT Token
        return UUID.randomUUID().toString();
    }

}
