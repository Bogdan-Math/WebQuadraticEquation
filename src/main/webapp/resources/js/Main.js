$(document).ready(function () {

    $('#param_a').on('change', validateParameters);
    $('#param_b').on('change', validateParameters);
    $('#param_c').on('change', validateParameters);

    $('#solve').on('click', sendRequest);
});