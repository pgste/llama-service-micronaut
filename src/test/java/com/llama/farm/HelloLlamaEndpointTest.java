package com.llama.farm;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class HelloLlamaEndpointTest {

    @Inject
    LlamaGreeterGrpc.LlamaGreeterBlockingStub blockingStub;

    @Test
    void testHelloWorld() {
        final LlamaServiceRequest request = LlamaServiceRequest.newBuilder()
                .setName("Sparkle")
                .build();
        assertEquals(
                "New Llama called Sparkle",
                blockingStub.send(request)
                        .getMessage()
        );
    }

}
