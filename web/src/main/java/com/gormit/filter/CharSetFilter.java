package com.gormit.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Gormit on 17.09.2015.
 * Class Filter for encoding
 */
public class CharSetFilter implements Filter{

    private String encoding;

    /**
     * If are no encoding, use UTF-8 as default
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        if (this.encoding == null) {
            this.encoding = "UTF-8";
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(this.encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
