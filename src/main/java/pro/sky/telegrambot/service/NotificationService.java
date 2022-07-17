package pro.sky.telegrambot.service;

import pro.sky.telegrambot.model.NotificationTask;

import java.util.Optional;
import java.util.function.Consumer;

public interface NotificationService {
    NotificationTask schedule(Long chatId, NotificationTask task);

    Optional<NotificationTask> parse(String notificationBotMessage);

    void notifyAllScheduledTasks(Consumer<NotificationTask> notifier);
}
