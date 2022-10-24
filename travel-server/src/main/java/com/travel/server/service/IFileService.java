package com.travel.server.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.*;

public interface IFileService {
    String updloadFile(MultipartFile files);
}
