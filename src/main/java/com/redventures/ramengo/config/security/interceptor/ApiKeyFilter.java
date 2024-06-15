package com.redventures.ramengo.config.security.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redventures.ramengo.config.errorhandler.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ApiKeyFilter extends OncePerRequestFilter {

    private static String API_KEY_HEADER;
    private static String API_KEY_VALUE;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ApiKeyFilter(String apiKeyValue, String apiKeyHeader) {
        API_KEY_VALUE = apiKeyValue;
        API_KEY_HEADER = apiKeyHeader;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiKey = request.getHeader(API_KEY_HEADER);
        printAllHeaders(request);
        if (apiKey == null || apiKey.isEmpty()) {
            ApiError error = new ApiError("x-api-key header missing");
            writeJsonResponse(response, error, HttpStatus.FORBIDDEN);
            return;
        }

        if (!apiKey.equalsIgnoreCase(API_KEY_VALUE)) {
            ApiError error = new ApiError("Invalid API key");
            writeJsonResponse(response, error, HttpStatus.UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private void writeJsonResponse(HttpServletResponse response, ApiError error, HttpStatus status) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(error));
    }

    private void printAllHeaders(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            System.out.println("Headers:");
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                Enumeration<String> headers = request.getHeaders(headerName);
                if (headers != null) {
                    while (headers.hasMoreElements()) {
                        String headerValue = headers.nextElement();
                        System.out.println(headerName + ": " + headerValue);
                    }
                }
            }
        }
    }
}
