package com.example.multiModule.common.spring.postgres.entities;

import com.example.multiModule.common.spring.cassandra.entities.Message;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "chats")
public class Chat {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "login_u1")
	private String loginUser1;

	@Column(name = "login_u2")
	private String loginUser2;

	private List<Message> messages;
}
