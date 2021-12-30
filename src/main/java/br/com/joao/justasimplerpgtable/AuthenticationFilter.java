package br.com.joao.justasimplerpgtable;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.joao.justasimplerpgtable.model.Tokens;

@Profile("!dev")
@Component
@Order(1)
public class AuthenticationFilter implements Filter {
	
	@Override
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		final String authorization = httpServletRequest.getHeader("authorization");
		
		if(Tokens.tokens.contains(authorization)
				||httpServletRequest.getRequestURI().equals("/login")
				||httpServletRequest.getRequestURI().equals("/Player")) {
			chain.doFilter(request, response);
		} else {
			final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido");
		}
		
	}

}
