package com.testing.framework.models;

public class UserResponseTest {
    public static void main(String[] args) {
        UserResponse userResponse = new UserResponse();
        UserResponse.Data data = new UserResponse.Data();
        data.setId(1);
        data.setEmail("test@example.com");
        data.setFirst_name("John");
        data.setLast_name("Doe");
        data.setAvatar("https://example.com/avatar.jpg");
        userResponse.setData(data);

        System.out.println("ID: " + userResponse.getData().getId());
        System.out.println("Email: " + userResponse.getData().getEmail());
        System.out.println("First Name: " + userResponse.getData().getFirst_name());
        System.out.println("Last Name: " + userResponse.getData().getLast_name());
        System.out.println("Avatar: " + userResponse.getData().getAvatar());
    }
}

