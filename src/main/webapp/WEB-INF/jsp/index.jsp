<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>

    <%--Bootstrap STYLES--%>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">

    <%--notification ANIMATION--%>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">

    <%--Custom STYLES--%>
    <link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/main.css">

    <%--Bootstrap SCRIPTS--%>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
            integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
            integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
            crossorigin="anonymous"></script>

    <%--jQuery SCRIPTS--%>
    <script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>

    <%--notification SCRIPTS--%>
    <script type="text/javascript" src="webjars/bootstrap-notify/3.1.3/bootstrap-notify.min.js"></script>

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

    </div>
</div>

<script>

    $(document).ready(function () {

        var alert = function(text, type) {
                $.notify({message: text},
                    {
                        type: type,
                        placement: {
                            from : "bottom",
                            align: "right"
                        }
                    }
                );
            },

            infoAlert = function (text) {
                alert(text, 'info');
            },

            warningAlert = function (text) {
                alert(text, 'warning');
            },

            errorAlert = function(text) {
                alert(text, 'danger');
            },

            successAlert = function(text) {
                alert(text, 'success');
            };


        $('#solve').on('click', function () {

            var param_a = $('#param_a').val(),
                param_b = $('#param_b').val(),
                param_c = $('#param_c').val();

            if (!($.isNumeric(param_a) && $.isNumeric(param_b) && $.isNumeric(param_c))) {
                infoAlert("<strong>a, b, c</strong> - parameters! " +
                    "They <strong>COULD NOT</strong> be empty, and <strong>SHOULD BE</strong> a number!"); return;
            }

            if (parseInt(param_a) === 0) {
                infoAlert("First parameter <strong>COULD NOT</strong> be zero!"); return;
            }

            $.ajax({
                headers: {'Content-Type': 'application/json'},
                type: 'POST',
                url: 'equation',
                data: JSON.stringify({
                    'paramA': param_a,
                    'paramB': param_b,
                    'paramC': param_c
                }),

                success: function (solutions) {
                    var solutionsExists = solutions.length > 0;
                    if (solutionsExists) {
                        solutions = solutions.map(function (solution) {
                            return solution.x;
                        });

                        var oneSolution  = solutions.length === 1,
                            twoSolutions = solutions.length === 2,
                            x1 = solutions[0],
                            x2 = solutions[1];

                        if (oneSolution) {
                            $('#result').html("" +
                                "<math>" +
                                "x<sub>1,2</sub>=" + x1 +
                                "</math>");
                            successAlert("Equation has <b>ONE</b> solution:" +
                                "<br>" +
                                "<b>x</b> = " + "<b>" + x1 + "</b>");
                        }

                        if (twoSolutions) {
                            $('#result').html("" +
                                "<math>" +
                                    "x<sub>1</sub>=" + x1 +
                                "</math>" +
                                "&nbsp;&nbsp;&nbsp;" +
                                "<math>" +
                                    "x<sub>2</sub>=" + x2 +
                                "</math>");
                            successAlert("Equation has <b>TWO</b> solutions:" +
                                "<br>" +
                                "<b>x1</b> = " + "<b>" + x1 + "</b>" +
                                "<br>" +
                                "<b>x2</b> = " + "<b>" + x2 + "</b>");
                        }
                    } else {
                        warningAlert("<strong>DISCRIMINANT</strong> less then zero! Equation has no result in natural numbers!");
                    }
                },

                error: function () {
                    errorAlert('Oops, something WRONG happened. :(');
                }
            });
        })
    });

</script>

</body>

</html>
