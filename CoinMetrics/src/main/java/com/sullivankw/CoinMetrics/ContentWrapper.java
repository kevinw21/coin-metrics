package com.sullivankw.CoinMetrics;

public class ContentWrapper<T> {

    private final T content;

    public ContentWrapper(T content) {
        this.content = content;
    }

    public static <T> ContentWrapper<T> wrap(T content) {
        return new ContentWrapper<>(content);
    }

    public T getContent() {
        return content;
    }
}
