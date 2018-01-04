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
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/popper.js/1.11.1/dist/popper.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

    <%--notification SCRIPTS--%>
    <script type="text/javascript" src="webjars/bootstrap-notify/3.1.3/bootstrap-notify.min.js"></script>

    <%--custom SCRIPTS--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>

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
            <a id="solve" href="#" class="btn btn-lg btn-outline-secondary">Solve it!</a>
            <div id="solution"></div>
        </div>
    </div>
</div>

<div class="container">
    <div id="result" class="text-center">
        <%--place for result--%>
    </div>
</div>

</body>
</html>
