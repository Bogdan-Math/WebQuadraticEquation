let validateParameters = function () {

    let a = $('#param_a').val(),
        b = $('#param_b').val(),
        c = $('#param_c').val(),
        solveButton = $('#solve');

    let isZero = function (param) {
        return parseInt(param) === 0;
    };

    let notEmpty = function (a, b, c) {
        return (a !== '' && b !== '' && c !== '');
    };

    let isNumeric = function (a, b, c) {
        return $.isNumeric(a) && $.isNumeric(b) && $.isNumeric(c);
    };

    if (isZero(a)) {
        solveButton.addClass('disabled');
        showAlert('info', FIRST_PARAMETER_DESCRIPTION);
        return;
    }

    if (isNumeric(a, b, c)) {
        solveButton.removeClass('disabled');
        new showAlert('info', WRIGHT_PARAMETERS);
    } else {
        solveButton.addClass('disabled');
        if (notEmpty(a, b, c)) {
            showAlert('info', WRONG_PARAMETERS);
        }
    }
};