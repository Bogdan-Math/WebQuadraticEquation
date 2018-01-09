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
                new SolutionsRenderer(solutions).show();
            },

            error: function () {
                new Alert(ERROR_DESCRIPTION).error();
            }
        });
    })
});
