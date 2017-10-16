<!-- 首页-->
<!DOCTYPE html>
<html lang="en-US">
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    <taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt">
    <title>Cblog</title>
    <jsp:include page="inc/params.jsp"/>
</head>
<body>
<jsp:include page="inc/header.jsp"/>

<!--.site-main -->
<div class="wrap" id="wrap">
    <div class="container">
        <div class="row">
            <div class="main clearfix">
                <!-- left -->
                <div class="col-xs-12 col-md-9 side-left">
                <jsp:include page="layout/index_style.jsp"/>
                </div>
                <!-- right sidebar-->
                <div class="col-xs-12 col-md-3 side-right hidden-xs hidden-sm">
                    <jsp:include page="inc/right.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="inc/footer.jsp"/>

<a href="#" class="site-scroll-top"></a>

<script type="text/javascript">
    seajs.use('main', function (main) {
        main.init();
    });
</script>
</body>
</html>

