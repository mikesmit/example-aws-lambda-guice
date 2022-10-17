package com.coderberry.examples.guicelambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaHandler implements RequestHandler<LambdaHandler.Request, LambdaHandler.Response> {

    public static class Request{
        private String requestId;
        private String message;

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Request{" +
                    "requestId='" + requestId + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
    public static class Response{
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    private ClientWhatever client;

    public LambdaHandler(final ClientWhatever client) {
        this.client = client;
    }

    @Override
    public Response handleRequest(Request request, Context context) {
        context.getLogger().log("Got request: " + request);
        client.call();
        Response response = new Response();
        response.setMessage("Success!");
        return response;
    }
}
