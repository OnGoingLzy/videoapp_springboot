package com.proj3.videoapp.service;

import org.springframework.stereotype.Service;

@Service
public interface VideoFrameService {
    public Boolean checkBeLike(String cid , String videoid);
    public Boolean addBeLike(String cid,String videoid);
    public Boolean deleteBeLike(String cid,String videoid);
    public Boolean shoucangVideo(String videoid,String folderid);
    public Boolean checkBeCollected(String videoid,String cid);
}
