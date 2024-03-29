package libiada.FastChainAlgorithms.FastChain.Calculators;

import libiada.FastChainAlgorithms.FastChain.FastChain;
import libiada.FastChainAlgorithms.FastChain.FastUniformChain;
import libiada.FastChainAlgorithms.FastChain.Interfaces.IFastCalculator;
import libiada.IntervalAnalysis.LinkUp;

/**
 * Created by IntelliJ IDEA.
 * User: Alex
 * Date: 29.07.11
 * Time: 19:33
 */
public class FastAverageRemoteness implements IFastCalculator {
    @Override
    public double getValue(FastChain chain, LinkUp linkUp) throws Exception {
        double n = FastCalculatorFactory.getEventCount().getValue(chain, linkUp);
        double gamaut = FastCalculatorFactory.getGamaut().getValue(chain, linkUp);
        return gamaut / n;
    }

    @Override
    public double getValue(FastUniformChain chain, LinkUp linkUp) throws Exception {
        double n = FastCalculatorFactory.getEventCount().getValue(chain, linkUp);
        double gamaut = FastCalculatorFactory.getGamaut().getValue(chain, linkUp);
        return gamaut / n;
    }

    @Override
    public String getName() {
        return "g";
    }
}
