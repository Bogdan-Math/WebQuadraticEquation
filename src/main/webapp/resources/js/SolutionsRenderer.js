function SolutionsRenderer(solutions) {
    this.solutions = solutions;

    this.show = function () {
        var me = this,
            solutionsExists = me.solutions.length > 0;

        if (solutionsExists) {
            solutions = solutions.map(function (solution) {
                return solution.x;
            });

            var oneSolution  = solutions.length === 1,
                twoSolutions = solutions.length === 2,
                x1 = solutions[0],
                x2 = solutions[1];

            if (oneSolution) {
                $('#result').html(
                    "<math>" +
                        "x<sub>1,2</sub>=" + x1 +
                    "</math>"
                );
                new Alert(ONE_SOLUTION_DESCRIPTION).success();
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
                new Alert(TWO_SOLUTIONS_DESCRIPTION).success();
            }
        } else {
            new Alert(DISCRIMINANT_DESCRIPTION).warning();
        }

    }
}