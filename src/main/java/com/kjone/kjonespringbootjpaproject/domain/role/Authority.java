package com.kjone.kjonespringbootjpaproject.domain.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kjone.kjonespringbootjpaproject.domain.user.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "authority")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Member member_id;

    public void setMember(Member member) {
        this.member_id = member;
    }
}