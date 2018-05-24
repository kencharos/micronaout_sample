package service;

import javax.inject.Singleton;

@Singleton
public class HogeServiceImpl implements HogeService{


    @Override
    public String greeting(String name) {
        return "Hello," + name;
    }
}
