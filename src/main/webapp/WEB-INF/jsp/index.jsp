<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>

    <%--Bootstrap STYLES--%>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">

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

    <%--JQuery SCRIPTS--%>
    <script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>


    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-growl/1.0.0/jquery.bootstrap-growl.min.js"></script>

<%--Custom STYLES--%>
    <style>
        input {
            text-align: right;
        }
    </style>

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
<div id="solved-alert" class="alert alert-success .alert-dismissible" role="alert" style="display:none;">
<%--
    <button type="button" class="close" data-dismiss="alert">
        <span aria-hidden="true">&times;</span>
    </button>
--%>
    <strong>Well done!</strong> You successfully read this important alert message.
</div>

<script>

    $(document).ready(function () {


        $('#solve').on('click', function () {
            $.bootstrapGrowl("Danger, Danger!", {
                type: 'danger',
                align: 'center',
                width: '400',
                allow_dismiss: true,
                delay: -1
            });

            var param_a = $('#param_a').val(),
                param_b = $('#param_b').val(),
                param_c = $('#param_c').val();

            if ($.isNumeric(param_a) && parseInt(param_a) === 0) {
                alert('First parameter COULDN\'T be zero!!!'); return;
            }

            if (!($.isNumeric(param_a) && $.isNumeric(param_b) && $.isNumeric(param_c))) {
                alert('Input only numbers!'); return;
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

                        var oneSolution = solutions.length === 1,
                            twoSolutions = solutions.length === 2;

                        if (oneSolution) $('#solution')
                            .text('Equation has ONE solution:  ' + 'x = ' + solutions[0]);
                        if (twoSolutions) $('#solution')
                            .text('Equation has TWO solutions:  ' + 'x1 = ' + solutions[0] + ', ' +
                                                                    'x2 = ' + solutions[1]);
                    } else {
                        $('#solution').text('DISCRIMINANT less then zero! Equation has no result in natural numbers!');
                    }
                    $.bootstrapGrowl('We do have the Kapua suite available.', {
                        type: 'success',
                        delay: 3000
                    });
                },

                error: function () {
                    $.bootstrapGrowl('Oops, something WRONG happened. :(', {
                        type: 'danger',
                        delay: 3000
                    });
                }
            });
        })
    });

</script>

</body>

</html>
