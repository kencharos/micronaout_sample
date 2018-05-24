package service;

import javax.inject.Singleton;
import java.util.Date;

@Singleton
public class HogeServiceImpl implements HogeService {

    //@Override
    public String now() {
        return new Date().toString();
    }
}
