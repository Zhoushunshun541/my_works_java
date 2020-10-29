package com.idiotic.domain.signUp;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sign_up")
@Data
@NoArgsConstructor
public class Happiness {
    @Id
    private long id;
    private String mobile;
    private String username;
    private String room_num;
    private Date sign_time;
}
