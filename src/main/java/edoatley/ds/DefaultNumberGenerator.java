package edoatley.ds;

import java.math.BigDecimal;


public class DefaultNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        double rand = Math.random();
        return new BigDecimal(rand).multiply(new BigDecimal(1000)).intValue();
    }
}
