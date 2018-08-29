package mrp.web.log.action;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mailtest.GoogleAuthentication;
import mrp.web.log.svc.IdFindService;
import mrp.web.log.svc.PwFindService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;

public class PwFindTestAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = null;
		String id=request.getParameter("id");
		String hint=request.getParameter("hint");
				
		PwFindService pwFindService = new PwFindService();
		User user = pwFindService.pwFind(id,hint);
		
		
		if(user.getU_email() != null) {
			request.setCharacterEncoding("UTF-8");
			String subject = "너의 영화는 - 비밀번호 찾기";
			String content = "비밀번호 찾기에 대한 비밀번호는 "+user.getU_passwd()+"입니다.";
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
				try {
					Properties properties = System.getProperties();
					properties.put("mail.smtp.starttls.enable","true");
					properties.put("mail.smtp.host","smtp.gmail.com");
					properties.put("mail.smtp.auth","true");
					properties.put("mail.smtp.port","587");
					Authenticator auth = new GoogleAuthentication();
					Session s = Session.getDefaultInstance(properties,auth);
					Message message=new MimeMessage(s);
					Address sender_address=new InternetAddress("mareco1265@gmail.com");
					Address receiver_address=new InternetAddress(user.getU_email());
					message.setHeader("content-type", "text/html;charset=UTF-8");
					message.setFrom(sender_address);
					message.addRecipient(Message.RecipientType.TO,receiver_address);
					message.setSubject(subject);
					message.setContent(content,"text/html;charset=UTF-8");
					message.setSentDate(new java.util.Date());
					Transport.send(message);
				} catch (AddressException e) {
					
					e.printStackTrace();
				} catch (MessagingException e) {
					
					e.printStackTrace();
				}
			
			request.setAttribute("u_email", user.getU_email());
			forward = new ActionForward();
			forward.setUrl("pwFindSuccess.jsp");
		}else {
			response.setContentType("text/html;charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>");
	         out.println("alert('정보를 다시한번 확인해주세요')");
	         out.println("history.back()");
	         out.println("</script>");
		}	
	     return forward;
	}

}
