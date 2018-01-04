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
