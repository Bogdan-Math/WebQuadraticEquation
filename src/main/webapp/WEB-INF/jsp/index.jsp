<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Quadratic Equation</title>

    <%--Bootstrap STYLES--%>
    <link rel="stylesheet"
          href="webjars/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">

    <%--notification ANIMATION--%>
    <link rel="stylesheet"
          href="webjars/animate.css/3.5.2/animate.min.css">

    <%--Custom STYLES--%>
    <link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/main.css">

    <%--Bootstrap SCRIPTS--%>
    <script type="text/javascript" src="webjars/jquery/3.0.0/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/popper.js/1.11.1/dist/umd/popper.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

    <%--notification SCRIPTS--%>
    <script type="text/javascript" src="webjars/bootstrap-notify/3.1.3/bootstrap-notify.min.js"></script>

    <%--custom SCRIPTS--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Alert.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Chart.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Constant.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Main.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Requests.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ResponseHandler.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Validator.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>

</head>
<body>

<div class="jumbotron">
    <div class="container">

        <div class="row justify-content-center form-inline">
            <div class="col-lg-2">
                <div class="input-group">
                    <input id="param_a" type="text" class="form-control" placeholder="a">
                    <span class="input-group-addon">
                        x<sup>2</sup>
                    </span>
                </div>
            </div>
            <b>+</b>
            <div class="col-lg-2">
                <div class="input-group">
                    <input id="param_b" type="text" class="form-control" placeholder="b">
                    <span class="input-group-addon">
                        x
                    </span>
                </div>
            </div>
            <b>+</b>
            <div class="col-lg-2">
                <div class="input-group">
                    <input id="param_c" type="text" class="form-control" placeholder="c">
                </div>
            </div>
            <b>=</b>
            <div class="col-lg-1">
                <div class="input-group">
                    <span class="input-group-addon">
                        0
                    </span>
                </div>
            </div>
            <a id="solve" href="#" class="btn btn-lg btn-outline-secondary disabled">Solve it!</a>
        </div>
    </div>
</div>

<div class="container">
    <div id="result" class="text-center">
        <div>&nbsp;</div>
    </div>
</div>

<div class="container">
    <canvas id="chart" width="900" height="600"></canvas>
</div>

</body>
</html>
