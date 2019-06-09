package com.wenpeng.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter("/*")
public class MyEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void destroy()
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");
        //解决Tomcat 7 Get请求中文乱码问题
        //MyRequest myRequest = new MyRequest((HttpServletRequest) request);
        chain.doFilter(request, response);
    }


}

//解决Tomcat 7 Get请求中文乱码问题
/*
class MyRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    public MyRequest(HttpServletRequest request)
    {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name)
    {
        return getParameterMap().get(name)[0];
    }

    @Override
    public Map<String, String[]> getParameterMap()
    {
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet())
        {
            String[] values = entry.getValue();
            for (int i = 0; i < values.length; i++)
            {
                try
                {
                    values[i] = new String(values[i].getBytes("ISO-8859-1"), "UTF-8");
                }
                catch (UnsupportedEncodingException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }
}*/
