<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>

</head>
<body>
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
