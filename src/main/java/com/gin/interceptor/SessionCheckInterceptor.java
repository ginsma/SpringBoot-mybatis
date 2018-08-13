package com.gin.interceptor;

import com.gin.domain.SysPeopleLoginEntity;
import com.gin.mapper.SysPeopleLoginMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　   ┏┓
 * ┏┛┻━━━━━━┛┻┓
 * ┃　　　　　　┃
 * ┃　　━　    ┃
 * ┃　┳┛　┗┳   ┃
 * ┃　　　　　　┃
 * ┃　　┻　　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　 ┏━━━┛
 * 　┃　　　┃神兽保佑
 * 　┃　　　┃代码无BUG！
 * 　┃　　　┗━━━┓
 * 　┃　　　　　 ┣┓
 * 　┃　　　　　┏┛
 * 　┗┓┓┏━━┳┓┏┛
 * 　 ┃┫┫　┃┫┫
 * 　 ┗┻┛　┗┻┛
 * Created by Jean .
 * 2018/8/9
 */
public class SessionCheckInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(SessionCheckInterceptor.class);

    @Resource
    private SysPeopleLoginMapper sysPeopleLoginMapper;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {


        final String sessionId = request.getRequestedSessionId();
        final String userId = request.getHeader("userid");
        final String clientId = request.getHeader("clientid");

        if (isEmpty(sessionId) || isEmpty(userId) || isEmpty(clientId)) {
            return false;
        }

        SysPeopleLoginEntity sysPeopleLoginEntity = new SysPeopleLoginEntity();
        sysPeopleLoginEntity.setEhrId(userId);
        sysPeopleLoginEntity.setClientId(clientId);
        sysPeopleLoginEntity = sysPeopleLoginMapper.querySysPeopleLoginEntity(sysPeopleLoginEntity);

        if(sysPeopleLoginEntity == null) {
            return false;
        }
        //session检验
        if(!sysPeopleLoginEntity.getSessionId().equals(sessionId)) {
            return false;
        }
        //登陆超时时间检验
        String timeoutTime = sysPeopleLoginEntity.getTimeoutTime();
        String newTime = dateFormat(new Date(), "yyyy-MM-dd HH:mm:ss");
        if( newTime.compareTo(timeoutTime) > 0) {
            return false;
        }

        return true;





//        HandlerMethod method = (HandlerMethod) handler;
//        MethodParameter[] parms = method.getMethodParameters();
//        for (MethodParameter parm : parms) {
//            logger.info(parm.getNestedGenericParameterType().getTypeName());
//        }
//        logger.info("RquestedURL :" + request.getRequestURL() + "Method : "
//                + method.getMethod());
//        return true;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
        logger.info("this is interceptor, postHandle method");
    }
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info("this is interceptor, afterCompletion method");
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String dateFormat(Date date, String pattern) {
        if(null == date || date.toString().equals("")) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }




}
