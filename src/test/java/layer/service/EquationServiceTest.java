package layer.service;

import layer.service.instance.EquationServiceInstance;
import model.Equation;
import model.Solution;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EquationServiceTest {

    private EquationService equationService;
    private Equation equation;

    @Before
    public void setUp() {
        this.equationService = new EquationServiceInstance();
        this.equation = new Equation();
    }

    @Test
    public void solveEquationDiscriminantEqualToZero() {
        // Arrange
        Double one = 1d;
        equation.setParamA(1);
        equation.setParamB(-2);
        equation.setParamC(1);

        // Act
        equationService.solve(equation);

        //Assert
        assertEquals(1, equation.solutions().size());
        assertTrue(equation.solutions().stream()
                .map(Solution::getX)
                .anyMatch(x -> x.equals(one)));
    }

    @Test
    public void save() {
        //TODO: add test by TDD style
    }
}