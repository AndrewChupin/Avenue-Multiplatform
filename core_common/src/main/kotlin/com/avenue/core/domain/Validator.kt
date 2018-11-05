package com.avenue.core.domain


interface Validator<Request, Response> {
    fun validate(request: Request): Response
}
