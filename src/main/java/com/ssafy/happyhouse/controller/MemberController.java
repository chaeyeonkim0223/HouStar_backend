package com.ssafy.happyhouse.controller;


import java.util.Map;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.service.MemberService;



@Controller
public class MemberController {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String act = request.getParameter("act");
//		String root = request.getContextPath();
//
//		System.out.println(act);
//		
//		if("login".equals(act)) {
//			login(request,response);
//			
//		}else if("logout".equals(act)) {
//			logout(request,response);
//			
//		}else if("insertform".equals(act)) {
//			System.out.println("회원가입 버튼누름");
//			response.sendRedirect("enter.jsp");
//			
//		}else if("insertmember".equals(act)) {
//			System.out.println("회원등록 버튼누름");
//			insertmember(request,response);
//			
//		}else if("lookupmember".equals(act)) {
//			System.out.println("회원정보 버튼누름");
//			lookupmember(request,response);
//		}else if("updateform".equals(act)) {
//			System.out.println("수정하기 버튼누름");
//			response.sendRedirect("memberupdate.jsp");
//		}
//		else if("updatemember".equals(act)) {
//			System.out.println("수정메소드 실행");
//			updatemember(request,response);
//		}else if("deletemember".equals(act)) {
//			System.out.println("회원탈퇴 실행");
//			deletemember(request,response);
//		}else if("inner_submit_form".equals(act)) {
//			System.out.println("관심지역 등록 메뉴  누름");
//			response.sendRedirect("inter_submit.jsp");
//		}else if("inter_submit".equals(act)) {
//			System.out.println("관심지역 등록");
//			inner_submit(request,response);	
//		}else if("inter_search".equals(act)) {
//			System.out.println("관심지역탐방");
//			inner_search(request,response);
//		}else if("findpassword".equals(act)) {
//			findPassword(request, response);
//		}else if("citychange".equals(act)) {
//			citychange(request,response);
//		}else if("inter_delete".equals(act)) {
//			inter_delete(request,response);
//		}
//		
//		
//		
//		
//		
//		
//		
//		else if("gungu".equals(act)) gungu(request,response);
//		else if("dong".equals(act))	dong(request,response);
//		else if("trade".equals(act)) trade(request,response);
		
//		else if("1".equals(act)) {
//			System.out.println("관심지역 탐방 누름");		//탐방 누르면 리다이렉트로 보내버리고 해당 jsp에서 세션값 꺼낸다음 화면에 표시 or 없으면 임의로하나 지정해서 표시. 이후 값이 바뀔때마다 다시 표시해야됨
//			deletemember(request,response);
//		}else if("2".equals(act)) {
//			System.out.println("관심지역 탐방 누름");
//			deletemember(request,response);
//		}
		
//	}
//	private void inter_delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		HttpSession session = request.getSession();
//		
//		String dong = request.getParameter("dong");
//		String code = bSer.findCode(dong);
//		intSer.deleteArea(code,(String)session.getAttribute("id"));
//		
//		System.out.println("삭제완료");
//		
//		
//		String root = request.getContextPath();
//		String path = root+"/ayj?act=inter_search";
//		
//		response.sendRedirect(path);
//	}
//
//	private void inner_submit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		System.out.println("inner_submit");
//		
//		//여기서 세션에다가 값 넣기 왜냐 관심지역은 로그인하고 다른곳갔다와도 유지되야함
//		String root = request.getContextPath();
//		String dong = request.getParameter("dong");
//		String userId = (String) session.getAttribute("id"); 
//		System.out.println(userId);
//				
//		System.out.println(dong);
//		
//		intSer.insertArea(new InterestArea(userId, dong));
//		
//		//List<Mart> mart =  marSer.getinfo(dong);
////		
////		session.setAttribute("mart", mart);
//		
////		for(int i=0;i<mart.size();i++)
////			System.out.println(mart.get(i).toString());
//		String path = root+"/ayj?act=inter_search";
//		
//		response.sendRedirect(path);
//	}
//	
//	private void inner_search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String path = "/inter_search.jsp";
//		
//		String dong = request.getParameter("dong");
//		System.out.println("inner_submit");
//		//여기에서 DB체크 해서 값이 있으면 세션에 등록하고 없으면 돌려보내기
//		//다시 올때마다 세션 지우고 다시 만들어주기
//		
//		List<String> list = intSer.findArea((String)session.getAttribute("id"));	//id로 주변찾기
//		List<String> listdong = new ArrayList<>();
//		
//		if(list.size() == 0) {
//			System.out.println("관심지역이 없음 뒤로 ㄱㄱ");
//			//이거 해야함
//			path = "/inter_submit.jsp";
//			
//			
//		}else {
//			//결과값은 법정동 코드로 올거임
//			System.out.println("관심지역 찾았음");
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
//				String s = bSer.findDongName(list.get(i));	//코드로 동 이름 찾기
//				listdong.add(s);
//			}
//			
//			
//			
//			if(dong == null) {
//				//여기서 법정동코드로 찾기 해야됨
//				List<Mart> mart =  marSer.getinfo(list.get(0));
//				session.setAttribute("mart", mart);
//				session.setAttribute("martlist", listdong);
//			}else {
//				
//				String realdong = bSer.findCode(dong);
//				List<Mart> mart =  marSer.getinfo(realdong);
//				session.setAttribute("mart", mart);
//				session.setAttribute("martlist", listdong);
//				
//			}
//		}
		
//		if(session.getAttribute("mart") == null) {
//			
//			String path = "/index.jsp";
//			RequestDispatcher disp = request.getRequestDispatcher(path);
//			disp.forward(request, response);
//		}else {
//			String path = "/inter_search.jsp";
//			RequestDispatcher disp = request.getRequestDispatcher(path);
//			disp.forward(request, response);
//		}
		
		
//		RequestDispatcher disp = request.getRequestDispatcher(path);
//		disp.forward(request, response);
//		
//	}
//
//	
//
//	private void deletemember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		
//		
//		String root = request.getContextPath();
//		String path = root+"/index.jsp";
//		String id = (String) session.getAttribute("id");
//		System.out.println(id);
//		memSer.deleteMember(id);
//		System.out.println("deletemember");
//		
//		session.invalidate();//탈퇴하면 로그아웃한거랑 같아서 세션도 날려버림
//		response.sendRedirect(path);
//		
//		
//	}
//
//
//	private void updatemember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		
//		String id = (String) session.getAttribute("id");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		String address = request.getParameter("address");
//		String phone = request.getParameter("phone");
//		
//		System.out.println(phone);
//		try {
//			memSer.update(new Member(id,password, name, address,phone));
//			
//		}catch(Exception e) {
//			
//		}
//		
//		String path="/index.jsp";
//		
//		
//		RequestDispatcher disp = request.getRequestDispatcher(path);
//		disp.forward(request, response);
//		
//		
//	}
//
//
//	private void lookupmember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("lookupmember");
//		String path = "/member.jsp";
//		HttpSession session = request.getSession();
//		//id는 세션에서 가져와야되는데 아직 세션 안만듦
//		String id = (String) session.getAttribute("id");
//		
//		request.setAttribute("members", memSer.lookupmember(id));
//		RequestDispatcher disp = request.getRequestDispatcher(path);
//		disp.forward(request, response);
//		
//	}
//
//
//	private void insertmember(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		System.out.println("회원등록버튼누름");
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		String address = request.getParameter("address");
//		String phone = request.getParameter("phone");
//		
//		
//		System.out.println(id+" "+ password);
//		try {
//			memSer.insertMember(new Member(id, password, name, address, phone));
//			response.sendRedirect(request.getContextPath() + "/index.jsp");
//		}catch(Exception e) {
//		}
//		
//		
//		
//		
//	}

//	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		HttpSession session = request.getSession();
////		session.removeAttribute("userinfo");	//하나씩 지울때
//		session.invalidate();//세션 다 날려버리기
//		response.sendRedirect(request.getContextPath() + "/index.jsp");//로그아웃했으니 보내버리기
//		System.out.println("로그아웃함");
//		
//	}
	@PostMapping(value="/user")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletResponse response) {
		
		logger.debug("로그인실행");

		boolean login = memberService.login(map);
		String id = map.get("userId");
		
		if(login) {			
			session.setAttribute("userId", id);		
		}else {
			model.addAttribute("msg","아이디 비번 확인후로그인");
		}	
		return "index";
	}
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
//	
//	private void citychange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String val = request.getParameter("city");
//		System.out.println(val);
//		
//		request.setAttribute("sel", val);
//		RequestDispatcher disp = request.getRequestDispatcher("inter_search.jsp");
//		disp.forward(request, response);
//		
//		
//	}
//
//	private void findPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		String id = request.getParameter("id");
//		String phoneNumber = request.getParameter("phone");
//		String name = request.getParameter("name");
//		String findPwd = memSer.findPassword(id, name, phoneNumber);
//		
//		if(findPwd==null) {
//			request.setAttribute("findpwd", "fail");
//		} else {
//			request.setAttribute("findpwd", findPwd);
//		}
//		
//		RequestDispatcher disp = request.getRequestDispatcher("passfind.jsp");
//		disp.forward(request, response);
//		
//	}
//	
//	private void trade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String dong = request.getParameter("dong");
//		System.out.println(dong);
//		
//		ArrayList<HouseDealDto> house = (ArrayList<HouseDealDto>) HousedealServiceImpl.getHousedealService().treadInfo(dong);
//		
//		for(int i=0;i<house.size();i++)
//			System.out.println(house.get(i).toString());
//		
//		
//		String path = "/inter_submit.jsp";
//		
//		
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("tradeinfo", house);
//		
//		request.setAttribute("tlist", house);
//		
//		RequestDispatcher disp = request.getRequestDispatcher(path);
//		disp.forward(request, response);
//	}
//
//	private void dong(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String gu = request.getParameter("gu");
//		String gu2 = null;
//		
//		if(gu!=null)
//		{
//		List<String> dong = HousedealServiceImpl.getHousedealService().dong(gu);
//		
//		System.out.println(dong);
//		String path = "/inter_submit.jsp";
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("gungu", gu);	//현재 구
//		session.setAttribute("dong", dong);	//동 리스트
//		
//		
//		RequestDispatcher disp = request.getRequestDispatcher(path);
//		disp.forward(request, response);
//		}
//		else
//		{
//			System.out.println("구2");
//			gu2 = request.getParameter("gu2");
//			
//			List<String> dong = HousedealServiceImpl.getHousedealService().dong(gu2);
//			
//			System.out.println(dong);
//			String path = "/inter_submit.jsp";
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("gungu", gu2);	//현재 구
//			session.setAttribute("dong", dong);	//동 리스트
//			
//			
//			RequestDispatcher disp = request.getRequestDispatcher(path);
//			disp.forward(request, response);
//			
//		}
//		
//	}
//
//	private void gungu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String city = request.getParameter("city");
//		String city2 =null;
//		if (city == null) {
//			System.out.println("시2");
//			city2 = request.getParameter("city2");
//
//			List<String> gu = HousedealServiceImpl.getHousedealService().gungu(city2);
//
//			System.out.println(gu);
//			String path = "/inter_submit.jsp";
//
//			HttpSession session = request.getSession();
//			session.setAttribute("ct", city2); // 현재 시
//			session.setAttribute("gu", gu); // 구리스트
//
//			RequestDispatcher disp = request.getRequestDispatcher(path);
//			disp.forward(request, response);
//		} else {
//			
//			List<String> gu = HousedealServiceImpl.getHousedealService().gungu(city);
//
//			System.out.println(gu);
//			String path = "/inter_submit.jsp";
//
//			HttpSession session = request.getSession();
//			session.setAttribute("ct", city); // 현재 시
//			session.setAttribute("gu", gu); // 구리스트
//
//			RequestDispatcher disp = request.getRequestDispatcher(path);
//			disp.forward(request, response);
//		}
//	}
//	
//	
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		doGet(request,response);
//	}
//	
//	
//	
//	
//	
	

}