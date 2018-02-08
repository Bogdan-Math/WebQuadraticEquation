let drawChart = function (chart) {
    let points = chart.points,
        suggestedMinX = chart.suggestedMinX,
        suggestedMaxX = chart.suggestedMaxX,
        suggestedMinY = chart.suggestedMinY,
        suggestedMaxY = chart.suggestedMaxY;

    let ctx = document.getElementById("chart").getContext('2d');
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
};