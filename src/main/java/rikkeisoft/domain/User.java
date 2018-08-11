package rikkeisoft.domain;


import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(immutable = true)
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	@Id
	private Integer id;

	@Column(name = "user_name")
	private String userName;
	
}

