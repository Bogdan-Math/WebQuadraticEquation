let solveEquation = function () {
    $.ajax({
        headers: {'Content-Type': 'application/json'},
        type: 'POST',
        url: 'equation',
        data: JSON.stringify({
            'paramA': $('#param_a').val(),
            'paramB': $('#param_b').val(),
            'paramC': $('#param_c').val()
        }),
        success: handleSuccessSolving,
        error: handleErrorSolving
    });
};

let addChart = function () {
    $.ajax({
        headers: {'Content-Type': 'application/json'},
        type: 'POST',
        url: 'chart',
        success: drawChart
    });
};