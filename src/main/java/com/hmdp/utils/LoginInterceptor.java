package com.hmdp.utils;

import cn.hutool.core.util.ObjectUtil;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        UserDTO user = UserHolder.getUser();
        if (ObjectUtil.isEmpty(user)) {
            response.setStatus(401);
            return false;
        }
        return true;
    }

}
