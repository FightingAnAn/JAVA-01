package io.github.ningtianjing.homework03.filter;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * description：
 * author：ningtianjing
 * date: 22:29 2021/1/29
 */
public class MyHttpRequestFilter implements HttpRequestFilter {


    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("ntj_request_header", "ntjRequestHeaderFilter");
    }
}
