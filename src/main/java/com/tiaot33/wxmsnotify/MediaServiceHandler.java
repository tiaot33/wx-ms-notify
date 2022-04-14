package com.tiaot33.wxmsnotify;

import com.github.shuaidd.service.MediaService;
import com.github.shuaidd.support.WeChatManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
@Slf4j
public class MediaServiceHandler {
    @Resource
    private WeChatManager weChatManager;
    public static final String ADDRESS_BOOK = "push-bot";

    /**
     * 获取的结果 --- https://wework.qpic.cn/wwpic/495538_5AazgN0JRoCFypk_1626843955/0
     *
     * @throws FileNotFoundException 404
     */
    
    public void upload() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:image/20659972.png");
        String url = weChatManager.mediaService().uploadImage(file, MediaType.IMAGE_PNG, ADDRESS_BOOK);
        log.info("上传的图片地址--{}", url);
    }

    /**
     * 媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件（file）
     *
     * @throws FileNotFoundException 404
     */
    
    public void uploadMaterial() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:video/1626849301272424.mp4");
        String mediaId = weChatManager.mediaService().uploadMaterial(file, MediaType.APPLICATION_OCTET_STREAM, MediaService.VIDEO, ADDRESS_BOOK);
        log.info("上传的临时素材 media id--{}", mediaId);
    }

    
    public void download() throws IOException {
        ResponseEntity<byte[]> responseEntity = weChatManager.mediaService().download("39sypZn0YTWqSK9DFU4aqbQgHnm6y645mWIX4yjjKGgQ", ADDRESS_BOOK);
        IOUtils.write(responseEntity.getBody(), new FileOutputStream(new File("qywx-applyevent.json")));
    }
}
