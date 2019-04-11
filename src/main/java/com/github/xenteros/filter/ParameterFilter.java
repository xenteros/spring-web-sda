package com.github.xenteros.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.function.Predicate;

@Component
@Order(2)
class ParameterFilter implements Filter {

    private static Predicate<Map.Entry<String, ?>> parameterForbidden = mapEntry -> {
        String key = mapEntry.getKey();
        return  !(key.equals("id") || key.equals("title") || key.equals("author"));
    };


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getRequestURI().startsWith("/api/v2/books")) {
                req.getParameterMap()
                        .entrySet()
                        .removeIf(parameterForbidden);

//            Enumeration<String> parameterNames = req.getParameterNames();
//            for (String param : list(parameterNames)) {
//                if (!(param.equals("id") || param.equals("title") || param.equals("author"))) {
//                    req.getParameterMap().remove(param);
//                }
//            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
