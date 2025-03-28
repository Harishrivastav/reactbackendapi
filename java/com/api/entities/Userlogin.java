package com.api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "details")
public class Userlogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mobile;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Lob
    private byte[] photo;

    @Lob
    private byte[] resume;

    public Userlogin() {}

    public Userlogin(String name, String mobile, String email, String address, byte[] photo, byte[] resume) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.photo = photo;
        this.resume = resume;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getMobile() { return mobile; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public byte[] getPhoto() { return photo; }
    public byte[] getResume() { return resume; }
}
