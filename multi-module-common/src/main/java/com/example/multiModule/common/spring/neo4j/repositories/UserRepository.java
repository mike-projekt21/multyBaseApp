package com.example.multiModule.common.spring.neo4j.repositories;

import com.example.multiModule.common.spring.neo4j.entities.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface UserRepository extends Neo4jRepository<User, Long> {

    //to recommend friends (friends of user's friends)
    @Query("MATCH (u:User)-[:FRIEND_WITH]-(:User)-[:FRIEND_WITH]-(fu:User) WHERE u.login=userLogin AND NOT exists((u)-[:FRIEND_WITH]-(fu)) RETURN fu")
    List<User> findFriendOfFriend(Long userLogin);

}
