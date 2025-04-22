import HandlerInterceptor.HandlerInterceptor;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.*;

public final class LoginInterceptor implements HandlerInterceptor {

    // 不需要拦截的路径
    private static final String[] EXCLUDE_PATHS = {
            "/user/login",
            "/user/register",
            "/static/**",
            "/error"
    };

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        // 1. 排除不需要拦截的路径 [8]()
        for (String path : EXCLUDE_PATHS) {
            if (new AntPathMatcher().match(path, requestURI)) {
                return true;
            }
        }
        // 2. 检查登录状态 [7]()
        HttpSession session = request.getSession();
        Object userInfo = session.getAttribute("LOGIN_USER");

        // 3. 当用户未登录时
        if (userInfo == null) {
            // 根据请求类型返回不同响应 [3]()
            if (isAjaxRequest(request)) {
                response.setContentType("application/json");
                response.getWriter().write("{\"code\":401,  \"msg\":\"未认证\"}");
            } else {
                response.sendRedirect("/login");
            }
            return false;
        }

        // 4. 可扩展的权限验证逻辑 [15]()
        // 例如验证token有效期、权限级别等
        return true;
    }

    // 后处理
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler
//                           ModelAndView modelAndView
    ) throws Exception {
        // 记录请求处理时间、修改响应头等 [10]()
        long startTime = (Long) request.getAttribute("requestStartTime");
        long executeTime = System.currentTimeMillis()  - startTime;
        request.setAttribute("executeTime",  executeTime);
    }

    // 完成处理
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        // 资源清理、异常记录等 [7]()
        if (ex != null) {
//            log.error("Request  processing error: " + request.getRequestURI(),  ex);
        }
    }

    // 判断是否为Ajax请求
    private boolean isAjaxRequest(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}