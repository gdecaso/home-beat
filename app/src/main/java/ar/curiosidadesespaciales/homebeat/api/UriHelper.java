package ar.curiosidadesespaciales.homebeat.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@Component
public class UriHelper {

    private final HttpServletRequest request;

    @Autowired
    public UriHelper(HttpServletRequest request) {
        this.request = request;
    }

    public String withPageSize(int page, int size) {
        return ServletUriComponentsBuilder.fromRequest(request)
                .replaceQueryParam("page", page)
                .replaceQueryParam("size", size)
                .build()
                .toUriString();
    }
}
