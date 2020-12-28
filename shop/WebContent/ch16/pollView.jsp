<%@page import="java.util.Random"%>
<%@page import="ch16.model.PollListBean"%>
<%@page import="ch16.dao.PollMgr"%>
<%@page import="ch16.model.PollItemBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	PollMgr pMgr = new PollMgr();
	request.setCharacterEncoding("EUC-KR");
	int num = 0;
	if (request.getParameter("num") != null) {
		num = Integer.parseInt(request.getParameter("num"));
	}
	int sum = pMgr.sumCount(num);
	Vector<PollItemBean> vlist = pMgr.getView(num);
	PollListBean plBean = pMgr.getList(num);
	String question = plBean.getQuestion();
	Random r = new Random();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Poll</title>
</head>
<body bgcolor="#FFFFCC">
	<div align="center">
		<table border="1" width="400">
			<tr>
				<td colspan="4"><b>Q : <%=question%></b></td>
			</tr>
			<tr>
				<td colspan="3"><b>총 투표자 : <%=sum%>명</b></td>
				<td width="40">count</td>
			</tr>
			<%
				for (int i = 0; i < vlist.size(); i++) {
					PollItemBean piBean = vlist.get(i);
					String[] item = piBean.getItem(); // 아이템 ex)김태희
					int rgb = r.nextInt(255 * 255 * 255);
					String rgbt = Integer.toHexString(rgb);
					String hRGB = "#" + rgbt;
					int count = piBean.getCount(); // 투표수
					int ratio = (new Double(Math.ceil((double) count / sum * 100))).intValue();
			%>
			<tr>
				<td width="20" align="center"><%=i+1%></td>
				<td width="120"><%=item[0]%></td>
				<td>
					<table width="<%=ratio%>" height="15">
						<tr>
							<td bgcolor="<%=hRGB%>"></td>
						</tr>
					</table>
				</td>
				<td width="40"><%=count%></td>
			</tr>
			<%} //for%>
		</table>
		<p />
		<a href="javascript:window.close()">닫기</a>
	</div>
</body>
</html>