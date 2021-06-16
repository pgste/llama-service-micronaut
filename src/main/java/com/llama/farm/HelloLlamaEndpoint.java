package com.llama.farm;

import javax.inject.Singleton;
import io.grpc.stub.StreamObserver;

@Singleton
public class HelloLlamaEndpoint extends LlamaGreeterGrpc.LlamaGreeterImplBase { // <1>

    private final LlamaService llamaService;

    public HelloLlamaEndpoint(LlamaService greetingService) {
        this.llamaService = greetingService;
    }

    @Override
    public void send(LlamaServiceRequest request, StreamObserver<LlamaServiceReply> responseObserver) {
        // <3>
        final String message = llamaService.sayHelloToLlama(request.getName());
        LlamaServiceReply reply = LlamaServiceReply.newBuilder().setMessage(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
