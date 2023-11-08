package wordnet.genshin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import wordnet.genshin.domain.Guser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 实现登录验证的拦截功能    实现 Interceptor接口
 * */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        HttpSession session = request.getSession();

        String user = (String) session.getAttribute("EMP_SESSION");

       // System.out.println("user: "+user);
        if (user != null) {
            return true; // 用户已经登录则放行
        }

        if (!(uri.indexOf("/Home.html") >= 0) && !(uri.indexOf("/Users/login") >= 0)) {
            // 如果用户访问的是需要登录的页面，记录目标页面的 URL
            String targetUrl = request.getRequestURI();
            System.out.println("targetUrl_unchaged"+targetUrl);
            if (targetUrl != null) {
                // 移除上下文路径
                targetUrl = targetUrl.replace("/SSM_war_exploded", "");
            }
            System.out.println("targetUrl_chaged"+targetUrl);
                session.setAttribute("targetUrl", targetUrl);

                response.sendRedirect(request.getContextPath() + "/Login.html");
                return false; // 不放行，拦截请求
            }

            return true; // 用户未登录，但访问的是不需要登录的页面，放行
        }



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
