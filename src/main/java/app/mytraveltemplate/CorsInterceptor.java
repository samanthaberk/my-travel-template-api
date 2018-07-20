package app.mytraveltemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CorsInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000/");
		response.addHeader("X-something-I-made-up", "yes");
		super.postHandle(request, response, handler, modelAndView);
	}
		//@Override
		//public void postHandle(HtttpServletRequest request, HttpServletResponse response, ModelAndView model)
}
