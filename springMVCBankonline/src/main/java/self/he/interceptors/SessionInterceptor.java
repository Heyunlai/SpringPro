package self.he.interceptors;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import self.he.pojo.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionInterceptor implements HandlerInterceptor {


    private static final Logger LOGGER = Logger.getLogger(SessionInterceptor.class);


    //检查当前会话是否有User，有则放行，没有则拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object account = request.getSession().getAttribute("SESSION_ACCOUNT");


        if(account == null){
            LOGGER.warn("没有权限，请先登录！");
            return false;
        }

        if(account instanceof Account){
            //查数据库检查
            Account u = (Account)account;
            u.setPassword(null);
            request.getSession().setAttribute("SESSION_ACCOUNT",u);
            LOGGER.info(u.getCardNo()+"会话中。。");
            return true;

        }else {
            LOGGER.warn("不要搞事，请先登录！");
            return false;
        }

    }
}
