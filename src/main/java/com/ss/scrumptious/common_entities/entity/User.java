package com.ss.scrumptious.common_entities.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.Builder.Default;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Entity
@Table(name ="USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)", updatable = false)
    private UUID id;

    @NotBlank
    @Email
    private String email;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @NotBlank
    private String password;

    @Default
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.DEFAULT;

    @Column(name="created_at", updatable = false)
    @CreationTimestamp
    private ZonedDateTime creationDateTime;

    @UpdateTimestamp
	@Column(name="updated_at")
    private ZonedDateTime lastModifiedDateTime;

    @Column(columnDefinition = "TINYINT")
	@Default
	private boolean accountNonExpired = true;

    @Column(columnDefinition = "TINYINT")
	@Default
	private boolean accountNonLocked = true;

    @Column(columnDefinition = "TINYINT")
	@Default
    private boolean credentialsNonExpired = true;

    @Column(columnDefinition = "TINYINT")
    @Default
    private boolean enabled = true;

    @Column(columnDefinition = "TINYINT")
    @Default
    private boolean confirmed = false;

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<GrantedAuthority> set = new HashSet<>();
        if (userRole != null) {
            GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRole());
            set.add(authority);
        }
        return set;
    }
}
