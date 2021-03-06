let handleSuccessSolving = function (solutions) {
    let solutionsExists = solutions.length > 0;

    if (solutionsExists) {

        let oneSolution  = solutions.length === 1,
            twoSolutions = solutions.length === 2,
            x1 = solutions[0],
            x2 = solutions[1],

            drawOneSolution = function () {
                $('#result').html(
                    "<math>" +
                    "x<sub>1,2</sub>=" + x1 +
                    "</math>"
                );
            },

            drawTwoSolutions = function () {
                $('#result').html(
                    "<math>" +
                    "x<sub>1</sub>=" + x1 +
                    "</math>" +
                    "&nbsp;&nbsp;&nbsp;" +
                    "<math>" +
                    "x<sub>2</sub>=" + x2 +
                    "</math>"
                );
            };

        if (oneSolution) {
            drawOneSolution();
            showAlert('success', ONE_SOLUTION);
        }

        if (twoSolutions) {
            drawTwoSolutions();
            showAlert('success', TWO_SOLUTIONS);
        }
    } else {
        $('#result').html("&nbsp;");
        showAlert('warning', DISCRIMINANT_LESS_THAN_ZERO);
    }
    drawChartRequest();
};

let handleErrorSolving = function () {
    showAlert('danger', ERROR_DESCRIPTION);
};