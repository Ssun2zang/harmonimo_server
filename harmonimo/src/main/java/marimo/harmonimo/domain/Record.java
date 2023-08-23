package marimo.harmonimo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import marimo.harmonimo.dto.Record.RecordDTO;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recordId")
    private Long recordId;

    @ManyToOne
    @JoinColumn(name="senderId")
    private User sender;

    @ManyToOne
    @JoinColumn(name="receiverId")
    private User receiver;

    @Column(name = "url")
    private String url;

    public RecordDTO toRecordDTO() {
        RecordDTO recordDTO = new RecordDTO();
        recordDTO.setRecordId(this.recordId);
        recordDTO.setSenderId(this.sender != null ? this.sender.getUserId() : null);
        recordDTO.setReceiverId(this.receiver != null ? this.receiver.getUserId(): null);
        recordDTO.setUrl(this.url);
        return recordDTO;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
