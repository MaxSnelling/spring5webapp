package guru.springframework.spring5webapp.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String line1;
    private String city;
    private String county;
    private String postCode;

    public Address(String line1, String city, String county, String postCode) {
        this.line1 = line1;
        this.city = city;
        this.county = county;
        this.postCode = postCode;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "line1='" + line1 + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }
}
