package lepetitcoin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lepetitcoin.model.Messages;

public interface MessageRepository extends JpaRepository<Messages, Integer> {

}
