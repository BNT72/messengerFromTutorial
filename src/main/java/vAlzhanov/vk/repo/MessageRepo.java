package vAlzhanov.vk.repo;

import vAlzhanov.vk.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
