
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page language="java" import="cblog.utils.RelativeDateFormat"%>
<%@ taglib prefix="relDate" uri="/WEB-INF/tld/relativeDateFormat.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"/>
<!-- showBlog start-->
<div class="stream-item" id="loop-${row.id}">
    <div class="p-rank clearfix">
        <div class="users">
            <a href="${base}/ta/${row.author.id}">
                <div class="ava">
                    <c:if test="${row.author.avatar} != null">
                        <img class="img-circle" src="${base}${row.author.avatar}"/>
                    </c:if>
                </div>
                <div class="info">
                    <strong>${row.author.name}</strong>
                    <time><fmt:formatDate value="${row.created}" pattern="yyyy-MM-dd" /></time>
                    <time>${relDate:format(${row.created})}</time>
                </div>
            </a>
        </div>
        <div class="counts">
            <span class="act"><i class="praise_icon"></i>${row.favors}</span>
            <span class="act"><i class="comment_icon"></i>${row.comments}</span>
        </div>
    </div>
    <div class="summary">
        <a href="${base}/view/${row.id}">
            <div class="title">
                <c:choose>
                <c:when test="${row.featured} > 1 && ${showFeatured}" >
                <span class="label label-danger">推荐</span>
                </c:when>
                <c:when test="${row.group} == 1">
                <span class="label label-success">文</span>
                </c:when>
                <c:when test="${row.group} == 2">
                <span class="label label-info">图</span>
                </c:when>
                <c:when test="${row.group} == 3">
                <span class="label label-violet">视频</span>
                </c:when>
                <c:otherwise>
                <span class="label label-warning">问</span>
                </c:otherwise>
                </c:choose>
                <h2><c:if test="${row.title}">${row.title}</c:if></h2></div>
            <div class="excerpt wordbreak hidden-xs"><c:if test="${row.summary}">${row.summary}</c:if> </div>
        </a>
        <!--前端图片显示样式-->
        <c:if test="${row.albums}">
        <!--Start-->
        <div class="thumbs clearfix">
            <c:forEach var="alb" items="${row.albums}">
                <c:if test="${velocityCount} <= 6">
            <div class="media col-xs-4 col-sm-4 col-md-4">
                <a title="${row.title}" href="#resource(${alb.original})">
                    <c:choose>
                    <c:when test="${alb.store} == 1">
                    <img src="${base}/assets/images/spinner-overlay.gif" data-original="${att.screenshot}"/>
                    </c:when>
                    <c:otherwise>
                    <img src="${base}/assets/images/spinner-overlay.gif" data-original="#resource(${att.screenshot})"/>
                    </c:otherwise>
                    </c:choose>
                </a>
            </div>
                </c:if>
            </c:forEach>
        </div>
        <!--End-->
        </c:if>

        <div class="foot-block clearfix">
            <ul class="tags">
                <c:forEach var="tag" items="${row.tagArray}">
                <li>
                    <a class="tag tag-sm" href="${base}/tag/${tag}/">${tag}</a>
                </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<!-- showBlog end-->

