package com.haufe.forum.repository;

import com.haufe.forum.model.Forum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by StolojescuI
 */
@Repository
public interface ForumRepository extends MongoRepository<Forum, String> {

    Forum findForumById(String forumId);

}
