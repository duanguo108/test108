package com.yinhai.file;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\aaaa.txt");
        File file2 = new File("C:\\Users\\Administrator\\Desktop\\bbbb.txt");
        File[] files = file.listFiles();
        String name = file.getName();
        String parent = file.getParent();

        /**inputStream只能读取一次测试*/
//        String str = "abcdefg";
//        byte[] b= new byte[2];
//        int len=-1;
//        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
//        InputStream inputStream2 = inputStream;
//        OutputStream outputStream = new FileOutputStream(file);
//        while ((len=inputStream.read(b))!=-1){
//            outputStream.write(b,1,len-1);
//            System.out.println(new String(b));
//        }
//        while ((len=inputStream2.read(b))!=-1){
//            outputStream.write(b,1,len-1);
//            System.out.println(new String(b));
//        }

        /**InputStream只能读取一次的解决办法*/
//        InputStream input = new ByteArrayInputStream(str.getBytes());
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        byte[] buffer = new byte[1024];
//        while ((len = input.read(buffer)) > -1 ) {
//            baos.write(buffer, 0, len);
//        }
//        baos.flush();
//        InputStream stream1 = new ByteArrayInputStream(baos.toByteArray());
//        InputStream stream2 = new ByteArrayInputStream(baos.toByteArray());
//        while ((len=stream1.read(b))!=-1){
//            outputStream.write(b,1,len-1);
//            System.out.println(new String(b));
//        }
//        while ((len=stream2.read(b))!=-1){
//            outputStream.write(b,1,len-1);
//            System.out.println(new String(b));
//        }


        /**MultipartFile使用transferTo复制文件*/
//        FileInputStream input = new FileInputStream(file);
//        MultipartFile mf =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
//        mf.transferTo(file2);


        /**Multipartfile与File类型相互转换*/
////        1、M转F
//        File file = new File(path);
//        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
////        2、F转M
//        File file = new File("src/test/resources/input.txt");
//        FileInputStream input = new FileInputStream(file);
//        MultipartFile multipartFile =new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));


    }
}
