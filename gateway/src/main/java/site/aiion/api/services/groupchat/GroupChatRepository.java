package site.aiion.api.services.groupchat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GroupChatRepository extends JpaRepository<GroupChat, Long> {

    Page<GroupChat> findAllByOrderByCreatedAtDesc(Pageable pageable);

    List<GroupChat> findByIdGreaterThanOrderByCreatedAtAsc(Long id);

    List<GroupChat> findTop50ByOrderByCreatedAtDesc();

    /** 방별 최신 메시지 N개 */
    List<GroupChat> findTop50ByRoomTypeOrderByCreatedAtDesc(ChatRoomType roomType);

    /** 방별 lastId 초과 메시지 (SSE 푸시용) */
    List<GroupChat> findByIdGreaterThanAndRoomTypeOrderByCreatedAtAsc(Long id, ChatRoomType roomType);
}

