package com.exchange.repository;

import com.exchange.entity.Notification;
import com.exchange.entity.NotificationTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {


}
