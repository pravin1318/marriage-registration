package com.Spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class imageentity {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    private String imageName;

	    @Lob
	    @Column(length = 65555)
	    private byte[] imageData;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getImageName() {
			return imageName;
		}

		public void setImageName(String imageName) {
			this.imageName = imageName;
		}

		public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}

		public imageentity(Long id, String imageName, byte[] imageData) {
			super();
			this.id = id;
			this.imageName = imageName;
			this.imageData = imageData;
		}

		public imageentity() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		

	   
}
