package com.sulimann.mercadolivre.infra.utils.http;

import org.springframework.http.HttpMethod;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Get extends HttpPadrao {

    @Override
    protected HttpMethod method() {
        return HttpMethod.GET;
    }

}
