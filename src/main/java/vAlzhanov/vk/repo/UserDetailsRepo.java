package vAlzhanov.vk.repo;

import vAlzhanov.vk.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
