package io.github.ningtianjing.homework03.filter;

import io.github.kimmking.gateway.filter.HttpResponseFilter;
import io.netty.handler.codec.http.FullHttpResponse;

/**
 * description：
 * author：ningtianjing
 * date: 22:32 2021/1/29
 */
public class MyHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("ntj_response_header", "ntjResponseHeaderFilter");
    }
}
