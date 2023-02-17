package ThreadInvoker;

import arguments.HttpServletRequest;
import arguments.HttpServletResponse;
import servlet.AddServlet;

public class ClientThread extends Thread {
	private AddServlet servlet;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ClientThread(AddServlet servlet, HttpServletRequest request, HttpServletResponse response) {
		super();	
		this.servlet = servlet;
		this.request = request;
		this.response = response;
		}

	@Override
	public void run() {
		servlet.service(request,response);
	}

}
