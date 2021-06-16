package com.llama.farm;

import io.grpc.ManagedChannel;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import io.micronaut.grpc.server.GrpcServerChannel;

@Factory
class TestClients {
    @Bean
    LlamaGreeterGrpc.LlamaGreeterBlockingStub llamaServiceBlockingStub(
            @GrpcChannel(GrpcServerChannel.NAME) ManagedChannel channel) {
        return LlamaGreeterGrpc.newBlockingStub(
                channel
        );
    }
}
