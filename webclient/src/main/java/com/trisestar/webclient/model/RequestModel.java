package com.trisestar.webclient.model;

public class RequestModel {
    private Object body;
    private String uri;
    private String method;
    private boolean internal;
    public RequestModel() {
    }

    public Object getBody() {
        return body;
    }

    public RequestModel withBody(Object body) {
        this.body = body;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public RequestModel withUri(String uri) {
        this.uri = uri;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public RequestModel withMethod(String method) {
        this.method = method;
        return this;
    }

    public boolean isInternal() {
        return internal;
    }

    public RequestModel internal(boolean internal) {
        internal = internal;
        return this;
    }
}
