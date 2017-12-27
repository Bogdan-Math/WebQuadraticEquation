<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

            if ($.isNumeric(param_a) && $.isNumeric(param_b) && $.isNumeric(param_c)) {

                 $.ajax({
                 headers: {
                 'Content-Type': 'application/json'
                 },
                 type: 'POST',
                 url: 'equation',
                 data: JSON.stringify({
                 'paramA': param_a,
                 'paramB': param_b,
                 'paramC': param_c
                 }),

                 success: function (solutions) {
                     if (solutions) {

                         solutions = solutions.map(function (solution) {
                             return solution.x;
                         });

                         var x1 = solutions[0],
                             x2 = solutions[1];

                         if (solutions.length === 1) {
                             $('#solution').text('Equation has ONE solution:' + 'x = ' + x1);
                         }
                         else {
                             $('#solution').text('Equation has TWO solutions:' + 'x1 = ' + x1 + ', x2 = ' + x2);
                         }
                     }
                    else {
                         $('#solution').text('DISCRIMINANT less then zero! Equation has no result in natural numbers!');
                     }
                 },

                 error: function () {
                     alert('Oops, something WRONG happened. :(');
                 }
                 });

            }
            else {
                alert('Input only numbers!');
            }
        });

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
