package com.coderberry.examples.guicelambda;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class Module extends AbstractModule {
    @Provides
    public LambdaHandler handler() {
        return new LambdaHandler(new ClientWhatever());
    }
}
