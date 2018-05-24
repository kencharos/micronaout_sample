package service;


import example.Sample;
import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.Client;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface AwsFunction {
    // メソッド名と、properties の functions.<name> が対応する。
    public Single<Sample> example();

}
