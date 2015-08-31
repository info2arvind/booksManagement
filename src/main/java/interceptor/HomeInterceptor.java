package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HomeInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest req,
            HttpServletResponse res, Object handler) throws Exception {
		HttpSession session = req.getSession();
		System.out.println("HomeInterceptor");
		System.out.println(session.getId());
		if(session!=null && !session.isNew()){
			return true;
		}else{
			res.sendRedirect("customer");
		}
		
		return false;
	}

}
