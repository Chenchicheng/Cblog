<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <title>我的主页</title>
    <jsp:include page="../inc/params.jsp"/>
</head>
<body>
    <jsp:include page="../inc/header.jsp"/>
<!--.site-main -->
<div class="wrap" id="wrap">
    <div class="container">
        <div class="row">
            <div class="main clearfix">
                <!-- left -->
                <div class="col-xs-12 col-md-3 side-left">
                    <jsp:include page="left.jsp"/>
                   
                </div>

                <div class="col-xs-12 col-md-9 side-right">
                    
                    <div class="shadow-box">
                        <div class="filter">
                            <ul class="">
                                <li><a class="active" href="${base}/home">动态</a></li>
                            </ul>
                        </div>
                        <!-- tab panes -->
                        <div class="stream-list p-stream">
                            <c:if test="${page.results != null}">
                                <c:forEach var="row" items="${page.results}">
                                   <c:if test="${row.post != null}">
                                     showBlog(${row.post})
                                   </c:if>
                                </c:forEach>
                            </c:if>
                        <c:if test="${page.result.size() == 0}">
                            <div class="stream-item">
                                <i class="fa fa-info-circle fa-lg"></i> 没有动态,赶紧去关注別人吧!
                            </div>
                        </c:if>

                        </div>
                    </div>
                    <div class="text-center clr">
                   <%-- page("home" ${page} 5)--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <jsp:include page="../inc/footer.jsp"/>

<a href="#" class="site-scroll-top"></a>

<script type="text/javascript">
    seajs.use('main', function (main) {
        main.init();
    });
</script>
</body>
</html>



