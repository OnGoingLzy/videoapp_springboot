package com.proj3.videoapp.service;

import com.proj3.videoapp.entity.video;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface adminService {
    public List<video> getAuditVideo();
}
