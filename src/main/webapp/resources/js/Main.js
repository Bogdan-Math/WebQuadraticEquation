$(document).ready(function () {

    $('#solve').on('click', function () {

        var param_a = $('#param_a').val(),
            param_b = $('#param_b').val(),
            param_c = $('#param_c').val();

        if (!($.isNumeric(param_a) && $.isNumeric(param_b) && $.isNumeric(param_c))) {
            new Alert(PARAMETERS_DESCRIPTION).info(); return;
        }

        if (parseInt(param_a) === 0) {
            new Alert(FIRST_PARAMETER_DESCRIPTION).info(); return;
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
                        new Alert(ONE_SOLUTION_DESCRIPTION).success();
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
                        new Alert(TWO_SOLUTIONS_DESCRIPTION).success();
                    }
                } else {
                    new Alert(DISCRIMINANT_DESCRIPTION).warning();
                }
            },

            error: function () {
                new Alert(ERROR_DESCRIPTION).error();
            }
        });
    })
});
