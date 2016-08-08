<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>代办事物</title>
	<meta name="decorator" content="default"/>
</head>
<body>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<tr><th>标题</th><th>当前活动</th><th>到达时间</th><th>发送人</th><th>操作</th></tr>
		<c:forEach items="${list}" var="waitjobs">
			<tr>
				<td><a href="${waitjobs.url}">${waitjobs.title}</a></td>
				<td>${waitjobs.presentActiviti}</td>
				<td>${fns:formatDateTime(waitjobs.arriveData)}</td>
				<td>${waitjobs.user.name}</td>
				<td>
					<a href="${waitjobs.url}">查看详情</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>