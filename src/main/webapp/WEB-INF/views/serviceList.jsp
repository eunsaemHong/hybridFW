<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 

<%@ page session="false" %>
<html>
<head>
	<title>serviceList</title>
</head>
<body>

	<table>

                <tbody>
                <c:forEach items="${serviceList}" var="svc" varStatus="varnum">
               <%--  <c:if test="${varnum.index%2==0}">
               ggh
               </c:if> --%>
                    <tr>
                    
                        <td> <a href="<c:url value='/fileDownload?fileid=${svc.svcId}'/>">${svc.svcId} 파일다운로드</a></td>
                        <td>${svc.svcName}</td>
                        <td>${svc.svcDescription}</td>
                        <td>${svc.svcAssetVer}</td>
                        <td>${svc.userId}</td>
                        <td>${svc.createDate}</td>
                        <td>${svc.lastUpdateDate}</td>
                        <td>${svc.createUserId}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            
            </table>
           

</body>
</html>
