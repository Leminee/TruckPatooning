package de.truck.platooning.regservice.communication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TruckNotificator {

    private String messageId;
    private String message;
    private Date messageDate;

    public void setMessageId(String toString) {
    }

    public void setMessageDate(Date date) {
    }

    public String getMessageId() {
        return messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageDate() {
        return messageDate;
    }
}

