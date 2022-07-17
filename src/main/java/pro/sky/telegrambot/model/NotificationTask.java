package pro.sky.telegrambot.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class NotificationTask {

    public enum NotificationStatus{
        SCHEDULED,
        SENT,
    }

    @Id
    @GeneratedValue
    private Long id;

    private Long chatId;

    private String notificationMessage;

    private LocalDateTime notificationDate;

    private LocalDateTime sendDate;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status = NotificationStatus.SCHEDULED;

    public NotificationTask() {
    }

    public NotificationTask(String notificationMessage, LocalDateTime notificationDate) {
        this.notificationMessage = notificationMessage;
        this.notificationDate = notificationDate;
    }

    public void markStatus(){
        this.status = NotificationStatus.SENT;
        this.sendDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TelegramModel{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", messageText='" + notificationMessage + '\'' +
                ", messageDate=" + notificationDate +
                ", sendData=" + sendDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationTask that = (NotificationTask) o;
        return Objects.equals(id, that.id) && Objects.equals(chatId, that.chatId) && Objects.equals(notificationMessage, that.notificationMessage) && Objects.equals(notificationDate, that.notificationDate) && Objects.equals(sendDate, that.sendDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, notificationMessage, notificationDate, sendDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationText) {
        this.notificationMessage = notificationText;
    }

    public LocalDateTime getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(LocalDateTime notificationDate) {
        this.notificationDate = notificationDate;
    }

    public LocalDateTime getSendData() {
        return sendDate;
    }

    public void setSendData(LocalDateTime sendData) {
        this.sendDate = sendDate;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }
}
