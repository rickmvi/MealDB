package com.github.rickmvi.com.mealdb.app.infra;

import com.github.rickmvi.com.mealdb.app.util.Verify;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public record HttpClientProvider(@lombok.Getter(value = lombok.AccessLevel.PUBLIC) HttpClient client) {

    @Contract(pure = true)
    public HttpClientProvider {
        Verify.notNull(client, "Client cannot be null");
    }

    @Contract(" -> new")
    public static @NotNull HttpClientProvider create() {
        return new HttpClientProvider(HttpClient.newHttpClient());
    }

    public HttpRequest requiredRequest(String request) {
        return HttpRequest.newBuilder(URI.create(request)).build();
    }

    public @Nullable String getBody(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public @Nullable HttpResponse<String> send(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
