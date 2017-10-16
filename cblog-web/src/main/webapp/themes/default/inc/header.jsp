<!-- Login dialog BEGIN -->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div id="loginalert" style="display: none; top: 0px;" class="fade in">
    <div class="pd20 loginpd">
        <h3><i class="closealert fr" data-dismiss="modal" aria-label="Close"></i><div class="clear"></div></h3>
        <div class="loginwrap">
            <div class="loginh">
                <div class="fl">会员登录</div>
                <div class="fr">还没有账号<a id="sigup_now" href="${base}/reg">立即注册</a></div>
            </div>
            <h3><span class="login_warning" id="login_warning" style="display: none;">用户名或密码错误</span><div class="clear"></div></h3>
            <form action="" method="post" id="login_form">
                <div class="logininput">
                    <input type="text" id="alt_un" name="username" class="loginusername" value="" placeholder="用户名">
                    <input type="password" id="alt_pw" name="password" class="loginuserpasswordp" placeholder="密码">
                </div>
                <div class="loginbtn">
                    <div class="loginsubmit fl"><input type="button" value="登录" id="alt_login" class="btn"></div>
                    <!--
                    <div class="fr" style="margin:26px 0 0 0;"><a href="##">忘记密码?</a></div>
                    -->
                    <div class="clear"></div>
                </div>
            </form>
        </div>
    </div>
    <div class="thirdlogin">
        <div class="pd50">
            <h4>用第三方帐号直接登录</h4>
            <ul>
                <li id="sinal"><a href="${base}/oauth/callback/call_weibo">微博帐号注册</a></li>
                <li id="qql" style="margin-right: 0px;"><a href="${base}/oauth/callback/call_qq">QQ帐号注册</a></li>
            </ul>
            <div class="clear"></div>
        </div>
    </div>
</div>
<!-- Login dialog END -->

<!-- Header BEGIN -->
<div class="top-wrap">
    <nav class="navbar navbar-inverse" role="navigation">
    	<div class="container">
    		<div class="navbar-header">
    			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
    				<span class="sr-only">Toggle navigation</span>
    				<span class="icon-bar"></span>
    				<span class="icon-bar"></span>
    				<span class="icon-bar"></span>
    			</button>
    			<a class="navbar-brand logo" href="${base}/index"><img src="${base}/assets/images/logo/m42.png" style="border-radius: 2px"></a>
    		</div>
    		<div id="navbar" class="navbar-collapse collapse">
    			<ul class="nav navbar-nav">
                    <c:if test="${profile != null}">
    				<li data="home">
    					<a href="${base}/home" nav="home">主页</a>
    				</li>
                    </c:if>

					<c:if test="${menus != null}">
					<c:forEach var="m" items="${menus}">
					<li>
    					<a href="${base}/${m.url}" nav="${m.name}" target="${m.target}">${m.name}</a>
    				</li>
                    </c:forEach>
                    </c:if>

    			</ul>
    			<div id="_search_box" class="search-box navbar-left hidden-xs hidden-sm">
    				<form class="navbar-form" method="get" action="${base}/browse/search">
    					<input type="text" class="form-control" name="q" placeholder="搜索...">
						<button class="search-btn" type="submit"><i class="fa fa-search"></i></button>
    				</form>
    			</div>
    			
    			<ul class="nav navbar-nav navbar-right sign">
                    <c:choose>
                    <c:when test="${profile != null}">
					<li class="dropdown">
                        <a href="#" class="publish dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-magic"></i> 发布
                        </a>
                    	<ul class="dropdown-menu publishs" role="menu">
                        <c:if test="${groups != null}">
						<c:forEach var="g" items="${groups}" >
                        	<li>
                                <a href="${base}/post/new/${g.key}">
                                    <i class="${g.icon} icon"></i>
                                    <span>${g.alias}</span>
                                </a>
							</li>
                        </c:forEach>
						</c:if>
						</ul>
					</li>
    				<li class="dropdown">
    					<a href="#" class="ava dropdown-toggle" data-toggle="dropdown">
    						<img class="img-circle" src="${base}${profile.avatar}">
    					</a>
    					<ul class="dropdown-menu" role="menu">
    		                <li>
    		                	<a href="${base}/account/profile" class="ava">
                                    <c:choose>
                                        <c:when test="${profile.avatar}.startWitdh('http:')">
                                            <img class="img-circle" src="${profile.avatar}"/>
                                        </c:when>
                                        <c:otherwise>
                                            <img class="img-circle" src="${base}${profile.avatar}"
                                        </c:otherwise>
                                    </c:choose>
    		                		<span>${profile.username}</span>
    		                	</a>
    		               	</li>
    		                <li class="divider"></li>
                                 <shiro:hasPermission name="admin">
								<li><a href="${base}/admin">后台管理</a></li>
                                 </shiro:hasPermission>
							
    		                <li><a href="${base}/logout">退出</a></li>
    		              </ul>
    				</li>
                    </c:when >
    				<c:otherwise>
    				<li><a href="${base}/login" class="signin">登录</a></li>
                    <li class="hidden-xs"><span class="or">or</span></li>
                    <li><a href="${base}/reg" class="signup">注册</a></li>
                    </c:otherwise>
                </c:choose>
    			</ul>
    		</div>
    	</div>
    </nav>
</div>
<script type="text/javascript">
$(function () {
	$('a[nav]').each(function(){  
        $this = $(this);
        if($this[0].href == String(window.location)){  
            $this.closest('li').addClass("active");  
        }  
    });
});
</script>
<!-- Header END -->