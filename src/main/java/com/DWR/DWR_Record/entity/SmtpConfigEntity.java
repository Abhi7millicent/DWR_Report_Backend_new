package com.DWR.DWR_Record.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "smtp_config_sc")
public class SmtpConfigEntity {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	 @Column(name = "id_sc")
	    private Long id;
	 	 @Column(name = "host_sc")
	    private String host;
	 	 @Column(name = "port_sc")
	    private int port;
	 	 @Column(name = "username_sc")
	    private String username;
	 	 @Column(name = "password_sc")
	    private String password;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public int getPort() {
			return port;
		}
		public void setPort(int port) {
			this.port = port;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public SmtpConfigEntity(Long id, String host, int port, String username, String password) {
			super();
			this.id = id;
			this.host = host;
			this.port = port;
			this.username = username;
			this.password = password;
		}
	 	 
		public SmtpConfigEntity() {
			
		}
		@Override
		public String toString() {
			return "SmtpConfigEntity [id=" + id + ", host=" + host + ", port=" + port + ", username=" + username
					+ ", password=" + password + "]";
		}
		
		
}
