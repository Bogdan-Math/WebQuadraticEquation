$(document).ready(function () {

    var param_a = $('#param_a'),
        param_b = $('#param_b'),
        param_c = $('#param_c'),
        solveButton = $('#solve');

    var validateParamA = function () {
        if (parseInt(this.value) === 0) {
            solveButton.addClass('disabled');
            new Alert(FIRST_PARAMETER_DESCRIPTION).info();
        }
    };

    var notEmpty = function(a, b, c) {
        return (a !== '' && b !== '' && c !== '');
    };

    var isNumeric = function(a, b, c) {
        return $.isNumeric(a) && $.isNumeric(b) && $.isNumeric(c);
    };

    var validateParameters = function () {
        var a = param_a.val();
        var b = param_b.val();
        var c = param_c.val();
        if (isNumeric(a, b, c)) {
            solveButton.removeClass('disabled');
            new Alert(WRIGHT_PARAMETERS).info();
        } else {
            solveButton.addClass('disabled');
            if (notEmpty(a, b, c)) {
                new Alert(WRONG_PARAMETERS).info();
            }
        }
    };

    var sendRequest = function () {
        $.ajax({
            headers: {'Content-Type': 'application/json'},
            type: 'POST',
            url: 'equation',
            data: JSON.stringify({
                'paramA': param_a.val(),
                'paramB': param_b.val(),
                'paramC': param_c.val()
            }),

            success: function (solutions) {
                new SolutionsRenderer(solutions).show();
            },

            error: function () {
                new Alert(ERROR_DESCRIPTION).error();
            }
        });
    };

    param_a.on('change', validateParamA);
    param_a.on('change', validateParameters);
    param_b.on('change', validateParameters);
    param_c.on('change', validateParameters);
    solveButton.on('click', sendRequest);
});