package in.snm.personal_service.visitlog;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class VisitLog {
    @Id
    @GeneratedValue
    private Long id;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime visitDate;
    private String ip;
    private String country;
    private String network;
    private String otherDetails;
}
