
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"/>
<%--#contents(0, 'paging')--%>
<div class="shadow-box">
    <!-- tab -->
    <div class="filter">
        <ul class="">
            <li>
                <a
                <c:if test="${ord} =='newest'">
                    class="active"  href="${base}/?ord=newest"
                </c:if>
                ><i class="fa fa-newspaper-o"></i>最新的</a></li>
            <li>
                <a
                <c:if test="${ord} =='hottest'">
                    class="active"  href="${base}/?ord=hottest"
                </c:if>
                ><i class="fa fa-fire"></i>热门的</a></li>
        </ul>
    </div>
    <!-- tab end -->
    <!-- tab panes -->
    <div class="stream-list p-stream">
        <c:if test="${paging.results}">
            <c:forEach var="row" items="${paging.results}">
               <jsp:include page="showBlog.jsp"/>
            </c:forEach>
        </c:if>
        <c:if test="${paging.results.size()==0}">
        <div class="stream-item">
            该目录下还没有内容!
        </div>
        </c:if>
    </div>
</div>
<div class="text-center clr">
    <c:set var="url" value="index?ord=+${ord}"/>
   <%-- #page($url $paging 5)--%>
</div>

