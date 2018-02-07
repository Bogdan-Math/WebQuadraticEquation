let handleSuccess = function (solutions) {
    let drawChart = function () {
        let ctx = document.getElementById("chart").getContext('2d');
        $.ajax({
            headers: {'Content-Type': 'application/json'},
            type: 'POST',
            url: 'chart',
            success: function (chart) {
                let points = chart.points,
                    suggestedMinX = chart.suggestedMinX,
                    suggestedMaxX = chart.suggestedMaxX,
                    suggestedMinY = chart.suggestedMinY,
                    suggestedMaxY = chart.suggestedMaxY;

                new Chart(ctx, {
                    type: 'line',
                    data: {
                        datasets: [{
                            fill: false,
                            borderColor: 'rgb(0, 0, 0)',
                            data: points
                        }]
                    },
                    options: {
                        legend: {
                            display: false
                        },
                        tooltips: {
                            enabled: false
                        },
                        scales: {
                            xAxes: [{
                                display: true,
                                type: 'linear',
                                ticks: {
                                    suggestedMin: suggestedMinX,
                                    suggestedMax: suggestedMaxX
                                }
                            }],
                            yAxes: [{
                                display: true,
                                type: 'linear',
                                ticks: {
                                    suggestedMin: suggestedMinY,
                                    suggestedMax: suggestedMaxY
                                }
                            }]

                        }
                    }
                });
            }
        });
    };
    let solutionsExists = solutions.length > 0;

    if (solutionsExists) {

        let oneSolution = solutions.length === 1,
            twoSolutions = solutions.length === 2,
            x1 = solutions[0],
            x2 = solutions[1];

        if (oneSolution) {
            $('#result').html(
                "<math>" +
                "x<sub>1,2</sub>=" + x1 +
                "</math>"
            );
            showAlert('success', ONE_SOLUTION_DESCRIPTION);
            drawChart();
        }

        if (twoSolutions) {
            $('#result').html(
                "<math>" +
                "x<sub>1</sub>=" + x1 +
                "</math>" +
                "&nbsp;&nbsp;&nbsp;" +
                "<math>" +
                "x<sub>2</sub>=" + x2 +
                "</math>"
            );
            showAlert('success', TWO_SOLUTIONS_DESCRIPTION);
            drawChart();
        }
    } else {
        showAlert('warning', DISCRIMINANT_DESCRIPTION);
    }
};

let handleError = function () {
    showAlert('danger', ERROR_DESCRIPTION);
};