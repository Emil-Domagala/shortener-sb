package emil.shortener.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import emil.shortener.domains.models.UrlMapping;
import emil.shortener.services.UrlMappingService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RedirectController {

    private final UrlMappingService urlMappingService;

    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> redirect(@PathVariable String shortUrl) {
        UrlMapping urlMapping = urlMappingService.getOriginalUrl(shortUrl);
        if (urlMapping == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(302).header("Location",
                urlMapping.getOriginalUrl())
                .build();
    }

}
