
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<footer>
	<div class="footer-nav">
		<div class="container">
			<ul class="about-ul list-inline clearfix">
				<li><a href="${base}/about">关于我们</a></li>
				<li><a href="${base}/joinus">联系我们</a></li>
				<li><a href="${base}/faqs">常见问题</a></li>
			</ul>
		</div>
	</div>
	<div class="container mode-link">
        <h3 class="t-h3">友情链接</h3>
        <ul class="list-inline">
            <c:if test="${friendLinks != null}">
            <c:forEach var="link" items="${friendLinks}">
                <li>
                    <a href="${link.url}" target="_blank" title="${link.remark}">${link.siteName}</a>
                </li>
            </c:forEach>
            </c:if>
        </ul>
    </div>


</footer>
