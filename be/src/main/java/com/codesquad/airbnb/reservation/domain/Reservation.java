package com.codesquad.airbnb.reservation.domain;

import com.codesquad.airbnb.accommodation.domain.Accommodation;
import com.codesquad.airbnb.accommodation.domain.DetailAddress;
import com.codesquad.airbnb.common.BaseTime;
import com.codesquad.airbnb.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Reservation extends BaseTime {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = LAZY)
    private Accommodation accommodation;

    private int fee;

    private int countOfClient;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean cancelled;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = LAZY)
    private User user;

    public String getMainImageLink() {
        return accommodation.getMainImageLink();
    }

    public DetailAddress getDetailAddress() {
        return accommodation.getDetailAddress();
    }

    public String getName() {
        return accommodation.getName();
    }
}
