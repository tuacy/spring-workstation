package com.tuacy.fastdfs.component;

import cn.hutool.core.util.StrUtil;
import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * FastDFS客户端操作封装
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/20 20:15.
 */
@Component
@Slf4j
public class FastDFSClient {

    private FastFileStorageClient storageClient;
    private FdfsWebServer fdfsWebServer;

    @Autowired
    public void setStorageClient(FastFileStorageClient storageClient) {
        this.storageClient = storageClient;
    }

    @Autowired
    public void setFdfsWebServer(FdfsWebServer fdfsWebServer) {
        this.fdfsWebServer = fdfsWebServer;
    }

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException 异常信息
     */
    public String uploadFile(MultipartFile file) throws IOException {
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        return getResAccessUrl(storePath);
    }

    /**
     * 上传文件
     *
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException 异常信息
     */
    public String uploadFile(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        StorePath storePath = storageClient.uploadFile(inputStream, file.length(), FilenameUtils.getExtension(file.getName()), null);
        return getResAccessUrl(storePath);
    }

    /**
     * 将一段字符串生成一个文件上传
     *
     * @param content       文件内容
     * @param fileExtension 文件扩展名
     * @return 文件访问地址
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream, buff.length, fileExtension, null);
        return getResAccessUrl(storePath);
    }

    /**
     * 下载文件
     *
     * @param fileUrl 文件url
     * @return 文件内容
     */
    public byte[] download(String fileUrl) {
        String group = fileUrl.substring(0, fileUrl.indexOf("/"));
        String path = fileUrl.substring(fileUrl.indexOf("/") + 1);
        return storageClient.downloadFile(group, path, new DownloadByteArray());
    }

    /**
     * 删除文件
     *
     * @param fileUrl 文件访问地址
     */
    public void deleteFile(String fileUrl) {
        if (StrUtil.isEmpty(fileUrl)) {
            return;
        }
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
            log.warn(e.getMessage());
        }
    }

    /**
     * 封装图片完整URL地址
     *
     * @param storePath 获取对应的url
     * @return 文件对应的url
     */
    private String getResAccessUrl(StorePath storePath) {
        return fdfsWebServer.getWebServerUrl() + storePath.getFullPath();
    }

}
