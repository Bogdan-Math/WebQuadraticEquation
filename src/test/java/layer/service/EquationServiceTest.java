package layer.service;

import layer.repository.BaseEntityRepository;
import layer.service.instance.EquationServiceInstance;
import model.Equation;
import model.Solution;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EquationServiceTest {

    private EquationService equationService;
    private BaseEntityRepository<Equation> equationRepository;
    private Equation equation;

    @Before
    public void setUp() {
        this.equationService = new EquationServiceInstance();
        this.equationRepository = new BaseEntityRepository<Equation>() {
            @Override
            public Equation check(Equation entity) {
                return equation;
            }

            @Override
            public Equation save(Equation entity) {
                return entity;
            }
        };
        this.equation = new Equation() {{
            setParamA(1);
            setParamB(-2);
            setParamC(1);
        }};
    }

    @Test
    public void solveEquationDiscriminantEqualToZero() {
        // Arrange
        Double one = 1d;

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
        equationService.save(equation);
    }
}