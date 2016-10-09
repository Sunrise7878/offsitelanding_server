package com.gcy.offsitelanding_server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<User> users = new ArrayList<User>();
       
    public LoginServlet() {
        super();
        users.add(new User("user01", "123456", 0));
        users.add(new User("user02", "123456", 0));
        users.add(new User("user03", "123456", 0));
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String registrationId = request.getParameter("registrationId");
		User user = findUserByName(username);
		
		if(user == null){
			out.println("The current user does not exist");
		}else{
			if(user.getPassword().equals(password)){
				//��¼�ɹ�������ǰ�û��������ط���¼��Ӧ����������Ϣ����������
				if(user.getStatus() == 1){
					//����ע�⣺�����ַ���ǰ����masterSecret , ������appKey
					JPushClient jPushClient = new JPushClient("0bdecb00531ec118a7b982db", "f9ad20faed32beed296a71bd");
					PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.registrationId(user.getRegistrationId()))
							.setMessage(Message.newBuilder().setMsgContent("����˺�����һ̨�ֻ��ϵ�½����ȷ������˺ź������Ƿ�й¶����").build()).build();
					try {
						jPushClient.sendPush(payload);
					} catch (APIConnectionException | APIRequestException e) {
						e.printStackTrace();
					}
				}else{
					user.setStatus(1);
				}
				user.setRegistrationId(registrationId);
				System.out.println(registrationId);
				out.print("success");
			}else{
				out.println("Account and password do not match");
			}
		}
	}
	
	public User findUserByName(String userName){
		for(User u : users){
			if(u.getUsername().equals(userName)){
				return u;
			}
		}
		return null;
	}

}
