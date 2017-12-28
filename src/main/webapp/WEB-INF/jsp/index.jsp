<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
          crossorigin="anonymous">

</head>
<body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
        integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
        integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
        crossorigin="anonymous"></script>

<div class="row justify-content-center">
    <div class="col-lg-1">
        <div class="input-group">
            <span class="input-group-addon">$</span>
            <input type="text" class="form-control">
        </div>
    </div>
    <div class="col-lg-1">
        <div class="input-group">
            <span class="input-group-addon">0.00</span>
            <input type="text" class="form-control">
        </div>
    </div>
    <div class="col-lg-1">
        <div class="input-group">
            <span class="input-group-addon">0.00</span>
            <input type="text" class="form-control">
        </div>
    </div>
</div>

<script>

    $(document).ready(function () {

        $('#send').on('click', function () {

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
                },

                error: function () {
                    alert('Oops, something WRONG happened. :(');
                }
            });
        })
    });

</script>

<label>
    <input id="param_a" type="text">
</label>
<label>
    <input id="param_b" type="text">
</label>
<label>
    <input id="param_c" type="text">
</label>

<div id="solution"></div>

<button id="send">send</button>
</body>
</html>
