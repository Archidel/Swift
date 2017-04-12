package by.epam.swift.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** This filter encodes request object in UTF-8
 * @author Archangel
 */
public class EncodingFilter implements Filter{
	private final String nameInitParam = "encoding";
	private String encoding;
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		servletRequest.setCharacterEncoding(encoding);
		chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter(nameInitParam);
	}
	
}
