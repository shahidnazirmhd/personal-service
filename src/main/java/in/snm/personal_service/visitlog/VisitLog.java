package in.snm.personal_service.visitlog;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import in.snm.personal_service.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class VisitLog extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String ip;
    private String country;
    private String network;
    private String otherDetails;
}
