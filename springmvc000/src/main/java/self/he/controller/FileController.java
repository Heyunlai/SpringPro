package self.he.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {
    private static String uploadPath = "E:"+ File.separator;

    @RequestMapping("/upload")
   public String upload(@RequestParam("file")MultipartFile multipartFile, Model model){
        //1.传到哪里去。2.数据 3.传的细节
       if (multipartFile != null && !multipartFile.isEmpty()){
           //不空再传
           //1.获得文件名
           String originalFilename = multipartFile.getOriginalFilename();
           //2.截取文件名前缀
           String fileNamePrefix = originalFilename.substring(0,originalFilename.lastIndexOf('.'));
           //3.构建新文件名 前缀+时间戳
           String newFilePrefix = fileNamePrefix+new Date().getTime();
           //4.得到新文件名
           String newFileName =newFilePrefix+originalFilename.substring(originalFilename.lastIndexOf('.'));
           //5.构建文件对象
           File file = new File(uploadPath+newFileName);

           //6.写入文件
           try {
               multipartFile.transferTo(file);
               model.addAttribute("fileName",newFileName);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       return "uploadSuc";
   }
   
   @RequestMapping("/upload2")
    public String upload2(@RequestParam("file") MultipartFile[] multipartFiles,Model model){
       List<String> fileNames = new ArrayList<>();
       System.out.println(multipartFiles != null && multipartFiles.length >0);
       if (multipartFiles != null && multipartFiles.length >0){
           for (MultipartFile multipartFile:multipartFiles) {
               if (multipartFile != null && !multipartFile.isEmpty()){
                   //不空再传
                   //1.获得文件名
                   String originalFilename = multipartFile.getOriginalFilename();
                   //2.截取文件名前缀
                   String fileNamePrefix = originalFilename.substring(0,originalFilename.lastIndexOf('.'));
                   //3.构建新文件名 前缀+时间戳
                   String newFilePrefix = fileNamePrefix+new Date().getTime();
                   //4.得到新文件名
                   String newFileName =newFilePrefix+originalFilename.substring(originalFilename.lastIndexOf('.'));
                   //5.构建文件对象
                   File file = new File(uploadPath+newFileName);

                   //6.写入文件
                   try {
                       multipartFile.transferTo(file);

                       fileNames.add(newFileName);
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
       }
       model.addAttribute("fileNames",fileNames);
       return "uploadSuc";
   }

   @RequestMapping("/down")
    public void fileDown(HttpServletResponse response){
        //通过输出流写入客户端
//       response.setCharacterEncoding("UTF-8");
       //1.获取下载文件名
       String fileName = "哈哈.jpg";
       //2.构建一个文件对象，通过Paths工具类获得Path对象
       Path path = Paths.get(uploadPath,fileName);

       //3.判断它是否存在
       if(Files.exists(path)){
           //存在则下载
           //4.设定response的响应类型
                //获取文件后缀
           String fileSuffix = fileName.substring(fileName.lastIndexOf('.')+1);
                //设置contentType
           response.setContentType("application/"+fileSuffix);
           try {
               //ISO8859-1编码
               response.addHeader("Content-Disposition","attachment;filename=" + new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
           } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
           }
           //5 通过Path写出去
           try {
               Files.copy(path,response.getOutputStream());
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

   }


}
