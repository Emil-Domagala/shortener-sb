package emil.shortener.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emil.shortener.domains.models.UrlMapping;
import emil.shortener.domains.models.User;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {

    UrlMapping findByShortUrl(String shortUrl);

    List<UrlMapping> findByUser(User user);
}
