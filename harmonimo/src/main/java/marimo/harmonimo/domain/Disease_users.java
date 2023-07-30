package marimo.harmonimo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "disease_users")
public class Disease_users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long relationId;

    @ManyToMany
    @JoinColumn(name="userId")
    private User user;

    @ManyToMany
    @JoinColumn(name = "diseaseId")
    private Disease disease;



    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
