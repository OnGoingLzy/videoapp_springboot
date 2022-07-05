package com.proj3.videoapp.service;

import com.proj3.videoapp.entity.favorFolder;
import com.proj3.videoapp.entity.video;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public interface shoucangService {
    public List<favorFolder> getFolder(String cid);
    public List<video> getFolderVideo(String folderid);
    public Boolean addFolder(favorFolder addFolder);
    public Boolean deleteBeShoucang(String videoid,String folderid);
}
