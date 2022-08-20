package com.trisestar.webclient.model;

public class RequestModel {
    public RequestModel() {
    }

    public RequestModel(Object body, String uri, String method) {
        this.body = body;
        this.uri = uri;
        this.method = method;
    }

    private Object body;
    private String uri;
    private String method;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "body=" + body +
                ", uri='" + uri + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
