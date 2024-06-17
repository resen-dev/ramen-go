package com.redventures.ramengo.config.security.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redventures.ramengo.config.errorhandler.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class ApiKeyFilter extends OncePerRequestFilter {

    private final String API_KEY_HEADER;
    private final String API_KEY_VALUE;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ApiKeyFilter(String apiKeyValue, String apiKeyHeader) {
        API_KEY_VALUE = apiKeyValue;
        API_KEY_HEADER = apiKeyHeader;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        synchronized (this) {

            String apiKey = request.getHeader(API_KEY_HEADER);

            log.info("request: {} headers:", request.getRequestURL());
            request.getHeaderNames()
                    .asIterator().forEachRemaining(log::info);

            if (apiKey == null || apiKey.isBlank()) {
                log.error("x-api-key header missing");
                writeJsonResponse(response, new ApiError("x-api-key header missing"), HttpStatus.FORBIDDEN);
                return;
            }

            if (!apiKey.equalsIgnoreCase(API_KEY_VALUE)) {
                log.error("Invalid API key");
                writeJsonResponse(response, new ApiError("Invalid API key"), HttpStatus.UNAUTHORIZED);
                return;
            }

            filterChain.doFilter(request, response);
        }
    }

    private void writeJsonResponse(HttpServletResponse response, ApiError error, HttpStatus status) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(error));
    }
}
