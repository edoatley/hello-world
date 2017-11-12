package edoatley.scenarios;

import edoatley.ds.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return 42;
    }
}
