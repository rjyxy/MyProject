package top.yxy.boot.cache.service;

public interface AuthService {
    /**
     *
     * @param phone 手机号
     * @param code  验证码
     * @return  token
     * */
    String loginByPhone(String phone,String code);
}
