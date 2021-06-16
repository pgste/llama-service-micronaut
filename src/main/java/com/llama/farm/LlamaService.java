package com.llama.farm;

import javax.inject.Singleton;

@Singleton
public class LlamaService {

    String sayHelloToLlama(String name) {
        return "New Llama called " + name;
    }
}
