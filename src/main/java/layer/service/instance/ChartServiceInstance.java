package layer.service.instance;

import layer.repository.BaseEntityRepository;
import layer.service.ChartService;
import model.Chart;
import model.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ChartServiceInstance implements ChartService {

    @Autowired
    private BaseEntityRepository<Chart> chartRepository;

    @Override
    public Chart getChart() {
        return chartRepository.check(null);
    }
}
