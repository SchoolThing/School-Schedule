package testPackage;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.derby.impl.tools.ij.Main;
import org.eclipse.core.runtime.AssertionFailedException;
import org.junit.Test;
import org.xml.sax.SAXException;

import serverPackage.Login;
import serverPackage.User;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class LoginTest {
	public static final String ADDRESS = "http://localhost:8181/SchoolServer/";
	public static HttpServletRequest req;
	public static HttpServletResponse resp;
	public static HttpSession session;
	private String Username;
	private String Password;
	private String form;
	private Login login;

	
	@Test
	public void testUserData() throws IOException, SAXException, ServletException {
		createFixture();
		req.setAttribute("Username", "desi");
		req.setAttribute("Password", "admin");
		resp.getContentType();
		
		login.doGet(req,resp);
		
		assertEquals("mainPage.jsp",resp.getContentType());
		assertEquals("error.jsp",resp.getContentType());
	}	
	
	public void createFixture(){
		Login login= new Login();
	
	}
}
