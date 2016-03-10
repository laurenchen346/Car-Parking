



	// Location class as it would need street name and city name with zipcode.
	
	public class Location {
		private String street;
		private String city;
		private int	zipCode;
		
		public Location() { ; }
		
		public Location (String street, String city, int zipCode) {
			this.setStreet(street);
			this.setCity(city);
			this.setZipCode(zipCode);
		}

		public String getStreet() {
			return street;
		}

		public String getCity() {
			return city;
		}
		
		public int getZipCode() {
			return zipCode;
		}
		
		public boolean setStreet(String street) {
			if (street == null) {
				return false;
			}
			this.street = street;
			return true;
		}

		public boolean setCity(String city) {
			if (city == null) {
				return false;
			}
			this.city = city;
			return true;
		}

		public boolean setZipCode(int zipCode) {
			if (zipCode > 99999 || zipCode <= 0) {
				return false;
			}
			this.zipCode = zipCode;
			return true;
		}
	}


