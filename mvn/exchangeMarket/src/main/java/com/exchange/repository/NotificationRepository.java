package com.exchange.repository;

import com.exchange.entity.Notification;
import com.exchange.entity.NotificationTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByUserId(Long id);

    List<Notification> findAllByType(NotificationTypeEnum type);



}
