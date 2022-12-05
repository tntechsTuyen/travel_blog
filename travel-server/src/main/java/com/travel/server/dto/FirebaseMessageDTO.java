package com.travel.server.dto;

import lombok.Data;


@Data
public class FirebaseMessageDTO {

    private String to = "eKDlkgrJUT0:APA91bF4sBOuH1WOzNwUcLNrrT2OUMSuHlt7oiLQw25-QdfCa6hfGkCNYTKqLo4sUGC_RC1VCsB543uYAdH9zmMcZiJidKVXzEmUs120CdGNZvNqyqjWSRgzl2CboUCp8DI5BZmqs6jP";
    private Notification notification = new Notification();
    private DataKV data = new DataKV();

    @Data
    public class Notification {
        private String title = "Login auth";
        private String text = "Login auth in system";

    }

    @Data
    public class DataKV{
        private String accessToken;

    }
}
