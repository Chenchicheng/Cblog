<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<ul class="list-group about-user">
    <li class="list-group-item user-card" >
        <div class="ava">
            <a href="${base}/ta/${user.id}">
                <c:choose>
           <c:when test="${user.avatar}.startWitdh('http:')">
               <img class="img-circle" src="${user.avatar}"/>
           </c:when>
           <c:otherwise>
               <img class="img-circle" src="${base}${user.avatar}"
           </c:otherwise>
                </c:choose>

            </a>
        </div>
        <div class="user-info">
            <div class="nk mb10">${user.username}</div>
            <div class="mb6">
                <a class="btn btn-success btn-xs" href="${base}/account/profile"><i class="fa fa-pencil"></i> 修改账户</a>
            </div>
        </div>
    </li>
</ul>
<nav class="navbar navbar-default shadow-box">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#home-navbar" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <span class="navbar-brand">导航</span>
        </div>
    </div>
    <div id="home-navbar" class="collapse navbar-collapse">
        <ul class="list-group user-nav first">
            <li class="list-group-item">
                <a href="${base}/home"><i class="fa fa-feed"></i> 动态</a>
            </li>
            <li class="list-group-item">
                <a href="${base}/home?method=posts"><i class="fa fa-file-text-o"></i> 我的文章</a>
            </li>
            <li class="list-group-item">
                <a href="${base}/home?method=comments"><i class="fa fa-comment-o"></i> 我的评论</a>
            </li>
        </ul>

        <ul class="list-group user-nav">
            <li class="list-group-item">
                <a href="${base}/home/favors"><i class="fa fa-heart-o"></i> 我的喜欢</a>
            </li>
            <li class="list-group-item">
                <a href="${base}/home/follows"><i class="fa fa-eye"></i> 我的关注</a>
            </li>
            <li class="list-group-item">
                <a href="${base}/home/fans"><i class="fa fa-users"></i> 我的粉丝</a>
            </li>
        </ul>

        <ul class="list-group user-nav">
            <li class="list-group-item">
                <a href="${base}/home/notifies">
                    <i class="fa fa-bell-o"></i> 通知

                          <span class="label label-danger">
                            <%--  <c:if test="${profile != null}">
                          ${profile.badgesCount.notifies}
                              </c:if>--%>
                          </span>


                </a>
            </li>
        </ul>
    </div>
</nav>
