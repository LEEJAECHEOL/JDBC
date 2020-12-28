<%@page import="ch16.dao.PollMgr"%>
<%@page import="ch16.model.PollListBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Poll</title>
</head>
<body bgcolor="#FFFFCC">
	<div align="center">
		<br/>
		<h2>투표 프로그램</h2>
		<hr width="600"/>
		<b>설문 폼</b>
		<jsp:include page="pollForm.jsp" />
		<hr width="600"/>
		<b>설문리스트</b>
		<table>
			<tr>
				<td>
					<table width="500" border="1">
						<tr>
							<td align="center"><b>번호</b></td>
							<td><b>제목</b></td>
							<td><b>시작일 ~ 종료일</b></td>
						</tr>
						<%
							PollMgr pMgr = new PollMgr();
							Vector<PollListBean> vlist = pMgr.getAllList();

							int count = vlist.size();
							for (int i = 0; i < vlist.size(); i++) {
								PollListBean plBean = vlist.get(i);
								int num = plBean.getNum();
								String question = plBean.getQuestion();
								String sdate = plBean.getSdate();
								String edate = plBean.getEdate();

								out.println("	<tr><td align='center'>" + count + "</td>");
								out.println("<td><a href='pollList.jsp?num=" + num + "'>"
										+ question + "</a></td>");
								out.println("<td>" + sdate +" ~ "+ edate + "</td></tr>");
								count = count - 1;
							}
						%>
					</table>
				</td>
			</tr>
			<tr>
				<td align="right"><a href="pollInsert.jsp">설문 작성하기</a></td>
			</tr>
		</table>
	</div>
</body>
</html>